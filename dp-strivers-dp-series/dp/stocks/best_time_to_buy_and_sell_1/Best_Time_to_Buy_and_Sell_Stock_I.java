package dp.stocks.best_time_to_buy_and_sell_1;

import java.util.ArrayList;
import java.util.List;

/* Best Time to Buy and Sell Stock */
/* https://www.codingninjas.com/codestudio/problems/stocks-are-profitable_893405?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos&leftPanelTab=0 */

/* Only single transaction is allowed */

/* TC: O(N)
 * SC: O(1) */
public class Best_Time_to_Buy_and_Sell_Stock_I {

    public static void main(String[] args) {
        Best_Time_to_Buy_and_Sell_Stock_I t1 = new Best_Time_to_Buy_and_Sell_Stock_I();
        {
            List<Integer> input = List.of(17, 20, 11, 9, 12, 6);
            int result = t1.maximumProfit(new ArrayList<>(input));
            System.out.println(result);
        }
        {
            List<Integer> input = List.of(98, 101, 66, 72);
            int result = t1.maximumProfit(new ArrayList<>(input));
            System.out.println(result);
        }
    }

    public int maximumProfit(ArrayList<Integer> prices) {
        // Write your code here.
        int min = prices.get(0);
        int profit = 0;
        for (int i = 1; i < prices.size(); i++) {
            int curr = prices.get(i);
            profit = Math.max(profit, curr - min);
            min = Math.min(min, curr);
        }
        return profit;
    }
}
