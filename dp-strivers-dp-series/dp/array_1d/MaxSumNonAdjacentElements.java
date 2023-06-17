package dp.array_1d;

import java.util.Arrays;

/**
 * Max Sum Non Adjacent Elements
 *
 * <a href="https://www.codingninjas.com/codestudio/problems/maximum-sum-of-non-adjacent-elements_843261">Problem Link 1</a>
 */
public class MaxSumNonAdjacentElements {

    public static void main(String[] args) {
        MaxSumNonAdjacentElements t1 = new MaxSumNonAdjacentElements();
        {
            int[] input = new int[]{5, 5, 10, 100, 10, 5};
            t1.maxSumNonAdjacentElements(input); // 110
        }
        {
            int[] input = new int[]{1, 2, 3};
            t1.maxSumNonAdjacentElements(input); // 4
        }
        {
            int[] input = new int[]{1, 20, 3};
            t1.maxSumNonAdjacentElements(input); // 20
        }
    }

    public void maxSumNonAdjacentElements(int[] input) {
        // approach 1: recursion
        {
            long start = System.nanoTime();
            int result = maxSum_1(input, input.length - 1);
            long end = System.nanoTime();
            double elapsedTime = (end - start) / 1e6;
            System.out.println(result + " [time: " + elapsedTime + " ms]");
        }
        // approach 2: recursion + memoization
        {
            long start = System.nanoTime();
            int[] dp = new int[input.length];
            Arrays.fill(dp, -1);
            int result = maxSum_2(input, input.length - 1, dp);
            long end = System.nanoTime();
            double elapsedTime = (end - start) / 1e6;
            System.out.println(result + " [time: " + elapsedTime + " ms]");
        }
        // approach 3: iterative tabulation
        {
            long start = System.nanoTime();
            int result = maxSum_3(input);
            long end = System.nanoTime();
            double elapsedTime = (end - start) / 1e6;
            System.out.println(result + " [time: " + elapsedTime + " ms]");
        }
        // approach 4: iterative tabulation + space optimized
        {
            long start = System.nanoTime();
            int result = maxSum_4(input);
            long end = System.nanoTime();
            double elapsedTime = (end - start) / 1e6;
            System.out.println(result + " [time: " + elapsedTime + " ms]");
        }
    }

    // approach 1: recursion
    private int maxSum_1(int[] input, int index) {

        if (index < 0) {
            return 0;
        }

        int pick = input[index] + maxSum_1(input, index - 2);
        int dontPick = maxSum_1(input, index - 1);

        return Math.max(pick, dontPick);
    }

    // approach 2: recursion + memoization
    private int maxSum_2(int[] input, int index, int[] dp) {

        if (index < 0) return 0;
        if (dp[index] != -1) return dp[index];

        int pick = input[index] + maxSum_2(input, index - 2, dp);
        int dontPick = maxSum_2(input, index - 1, dp);

        return dp[index] = Math.max(pick, dontPick);
    }

    // approach 3: iterative tabulation
    private int maxSum_3(int[] input) {

        int n = input.length;
        if (n == 0) return 0;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        dp[1] = input[0];

        for (int index = 2; index <= n; index++) {
            int pick = input[index - 1] + dp[index - 2];
            int dontPick = dp[index - 1];
            dp[index] = Math.max(pick, dontPick);
        }
        return dp[n];
    }

    // approach 4: iterative tabulation + space optimization
    private int maxSum_4(int[] input) {

        int n = input.length;
        if (n == 0) return 0;
        int prev2 = 0;
        int prev1 = input[0];

        for (int index = 2; index <= n; index++) {
            int pick = input[index - 1] + prev2;
            int dontPick = prev1;
            int curr = Math.max(pick, dontPick);
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }
}
