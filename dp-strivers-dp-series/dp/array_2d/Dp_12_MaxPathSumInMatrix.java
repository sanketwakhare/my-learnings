package dp.array_2d;

/**
 * Maximum Path Sum in a Matrix
 *
 * <a href="https://www.codingninjas.com/codestudio/problems/maximum-path-sum-in-the-matrix_797998">Maximum Path Sum in a Matrix</a>
 */
public class Dp_12_MaxPathSumInMatrix {

    public static void main(String[] args) {
        Dp_12_MaxPathSumInMatrix obj = new Dp_12_MaxPathSumInMatrix();
        int[][] matrix = {
                {1, 2, 3},
                {4, 8, 2},
                {1, 5, 3}};
        int minSum = obj.getMaxPathSum(matrix);
        System.out.println(minSum); // 16

        int[][] matrix2 = {
                {1, 2, 3},
                {4, 8, 2},
                {1, 5, 3},
                {6, 2, 9}};
        minSum = obj.getMaxPathSum(matrix2);
        System.out.println(minSum); // 25
    }

    public int getMaxPathSum(int[][] matrix) {
        int[] dx = {-1, -1, -1};
        int[] dy = {-1, 0, 1};

        int n = matrix.length;
        int m = matrix[0].length;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int max = Integer.MIN_VALUE;
                for (int k = 0; k < dx.length; k++) {
                    int row = i + dx[k];
                    int col = j + dy[k];
                    if (row >= 0 && col >= 0 && row < n && col < m) {
                        max = Math.max(max, matrix[row][col]);
                    }
                }
                matrix[i][j] += max;
            }
        }
        int max = Integer.MIN_VALUE;
        for (int j = 0; j < m; j++) {
            max = Math.max(matrix[n - 1][j], max);
        }

        return max;
    }
}
