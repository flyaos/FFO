package yao.exercise;

import java.io.*;
import java.util.HashSet;

/**
 * Created by yao on 2014/10/12.
 * <p/>
 * ThoughtWorks 笔试题
 */
public class TaxCompute {

    /**
     * 免税关键词
     */
    public static HashSet<String> exempts = new HashSet<String>();

    public TaxCompute() {
        exempts.add("chocolate");
        exempts.add("book");
        exempts.add("headache");
        exempts.add("pills");
    }

    /**
     * 添加免税物品的关键词
     */
    public void addExempts(String key) {
        if (!exempts.contains(key)) {
            exempts.add(key);
        }
    }

    /**
     * 移除免税物品的关键词
     */
    public void removeExempts(String key) {
        if (exempts.contains(key)) {
            exempts.remove(key);
        }
    }

    /**
     * 判断是否免税
     */
    public boolean isExempt(String key) {
        return exempts.contains(key) ? true : false;
    }

    /**
     * 是否进口
     */
    public boolean isImported(String key) {
        return key.contains("imported") ? true : false;
    }

    /**
     * 返回当前行的税率
     */
    float getRate(String[] inputs) {
        int len = inputs.length;

        float rate = 0;
        boolean isE = false;
        boolean isI = false;

        for (int i = 1; i < len - 2; i++) {
            if (isExempt(inputs[i]) && !isE) {
                isE = true;
            }
            if (isImported(inputs[i]) && !isI) {
                isI = true;
            }
        }

        if (!isE) {
            rate += 0.1;
        }

        if (isI) {
            rate += 0.05;
        }

        return rate;
    }

    /**
     * 输出一行
     */
    public String getOutPutLine(String[] inputs, float finaPrice) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < inputs.length - 2; i++) {
            sb.append(inputs[i]).append(" ");
        }

        sb.append(": ").append(finaPrice);

        return sb.toString();

    }

    /**
     * 计算并打印输出
     *
     * @throws IOException
     */
    public void calculate() throws IOException {

        String path = "E:\\a.txt";
        BufferedReader br = new BufferedReader(new FileReader(path));
        String line;
        float total = 0;
        float salesTaxes = 0;
        int l = 1;

        while ((line = br.readLine()) != null) {
            if (line.toLowerCase().contains("input")) {
                if (l == 1) {
                    System.out.println("Output " + l);
                }
                if (l > 1) {
                    // 打印上一次计算的结果
                    System.out.println("Sales Taxes: " + salesTaxes);
                    System.out.println("Total:: " + total);

                    // 打印下一次的输出序号
                    System.out.println("Output " + l);

                    //打印完清零
                    total = 0;
                    salesTaxes = 0;
                }
                l++;
            } else {
                // 处理一行
                String[] inputs = line.split(" ");
                int num = Integer.parseInt(inputs[0]);
                float price = Float.parseFloat(inputs[inputs.length - 1]);
                float finaPrice = num * price;

                float rate = getRate(inputs);       // 本行的税率
                finaPrice = finaPrice * (1 + rate); // 本行的最终价格

                // 求和
                salesTaxes += finaPrice - price;
                total += finaPrice;

                // 输出
                String output_line = getOutPutLine(inputs, finaPrice);
                System.out.println(output_line);

            }
        }

        // 最后跳出，最后一次打印
        System.out.println("Sales Taxes: " + salesTaxes);
        System.out.println("Total:: " + total);

    }


    public static void main(String[] args) throws IOException {
        TaxCompute tc = new TaxCompute();
        tc.calculate();

    }


}
