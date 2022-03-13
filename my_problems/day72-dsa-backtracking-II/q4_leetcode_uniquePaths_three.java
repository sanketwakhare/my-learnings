/* 
Unique Paths III

https://leetcode.com/problems/unique-paths-iii/

You are given an m x n integer array grid where grid[i][j] could be:

1 representing the starting square. There is exactly one starting square.
2 representing the ending square. There is exactly one ending square.
0 representing empty squares we can walk over.
-1 representing obstacles that we cannot walk over.
Return the number of 4-directional walks from the starting square to the ending square, that walk over every non-obstacle square exactly once.


Example 1:


Input: grid = [[1,0,0,0],[0,0,0,0],[0,0,2,-1]]
Output: 2
Explanation: We have the following two paths: 
1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2)
2. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2)
Example 2:


Input: grid = [[1,0,0,0],[0,0,0,0],[0,0,0,2]]
Output: 4
Explanation: We have the following four paths: 
1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2),(2,3)
2. (0,0),(0,1),(1,1),(1,0),(2,0),(2,1),(2,2),(1,2),(0,2),(0,3),(1,3),(2,3)
3. (0,0),(1,0),(2,0),(2,1),(2,2),(1,2),(1,1),(0,1),(0,2),(0,3),(1,3),(2,3)
4. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2),(2,3)
Example 3:


Input: grid = [[0,1],[2,0]]
Output: 0
Explanation: There is no path that walks over every empty square exactly once.
Note that the starting and ending square can be anywhere in the grid.
 

Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 20
1 <= m * n <= 20
-1 <= grid[i][j] <= 2
There is exactly one starting cell and one ending cell.

*/

import java.util.ArrayList;
import java.util.List;

public class q4_leetcode_uniquePaths_three {

    public int uniquePathsIII(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;
        List<int[][]> paths = new ArrayList<int[][]>();

        int startRowIndex = 0;
        int startColIndex = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    startRowIndex = i;
                    startColIndex = j;
                    break;
                }
            }
        }
        uniquePaths(startRowIndex, startColIndex, grid, paths, n, m);

        System.out.println(paths.size());
        return paths.size();

    }

    public void uniquePaths(int i, int j, int[][] grid, List<int[][]> paths, int n, int m) {

        if (i < 0 || j < 0 || i == n || j == m || grid[i][j] == -1 || grid[i][j] == 3) {
            return;
        }

        if (grid[i][j] == 2) {
            // reached to destination
            if (isUniquePath(grid)) {
                int[][] temp = new int[n][m];
                for (int p = 0; p < n; p++) {
                    for (int q = 0; q < m; q++) {
                        temp[p][q] = grid[p][q];
                    }
                }
                paths.add(temp);
            }
            return;

        }

        // mark visited
        grid[i][j] = 3;

        uniquePaths(i - 1, j, grid, paths, n, m);
        uniquePaths(i + 1, j, grid, paths, n, m);
        uniquePaths(i, j - 1, grid, paths, n, m);
        uniquePaths(i, j + 1, grid, paths, n, m);

        grid[i][j] = 0;

    }

    private boolean isUniquePath(int[][] grid) {
        boolean shouldBeIncluded = true;
        for (int p = 0; p < grid.length; p++) {
            for (int q = 0; q < grid[0].length; q++) {
                if (grid[p][q] == 0) {
                    // do not include this path
                    shouldBeIncluded = false;
                    break;
                }
            }
            if (!shouldBeIncluded) {
                break;
            }
        }
        return shouldBeIncluded;
    }

    public static void main(String[] args) {

        // test case 1
        int[][] grid = new int[][] { { 1, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 2, -1 } };
        q4_leetcode_uniquePaths_three t1 = new q4_leetcode_uniquePaths_three();
        t1.uniquePathsIII(grid); // 2

        // test case 2
        grid = new int[][] { { 1, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 2 } };
        t1.uniquePathsIII(grid); // 4

        // test case 3
        grid = new int[][] { { 0, 1 }, { 2, 0 } };
        t1.uniquePathsIII(grid); // 0

    }
}