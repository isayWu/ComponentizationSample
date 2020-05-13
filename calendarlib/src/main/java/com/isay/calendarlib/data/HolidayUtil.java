package com.isay.calendarlib.data;


import android.text.TextUtils;

import java.util.Arrays;
import java.util.List;

/**
 * @author necer
 * @date 2018/11/16
 */
public class HolidayUtil {


    /**
     * 法定节假日 休息的日期
     */
//    private static final List<String> restList = Arrays.asList("2017-12-30", "2017-12-31", "2018-01-01", "2018-02-15", "2018-02-16", "2018-02-17", "2018-02-18",
//            "2018-02-19", "2018-02-20", "2018-02-21", "2018-04-05", "2018-04-06", "2018-04-07", "2018-04-29", "2018-04-30", "2018-05-01", "2018-06-16", "2018-06-17",
//            "2018-06-18", "2018-09-22", "2018-09-23", "2018-09-24", "2018-10-01", "2018-10-02", "2018-10-03", "2018-10-04", "2018-10-05", "2018-10-06", "2018-10-07",
//            "2018-12-30", "2018-12-31", "2019-01-01", "2019-02-04", "2019-02-05", "2019-02-06", "2019-02-07", "2019-02-08", "2019-02-09", "2019-02-10", "2019-04-05", "2019-04-06",
//            "2019-04-07", "2019-05-01", "2019-05-02", "2019-05-03", "2019-05-04", "2019-06-07", "2019-06-08", "2019-06-09", "2019-09-13", "2019-09-14", "2019-09-15", "2019-10-01", "2019-10-02",
//            "2019-10-03", "2019-10-04", "2019-10-05", "2019-10-06", "2019-10-07", "2020-01-01", "2020-01-24", "2020-01-25", "2020-01-26", "2020-01-27", "2020-01-28", "2020-01-29", "2020-01-30", "2020-04-04"
//            , "2020-04-05", "2020-04-06", "2020-05-01", "2020-05-02", "2020-05-03", "2020-05-04", "2020-05-05", "2020-06-25", "2020-06-26", "2020-06-27", "2020-10-01"
//            , "2020-10-02", "2020-10-03", "2020-10-04", "2020-10-05", "2020-10-06", "2020-10-07", "2020-10-08"
//    );

    /**
     * 补班的日期
     */
//    private static final List<String> workdayList = Arrays.asList("2018-02-11", "2018-02-24", "2018-04-08", "2018-04-28", "2018-09-29", "2018-04-30", "2018-12-29",
//            "2019-02-02", "2019-02-03", "2019-04-28", "2019-05-05", "2019-09-29", "2019-10-12", "2020-01-19", "2020-02-01", "2020-04-26", "2020-05-09", "2020-06-28", "2020-09-27", "2020-10-10");


    /**
     * 法定节假日 休息的日期
     */
    private static final List<String> restList = Arrays.asList("2017-12-30", "2017-12-31", "2018-1-1", "2018-2-15", "2018-2-16", "2018-2-17", "2018-2-18",
            "2018-2-19", "2018-2-20", "2018-2-21", "2018-4-5", "2018-4-6", "2018-4-7", "2018-4-29", "2018-4-30", "2018-5-1", "2018-6-16", "2018-6-17",
            "2018-6-18", "2018-9-22", "2018-9-23", "2018-9-24", "2018-10-1", "2018-10-2", "2018-10-3", "2018-10-4", "2018-10-5", "2018-10-6", "2018-10-7",
            "2018-12-30", "2018-12-31", "2019-1-1", "2019-2-4", "2019-2-5", "2019-2-6", "2019-2-7", "2019-2-8", "2019-2-9", "2019-2-10", "2019-4-5", "2019-4-6",
            "2019-4-7", "2019-5-1", "2019-5-2", "2019-5-3", "2019-5-4", "2019-6-7", "2019-6-8", "2019-6-9", "2019-9-13", "2019-9-14", "2019-9-15", "2019-10-1", "2019-10-2",
            "2019-10-3", "2019-10-4", "2019-10-5", "2019-10-6", "2019-10-7", "2020-1-1", "2020-1-24", "2020-1-25", "2020-1-26", "2020-1-27", "2020-1-28", "2020-1-29", "2020-1-30", "2020-4-4"
            , "2020-4-5", "2020-4-6", "2020-5-1", "2020-5-2", "2020-5-3", "2020-5-4", "2020-5-5", "2020-6-25", "2020-6-26", "2020-6-27", "2020-10-1"
            , "2020-10-2", "2020-10-3", "2020-10-4", "2020-10-5", "2020-10-6", "2020-10-7", "2020-10-8"
    );

    /**
     * 补班的日期
     */
    private static final List<String> workdayList = Arrays.asList("2018-2-11", "2018-2-24", "2018-4-8", "2018-4-28", "2018-9-29", "2018-4-30", "2018-12-29",
            "2019-2-2", "2019-2-3", "2019-4-28", "2019-5-5", "2019-9-29", "2019-10-12", "2020-1-19", "2020-2-1", "2020-4-26", "2020-5-9", "2020-6-28", "2020-9-27", "2020-10-10");


    /**
     * 是否是班
     *
     * @param year
     * @param month
     * @param day
     * @return
     */
    public static boolean isWork(int year, int month, int day) {
        String date = year + "-" + month + "-" + day;
        for (String str : workdayList) {
            if (TextUtils.equals(str, date)) {
                return true;
            }
        }
        return false;
    }


    /**
     * 是否是休
     *
     * @param year
     * @param month
     * @param day
     * @return
     */
    public static boolean isReset(int year, int month, int day) {
        String date = year + "-" + month + "-" + day;
        for (String str : restList) {
            if (TextUtils.equals(str, date)) {
                return true;
            }
        }
        return false;
    }


}
