package yao.exercise;

import java.io.IOException;

/**
 * Created by yao on 2014/9/23.
 * <p/>
 * 全排列
 * 递归的思想
 */
public class Permutation {

    public static void permutation() {

    }

    public static void main(String[] args) {
        System.out.print(">");
        try {
            char s = (char) System.in.read();

            if (s == '\r') {
                char m = (char) System.in.read();
            }
            System.out.println("A" + s + "B");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

