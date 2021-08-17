package leetCode;

/**
 * @Author Li Yang
 * @Created on 2021/8/17.
 * @Desc 551.学生出勤记录 I https://leetcode-cn.com/problems/student-attendance-record-i/
 * 难度 简单
 * tips 力扣可以使用jdk原生的工具类
 */
public class lt551 {

    public static void main(String[] args) {
        System.out.println(checkRecord("PPALAL"));
    }

    //很垃圾的解法,复杂且笨,注释都不想写了
    public static boolean checkRecord(String s) {
        int A = 0;
        int L = 1;
        String[] split = s.split("");
        for (int i = 0; i < split.length; i++) {
            if (split[i].equals("A")) {
                A++;
            }
            if (split[i].equals("L")) {
                if (i + 1 < s.length()) {
                    if (split[i + 1].equals("L")){
                        L++;
                    }
                    if (!split[i + 1].equals("L")){
                        L=1;
                    }
                }
                if (L >= 3) {
                    return false;
                }
            }
        }
        if (A >= 2) {
            return false;
        }
        return true;
    }
    /**
     *执行用时：9 ms, 在所有 Java 提交中击败了5.63%的用户
     * 内存消耗：38.5 MB, 在所有 Java 提交中击败了5.00%的用户
     */

    /**
     * 改良后的方法,使用indexOf判断是否存在连续的 LLL 判断第一个A的位置和最后一个A的位置是否相同来判断A的数量是否超过2
     * @param s
     * @return
     */
    public static boolean checkRecordImprove(String s) {
        if (s.indexOf("LLL")!=-1){
            return false;
        }
        if (s.indexOf("A")!=(s.lastIndexOf("A"))){
            return false;
        }
        return true;
    }
    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：36.2 MB, 在所有 Java 提交中击败了95.10%的用户
     */
}
