package yao.exercise;

/**
 * Created by yao on 2014/9/18.
 * <p/>
 * 一个字符串是否包含另外一字符串
 * 1.暴力解法
 * 2.KMP 解法
 */
public class KMP {

    /**
     * 暴力解法
     * 时间复杂度：n^2
     */
    public static boolean contains(String a, String b) {
        boolean con = false;
        char[] arr_a = a.toCharArray();
        char[] arr_b = b.toCharArray();

        for (int i = 0; i < a.length(); i++) {
            if (arr_a[i] == arr_b[0]) {
                for (int j = 1; j < b.length(); j++) {
                    if (arr_a[i + j] != arr_b[j]) {
                        break;
                    }
                    if (j == b.length() - 1) {
                        return true;
                    }
                }
            }

        }

        return con;
    }

    /**
     * 优化版本，KMP算法
     */
    public static boolean kmp(String a, String b) {
        boolean con = false;
        char[] source = a.toCharArray();
        char[] target = b.toCharArray();

        int[] next = getNext(b); // 获取 next 数组
        int j = 0;

        for (int i = 0; i < source.length; i++) {
            //找到匹配的字符时才执行
            while (j > 0 && source[i] != target[j]) {
                //设置为 source 中合适的位置
                j = next[j - 1];
            }
            //找到一个匹配的字符
            if (target[j] == source[i]) {
                j++;
            }
            //匹配到一个，输出结果
            if (j == target.length) {
                return true;
            }
        }

        // 这是更直观的表达
        int m = 0;
        int n = 0;
        while (m < source.length && n < target.length) {
            // 当两个字符相同，就比较下一个, 当n为-1时，要移动的是m，当然n也要归0
            if (source[m] == target[n] || n == -1) {
                m++;
                n++;
            } else {
                n = next[n];
            }
        }

        if (n == target.length) {
            return true;
        }

        return con;
    }

    // 预处理获取 next 数组
    static int[] getNext(String P) {
        char p[] = P.toCharArray();
        int next[] = new int[p.length];

        int k = -1; // 最大前后缀匹配长度
        int j = 0;
        next[0] = -1;

        while (j < p.length) {
            if (k == -1 || p[j] == p[k]) {
                next[++j] = ++k;
            } else {
                k = next[k];
            }
        }

        return next;
    }


    public static void main(String[] args) {
        String a = "a abdabdcdefg";
        String b = "afaaff";

        System.out.println(kmp(a, b));
    }
}
