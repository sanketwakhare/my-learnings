package dp.stocks;

/* Best Time to Buy and Sell Stock with Cooldown - V */
/* https://www.codingninjas.com/codestudio/problems/highway-billboards_3125969?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos&leftPanelTab=0 */

/* Unlimited transactions are allowed but cool-down period of one day
i.e. we cannot buy immediately on next after sell day */

/* TC: O(N x 2)
 * SC: O(N x 2) for dp array */
public class Best_Time_to_Buy_and_Sell_Stock_V_tabulation {

    public static void main(String[] args) {
        Best_Time_to_Buy_and_Sell_Stock_V_tabulation t1 =
                new Best_Time_to_Buy_and_Sell_Stock_V_tabulation();
        {
            int[] input = new int[]{4, 5, 2, 10, 1, 15};
            int result = t1.stockProfit(input);
            System.out.println(result); // 15
        }
        {
            int[] input = new int[]{51, 36, 46, 25, 13, 75, 3, 104, 91, 49, 36};
            int result = t1.stockProfit(input);
            System.out.println(result); // 111
        }
    }

    public int stockProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n + 2][2];

        for (int index = n - 1; index >= 0; index--) {
            // buy
            int buy = -prices[index] + dp[index + 1][0];
            // dont buy
            int dontBuy = dp[index + 1][1];
            dp[index][1] = Math.max(buy, dontBuy);

            // sell - now next buy will happen only after 1 day cool-down period
            int sell = prices[index] + dp[index + 2][1];
            // dont sell
            int dontSell = dp[index + 1][0];
            dp[index][0] = Math.max(sell, dontSell);
        }
        return dp[0][1];
    }
}
