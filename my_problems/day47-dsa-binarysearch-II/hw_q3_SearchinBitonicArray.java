/**
 * Search in Bitonic Array!
 */
/*
 * Problem Description
 * Given a bitonic sequence A of N distinct elements, write a program to find a
 * given element B in the bitonic sequence in O(logN) time.
 * 
 * NOTE:
 * A Bitonic Sequence is a sequence of numbers which is first strictly
 * increasing then after a point strictly decreasing.
 * 
 * Problem Constraints
 * 3 <= N <= 10^5
 * 1 <= A[i], B <= 10^8
 * 
 * Given array always contain a bitonic point.
 * Array A always contain distinct elements.
 * 
 * Input Format
 * First argument is an integer array A denoting the bitonic sequence.
 * Second argument is an integer B.
 * 
 * Output Format
 * Return a single integer denoting the position (0 index based) of the element
 * B in the array A if B doesn't exist in A return -1.
 * 
 * Example Input
 * Input 1:
 * A = [3, 9, 10, 20, 17, 5, 1]
 * B = 20
 * Input 2:
 * A = [5, 6, 7, 8, 9, 10, 3, 2, 1]
 * B = 30
 * 
 * Example Output
 * Output 1:
 * 3
 * Output 2:
 * -1
 * 
 * Example Explanation
 * Explanation 1:
 * B = 20 present in A at index 3
 * Explanation 2:
 * B = 30 is not present in A
 */

/**
 * Using Binary search, find element K in Bitonic array
 * TC: O(logN)
 * SC: O(1)
 */
public class hw_q3_SearchinBitonicArray {

    public static int searchInBitonicArray(int[] A, int K) {
        int N = A.length;
        int answer = -1;

        // edge cases
        if (A[0] == K)
            return 0;
        if (A[N - 1] == K)
            return N - 1;

        // initialize search space
        int l = 1;
        int r = N - 2;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (A[mid] == K) {
                // found the answer
                return mid;
            } else if (A[mid] > A[mid - 1]) {
                // we are in left subArray now
                // now check if K lies within A[1] to A[mid-1]
                if (A[1] <= K && K <= A[mid - 1]) {
                    // if K lies within range A[1] to A[mid-1], ignore right part of mid
                    r = mid - 1;
                } else {
                    // ignore left part of mid
                    l = mid + 1;
                }
            } else {
                // we are in right subArray now
                // now check if K lies within A[mid+1] to A[N-2]
                if (A[mid + 1] >= K && K >= A[N - 2]) {
                    // if K lies within range A[mid+1] to A[N-2], ignore left part of mid
                    l = mid + 1;
                } else {
                    // ignore right part of mid
                    r = mid - 1;
                }
            }
        }

        // if K is not found, return -1
        return answer;
    }

    public static void main(String[] args) {
        int[] input1 = { 1, 2, 3, 4, 5, 10, 9, 8, 7, 6 };
        int out1 = searchInBitonicArray(input1, 5);
        System.out.println("answer -> " + out1);
        int[] input2 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 20, 19, 18, 17, 16, 15, 14, 13, 12, 11 };
        int out2 = searchInBitonicArray(input2, 12);
        System.out.println("answer -> " + out2);
    }
}