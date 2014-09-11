package yao.sort;

/**
 * Created by yao on 2014/8/13.
 */
public class QuickSort {

    /**
     * 快速排序
     *
     * 分区，求出中间值j
     * 递归快速排序
     * 平均时间复杂度：O(nlgn)，最坏情况：逆序（n平方）
     * 空间复杂度：O(n) ~ O(lgn) ：栈大小
     * 稳定度：不稳定
     *
     * @param a 数组
     * @param start 开始
     * @param end 结束
     */
    public static void quickSort(int[] a, int start, int end) {
        if (start >= end)
            return;
        int j = partition_left(a, start, end);
        quickSort(a, start, j - 1);
        quickSort(a, j + 1, end);
    }

    /**
     * 以最右边的为主元
     *
     */
    private static int partition_right(int[] a, int start, int end) {
        int key = a[end];
        int i = start - 1;
        int j = end;
        while (true) {
            while (a[++i] <= key)
                if (i == end)
                    break;

            while (a[--j] >= key)
                if (j == start)
                    break;

            if (i >= j) break;
            exchange(a, i, j);
        }

        exchange(a, i, end);

        return i;
    }

    /**
     * 以最左边的为主元
     *
     */
    private static int partition_left(int[] a, int start, int end) {
        int key = a[start];
        int i = start;
        int j = end + 1;
        while (true) {
            while (a[--j] >= key)
                if (j == start)
                    break;

            while (a[++i] <= key)
                if (i == end)
                    break;

            if (i >= j) break;
            exchange(a, i, j);
        }

        exchange(a, start, j);

        return j;
    }

    private static void exchange(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static void main(String[] args) {

        int a[] = {1, 4, 3, 6, 2, 7};
        int aa[] = {5,4,3,2,1};
        quickSort(a, 0, a.length - 1);
        for (int i : a) {
            System.out.println(i);
        }

    }
}
