package yao.exercise;

import java.util.HashSet;

/**
 * Created by yao on 2014/8/18.
 *
 * 找到一个字符串中的最大子回文串
 * 注意：可能有多个相同长度的回文，需全部输出
 */

public class FindLargestHui {

    public static int max = 1;
    public static String maxString = "";
    public static HashSet<String> storeList = new HashSet<String>();

    public static HashSet<String> findLargestHui(String str) {
        if (str.length() == 1) {
            storeList.add(str);
        } else {
            int middle = str.length() / 2;
            find(middle, str, true);
            find(middle + 1, str, false);
        }
        return storeList;
    }

    public static void find(int j, String str, boolean isLeft) {
        while (j >= 0 && j < str.length()) {
            int k = 1;
            int k_left = 1;
            int k_right = 1;

            //以j为中心的对称
            while (j - k >= 0 && j + k < str.length()) {
                if (str.charAt(j - k) == str.charAt(j + k)) {
                    k++;
                } else {
                    break;
                }
            }

            // j与左边相邻的比较
            while (j - k_left >= 0 && j + k_left - 1 < str.length() && isLeft) {
                if (str.charAt(j - k_left) == str.charAt(j + k_left - 1)) {
                    k_left++;
                } else {
                    break;
                }
            }

            // j与右边相邻的
            while (j + k_right < str.length() && j - k_right + 1 >= 0 && !isLeft) {
                if (str.charAt(j + k_right) == str.charAt(j - k_right + 1)) {
                    k_right++;
                } else {
                    break;
                }
            }

            /**
             * 分别存回文的长度
             */
            int k_max = (k - 1) * 2 + 1;
            int k_left_max = (k_left - 1) * 2;
            int k_right_max = (k_right - 1) * 2;

            if (k_max >= max) {
                if (k_max == 1)
                    maxString = str.substring(j, j + 1);
                else
                    maxString = str.substring(j - k + 1, j + k);
                if (k_max > max) {
                    max = k_max;
                    storeList.clear(); //清空
                }
                storeList.add(maxString);
            }

            if (k_left_max >= max && isLeft) {
                if (k_left_max == 0)
                    maxString = str.substring(j, j + 1);
                else
                    maxString = str.substring(j - k_left + 1, j + k_left - 1);
                if (k_left_max > max) {
                    max = k_left_max;
                    storeList.clear();
                }
                storeList.add(maxString);
            }

            if (k_right_max >= max && !isLeft) {
                if (k_right_max == 0)
                    maxString = str.substring(j, j + 1);
                else
                    maxString = str.substring(j - k_right + 2, j + k_right);
                if (k_right_max > max) {
                    max = k_right_max;
                    storeList.clear();
                }
                storeList.add(maxString);
            }

            if (isLeft)
                j--;
            else
                j++;
        }
    }

    public static void main(String[] args) {

        String test = "aaaabcdeedfbgggg";
        HashSet<String> resultList = findLargestHui(test);
        System.out.println("ZTest string: " + test);

        for (String str : resultList) {
            System.out.println(str);
        }
    }

}
