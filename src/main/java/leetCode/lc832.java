package leetCode;

import com.alibaba.fastjson.JSONArray;

/**
 * @Author Li Yang
 * @Created on 2021/8/18.
 * @Desc 832. 翻转图像 https://leetcode-cn.com/problems/flipping-an-image/
 */
public class lc832 {
    public static void main(String[] args) {
        int[][] image = new int[][]{{1, 1, 0}, {1, 0, 1}, {0, 0, 0}};
        System.out.println(JSONArray.toJSONString(flipAndInvertImage(image)));
    }

    public static int[][] flipAndInvertImage(int[][] image) {
        /**
         * 采用双层循环嵌套的方式解决,内存消耗较大
         */
        for (int i = 0; i < image.length; i++) {
            int[] reverseArray = new int[image[i].length];
            for (int j = 0; j < image[i].length; j++) {
                //使用数组的长度-1-j来计算下标,得到翻转的数组
                reverseArray[j] = image[i][image[i].length - 1 - j];
                //这里用三元运算符进行 0 1 的倒转赋值
                reverseArray[j] = reverseArray[j] == 0 ? 1 : 0;
            }
            image[i] = reverseArray;
        }
        return image;
    }
}
