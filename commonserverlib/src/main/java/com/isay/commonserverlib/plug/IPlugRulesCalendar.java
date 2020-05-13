package com.isay.commonserverlib.plug;

import android.content.Context;
import android.view.View;

import com.isay.commonserverlib.listener.CalendarDateChangeListener;

/**
 * Desc: 日历模板暴露的接口
 * <p>
 * Author: WuCongYi
 * Date: 2020/5/7
 * Copyright: Copyright (c) 2016-2020
 * Company: @小牛科技
 * Update Comments:
 * 构建配置参见:
 *
 * @author wucongyi
 */
public interface IPlugRulesCalendar extends IPlugRules {

    /**
     * 返回日历view
     *
     * @param context
     * @param otherView
     * @param listener
     * @return
     */
    View getCalendarView(Context context, View otherView, CalendarDateChangeListener listener);

}
