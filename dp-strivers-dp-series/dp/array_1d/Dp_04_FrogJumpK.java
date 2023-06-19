package dp.array_1d;

import java.util.Arrays;

/**
 * Frog Jump K
 * <p>
 * <a href="https://atcoder.jp/contests/dp/tasks/dp_b">Frog Jump K</a>
 */
public class Dp_04_FrogJumpK {
    public static void main(String[] args) {
        Dp_04_FrogJumpK t1 = new Dp_04_FrogJumpK();
        {
            // test case 1
            int[] input = new int[]{10, 30, 40, 50, 20, 30, 15, 7, 3, 6, 4, 3, 29, 23, 3};
            int k = 3;
            t1.frogJump(k, input);
        }
        {
            // test case 2
            int[] input = new int[]{10, 20, 10};
            int k = 1;
            t1.frogJump(k, input);
        }
    }

    public void frogJump(int k, int[] heights) {
        // approach 1: recursion
        {
            long start = System.nanoTime();
            int answer = jump_1(k, heights);
            long end = System.nanoTime();
            double elapsedTime = (end - start) / 1e6;
            System.out.println(answer + " [time: " + elapsedTime + " ms]");
        }
        // approach 2: recursion + memoization
        {
            long start = System.nanoTime();
            int answer = jump_2(k, heights);
            long end = System.nanoTime();
            double elapsedTime = (end - start) / 1e6;
            System.out.println(answer + " [time: " + elapsedTime + " ms]");
        }
        // approach 3: iterative tabulation
        {
            long start = System.nanoTime();
            int answer = jump_3(k, heights);
            long end = System.nanoTime();
            double elapsedTime = (end - start) / 1e6;
            System.out.println(answer + " [time: " + elapsedTime + " ms]");
        }
        //  approach 4: iterative tabulation + space optimized
        {
            long start = System.nanoTime();
            int answer = jump_4(k, heights);
            long end = System.nanoTime();
            double elapsedTime = (end - start) / 1e6;
            System.out.println(answer + " [time: " + elapsedTime + " ms]");
        }
    }

    // approach 4: iterative tabulation + space optimized
    public int jump_4(int k, int[] heights) {
        int n = heights.length;
        int[] dp = new int[k + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int index = 1; index < n; index++) {
            int min = Integer.MAX_VALUE;
            for (int j = index - 1; j >= 0 && index - j <= k; j--) {
                int diff = Math.abs(heights[index] - heights[j]);
                dp[index % (k + 1)] = min = Math.min(min, dp[j % (k + 1)] + diff);
            }
        }
        return dp[(n - 1) % k];
    }

    // approach 3: iterative tabulation
    public int jump_3(int k, int[] heights) {
        int n = heights.length;
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int index = 1; index < n; index++) {
            for (int j = index - 1; j >= 0 && index - j <= k; j--) {
                int diff = Math.abs(heights[index] - heights[j]);
                dp[index] = Math.min(dp[index], dp[j] + diff);
            }
        }
        return dp[n - 1];
    }

    // approach 2: recursion + memoization
    public int jump_2(int k, int[] heights) {
        int n = heights.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return backtrack_2(0, n, k, heights, dp);
    }

    public int backtrack_2(int index, int n, int k, int[] heights, int[] dp) {
        if (index >= n - 1) return 0;
        int min = Integer.MAX_VALUE;
        if (dp[index] != -1) return dp[index];
        for (int i = index + 1; i < n && i <= index + k; i++) {
            int cost = Math.abs(heights[i] - heights[index]) + backtrack_2(i, n, k, heights, dp);
            min = Math.min(min, cost);
        }
        return dp[index] = min;
    }

    // approach 1: recursion
    public int jump_1(int k, int[] heights) {
        int n = heights.length;
        return backtrack_1(0, n, heights, k);
    }

    public int backtrack_1(int index, int n, int[] heights, int k) {
        if (index >= n - 1) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for (int i = index + 1; i < n && i <= index + k; i++) {
            int cost = Math.abs(heights[index] - heights[i]) + backtrack_1(i, n, heights, k);
            min = Math.min(min, cost);
        }
        return min;
    }
}
