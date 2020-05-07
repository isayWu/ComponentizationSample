package com.isay.componentizationtest.test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.FrameLayout;

import com.isay.commonlib.mvp.MvpPresenter;
import com.isay.commonserverlib.base.BaseActivity;
import com.isay.componentizationtest.R;
import com.isay.componentizationtest.ui.contract.MainContract;
import com.isay.componentizationtest.ui.contract.MainPresenterImpl;

public class TestActivity extends BaseActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    protected int getLayoutId() {
        return 0;
    }

    @Override
    public MvpPresenter installPresenter() {
        return null;
    }

    @Override
    protected void initView() {

    }

}
