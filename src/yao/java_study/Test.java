package yao.java_study;

/**
 * Created by yao on 2014/8/18.
 */
public class Test {

    public static void main(String[] args) {

        /**
         * 字符串相关
         */
        System.out.println("abc".substring(0, 3));// endIndex 的最大值为字符串的长度,第二个参数3是偏移量
        String a = new String("abc".toCharArray(), 0, 3); // 上面等价于
        System.out.println(a);

        /**
         * 移位操作
         */
        System.out.println(4 >> 1); // 右移1位，相当于除2
        System.out.println(2 + 4 >> 1); // 移位符 >> 的优先级很低，所以结果等价位 （2+4）>> 2
        System.out.println(4 << 2);

    }
}
