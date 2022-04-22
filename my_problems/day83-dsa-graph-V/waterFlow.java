/* Water Flow */

/* https://www.scaler.com/academy/mentee-dashboard/class/7327/assignment/problems/11949/?navref=cl_pb_nv_tb */

/* Problem Description

Given an N x M matrix A of non-negative integers representing the height of each unit cell in a continent, the "Blue lake" touches the left and top edges of the matrix and the "Red lake" touches the right and bottom edges.

Water can only flow in four directions (up, down, left, or right) from a cell to another one with height equal or lower.

Find the number of cells from where water can flow to both the Blue and Red lake.


Problem Constraints

1 <= M, N <= 1000
1 <= A[i][j] <= 10^9


Input Format
First and only argument is a 2D matrix A.


Output Format

Return an integer denoting the number of cells from where water can flow to both the Blue and Red lake



Example Input

Input 1:

 A = [
       [1, 2, 2, 3, 5]
       [3, 2, 3, 4, 4]
       [2, 4, 5, 3, 1]
       [6, 7, 1, 4, 5]
       [5, 1, 1, 2, 4]
     ]
Input 2:

 A = [
       [2, 2]
       [2, 2]
     ]


Example Output

Output 1:

 7
Output 2:

 4


Example Explanation

Explanation 1:

 Blue Lake ~   ~   ~   ~   ~ 
        ~  1   2   2   3  (5) *
        ~  3   2   3  (4) (4) *
        ~  2   4  (5)  3   1  *
        ~ (6) (7)  1   4   5  *
        ~ (5)  1   1   2   4  *
           *   *   *   *   * Red Lake
 Water can flow to both lakes from the cells denoted in parentheses.  
Explanation 2:

 Water can flow from all cells. */

import java.util.LinkedList;
import java.util.Queue;

public class waterFlow {

    // Custom cell class to store the coordinate and value
    class Cell {
        int value;
        int x;
        int y;

        public Cell(int value, int x, int y) {
            this.value = value;
            this.x = x;
            this.y = y;
        }
    }

    public int solve(int[][] A) {

        int N = A.length;
        int M = A[0].length;

        // visited arrays for blue and red lake
        boolean[][] blueLake = new boolean[N][M];
        boolean[][] redLake = new boolean[N][M];

        // maintain Queues to apply BFS
        Queue<Cell> blueQueue = new LinkedList<Cell>();
        Queue<Cell> redQueue = new LinkedList<Cell>();

        // add all possible sources for both the red and blue lake boundary
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (i == 0 || j == 0) {
                    blueQueue.add(new Cell(A[i][j], i, j));
                }
                if (i == N - 1 || j == M - 1) {
                    redQueue.add(new Cell(A[i][j], i, j));
                }
            }
        }

        int[] dx = new int[] { -1, 0, 0, 1 };
        int[] dy = new int[] { 0, -1, 1, 0 };

        // apply BFS on multi source - blue lake
        while (!blueQueue.isEmpty()) {
            Cell cell = blueQueue.poll();
            // mark visited
            blueLake[cell.x][cell.y] = true;

            for (int i = 0; i < dx.length; i++) {
                int x = cell.x + dx[i];
                int y = cell.y + dy[i];
                boolean isSafe = x >= 0 && y >= 0 && x < N && y < M;
                if (isSafe && cell.value <= A[x][y] && !blueLake[x][y]) {
                    blueQueue.add(new Cell(A[x][y], x, y));
                }
            }
        }

        // apply BFS on multi source - red lake
        while (!redQueue.isEmpty()) {
            Cell cell = redQueue.poll();
            // mark visited
            redLake[cell.x][cell.y] = true;

            for (int i = 0; i < dx.length; i++) {
                int x = cell.x + dx[i];
                int y = cell.y + dy[i];
                boolean isSafe = x >= 0 && y >= 0 && x < N && y < M;
                if (isSafe && cell.value <= A[x][y] && !redLake[x][y]) {
                    redQueue.add(new Cell(A[x][y], x, y));
                }
            }
        }

        // find the count of common elements from both visited arrays
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (blueLake[i][j] && redLake[i][j]) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        waterFlow t1 = new waterFlow();
        {
            int[][] A = new int[][] {
                    { 1, 2, 2, 3, 5 },
                    { 3, 2, 3, 4, 4 },
                    { 2, 4, 5, 3, 1 },
                    { 6, 7, 1, 4, 5 },
                    { 5, 1, 1, 2, 4 }
            };
            System.out.println(t1.solve(A)); // 7
        }
        {
            int[][] A = new int[][] {
                    { 2, 2 },
                    { 2, 2 }
            };
            System.out.println(t1.solve(A)); // 4
        }
        {
            int[][] A = new int[][] {
                    { 11, 20, 5, 18, 9, 4 },
                    { 16, 2, 3, 11, 12, 17 },
                    { 15, 1, 17, 2, 9, 20 },
                    { 9, 5, 2, 15, 14, 20 },
                    { 19, 19, 1, 9, 8, 8 },
                    { 9, 14, 9, 4, 8, 2 },
                    { 11, 18, 14, 15, 10, 17 },
                    { 16, 12, 1, 10, 20, 17 },
                    { 19, 4, 5, 9, 5, 10 },
                    { 10, 3, 16, 6, 14, 4 },
                    { 4, 8, 15, 4, 9, 1 },
                    { 19, 19, 1, 17, 19, 2 },
                    { 10, 19, 10, 18, 13, 3 }
            };
            System.out.println(t1.solve(A)); // 11
        }
    }
}
