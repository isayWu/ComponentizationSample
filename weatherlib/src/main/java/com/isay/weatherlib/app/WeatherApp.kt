package com.isay.weatherlib.app

import android.app.Application
import android.util.Log
import com.isay.commonlib.app.IApplicationDelegate
import com.isay.commonserverlib.plug.IPlugRules
import com.isay.commonserverlib.plug.PlugManager
import com.isay.weatherlib.plug.WeatherPlugImpl

/**
 * Desc: application代理实现类
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
class WeatherApp : IApplicationDelegate {


    companion object {
        const val TAG = ">>isay WeatherImpl";
    }

    override fun onCreate(application: Application?) {
        Log.d(TAG, "onCreate")

        PlugManager.getInstance().addPlugRules(IPlugRules.WEATHER_ID, WeatherPlugImpl())
    }


}