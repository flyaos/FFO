package yao.exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by yao on 2014/9/5.
 * <p/>
 * 求一个序列里前 K 大的数集合
 * 方法1：快速划分递归
 * 方法2：最小堆
 */
public class TopK {

    static final ArrayList<Integer> emptyList = new ArrayList<Integer>();

    /**
     * 类似于快速排序递归划分
     * 时间复杂度：O（N*Lg(k)）
     *
     * @param S 原始序列
     * @param k 前 k 个数
     * @return
     */
    private static ArrayList<Integer> topK(ArrayList<Integer> S, int k) {

        // 递归结束条件
        if (k <= 0) {
            return emptyList;
        }
        if (S.size() <= k)
            return S;

        S_a_b s_a_b = Partition(S);

        ArrayList<Integer> arrayList = topK(s_a_b.Sa, k);
        ArrayList<Integer> b_list = topK(s_a_b.Sb, k - s_a_b.Sa.size());

        if (b_list.size() > 0) {
            arrayList.addAll(b_list);
        }

        return arrayList;

    }

    /**
     * 划分成 Sa Sb 使得 Sa > x, Sb < x
     *
     * @param S
     * @return
     */
    private static S_a_b Partition(ArrayList<Integer> S) {

        S_a_b s_a_b = new S_a_b();

        int x = S.get(0);
        for (int i = 1; i < S.size(); i++) {
            if (S.get(i) > x) {
                s_a_b.add2Sa(S.get(i));
            } else s_a_b.add2Sb(S.get(i));
        }

        if (s_a_b.Sa.size() <= s_a_b.Sb.size())
            s_a_b.add2Sa(x);
        else {
            s_a_b.add2Sb(x);
        }

        return s_a_b;
    }

    public int[] heapTree;

    /**
     * 方法2：维护一个 K 的最小堆
     */
    public void heapSelect(int[] array, int k) {
        this.heapTree = new int[k];

        for (int i = 0; i < k; i++) {
            this.heapTree[i] = array[i];
        }

        // 将上面初始化的数组建为最小堆
        for (int i = k / 2; i >= 0; i--) {
            MinHeap(i);
        }

        // 从第 k+1 位遍历数组，
        for (int i = k; i < array.length; i++) {
            if (array[i] > heapTree[0]) {
                heapTree[0] = array[i];
                MinHeap(0);
            }
        }
    }

    /**
     * 维护最小堆的性质
     * @param i 从哪个节点开始
     */
    private void MinHeap(int i) {
        int min = i;
        int left = 2 * i + 1; // 左孩子
        int right = (i + 1) * 2; // 右孩子
        if (left < heapTree.length && heapTree[left] < heapTree[i]) {
            min = left;
        }
        if (right < heapTree.length && heapTree[right] < heapTree[min]) {
            min = right;
        }
        if (min != i) {
            int tmp = heapTree[i];
            heapTree[i] = heapTree[min];
            heapTree[min] = tmp;
            MinHeap(min);
        }

    }

    public static class S_a_b {
        public ArrayList<Integer> Sa = new ArrayList<Integer>();
        public ArrayList<Integer> Sb = new ArrayList<Integer>();

        public void add2Sa(int a) {
            this.Sa.add(a);
        }

        public void add2Sb(int b) {
            this.Sb.add(b);
        }

    }

    public static void main(String[] args) {
        // ArrayList 怎么初始化 先声明一个List
        // ArrayList<Integer> t = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 5));
        List<Integer> list = Arrays.asList(1, 2, 3, 5, 3, 6, 3, 6, 7, 8);
        ArrayList<Integer> testList = new ArrayList<Integer>(list);
        for (int a : topK(testList, 5)) {
            System.out.println(a);
        }

        System.out.println("--------------------heap method--------------------");

        int[] a = {1, 2, 3, 5, 3, 6, 3, 6, 7, 8};
        TopK testHeap = new TopK();
        testHeap.heapSelect(a, 5);
        for (int b : testHeap.heapTree) {
            System.out.println(b);
        }

    }

}
