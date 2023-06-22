package dp.array_2d;

/**
 * Minimum Path Sum in a Triangle
 *
 * <a href="https://www.codingninjas.com/codestudio/problems/triangle_1229398">Minimum Path Sum in a Triangle</a>
 */
public class Dp_11_MinPathSumInTriangle {

    public static void main(String[] args) {
        Dp_11_MinPathSumInTriangle obj = new Dp_11_MinPathSumInTriangle();
        int[][] triangle = {
                {2},
                {3, 4},
                {6, 5, 7},
                {4, 1, 8, 3}};
        int minSum = obj.minimumPathSum(triangle, 4);
        System.out.println(minSum); // 11

        int[][] triangle2 = {
                {2},
                {3, 4},
                {6, 5, 7},
                {4, 1, 8, 3},
                {1, 2, 3, 4, 5}};
        minSum = obj.minimumPathSum(triangle2, 5);
        System.out.println(minSum); // 13
    }

    public int minimumPathSum(int[][] triangle, int n) {
        for(int i=1; i< n; i++) {
            triangle[i][0] += triangle[i-1][0];
        }

        for(int i=1; i<n; i++) {
            triangle[i][i] += triangle[i-1][i-1];
        }

        for(int i=2; i<n; i++) {
            for(int j=1; j<i; j++) {
                triangle[i][j] += Math.min(triangle[i-1][j], triangle[i-1][j-1]);
            }
        }
        int min = Integer.MAX_VALUE;
        for(int j=0; j<n; j++) {
            min = Math.min(min, triangle[n-1][j]);
        }
        return min;
    }
}
