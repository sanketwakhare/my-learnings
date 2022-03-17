import java.util.Arrays;

/* Dice throw */

/* Problem Description

Given sum A, number of ways you can get that sum with dice roll[1-6].

As the number of ways can be large return its modulo by 1e9 + 7.


Problem Constraints
1 <= A <= 10^2


Input Format
The first argument is the integer A.


Output Format
Return an integer .


Example Input

Input 1:
A = 3
Input 2:
A = 4


Example Output

Output 1:
4
Output 2:
8

Example Explanation

Explanation 1:

The four possible ways to obtain 3 are: [1, 1, 1], [1, 2], [2, 1] and [3].


Explanation 2:

The eight possible ways to obtain 8 are: [1, 1, 1, 1], [1, 1, 2], [1, 2, 1], [2, 1, 1], [1, 3], [3, 1], [2, 2], [4]. */
public class hw_q1_Dice_Throw {

    public int solve(int n) {
        return waysToGetSum_tabulation_optimized(n);
    }

    public int waysToGetSum_tabulation_optimized(int n) {

        int[] dp = new int[6];
        Arrays.fill(dp, -1);
        dp[0] = 1;

        // base condition
        if (n == 0)
            return dp[0];

        long m = 1000000007;

        for (int i = 1; i <= n; i++) {
            // collect sum of last 6 numbers from dp array from current n
            long acc = 0;
            for (int j = 1; i - j >= 0 && j <= 6; j++) {
                acc = ((acc % m) + (dp[(i - j) % 6] % m)) % m;
            }
            dp[i % 6] = (int) acc;
        }

        return dp[n % 6];
    }

    public static void main(String[] args) {

        hw_q1_Dice_Throw t1 = new hw_q1_Dice_Throw();
        System.out.println(t1.solve(3)); // 4
        System.out.println(t1.solve(4)); // 8
        System.out.println(t1.solve(10)); // 492
        System.out.println(t1.solve(37)); // 862035276
        System.out.println(t1.solve(979)); // 214420059

    }

}
