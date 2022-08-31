import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* Pacific Atlantic Water Flow */

// https://leetcode.com/problems/pacific-atlantic-water-flow/
public class PacificAtlanticWaterFlow {

    public static void main(String[] args) {
        PacificAtlanticWaterFlow t1 = new PacificAtlanticWaterFlow();
        t1.pacificAtlantic(new int[][]{{1, 2, 2, 3, 5}, {3, 2, 3, 4, 4}, {2, 4, 5, 3, 1}, {6, 7, 1, 4, 5}, {5, 1, 1, 2, 4}});
        t1.pacificAtlantic(new int[][]{{1, 1}, {1, 1}, {1, 1}});
    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        // initialize
        int n = heights.length;
        int m = heights[0].length;
        int[][] pacificOcean = new int[n][m];
        int[][] atlanticOcean = new int[n][m];

        // apply dfs on top boundary of grid connecting pacificOcean
        for (int i = 0; i < n; i++) {
            if (pacificOcean[i][0] == 0)
                dfs(heights, i, 0, n, m, pacificOcean);
        }
        // apply dfs on left boundary of grid connecting pacificOcean
        for (int j = 1; j < m; j++) {
            if (pacificOcean[0][j] == 0)
                dfs(heights, 0, j, n, m, pacificOcean);
        }
        // apply dfs on bottom boundary of grid connecting atlanticOcean
        for (int i = 0; i < n; i++) {
            if (atlanticOcean[i][m - 1] == 0)
                dfs(heights, i, m - 1, n, m, atlanticOcean);
        }
        // apply dfs on right boundary of grid connecting atlanticOcean
        for (int j = 0; j < m - 1; j++) {
            if (atlanticOcean[n - 1][j] == 0)
                dfs(heights, n - 1, j, n, m, atlanticOcean);
        }
        for (int[] row : pacificOcean)
            System.out.println(Arrays.toString(row));

        for (int[] row : atlanticOcean)
            System.out.println(Arrays.toString(row));

        // select common coordinates which are 1
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (pacificOcean[i][j] == 1 && atlanticOcean[i][j] == 1) {
                    result.add(List.of(i, j));
                }
            }
        }
        System.out.println(result);
        return result;
    }

    int[] dx = {0, 0, 1, -1};
    int[] dy = {-1, 1, 0, 0};

    // dfs
    public void dfs(int[][] A, int i, int j, int n, int m, int[][] visited) {
        if (i < 0 || i >= n || j < 0 || j >= m) return;

        visited[i][j] = 1;

        for (int index = 0; index < dx.length; index++) {
            int newRow = i + dx[index];
            int newCol = j + dy[index];
            if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m &&
                    visited[newRow][newCol] == 0 && A[newRow][newCol] >= A[i][j]) {
                dfs(A, newRow, newCol, n, m, visited);
            }
        }
    }
}