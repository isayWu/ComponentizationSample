package com.isay.commonserverlib.view.tab;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.isay.commonserverlib.R;


/**
 * tabView
 * Created by cywu4 on 2018/8/6.
 */

public class AppTabView extends LinearLayout {

    private int mIndex = 0;
    private TextView mTxtTitle;
    private ImageView mImgIcon;
    private AppTabInfo mInfo;

    public AppTabView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initialize();
    }

    public AppTabView(Context context, AppTabInfo info, int index) {
        super(context);
        mIndex = index;
        mInfo = info;
        initialize();
    }

    private void initialize() {
        View.inflate(getContext(), R.layout.view_main_tab_item, this);
        mTxtTitle = findViewById(R.id.tab_item_text);
        mImgIcon = findViewById(R.id.tab_item_img);
        mTxtTitle.setText(mInfo.getTabName());
        mImgIcon.setImageDrawable(mInfo.getNorDrawable());
        setSelectedStatus(false);
    }


    public int getIndex() {
        return mIndex;
    }


    /**
     * 更改选中状态
     *
     * @param isSelect
     */
    public void setSelectedStatus(boolean isSelect) {
        if (isSelect) {
            int color = getResources().getColor(R.color.colorAccent);
            mTxtTitle.setTextColor(color);
            mImgIcon.setImageDrawable(mInfo.getNorDrawable());
            mImgIcon.setColorFilter(color);
        } else {
            int color = getResources().getColor(R.color.colorGrey);
            mTxtTitle.setTextColor(color);
            mImgIcon.setImageDrawable(mInfo.getNorDrawable());
            mImgIcon.setColorFilter(color);
        }
    }


}