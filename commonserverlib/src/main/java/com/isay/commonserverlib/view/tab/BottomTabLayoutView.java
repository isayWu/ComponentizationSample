package com.isay.commonserverlib.view.tab;

import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.viewpager.widget.ViewPager;

import java.util.List;

import static android.view.ViewGroup.LayoutParams.MATCH_PARENT;

/**
 * tab widget
 * Created by cywu4 on 2018/8/6.
 */
public class BottomTabLayoutView extends LinearLayout {


    private int mSelectedTabIndex = -1;

    private OnTabSelectedListener mTabReselectedListener;

    private ViewPager mViewPager;

    public BottomTabLayoutView(Context context) {
        this(context, null);
    }

    public BottomTabLayoutView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setHorizontalScrollBarEnabled(false);
        this.setGravity(Gravity.CENTER_HORIZONTAL);
        this.setOrientation(HORIZONTAL);
        setLayoutParams(new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
    }


    /**
     * 设置当前选中的tab
     *
     * @param index 下标
     */
    public BottomTabLayoutView setCurrentTab(int index) {
        if (index == mSelectedTabIndex) {
            return this;
        }
        if (mSelectedTabIndex < 0) {
            mSelectedTabIndex = 0;
        }
        AppTabView child = (AppTabView) this.getChildAt(mSelectedTabIndex);
        if (child == null) {
            return this;
        }
        // 改变tab的选中状态
        child.setSelectedStatus(false);
        AppTabView currChild = (AppTabView) this.getChildAt(index);
        if (currChild != null) {
            currChild.setSelectedStatus(true);
        }
        mSelectedTabIndex = index;
        return this;
    }

    /**
     * 绑定viewPager
     *
     * @param viewPager
     */
    public void bindViewPager(ViewPager viewPager) {
        mViewPager = viewPager;
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                setCurrentTab(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    /**
     * 清空
     */
    public void clearTabAll() {
        removeAllViews();
    }

    /**
     * 添加单个tab
     *
     * @param list AppTabInfo列表
     */
    public void addTabAll(List<AppTabInfo> list) {
        for (int i = 0, size = list.size(); i < size; i++) {
            addTab(i, list.get(i));
        }
    }

    /**
     * 添加单个tab
     *
     * @param index 下标
     * @param info  AppTabInfo
     */
    public BottomTabLayoutView addTab(int index, AppTabInfo info) {
        AppTabView tabView = new AppTabView(getContext(), info, index);
        tabView.setFocusable(true);
        tabView.setOnClickListener(v -> {
            AppTabView tabView1 = (AppTabView) v;
            int index1 = tabView1.getIndex();
            if (index1 == mSelectedTabIndex) {
                return;
            }
            setCurrentTab(index1);
            if (mViewPager != null) {
                mViewPager.setCurrentItem(index1);
            }
            if (mTabReselectedListener != null) {
                mTabReselectedListener.onTabWidgetSelected(index1);
            }
        });
        addView(tabView, new LayoutParams(0, MATCH_PARENT, 1));
        return this;
    }


    /**
     * 设置点击监听
     *
     * @param listener OnTabSelectedListener
     */
    public void setOnTabReselectedListener(OnTabSelectedListener listener) {
        mTabReselectedListener = listener;
    }


    /**
     * tab 点击回调接口
     */
    public interface OnTabSelectedListener {
        void onTabWidgetSelected(int index);
    }
}
