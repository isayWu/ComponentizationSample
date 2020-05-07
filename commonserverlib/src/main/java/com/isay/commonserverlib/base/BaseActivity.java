package com.isay.commonserverlib.base;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;

import com.gyf.immersionbar.ImmersionBar;
import com.isay.commonserverlib.R;

/**
 * @author wucongyi
 */
public abstract class BaseActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //沉浸式状态栏
        initStatusBar();
        //设置layoutId
        int layoutId = getLayoutId();
        if (layoutId > 0) {
            setContentView(getLayoutId());
        }
        //初始化view
        initView();
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

    protected abstract void initView();


}
