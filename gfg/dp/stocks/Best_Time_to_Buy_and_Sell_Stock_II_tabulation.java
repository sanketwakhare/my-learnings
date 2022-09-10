package dp.stocks;

/* Best Time to Buy and Sell Stock II */
/* https://www.codingninjas.com/codestudio/problems/selling-stock_630282?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos */

import java.util.Arrays;

public class Best_Time_to_Buy_and_Sell_Stock_II_tabulation {

    public static void main(String[] args) {
        // test case 1
        long profit = Best_Time_to_Buy_and_Sell_Stock_II_tabulation.getMaximumProfit(5, new long[]{1, 2, 3, 4, 5});
        System.out.println(profit); // 4
        // test case 2
        profit = Best_Time_to_Buy_and_Sell_Stock_II_tabulation.getMaximumProfit(6, new long[]{7, 1, 5, 3, 6, 4});
        System.out.println(profit); // 7
        // test case 3
        profit = Best_Time_to_Buy_and_Sell_Stock_II_tabulation.getMaximumProfit(10, new long[]{23, 13, 25, 29, 33, 19, 34, 45, 65, 67});
        System.out.println(profit); // 68
        // test case 4
        profit = Best_Time_to_Buy_and_Sell_Stock_II_tabulation.getMaximumProfit(7, new long[]{100, 180, 260, 310, 40, 535, 695});
        System.out.println(profit); // 865
    }

    public static long getMaximumProfit(int n, long[] values) {
        long[][] dp = new long[n + 1][2];
        for (long[] row : dp) {
            Arrays.fill(row, -1);
        }
        dp[n][0] = 0;
        dp[n][1] = 0;
        for (int index = n - 1; index >= 0; index--) {
            // buy
            long buy = -values[index] + dp[index + 1][0];
            // dont buy
            long dontBuy = dp[index + 1][1];
            dp[index][1] = Math.max(buy, dontBuy);
            // sell
            long sell = values[index] + dp[index + 1][1];
            // dont sell
            long dontSell = dp[index + 1][0];
            dp[index][0] = Math.max(sell, dontSell);
        }
        return dp[0][1];
    }
}
