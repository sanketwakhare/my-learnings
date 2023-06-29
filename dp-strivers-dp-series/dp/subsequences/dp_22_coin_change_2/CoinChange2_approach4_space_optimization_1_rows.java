package dp.subsequences.dp_22_coin_change_2;

/**
 * Coin Change 2 - Ways to Make Coin Change
 * Approach 1: Recursion
 * <p>
 * Link: <a href="https://www.codingninjas.com/studio/problems/ways-to-make-coin-change_630471">Ways to Make Coin Change</a>
 */
public class CoinChange2_approach4_space_optimization_1_rows {

    public static void main(String[] args) {
        // test 1
        int n = 3;
        int[] denominations = {1, 2, 3};
        int target = 4;
        System.out.println(new CoinChange2_approach4_space_optimization_1_rows().countWaysToMakeChange(denominations, n, target)); // 4

        // test 2
        int n2 = 2;
        int[] denominations2 = new int[]{1, 2};
        int target2 = 4;
        System.out.println(new CoinChange2_approach4_space_optimization_1_rows().countWaysToMakeChange(denominations2, n2, target2)); // 3

        // test 3
        int n3 = 4;
        int[] denominations3 = new int[]{1, 2, 3, 4};
        int target3 = 5;
        System.out.println(new CoinChange2_approach4_space_optimization_1_rows().countWaysToMakeChange(denominations3, n3, target3)); // 6
    }

    public long countWaysToMakeChange(int[] denominations, int n, int target) {
        long[] prev = new long[target + 1];

        // base case
        for (int T = 0; T <= target; T++) {
            prev[T] = T % denominations[0] == 0 ? 1 : 0;
        }
        for (int index = 1; index < n; index++) {
            // as values of curren cell depends only on previous cells and current cell, we can use single row
            for (int T = 0; T <= target; T++) {
                long notPick = prev[T];
                long pick = 0;
                if (T >= denominations[index]) {
                    pick = prev[T - denominations[index]];
                }
                prev[T] = notPick + pick;
            }
        }

        return prev[target];
    }
}
