/* Stairs */

/* Problem Description

You are climbing a stair case and it takes A steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?


Problem Constraints

1 <= A <= 36



Input Format

The first and the only argument contains an integer A, the number of steps.


Output Format

Return an integer, representing the number of ways to reach the top.


Example Input

Input 1:

 A = 2
Input 2:

 A = 3


Example Output

Output 1:

 2
Output 2:

 3


Example Explanation

Explanation 1:

 Distinct ways to reach top: [1, 1], [2].
Explanation 2:

 Distinct ways to reach top: [1 1 1], [1 2], [2 1]. */

public class q2_Stairs {

    public int climbStairs(int n) {
        // instead of dp array, use 2 variables
        int prev1 = 1;
        int prev2 = 1;
        int curr;

        for (int i = 2; i <= n; i++) {
            curr = prev1 + prev2;
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }

    public static void main(String[] args) {
        q2_Stairs t1 = new q2_Stairs();
        System.out.println(t1.climbStairs(2)); // 2
        System.out.println(t1.climbStairs(3)); // 3
        System.out.println(t1.climbStairs(4)); // 5
        System.out.println(t1.climbStairs(5)); // 8
        System.out.println(t1.climbStairs(9)); // 55
        System.out.println(t1.climbStairs(10)); // 89
    }
}
