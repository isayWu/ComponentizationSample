package com.isay.commonserverlib.listener;

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
public interface CalendarDateChangeListener {

    public void onMonthChange(int year, int month);

    public void onYearChange(int year);

}
