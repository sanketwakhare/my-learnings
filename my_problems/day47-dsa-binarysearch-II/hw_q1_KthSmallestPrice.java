/**
 * KthPrice
 * 
 * Given the price list at which tickets for a flight were purchased, figure out
 * the kth smallest price for the flight. kth smallest price is the minimum
 * possible n such that there are at least k price elements in the price list
 * with value <= n. In other words, if the price list was sorted, then A[k-1] (
 * k is 1 based, while the array is 0 based ).
 * NOTE You are not allowed to modify the price list ( The price list is read
 * only ). Try to do it using constant extra space.
 * 
 * Example:
 * A : [2 1 4 3 2]
 * k : 3
 * Answer : 2
 * 
 * Constraints :
 * 1 <= number of elements in the price list <= 1000000
 * 1 <= k <= number of elements in the price list
 */

/**
 * Use Binary Search on range value
 */
public class hw_q1_KthSmallestPrice {

    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public static int kthsmallest(final int[] A, int K) {

        // find min and max
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < A.length; i++) {
            if (A[i] < min) {
                min = A[i];
            }
            if (A[i] > max) {
                max = A[i];
            }
        }

        // the range of answer is guaranteed to be between min and max
        // apply Binary Search on range min to max
        while (min <= max) {
            int mid = min + (max - min) / 2;
            int count = countLessThanEqualToMid(A, mid);
            if (count < K) {
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }
        return min;

    }

    public static int countLessThanEqualToMid(int[] A, int mid) {
        int count = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] <= mid) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] input1 = { 2, 1, 4, 3, 2 };
        int K = 3;
        int out = kthsmallest(input1, K);
        System.out.println("answer -> " + out); // expected output 2
        int[] input2 = { 4, 3, 6, 9, 2, 7, 8, 3, 2, 3 };
        K = 6;
        int out2 = kthsmallest(input2, K);
        System.out.println("answer -> " + out2); // expected output 2

    }
}
