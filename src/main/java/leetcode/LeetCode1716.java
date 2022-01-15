package leetcode;

/**
 * @Author Li Yang
 * @Created on 15/1/2022.
 * @Desc 1716. 计算力扣银行的钱
 * link: https://leetcode-cn.com/problems/calculate-money-in-leetcode-bank/
 */
public class LeetCode1716 {
    public static void main(String[] args) {
        System.out.println(totalMoney(4));
    }

    public static int totalMoney(int n) {
        int finalMoney = 0;
        if (n >= 7) {
            int baseWeekSum = 28;
            int saveMoneyWeek = n / 7;
            int ss = 0;
            if (saveMoneyWeek >= 2) {
                for (int i = 0; i < saveMoneyWeek; i++) {
                    ss += i;
                }
            }
            finalMoney = baseWeekSum * saveMoneyWeek + ss * 7;
            int singleWeekDay = n % 7;
            int newWeekMoney = saveMoneyWeek += 1;
            int aaa = 0;
            for (int i = newWeekMoney; i < singleWeekDay + newWeekMoney; i++) {
                aaa = aaa + i;
            }
            return finalMoney + aaa;
        } else {
            for (int i = 1; i <= n; i++) {
                finalMoney += i;
            }
            return finalMoney;
        }
    }
}
