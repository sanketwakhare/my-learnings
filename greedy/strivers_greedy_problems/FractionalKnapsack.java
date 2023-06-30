package strivers_greedy_problems;

import java.util.Arrays;

/**
 * Fractional Knapsack
 *
 * <a href="https://www.codingninjas.com/studio/problems/975286">Fractional Knapsack</a>
 */
public class FractionalKnapsack {

    public static void main(String[] args) {
        // test 1
        int n1 = 6;
        int w1 = 200;
        Pair[] items1 = new Pair[n1];
        items1[0] = new Pair(50, 40);
        items1[1] = new Pair(40, 50);
        items1[2] = new Pair(90, 25);
        items1[3] = new Pair(120, 100);
        items1[4] = new Pair(10, 30);
        items1[5] = new Pair(200, 45);
        System.out.println(maximumValue(items1, n1, w1)); // 204.0

        // test 2
        int n2 = 5;
        int w2 = 100;
        Pair[] items2 = new Pair[n2];
        items2[0] = new Pair(20, 12);
        items2[1] = new Pair(24, 35);
        items2[2] = new Pair(36, 41);
        items2[3] = new Pair(40, 25);
        items2[4] = new Pair(42, 32);
        System.out.println(maximumValue(items2, n2, w2)); // 106.48

    }

    public static double maximumValue(Pair[] items, int n, int w) {
        // sort by descending order of weights per unit
        Arrays.sort(items, (a, b) -> {
            double a_wtPerUnit = (double) a.value / (double) a.weight;
            double b_wtPerUnit = (double) b.value / (double) b.weight;
            if (b_wtPerUnit > a_wtPerUnit) return 1;
            if (b_wtPerUnit < a_wtPerUnit) return -1;
            return 0;
        });

        double maxValue = 0;
        double currWeight = 0;
        for (int i = 0; i < n; i++) {
            Pair currentItem = items[i];
            if (currWeight + currentItem.weight <= w) {
                // if can fit entire item
                currWeight += currentItem.weight;
                maxValue += currentItem.value;
            } else {
                double units = w - currWeight;
                if (units > 0) {
                    currWeight += units;
                    maxValue += ((double) currentItem.value / (double) currentItem.weight) * units;
                }
            }
        }
        return maxValue;
    }

    static class Pair {
        int weight;
        int value;

        Pair(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }

    }
}
