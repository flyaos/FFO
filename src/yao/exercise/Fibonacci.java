package yao.exercise;

/**
 * Created by yao on 2014/9/5.
 *
 */
public class Fibonacci {
    /**
     * 方法1：递归
     */
    public static int fibonacci(int n) {
        if (n == 0)
            return 0;
        else if (n == 1)
            return 1;
        else
            return fibonacci(n - 1) + fibonacci(n - 2);
    }

    /**
     * 方法2：循环迭代
     */

    public static int fibonacci_1(int n) {
        int b_1 = 0;
        int b_2 = 1;
        int sum = 0;
        for (int i = 0; i < n - 1; i++) {
            sum = b_1 + b_2;
            b_1 = b_2;
            b_2 = sum;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(fibonacci_1(6));
    }
}
