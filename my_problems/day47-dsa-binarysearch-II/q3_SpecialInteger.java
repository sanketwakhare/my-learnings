/**
 * Special Integer
 * 
Problem Description
Given an array of integers A and an integer B, find and return the maximum value K such that there is no subArray in A of size K with sum of elements greater than B.

Problem Constraints
1 <= |A| <= 100000
1 <= A[i] <= 10^9
1 <= B <= 10^9

Input Format
The first argument given is the integer array A.
The second argument given is integer B.

Output Format
Return the maximum value of K (sub array length).

Example Input
Input 1:
A = [1, 2, 3, 4, 5]
B = 10
Input 2:
A = [5, 17, 100, 11]
B = 130

Example Output
Output 1:
 2
Output 2:
 3

Example Explanation
Explanation 1:
Constraints are satisfied for maximal value of 2.
Explanation 2:
Constraints are satisfied for maximal value of 3.
 */

/**
 * TC: O(N*logN) => N for sliding window sum and logN for Binary Search
 * SC: O(1)
 */
public class q3_SpecialInteger {

    // check if there exist a subArray of length K with sum > B
    public static boolean check(int[] A, int K, int B) {
        // use sliding window approach

        // find sum of first window
        int sum = 0;
        for (int i = 0; i < K; i++) {
            sum = sum + A[i];
        }
        if (sum > B) {
            return true;
        }
        for (int i = 1; i <= A.length - K; i++) {
            sum = sum - A[i - 1] + A[i - 1 + K];
            if (sum > B) {
                return true;
            }
        }
        // if no subArray of length K with sum > B present, return false
        return false;
    }

    /* Apply Binary search on range [1 to N] */
    public static final int specialInteger(int[] A, int B) {

        // initialize search space
        int l = 1;
        int r = A.length;
        // initialize answer
        int maxLength = 0;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (!check(A, mid, B)) {
                // update possible answer
                maxLength = mid;
                // ignore left part as maxLength can not lie to left
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        int[] input1 = { 1, 2, 3, 4, 5 };
        int out = specialInteger(input1, 10);
        System.out.println("answer -> " + out);
        int[] input2 = { 5, 17, 100, 11 };
        int out2 = specialInteger(input2, 130);
        System.out.println("answer -> " + out2);
    }
}
