package com.isay.commonlib.app

import android.app.Application
import android.util.Log
import com.alibaba.android.arouter.launcher.ARouter
import com.isay.commonlib.BuildConfig

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
class CommonAppImpl : IApplicationDelegate {


    companion object {
        const val TAG = ">>isay CommonAppImpl";
    }

    override fun onCreate(application: Application?) {
        Log.d(TAG, "onCreate")
        initARouter(application)
    }


    fun initARouter(app: Application?) {
        if (BuildConfig.DEBUG) {
            ARouter.openLog()
            ARouter.openDebug();
        }
        ARouter.init(app);
    }

}