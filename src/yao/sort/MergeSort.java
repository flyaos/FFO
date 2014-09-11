package yao.sort;

/**
 * Created by yao on 2014/8/13.
 */
public class MergeSort {

    /**
     * 归并排序
     * 思路：先递归划分，再两两归并
     * <p/>
     * 时间复杂度：O(nlg(n))
     * 空间复杂度：O(n)
     */
    public static void mergeSort(int[] a, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(a, start, mid); //划分为两块
            mergeSort(a, mid + 1, end); // 同上
            merge(a, start, mid, end); // 合并这两块
        }
    }

    /**
     * 两个数组归并
     *
     * @param a     原数组
     * @param start 开始
     * @param mid   中间
     * @param end   结尾
     */
    public static void merge(int[] a, int start, int mid, int end) {
        int i = start;
        int j = mid + 1;
        int[] tmp = new int[end - start + 1];
        int k = 0;

        // 先比较,如果相等，则先放左边的，保证稳定性
        while (i <= mid && j <= end) {
            if (a[i] <= a[j]) {
                tmp[k++] = a[i++];
            } else {
                tmp[k++] = a[j++];
            }
        }

        // 把剩下插到 tmp 末尾
        while (i <= mid) {
            tmp[k++] = a[i++];
        }

        while (j <= end) {
            tmp[k++] = a[j++];
        }

        // tmp 所有数附给原始数组对应都位置上
        for (int data : tmp) {
            a[start++] = data;
        }

    }

    public static void main(String[] args) {
        int[] data = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        mergeSort(data, 0, data.length - 1);
        for (int d : data) {
            System.out.println(d);
        }
    }
}
