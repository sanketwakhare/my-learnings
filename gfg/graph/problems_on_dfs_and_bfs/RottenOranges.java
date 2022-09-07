package graph.problems_on_dfs_and_bfs;

import java.util.LinkedList;
import java.util.Queue;

/* Rotten Oranges */

/* https://practice.geeksforgeeks.org/problems/rotten-oranges2536/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=rotten_oranges */

class QueueData {
    int row;
    int col;
    int time;

    public QueueData(int row, int col, int time) {
        this.row = row;
        this.col = col;
        this.time = time;
    }
}

public class RottenOranges {

    public static void main(String[] args) {
        RottenOranges t1 = new RottenOranges();
        {
            int[][] grid = {
                    {0, 1, 2},
                    {0, 1, 2},
                    {2, 1, 1}};
            System.out.println(t1.orangesRotting(grid));
        }
        {
            int[][] grid = {
                    {0, 1, 2},
                    {1, 0, 2},
                    {0, 1, 1}};
            System.out.println(t1.orangesRotting(grid));
        }
        {
            int[][] grid = {
                    {0, 1, 2},
                    {0, 1, 1},
                    {1, 1, 0}};
            System.out.println(t1.orangesRotting(grid));
        }
    }

    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};

    //Function to find minimum time required to rot all oranges.
    public int orangesRotting(int[][] grid) {
        // Code here
        int n = grid.length;
        int m = grid[0].length;

        int[][] visited = new int[n][m];
        Queue<QueueData> queue = new LinkedList<>();
        int freshCount = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new QueueData(i, j, 0));
                    visited[i][j] = 1;
                } else {
                    visited[i][j] = 0;
                }
                if (grid[i][j] == 1) {
                    freshCount++;
                }
            }
        }

        int minTime = 0;
        int freshVisitedCount = 0;
        while (!queue.isEmpty()) {
            QueueData node = queue.poll();
            int currRow = node.row;
            int currCol = node.col;
            int currTime = node.time;
            minTime = Math.max(minTime, currTime);

            for (int index = 0; index < dx.length; index++) {
                int newRow = currRow + dx[index];
                int newCol = currCol + dy[index];
                // if new coordinate is fresh orange which is not visited already
                if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m &&
                        grid[newRow][newCol] == 1 && visited[newRow][newCol] == 0) {
                    // mark as visited
                    visited[newRow][newCol] = 1;
                    queue.add(new QueueData(newRow, newCol, currTime + 1));
                    freshVisitedCount++;
                }
            }
        }
        // System.out.println(freshCount + " " + freshVisitedCount);
        // if fresh oranges count is different, it means some fresh oranges are not rotten
        if (freshVisitedCount != freshCount) return -1;
        // otherwise return min time
        return minTime;
    }
}
