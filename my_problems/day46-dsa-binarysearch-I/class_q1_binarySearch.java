/**
 * Given a sorted array , find index of K, if K does not exist return -1
 * 
 * Divide and conquer
 * TC: O(logN)
 */

public class class_q1_binarySearch {
    public static int binarySearch(int[] A, int K) {

        // initialize l and r index values
        int l = 0;
        int r = A.length - 1;

        // iterate while there is search space available
        while (l <= r) {
            // find mid index
            int mid = l + (r - l) / 2;
            if (A[mid] == K) {
                // return mid if element K is found
                return mid;
            } else if (A[mid] > K) {
                // search in left part
                r = mid - 1;
            } else {
                // search in right part
                l = mid + 1;
            }
        }
        // if element K is not found, return -1
        return -1;
    }

    public static void main(String[] args) {
        int[] input1 = { 3, 6, 9, 12, 14, 19, 20, 23, 25, 27 };
        int out = binarySearch(input1, 12);
        System.out.println(out);
        int[] input2 = { 1 };
        out = binarySearch(input2, 5);
        System.out.println(out);
        int[] input3 = { 10, 15, 17, 24, 25, 34, 45, 46 };
        out = binarySearch(input3, 34);
        System.out.println(out);
    }
}
