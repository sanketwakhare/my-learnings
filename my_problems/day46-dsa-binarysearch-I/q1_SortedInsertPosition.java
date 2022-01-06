/**
 * Sorted Insert Position
 * 
 * Problem Description
 * 
 * Given a sorted array A of size N and a target value B, return the index
 * (0-based indexing) if the target is found.
 * If not, return the index where it would be if it were inserted in order.
 * 
 * NOTE: You may assume no duplicates in the array. Users are expected to solve
 * this in O(log(N)) time.
 * 
 * Problem Constraints
 * 1 <= N <= 10^6
 * 
 * Input Format
 * First argument is an integer array A of size N.
 * Second argument is an integer B.
 * 
 * Output Format
 * Return an integer denoting the index of target value.
 * 
 * Example Input
 * Input 1:
 * A = [1, 3, 5, 6]
 * B = 5
 * Input 2:
 * A = [1]
 * B = 1
 * 
 * Example Output
 * Output 1:
 * 2
 * Output 2:
 * 0
 * 
 * Example Explanation
 * Explanation 1:
 * The target value is present at index 2.
 * Explanation 2:
 * The target value is present at index 0.
 */

public class q1_SortedInsertPosition {
    public static int searchInsert(int[] A, int K) {

        // initialize l and r index values
        int l = 0;
        int r = A.length - 1;

        // iterate while there is search space available
        while (l <= r) {
            // find mid index
            int mid = l + (r - l) / 2;
            if (A[mid] == K) {
                // return if element K is found
                return mid;
            } else if (A[mid] > K) {
                // search in left part
                r = mid - 1;
            } else {
                // search in right part
                l = mid + 1;
            }
        }
        // if element is not found, return index l where the element would be present if
        // inserted
        return l;
    }

    public static void main(String[] args) {
        int[] input1 = { 1, 3, 5, 6 };
        int out = searchInsert(input1, 5);
        System.out.println(out);
        int[] input2 = { 1 };
        out = searchInsert(input2, 5);
        System.out.println(out);
        int[] input3 = { 10, 15, 17, 24, 25, 34, 45, 46 };
        out = searchInsert(input3, 45);
        System.out.println(out);
    }
}
