package yao.exercise;

import yao.util.YaoUtils;

/**
 * Created by yao on 2014/9/20.
 * <p/>
 * 只有123这三个数字的序列排序
 * 不可用统计法
 * <p/>
 * 思路：基于快速排序的思想，先以1为基准来快排，一遍后，1在最左边
 * 再以2为主元，将2左边的3全部移到右边
 */
public class Sort123 {

    public static void sort_123(Integer[] data) {
        int i = -1;
        int j = data.length;

        // 第一次以 1 来划分
        while (true) {
            while (data[--j] > 1) {
                if (j == 0)
                    break;
            }

            while (data[++i] == 1) {
                if (i == data.length)
                    break;
            }

            if (i >= j) break;
            YaoUtils.swap(data, i, j);
        }

        i = -1;
        j = data.length;

        // 第二次以 2 来划分
        while (true) {
            while (data[--j] != 2) {
                if (j == 0) break;
            }

            while (data[++i] != 3) {
                if (i == data.length) break;
            }

            if (i >= j) break;
            YaoUtils.swap(data, i, j);
        }
    }


    public static void main(String[] args) {
        Integer[] data = {1, 1, 2, 1, 3, 2, 1, 3};
        sort_123(data);
        System.out.println("");
    }

}
