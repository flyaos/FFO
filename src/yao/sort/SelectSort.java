package yao.sort;

/**
 * Created by yao on 2014/8/13.
 */
public class SelectSort {

    /**
     * 选择排序
     * 先比较找出最小的，再交换
     * 事件复杂度：O(n方)，空间复杂度 O(1)
     * 稳定否：不稳定 比如 5 8 5 3 第一次：第1个5和最后的3交换
     *
     * @param a
     */
    public static void selectSort(int a[]) {

        for (int i = 0; i < a.length; i++) {
            int min = a[i];
            int j = i + 1;
            int k = i;
            while (j < a.length && k < a.length) {
                if (a[j] < min) {
                    min = a[j];
                    k = j; // k 记录最小数的地址
                }
                j++;
            }

            // 交换当前i与最小值的位置
            // 如果当前值为最小值也就是不需要交换
            if (k != i) {
                int tmp = a[i];
                a[i] = a[k];
                a[k] = tmp;
            }

        }

    }
}
