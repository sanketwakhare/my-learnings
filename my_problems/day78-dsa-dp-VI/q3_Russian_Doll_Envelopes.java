import java.util.ArrayList;
import java.util.Collections;

/* Russian Doll Envelopes */

/* Problem Description

Given a matrix of integers A of size N x 2 describing dimensions of N envelopes, where A[i][0] denotes the height of the ith envelope and A[i][1] denotes the width of the ith envelope.

One envelope can fit into another if and only if both the width and height of one envelope is greater than the width and height of the other envelope.

Find the maximum number of envelopes you can put one inside other.


Problem Constraints

1 <= N <= 1000
1 <= A[i][0], A[i][1] <= 10^9


Input Format
The only argument given is the integer matrix A.


Output Format
Return an integer denoting the maximum number of envelopes you can put one inside other.


Example Input
Input 1:
 A = [ 
         [5, 4]
         [6, 4]
         [6, 7]
         [2, 3]  
     ]
Input 2:
 A = [     '
         [8, 9]
         [8, 18]    
     ]


Example Output
Output 1:
 3
Output 2:
 1

Example Explanation
Explanation 1:

 Step 1: put [2, 3] inside [5, 4]
 Step 2: put [5, 4] inside [6, 7]
 3 envelopes can be put one inside other.
Explanation 2:

 No envelopes can be put inside any other so answer is 1. */
public class q3_Russian_Doll_Envelopes {

    class Pair implements Comparable<Pair> {
        int width;
        int height;

        public Pair(int width, int height) {
            this.width = width;
            this.height = height;
        }

        @Override
        public int compareTo(q3_Russian_Doll_Envelopes.Pair o) {
            return this.height - o.height;
        }
    }

    // Use Longest Increasing Subsequence solution for one the array after sorting
    public int solve(int[][] A) {
        // create Pair for each elements in 2d matrix. this can be useful for sorting
        // purpose
        ArrayList<Pair> list = new ArrayList<Pair>();
        for (int i = 0; i < A.length; i++) {
            list.add(new Pair(A[i][0], A[i][1]));
        }
        // sort
        Collections.sort(list);

        int dp[] = new int[A.length];
        int ans = 1;
        for (int i = 0; i < list.size(); i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                // if both height and width are less, then envelope can be inserted
                if (list.get(i).width > list.get(j).width && list.get(i).height > list.get(j).height) {
                    // update dp array
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                    // update answer array
                    ans = Math.max(ans, dp[i]);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {

        q3_Russian_Doll_Envelopes t1 = new q3_Russian_Doll_Envelopes();
        int[][] A;

        A = new int[][] {
                new int[] { 5, 4 },
                new int[] { 6, 4 },
                new int[] { 6, 7 },
                new int[] { 2, 3 } };
        System.out.println(t1.solve(A)); // 3

        A = new int[][] {
                new int[] { 8, 9 },
                new int[] { 8, 18 } };
        System.out.println(t1.solve(A)); // 1

    }

}
