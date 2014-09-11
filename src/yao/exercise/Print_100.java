package yao.exercise;

/**
 * Created by yao on 2014/8/25.
 * <p/>
 * 不用循环打印1到100
 */
public class Print_100 {

    public static int result;

    public static int print_100(int n) {
        if (n <= 1) {
            result = n;
        } else {
            result = print_100(n - 1) + 1;
        }
        System.out.println(result);
        return result;
    }

    public static void main(String[] args) {
        print_100(100);
    }
}
