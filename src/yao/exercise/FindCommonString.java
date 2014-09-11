package yao.exercise;

import java.util.ArrayList;

/**
 * Created by yao on 2014/8/14.
 */
public class FindCommonString {

    /**
     * 华为机试3：求两个串的公用子序列
     *
     * @param a 源串
     * @param b 待比较都串，支持通配符，？代表一个字符
     */
    public static String find(String a, String b) {

        ArrayList<String> as = new ArrayList<String>();

        //将源字符串中的对应位置替换为？
        for (int i = 0; i < b.length(); i++) {
            if (b.charAt(i) == '?') {
                System.out.println(i);
                if (i <= a.length()) {
                    a = a.substring(0, i) + "?" + a.substring(i + 1, a.length());
                }
            }
        }

        //对比,提取所有公共子串
        for (int i = 0; i < b.length(); i++) {
            int j = i + 1;
            String m;
            while (true) {
                m = b.substring(i, j);
                if (a.contains(m)) {
                    j++;
                } else {
                    break;
                }
                if (j == b.length() + 1) break;
            }

            if (j - 1 != i) {
                as.add(m);
            }
        }

        // 求出最长的那个
        String result = "";
        for (String str : as) {
            if (str.length() > result.length()) {
                result = str;
            }
        }
        return result;

    }

    public static void main(String[] args) {
        String a = "abcddgeg";
        String b = "aeb?c?d";


        String result = find(a, b);
        System.out.println(result);

    }

}
