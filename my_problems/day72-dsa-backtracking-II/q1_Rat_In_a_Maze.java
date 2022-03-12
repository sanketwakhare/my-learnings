/* Rat In a Maze */

/* Problem Description

Given a grid A, a rat is at position (1, 1). He wants to go to the position (n, n) where n is size of the square matrix A.

1 represents a traversable cell and 0 represents a non-traversable cell. Rat can only move right or down.

Return a path that the rat can take.


Problem Constraints
1 <= |A| <= 4


Input Format
First and only argument is the vector of vectors A.


Output Format
Return a vector of vectors that denotes a path that can be taken.


Example Input

Input 1:

A = [   [1, 0]
        [1, 1]
    ]
Input 2:

A = [    [1, 1, 1]
         [1, 0, 1]
         [0, 0, 1]
    ]


Example Output

Output 1:

[   [1, 0]
    [1, 1]
]
Output 2:

[    [1, 1, 1]
     [0, 0, 1]
     [0, 0, 1]
]


Example Explanation

Explanation 1:

 Path is shown in output.
Explanation 2:

 Path is shown in output. */

/**
 * TC: O(MxN) - each array element will be visited only once
 * SC: O(NxM) - max-height of the recursion tree will be N
 */
public class q1_Rat_In_a_Maze {

    public int[][] solve(int[][] A) {
        int N = A.length;
        int M = A[0].length;
        int[][] path = new int[N][M];
        traverse(0, 0, A, path, N, M);
        return path;
    }

    public boolean traverse(int i, int j, int[][] A, int[][] path, int n, int m) {

        // base conditions to check if path is found
        if (i + 1 == n && j + 1 == m) {
            // path found
            path[i][j] = A[i][j];
            return true;
        }

        // base conditions where we can't move next
        if (i < 0 || j < 0 || i >= n || j >= m || A[i][j] == 2 || A[i][j] == 0) {
            return false;
        }

        // update path
        path[i][j] = A[i][j];
        // mark as visited
        A[i][j] = 2;

        if (traverse(i + 1, j, A, path, n, m) || traverse(i, j + 1, A, path, n, m)) {
            return true;
        }
        // revert path state as we are backtracking
        path[i][j] = 0;
        // mark as unvisited
        A[i][j] = 1;
        return false;
    }

    public static void main(String[] args) {
        q1_Rat_In_a_Maze t1 = new q1_Rat_In_a_Maze();
        int[][] A1 = new int[][] {
                new int[] { 1, 0 },
                new int[] { 1, 1 } };
        int[][] output = t1.solve(A1);
        System.out.println(output);
        ArrayUtils.print2DArray(output);
        /*
         * expected answer:-
         * [[1, 0],
         * [1, 1]]
         */

        int[][] A2 = new int[][] {
                new int[] { 1, 1, 1 },
                new int[] { 1, 0, 1 },
                new int[] { 0, 0, 1 } };
        output = t1.solve(A2);
        System.out.println(output);
        ArrayUtils.print2DArray(output);
        /*
         * expected answer:-
         * [[1, 1, 1],
         * [0, 0, 1],
         * [0, 0, 1]]
         */

        int[][] A3 = new int[][] {
                new int[] { 1, 1, 1, 0, 1, 1, 1 },
                new int[] { 1, 0, 1, 0, 1, 0, 1 },
                new int[] { 1, 0, 1, 1, 0, 1, 1 },
                new int[] { 1, 1, 0, 1, 0, 1, 0 },
                new int[] { 0, 1, 0, 1, 1, 1, 1 },
                new int[] { 1, 1, 1, 0, 1, 0, 1 } };
        output = t1.solve(A3);
        System.out.println(output);
        ArrayUtils.print2DArray(output);
        /*
         * expected answer:-
         * [
         * [1, 1, 1, 0, 0, 0, 0],
         * [0, 0, 1, 0, 0, 0, 0],
         * [0, 0, 1, 1, 0, 0, 0],
         * [0, 0, 0, 1, 0, 0, 0],
         * [0, 0, 0, 1, 1, 1, 1],
         * [0, 0, 0, 0, 0, 0, 1]]
         */
    }

}
