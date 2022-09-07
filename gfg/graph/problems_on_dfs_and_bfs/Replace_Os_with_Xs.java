package graph.problems_on_dfs_and_bfs;

import java.util.Arrays;

/* Replace O's with X's */

/* https://practice.geeksforgeeks.org/problems/replace-os-with-xs0052/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=replace-os-with-xs */

public class Replace_Os_with_Xs {

    public static void main(String[] args) {
        Replace_Os_with_Xs t1 = new Replace_Os_with_Xs();
        {
            char[][] grid = {
                    {'X', 'X', 'X', 'X'},
                    {'X', 'O', 'X', 'X'},
                    {'X', 'O', 'O', 'X'},
                    {'X', 'O', 'X', 'X'},
                    {'X', 'X', 'O', 'O'}};
            grid = t1.fill(grid.length, grid[0].length, grid);
            for (char[] row : grid) {
                System.out.println(Arrays.toString(row));
            }
            /* expected:
                [X, X, X, X]
                [X, X, X, X]
                [X, X, X, X]
                [X, X, X, X]
                [X, X, O, O]
            */

        }
        {
            char[][] grid = {
                    {'X', 'X', 'X', 'X', 'X'},
                    {'O', 'X', 'X', 'X', 'O'},
                    {'O', 'X', 'X', 'O', 'X'},
                    {'X', 'X', 'X', 'O', 'O'}};
            grid = t1.fill(grid.length, grid[0].length, grid);
            for (char[] row : grid) {
                System.out.println(Arrays.toString(row));
            }
            /* expected:
                [X, X, X, X, X]
                [O, X, X, X, O]
                [O, X, X, O, X]
                [X, X, X, O, O]
            */
        }
    }

    public char[][] fill(int n, int m, char[][] a) {
        // code here
        // idea : apply dfs or bfs on boundary
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 || j == 0 || i == n - 1 || j == m - 1) {
                    if (a[i][j] == 'O') {
                        dfs(a, i, j, n, m);
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (a[i][j] == 'O') a[i][j] = 'X';
                if (a[i][j] == 'N') a[i][j] = 'O';
            }
        }
        return a;
    }

    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};

    public void dfs(char[][] grid, int i, int j, int n, int m) {
        if (i < 0 || i >= n || j < 0 || j >= m) return;
        // mark as visited
        grid[i][j] = 'N';
        for (int index = 0; index < dx.length; index++) {
            int newRow = i + dx[index];
            int newCol = j + dy[index];
            if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && grid[newRow][newCol] == 'O') {
                dfs(grid, newRow, newCol, n, m);
            }
        }
    }
}
