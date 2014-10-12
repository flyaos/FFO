package yao.exercise;

/**
 * Created by yao on 2014/9/24.
 * <p/>
 * 数组循环移位，循环右移
 */
public class RightShift {

    /**
     * 向右循环移动 K 位；
     * 暴力法，O（K*N）
     */
    public static void rightShift(int[] arr, int k) {
        int N = arr.length;
        while (k > 0) {
            int t = arr[N - 1];
            for (int i = N - 1; i > 0; i--) {
                arr[i] = arr[i - 1];
            }
            arr[0] = t;
        }
    }


}
