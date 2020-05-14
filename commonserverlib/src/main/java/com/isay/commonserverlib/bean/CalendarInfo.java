package com.isay.commonserverlib.bean;

/**
 * Desc:
 * <p>
 * Author: WuCongYi
 * Date: 2020/5/14
 * Copyright: Copyright (c) 2016-2020
 * Company: @小牛科技
 * Update Comments:
 * 构建配置参见:
 *
 * @author wucongyi
 */
public class CalendarInfo {

    private int year;
    private int month;
    private int day;
    private int week;
    /**
     * 公历节日
     */
    private String holiday;
    private int lunaYear;
    private int lunaMonth;
    private int lunaDay;
    private String lunaDayStr;
    /**
     * 农历节日
     */
    private String lunaHoliday;
    /**
     * 24节气
     */
    private String solarItem;

    public int getYear() {
        return year;
    }

    public CalendarInfo setYear(int year) {
        this.year = year;
        return this;
    }

    public int getMonth() {
        return month;
    }

    public CalendarInfo setMonth(int month) {
        this.month = month;
        return this;
    }

    public int getDay() {
        return day;
    }

    public CalendarInfo setDay(int day) {
        this.day = day;
        return this;
    }

    public String getHoliday() {
        return holiday;
    }

    public CalendarInfo setHoliday(String holiday) {
        this.holiday = holiday;
        return this;
    }

    public int getLunaYear() {
        return lunaYear;
    }

    public CalendarInfo setLunaYear(int lunaYear) {
        this.lunaYear = lunaYear;
        return this;
    }

    public int getLunaMonth() {
        return lunaMonth;
    }

    public CalendarInfo setLunaMonth(int lunaMonth) {
        this.lunaMonth = lunaMonth;
        return this;
    }

    public int getLunaDay() {
        return lunaDay;
    }

    public CalendarInfo setLunaDay(int lunaDay) {
        this.lunaDay = lunaDay;
        return this;
    }

    public String getLunaHoliday() {
        return lunaHoliday;
    }

    public CalendarInfo setLunaHoliday(String lunaHoliday) {
        this.lunaHoliday = lunaHoliday;
        return this;
    }

    public String getLunaDayStr() {
        return lunaDayStr;
    }

    public CalendarInfo setLunaDayStr(String lunaDayStr) {
        this.lunaDayStr = lunaDayStr;
        return this;
    }

    public int getWeek() {
        return week;
    }

    public CalendarInfo setWeek(int week) {
        this.week = week;
        return this;
    }

    public String getSolarItem() {
        return solarItem;
    }

    public CalendarInfo setSolarItem(String solarItem) {
        this.solarItem = solarItem;
        return this;
    }
}
