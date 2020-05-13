package com.isay.componentizationtest.ui.view.huangli;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.isay.componentizationtest.R;


/**
 * Desc: 黄历
 * <p>
 * Author: WuCongYi
 * Date: 2020/5/13
 * Copyright: Copyright (c) 2016-2020
 * Company: @小牛科技
 * Update Comments:
 * 构建配置参见:
 *
 * @author wucongyi
 */
public class LunaView extends LinearLayout {

    private TextView mTvLuna;
    private TextView mTvWeek;
    private TextView mTvHoliday;

    public LunaView(Context context) {
        this(context, null);
    }

    public LunaView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        intiView(context);
    }

    private void intiView(Context context) {
        View view = LayoutInflater.from(context).inflate(R.layout.view_huangli, this);
        mTvLuna = view.findViewById(R.id.calendar_lunar_tv_luna);
        mTvWeek = view.findViewById(R.id.calendar_lunar_week);
        mTvHoliday = view.findViewById(R.id.calendar_lunar_holiday);
    }


    public LunaView showLuna(String s){
        mTvLuna.setText(s);
        return this;
    }

    public LunaView showWeek(String s){
        mTvWeek.setText(s);
        return this;
    }

    public LunaView showHoliday(String s){
        mTvHoliday.setText(s);
        return this;
    }
}
