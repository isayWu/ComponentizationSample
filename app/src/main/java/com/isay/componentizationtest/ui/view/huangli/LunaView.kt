package com.isay.componentizationtest.ui.view.huangli

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.TextView
import com.isay.componentizationtest.R
import kotlinx.android.synthetic.main.view_huangli.view.*

/**
 * Desc: 黄历
 *
 *
 * Author: WuCongYi
 * Date: 2020/5/13
 * Copyright: Copyright (c) 2016-2020
 * Company: @小牛科技
 * Update Comments:
 * 构建配置参见:
 *
 * @author wucongyi
 */
class LunaView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : LinearLayout(context, attrs) {


    init {
        intiView(context)
    }

    private fun intiView(context: Context) {
        LayoutInflater.from(context).inflate(R.layout.view_huangli, this)
    }

    fun setDate(
        year: Int,
        month: Int,
        day: Int,
        lunaMonth: Int,
        lunaDay: Int,
        luna: String
    ): LunaView {
        calendar_lunar_tv_luna!!.text = "${lunaMonth}月$luna"
        return this
    }

    fun showLuna(s: String?): LunaView {
        calendar_lunar_tv_luna!!.text = s
        return this
    }

    fun showWeek(s: String?): LunaView {
        calendar_lunar_week!!.text = s
        return this
    }

    fun showHoliday(s: String?): LunaView {
        calendar_lunar_holiday!!.text = s
        return this
    }

}