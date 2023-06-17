package dp.stocks;

/* Best Time to Buy and Sell Stock III */
/* https://www.codingninjas.com/codestudio/problems/buy-and-sell-stock_1071012?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos */

/* At most 2 transactions are allowed */

import java.util.ArrayList;
import java.util.List;

/* TC: O(N x 2 x 3)
 * SC: O(2 x 2 x 3) = O(12) ~ constant = O(1) */
public class Best_Time_to_Buy_and_Sell_Stock_III_tabulation_space_optimized {

    public static void main(String[] args) {
        Best_Time_to_Buy_and_Sell_Stock_III_tabulation_space_optimized t1 =
                new Best_Time_to_Buy_and_Sell_Stock_III_tabulation_space_optimized();
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
        int[][] next = new int[2][k + 1];
        int[][] curr = new int[2][k + 1];

        // traversal
        for (int index = n - 1; index >= 0; index--) {
            for (int canBuy = 0; canBuy < 2; canBuy++) {
                for (int cap = k; cap > 0; cap--) {
                    if (canBuy == 0) {
                        // if buy is possible
                        int buy = -prices.get(index) + next[1][cap];
                        int dontBuy = next[0][cap];
                        curr[0][cap] = Math.max(buy, dontBuy);
                    } else {
                        // if sell is possible
                        int sell = prices.get(index) + next[0][cap - 1];
                        int dontSell = next[1][cap];
                        curr[1][cap] = Math.max(sell, dontSell);
                    }
                }
            }
            next = curr;
        }
        return curr[0][k];
    }
}
