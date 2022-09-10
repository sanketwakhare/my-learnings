package dp.stocks;

/* Best Time to Buy and Sell Stock III */
/* https://www.codingninjas.com/codestudio/problems/buy-and-sell-stock_1071012?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos */

/* At most 2 transactions are allowed */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* TC: O(N x 2 x 3)
 * SC: O(N x 2 x 3) for dp array + O(N) recursive stack space */
public class Best_Time_to_Buy_and_Sell_Stock_III_memoization {

    public static void main(String[] args) {
        Best_Time_to_Buy_and_Sell_Stock_III_memoization t1 =
                new Best_Time_to_Buy_and_Sell_Stock_III_memoization();
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
        int cap = 2;
        int[][][] dp = new int[n + 1][2][cap + 1];
        for (int index = 0; index < dp.length; index++) {
            for (int buy = 0; buy < dp[index].length; buy++) {
                Arrays.fill(dp[index][buy], -1);
            }
        }

        return f(0, true, cap, n, prices, dp);
    }

    public int f(int index, boolean canBuy, int cap, int n, ArrayList<Integer> prices, int[][][] dp) {
        if (index == n || cap == 0) return 0;
        int profit;
        if (canBuy) {
            if (dp[index][0][cap] != -1) return dp[index][0][cap];
            int buy = -prices.get(index) + f(index + 1, false, cap, n, prices, dp);
            int dontBuy = f(index + 1, true, cap, n, prices, dp);
            dp[index][0][cap] = profit = Math.max(buy, dontBuy);
        } else {
            if (dp[index][1][cap] != -1) return dp[index][1][cap];
            int sell = prices.get(index) + f(index + 1, true, cap - 1, n, prices, dp);
            int dontSell = f(index + 1, false, cap, n, prices, dp);
            dp[index][1][cap] = profit = Math.max(sell, dontSell);
        }
        return profit;
    }
}
