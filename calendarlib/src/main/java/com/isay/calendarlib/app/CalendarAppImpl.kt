package com.isay.calendarlib.app

import android.app.Application
import android.util.Log
import com.isay.commonlib.app.IApplicationDelegate

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
class CalendarAppImpl : IApplicationDelegate{

    companion object {
        private const val TAG = ">>isay  CalendarAppImpl"
    }

    override fun onCreate(application: Application?) {
        Log.d(TAG, "onCreate")
    }


}