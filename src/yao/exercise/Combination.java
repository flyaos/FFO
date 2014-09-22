package yao.exercise;

/**
 * Created by yao on 2014/9/23.
 * <p/>
 * 输出全组合 abc 输出 a b c ab ac bc abc
 * 思路：利用二进制比特位的思想，全排列有 2^n-1 种 (除去 000)
 * 001 c    011 bc     111 abc
 * 010 b    101 ac
 * 100 a    110 ab
 *
 *
 */
public class Combination {

    public static void combination(char[] array) {
        int len = array.length;
        int n = 1 << len;  // 从 1 循环到 2^len
        for (int i = 1; i <= n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < len; j++) {
                int temp = 1 << j;  // temp 变化：1 010 0100 01000
                if ((temp & i) != 0) {
                    sb.append(array[j]);
                }
            }
            System.out.println(sb);
        }

    }

    public static void main(String[] args) {
        String test = "abcd";
        combination(test.toCharArray());
    }
}
