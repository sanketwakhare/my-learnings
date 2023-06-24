package dp.stocks.best_time_to_buy_and_sell_4;

/* Best Time to Buy and Sell Stock IV */
/* https://www.codingninjas.com/codestudio/problems/best-time-to-buy-and-sell-stock_1080698?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos&leftPanelTab=0 */

/* At most k transactions are allowed */

/* TC: O(2^N * N) all possible combinations of either buy or sell + repeated sub-problems will get called N times
 * SC: O(N) recursive stack space */
public class Best_Time_to_Buy_and_Sell_Stock_IV_brute_force_recursion {

    public static void main(String[] args) {
        Best_Time_to_Buy_and_Sell_Stock_IV_brute_force_recursion t1 =
                new Best_Time_to_Buy_and_Sell_Stock_IV_brute_force_recursion();
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
        return f(0, 0, k, n, prices);
    }

    private int f(int index, int canBuy, int cap, int n, int[] prices) {
        if (index == n || cap == 0) return 0;
        int profit;
        if (canBuy == 0) {
            // buy
            int buy = -prices[index] + f(index + 1, 1, cap, n, prices);
            int dontBuy = f(index + 1, 0, cap, n, prices);
            profit = Math.max(buy, dontBuy);
        } else {
            int sell = prices[index] + f(index + 1, 0, cap - 1, n, prices);
            int dontSell = f(index + 1, 1, cap, n, prices);
            profit = Math.max(sell, dontSell);
        }
        return profit;
    }
}
