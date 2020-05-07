package com.isay.componentizationtest.ui.contract;



import com.isay.commonlib.mvp.MvpPresenter;


/**
 * MainActivity
 *
 * @author wucongyi
 */
public class HomePresenterImpl extends MvpPresenter<HomeContract.IView> implements HomeContract.IPresenter {

    public HomePresenterImpl(HomeContract.IView mView) {
        super(mView);
    }


}
