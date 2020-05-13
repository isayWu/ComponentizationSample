package com.isay.calendarlib.plug

import android.content.Context
import android.view.View
import com.isay.calendarlib.view.calender.CalenderView
import com.isay.commonserverlib.listener.CalendarDateChangeListener
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

    /**
     * 获取日历view
     */
    override fun getCalendarView(
        context: Context?,
        otherView: View?,
        listener: CalendarDateChangeListener?
    ): View {
        var calendar = CalenderView(context)
        calendar.setOtherView(otherView).setListener(listener)
        return calendar
    }


}