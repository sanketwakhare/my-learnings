/* Unique Paths in a Grid */

/* Problem Description

Given a grid of size n * m, lets assume you are starting at (1,1) and your goal is to reach (n, m). At any instance, if you are on (x, y), you can either go to (x, y + 1) or (x + 1, y).

Now consider if some obstacles are added to the grids. How many unique paths would there be? An obstacle and empty space is marked as 1 and 0 respectively in the grid.


Problem Constraints

1 <= n, m <= 100
A[i][j] = 0 or 1


Input Format

First and only argument A is a 2D array of size n * m.


Output Format

Return an integer denoting the number of unique paths from (1, 1) to (n, m).


Example Input

Input 1:

 A = [
        [0, 0, 0]
        [0, 1, 0]
        [0, 0, 0]
     ]
Input 2:

 A = [
        [0, 0, 0]
        [1, 1, 1]
        [0, 0, 0]
     ]


Example Output

Output 1:

 2
Output 2:

 0


Example Explanation

Explanation 1:

 Possible paths to reach (n, m): {(1, 1), (1, 2), (1, 3), (2, 3), (3, 3)} and {(1 ,1), (2, 1), (3, 1), (3, 2), (3, 3)}  
 So, the total number of unique paths is 2. 
Explanation 2:

 It is not possible to reach (n, m) from (1, 1). So, ans is 0. */

public class q2_Unique_Paths_in_a_Grid {

    public int uniquePathsWithObstacles(int[][] A) {

        int n = A.length;
        int m = A[0].length;
        int[][] dp = new int[n][m];

        // initialize dp first row
        for (int j = 0; j < m; j++) {
            if (A[0][j] == 1) {
                dp[0][j] = 0;
            } else {
                if (j == 0) {
                    dp[0][j] = 1;
                } else if (j > 0) {
                    dp[0][j] += dp[0][j - 1];
                }
            }
        }
        // initialize dp first column - as first element is already considered in first
        // row, start with second row
        for (int i = 1; i < n; i++) {
            if (A[i][0] == 1) {
                dp[i][0] = 0;
            } else {
                if (i == 0) {
                    dp[i][0] = 1;
                } else if (i > 0) {
                    dp[i][0] += dp[i - 1][0];
                }
            }
        }

        // update dp array
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (A[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
                }
            }
        }

        return dp[n - 1][m - 1];
    }

    public static void main(String[] args) {

        q2_Unique_Paths_in_a_Grid t1 = new q2_Unique_Paths_in_a_Grid();
        int[][] A;

        {
            A = new int[][] {
                    { 0, 0, 0 },
                    { 0, 1, 0 },
                    { 0, 0, 0 }
            };
            System.out.println(t1.uniquePathsWithObstacles(A)); // 2
            A = new int[][] {
                    { 0, 0, 0 },
                    { 1, 1, 1 },
                    { 0, 0, 0 }
            };
            System.out.println(t1.uniquePathsWithObstacles(A)); // 0
        }
    }

}
