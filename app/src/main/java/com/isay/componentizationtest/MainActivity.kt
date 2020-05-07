package com.isay.componentizationtest

import android.os.Bundle
import android.view.View
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import com.isay.commonserverlib.plug.PlugManager

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //初始化日历view
        initCalendarView()
    }

    private fun initCalendarView() {
        var calendarView: View? = PlugManager.getInstance().calendarPlugRules.getCalendarView(this)
        if (calendarView != null) {
            var layout: FrameLayout = findViewById<View>(R.id.app_calender_view) as FrameLayout
            layout.addView(calendarView)
        }
    }

}
