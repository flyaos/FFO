package yao.exercise.dp;

/**
 * Created by yao on 2014/9/1.
 * <p/>
 * 数组的最大递增子序列的长度 (不需要连续)
 * 来自编程之美 P198
 */
public class LIS {

    public static void main(String[] args) {
        int[] data = {-3, 0, 1, -1, 2, 3, 4, -5, 5, -8, 6};
        int[] res = Lis(data);
        int i = 0;
        for (int a : res) {
            System.out.println("LIS[" + i++ + "]: " + a);
        }
    }

    /**
     * 动态规划
     *
     * @param data
     * @return
     */
    private static int[] Lis(int[] data) {
        int[] LIS = new int[data.length]; // 保存从0到n-1的最长连续递增序列
        for (int i = 0; i < data.length; i++) {
            // 每个初始化为 1，只包含自己
            LIS[i] = 1;
            // 找出当前的 LIS[i] 前面的最长序列
            // 判断里面 LIS[j] + 1 > LIS[i] 保证 LIS[i] 更新最大值
            for (int j = 0; j < i; j++) {
                if (data[i] > data[j] && LIS[j] + 1 > LIS[i]) {
                    LIS[i] = LIS[j] + 1;
                }
            }
        }
        return LIS;
    }

}
