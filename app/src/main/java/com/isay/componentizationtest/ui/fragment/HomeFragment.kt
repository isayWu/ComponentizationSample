package com.isay.componentizationtest.ui.fragment

import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import com.isay.commonserverlib.base.BaseFragment
import com.isay.commonserverlib.plug.PlugManager
import com.isay.componentizationtest.R
import com.isay.componentizationtest.ui.contract.HomeContract
import com.isay.componentizationtest.ui.contract.HomePresenterImpl

/**
 * Desc: 首页Fragment
 *
 *
 * Author: WuCongYi
 * Date: 2020/5/7
 * Copyright: Copyright (c) 2016-2020
 * Company: @小牛科技
 * Update Comments:
 * 构建配置参见:
 *
 * @author wucongyi
 */
class HomeFragment : BaseFragment<HomePresenterImpl?>(), HomeContract.IView {


    companion object {
        fun getInstance(): HomeFragment {
            return HomeFragment()
        }
    }

    override fun installPresenter(): HomePresenterImpl {
        return HomePresenterImpl(this)
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_home
    }

    override fun initView() {
        //add日历view
        var appCalenderLayout: FrameLayout =
            mRootView.findViewById<View>(R.id.app_home_content_view) as FrameLayout
        //找到日历view,并添加
        var calendarView: View? = PlugManager.getInstance().calendarPlugRules.getCalendarView(context)
        if (calendarView != null) {
            appCalenderLayout.addView(calendarView)
        }
        //添加其它view
        var calendarOther: FrameLayout? =
            appCalenderLayout.findViewWithTag<View>("calendar_other_view") as FrameLayout
        if (calendarOther != null) {
            var otherView: View = LayoutInflater.from(context).inflate(R.layout.view_home_other, null)
            calendarOther.addView(otherView)
        }
    }
}