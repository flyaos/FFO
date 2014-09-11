package yao.sort;

/**
 * Created by yao on 2014/8/13.
 */
public class ShellSort {

    /**
     * 希尔排序
     *
     * @param a 待排数组
     * @param N 增量
     */
    public static void shellSort(int[] a, int N) {

        int i, j, gap;

        //步长
        for (gap = N / 2; gap > 0; gap /= 2) {
            //直接插入排序
            for (i = 0; i < gap; i++) {
                for (j = i + gap; j < N; j = j + gap) {
                    if (a[j] < a[j - gap]) {
                        int key = a[j];
                        int k = j - gap; //当前待比较的前一个
                        while (k > 0 && key < a[k]) {
                            a[k + 1] = a[k];
                            k = k - gap;
                        }

                        a[k + gap] = key;
                    }
                }
            }
        }

    }


    public static void main(String[] args) {
        int[] a = {5, 4, 3, 2, 1, 5, 3, 6};
        shellSort(a, a.length);
        for (int i : a) {
            System.out.println(i);
        }
    }
}
