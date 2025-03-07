package leetcode;

import java.util.Stack;

/**
 * @Author Li Yang
 * @Created on 2021/8/30.
 * @Desc https://leetcode-cn.com/problems/valid-parentheses/
 * 状态:未完成全部测试用例,待修改
 */
public class LeetCode20 {

    public static void main(String[] args) {
//        String s = "([}}])";
        String s = "()[]{}";
        System.out.println(isValid(s));
    }

    public static boolean isValid(String s) {
        if (s.length() <= 1 || s.length() >= 10000) {
            return false;
        }
        if ("{}".equals(s) || "()".equals(s) || "[]".equals(s)) {
            return true;
        } else if (s.length() == 2 && (")".equals(String.valueOf(s.charAt(0))) || "}".equals(String.valueOf(s.charAt(0))) || "]".equals(String.valueOf(s.charAt(0))))) {
            return false;
        } else if (s.length() % 2 != 0) {
            return false;
        }
        Stack<String> stack = new Stack<>();
        try {
            for (int i = 0; i < s.length(); i++) {
                if ("(".equals(String.valueOf(s.charAt(i)))) {
                    stack.push("(");
                    continue;
                }
                if (")".equals(String.valueOf(s.charAt(i))) && "(".equals(stack.peek())) {
                    stack.pop();
                    continue;
                }
                if ("{".equals(String.valueOf(s.charAt(i)))) {
                    stack.push("{");
                    continue;
                }
                if ("}".equals(String.valueOf(s.charAt(i))) && "{".equals(stack.peek())) {
                    stack.pop();
                    continue;
                }
                if ("[".equals(String.valueOf(s.charAt(i)))) {
                    stack.push("[");
                    continue;
                }
                if ("]".equals(String.valueOf(s.charAt(i))) && "[".equals(stack.peek())) {
                    stack.pop();
                    continue;
                }
                if (")".equals(String.valueOf(s.charAt(i)))) {
                    if (stack.search("{") == -1) {
                        return false;
                    }
                }
                if ("]".equals(String.valueOf(s.charAt(i)))) {
                    if (stack.search("[") == -1) {
                        return false;
                    }
                }
                if ("}".equals(String.valueOf(s.charAt(i)))) {
                    if (stack.search("{") == -1) {
                        return false;
                    }
                }
            }
            return stack.empty();
        } catch (Exception exception) {
            return false;
        }
    }
}
