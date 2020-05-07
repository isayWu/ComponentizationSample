package com.isay.commonserverlib.plug;

import android.util.SparseArray;



/**
 * 接口管理类
 * <p>
 * Created by cywu4 on 2017/5/19.
 */
public class PlugManager {

    private volatile static PlugManager sInstance;

    private final SparseArray<IPlugRules> mPlugArrays = new SparseArray<>();

    public static PlugManager getInstance() {
        if (sInstance == null) {
            synchronized (PlugManager.class) {
                if (sInstance == null) {
                    sInstance = new PlugManager();
                }
            }
        }
        return sInstance;
    }

    /**
     * 添加插件接口
     *
     * @param plugID    插件标识
     * @param plugRules
     */
    public void addPlugRules(int plugID, IPlugRules plugRules) {
        if (mPlugArrays.indexOfKey(plugID) < 0) {
            mPlugArrays.put(plugID, plugRules);
        }
    }

    /**
     * 获取日历模块插件
     *
     * @return
     */
    public IPlugRulesCalendar getCalendarPlugRules() {
        return (IPlugRulesCalendar) getPlugRules(IPlugRules.CALENDAR_ID);
    }


    /**
     * 获取天气模块插件
     *
     * @return
     */
    public IPlugRulesWeather getWeatherPlugRules() {
        return (IPlugRulesWeather) getPlugRules(IPlugRules.WEATHER_ID);
    }


    /**
     * 获取插件接口
     *
     * @param plugID
     * @return
     */
    public IPlugRules getPlugRules(int plugID) {
        return mPlugArrays.get(plugID);
    }


}
