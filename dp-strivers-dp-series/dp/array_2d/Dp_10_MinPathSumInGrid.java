package dp.array_2d;

/**
 * Minimum Path Sum in a Grid
 *
 * <a href="https://www.codingninjas.com/codestudio/problems/minimum-path-sum_985349">Minimum Path Sum in a Grid</a>
 */
public class Dp_10_MinPathSumInGrid {

    public static void main(String[] args) {
        Dp_10_MinPathSumInGrid obj = new Dp_10_MinPathSumInGrid();
        int[][] grid = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}};
        int minSum = obj.minSumPath(grid);
        System.out.println(minSum); // 7

        int[][] grid2 = {
                {1, 2, 8},
                {4, 5, 6}};
        minSum = obj.minSumPath(grid2);
        System.out.println(minSum); // 14
    }

    public int minSumPath(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        // for cells in first colums, there is only single way to reach there
        for (int i = 1; i < n; i++) {
            grid[i][0] += grid[i - 1][0];
        }

        // for cells in first row
        for (int j = 1; j < m; j++) {
            grid[0][j] += grid[0][j - 1];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
            }
        }
        return grid[n - 1][m - 1];
    }
}
