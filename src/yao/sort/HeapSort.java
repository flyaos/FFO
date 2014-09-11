package yao.sort;

/**
 * Created by yao on 2014/8/28.
 * <p/>
 * 堆排序，构建最大堆 MaxHeap
 */
public class HeapSort {

    private int[] heap;
    private int heapSize;

    /**
     * 构造函数
     *
     * @param A
     */
    public HeapSort(int[] A) {
        this.heap = A;
        this.heapSize = A.length;
    }

    /**
     * 堆排序
     *
     * 方法：每次把最后一个与第一个元素（根元素）交换
     * 交换后，数组长度减1，从第一个元素维护最大堆的性质
     * 直到数组长度
     *
     * 时间复杂度：O(nLgn)
     */
    public void heapSort() {
        for (int i = heapSize; i > 0; i--) {
            swap(0, i - 1);
            heapSize--;
            maxHeapify(0);
        }
    }


    /**
     * 维护最大堆的性质
     * 时间复杂度：O(Lg(n)), 树的高度
     *
     * @param i 位
     */
    public void maxHeapify(int i) {
        int left = getLeftChild(i);
        int right = getRightChild(i);
        int max;
        if (left < heapSize && heap[left] > heap[i]) {
            max = left;
        } else {
            max = i;
        }
        if (right < heapSize && heap[right] > heap[max]) {
            max = right;
        }
        if (max != i) {
            swap(i, max);
            maxHeapify(max);
        }

    }

    /**
     * 建堆：最大堆
     * 方法：从第size/2 到第一个依次恢复堆的性质
     * 时间复杂度：O(n)
     */
    public void bulidMaxHeap() {

        for (int i = heapSize / 2; i >= 0; i--) {
            maxHeapify(i);
        }

    }


    public void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }


    public int getLeftChild(int i) {
        return 2 * i + 1;
    }

    public int getRightChild(int i) {
        return (i + 1) * 2;
    }

    public int getParent(int i) {
        return (i - 1) / 2;
    }

    public static void main(String args[]) {
        int[] testArray = {4, 3, 10, 6, 2, 9, 2, 7, 8, 22};
        HeapSort heapSort = new HeapSort(testArray);
        System.out.println("初始的堆结构：");
        printHeapTree(heapSort.heap);

        heapSort.bulidMaxHeap();
        System.out.println("建堆后的结构：");
        printHeapTree(heapSort.heap);

        heapSort.heapSort();
        System.out.println("排序后");
        printHeap(heapSort.heap);

    }

    // 打印树的结构
    private static void printHeapTree(int[] array) {
        for (int i = 1; i < array.length; i = i * 2) {
            for (int k = i - 1; k < 2 * (i) - 1 && k < array.length; k++) {
                System.out.print(array[k] + " ");
            }
            System.out.println();
        }
    }

    // 打印数组
    private static void printHeap(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }


}
