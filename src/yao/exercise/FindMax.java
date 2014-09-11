package yao.exercise;

/**
 * Created by yao on 2014/6/29.
 *
 * 计算最大子数组之和
 */
public class FindMax {

    private int start;
    private int end;

    // 计算最大子数组之和
    public int findMax(int[] array) {
        int max = array[0];
        int i = 0;
        int j;
        while (i < array.length) {
            if (array[i] < 0) {
                max = array[i] > max ? array[i] : max;
                i++;
            } else if (array[i] >= 0) {
                int tempMax = array[i];
                j = i + 1;
                while (j < array.length && array[j] >= 0) {
                    tempMax = tempMax + array[j++];
                    i++;
                }
                i++;
                max = tempMax > max ? tempMax : max;
            }

        }
        return max;
    }

    // 计算最大子数组之和,并给出子数组具体位置
    // 若遇到连续负数，则取最大一个就可以了
    // 若遇到连续的正数，则要连加
    public int findMaxWithPositions(int[] array) {
        int max = array[0];
        int j;
        int start = 0;
        int end = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 0) {
                if (array[i] > max) {
                    max = array[i];
                    start = i;
                    end = i;
                }
            } else if (array[i] >= 0) {
                int tempMax = array[i];
                int start_backup = i;
                j = i + 1;
                while (j < array.length && array[j] >= 0) {
                    tempMax += array[j++];
                    i++;
                }
                if (tempMax > max) {
                    start = start_backup;
                    end = i;
                    max = tempMax;
                }
            }
        }
        this.setStart(start);
        this.setEnd(end);
        return max;
    }


    public static void main(String args[]) {
        int[] array = {0, -55, -55, 53, 6, -6, 691, 256, 9, 84, -4, 6, 15, -3, 12, 55, -77, 9, 555, -5, 0};
        FindMax test = new FindMax();
        System.out.println("Max: " + test.findMax(array));

        System.out.println("============================================");

        int result = test.findMaxWithPositions(array);
        int start = test.getStart() + 1;
        int end = test.getEnd() + 1;
        System.out.println("Max: " + result + "\nfrom: " + start + "-" + end);
        System.out.println("the subArray is: ");
        for (int i = start-1; i <= end-1; i++) {
            System.out.print(array[i] + " ");
        }
    }


    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }
}
