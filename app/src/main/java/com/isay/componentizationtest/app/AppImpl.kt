package com.isay.componentizationtest.app

import android.app.Application
import android.util.Log
import com.isay.commonlib.app.IApplicationDelegate

/**
 * Desc:
 *
 * Date: 2020/4/29
 * Copyright: Copyright (c) 2016-2020
 */
class AppImpl : IApplicationDelegate{


    companion object {
        private const val TAG = ">>isay  AppImpl"
    }

    override fun onCreate(application: Application?) {
        Log.d(TAG, "onCreate")
    }


}
