package com.liang.demo;

/**
 * @Author Li Yang
 * @Created on 2021/9/27.
 * @Desc 处理字符串中不等长的空格为统一长度的空格
 */
public class DealBlank {
    public static void main(String[] args) {

    }

    //处理文字中的空格,全部替换为6个下划线______
    public static String dealBlank(String word) {
        int ll = word.indexOf('_');
        char[] chars = word.toCharArray();
        String blankLength = "_";
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '_' && chars[i + 1] == '_') {
                blankLength = blankLength + "_";
            }
            if (chars[i] == '_' && chars[i + 1] != '_') {
                break;
            }

        }
        //判断待处理不定长空格的长度,如果>1再进行处理
        if (blankLength.length() > 1) {
            word = word.replace(blankLength, "______");
        }
        return word;
    }
}
