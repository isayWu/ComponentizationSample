package com.isay.commonserverlib.listener;

import java.util.ArrayList;
import java.util.List;

/**
 * Desc:
 * <p>
 * Author: WuCongYi
 * Date: 2020/5/8
 * Copyright: Copyright (c) 2016-2020
 * Company: @小牛科技
 * Update Comments:
 * 构建配置参见:
 *
 * @author wucongyi
 */
public class CalendarDateChangeListenerManager {

    private static CalendarDateChangeListenerManager mInstance;

    private List<CalendarChangeListener> mListChangeListener = new ArrayList<>();

    public static CalendarDateChangeListenerManager getInstance() {
        if (mInstance == null) {
            mInstance = new CalendarDateChangeListenerManager();
        }
        return mInstance;
    }

    public void addChangeListener(CalendarChangeListener l) {
        this.mListChangeListener.add(l);
    }

    public List<CalendarChangeListener> getListChangeListener() {
        return mListChangeListener;
    }

}
