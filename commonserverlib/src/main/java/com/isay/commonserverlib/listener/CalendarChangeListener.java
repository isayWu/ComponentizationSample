package com.isay.commonserverlib.listener;

import com.isay.commonserverlib.bean.CalendarInfo;

/**
 * Desc:
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
public interface CalendarChangeListener {

    public void onMonthChange(int year, int month);

    public void onYearChange(int year);

    public void onCalendarOutOfRange(int year, int month, int day);

    public void onCalendarSelect(CalendarInfo info);

}
