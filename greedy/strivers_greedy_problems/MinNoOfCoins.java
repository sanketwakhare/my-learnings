package strivers_greedy_problems;

/**
 * Minimum Number of Coins
 *
 * <a href="https://www.codingninjas.com/studio/problems/975277">Minimum Number of Coins</a>
 */
public class MinNoOfCoins {

    public static void main(String[] args) {
        MinNoOfCoins obj = new MinNoOfCoins();
        // test 1
        int amount = 43;
        System.out.println(obj.findMinimumCoins(amount));
        // test 2
        amount = 1000;
        System.out.println(obj.findMinimumCoins(amount));
        // test 3
        amount = 83;
        System.out.println(obj.findMinimumCoins(amount));
    }

    public int findMinimumCoins(int amount) {
        int[] denominations = new int[]{1, 2, 5, 10, 20, 50, 100, 500, 1000};
        int n = denominations.length;

        int count = 0;
        for (int i = n - 1; i >= 0; i--) {
            while (amount >= denominations[i]) {
                amount -= denominations[i];
                count++;
            }
        }

        return count;
    }
}
