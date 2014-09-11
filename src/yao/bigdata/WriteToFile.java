package yao.bigdata;

import java.io.IOException;

/**
 * Created by yao on 2014/8/12.
 */
public class WriteToFile {


    /**
     * 写两个文件
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {

        String path_1 = "D:\\1.txt";
        String path_2 = "D:\\2.txt";

        GenNumRunnable gr_1 = new GenNumRunnable(path_1,"_thread_1_");
        Thread thread_1 = new Thread(gr_1);
        thread_1.start();

        GenNumRunnable gr_2 = new GenNumRunnable(path_2,"_thread_2_");
        Thread thread_2 = new Thread(gr_2);
        thread_2.start();


    }
}
