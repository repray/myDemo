package com.liang.demo;

import java.util.Arrays;

/**
 * @author : liyang
 * @date : 2021/9/25
 * array数组常用方法
 */
public class ArrayDemo {
    public static void main(String[] args) {
        //数组的声明
        int[] arrays = new int[]{1, 2, 3, 4, 5};
        int[] arr = new int[3];
        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 2;
        //数组的打印
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(arrays));
        for (int i : arr) {
            System.out.println(i);
        }
        //直接打印数组,输出的是数组的内存地址
        System.out.println(arr);
        //二维数组的声明
        int[][] magicSquare =
                {
                        {16, 3, 2, 13},
                        {5, 10, 11, 8},
                        {9, 6, 7, 3}
                };
        //二维数组的打印-deepToString
        System.out.println(Arrays.deepToString(magicSquare));
    }
}
