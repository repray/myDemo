package classicArithmetic;

import java.util.Arrays;

/**
 * @Author Li Yang
 * @Created on 2021/8/27.
 * @Desc 选择排序
 */
public class selectSort {

    public static void main(String[] args) {
        int array[] = {38, 21, 15, 48, 91, 3, 62, 79, 86, 54};
        System.out.println(Arrays.toString(selectSort(array)));
    }

    public static int[] selectSort(int[] array) {
        //按数组长度循环
        for (int i = 0; i < array.length; i++) {
            //先将第一位的值定义为比较值,也就是最小的值
            int min = array[i];
            //再将数组按长度循环,开始值为i+1,就是每次比较第一位与后面所有位的值
            for (int j = i + 1; j < array.length; j++) {
                //如果最小位大于后面某位的值,则将两个位置的值替换
                if (min > array[j]) {
                    int temp;
                    temp = min;
                    min = array[j];
                    array[j] = temp;
                }
            }
            //完成一次内圈循环后,min的值则为本次循环最小的值,将a[i]更新为min值参与下次比较
            array[i] = min;
        }//完成所有外圈循环后,输出的值则是从小到大排序的有序数组
        return array;
    }
}
