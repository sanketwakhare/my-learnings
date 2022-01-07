/***
 * Matrix Median
 * Problem Description
 * 
 * Given a matrix of integers A of size N x M in which each row is sorted.
 * Find and return the overall median of the matrix A.
 * NOTE: No extra memory is allowed.
 * NOTE: Rows are numbered from top to bottom and columns are numbered from left
 * to right.
 * 
 * Problem Constraints
 * 1 <= N, M <= 10^5
 * 1 <= N*M <= 10^6
 * 1 <= A[i] <= 10^9
 * N*M is odd
 * 
 * Input Format
 * The first and only argument given is the integer matrix A.
 * 
 * Output Format
 * Return the overall median of the matrix A.
 * 
 * Example Input
 * Input 1:
 * A = [ [1, 3, 5],
 * [2, 6, 9],
 * [3, 6, 9] ]
 * Input 2:
 * A = [ [5, 17, 100] ]
 * 
 * Example Output
 * Output 1:
 * 5
 * Output 2:
 * 17
 * 
 * Example Explanation
 * Explanation 1:
 * A = [1, 2, 3, 3, 5, 6, 6, 9, 9]
 * Median is 5. So, we return 5.
 * Explanation 2:
 * Median is 17.
 */

public class hw_q2_MatrixMedian {

    /**
     * Apply Binary Search on values by comparing count of elements<=mid and
     * expectedCount
     */
    public static int binarySearch(int[][] A, int l, int r, int expectedCount) {

        while (l <= r) {
            int mid = l + (r - l) / 2;
            int count = getCountLessThanOrEqualToK(A, mid);
            if (count < expectedCount) {
                // if count is less than expected count, ignore left part
                l = mid + 1;
            } else {
                // ignore right part
                r = mid - 1;
            }
        }
        // value l will be expected answer
        return l;
    }

    /**
     * Find min and min within 2d array
     * 
     * @param A array of integers
     * @return array of min and max
     */
    public static int[] findMinAndMax(int[][] A) {
        int N = A.length;
        int M = A[0].length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 1; j++) {
                if (A[i][j] <= min) {
                    min = A[i][j];
                }
                if (A[i][M - 1] >= max) {
                    max = A[i][M - 1];
                }
            }
        }
        int[] output = { min, max };
        return output;
    }

    /**
     * Get count of elements <= K in entire 2d matrix
     * 
     * @param A array of integers
     * @param K integer mid
     * @return int count
     */
    public static int getCountLessThanOrEqualToK(int[][] A, int K) {
        int count = 0;
        int N = A.length;
        int M = A[0].length;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (A[i][j] <= K) {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * Find median
     * 
     * @param A array of integers
     * @return median element
     */
    public static int findMedian(int[][] A) {
        int[] minMax = findMinAndMax(A);
        int min = minMax[0];
        int max = minMax[1];

        // apply binary search on each row until we find the median
        // observation is there are (1+(N*M))/2 elements less than mid for median
        int N = A.length;
        int M = A[0].length;
        int expectedCount = (1 + (N * M)) / 2;

        // apply binary search on value based on condition which will count of mid <=
        // expectedCount
        int median = binarySearch(A, min, max, expectedCount);
        return median;
    }

    public static void main(String[] args) {
        int[][] input1 = { { 1, 3, 5 },
                { 2, 6, 90 },
                { 3, 6, 9 } };
        int out = findMedian(input1);
        System.out.println("answer -> " + out); // expected output 5
        int[][] input2 = { { 5, 17, 100 } };
        int out2 = findMedian(input2);
        System.out.println("answer -> " + out2); // expected output 5
        int[][] input3 = { { 1, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3 } };
        int out3 = findMedian(input3);
        System.out.println("answer -> " + out3); // expected output 2
    }
}
