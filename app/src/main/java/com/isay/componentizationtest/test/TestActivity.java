package com.isay.componentizationtest.test;

import com.isay.commonlib.mvp.MvpPresenter;
import com.isay.commonserverlib.base.BaseActivity;
import com.isay.commonserverlib.listener.CalendarChangeListener;
import com.isay.componentizationtest.R;
import com.isay.commonserverlib.view.tab.BottomTabLayoutView;

public class TestActivity extends BaseActivity  {


    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public MvpPresenter installPresenter() {
        return null;
    }

    @Override
    protected void initView() {
        ((BottomTabLayoutView)findViewById(R.id.app_main_bottom_tab)).setCurrentTab(0);
    }



}
