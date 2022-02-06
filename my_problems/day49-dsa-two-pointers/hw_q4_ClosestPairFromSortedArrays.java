/* Closest pair from sorted arrays */

/***
 * Problem Description
 * 
 * Given two sorted arrays of distinct integers, A and B, and an integer C, find
 * and return the pair whose sum is closest to C and the pair has one element
 * from each array.
 * More formally, find A[i] and B[j] such that abs((A[i] + B[j]) - C) has
 * minimum value.
 * 
 * If there are multiple solutions find the one with minimum i and even if there
 * are multiple values of j for the same i then return the one with minimum j.
 * Return an array with two elements {A[i], B[j]}.
 * 
 * Problem Constraints
 * 1 <= length of both the arrays <= 100000
 * 1 <= A[i], B[i] <= 10^9
 * 1 <= C <= 10^9
 * 
 * Input Format
 * The first argument given is the integer array A.
 * The second argument given is the integer array B.
 * The third argument given is integer C.
 * 
 * Output Format
 * Return an array of size 2 denoting the pair which has sum closest to C.
 * 
 * Example Input
 * Input 1:
 * A = [1, 2, 3, 4, 5]
 * B = [2, 4, 6, 8]
 * C = 9
 * Input 2:
 * A = [5, 10, 20]
 * B = [1, 2, 30]
 * C = 13
 * 
 * Example Output
 * Output 1:
 * [1, 8]
 * Output 2:
 * [10, 2]
 * 
 * Example Explanation
 * Explanation 1:
 * There are three pairs: (1, 8), (3, 6), (5, 4), that gives the minimum value.
 * Since we have to return the value with minimum i and then with minimum j. We
 * will return [1, 8].
 * Explanation 2:
 * [10, 2] is the only pair such abs(10+2-13) is minimum.
 */

/**
 * Two pointer approach
 * TC: O(N)
 * SC: O(1)
 */
public class hw_q4_ClosestPairFromSortedArrays {

    public static int[] solve(int[] A, int[] B, int C) {

        // initialize min and output array
        int min = Integer.MAX_VALUE;
        int output[] = new int[2];

        int i = 0;
        int j = B.length - 1;

        while (i < A.length && j >= 0) {

            int currentValue = Math.abs(A[i] + B[j] - C);
            if (currentValue < min) {
                // update min and answer
                min = currentValue;
                output[0] = A[i];
                output[1] = B[j];
            }

            // this condition to handle when sum is = and to find min j for same i
            if (currentValue <= min && output[0] == A[i]) {
                min = currentValue;
                output[0] = A[i];
                output[1] = B[j];
            }

            if (A[i] + B[j] >= C) {
                // move j when sum is >= target
                j--;
            } else if (A[i] + B[j] < C) {
                // move i when sum < target
                i++;
            }

        }
        System.out.println("answer -> " + output[0] + ", " + output[1]);
        return output;
    }

    public static void main(String[] args) {

        // test case 1
        int[] A1 = { 1, 2, 3, 4, 5 };
        int[] B1 = { 2, 4, 6, 8 };
        int C1 = 9;
        solve(A1, B1, C1); // expected answer [1, 8]

        // test case 2
        int[] A2 = { 5, 10, 20 };
        int[] B2 = { 1, 2, 30 };
        int C2 = 13;
        solve(A2, B2, C2); // expected answer [10, 2]

        // test case 3
        int[] A3 = { 1 };
        int[] B3 = { 2, 4 };
        int C3 = 4;
        solve(A3, B3, C3); // expected answer [1, 2]

    }

}
