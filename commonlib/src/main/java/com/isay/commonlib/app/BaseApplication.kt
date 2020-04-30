package com.isay.commonlib.app

import android.app.Application
import android.util.Log
import java.util.*


/**
 * Desc:
 * <p>
 * Author: WuCongYi
 * Date: 2020/4/29
 * Copyright: Copyright (c) 2016-2020
 * Company: @小牛科技
 * Update Comments:
 * 构建配置参见:
 * @author wucongyi
 */
 class BaseApplication : Application() {

    private var mAppDelegateList: MutableList<IApplicationDelegate?> = ArrayList()

    private companion object {
        const val MODULE_VALUE = "ConfigModule"
    }

    override fun onCreate() {
        super.onCreate()
        //用反射, 将 AndroidManifest.xml 中带有 ConfigModule 标签的 class 转成对象集合（List<ConfigModule>）
        val delegateList: MutableList<IApplicationDelegate>? = ManifestParser(this).parse()
        if (delegateList != null) {
            for (d in delegateList) {
                mAppDelegateList.add(d)
            }
        }
        //onCreate
        for (delegate in mAppDelegateList) {
            delegate?.onCreate(this)
            Log.d(">>isay_is_debug", delegate.toString())
        }
    }

    override fun onTerminate() {
        super.onTerminate()
        for (delegate in mAppDelegateList) {
            delegate?.onTerminate()
        }
    }

    override fun onTrimMemory(level: Int) {
        super.onTrimMemory(level)
        for (delegate in mAppDelegateList) {
            delegate?.onTrimMemory(level)
        }
    }

    override fun onLowMemory() {
        super.onLowMemory()
        for (delegate in mAppDelegateList) {
            delegate?.onLowMemory()
        }
    }


}