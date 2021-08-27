package classicArithmetic;

/**
 * @Author Li Yang
 * @Created on 2021/8/27.
 * @Desc 选择排序
 * 待吸收理解
 */
public class selectSort {


    public static int[] selectSort(int[] a) {
        int n = a.length;
        for (int i = 0; i < n - 1; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (a[min] > a[j]) {
                    min = j;
                }
            }
            //交换
            int temp = a[i];
            a[i] = a[min];
            a[min] = temp;
        }
        return a;

    }
}
