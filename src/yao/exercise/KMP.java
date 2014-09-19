package yao.exercise;

/**
 * Created by yao on 2014/9/18.
 */
public class KMP {

    public static boolean contains(String a, String b) {
        boolean con = false;
        char[] arr_a = a.toCharArray();
        char[] arr_b = b.toCharArray();

        for (int i = 0; i < a.length(); i++) {
            if (arr_a[i] == arr_b[0]) {
                for (int j = 1; j < b.length(); j++) {
                    if (arr_a[i + j] != arr_b[j]) {
                        i = i - getNext(a.substring(i, i + j));
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

    private static int getNext(String substring) {
        return 0;
    }

    public static void main(String[] args) {
        String a = "a abdabdcdefg";
        String b = "abdc";

        System.out.println(contains(a, b));
    }
}
