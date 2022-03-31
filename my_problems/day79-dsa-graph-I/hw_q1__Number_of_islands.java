/* Number of islands */

/* Problem Description

Given a matrix of integers A of size N x M consisting of 0 and 1. A group of connected 1's forms an island. From a cell (i, j) such that A[i][j] = 1 you can visit any cell that shares a corner with (i, j) and value in that cell is 1.

More formally, from any cell (i, j) if A[i][j] = 1 you can visit:

(i-1, j) if (i-1, j) is inside the matrix and A[i-1][j] = 1.
(i, j-1) if (i, j-1) is inside the matrix and A[i][j-1] = 1.
(i+1, j) if (i+1, j) is inside the matrix and A[i+1][j] = 1.
(i, j+1) if (i, j+1) is inside the matrix and A[i][j+1] = 1.
(i-1, j-1) if (i-1, j-1) is inside the matrix and A[i-1][j-1] = 1.
(i+1, j+1) if (i+1, j+1) is inside the matrix and A[i+1][j+1] = 1.
(i-1, j+1) if (i-1, j+1) is inside the matrix and A[i-1][j+1] = 1.
(i+1, j-1) if (i+1, j-1) is inside the matrix and A[i+1][j-1] = 1.
Return the number of islands.

NOTE: Rows are numbered from top to bottom and columns are numbered from left to right.



Problem Constraints

1 <= N, M <= 100

0 <= A[i] <= 1



Input Format

The only argument given is the integer matrix A.



Output Format

Return the number of islands.



Example Input

Input 1:

 A = [ 
       [0, 1, 0]
       [0, 0, 1]
       [1, 0, 0]
     ]
Input 2:

 A = [   
       [1, 1, 0, 0, 0]
       [0, 1, 0, 0, 0]
       [1, 0, 0, 1, 1]
       [0, 0, 0, 0, 0]
       [1, 0, 1, 0, 1]    
     ]


Example Output

Output 1:

 2
Output 2:

 5


Example Explanation

Explanation 1:

 The 1's at position A[0][1] and A[1][2] forms one island.
 Other is formed by A[2][0].
Explanation 2:

 There 5 island in total. */
public class hw_q1__Number_of_islands {

    public int solve(int[][] A) {
        return countIslands(A);
    }

    public void dfsTraversal(int i, int j, int n, int m, int[][] A) {
        if (i < 0 || j < 0 || i >= n || j >= m || A[i][j] == 0) {
            return;
        }
        if (A[i][j] == 1) {
            A[i][j] = 0;
            dfsTraversal(i - 1, j - 1, n, m, A);
            dfsTraversal(i - 1, j, n, m, A);
            dfsTraversal(i - 1, j + 1, n, m, A);
            dfsTraversal(i, j - 1, n, m, A);
            dfsTraversal(i, j + 1, n, m, A);
            dfsTraversal(i + 1, j - 1, n, m, A);
            dfsTraversal(i + 1, j, n, m, A);
            dfsTraversal(i + 1, j + 1, n, m, A);
        }
    }

    public int countIslands(int[][] A) {
        int n = A.length;
        int m = A[0].length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (A[i][j] == 1) {
                    A[i][j] = 0;
                    count++;
                    dfsTraversal(i - 1, j - 1, n, m, A);
                    dfsTraversal(i - 1, j, n, m, A);
                    dfsTraversal(i - 1, j + 1, n, m, A);
                    dfsTraversal(i, j - 1, n, m, A);
                    dfsTraversal(i, j + 1, n, m, A);
                    dfsTraversal(i + 1, j - 1, n, m, A);
                    dfsTraversal(i + 1, j, n, m, A);
                    dfsTraversal(i + 1, j + 1, n, m, A);
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {

        hw_q1__Number_of_islands t1 = new hw_q1__Number_of_islands();
        int[][] A;

        A = new int[][] {
                { 0, 0, 1, 0, 1, 0, 1, 1, 1 },
                { 0, 1, 0, 0, 1, 1, 1, 0, 1 }
        };
        System.out.println(t1.solve(A)); // 2

        A = new int[][] {
                { 0, 1, 0 },
                { 0, 0, 1 },
                { 1, 0, 0 }
        };
        System.out.println(t1.solve(A)); // 2

        A = new int[][] {
                { 1, 1, 0, 0, 0 },
                { 0, 1, 0, 0, 0 },
                { 1, 0, 0, 1, 1 },
                { 0, 0, 0, 0, 0 },
                { 1, 0, 1, 0, 1 }
        };
        System.out.println(t1.solve(A)); // 5
    }

}
