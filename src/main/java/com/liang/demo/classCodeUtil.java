package com.liang.demo;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;

/**
 * @Author Li Yang
 * @Created on 2021/9/6.
 * @Desc
 */
public class classCodeUtil {
    public static void main(String[] args) {
//        System.out.println(getCode(39678));
//        System.out.println(getCode(39679));
//        System.out.println(getCode(39680));
//        System.out.println(getCode(39681));
//        System.out.println(getCode(39682));
//        System.out.println(getCode(39683));
//        System.out.println(getCode(39684));


//        System.out.println(getCode(31402));
//        System.out.println(getCode(31432));
//        System.out.println(getCode(31453));
        System.out.println(analysisCode("230970"));

        String aa = "12334______456456______123123";
        System.out.println(Arrays.toString(aa.split("______")));


    }

    public static long analysisCode(String code) {
        if (StringUtils.isEmpty(code)) {
            return -1;
        }
        long value ;
        try {
            value = Long.parseLong(code);
        } catch (Exception e) {
            return -1;
        }
        long lo = value - 100000;
        String s = Long.toBinaryString(lo);
        int m = s.length() - 1;
        int move = 8;
        long cou = (long) (Math.pow(2, move)) - 1;
        long max = (long)Math.pow(2, m - move) - 1;
        return (lo >> move & max) | ((lo & cou) << m - move);
    }

    public static String getCode(long id) {

        if (id <= 0) {
            return "";
        }
        String s = Long.toBinaryString(id);
        long result ;
        int move = 8;
        int m = Math.max(s.length(), move);
        long cou = (long) (Math.pow(2, m - move)) - 1;
        long max = (long) Math.pow(2, m);
        result = ((id >> m - move) | ((id & cou) << move | max)) + 100000;

        return String.valueOf(result);
    }
}
