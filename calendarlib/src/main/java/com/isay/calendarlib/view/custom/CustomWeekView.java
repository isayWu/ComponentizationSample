package com.isay.calendarlib.view.custom;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.text.TextUtils;

import androidx.core.content.ContextCompat;

import com.haibin.calendarview.Calendar;
import com.haibin.calendarview.WeekView;
import com.isay.calendarlib.R;

/**
 * 演示一个变态需求的周视图
 * Created by huanghaibin on 2018/2/9.
 */

public class CustomWeekView extends WeekView {


    private int mRadius;

    /**
     * 自定义魅族标记的文本画笔
     */
    private Paint mTextPaint = new Paint();


    /**
     * 24节气画笔
     */
    private Paint mSolarTermTextPaint = new Paint();

    /**
     * 背景圆点
     */
    private Paint mPointPaint = new Paint();

    /**
     * 今天的背景色
     */
    private Paint mCurrentDayPaint = new Paint();


    /**
     * 圆点半径
     */
    private float mPointRadius;

    private int mPadding;

    private float mCircleRadius;
    /**
     * 自定义魅族标记的圆形背景
     */
    private Paint mSchemeBasicPaint = new Paint();

    private float mSchemeBaseLine;


    /**
     * 周末日期颜色
     */
    private int weekEndColor = 0xffE43030;
    /**
     * 24节气节日颜色
     */
    private int solarTermColor = 0xFFF79000;
    /**
     * 节日日颜色
     */
    private int festivalColor = 0xffD92B2B;
    /**
     * 农历节日日颜色
     */
    private int lunarFestivalColor = 0xffD92B2B;
    /**
     * 农历文字颜色
     */
    private int lunarColor = 0xff333333;
    /**
     * 阳历文字颜色
     */
    private int sonarColor = 0xff333333;

    public CustomWeekView(Context context) {
        super(context);
        weekEndColor = ContextCompat.getColor(context, R.color.colorAccent);
        solarTermColor = ContextCompat.getColor(context, R.color.solarTermColor);
        festivalColor = ContextCompat.getColor(context, R.color.festivalColor);
        lunarFestivalColor = ContextCompat.getColor(context, R.color.lunaFestivalColor);
        lunarColor = ContextCompat.getColor(context, R.color.lunarColor);
        sonarColor = ContextCompat.getColor(context, R.color.solarColor);

        mTextPaint.setTextSize(dipToPx(context, 12));
        mTextPaint.setColor(0xffffffff);
        mTextPaint.setAntiAlias(true);
        mTextPaint.setFakeBoldText(true);


        mSolarTermTextPaint.setColor(0xff489dff);
        mSolarTermTextPaint.setAntiAlias(true);
        mSolarTermTextPaint.setTextAlign(Paint.Align.CENTER);

        mSchemeBasicPaint.setAntiAlias(true);
        mSchemeBasicPaint.setStyle(Paint.Style.FILL);
        mSchemeBasicPaint.setTextAlign(Paint.Align.CENTER);
        mSchemeBasicPaint.setFakeBoldText(true);
        mSchemeBasicPaint.setColor(Color.WHITE);

        mPointPaint.setAntiAlias(true);
        mPointPaint.setStyle(Paint.Style.FILL);
        mPointPaint.setTextAlign(Paint.Align.CENTER);
        mPointPaint.setColor(Color.RED);


        mCurrentDayPaint.setAntiAlias(true);
        mCurrentDayPaint.setStyle(Paint.Style.FILL);
        mCurrentDayPaint.setColor(ContextCompat.getColor(context, R.color.todayBgColor));


        mCircleRadius = dipToPx(getContext(), 7);

        mPadding = dipToPx(getContext(), 3);

        mPointRadius = dipToPx(context, 8);

        Paint.FontMetrics metrics = mSchemeBasicPaint.getFontMetrics();
        mSchemeBaseLine = mCircleRadius - metrics.descent + (metrics.bottom - metrics.top) / 2 + dipToPx(getContext(), 1);

    }


    @Override
    protected void onPreviewHook() {
        mSolarTermTextPaint.setTextSize(mCurMonthLunarTextPaint.getTextSize());
        mRadius = Math.min(mItemWidth, mItemHeight) / 11 * 5;
    }


    @Override
    protected boolean onDrawSelected(Canvas canvas, Calendar calendar, int x, boolean hasScheme) {
        int cx = x + mItemWidth / 2;
        int cy = mItemHeight / 2;
        canvas.drawCircle(cx, cy, mRadius, mSelectedPaint);
        return true;
    }


    @Override
    protected void onDrawScheme(Canvas canvas, Calendar calendar, int x) {
        float tx = x + mItemWidth - mPadding - mCircleRadius;
        float ty = mSchemeBaseLine + mPadding;
        float tw = mTextPaint.measureText(calendar.getScheme()) / 2;
        //画文字背景,这里y-2估计的，需要优化位置
        int color = calendar.getSchemeColor();
        if (!calendar.isCurrentMonth()) {
            color = color - 0x99000000;
        }
        mPointPaint.setColor(color);
        canvas.drawCircle(tx + tw , ty - tw / 2 -2, mPointRadius, mPointPaint);
        canvas.drawText(calendar.getScheme(), tx, ty, mTextPaint);
    }

    @SuppressWarnings("IntegerDivisionInFloatingPointContext")
    @Override
    protected void onDrawText(Canvas canvas, Calendar calendar, int x, boolean hasScheme, boolean isSelected) {
        int cx = x + mItemWidth / 2;
        int cy = mItemHeight / 2;
        int top = -mItemHeight / 6;
        //画圆圈背景
        if (calendar.isCurrentDay() || isSelected) {
            canvas.drawCircle(cx, cy, mRadius, mCurrentDayPaint);
        }
        //画日期和农历日期文字
        int color = lunarColor;
        if (!TextUtils.isEmpty(calendar.getSolarTerm())) {
            //24节气颜色
            color = solarTermColor;
        } else if (!TextUtils.isEmpty(calendar.getTraditionFestival())) {
            //传统节日颜色
            color = lunarFestivalColor;
        } else if (!TextUtils.isEmpty(calendar.getGregorianFestival())) {
            //阳历节日颜色
            color = festivalColor;
        } else if (calendar.isWeekend()) {
            color = weekEndColor;
        }
        //是否半透明
        if (!calendar.isCurrentMonth()) {
            color = color - 0x99000000;
        }
        //显示
        mCurMonthTextPaint.setColor(color != lunarColor ? color : sonarColor);
        mCurMonthLunarTextPaint.setColor(color);
        canvas.drawText(String.valueOf(calendar.getDay()), cx, mTextBaseLine + top, mCurMonthTextPaint);
        canvas.drawText(calendar.getLunar(), cx, mTextBaseLine +  mItemHeight / 10, mCurMonthLunarTextPaint);
    }

    /**
     * dp转px
     *
     * @param context context
     * @param dpValue dp
     * @return px
     */
    private static int dipToPx(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }
}
