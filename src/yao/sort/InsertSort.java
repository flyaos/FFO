package yao.sort;

/**
 * Created by yao on 2014/8/13.
 */
public class InsertSort {

    /**
     * 插入排序，遍历第2个到最后一个元素，每次与已排好序的遍历比较（倒序比较）
     * <p/>
     * 空间复杂度:O(1)，
     * 时间复杂度:O(n方）（最快的情况，比如原始序列是倒序. 最好是情况O(n))
     *
     * 稳定否：稳定
     *
     * @param rawArray
     */
    public static void insertSort(int[] rawArray) {

        for (int i = 1; i < rawArray.length; i++) {
            int key = rawArray[i];
            int j = i - 1;
            while (j >= 0 && key < rawArray[j]) {
                rawArray[j + 1] = rawArray[j];
                j = j - 1;
            }
            rawArray[j + 1] = key; // 当rawArray[j] > key，则将key插入j后面

        }

    }

    public static void main(String[] args) {

        int[] a = {5, 4, 3, 2, 1};
        insertSort(a);
        for (int i : a) {
            System.out.println(i);
        }

    }
}
