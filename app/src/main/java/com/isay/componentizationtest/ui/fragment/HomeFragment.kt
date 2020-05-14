package com.isay.componentizationtest.ui.fragment

import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import com.isay.commonserverlib.base.BaseFragment
import com.isay.commonserverlib.bean.CalendarInfo
import com.isay.commonserverlib.listener.CalendarChangeListener
import com.isay.commonserverlib.listener.CalendarDateChangeListenerManager
import com.isay.commonserverlib.plug.PlugManager
import com.isay.componentizationtest.R
import com.isay.componentizationtest.ui.contract.HomeContract
import com.isay.componentizationtest.ui.contract.HomePresenterImpl
import kotlinx.android.synthetic.main.view_home_other.*
import kotlinx.android.synthetic.main.view_home_title.*

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
        //添加其它view
        var contentView: View = LayoutInflater.from(context).inflate(R.layout.view_home_other, null)
        //add日历view
        var calenderLayout: FrameLayout =
            mRootView.findViewById<View>(R.id.app_home_content_view) as FrameLayout
        var calendarView: View? =
            PlugManager.getInstance().calendarPlugRules.getCalendarView(
                context,
                contentView
            )
        CalendarDateChangeListenerManager.getInstance().addChangeListener(mCalendarChangeListener)
        if (calendarView != null) {
            calenderLayout.addView(calendarView)
        }
    }

    /**
     * 期间变化回调监听
     */
    private val mCalendarChangeListener: CalendarChangeListener = object : CalendarChangeListener {
        override fun onMonthChange(year: Int, month: Int) {
            app_home_head_tv_date.text = "${year}年${month}月"
        }

        override fun onYearChange(year: Int) {}

        override fun onCalendarSelect(info: CalendarInfo) {
            home_luna_view.setDate(info)
        }

        override fun onCalendarOutOfRange(year: Int, month: Int, day: Int) {

        }
    }

}