package yao.exercise;

import java.util.HashSet;

/**
 * Created by yao on 2014/8/24.
 */
public class BinarySearch {

    /**
     * 二分查找算法
     *
     * @param array 已排序的数组
     * @param value 待查的值
     * @return 位置信息，-1为未找到
     */
    public static int bindarySearch(int[] array, int value) {
        int n = array.length - 1;
        int left = 0;
        int right = n;
        int mid;
        while (left <= right) {
            // mid = (left + right) / 2;
            mid = left + ((right - left) >> 1); //防止溢出，移位更好
            if (value < array[mid]) {
                right = mid - 1;
            } else if (value > array[mid]) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static int bindarySearch_(int[] array, int value) {
        int n = array.length;
        int left = 0;
        int right = n; //初始化为n，考虑数组长度为1的情况
        int mid;
        while (left < right) {
            // mid = (left + right) / 2;
            mid = left + ((right - left) >> 1); //防止溢出，移位更好
            if (value < array[mid]) {
                right = mid;
            } else if (value > array[mid]) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }



    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        System.out.println(bindarySearch_(a, 9));
        HashSet<Integer> b = new HashSet<Integer>();
    }


}
