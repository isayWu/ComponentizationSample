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
import com.isay.commonserverlib.listener.CalendarDateChangeListener;
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
public class CalenderView extends FrameLayout implements CalendarView.OnMonthChangeListener, CalendarView.OnYearChangeListener {

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
    }

    public CalenderView setOtherView(View view) {
        mOtherLayout.addView(view);
        return this;
    }

    public CalenderView setListener(CalendarDateChangeListener l) {
        CalendarDateChangeListenerManager.getInstance().setListChangeListener(l);
        return this;
    }

    @Override
    public void onMonthChange(int year, int month) {
        for (CalendarDateChangeListener listener : CalendarDateChangeListenerManager.getInstance().getListChangeListener()) {
            listener.onMonthChange(year, month);
        }


        Map<String, Calendar> map = new HashMap<>();
        map.put(getSchemeCalendar(year, month, 3, 0xFF40db25, "班").toString(),
                getSchemeCalendar(year, month, 3, 0xFF40db25, "班"));
        map.put(getSchemeCalendar(year, month, 6, 0xFFe69138, "休").toString(),
                getSchemeCalendar(year, month, 6, 0xFFe69138, "休"));
        //此方法在巨大的数据量上不影响遍历性能，推荐使用
        mCalendarView.setSchemeDate(map);
    }

    @Override
    public void onYearChange(int year) {
        for (CalendarDateChangeListener listener : CalendarDateChangeListenerManager.getInstance().getListChangeListener()) {
            listener.onYearChange(year);
        }
    }

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
