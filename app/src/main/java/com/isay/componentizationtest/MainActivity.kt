package com.isay.componentizationtest

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.alibaba.android.arouter.launcher.ARouter
import com.isay.commonlib.app.IApplicationDelegate
import com.isay.commonlib.app.ManifestParser
import kotlinx.android.synthetic.main.activity_main.*
import java.util.ArrayList

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //点击跳转
        app_jump_to_weather.setOnClickListener {
            ARouter.getInstance().build("/weather/home").navigation()
        }
    }
}
