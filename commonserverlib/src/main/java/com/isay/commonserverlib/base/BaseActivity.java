package com.isay.commonserverlib.base;


import android.app.Activity;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import com.gyf.immersionbar.ImmersionBar;
import com.isay.commonlib.mvp.MvpPresenter;
import com.isay.commonlib.mvp.MvpView;
import com.isay.commonserverlib.R;

/**
 * @author wucongyi
 */
public abstract class BaseActivity<T extends MvpPresenter> extends FragmentActivity implements MvpView {


    protected T mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //沉浸式状态栏
        //initStatusBar();
        //设置layoutId
        int layoutId = getLayoutId();
        if (layoutId > 0) {
            setContentView(getLayoutId());
        }
        //加载数据
        mPresenter = installPresenter();
        //初始化view
        initView();
        //初始化数据
        initData();
    }

    /**
     * 设置状态栏字体颜色
     * 使用fitsSystemWindows属性,必须指定状态栏颜色
     */
    protected void initStatusBar() {
        ImmersionBar.with(this)
                .statusBarDarkFont(true)
                .fitsSystemWindows(true)
                .statusBarColor(R.color.transColor).init();
    }


    protected abstract int getLayoutId();

    public abstract T installPresenter();

    protected abstract void initView();

    protected void initData() {
        if (mPresenter != null) {
            mPresenter.loadData();
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.detachView();
        }
    }
}
