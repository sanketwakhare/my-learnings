import java.util.LinkedList;
import java.util.Queue;

/* Distance of nearest cell */

/* Problem Description

Given a matrix of integers A of size N x M consisting of 0 or 1.

For each cell of the matrix find the distance of nearest 1 in the matrix.

Distance between two cells (x1, y1) and (x2, y2) is defined as |x1 - x2| + |y1 - y2|.

Find and return a matrix B of size N x M which defines for each cell in A distance of nearest 1 in the matrix A.

NOTE: There is at least one 1 is present in the matrix.


Problem Constraints
1 <= N, M <= 1000
0 <= A[i][j] <= 1


Input Format
The first argument given is the integer matrix A.


Output Format
Return the matrix B.


Example Input

Input 1:

 A = [
       [0, 0, 0, 1]
       [0, 0, 1, 1] 
       [0, 1, 1, 0]
     ]
Input 2:

 A = [
       [1, 0, 0]
       [0, 0, 0]
       [0, 0, 0]  
     ]


Example Output

Output 1:

 [ 
   [3, 2, 1, 0]
   [2, 1, 0, 0]
   [1, 0, 0, 1]   
 ]
Output 2:

 [
   [0, 1, 2]
   [1, 2, 3]
   [2, 3, 4] 
 ]


Example Explanation

Explanation 1:

 A[0][0], A[0][1], A[0][2] will be nearest to A[0][3].
 A[1][0], A[1][1] will be nearest to A[1][2].
 A[2][0] will be nearest to A[2][1] and A[2][3] will be nearest to A[2][2].
Explanation 2:

 There is only a single 1. Fill the distance from that 1. */

public class hw_q2_Distance_of_nearest_cell {

    // custom object to store the distance of coordinate [i,j]
    class Pair {
        int i, j, minDist;

        public Pair(int i, int j, int minDist) {
            this.i = i;
            this.j = j;
            this.minDist = minDist;
        }
    }

    public int[][] solve(int[][] A) {

        int n = A.length;
        int m = A[0].length;
        int[][] dist = new int[n][m];
        // create queue for BFS traversal
        Queue<Pair> queue = new LinkedList<Pair>();

        // initialize queue and dist array
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (A[i][j] == 1) {
                    // for all 1s, dist will be 0
                    dist[i][j] = 0;
                    // insert all 1s into queue
                    queue.add(new Pair(i, j, 0));
                } else {
                    // for 0 cells, initialize distance to -1 (which will help to identify if it
                    // visited)
                    dist[i][j] = -1;
                }
            }
        }

        // allowed directions
        int[] rows = new int[] { -1, 0, 0, 1 };
        int[] cols = new int[] { 0, -1, 1, 0 };

        while (!queue.isEmpty()) {
            Pair x = queue.poll();
            // for all the neighbors, calculate distance and add into queue if applicable
            for (int k = 0; k < rows.length; k++) {
                int new_i = x.i + rows[k];
                int new_j = x.j + cols[k];
                // if cell has valid coordinates and not already visited
                if (new_i >= 0 && new_i < n && new_j >= 0 && new_j < m && dist[new_i][new_j] == -1) {
                    dist[new_i][new_j] = x.minDist + 1;
                    queue.add(new Pair(new_i, new_j, x.minDist + 1));
                }
            }
        }

        return dist;
    }

    public static void main(String[] args) {
        hw_q2_Distance_of_nearest_cell t1 = new hw_q2_Distance_of_nearest_cell();
        int[][] A, dist;

        // test case 1
        A = new int[][] {
                { 0, 0, 0, 1 },
                { 0, 0, 1, 1 },
                { 0, 1, 1, 0 }
        };
        dist = t1.solve(A);
        ArrayUtils.print2DArray(dist);
        /*
         * expected answer
         * [[3, 2, 1, 0],
         * [2, 1, 0, 0],
         * [1, 0, 0, 1]]
         */

        // test case 2
        A = new int[][] {
                { 1, 0, 0 },
                { 0, 0, 0 },
                { 0, 0, 0 }
        };
        dist = t1.solve(A);
        ArrayUtils.print2DArray(dist);
        /*
         * expected answer
         * [[0, 1, 2],
         * [1, 2, 3],
         * [2, 3, 4]]
         */

    }

}
