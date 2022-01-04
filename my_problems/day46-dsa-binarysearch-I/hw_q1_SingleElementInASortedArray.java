/**
 * Single Element in a Sorted Array
 * 
 * 
 * Problem Description
 * Given a sorted array of integers A where every element appears twice except
 * for one element which appears once, find and return this single element that
 * appears only once.
 * NOTE: Users are expected to solve this in O(log(N)) time.
 * 
 * Problem Constraints
 * 1 <= |A| <= 100000
 * 1 <= A[i] <= 10^9
 * 
 * Input Format
 * The only argument given is the integer array A.
 * 
 * Output Format
 * Return the single element that appears only once.
 * 
 * Example Input
 * Input 1:
 * A = [1, 1, 7]
 * Input 2:
 * A = [2, 3, 3]
 * 
 * Example Output
 * Output 1:
 * 7
 * Output 2:
 * 2
 * 
 * Example Explanation
 * Explanation 1:
 * 7 appears once
 * Explanation 2:
 * 2 appears once
 */
public class hw_q1_SingleElementInASortedArray {
    public static int singleElement(int[] A) {
        int ans = -1;

        // initialize search space
        int l = 0;
        int r = A.length - 1;

        // edge cases
        if (A[l] != A[l + 1]) {
            // first element is unique element
            return A[0];
        }
        if (A[r] != A[r - 1]) {
            // last element is unique element
            return A[r];
        }

        // if no edge cases, ignore first and last pair of same elements to avoid array
        // index out of bounds exception
        l = l + 2;
        r = r - 2;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (A[mid] != A[mid - 1] && A[mid] != A[mid + 1]) {
                // found the unique element
                return A[mid];
            }
            if (A[mid] == A[mid - 1]) {
                // if mid is at odd index, make it even
                mid = mid - 1;
            }
            if (mid % 2 == 0) {
                // unique element is present on right side
                l = mid + 2;
            } else {
                // unique element is present on left side
                r = mid - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] input1 = { 1, 1, 7 };
        int out = singleElement(input1);
        System.out.println(out);
        int[] input2 = { 2, 3, 3 };
        out = singleElement(input2);
        System.out.println(out);
        int[] input3 = { 1, 1, 3, 3, 4, 4, 6, 6, 8, 8, 9, 10, 10 };
        out = singleElement(input3);
        System.out.println(out);
    }

}