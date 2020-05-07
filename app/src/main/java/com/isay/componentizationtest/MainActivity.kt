package com.isay.componentizationtest

import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import com.gyf.immersionbar.ImmersionBar
import com.isay.commonserverlib.base.BaseActivity
import com.isay.commonserverlib.plug.PlugManager

/**
 * 主页
 */
class MainActivity : BaseActivity() {


    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun initView() {
        //add日历view
        var appCalenderLayout: FrameLayout =
            findViewById<View>(R.id.app_calender_view) as FrameLayout
        //找到日历view,并添加
        var calendarView: View? = PlugManager.getInstance().calendarPlugRules.getCalendarView(this)
        if (calendarView != null) {
            appCalenderLayout.addView(calendarView)
        }
        //添加其它view
        var calendarOther: FrameLayout? =
            appCalenderLayout.findViewWithTag<View>("calendar_other_view") as FrameLayout
        if (calendarOther != null) {
            var otherView: View = LayoutInflater.from(this).inflate(R.layout.view_home_other, null)
            calendarOther.addView(otherView)
        }
    }


    override fun initStatusBar() {
        ImmersionBar.with(this)
            .statusBarDarkFont(false)
            .fitsSystemWindows(true)
            .statusBarColor(com.isay.commonserverlib.R.color.colorAccent).init()
    }

}
