import java.util.Arrays;

/* Dice throw: 
Find no of ways in which you can get sum = N
*/
public class class_q4_dice_throw {

    /**
     * Approach 1 : recursive + initialize dp[0] with 1
     * recursive method: TC: O(6^n) each n has 6 possibilities
     * SC: O(n) recursive stack space
     */
    public int waysToGetSum(int n, int[] dp) {

        if (n == 0)
            return dp[0];

        if (dp[n] != -1)
            return dp[n];

        // collect sum of last 6 numbers from dp array from current n
        int sum = 0;
        for (int i = 1; i <= 6 && i <= n; i++) {
            sum += waysToGetSum(n - i, dp);
        }
        dp[n] = sum;

        return dp[n];
    }

    /**
     * Approach 2: recursive + initialize dp[1] to dp[6]
     * recursive method: TC: O(6^n) each n has 6 possibilities
     * SC: O(n) recursive stack space
     */
    public int waysToGetSum_approach2(int n, int[] dp) {

        if (n <= 6)
            return dp[n];

        if (dp[n] != -1)
            return dp[n];

        // collect sum of last 6 numbers from dp array from current n
        int sum = 0;
        for (int i = 1; i <= 6; i++) {
            sum += waysToGetSum_approach2(n - i, dp);
        }
        dp[n] = sum;

        return dp[n];
    }

    /**
     * Approach 3: iterative tabulation method
     * TC: O(6 *n) => O(n)
     * SC: O(n+6) for dp array
     */
    public int waysToGetSum_tabulation(int n) {

        int[] dp = new int[n + 6];
        Arrays.fill(dp, -1);
        dp[0] = 1;

        // base condition
        if (n == 0)
            return dp[0];

        for (int i = 1; i <= n; i++) {
            // collect sum of last 6 numbers from dp array from current n
            int sum = 0;
            for (int j = 1; i - j >= 0 && j <= 6; j++) {
                sum += dp[i - j];
            }
            dp[i] = sum;
        }

        return dp[n];
    }

    /**
     * Approach 4: iterative tabulation method + space optimized
     * TC: O(6 *n) => O(n)
     * SC: O(1) for dp array of size 6 only
     */
    public int waysToGetSum_tabulation_optimized(int n) {

        int[] dp = new int[6];
        Arrays.fill(dp, -1);
        dp[0] = 1;

        // base condition
        if (n == 0)
            return dp[0];

        for (int i = 1; i <= n; i++) {
            // collect sum of last 6 numbers from dp array from current n
            int sum = 0;
            for (int j = 1; i - j >= 0 && j <= 6; j++) {
                sum += dp[(i - j) % 6];
            }
            dp[i % 6] = sum;
        }

        return dp[n % 6];
    }

    public static void main(String[] args) {

        class_q4_dice_throw t1 = new class_q4_dice_throw();
        int n;
        int[] dp;

        {
            // Approach 1 : recursive + initialize dp[0] with 1
            System.out.println("Approach 1 : recursive + initialize dp[0] with 1");
            n = 10;
            dp = new int[n + 1];
            Arrays.fill(dp, -1);
            dp[0] = 1;
            System.out.println(t1.waysToGetSum(n, dp)); // 492
        }

        {
            // Approach 2: recursive + initialize dp[1] to dp[6]
            System.out.println("Approach 2: recursive + initialize dp[1] to dp[6]");
            n = 8;
            dp = new int[n + 6];
            Arrays.fill(dp, -1);
            dp[1] = 1;
            dp[2] = 2;
            dp[3] = 4;
            dp[4] = 8;
            dp[5] = 16;
            dp[6] = 32;
            System.out.println(t1.waysToGetSum_approach2(n, dp)); // 125
        }

        {
            // Approach 3: iterative tabulation method
            System.out.println("Approach 3: iterative tabulation method");
            n = 10;
            System.out.println(t1.waysToGetSum_tabulation(n)); // 492
        }

        {
            // Approach 4: iterative tabulation method + space optimized
            System.out.println("Approach 4: iterative tabulation method + space optimized");
            n = 12;
            System.out.println(t1.waysToGetSum_tabulation_optimized(n)); // 1936
        }

    }
}
