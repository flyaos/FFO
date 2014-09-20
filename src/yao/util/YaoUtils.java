package yao.util;

/**
 * Created by yao on 2014/9/20.
 */
public class YaoUtils<T> {

    public static <T> void swap(T[] data, int i, int j) {
        T tmp = data[i];
        data[i] = data[j];
        data[j] = tmp;
    }
}
