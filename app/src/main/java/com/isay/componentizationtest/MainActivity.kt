package com.isay.componentizationtest

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.alibaba.android.arouter.launcher.ARouter
import com.isay.commonserverlib.constants.ARouterPathConstants
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //点击跳转
        app_jump_to_weather.setOnClickListener {
            ARouter.getInstance().build(ARouterPathConstants.CALENDAR_HOME).navigation()
        }
    }
}
