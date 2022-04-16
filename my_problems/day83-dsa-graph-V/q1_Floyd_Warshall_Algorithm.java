/* Floyd Warshall Algorithm */

/* Problem Description
Given a matrix of integers A of size N x N, where A[i][j] represents the weight of directed edge from i to j (i ---> j).

If i == j, A[i][j] = 0, and if there is no directed edge from vertex i to vertex j, A[i][j] = -1.

Return a matrix B of size N x N where B[i][j] = shortest path from vertex i to vertex j.

If there is no possible path from vertex i to vertex j , B[i][j] = -1

Note: Rows are numbered from top to bottom and columns are numbered from left to right.


Problem Constraints
1 <= N <= 200
-1 <= A[i][j] <= 1000000

Input Format
The first and only argument given is the integer matrix A.


Output Format
Return a matrix B of size N x N where B[i][j] = shortest path from vertex i to vertex j
If there is no possible path from vertex i to vertex j, B[i][j] = -1.


Example Input
A = [ [0 , 50 , 39]
          [-1 , 0 , 1]
          [-1 , 10 , 0] ]


Example Output
[ [0 , 49 , 39 ]
   [-1 , 0 , -1 ]
   [-1 , 10 , 0 ] ]


Example Explanation
Shortest Path from 1 to 2 would be 1 ---> 3 ---> 2 and not directly from 1 to 2,
All remaining distances remains same. */

/**
 * TC: O(N^3)
 */
public class q1_Floyd_Warshall_Algorithm {

    public int[][] solve(int[][] A) {

        int N = A.length;
        int M = A[0].length;

        // replace -1 with Max value
        // this will be helpful to find the min sum
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (A[i][j] == -1) {
                    A[i][j] = 1000001;
                }
            }
        }

        // Floyd Warshall Algorithm
        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    A[i][j] = Math.min(A[i][j], A[i][k] + A[k][j]);
                }
            }
        }

        // replace Max value = 1000001 with -1
        // the paths which were not reacheable, reinitialize them with -1
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (A[i][j] == 1000001) {
                    A[i][j] = -1;
                }
            }
        }

        return A;
    }

    public static void main(String[] args) {

        q1_Floyd_Warshall_Algorithm t1 = new q1_Floyd_Warshall_Algorithm();
        int[][] A, output;
        {
            A = new int[][] {
                    { 0, 50, 39 },
                    { -1, 0, 1 },
                    { -1, 10, 0 } };
            output = t1.solve(A);
            ArrayUtils.print2DArray(output);
            /*
             * expected output
             * [[0, 49, 39],
             * [-1, 0, 1],
             * [-1, 10, 0]]
             */
        }
        {
            A = new int[][] {

                    { 0, 5, -1, 10 },
                    { -1, 0, 3, -1 },
                    { -1, -1, 0, 1 },
                    { -1, -1, -1, 0 }
            };
            output = t1.solve(A);
            ArrayUtils.print2DArray(output);
            /*
             * expected output
             * [[0, 5, 8, 9],
             * [-1, 0, 3, 4],
             * [-1, -1, 0, 1],
             * [-1, -1, -1, 0]]
             */
        }
    }
}
