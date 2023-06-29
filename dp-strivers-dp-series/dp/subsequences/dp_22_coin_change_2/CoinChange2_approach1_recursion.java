package dp.subsequences.dp_22_coin_change_2;

/**
 * Coin Change 2 - Ways to Make Coin Change
 * Approach 1: Recursion
 * <p>
 * Link: <a href="https://www.codingninjas.com/studio/problems/ways-to-make-coin-change_630471">Ways to Make Coin Change</a>
 */
public class CoinChange2_approach1_recursion {

    public static void main(String[] args) {
        // test 1
        int n = 3;
        int[] denominations = {1, 2, 3};
        int target = 4;
        System.out.println(new CoinChange2_approach1_recursion().countWaysToMakeChange(denominations, n, target)); // 4

        // test 2
        int n2 = 2;
        int[] denominations2 = new int[]{1, 2};
        int target2 = 4;
        System.out.println(new CoinChange2_approach1_recursion().countWaysToMakeChange(denominations2, n2, target2)); // 3

        // test 3
        int n3 = 4;
        int[] denominations3 = new int[]{1, 2, 3, 4};
        int target3 = 5;
        System.out.println(new CoinChange2_approach1_recursion().countWaysToMakeChange(denominations3, n3, target3)); // 6
    }

    public long countWaysToMakeChange(int denominations[], int n, int target) {
        return f(n - 1, target, denominations);
    }

    public long f(int index, int target, int[] coins) {
        if (index == 0) {
            return target % coins[index] == 0 ? 1 : 0;
        }
        long notPick = f(index - 1, target, coins);
        long pick = 0;
        if (target >= coins[index]) {
            pick = f(index, target - coins[index], coins);
        }
        return notPick + pick;
    }
}
