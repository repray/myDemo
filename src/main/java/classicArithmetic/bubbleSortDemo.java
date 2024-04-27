package classicArithmetic;

import java.util.Arrays;

/**
 * @Author Li Yang
 * @Created on 2021/8/25.
 * @Desc 冒泡排序
 */
public class bubbleSortDemo {

    public static void main(String[] args) {
        int[] arr = new int[]{2, 8, 7, 9, 4, 1, 5, 0};
        System.out.println(Arrays.toString(bubbleSort(arr)));
    }

    public static int[] bubbleSort(int[] arr) {
        //控制冒泡排序的循环次数,因为是相邻两位比较,所以长度为8的数组则需要循环7次,从0开始则需要length-1
        for (int i = 0; i < arr.length - 1; i++) {
            //在每次循环中,因为是相邻数组位置比较,比较完的则不参与比较,所以每次需要length减去i
            for (int j = 0; j < arr.length - 1 - i; j++) {
                //如果相邻两个,前一位大于后一位,则两个交换位置
                //降序排序则大于换成小于就可以了
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        //执行完,则数组变成按序排列
        return arr;
    }
}
