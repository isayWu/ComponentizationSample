package com.isay.componentizationtest.ui.view.huangli

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.TextView
import com.isay.commonserverlib.bean.CalendarInfo
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

    /**
     * 显示农历数据
     */
    fun setDate(info: CalendarInfo): LunaView {
        calendar_lunar_tv_luna!!.text = "${info.lunaMonth}月${info.lunaDayStr}${info.solarItem}"
        calendar_lunar_week!!.text = "星期${info.week}"
        calendar_lunar_holiday!!.text = "${info.holiday} ·${info.lunaHoliday}"
        return this
    }


}