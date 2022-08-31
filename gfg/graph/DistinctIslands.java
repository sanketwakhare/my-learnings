package graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* Number of Distinct Islands */

/* https://practice.geeksforgeeks.org/problems/number-of-distinct-islands/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=number-of-distinct-islands */

public class DistinctIslands {

    public static void main(String[] args) {
        DistinctIslands t1 = new DistinctIslands();
        {
            int[][] grid = {
                    {1, 1, 0, 1, 1},
                    {1, 1, 0, 0, 0},
                    {0, 0, 0, 1, 1},
                    {1, 1, 0, 1, 1}};
            System.out.println(t1.countDistinctIslands(grid));
        }
        {
            int[][] grid = {
                    {1, 1, 0, 0, 1},
                    {1, 1, 0, 1, 1},
                    {0, 0, 1, 0, 0},
                    {0, 1, 0, 1, 0},
                    {1, 0, 0, 0, 1},
                    {1, 1, 0, 1, 1}};
            System.out.println(t1.countDistinctIslands(grid));
        }
    }

    static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (x != pair.x) return false;
            return y == pair.y;
        }

        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            return result;
        }
    }

    int countDistinctIslands(int[][] grid) {
        // Your Code here
        int n = grid.length;
        int m = grid[0].length;
        Set<List<Pair>> distinctIslands = new HashSet<>();
        int[][] visited = new int[n][m];
        List<Pair> list;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visited[i][j] == 0 && grid[i][j] == 1) {
                    // initialize new list
                    list = new ArrayList<>();
                    // insert base coordinate
                    list.add(new Pair(0, 0));
                    // mark base coordinate as visited
                    visited[i][j] = 1;
                    dfs(grid, i, j, n, m, i, j, visited, list);
                    distinctIslands.add(list);
                }
            }
        }
        return distinctIslands.size();
    }

    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};

    public void dfs(int[][] grid, int i, int j, int n, int m, int baseRow, int baseCol,
                    int[][] visited,
                    List<Pair> currIsland) {

        if (i < 0 || i >= n || j < 0 || j >= m) return;

        for (int index = 0; index < dx.length; index++) {
            int newRow = i + dx[index];
            int newCol = j + dy[index];
            if (isSafe(newRow, newCol, n, m, grid, visited)) {
                // mark as visited
                visited[newRow][newCol] = 1;
                // update current list of coordinates
                currIsland.add(new Pair(newRow - baseRow, newCol - baseCol));
                dfs(grid, newRow, newCol, n, m, baseRow, baseCol, visited, currIsland);
            }
        }
    }

    public boolean isSafe(int i, int j, int n, int m, int[][] grid, int[][] visited) {
        return i >= 0 && i < n && j >= 0 && j < m && visited[i][j] == 0 && grid[i][j] == 1;
    }
}