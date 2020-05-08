package com.isay.commonlib.mvp;

public class MvpPresenter<V extends MvpView> {

    protected V mView;

    public MvpPresenter(V mView) {
        this.mView = mView;
    }

    /**
     * 加载数据
     */
    public void loadData() {
    }

    /**
     * 绑定view，一般在初始化中调用该方法
     *
     * @param view view
     */
    public void attachView(V view) {
        this.mView = view;
    }


    /**
     * 解除绑定view，一般在onDestroy中调用
     */

    public void detachView() {
        this.mView = null;
    }


    /**
     * View是否绑定
     *
     * @return
     */
    public boolean isViewAttached() {
        return mView != null;
    }

    /**
     * 获取view
     *
     * @return
     */
    public V getView() {
        return mView;
    }


}