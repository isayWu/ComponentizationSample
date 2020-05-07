package com.isay.componentizationtest.ui

import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import android.widget.Toast
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.gyf.immersionbar.ImmersionBar
import com.gyf.immersionbar.ktx.immersionBar
import com.isay.commonlib.ui.adapter.TabLayoutAdapter
import com.isay.commonserverlib.base.BaseActivity
import com.isay.commonserverlib.plug.PlugManager
import com.isay.componentizationtest.R
import com.isay.componentizationtest.ui.contract.MainContract
import com.isay.componentizationtest.ui.contract.MainPresenterImpl
import com.isay.componentizationtest.ui.fragment.HomeFragment

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
        val tabAdapter = TabLayoutAdapter(
            supportFragmentManager,
            FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
        )
        tabAdapter.addFragment(HomeFragment.getInstance())
        tabAdapter.addFragment(HomeFragment.getInstance())
        tabAdapter.addFragment(HomeFragment.getInstance())
        tabAdapter.addFragment(HomeFragment.getInstance())
        var viewPager: ViewPager = findViewById<View>(R.id.app_main_view_pager) as ViewPager
        viewPager.setAdapter(tabAdapter)
        //viewPager.addOnPageChangeListener(mPageChangeListener)
        viewPager.setOffscreenPageLimit(4)


    }


}
