/* Max Sum of Rectangle No Larger Than K */
// TODO: incomplete
public class MaxSumRectangleNoLargerThanK {

    public static void main(String[] args) {
        MaxSumRectangleNoLargerThanK t1 = new MaxSumRectangleNoLargerThanK();
        {
//            int[][] A = {{1, 0, 1}, {0, -2, 3}};
            int[][] A = {{2, 2, -1}};
            int k = 0;
            int result = t1.maxSumSubmatrix(A, k);
            System.out.println(result);
        }
    }

    public int maxSumSubmatrix(int[][] matrix, int k) {
        int answer = Integer.MIN_VALUE;
        int n = matrix.length;
        int m = matrix[0].length;

        // generate prefix sum column wise
        int[][] pf = new int[n][m];
        for (int col = 0; col < m; col++) {
            pf[0][col] = matrix[0][col];
            if (matrix[0][col] == k) return k;
        }
        for (int row = 1; row < n; row++) {
            for (int col = 0; col < m; col++) {
                pf[row][col] = pf[row - 1][col] + matrix[row][col];
                if (matrix[row][col] == k) return k;
            }
        }
        System.out.println(pf);

        // fix top row
        for (int topRow = 0; topRow < n; topRow++) {
            // for every bottom row
            for (int bottomRow = topRow; bottomRow < n; bottomRow++) {
                for (int startCol = 0; startCol < m; startCol++) {
                    for (int endCol = startCol; endCol < m; endCol++) {
                        int sum = pf[bottomRow][endCol];
                        if (topRow > 0 && startCol > 0)
                            sum -= pf[topRow - 1][startCol - 1];
                        if (startCol > 0)
                            sum -= pf[topRow][startCol - 1];
                        if (topRow > 0)
                            sum -= pf[topRow - 1][startCol];
                        if (sum <= k && sum > answer) {
                            if (sum == k) return k;
                            answer = sum;
                        }
                    }
                }

            }
        }

        return answer;
    }
}
