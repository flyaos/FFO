package yao.exercise.dp;

/**
 * Created by yao on 2014/9/1.
 * 求最长公共子序列（不需要连续）LCS
 * 注：最长公共子串需要连续
 */
public class LeastChar4Huiwen {

    public static void main(String[] args) {
        String testStr = "afdsafsdgag24gehfsdfhagfdafdffffffffffffsahfhsbtwhwvaab";
        int re = fmiDP(testStr.toCharArray(), testStr.length());
        System.out.println("DP method: " + re);
        int result = getLeastChar4HuiWen(testStr);
        System.out.println("recursive method:" + result);
    }

    private static int getLeastChar4HuiWen(String testStr) {
        char[] chars = testStr.toCharArray();
        int length = chars.length;
        return getLeastNumbers(chars, 0, length - 1);
    }

    /**
     * 递归解法
     * @param chars 字符数组列表
     * @param start 开始
     * @param end 最后
     * @return
     */
    private static int getLeastNumbers(char[] chars, int start, int end) {
        if (start > end)
            return 0;
        else if (chars[start] == chars[end])
            return getLeastNumbers(chars, start + 1, end - 1);
        else
            return 1 + Math.min(getLeastNumbers(chars, start, end - 1), getLeastNumbers(chars, start + 1, end));
    }

    /**
     * 动态规划解法
     */
    private static int fmiDP(char[] str, int n) {
        //二维数组保存子问题的解，table[i][j]表示str[i,j]转换为回文，需要插入的最少字符数。
        int table[][] = new int[n][n];
        int l, h, gap;

        // 外层循环，gap从小到大
        for (gap = 1; gap < n; ++gap)
            for (l = 0, h = gap; h < n; ++l, ++h)
                table[l][h] = (str[l] == str[h]) ? table[l + 1][h - 1] :
                        (Math.min(table[l][h - 1], table[l + 1][h]) + 1);
        return table[0][n - 1];
    }
}
