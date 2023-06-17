package dp.stocks;

/* Best Time to Buy and Sell Stock with Transaction Fee - VI */
/* https://www.codingninjas.com/codestudio/problems/rahul-and-his-chocolates_3118974?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos&leftPanelTab=0 */

/* Unlimited transactions are allowed but there is transaction fee charged after successful transaction
 * i.e. Buy + Sell = Transaction */

/* TC: O(N x 2)
 * SC: O(N x 2) for dp array */
public class Best_Time_to_Buy_and_Sell_Stock_VI_tabulation {

    public static void main(String[] args) {
        Best_Time_to_Buy_and_Sell_Stock_VI_tabulation t1 =
                new Best_Time_to_Buy_and_Sell_Stock_VI_tabulation();
        {
            int[] input = new int[]{6, 3, 1, 3, 5, 6};
            int fee = 2;
            int result = t1.maximumProfit(input.length, fee, input);
            System.out.println(result); // 3
        }
        {
            int[] input = new int[]{3, 5, 32, 5, 5, 3};
            int fee = 4;
            int result = t1.maximumProfit(input.length, fee, input);
            System.out.println(result); // 25
        }
    }

    public int maximumProfit(int n, int fee, int[] prices) {
        int[][] dp = new int[n + 2][2];

        for (int index = n - 1; index >= 0; index--) {
            // buy
            int buy = -prices[index] + dp[index + 1][0];
            // dont buy
            int dontBuy = dp[index + 1][1];
            dp[index][1] = Math.max(buy, dontBuy);

            // sell
            int sell = prices[index] - fee + dp[index + 1][1];
            // dont sell
            int dontSell = dp[index + 1][0];
            dp[index][0] = Math.max(sell, dontSell);
        }
        return dp[0][1];
    }
}
