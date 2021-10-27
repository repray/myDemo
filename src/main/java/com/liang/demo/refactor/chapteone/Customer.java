package com.liang.demo.refactor.chapteone;

import java.util.Enumeration;
import java.util.Vector;

/**
 * @Author Li Yang
 * @Created 2021/10/14
 * @desc 重构第一章demo
 * 消费者类及实现方法
 * https://gitee.com/mrlijing/code-refactor 可参考重构第二部 第一章java案例
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

            /**
             * 判断各种类型电影的总金额
             * 第一次 重构
             *
             * 修改方法引用
             * 第四次重构
             */
            thisAmount = each.getCharge();
            //常租点数+1;
            frequentRenterPoints++;
            //电影价格由调用参数时传入,与电影实体类中的固定值像比较
            //如果普通电影,且租的天数大于1,则常租点数+1
            if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE) && each.getDaysRented() > 1) {
                frequentRenterPoints++;
            }
            result += "\t" + each.getMovie().get_title() + "\t" + String.valueOf(thisAmount) + "\n";
            totalAmount += thisAmount;
        }
        //输出结果
        result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
        result += "You earned " + String.valueOf(frequentRenterPoints) + "frequent renter points";
        return result;
    }

    /**
     * 将switch代码段提取成方法
     * 第一次重构
     * double正确写法是小写开头...
     * <p>
     * 第二次重构
     * 修改amountFor方法入参和返回值名称
     * <p>
     * 第三次重构
     * 修改amountFor方法位置从Customer到Rental
     * 并改名为getCharge,并改变方法内引用
     *
     * @param aRental
     * @return
     */
    private double amountFor(Rental aRental) {
        return aRental.getCharge();
    }
}
