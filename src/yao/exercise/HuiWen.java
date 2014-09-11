package yao.exercise;

import java.util.Scanner;

/**
 * Created by yao on 2014/8/10.
 *
 * 判断回文
 */
public class HuiWen {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();

        String a_String = "" + a;
        int length = a_String.length();
        boolean huiwen =  true;
        if(length > 1) {
            int end = (int) (Math.ceil(length/2) - 1);
            for(int i = 0; i <= end ; i++) {
                if(a_String.charAt(i) != a_String.charAt(length - i - 1)) {
                    huiwen = false;
                    break;
                }
            }
        }

        if(huiwen)
            System.out.println("是回文:");
        else
            System.out.println("不是回文:");
    }
}
