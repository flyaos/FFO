package yao.java_study;

import java.util.*;

/**
 * Created by yao on 2014/9/25.
 */
public class FinalTest {

    public static void main(String[] args) {
        HashMap<Integer,Integer> hashMap = new HashMap<Integer, Integer>();
        Collections.sort((java.util.List<Map.Entry<Integer, Integer>>) hashMap,new Comparator<Map.Entry<Integer,Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o1.getKey().compareTo(o2.getKey());
            }
        });

    }
}
