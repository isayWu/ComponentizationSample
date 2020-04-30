package com.isay.commonlib.app

import android.app.Application

/**
 * Desc:
 *
 *
 * Author: WuCongYi
 * Date: 2020/4/29
 * Copyright: Copyright (c) 2016-2020
 * Company: @小牛科技
 * Update Comments:
 * 构建配置参见:
 *
 * @author wucongyi
 */
interface IApplicationDelegate {

    fun onCreate(application: Application?)

    fun onTerminate() {}

    fun onTrimMemory(level: Int) {}

    fun onLowMemory() {}
}