package yao.exercise;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by yao on 2014/8/8.
 *
 * 测试 hashMap
 */
public class FindTheSame {
    public static void main(String args[]) {
        HashMap<Integer, Integer> hs = new HashMap<Integer, Integer>();

        int[] test = {1, 2, 3, 4, 5, 6, 7, 8, 7, 8, 13, 7, 8, 5, 4, 5, 5, 5, 5};
        for (int i = 0; i < test.length; i++) {
            if (!hs.containsKey(test[i])) {
                hs.put(test[i], 1);
            } else {
                int num = hs.get(test[i]);
                hs.put(test[i], num + 1);
            }
        }

        Iterator iterator = hs.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> entry = (Map.Entry<Integer, Integer>) iterator.next();
            if (entry.getValue() > 1) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        }

        System.out.println(Math.ceil(5.33));

    }
}
