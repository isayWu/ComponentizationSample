package com.isay.commonserverlib.base;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.isay.commonlib.mvp.MvpPresenter;
import com.isay.commonlib.mvp.MvpView;

/**
 * Created by cywu4 on 2018/8/6.
 */

public abstract class BaseFragment<T extends MvpPresenter> extends Fragment implements MvpView {

    protected Context mContext;

    protected View mRootView = null;

    protected T mPresenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (mRootView == null) {
            mContext = getContext();
            mRootView = inflater.inflate(getLayoutId(), container, false);
            mPresenter = installPresenter();
            initView();
            initData();
        }
        return mRootView;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.detachView();
        }
    }


    public abstract T installPresenter();

    /**
     * 获取layoutId
     *
     * @return
     */
    protected abstract int getLayoutId();


    /**
     * 初始化view,除了recyclerView和smartRefreshLayout
     */
    protected abstract void initView();


    /**
     * 初始化数据，比如初始化执行网络请求
     */
    protected void initData() {
    }


}
