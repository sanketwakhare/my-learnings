package graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/* Distance of nearest cell having 1 */

/* https://practice.geeksforgeeks.org/problems/distance-of-nearest-cell-having-1-1587115620/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=distance-of-nearest-cell-having-1 */

class QueueNode {
    int row;
    int col;
    int dist;

    public QueueNode(int row, int col, int dist) {
        this.row = row;
        this.col = col;
        this.dist = dist;
    }
}

public class Distance_of_Nearest_cell_having_1 {

    public static void main(String[] args) {
        Distance_of_Nearest_cell_having_1 t1 = new Distance_of_Nearest_cell_having_1();
        {
            int[][] grid = {
                    {0, 1, 1, 0},
                    {1, 1, 0, 0},
                    {0, 0, 1, 1}};
            int[][] dist = t1.nearest(grid);
            printGrid(dist);
        }
        {
            int[][] grid = {
                    {0, 0, 1, 0},
                    {1, 0, 0, 0},
                    {0, 0, 0, 1}};
            int[][] dist = t1.nearest(grid);
            printGrid(dist);
        }
        {
            int[][] grid = {
                    {0, 0, 0, 0},
                    {1, 0, 0, 0},
                    {0, 0, 0, 0}};
            int[][] dist = t1.nearest(grid);
            printGrid(dist);
        }
    }

    private static void printGrid(int[][] dist) {
        for (int[] row : dist) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println("-------------");
    }

    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};

    //Function to find distance of nearest 1 in the grid for each cell.
    public int[][] nearest(int[][] grid) {
        // Code here
        int n = grid.length;
        int m = grid[0].length;
        int[][] dist = new int[n][m];
        int[][] visited = new int[n][m];
        Queue<QueueNode> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    queue.add(new QueueNode(i, j, 0));
                    visited[i][j] = 1;
                    dist[i][j] = 0;
                }
            }
        }

        while (!queue.isEmpty()) {
            QueueNode node = queue.poll();
            int currRow = node.row;
            int currCol = node.col;
            int currDist = node.dist;

            for (int index = 0; index < dx.length; index++) {
                int newRow = currRow + dx[index];
                int newCol = currCol + dy[index];
                int newDist = currDist + 1;
                if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && grid[newRow][newCol] == 0 && visited[newRow][newCol] == 0) {
                    visited[newRow][newCol] = 1;
                    dist[newRow][newCol] = newDist;
                    queue.add(new QueueNode(newRow, newCol, newDist));
                }
            }
        }

        return dist;
    }
}
