package leetCode;

/**
 * @Author Li Yang
 * @Created on 2021/8/30.
 * @Desc https://leetcode-cn.com/problems/valid-parentheses/
 * 状态:未完成全部测试用例,待修改
 */
public class lc20 {

    public static void main(String[] args) {
        String s = "(){}}{";
        System.out.println(isValid(s));
    }

    public static boolean isValid(String s) {

        if (s.length() <= 1 || s.length() >= 10000) {
            return false;
        }
        if (s.length() == 2 && (String.valueOf(s.charAt(0)).equals(")") || String.valueOf(s.charAt(0)).equals("}") || String.valueOf(s.charAt(0)).equals("]"))) {
            return false;
        }
        for (int i = 0; i < s.length() - 1; i++) {
            if (String.valueOf(s.charAt(i)).equals("(") && (!String.valueOf(s.charAt(i + 1)).equals(")") && s.lastIndexOf(")") != s.length() - 1 - i)) {
                return false;
            }
            if (String.valueOf(s.charAt(i)).equals("{") && (!String.valueOf(s.charAt(i + 1)).equals("}") && s.lastIndexOf("}") != s.length() - 1 - i)) {
                return false;
            }
            if (String.valueOf(s.charAt(i)).equals("[") && (!String.valueOf(s.charAt(i + 1)).equals("]") && s.lastIndexOf("]") != s.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}
