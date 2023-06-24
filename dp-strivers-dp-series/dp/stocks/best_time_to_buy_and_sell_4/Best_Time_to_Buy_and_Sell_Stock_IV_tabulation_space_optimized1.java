package dp.stocks.best_time_to_buy_and_sell_4;

/* Best Time to Buy and Sell Stock IV */
/* https://www.codingninjas.com/codestudio/problems/best-time-to-buy-and-sell-stock_1080698?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos&leftPanelTab=0 */

/* At most k transactions are allowed */

/* TC: O(N x 2 x (k + 1))
 * SC: O(2 x 2 x (k + 1)) ~ O(4k) ~ O(k) for dp array */
public class Best_Time_to_Buy_and_Sell_Stock_IV_tabulation_space_optimized1 {

    public static void main(String[] args) {
        Best_Time_to_Buy_and_Sell_Stock_IV_tabulation_space_optimized1 t1 =
                new Best_Time_to_Buy_and_Sell_Stock_IV_tabulation_space_optimized1();
        {
            int[] input = new int[]{8, 5, 1, 3, 10};
            int k = 2;
            int result = t1.maximumProfit(input, input.length, k);
            System.out.println(result); // 9
        }
        {
            int[] input = new int[]{2, 4, 8, 11, 15, 18, 14, 25};
            int k = 4;
            int result = t1.maximumProfit(input, input.length, k);
            System.out.println(result); // 27
        }
    }

    public int maximumProfit(int[] prices, int n, int k) {
        int[][][] dp = new int[2][2][k + 1];
        for (int index = n - 1; index >= 0; index--) {
            for (int canBuy = 0; canBuy < 2; canBuy++) {
                for (int cap = k; cap >= 1; cap--) {
                    if (canBuy == 0) {
                        // buy
                        int buy = -prices[index] + dp[1][1][cap];
                        int dontBuy = dp[1][0][cap];
                        dp[0][0][cap] = Math.max(buy, dontBuy);
                    } else {
                        int sell = prices[index] + dp[1][0][cap - 1];
                        int dontSell = dp[1][1][cap];
                        dp[0][1][cap] = Math.max(sell, dontSell);
                    }
                }
            }
            dp[1] = dp[0];
        }
        return dp[0][0][k];
    }
}
