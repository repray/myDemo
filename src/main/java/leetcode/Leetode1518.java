package leetcode;

/**
 * @Author Li Yang
 * @Created on 17/12/2021.
 * @Desc 1518. 换酒问题
 * link: https://leetcode-cn.com/problems/water-bottles/
 * 小区便利店正在促销，用 numExchange 个空酒瓶可以兑换一瓶新酒。你购入了 numBottles 瓶酒。
 * 如果喝掉了酒瓶中的酒，那么酒瓶就会变成空的。
 * 请你计算 最多 能喝到多少瓶酒。
 */
public class Leetode1518 {

    public static void main(String[] args) {
        System.out.println(numWaterBottles(15,4));
    }

    public static int numWaterBottles(int numBottles, int numExchange) {
        //第一次买的酒设置为能喝到酒的初始值
        int result = numBottles;
        //如果酒瓶的数量>=能换酒瓶的数量,就开始进行换酒的操作
        while (numBottles >= numExchange) {
            //换酒的时候,将初始值添加本次可以换的酒的数量,也就是酒瓶数/多少瓶就可以兑换一瓶酒的数量
            result += numBottles / numExchange;
            //此时剩下的空瓶数量为可以换的酒瓶数量,加上没有达到换一整瓶酒的剩下的瓶子
            numBottles = numBottles / numExchange +numBottles % numExchange;
            //然后进行下一次判断
        }
        return result;
    }
}
