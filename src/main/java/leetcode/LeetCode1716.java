package leetcode;

/**
 * @Author Li Yang
 * @Created on 15/1/2022.
 * @Desc 1716. 计算力扣银行的钱
 * link: https://leetcode-cn.com/problems/calculate-money-in-leetcode-bank/
 */
public class LeetCode1716 {
    public static void main(String[] args) {
        System.out.println(totalMoney2(2));
    }

    public static int totalMoney(int n) {
        int finalMoney = 0;
        //如果日期大于7,则需要计算多出时间的存款
        if (n > 7) {
            //第一周的基础存款为28
            int baseWeekSum = 28;
            // n/7 为已完成存款的完整周,比如存款21天,完整周则为3,存款20天,完整周则为2
            int saveMoneyWeek = n / 7;
            //multNum为每周递增比第一周递增的*7存款额,举例,一共存款3周,则存款额为28 + 28+7 + 28+7+7 ,其中加7的数量为0,1,3,6,10的等差数列
            int multNum = 0;
            for (int i = 0; i < saveMoneyWeek; i++) {
                multNum += i;
            }
            //计算出完整周的存款额度
            finalMoney = baseWeekSum * saveMoneyWeek + multNum * 7;
            //计算最后一周的天数
            int lastWeekDay = n % 7;
            //计算最后一周的周一的存款额
            int lastWeekMonday = saveMoneyWeek + 1;
            int singleWeekMoney = 0;
            for (int i = lastWeekMonday; i < lastWeekDay + lastWeekMonday; i++) {
                singleWeekMoney = singleWeekMoney + i;
            }
            return finalMoney + singleWeekMoney;
        }
        //如果日期<=7,则直接计算一周内的总额
        else {
            for (int i = 1; i <= n; i++) {
                finalMoney += i;
            }
            return finalMoney;
        }
    }

    public static int totalMoney2(int n) {
        int money = 0;
        for (int i = 0; i < n; i++) {
            money += i / 7 + i % 7 + 1;
        }
        return money;
    }
}
