package dp.stocks;

/* Best Time to Buy and Sell Stock IV */
/* https://www.codingninjas.com/codestudio/problems/best-time-to-buy-and-sell-stock_1080698?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos&leftPanelTab=0 */

/* At most k transactions are allowed */

/* TC: O(N x 2 x (k + 1))
 * SC: O(N x 2 x (k + 1)) for dp array + O(N) recursive stack space */
public class Best_Time_to_Buy_and_Sell_Stock_IV_memoization {

    public static void main(String[] args) {
        Best_Time_to_Buy_and_Sell_Stock_IV_memoization t1 =
                new Best_Time_to_Buy_and_Sell_Stock_IV_memoization();
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
        int[][][] dp = new int[n + 1][2][k + 1];
        for (int index = 0; index < n; index++) {
            for (int buy = 0; buy < 2; buy++) {
                for (int cap = 0; cap <= k; cap++) {
                    dp[index][buy][cap] = -1;
                }
            }
        }
        return f(0, 0, k, n, prices, dp);
    }

    private int f(int index, int canBuy, int cap, int n, int[] prices, int[][][] dp) {
        if (index == n || cap == 0) return 0;
        int profit;
        if (dp[index][canBuy][cap] != -1) return dp[index][canBuy][cap];
        if (canBuy == 0) {
            // buy
            int buy = -prices[index] + f(index + 1, 1, cap, n, prices, dp);
            int dontBuy = f(index + 1, 0, cap, n, prices, dp);
            dp[index][0][cap] = profit = Math.max(buy, dontBuy);
        } else {
            int sell = prices[index] + f(index + 1, 0, cap - 1, n, prices, dp);
            int dontSell = f(index + 1, 1, cap, n, prices, dp);
            dp[index][1][cap] = profit = Math.max(sell, dontSell);
        }
        return profit;
    }
}
