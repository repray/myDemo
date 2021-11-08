package leetcode;

/**
 * @Author Li Yang
 * @Created on 2021/8/16.
 * @Desc 7. 整数反转  https://leetcode-cn.com/problems/reverse-integer/
 */
public class LeetCode7 {

    public static void main(String[] args) {
        int reverse = reverse(1534236469);
        System.out.println(reverse);
    }

    public static int reverse(int x) {
        try {
            StringBuffer sb = new StringBuffer(String.valueOf(Math.abs(x)));
            String afterReverse = sb.reverse().toString();
            //三元运算符嵌套 先判断转换后的字符串是否大于32,大于32直接返回0,小于等于32再继续判断入参是否大于0,入参小于0则*-1,入参大于0直接返回
            return afterReverse.length() > 32 ? 0 : (x < 0 ? Integer.parseInt(afterReverse) * -1 : Integer.parseInt(afterReverse));
        }
        //转换前为正常int类型范围整数,转换后超过int类型
        catch (Exception e) {
            return 0;
        }
    }
}
