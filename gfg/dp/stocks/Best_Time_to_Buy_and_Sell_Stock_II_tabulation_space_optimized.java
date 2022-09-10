package dp.stocks;

/* Best Time to Buy and Sell Stock II */
/* https://www.codingninjas.com/codestudio/problems/selling-stock_630282?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos */

/* Infinite transactions are allowed */

/* TC: O(N)
 * SC: O(4) ~ O(1) = constant */
public class Best_Time_to_Buy_and_Sell_Stock_II_tabulation_space_optimized {

    public static void main(String[] args) {
        // test case 1
        long profit = Best_Time_to_Buy_and_Sell_Stock_II_tabulation_space_optimized.getMaximumProfit(5, new long[]{1, 2, 3, 4, 5});
        System.out.println(profit); // 4
        // test case 2
        profit = Best_Time_to_Buy_and_Sell_Stock_II_tabulation_space_optimized.getMaximumProfit(6, new long[]{7, 1, 5, 3, 6, 4});
        System.out.println(profit); // 7
        // test case 3
        profit = Best_Time_to_Buy_and_Sell_Stock_II_tabulation_space_optimized.getMaximumProfit(10, new long[]{23, 13, 25, 29, 33, 19, 34, 45, 65, 67});
        System.out.println(profit); // 68
        // test case 4
        profit = Best_Time_to_Buy_and_Sell_Stock_II_tabulation_space_optimized.getMaximumProfit(7, new long[]{100, 180, 260, 310, 40, 535, 695});
        System.out.println(profit); // 865
    }

    public static long getMaximumProfit(int n, long[] values) {
        long nextSell = 0;
        long nextBuy = 0;
        long currSell;
        long currBuy = 0;
        for (int index = n - 1; index >= 0; index--) {
            // buy
            long buy = -values[index] + nextSell;
            // dont buy
            long dontBuy = nextBuy;
            currBuy = Math.max(buy, dontBuy);
            // sell
            long sell = values[index] + nextBuy;
            // dont sell
            long dontSell = nextSell;
            currSell = Math.max(sell, dontSell);

            nextBuy = currBuy;
            nextSell = currSell;
        }
        return currBuy;
    }
}
