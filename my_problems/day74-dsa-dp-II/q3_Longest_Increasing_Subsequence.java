/*  Longest Increasing Subsequence */

/* Problem Description

Find the longest increasing subsequence of a given array of integers, A.

In other words, find a subsequence of array in which the subsequence's elements are in strictly increasing order, and in which the subsequence is as long as possible.

In this case, return the length of the longest increasing subsequence.


Problem Constraints

0 <= length(A) <= 2500
1 <= A[i] <= 2500


Input Format

The first and the only argument is an integer array A.


Output Format

Return an integer representing the length of the longest increasing subsequence.



Example Input

Input 1:

 A = [1, 2, 1, 5]
Input 2:

 A = [0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15]


Example Output

Output 1:

 3
Output 2:

 6


Example Explanation

Explanation 1:

 The longest increasing subsequence: [1, 2, 5]
Explanation 2:

 The possible longest increasing subsequences: [0, 2, 6, 9, 13, 15] or [0, 4, 6, 9, 11, 15] or [0, 4, 6, 9, 13, 15] */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* Longest Increasing Subsequence */
public class q3_Longest_Increasing_Subsequence {

    /**
     * Approach 1- backtracking
     * TC: O(2^n)
     * SC: O(n) recursion stack space
     * TLE
     */
    static int max = Integer.MIN_VALUE;

    public void backtrack(int index, int n, int[] A, List<Integer> list, int count) {

        if (index == n) {
            if (max < list.size()) {
                max = list.size();
            }
            return;
        }
        if ((list.size() == 0) || (list.size() > 0 && A[index] >= list.get(list.size() - 1))) {
            list.add(A[index]);
            backtrack(index + 1, n, A, list, count + 1);
            list.remove(list.size() - 1);
        }
        backtrack(index + 1, n, A, list, count);
    }

    /**
     * Approach 2 - iterative dp solution
     * TC: O(n^2)
     * SC: O(n) for dp array
     * 
     * @param A  input array
     * @param dp dp array
     */
    public int lis_dp(int[] A) {

        // initialize dp array with 1
        int[] dp = new int[A.length];
        Arrays.fill(dp, 1);
        int n = A.length;
        int maxLength = 1;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (A[i] > A[j]) {
                    dp[i] = Math.max(1 + dp[j], dp[i]);
                    maxLength = Math.max(maxLength, dp[i]);
                }
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {

        q3_Longest_Increasing_Subsequence t1 = new q3_Longest_Increasing_Subsequence();
        int[] A;

        {
            System.out.println("Approach 1 - backtrack");
            A = new int[] { 1, 2, 1, 5 };
            t1.backtrack(0, A.length, A, new ArrayList<Integer>(), 0);
            System.out.println(max);

            A = new int[] { 0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15 };
            t1.backtrack(0, A.length, A, new ArrayList<Integer>(), 0);
            System.out.println(max);
        }

        {
            System.out.println("Approach 2 - iterative dp solution");
            A = new int[] { 1, 2, 1, 5 };
            System.out.println(t1.lis_dp(A));

            A = new int[] { 0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15 };
            System.out.println(t1.lis_dp(A));

            A = new int[] { 1, 6, 8, 3, 2, 10, 5 };
            System.out.println(t1.lis_dp(A));
        }

    }

}