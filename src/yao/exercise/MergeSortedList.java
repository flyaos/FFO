package yao.exercise;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created by yao on 2014/8/24.
 * <p/>
 * 求几个排好序的 list 的交集
 */
public class MergeSortedList {

    public static ArrayList<Integer> mergeSortedList(ArrayList<ArrayList<Integer>> lists) {

        HashSet<Integer> hashSet = new HashSet<Integer>();
        for (int i : lists.get(0)) {
            hashSet.add(i);
        }

        HashSet<Integer> res = new HashSet<Integer>();
        //遍历每个list
        for (int j = 1; j < lists.size(); j++) {
            for (int k : lists.get(j)) {
                if (hashSet.contains(k)) {
                    res.add(k);
                }
            }
            hashSet = (HashSet<Integer>) res.clone();
            res.clear();
        }

        ArrayList<Integer> result = new ArrayList<Integer>();
        for (int i : hashSet) {
            result.add(i);
        }

        return result;

    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> l_1 = new ArrayList<Integer>();
        ArrayList<Integer> l_2 = new ArrayList<Integer>();
        ArrayList<Integer> l_3 = new ArrayList<Integer>();
        int[] a1 = {1, 2, 3, 4, 5};
        int[] a2 = {2, 4, 5, 8, 9};
        int[] a3 = {3, 4, 5, 10, 11, 13};
        for (int i : a1) {
            l_1.add(i);
        }

        for (int i : a2) {
            l_2.add(i);
        }

        for (int i : a3) {
            l_3.add(i);
        }

        lists.add(l_1);
        lists.add(l_2);
        lists.add(l_3);

        for (int i : mergeSortedList(lists)) {
            System.out.println(i);
        }


    }
}
