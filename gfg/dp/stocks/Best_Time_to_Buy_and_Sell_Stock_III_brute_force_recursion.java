package dp.stocks;

/* Best Time to Buy and Sell Stock III */
/* https://www.codingninjas.com/codestudio/problems/buy-and-sell-stock_1071012?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos */

/* At most 2 transactions are allowed */

import java.util.ArrayList;
import java.util.List;

/* TC: O(2^N * N) all possible combinations of either buy or sell + repeated sub-problems will get called N times
 * SC: O(N) recursive stack space */
public class Best_Time_to_Buy_and_Sell_Stock_III_brute_force_recursion {

    public static void main(String[] args) {
        Best_Time_to_Buy_and_Sell_Stock_III_brute_force_recursion t1 =
                new Best_Time_to_Buy_and_Sell_Stock_III_brute_force_recursion();
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
        return f(0, true, 2, n, prices);
    }

    public int f(int index, boolean canBuy, int cap, int n, ArrayList<Integer> prices) {
        if (index == n || cap == 0) return 0;
        int profit;
        if (canBuy) {
            int buy = -prices.get(index) + f(index + 1, false, cap, n, prices);
            int dontBuy = f(index + 1, true, cap, n, prices);
            profit = Math.max(buy, dontBuy);
        } else {
            int sell = prices.get(index) + f(index + 1, true, cap - 1, n, prices);
            int dontSell = f(index + 1, false, cap, n, prices);
            profit = Math.max(sell, dontSell);
        }
        return profit;
    }
}
