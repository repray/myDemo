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

    /**
     * 将switch代码段提取成方法
     * 第一次重构
     * double正确写法是小写开头...
     *
     * 第二次重构
     * 修改amountFor方法入参和返回值名称
     *
     * 第三次重构
     * 修改amountFor方法位置从Customer到Rental
     * 并改名为getCharge,并改变方法内引用
     * @param
     * @return
     */
    public double getCharge() {
        double result = 0;
        //判断各种类型电影的总金额
        switch (getMovie().getPriceCode()) {
            case Movie.REGULAR:
                //起步2元
                result += 2;
                //普通电影,当天数大于2天时,每天按1.5元收费
                if (getDaysRented() > 2) {
                    result += (getDaysRented() - 2) * 1.5;
                }
                break;
            //新电影,按每天3元收费
            case Movie.NEW_RELEASE:
                result += getDaysRented() * 3;
                break;
            //儿童电影,起步1.5元,大于3天时,按每天1.5元收费
            case Movie.CHILDENS:
                result += 1.5;
                if (getDaysRented() > 3) {
                    result += (getDaysRented() - 3) * 1.5;
                }
                break;
        }
        return result;
    }
}
