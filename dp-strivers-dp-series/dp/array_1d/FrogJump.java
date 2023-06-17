package dp.array_1d;

import java.util.Arrays;

/**
 * Frog Jump
 * <p>
 * There is a frog on the '1st' step of an 'N' stairs long staircase.
 * The frog wants to reach the 'Nth' stair.
 * 'HEIGHT[i]' is the height of the '(i+1)th' stair.
 * If Frog jumps from 'ith' to 'jth' stair, the energy lost in the jump is given by absolute value of ( HEIGHT[i-1] - HEIGHT[j-1] ).
 * If the Frog is on 'ith' staircase, he can jump either to '(i+1)th' stair or to '(i+2)th' stair.
 * Your task is to find the minimum total energy used by the frog to reach from '1st' stair to 'Nth' stair.
 * <p>
 * https://www.codingninjas.com/codestudio/problems/frog-jump_3621012
 */
public class FrogJump {
    public static void main(String[] args) {
        FrogJump.frogJump(9, new int[]{7, 5, 5, 8, 4, 9, 1, 1, 10}); // 15
        FrogJump.frogJump(4, new int[]{10, 20, 30, 10}); // 20
    }

    public static int frogJump(int n, int heights[]) {
        // approach 1: recursion
        {
            long start = System.nanoTime();

            int answer = jump_1(0, n, heights);

            long end = System.nanoTime();
            double elapsedTime = (end - start) / 1e6;
            System.out.println(answer + " [time: " + elapsedTime + " ms]");
        }

        // approach 2: recursion + memoization
        {
            long start = System.nanoTime();

            int[] dp = new int[n + 1];
            Arrays.fill(dp, -1);
            int answer = jump_2(0, n, heights, dp);

            long end = System.nanoTime();
            double elapsedTime = (end - start) / 1e6;
            System.out.println(answer + " [time: " + elapsedTime + " ms]");
        }

        // approach 3: iterative tabulation
        {
            long start = System.nanoTime();

            int answer = jump_3(n, heights);

            long end = System.nanoTime();
            double elapsedTime = (end - start) / 1e6;
            System.out.println(answer + " [time: " + elapsedTime + " ms]");
        }

        //  approach 4: iterative tabulation + space optimized
        {
            long start = System.nanoTime();

            int answer = jump_4(n, heights);

            long end = System.nanoTime();
            double elapsedTime = (end - start) / 1e6;
            System.out.println(answer + " [time: " + elapsedTime + " ms]");
        }
        return 0;
    }

    // approach 4: iterative tabulation + space optimized
    public static int jump_4(int n, int[] heights) {
        int first = 0;
        int second = 0;

        for (int index = 1; index < n; index++) {
            int value1 = first + Math.abs(heights[index] - heights[index - 1]);
            int value2 = Integer.MAX_VALUE;
            if (index - 2 >= 0) value2 = second + Math.abs(heights[index] - heights[index - 2]);
            int curr = Math.min(value1, value2);
            second = first;
            first = curr;
        }
        return first;
    }

    // approach 3: iterative tabulation
    public static int jump_3(int n, int[] heights) {

        int[] dp = new int[n];
        dp[0] = 0;

        for (int index = 1; index < n; index++) {
            int second = Integer.MAX_VALUE;
            int first = dp[index - 1] + Math.abs(heights[index] - heights[index - 1]);
            if (index - 2 >= 0) second = dp[index - 2] + Math.abs(heights[index] - heights[index - 2]);
            dp[index] = Math.min(first, second);
        }
        return dp[n - 1];
    }

    // approach 2: recursion + memoization
    public static int jump_2(int index, int n, int[] heights, int[] dp) {
        if (index >= n - 1) return 0;

        if (dp[index] != -1) return dp[index];

        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;
        if (index + 1 < n) {
            first = jump_2(index + 1, n, heights, dp) + Math.abs(heights[index] - heights[index + 1]);
        }
        if (index + 2 < n) {
            second = jump_2(index + 2, n, heights, dp) + Math.abs(heights[index] - heights[index + 2]);
        }

        return dp[index] = Math.min(first, second);
    }

    // approach 1: recursion
    public static int jump_1(int index, int n, int[] heights) {
        if (index >= n - 1) return 0;

        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;
        if (index + 1 < n) {
            first = jump_1(index + 1, n, heights) + Math.abs(heights[index] - heights[index + 1]);
        }
        if (index + 2 < n) {
            second = jump_1(index + 2, n, heights) + Math.abs(heights[index] - heights[index + 2]);
        }

        return Math.min(first, second);
    }
}
