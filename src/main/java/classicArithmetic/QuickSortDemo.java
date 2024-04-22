package classicArithmetic;

/**
 * 快速排序
 */
public class QuickSortDemo {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 8, 7, 9, 4, 1, 5, 0};
        quickSort(arr,0,arr.length-1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }

    public static void quickSort(int[] array, int left, int right) {
        if (left>right){
            return;
        }
        int basePoint = array[left];
        int i = left;
        int j = right;
        while (i != j) {
            while (array[j] >= basePoint && i < j) {
                j--;
            }
            while (array[i] <= basePoint && i < j) {
                i++;
            }
            int temp = array[j];
            array[j] = array[i];
            array[i] = temp;
        }

        array[left] = array[i];
        array[i] = basePoint;

        quickSort(array, left, i - 1);
        quickSort(array, i + 1, right);
    }
}
