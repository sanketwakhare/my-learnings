/**
 * Find a peak element

Problem Description
Given an array of integers A, find and return the peak element in it. An array element is peak if it is NOT smaller than its neighbors.
For corner elements, we need to consider only one neighbor. We ensure that answer will be unique.
NOTE: Users are expected to solve this in O(log(N)) time.


Problem Constraints
1 <= |A| <= 100000
1 <= A[i] <= 10^9

Input Format
The only argument given is the integer array A.

Output Format
Return the peak element.

Example Input
Input 1:
A = [1, 2, 3, 4, 5]
Input 2:
A = [5, 17, 100, 11]

Example Output
Output 1:
 5
Output 2:
 100

Example Explanation
Explanation 1:
 5 is the peak.
Explanation 2:
 100 is the peak.
 */

/**
 * Problem is same as local maxima/maximum
 * TC: O(logN)
 * SC: O(1)
 */
public class q3_FindAPeakElement {
    public static int localMaxima(int[] A) {

        // initialize search space - start and end indexes
        int l = 0;
        int r = A.length - 1;

        // edge cases
        if (r == 0) {
            // if only single element is present in array
            return A[r];
        }
        if (A[l] > A[l + 1]) {
            // if first element is larger than second element
            return A[l];
        }
        if (A[r] > A[r - 1]) {
            // if last element is larger than second last element
            return A[r];
        }

        // binary search
        while (l <= r) {
            // find mid
            int mid = l + (r - l) / 2;

            if (A[mid] > A[mid - 1] && A[mid] > A[mid + 1]) {
                // A[mid] is one of the maxima
                return A[mid];
            } else if (A[mid + 1] > A[mid]) {
                // go to right side, as there would be at least one maxima on right
                l = mid + 1;
            } else {
                // go to left side as there is at least one maxima on left
                r = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] input1 = { 1, 2, 3, 4, 5 };
        int out = localMaxima(input1);
        System.out.println(out);
        int[] input2 = { 5, 17, 100, 11 };
        out = localMaxima(input2);
        System.out.println(out);
        int[] input3 = { 2, 8, 3, 76, 4, 10, 5 };
        out = localMaxima(input3);
        System.out.println(out);

    }
}