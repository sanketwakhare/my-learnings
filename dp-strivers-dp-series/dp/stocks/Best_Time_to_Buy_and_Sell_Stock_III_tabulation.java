package dp.stocks;

/* Best Time to Buy and Sell Stock III */
/* https://www.codingninjas.com/codestudio/problems/buy-and-sell-stock_1071012?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos */

/* At most 2 transactions are allowed */

import java.util.ArrayList;
import java.util.List;

/* TC: O(N x 2 x 3)
 * SC: O(N x 2 x 3) for dp array */
public class Best_Time_to_Buy_and_Sell_Stock_III_tabulation {

    public static void main(String[] args) {
        Best_Time_to_Buy_and_Sell_Stock_III_tabulation t1 =
                new Best_Time_to_Buy_and_Sell_Stock_III_tabulation();
        {
            ArrayList<Integer> input = new ArrayList<>(List.of(3, 3, 5, 0, 3, 1, 4));
            int result = t1.maxProfit(input, input.size());
            System.out.println(result); // 6
        }
        {
            ArrayList<Integer> input = new ArrayList<>(List.of(7, 13, 18, 3, 8, 4, 10, 15, 12, 15));
            int result = t1.maxProfit(input, input.size());
            System.out.println(result); // 23
        }
    }

    public int maxProfit(ArrayList<Integer> prices, int n) {
        // 2 transactions cap is allowed
        int k = 2;
        int[][][] dp = new int[n + 1][2][k + 1];

        // traversal
        for (int index = n - 1; index >= 0; index--) {
            for (int canBuy = 0; canBuy < dp[index].length; canBuy++) {
                for (int cap = k; cap > 0; cap--) {
                    if (canBuy == 0) {
                        // if buy is possible
                        int buy = -prices.get(index) + dp[index + 1][1][cap];
                        int dontBuy = dp[index + 1][0][cap];
                        dp[index][0][cap] = Math.max(buy, dontBuy);
                    } else {
                        // if sell is possible
                        int sell = prices.get(index) + dp[index + 1][0][cap - 1];
                        int dontSell = dp[index + 1][1][cap];
                        dp[index][1][cap] = Math.max(sell, dontSell);
                    }
                }
            }
        }
        return dp[0][0][k];
    }
}
