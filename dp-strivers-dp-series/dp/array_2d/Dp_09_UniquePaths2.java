package dp.array_2d;

import java.util.ArrayList;
import java.util.List;

/**
 * Unique Paths II
 * <p>
 * <a href="https://www.codingninjas.com/codestudio/problems/maze-obstacles_977241">Unique Paths II</a>
 */
public class Dp_09_UniquePaths2 {

    public static void main(String[] args) {
        Dp_09_UniquePaths2 t1 = new Dp_09_UniquePaths2();
        {
            ArrayList<ArrayList<Integer>> mat = new ArrayList<>();
            mat.add(new ArrayList<>(List.of(0, 0, 0)));
            mat.add(new ArrayList<>(List.of(0, -1, 0)));
            mat.add(new ArrayList<>(List.of(0, 0, 0)));
            System.out.println(t1.mazeObstacles(3, 3, mat));
        }
        {
            ArrayList<ArrayList<Integer>> mat = new ArrayList<>();
            mat.add(new ArrayList<>(List.of(0, 0, 0)));
            mat.add(new ArrayList<>(List.of(0, -1, 0)));
            mat.add(new ArrayList<>(List.of(0, 0, 0)));
            mat.add(new ArrayList<>(List.of(0, 0, 0)));
            System.out.println(t1.mazeObstacles(4, 3, mat));
        }
        {
            ArrayList<ArrayList<Integer>> mat = new ArrayList<>();
            mat.add(new ArrayList<>(List.of(0, 0, 0)));
            mat.add(new ArrayList<>(List.of(0, -1, 0)));
            mat.add(new ArrayList<>(List.of(0, 0, 0)));
            mat.add(new ArrayList<>(List.of(0, 0, 0)));
            mat.add(new ArrayList<>(List.of(0, 0, 0)));
            System.out.println(t1.mazeObstacles(5, 3, mat));
        }
    }

    public int mazeObstacles(int n, int m, ArrayList<ArrayList<Integer>> mat) {

        long p = 1000000007;
        long[][] grid = new long[n][m];

        for (int j = 0; j < m; j++) {
            if (mat.get(0).get(j) != -1) {
                grid[0][j] = 1;
            } else break;
        }
        for (int i = 0; i < n; i++) {
            if (mat.get(i).get(0) != -1) {
                grid[i][0] = 1;
            } else break;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (mat.get(i).get(j) != -1) {
                    grid[i][j] = (grid[i][j - 1] % p + grid[i - 1][j] % p) % p;
                }
            }
        }
        return (int) grid[n - 1][m - 1];
    }
}
