import java.util.Arrays;
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

    // 1 - left
    // 2 - top
    // 3 - right
    // 4 - down

    class QNode {
        // current cell coordinates
        Coordinate cell;
        // current distance from source
        int dist;
        // stores the direction from which the ball has come
        int direction;

        public QNode(Coordinate cell, int dist, int direction) {
            this.cell = cell;
            this.dist = dist;
            this.direction = direction;
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

        // initialize 4 2d arrays to store state of visited from specific direction
        int[][] leftVisited = new int[n][m];
        int[][] topVisited = new int[n][m];
        int[][] rightVisited = new int[n][m];
        int[][] bottomVisited = new int[n][m];

        // single source
        Queue<QNode> queue = new LinkedList<QNode>();
        queue.add(new QNode(new Coordinate(B[0], B[1]), 0, 1));
        queue.add(new QNode(new Coordinate(B[0], B[1]), 0, 2));
        queue.add(new QNode(new Coordinate(B[0], B[1]), 0, 3));
        queue.add(new QNode(new Coordinate(B[0], B[1]), 0, 4));
        // mark all initial source(s) as visited
        leftVisited[B[0]][B[1]] = 1;
        topVisited[B[0]][B[1]] = 1;
        rightVisited[B[0]][B[1]] = 1;
        bottomVisited[B[0]][B[1]] = 1;

        int minDistance = Integer.MAX_VALUE;

        int[] rows = new int[] { 0, 0, -1, 0, 1 };
        int[] cols = new int[] { 0, -1, 0, 1, 0 };
        while (!queue.isEmpty()) {
            QNode currQNode = queue.poll();
            Coordinate temp = currQNode.cell;
            int prevDir = currQNode.direction;

            int new_x = temp.x + rows[prevDir];
            int new_y = temp.y + cols[prevDir];
            if (temp.x == C[0] && temp.y == C[1]) {
                // reached destination
                boolean isWallFound = new_x < 0 || new_y < 0 || new_x >= n || new_y >= m || A[new_x][new_y] == 1;
                if (isWallFound) {
                    minDistance = Math.min(minDistance, currQNode.dist);
                }
            }

            boolean canTravelInSameDirection = new_x >= 0 && new_y >= 0 && new_x < n && new_y < m
                    && A[new_x][new_y] == 0;
            if (canTravelInSameDirection) {
                // if ball can travel in same direction
                boolean isSafe = isSafeToAddInQueue(new_x, new_y, prevDir, leftVisited, topVisited, rightVisited,
                        bottomVisited);
                if (isSafe) {
                    queue.add(new QNode(new Coordinate(new_x, new_y), currQNode.dist + 1, prevDir));
                }
            } else {
                // if wall is found or boundary is reached, try other possibilities except
                // previous direction
                for (int i = 1; i < rows.length; i++) {
                    int newDirection = i;
                    if (newDirection == prevDir) {
                        continue;
                    }
                    new_x = temp.x + rows[i];
                    new_y = temp.y + cols[i];
                    boolean canTravelInNewDirection = new_x >= 0 && new_y >= 0 && new_x < n && new_y < m
                            && A[new_x][new_y] == 0;
                    if (canTravelInNewDirection) {
                        boolean isSafe = isSafeToAddInQueue(new_x, new_y, newDirection, leftVisited, topVisited,
                                rightVisited,
                                bottomVisited);
                        if (isSafe) {
                            queue.add(new QNode(new Coordinate(new_x, new_y), currQNode.dist + 1, newDirection));
                        }
                    }
                }
            }
        }
        if (minDistance != Integer.MAX_VALUE) {
            return minDistance;
        }
        return -1;
    }

    private boolean isSafeToAddInQueue(int x, int y, int previousDirection, int[][] leftVisited,
            int[][] topVisited,
            int[][] rightVisited, int[][] bottomVisited) {

        boolean isUnvisited = true;
        // if there is empty space in same direction
        switch (previousDirection) {
            case 1:
                if (leftVisited[x][y] == 1) {
                    isUnvisited = false;
                } else {
                    leftVisited[x][y] = 1;
                }
                break;
            case 2:
                if (topVisited[x][y] == 1) {
                    isUnvisited = false;
                } else {
                    topVisited[x][y] = 1;
                }
                break;
            case 3:
                if (rightVisited[x][y] == 1) {
                    isUnvisited = false;
                } else {
                    rightVisited[x][y] = 1;
                }
                break;
            case 4:
                if (bottomVisited[x][y] == 1) {
                    isUnvisited = false;
                } else {
                    bottomVisited[x][y] = 1;
                }
                break;
        }
        return isUnvisited;
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
            int minDistance = t1.solve(A, B, C);
            System.out.println(minDistance);
        }
        {
            A = new int[][] {
                    { 0, 0, 1 },
                    { 1, 0, 1 },
                    { 0, 0, 0 },
                    { 1, 0, 0 },
                    { 0, 0, 1 },
                    { 1, 1, 1 },
                    { 0, 0, 1 },
                    { 1, 0, 1 },
                    { 0, 0, 0 }
            };
            B = new int[] { 3, 2 };
            C = new int[] { 2, 0 };
            int minDistance = t1.solve(A, B, C);
            System.out.println(minDistance);
        }
    }
}
