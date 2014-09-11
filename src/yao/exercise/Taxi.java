package yao.exercise;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Created by yao on 2014/8/8.
 */
public class Taxi {

    public static void main(String args[]) {
        System.out.println("please input:");
        Scanner sc = new Scanner(System.in);
        String con = sc.nextLine();

        float distance = Float.parseFloat(con.split(" ")[0]);
        int time = Integer.parseInt(con.split(" ")[1]);

        double startPrice = 6.0; //起步价
        double priceByDistance; //按距离算的费用
        double priceByTime; // 按时间算的费用
        double finalPrice = 0; // 最终费用

        if (time <= 0 || distance < 0) {
            System.out.println("error,input again");
        } else {
            if (time < 10 && distance <= 2) {
                finalPrice = startPrice;
            } else {
                if (distance <= 7) {
                    if (distance <= 2) {
                        priceByDistance = startPrice + Math.round(distance) * 2 * 0.7;
                    } else {
                        double dis = distance - 2;
                        double disInt = Math.round(dis);
                        priceByDistance = startPrice + disInt * 2 * 0.7;
                    }
                } else {
                    priceByDistance = startPrice + 2 * 7 * 0.7 + Math.floor(distance - 7 - 2) * 0.7 * 3;
                }

                int times = time / 3;
                priceByTime = startPrice + times * 1.4;

                finalPrice = (priceByDistance > priceByTime ? priceByDistance : priceByTime);
            }


        }
        DecimalFormat myFormmat = new DecimalFormat("0.0");
        myFormmat.format(finalPrice);


        System.out.println(finalPrice);

    }
}
