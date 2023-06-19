package dp.array_2d;

/**
 * Ninjas Training
 * <p>
 * Ninja is planing this ‘N’ days-long training schedule.
 * Each day, he can perform any one of these three activities (Running, Fighting Practice or Learning New Moves).
 * Each activity has some merit points on each day.
 * <p>
 * As Ninja has to improve all his skills, he can’t do the same activity in two consecutive days.
 * <p>
 * Can you help Ninja find out the maximum merit points Ninja can earn?
 * <p>
 * Example:
 * <p>
 * If the given ‘POINTS’ array is [[1,2,5], [3 ,1 ,1] ,[3,3,3] ],the answer will be 11 as 5 + 3 + 3.
 *
 *
 * <a href="https://www.codingninjas.com/codestudio/problems/ninja-s-training_3621003">Problem link code studio</a>
 */
public class NinjasTraining {

    public static void main(String[] args) {
        NinjasTraining t1 = new NinjasTraining();
        {
            int[][] input = new int[][]{{1, 2, 5}, {3, 1, 1}, {3, 3, 3}};
            t1.ninjasTraining(input.length, input); // 11
        }
        {
            int[][] input = new int[][]{{1, 2, 5}, {3, 1, 1}, {3, 3, 3}, {1, 2, 5}, {3, 1, 1}, {3, 3, 3}};
            t1.ninjasTraining(input.length, input); // 22
        }
        {
            int[][] input = new int[][]{{1, 2, 5}, {3, 1, 1}, {3, 3, 3}, {1, 2, 5}, {3, 1, 1}, {3, 3, 3}, {1, 2, 5}, {3, 1, 1}, {3, 3, 3}};
            t1.ninjasTraining(input.length, input); // 33
        }
    }


    // approach 3: tabulation
    public void ninjasTraining(int n, int[][] points) {
        {
            // approach 1: recursion
            System.out.println(ninja_1(n, points));
        }
        {
            // approach 2: recursion + memoization
            System.out.println(ninja_2(n, points));
        }
        {
            // approach 3: tabulation
            System.out.println(ninja_3(n, points));
        }
    }

    // approach 3: tabulation
    public int ninja_3(int n, int[][] points) {
        int[][] memo = new int[n][4];

        memo[0][0] = Math.max(points[0][1], points[0][2]);
        memo[0][1] = Math.max(points[0][0], points[0][2]);
        memo[0][2] = Math.max(points[0][0], points[0][1]);
        memo[0][3] = Math.max(points[0][0], Math.max(points[0][1], points[0][2]));

        for (int day = 1; day < n; day++) {
            for (int last = 0; last < 4; last++) {
                int max = 0;
                for (int i = 0; i < 3; i++) {
                    if (last != i) {
                        int activity = points[day][i] + memo[day - 1][i];
                        max = Math.max(max, activity);
                    }
                }
                memo[day][last] = max;
            }
        }
        return memo[n - 1][3];
    }

    // approach 2: recursion + memoization
    public int ninja_2(int n, int[][] points) {
        int[][] memo = new int[points.length][4];
        for (int[] row : memo) {
            java.util.Arrays.fill(row, -1);
        }
        return f2(n - 1, n, 3, points, memo);
    }

    public int f2(int index, int n, int lastTaskIndex, int[][] points, int[][] memo) {

        if (index < 0) return 0;
        if (memo[index][lastTaskIndex] != -1) return memo[index][lastTaskIndex];
        int max = 0;
        for (int i = 0; i < 3; i++) {
            if (lastTaskIndex != i) {
                int activity = points[index][i] + f2(index - 1, n, i, points, memo);
                max = Math.max(activity, max);
            }
        }
        return memo[index][lastTaskIndex] = max;
    }

    // approach 1: recursion
    public int ninja_1(int n, int[][] points) {
        return this.f1(n - 1, n, 3, points);
    }

    public int f1(int index, int n, int lastTaskIndex, int[][] points) {

        if (index < 0) return 0;

        int max = 0;
        for (int i = 0; i < 3; i++) {
            if (lastTaskIndex != i) {
                int activity = points[index][i] + f1(index - 1, n, i, points);
                max = Math.max(activity, max);
            }
        }
        return max;
    }
}
