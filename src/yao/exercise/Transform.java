package yao.exercise;

/**
 * Created by yao on 2014/9/15.
 * 腾讯笔试题
 * 将 10 进制转换为 36 进制的数；
 * 四位四位一输出
 */
public class Transform {

    public static String transform(int data) {
        String str = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        char[] symbol = str.toCharArray();

        StringBuilder sb = new StringBuilder();
        while (data >= 36) {
            int i = data % 36;
            data = data / 36;
            sb.append(symbol[i]);
        }
        sb.append(symbol[data]);
        return sb.toString();
    }

    public static void main(String[] args) {

        String test = transform(2000000000);
        char[] array = test.toCharArray();
        int j = array.length % 4;
        StringBuilder sb = new StringBuilder();
        int k = 0;
        for (int i = array.length - 1; i >= 0; i--, k++) {
            if (k == j && j != 0) {
                sb.append(' ');
            }

            sb.append(array[i]);

            if ((k - j) % 4 == 0 && (k - j) >= 4) {
                sb.append(' ');
            }
        }

        System.out.println(sb.toString());
    }

}
