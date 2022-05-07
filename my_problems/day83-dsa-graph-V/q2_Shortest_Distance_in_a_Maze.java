import java.util.LinkedList;
import java.util.Queue;

/* Shortest Distance in a Maze */

/* Problem Description
Given a matrix of integers A of size N x M describing a maze. The maze consists of empty locations and walls.

1 represents a wall in a matrix and 0 represents an empty location in a wall.

There is a ball trapped in a maze. The ball can go through empty spaces by rolling up, down, left or right, but it won't stop rolling until hitting a wall (maze boundary is also considered as a wall). When the ball stops, it could choose the next direction.

Given two array of integers of size B and C of size 2 denoting the starting and destination position of the ball.

Find the shortest distance for the ball to stop at the destination. The distance is defined by the number of empty spaces traveled by the ball from the starting position (excluded) to the destination (included). If the ball cannot stop at the destination, return -1.


Problem Constraints
2 <= N, M <= 100
0 <= A[i] <= 1
0 <= B[i][0], C[i][0] < N
0 <= B[i][1], C[i][1] < M


Input Format
The first argument given is the integer matrix A.

The second argument given is an array of integer B.

The third argument if an array of integer C.



Output Format
Return a single integer, the minimum distance required to reach destination



Example Input
Input 1:

A = [ [0, 0], [0, 0] ]
B = [0, 0]
C = [0, 1]
Input 2:

A = [ [0, 0], [0, 1] ]
B = [0, 0]
C = [0, 1]


Example Output
Output 1:

 1
Output 2:

 1


Example Explanation
Explanation 1:

 Go directly from start to destination in distance 1.
Explanation 2:

 Go directly from start to destination in distance 1. */
public class q2_Shortest_Distance_in_a_Maze {

    class Pair {
        Coordinate cell;
        int dist;

        public Pair(Coordinate cell, int dist) {
            this.cell = cell;
            this.dist = dist;
        }
    }

    class Coordinate {
        int x;
        int y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int solve(int[][] A, int[] B, int[] C) {

        // Idea: Apply BFS traversal to find the shortest distance from source to
        // destination
        // mark visited cell as 1 [visited]
        int n = A.length;
        int m = A[0].length;

        // single source
        Queue<Pair> queue = new LinkedList<Pair>();
        queue.add(new Pair(new Coordinate(B[0], B[1]), 0));
        // mark source as visited
        A[B[0]][B[1]] = 1;

        int[] rows = new int[] { -1, 0, 0, 1 };
        int[] cols = new int[] { 0, -1, 1, 0 };
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            Coordinate temp = pair.cell;

            if (temp.x == C[0] && temp.y == C[1]) {
                // reached destination
                return pair.dist;
            }

            for (int i = 0; i < rows.length; i++) {
                int new_x = temp.x + rows[i];
                int new_y = temp.y + cols[i];
                boolean isSafe = new_x >= 0 && new_y >= 0 && new_x < n && new_y < m && A[new_x][new_y] == 0;
                if (isSafe) {
                    queue.add(new Pair(new Coordinate(new_x, new_y), pair.dist + 1));
                    A[new_x][new_y] = 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        q2_Shortest_Distance_in_a_Maze t1 = new q2_Shortest_Distance_in_a_Maze();
        int[][] A;
        int[] B, C;
        {
            A = new int[][] {
                    { 1, 1, 0, 1 },
                    { 0, 0, 0, 1 },
                    { 1, 0, 0, 1 },
                    { 0, 0, 1, 0 }
            };
            B = new int[] { 1, 1 };
            C = new int[] { 2, 1 };
            t1.solve(A, B, C);
        }
    }
}
