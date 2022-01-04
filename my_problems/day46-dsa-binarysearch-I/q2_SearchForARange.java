/**
 * Search for a Range
 * 
 * Problem Description
 * Given a sorted array of integers A(0 based index) of size N, find the
 * starting and ending position of a given integer B in array A.
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * Return an array of size 2, such that first element = starting position of B
 * in A and second element = ending position of B in A, if B is not found in A
 * return [-1, -1].
 * 
 * Problem Constraints
 * 1 <= N <= 10^6
 * 1 <= A[i], B <= 10^9
 * 
 * Input Format
 * The first argument given is the integer array A.
 * The second argument given is the integer B.
 * 
 * Output Format
 * Return an array of size 2, such that first element = starting position of B
 * in A and second element = ending position of B in A, if B is not found in A
 * return [-1, -1].
 * 
 * Example Input
 * Input 1:
 * A = [5, 7, 7, 8, 8, 10]
 * B = 8
 * Input 2:
 * A = [5, 17, 100, 111]
 * B = 3
 * 
 * Example Output
 * Output 1:
 * [3, 4]
 * Output 2:
 * [-1, -1]
 * 
 * Example Explanation
 * Explanation 1:
 * First occurrence of 8 in A is at index 3
 * Second occurrence of 8 in A is at index 4
 * ans = [3, 4]
 * Explanation 2:
 * There is no occurrence of 3 in the array.
 */

/**
 * TC: O(logN) using Binary Search
 */
public class q2_SearchForARange {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public static int[] searchRange(final int[] A, int K) {

        int[] output = new int[2];

        // initialize start and end index - search space
        int l = 0;
        int r = A.length - 1;

        /* find first occurrence of K */
        int firstOccIndex = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (A[mid] == K) {
                // update answer and search on left for first occurrence if available
                firstOccIndex = mid;
                r = mid - 1;
            } else if (A[mid] < K) {
                // search on right side as all the elements to left will be smaller than K
                l = mid + 1;
            } else {
                // search on left side as all the elements to right will be larger than K
                r = mid - 1;
            }
        }
        output[0] = firstOccIndex;

        /* find last occurrence index of K */
        // re initialize start and end index - search space
        l = 0;
        r = A.length - 1;
        int lastOccIndex = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (A[mid] == K) {
                lastOccIndex = mid;
                l = mid + 1;
            } else if (A[mid] < K) {
                // search on right side
                l = mid + 1;
            } else {
                // search on left side
                r = mid - 1;
            }
        }
        output[1] = lastOccIndex;

        return output;
    }

    public static void main(String[] args) {
        int[] input1 = { 5, 7, 7, 8, 8, 10 };
        int[] out = searchRange(input1, 8);
        System.out.println(out[0] + " " + out[1]);
        int[] input2 = { 5, 17, 100, 111 };
        out = searchRange(input2, 3);
        System.out.println(out[0] + " " + out[1]);
        int[] input3 = { 10, 15, 15, 15, 15, 17, 24, 24, 25, 25, 25, 25, 34, 34, 45, 45 };
        out = searchRange(input3, 25);
        System.out.println(out[0] + " " + out[1]);
        out = searchRange(input3, 17);
        System.out.println(out[0] + " " + out[1]);
    }
}
