package yao.bigdata;

import java.io.*;
import java.util.Random;

/**
 * Created by yao on 2014/8/12.
 *
 * java_study IO通过缓冲流来提高读写效率，普通的字节、字符流都是一个字节一个字符这样读取的，而缓冲流则是将数据先缓冲起来，然后一起写入或者读取出来。
 * 经常使用的是readLine()方法，表示一次读取一行数据。
 */
public class GenNumRunnable implements Runnable {

    private String path;
    private String threadName;
    public static int endNumber = 99999;
    public static int totals = 9000000;

    public GenNumRunnable(String path,String threadName) {
        this.path = path;
        this.threadName = threadName;
    }

    @Override
    public void run() {
        String path = this.path;
        try {
            FileWriter fw = new FileWriter(new File(path));
            BufferedWriter bw1 = new BufferedWriter(fw);
            for (int i = 0; i < totals; i++) {
                int n = new Random().nextInt(endNumber);
                System.out.println(this.threadName + ": " + n);
                bw1.write(String.valueOf(n));
                bw1.newLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}