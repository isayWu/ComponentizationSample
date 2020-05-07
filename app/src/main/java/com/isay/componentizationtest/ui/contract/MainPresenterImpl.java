package com.isay.componentizationtest.ui.contract;



import com.isay.commonlib.mvp.MvpPresenter;


/**
 * MainActivity
 *
 * @author wucongyi
 */
public class MainPresenterImpl extends MvpPresenter<MainContract.IView> implements MainContract.IPresenter {

    public MainPresenterImpl(MainContract.IView mView) {
        super(mView);
    }


}
