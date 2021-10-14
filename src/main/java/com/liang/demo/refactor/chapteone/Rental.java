package com.liang.demo.refactor.chapteone;

/**
 * @Author Li Yang
 * @Created 2021/10/14
 * @desc 租金实体类
 */
public class Rental {

    //电影
    private Movie _movie;

    //租的天数
    private int _daysRented;

    public Rental(Movie movie, int daysRented) {
        _movie = movie;
        _daysRented = daysRented;
    }

    public Movie getMovie() {
        return _movie;
    }

    public int getDaysRented() {
        return _daysRented;
    }
}
