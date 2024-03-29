package dp.stocks.best_time_to_buy_and_sell_2;

/* Best Time to Buy and Sell Stock II */
/* https://www.codingninjas.com/codestudio/problems/selling-stock_630282?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos */

/* Infinite transactions are allowed */

/* TC: O(2^N * N) all possible combinations of either buy or sell + repeated sub-problems will get called N times
 * SC: O(N) recursive stack space */
public class Best_Time_to_Buy_and_Sell_Stock_II_brute_force_recursion {

    public static void main(String[] args) {
        // test case 1
        long profit = Best_Time_to_Buy_and_Sell_Stock_II_brute_force_recursion.getMaximumProfit(5, new long[]{1, 2, 3, 4, 5});
        System.out.println(profit); // 4
        // test case 2
        profit = Best_Time_to_Buy_and_Sell_Stock_II_brute_force_recursion.getMaximumProfit(6, new long[]{7, 1, 5, 3, 6, 4});
        System.out.println(profit); // 7
        // test case 3
        profit = Best_Time_to_Buy_and_Sell_Stock_II_brute_force_recursion.getMaximumProfit(10, new long[]{23, 13, 25, 29, 33, 19, 34, 45, 65, 67});
        System.out.println(profit); // 68
        // test case 4
        profit = Best_Time_to_Buy_and_Sell_Stock_II_brute_force_recursion.getMaximumProfit(7, new long[]{100, 180, 260, 310, 40, 535, 695});
        System.out.println(profit); // 865
    }

    public static long getMaximumProfit(int n, long[] values) {
        // Your code goes here.
        return f(0, true, n, values);
    }

    private static long f(int index, boolean canBuy, int n, long[] values) {
        if (index == n) return 0;
        long profit;
        if (canBuy) {
            // buy
            long buy = -values[index] + f(index + 1, false, n, values);
            // dont buy
            long dontBuy = f(index + 1, true, n, values);
            profit = Math.max(buy, dontBuy);
        } else {
            // sell
            long sell = values[index] + f(index + 1, true, n, values);
            // dont sell
            long dontSell = f(index + 1, false, n, values);
            profit = Math.max(sell, dontSell);
        }
        return profit;
    }
}
