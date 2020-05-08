package com.isay.componentizationtest.ui

import android.view.View
import androidx.appcompat.content.res.AppCompatResources
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.isay.commonlib.ui.adapter.TabLayoutAdapter
import com.isay.commonserverlib.base.BaseActivity
import com.isay.componentizationtest.R
import com.isay.componentizationtest.ui.contract.MainContract
import com.isay.componentizationtest.ui.contract.MainPresenterImpl
import com.isay.componentizationtest.ui.fragment.HomeFragment
import com.isay.commonserverlib.view.tab.AppTabInfo
import com.isay.commonserverlib.view.tab.BottomTabLayoutView

/**
 * 主页
 */
class MainActivity : BaseActivity<MainPresenterImpl?>(), MainContract.IView {


    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun installPresenter(): MainPresenterImpl? {
        return MainPresenterImpl(this)
    }


    override fun initView() {
        //viewPager
        var viewPager: ViewPager = findViewById<View>(R.id.app_main_view_pager) as ViewPager
        val tabAdapter = TabLayoutAdapter(
            supportFragmentManager,
            FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
        )
        tabAdapter.addFragment(HomeFragment.getInstance())
        tabAdapter.addFragment(HomeFragment.getInstance())
        viewPager.setAdapter(tabAdapter)
        viewPager.setOffscreenPageLimit(4)
        //bottom
        var homeTab =
            AppTabInfo("日历", AppCompatResources.getDrawable(this, R.drawable.ic_tab_calendar))
        var weatherTab =
            AppTabInfo("天气", AppCompatResources.getDrawable(this, R.drawable.ic_tab_weather))
        var bottomTabView = (findViewById<View>(R.id.app_main_bottom_tab) as BottomTabLayoutView)
        bottomTabView
            .addTab(0, homeTab)
            .addTab(1, weatherTab)
            .setCurrentTab(0)
            .bindViewPager(viewPager)
    }


}
