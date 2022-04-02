/* Rotten Oranges */

/* Problem Description

Given a matrix of integers A of size N x M consisting of 0, 1 or 2.

Each cell can have three values:
The value 0 representing an empty cell.
The value 1 representing a fresh orange.
The value 2 representing a rotten orange.

Every minute, any fresh orange that is adjacent (Left, Right, Top, or Bottom) to a rotten orange becomes rotten. Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1 instead.
Note: Your solution will run on multiple test cases. If you are using global variables, make sure to clear them.



Problem Constraints

1 <= N, M <= 1000

0 <= A[i][j] <= 2



Input Format

The first argument given is the integer matrix A.



Output Format

Return the minimum number of minutes that must elapse until no cell has a fresh orange.

If this is impossible, return -1 instead.



Example Input

Input 1:

A = [   [2, 1, 1]
        [1, 1, 0]
        [0, 1, 1]   ]
Input 2:

 
A = [   [2, 1, 1]
        [0, 1, 1]
        [1, 0, 1]   ]


Example Output

Output 1:

 4
Output 2:

 -1


Example Explanation

Explanation 1:

 Max of 4 using (0,0) , (0,1) , (1,1) , (1,2) , (2,2)
Explanation 2:

 Task is impossible */
import java.util.LinkedList;
import java.util.Queue;

/**
 * TC: O(n * m)
 * SC: O(n * m)
 */
public class q1_Rotten_Oranges {

    // custom object will be stored in queue
    class Pair {
        // coordinate of orange
        int i;
        int j;
        // min distance to get rotten
        int minDist;

        public Pair(int i, int j, int minDist) {
            this.i = i;
            this.j = j;
            this.minDist = minDist;
        }
    }

    public int solve(int[][] A) {

        int n = A.length;
        int m = A[0].length;
        int[][] minDistance = new int[n][m];

        // store the initial rotten oranges in Queue
        Queue<Pair> queue = new LinkedList<Pair>();

        // fill queue with rotten oranges first
        // initialize the minDistance array
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (A[i][j] == 2) {
                    minDistance[i][j] = 0;
                    queue.add(new Pair(i, j, 0));
                } else if (A[i][j] == 0) {
                    // initialize empty spaces with INT_MIN
                    minDistance[i][j] = Integer.MIN_VALUE;
                } else {
                    minDistance[i][j] = -1;
                }
            }
        }

        // allowed directions
        int[] rows = { -1, 0, 0, 1 };
        int[] cols = { 0, -1, 1, 0 };

        while (!queue.isEmpty()) {

            Pair x = queue.poll();

            // new distance
            int dist = x.minDist + 1;

            for (int k = 0; k < rows.length; k++) {
                int new_i = x.i + rows[k];
                int new_j = x.j + cols[k];
                // enter into queue only when orange is fresh and valid coordinates are present
                if (new_i >= 0 && new_j >= 0 && new_i < n && new_j < m && A[new_i][new_j] == 1) {
                    // mark the orange as rotten
                    A[new_i][new_j] = 2;
                    // add new rotten orange/coordinate to queue
                    queue.add(new Pair(new_i, new_j, dist));
                    // update distance
                    minDistance[new_i][new_j] = dist;
                }
            }
        }

        // find max element from matrix
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (minDistance[i][j] == -1) {
                    // if it is not possible to rot any of the oranges
                    max = -1;
                    break;
                }
                max = Math.max(minDistance[i][j], max);
            }
            if (max == -1)
                break;
        }

        return max;
    }

    public static void main(String[] args) {

        q1_Rotten_Oranges t1 = new q1_Rotten_Oranges();
        int[][] A;

        // test case 1
        A = new int[][] {
                { 2, 1, 1 },
                { 1, 1, 0 },
                { 0, 1, 1 } };
        System.out.println(t1.solve(A)); // 4

        // test case 2
        A = new int[][] {
                { 2, 1, 1 },
                { 0, 1, 1 },
                { 1, 0, 1 } };
        System.out.println(t1.solve(A)); // -1

        // test case 3
        A = new int[][] {
                { 0, 2, 1 },
                { 2, 2, 1 },
                { 0, 1, 0 },
                { 2, 1, 1 },
                { 0, 1, 1 },
                { 1, 2, 1 } };
        System.out.println(t1.solve(A)); // 2

        // test case 4
        A = new int[][] {
                { 0, 0, 1, 1, 1, 1 },
                { 1, 2, 1, 1, 0, 2 },
                { 0, 0, 2, 2, 1, 1 },
                { 1, 1, 1, 1, 0, 0 },
                { 1, 2, 0, 0, 0, 1 },
                { 1, 0, 2, 1, 2, 0 } };
        System.out.println(t1.solve(A)); // -1

    }
}
