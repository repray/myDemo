package leetcode;

import lombok.val;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author Li Yang
 * @Created on 2024/7/29
 * @Desc 682. 棒球比赛  https://leetcode.cn/problems/baseball-game/description/
 * 你现在是一场采用特殊赛制棒球比赛的记录员。这场比赛由若干回合组成，过去几回合的得分可能会影响以后几回合的得分。
 * 比赛开始时，记录是空白的。你会得到一个记录操作的字符串列表 ops，其中 ops[i] 是你需要记录的第 i 项操作，ops 遵循下述规则：
 * 整数 x - 表示本回合新获得分数 x
 * "+" - 表示本回合新获得的得分是前两次得分的总和。题目数据保证记录此操作时前面总是存在两个有效的分数。
 * "D" - 表示本回合新获得的得分是前一次得分的两倍。题目数据保证记录此操作时前面总是存在一个有效的分数。
 * "C" - 表示前一次得分无效，将其从记录中移除。题目数据保证记录此操作时前面总是存在一个有效的分数。
 * 请你返回记录中所有得分的总和。
 */
public class LeetCode682 {
    public static void main(String[] args) {
        String[] ops = {"5", "2", "C", "D", "+"};
        val i = calPoints(ops);
        System.out.println(i);
    }

    public static int calPoints(String[] operations) {
        List<String> list = new ArrayList<>(Arrays.asList(operations));
        Integer sum = 0;
        for (int i = 0; i < list.size(); i++) {
            if ("+".equals(list.get(i))) {
                list.set(i, String.valueOf(Integer.parseInt(list.get(i - 1)) + Integer.parseInt(list.get(i - 2))));
                sum = sum + Integer.parseInt(list.get(i));
                continue;
            }
            if ("D".equals(list.get(i))) {
                list.set(i, String.valueOf(Integer.parseInt(list.get(i - 1)) * 2));
                sum = sum + Integer.parseInt(list.get(i));
                continue;
            }
            if ("C".equals(list.get(i))) {
                sum = sum - Integer.parseInt(list.get(i - 1));
                list.remove(list.get(i));
                list.remove(list.get(i - 1));
                i = i - 2;
                continue;
            } else {
                sum = sum + Integer.parseInt(list.get(i));
            }
        }
        return sum;
    }
}
