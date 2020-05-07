package com.isay.componentizationtest.ui.view.tab;

import android.graphics.drawable.Drawable;

/**
 * @author feiren
 * Created by feiren on 2017/6/8.
 * tab 实体
 */

public class AppTabInfo {

    private String tabTag = "home";
    private String tabName = "首页";
    private Drawable norDrawable;
    private Drawable selectedDrawable;

    public AppTabInfo(String name, Drawable select, Drawable unSelect) {
        tabName = name;
        tabTag = name;
        norDrawable = unSelect;
        selectedDrawable = select;
    }

    public String getTabTag() {
        return tabTag;
    }

    public void setTabTag(String tabTag) {
        this.tabTag = tabTag;
    }

    public String getTabName() {
        return tabName;
    }

    public void setTabName(String tabName) {
        this.tabName = tabName;
    }

    public Drawable getNorDrawable() {
        return norDrawable;
    }

    public void setNorDrawable(Drawable norDrawable) {
        this.norDrawable = norDrawable;
    }

    public Drawable getSelectedDrawable() {
        return selectedDrawable;
    }

    public void setSelectedDrawable(Drawable selectedDrawable) {
        this.selectedDrawable = selectedDrawable;
    }
}
