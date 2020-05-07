package com.isay.calendarlib.plug

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import com.isay.calendarlib.R
import com.isay.commonserverlib.plug.IPlugRulesCalendar

/**
 * Desc:
 * <p>
 * Author: WuCongYi
 * Date: 2020/5/7
 * Copyright: Copyright (c) 2016-2020
 * Company: @小牛科技
 * Update Comments:
 * 构建配置参见:
 * @author wucongyi
 */
class CalendarPlugImpl : IPlugRulesCalendar {

    override fun getCalendarView(content: Context): View? {
        return LayoutInflater.from(content).inflate(R.layout.view_calendar, null)
    }


}