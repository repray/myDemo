package com.liang.demo.refactor.chapteone;

/**
 * @Author Li Yang
 * @Created 2021/10/14
 * @desc 电影实体类
 */
public class Movie {

    /**
     * 儿童片
     */
    public static final int CHILDENS = 2;

    /**
     * 普通片
     */
    public static final int REGULAR = 0;

    /**
     * 新片
     */
    public static final int NEW_RELEASE = 1;


    private String _title;

    private int _priceCode;

    public Movie(String _title, int _priceCode) {
        this._title = _title;
        this._priceCode = _priceCode;
    }

    public int getPriceCode() {
        return _priceCode;
    }

    public void setPriceCode(int arg) {
        _priceCode = arg;
    }

    public String get_title() {
        return _title;
    }
}
