package yao.exercise;

import java.text.DecimalFormat;
import java.util.Random;

/**
 * Created by yao on 2014/9/7.
 * <p/>
 * 模拟汽车与山羊问题
 */
public class MontyHallproblem {
    public static void main(String[] args) {
        Random random = new Random();
        // 山羊是0，汽车是1
        long n = 99999999;
        int switch_hit = 0;
        int no_switch_hit = 0;
        boolean[] a = new boolean[]{false, false, false};
        // 测试n次
        for (int i = 0; i < n; i++) {
            // 随机洗牌的意思
            int car = Math.abs(random.nextInt() % 3);
            a[car] = true;

            // 随便选一个
            int select = Math.abs(random.nextInt() % 3);

            // 坚持不换
            if (a[select])
                no_switch_hit++;

            // 换的情况
            if (!a[select])
                switch_hit++;

            a[car] = false;
        }

        DecimalFormat df = new DecimalFormat("#.######");
        float no_switch_hit_p = (float) no_switch_hit / n;
        float switch_hit_p = (float) switch_hit / n;

        System.out.println("no_switch_hit: " + df.format(no_switch_hit_p));
        System.out.println("switch_hit: " + df.format(switch_hit_p));
    }
}
