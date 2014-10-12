package yao.exercise;

import java.io.*;
import java.util.HashSet;

/**
 * Created by yao
 * Coding Date: 2014/10/12 01:23:15
 *
 * ThoughtWorks exercise
 *
 */

/**************************************************
 *
 * d:\a.txt just as follows:
 *
     Input 1
     2 book at 12.49
     2 music CD at 14.99
     1 chocolate bar at 0.85
     1 packet of headache pills at 9.75
     1 imported box of chocolate at 10.50
     Input 2
     2 music CD at 14.99
     1 chocolate bar at 0.85
     1 packet of headache pills at 9.75
     Input 3
     2 book at 12.49
     2 music CD at 14.99
     1 chocolate bar at 0.85
     1 imported box of chocolate at 10.50
 *
 *
 ****************************************************
 */

public class TaxCompute {

    /**
     * filter of exempts goods
     */
    public static HashSet<String> exempts = new HashSet<String>();

    public TaxCompute() {
        exempts.add("chocolate");
        exempts.add("book");
        exempts.add("headache");
        exempts.add("pills");
    }

    /**
     * main
     */
    public static void main(String[] args) throws IOException {
        TaxCompute tc = new TaxCompute();
        tc.calculate("E:\\a.txt");

    }

    /**
     * calculate and print
     *
     * @throws IOException
     */
    public void calculate(String path) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader(path));
        String line;
        float total = 0;
        float salesTaxes = 0;
        int l = 1; // input group number

        while ((line = br.readLine()) != null) {
            if (line.toLowerCase().contains("input")) {
                if (l == 1) {
                    System.out.println("Output " + l);
                }
                if (l > 1) {
                    // print previous cal result
                    System.out.println("Sales Taxes: " + salesTaxes);
                    System.out.println("Total:: " + total);

                    // print next output number
                    System.out.println("Output " + l);

                    // clear to zero
                    total = 0;
                    salesTaxes = 0;
                }
                l++;
            } else {
                String[] inputs = line.split(" ");
                int num = Integer.parseInt(inputs[0]);
                float price = Float.parseFloat(inputs[inputs.length - 1]);
                float finaPrice = num * price;

                float rate = getRate(inputs);       // get the rate
                finaPrice = finaPrice * (1 + rate); // the final price

                // make a sum
                salesTaxes += finaPrice - price;
                total += finaPrice;

                printCurrentLine(inputs, finaPrice);

            }
        }

        // break of while, The last time, print the total
        System.out.println("Sales Taxes: " + salesTaxes);
        System.out.println("Total: " + total);

    }

    /**
     * add exempts keywords
     */
    public void addExempts(String key) {
        if (!exempts.contains(key)) {
            exempts.add(key);
        }
    }

    /**
     * remove exempts keywords
     */
    public void removeExempts(String key) {
        if (exempts.contains(key)) {
            exempts.remove(key);
        }
    }

    /**
     * whether is exempts
     */
    public boolean isExempt(String key) {
        return exempts.contains(key) ? true : false;
    }

    /**
     * whether is imported
     */
    public boolean isImported(String key) {
        return key.contains("imported") ? true : false;
    }

    /**
     * calculate the total rate of a row of item
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
     * print current line after cal
     */
    public void printCurrentLine(String[] inputs, float finaPrice) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < inputs.length - 2; i++) {
            sb.append(inputs[i]).append(" ");
        }

        sb.append(": ").append(finaPrice);

        System.out.println(sb.toString());

    }


}
