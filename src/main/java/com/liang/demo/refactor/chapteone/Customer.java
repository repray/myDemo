package com.liang.demo.refactor.chapteone;

import java.util.Enumeration;
import java.util.Vector;

/**
 * @Author Li Yang
 * @Created 2021/10/14
 * @desc 重构第一章demo
 * 消费者类及实现方法
 */
public class Customer {

    //姓名
    private String _name;

    //租金
    private Vector _rentals = new Vector();

    public Customer(String name) {
        _name = name;
    }

    public void addRental(Rental arg) {
        _rentals.addElement(arg);
    }

    public String getName() {
        return _name;
    }

    public String statment() {
        // totalAmount 总金额
        double totalAmount = 0;
        // frequent Renter Points 常租客点数
        int frequentRenterPoints = 0;
        Enumeration rentals = _rentals.elements();
        String result = "Rental Record for " + getName() + "\n";
        while (rentals.hasMoreElements()) {
            double thisAmount = 0;
            Rental each = (Rental) rentals.nextElement();

            //判断各种类型电影的总金额
            switch (each.getMovie().getPriceCode()) {
                case Movie.REGULAR:
                    //起步2元
                    thisAmount += 2;
                    //普通电影,当天数大于2天时,每天按1.5元收费
                    if (each.getDaysRented() > 2) {
                        thisAmount += (each.getDaysRented() - 2) * 1.5;
                    }
                    break;
                //新电影,按每天3元收费
                case Movie.NEW_RELEASE:
                    thisAmount += each.getDaysRented() * 3;
                    break;
                //儿童电影,起步1.5元,大于3天时,按每天1.5元收费
                case Movie.CHILDENS:
                    thisAmount += 1.5;
                    if (each.getDaysRented() > 3) {
                        thisAmount += (each.getDaysRented() - 3) * 1.5;
                    }
                    break;
            }
            //常租点数+1;
            frequentRenterPoints++;
            //电影价格由调用参数时传入,与电影实体类中的固定值像比较
            //如果普通电影,且租的天数大于1,则常租点数+1
            if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE) && each.getDaysRented() > 1) {
                frequentRenterPoints++;
            }
            result += "\t" + each.getMovie().get_title() + "\t" + String.valueOf(thisAmount) + "\n";
            thisAmount += totalAmount;
        }
        //输出结果
        result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
        result += "You earned " + String.valueOf(frequentRenterPoints) + "frequent renter points";
        return result;
    }
}
