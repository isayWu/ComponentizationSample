package com.isay.calendarlib.view.calender;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import com.haibin.calendarview.Calendar;
import com.haibin.calendarview.CalendarView;
import com.isay.calendarlib.R;
import com.isay.calendarlib.data.HolidayUtil;
import com.isay.commonserverlib.bean.CalendarInfo;
import com.isay.commonserverlib.listener.CalendarChangeListener;
import com.isay.commonserverlib.listener.CalendarDateChangeListenerManager;

import java.util.HashMap;
import java.util.Map;

/**
 * Desc: 日历view
 * <p>
 * Author: WuCongYi
 * Date: 2020/5/8
 * Copyright: Copyright (c) 2016-2020
 * Company: @小牛科技
 * Update Comments:
 * 构建配置参见:
 *
 * @author wucongyi
 */
public class CalenderView extends FrameLayout implements CalendarView.OnMonthChangeListener,
        CalendarView.OnYearChangeListener, CalendarView.OnCalendarSelectListener {

    private CalendarView mCalendarView;
    private FrameLayout mOtherLayout;

    public CalenderView(Context context) {
        this(context, null);
    }

    public CalenderView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        View view = LayoutInflater.from(context).inflate(R.layout.view_calendar, this);
        mCalendarView = view.findViewById(R.id.calendar_view);
        mOtherLayout = view.findViewById(R.id.calendar_other_view);
        mCalendarView.setOnMonthChangeListener(this);
        mCalendarView.setOnYearChangeListener(this);
        mCalendarView.setOnCalendarSelectListener(this);
        initView();
    }

    /**
     * 设置其它view包含在日历view内部
     *
     * @param view
     * @return
     */
    public CalenderView setOtherView(View view) {
        mOtherLayout.addView(view);
        return this;
    }


    @Override
    public void onMonthChange(int year, int month) {
        for (CalendarChangeListener listener : CalendarDateChangeListenerManager.getInstance().getListChangeListener()) {
            listener.onMonthChange(year, month);
        }
        schemeCalendar(year, month);
    }

    @Override
    public void onYearChange(int year) {
        for (CalendarChangeListener listener : CalendarDateChangeListenerManager.getInstance().getListChangeListener()) {
            listener.onYearChange(year);
        }
        schemeCalendar(year, mCalendarView.getCurMonth());
    }


    @Override
    public void onCalendarOutOfRange(Calendar calendar) {
        for (CalendarChangeListener listener : CalendarDateChangeListenerManager.getInstance().getListChangeListener()) {
            listener.onCalendarOutOfRange(calendar.getYear(), calendar.getMonth(), calendar.getDay());
        }
    }

    @Override
    public void onCalendarSelect(Calendar calendar, boolean isClick) {
        CalendarInfo info = new CalendarInfo();
        info.setYear(calendar.getYear())
                .setMonth(calendar.getMonth())
                .setLunaMonth(calendar.getLunarCalendar().getMonth())
                .setDay(calendar.getDay())
                .setLunaDayStr(calendar.getLunarCalendar().getLunar())
                .setWeek(calendar.getWeek())
                .setHoliday(calendar.getGregorianFestival())
                .setLunaHoliday(calendar.getTraditionFestival())
                .setSolarItem(calendar.getSolarTerm());
        for (CalendarChangeListener listener : CalendarDateChangeListenerManager.getInstance().getListChangeListener()) {
            listener.onCalendarSelect(info);
        }
    }


    /**
     * 初始化view
     */
    private void initView() {
        schemeCalendar(mCalendarView.getCurYear(), mCalendarView.getCurMonth());
    }

    /**
     * 标记班休等
     */
    private void schemeCalendar(int year, int month) {
        int workBg = ContextCompat.getColor(getContext(), R.color.workBgColor);
        int resetBg = ContextCompat.getColor(getContext(), R.color.restBgColor);
        Map<String, Calendar> map = new HashMap<>();
        for (int i = 1; i < 31; i++) {
            //找出班
            if (HolidayUtil.isWork(year, month, i)) {
                Calendar calendar = getSchemeCalendar(year, month, i, workBg, "班");
                map.put(calendar.toString(), calendar);
            }
            //找出休
            if (HolidayUtil.isReset(year, month, i)) {
                Calendar calendar = getSchemeCalendar(year, month, i, resetBg, "休");
                map.put(calendar.toString(), calendar);
            }
            //找出前一个月的班
            if (i > 20) {
                int m = (month <= 1) ? 12 : month - 1;
                if (HolidayUtil.isWork(year, m, i)) {
                    Calendar calendar = getSchemeCalendar(year, m, i, workBg, "班");
                    map.put(calendar.toString(), calendar);
                }
                if (HolidayUtil.isReset(year, m, i)) {
                    Calendar calendar = getSchemeCalendar(year, m, i, resetBg, "休");
                    map.put(calendar.toString(), calendar);
                }
            }
            //找出后一个月的班
            if (i < 8) {
                int m = (month >= 12) ? 1 : month + 1;
                if (HolidayUtil.isWork(year, m, i)) {
                    Calendar calendar = getSchemeCalendar(year, m, i, workBg, "班");
                    map.put(calendar.toString(), calendar);
                }
                if (HolidayUtil.isReset(year, m, i)) {
                    Calendar calendar = getSchemeCalendar(year, m, i, resetBg, "休");
                    map.put(calendar.toString(), calendar);
                }
            }
        }
        //此方法在巨大的数据量上不影响遍历性能，推荐使用
        mCalendarView.setSchemeDate(map);
    }

    /**
     * 标记班休等颜色信息
     *
     * @param year
     * @param month
     * @param day
     * @param color
     * @param text
     * @return
     */
    private Calendar getSchemeCalendar(int year, int month, int day, int color, String text) {
        Calendar calendar = new Calendar();
        calendar.setYear(year);
        calendar.setMonth(month);
        calendar.setDay(day);
        calendar.setSchemeColor(color);
        calendar.setScheme(text);
        calendar.addScheme(new Calendar.Scheme());
        calendar.addScheme(ContextCompat.getColor(getContext(), R.color.workBgColor), "班");
        calendar.addScheme(ContextCompat.getColor(getContext(), R.color.restBgColor), "休");
        return calendar;
    }


}
