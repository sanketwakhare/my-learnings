/* Array 3 Pointers */

/***
 * Problem Description
 * 
 * You are given 3 sorted arrays A, B and C.
 * 
 * Find i, j, k such that : max(abs(A[i] - B[j]), abs(B[j] - C[k]), abs(C[k] -
 * A[i])) is minimized.
 * 
 * Return the minimum max(abs(A[i] - B[j]), abs(B[j] - C[k]), abs(C[k] - A[i])).
 * 
 * Problem Constraints
 * 
 * 0 <= len(A), len(B), len(c) <= 10^6
 * 0 <= A[i], B[i], C[i] <= 10^7
 * 
 * Input Format
 * First argument is an integer array A.
 * Second argument is an integer array B.
 * Third argument is an integer array C.
 * 
 * Output Format
 * Return an single integer denoting the minimum max(abs(A[i] - B[j]), abs(B[j]
 * - C[k]), abs(C[k] - A[i])).
 * 
 * Example Input
 * Input 1:
 * A = [1, 4, 10]
 * B = [2, 15, 20]
 * C = [10, 12]
 * Input 2:
 * A = [3, 5, 6]
 * B = [2]
 * C = [3, 4]
 * 
 * Example Output
 * Output 1:
 * 5
 * Output 2:
 * 1
 * 
 * Example Explanation
 * Explanation 1:
 * With 10 from A, 15 from B and 10 from C.
 * Explanation 2:
 * With 3 from A, 2 from B and 3 from C.
 */

/**
 * TC: O(N+M+L)
 * SC: O(1)
 */
public class hw_q1_Array3Pointers {

    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public static int minimize(final int[] A, final int[] B, final int[] C) {

        // maintain 2 pointers and start from end
        int a1 = A.length - 1;
        int b1 = B.length - 1;
        int c1 = C.length - 1;

        // find current max and in out of all 3 array elements and min min abs diff
        int max = Math.max(A[a1], Math.max(B[b1], C[c1]));
        int min = Math.min(A[a1], Math.min(B[b1], C[c1]));
        int minDiff = Math.abs(max - min);

        // iterate until one of the array index goes below index 0
        while (a1 > -1 && b1 > -1 && c1 > -1) {

            // find current min and max
            int currMin = Math.min(A[a1], Math.min(B[b1], C[c1]));
            int currMax = Math.max(A[a1], Math.max(B[b1], C[c1]));
            int currMinDiff = Math.abs(currMax - currMin);

            // update min difference
            if (currMinDiff < minDiff) {
                minDiff = currMinDiff;
            }

            // move/decrement the pointer of the current max element out of 3 arrays
            if (currMax == A[a1]) {
                a1--;
            } else if (currMax == B[b1]) {
                b1--;
            } else {
                c1--;
            }
        }
        // return final answer
        return minDiff;
    }

    public static void main(String[] args) {

        int[] A1 = { 1, 4, 10 };
        int[] B1 = { 2, 15, 20 };
        int[] C1 = { 10, 12 };
        int answer = minimize(A1, B1, C1);
        System.out.println("answer->" + answer); // expected answer 5 [10,15,10]

        int[] A2 = { 3, 5, 6 };
        int[] B2 = { 2 };
        int[] C2 = { 3, 4 };
        answer = minimize(A2, B2, C2);
        System.out.println("answer->" + answer); // expected answer 5 [3,2,3]

    }
}
