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