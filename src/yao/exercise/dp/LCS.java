package yao.exercise.dp;

/**
 * Created by yao on 2014/8/29.
 */
public class LCS {


    public static int getLcsLenth(String a, String b) {
        int aLen = a.length();
        int bLen = b.length();
        int[][] maxLength = new int[aLen + 1][bLen + 1];

        // 初始化
        for (int i = 0; i < aLen; i++) {
            maxLength[i][0] = 0;
        }

        for (int j = 0; j < bLen; j++) {
            maxLength[0][j] = 0;
        }

        //i is the current aLen
        //j is the current bLen
        for (int i = 1; i <= aLen; i++) {
            for (int j = 1; j <= bLen; j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    maxLength[i][j] = maxLength[i - 1][j - 1] + 1;
                } else {
                    maxLength[i][j] = Math.max(maxLength[i][j - 1], maxLength[i - 1][j]);
                }
            }
        }

        int max = maxLength[aLen][bLen];
        return max;
    }


    public static void main(String[] args) {

        String a = "yuan";
        String b = "abdfuanyun";
        int maxLength = getLcsLenth(a, b);
        System.out.println(maxLength);
    }

}


