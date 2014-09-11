package yao.bigdata;

import java.io.*;
import java.util.HashSet;
import java.util.Iterator;

/**
 * Created by yao on 2014/8/12.
 * 将对应的两个文件中相同的数抽出到一个文件中
 *
 */
public class CombineSame {

    public static void main(String[] args) throws IOException {
        String path_1 = "D:\\1-divide\\";
        String path_2 = "D:\\2-divide\\";
        String destPath = "D:\\1-2-combine\\";


        for (int i = 0; i < 100; i++) {
            String p = i + "_.txt";
            BufferedReader br_1 = new BufferedReader(new FileReader(new File(path_1 + p)));
            BufferedReader br_2 = new BufferedReader(new FileReader(new File(path_2 + p)));

            String line_1;
            HashSet<String> set_1 = new HashSet<String>();
            HashSet<String> result = new HashSet<String>();

            while ((line_1 = br_1.readLine()) != null) {
                set_1.add(line_1);
            }
            br_1.close();

            String line_2;

            while ((line_2 = br_2.readLine()) != null) {
                if (set_1.contains(line_2)) {
                    result.add(line_2);
                }
            }
            br_2.close();

            String destFile = destPath + i + "_.txt";
            BufferedWriter bw = new BufferedWriter(new FileWriter(new File(destFile), true));

            Iterator<String> iterator = result.iterator();
            while (iterator.hasNext()) {
                bw.write(iterator.next());
                bw.newLine();
                bw.flush();
            }
            bw.close();
        }
    }
}
