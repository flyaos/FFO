package yao.bigdata;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by yao on 2014/8/12.
 */
public class HashFile {
    public static void main(String[] args) throws IOException {
        String path_1 = "D:\\1.txt";
        String path_2 = "D:\\2.txt";

        String folder_1 = "D:\\1-divide\\";
        String folder_2 = "D:\\3-divide\\";

        // 求出总行数
        FileReader fileReader = new FileReader(new File(path_2));
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        int total = 0;
        HashMap<String, ArrayList<String>> hashMap = new HashMap<String, ArrayList<String>>();
        while (bufferedReader.readLine() != null) {
            total++;
        }
        bufferedReader.close();
        fileReader.close();
        System.out.println(total);

        // Hash 写入文件，100000次缓存一下再写入
        String line;
        int i = 0; // 10000次后重写
        int j = 0; // 最后一次
        FileReader fileReader2 = new FileReader(new File(path_2));
        BufferedReader bufferedReader2 = new BufferedReader(fileReader2);

        while ((line = bufferedReader2.readLine()) != null) {
            int hashCode = Integer.parseInt(line) % 100;
            String key = String.valueOf(hashCode);

            // 每次放入一个hashmap，key是hash得到的值，value是实际数字
            if (hashMap.containsKey(key)) {
                ArrayList<String> al = hashMap.get(key);
                al.add(line);
                hashMap.put(key, al);
            } else {
                ArrayList<String> at = new ArrayList<String>();
                at.add(line);
                hashMap.put(key, at);
            }

            // 100000后写文件
            if (i == 100000 || j == total - 1) {
                System.out.println(j);

                Iterator iterator = hashMap.entrySet().iterator();

                while (iterator.hasNext()) {
                    Map.Entry<String, ArrayList<String>> entry = (Map.Entry<String, ArrayList<String>>) iterator.next();
                    String path = folder_2 + String.valueOf(entry.getKey()) + "_.txt";
                    System.out.println(path);
                    File file = new File(path);

                    if (!file.exists()) {
                        file.createNewFile();
                    }

                    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true));

                    ArrayList<String> al = entry.getValue();
                    Iterator<String> iter = al.iterator();
                    while (iter.hasNext()) {
                        bufferedWriter.write(iter.next());
                        bufferedWriter.newLine();
                        bufferedWriter.flush();
                    }
                }
                i = 0;
                hashMap.clear();

            }

            i++;
            j++;

        }

        bufferedReader.close();
    }
}
