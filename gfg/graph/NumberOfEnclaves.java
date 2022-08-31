package graph;

/* Number Of Enclaves */

/* https://practice.geeksforgeeks.org/problems/number-of-enclaves/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=number-of-enclaves */

public class NumberOfEnclaves {
    public static void main(String[] args) {

        NumberOfEnclaves t1 = new NumberOfEnclaves();
        {
            int[][] grid = {
                    {0, 0, 0, 0},
                    {1, 0, 1, 0},
                    {0, 1, 1, 0},
                    {0, 0, 0, 0}};
            System.out.println(t1.numberOfEnclaves(grid)); // 3
        }
        {
            int[][] grid = {
                    {0, 0, 0, 1},
                    {0, 1, 1, 0},
                    {0, 1, 1, 0},
                    {0, 0, 0, 1},
                    {0, 1, 1, 0}};
            System.out.println(t1.numberOfEnclaves(grid)); // 4
        }
    }

    int numberOfEnclaves(int[][] grid) {

        // Your code here
        int n = grid.length;
        int m = grid[0].length;
        // apply dfs on land cells which re part of boundary
        // and find out which land cells are connected to boundary
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 || j == 0 || i == n - 1 || j == m - 1) {
                    if (grid[i][j] == 1) {
                        dfs(grid, i, j, n, m);
                    }
                }
            }
        }

        // count all land cells i.e. all 1s
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) count++;
            }
        }
        return count;
    }

    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};

    public void dfs(int[][] grid, int i, int j, int n, int m) {
        if (i < 0 || i >= n || j < 0 || j >= m) return;
        // mark as visited
        grid[i][j] = 0;
        for (int index = 0; index < dx.length; index++) {
            int newRow = i + dx[index];
            int newCol = j + dy[index];
            if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && grid[newRow][newCol] == 1) {
                dfs(grid, newRow, newCol, n, m);
            }
        }
    }
}
