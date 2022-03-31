import java.util.LinkedList;
import java.util.Queue;

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
public class hw_q1__Number_of_islands__BFS {

    class Pair {
        int i;
        int j;

        public Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public int solve(int[][] A) {
        return countIslands(A);
    }

    public int countIslands(int[][] A) {

        int n = A.length;
        int m = A[0].length;
        int count = 0;
        boolean[][] isVisited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (A[i][j] == 1 && !isVisited[i][j]) {
                    bfsTraversal(A, isVisited, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    public void bfsTraversal(int[][] A, boolean[][] isVisited, int i, int j) {

        int row[] = { -1, -1, -1, 0, 0, 1, 1, 1 };
        int col[] = { -1, 0, 1, -1, 1, -1, 0, 1 };
        Queue<Pair> queue = new LinkedList<Pair>();
        queue.add(new Pair(i, j));
        isVisited[i][j] = true;

        while (!queue.isEmpty()) {

            Pair temp = queue.poll();

            int x, y;
            for (int k = 0; k < 8; k++) {
                x = temp.i + row[k];
                y = temp.j + col[k];
                if (isValidPair(x, y, A, isVisited)) {
                    isVisited[x][y] = true;
                    queue.add(new Pair(x, y));
                }
            }
        }

    }

    public boolean isValidPair(int i, int j, int[][] A, boolean[][] isVisited) {
        if (i >= 0 && j >= 0 && i < A.length && j < A[0].length && !isVisited[i][j] && A[i][j] == 1) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {

        hw_q1__Number_of_islands__BFS t1 = new hw_q1__Number_of_islands__BFS();
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
