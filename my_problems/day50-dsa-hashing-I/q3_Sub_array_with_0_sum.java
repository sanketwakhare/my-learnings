import java.util.HashSet;
import java.util.Set;

/**
 * Sub-array with 0 sum
 * 
 * Problem Description
 * 
 * Given an array of integers A, find and return whether the given array
 * contains a non-empty sub array with a sum equal to 0.
 * 
 * If the given array contains a sub-array with sum zero return 1 else return 0.
 * 
 * Problem Constraints
 * 1 <= |A| <= 100000
 * -10^9 <= A[i] <= 10^9
 * 
 * Input Format
 * The only argument given is the integer array A.
 * 
 * Output Format
 * Return whether the given array contains a sub array with a sum equal to 0.
 * 
 * Example Input
 * Input 1:
 * A = [1, 2, 3, 4, 5]
 * Input 2:
 * A = [-1, 1]
 * 
 * Example Output
 * Output 1:
 * 0
 * Output 2:
 * 1
 * 
 * Example Explanation
 * 
 * Explanation 1:
 * No sub array has sum 0.
 * Explanation 2:
 * The array has sum 0.
 */

/**
 * TC: O(N)
 * SC: O(N)
 */
public class q3_Sub_array_with_0_sum {
    public static int solve(int[] A) {

        // Idea:-> the sum will be 0 when prefix array will have duplicate elements
        // consider edge case where subArray starting with 0 index will have sum 0

        int N = A.length;

        // Generate prefix array, use long since sum can overflow
        long[] prefix = new long[N + 1];
        // add extra 0 to start of the prefix array to handle duplicate element as 0
        prefix[0] = 0;
        for (int i = 0; i < N; i++) {
            prefix[i + 1] = prefix[i] + (long) A[i];
        }

        // Check occurrences using set
        Set<Long> set = new HashSet<Long>();
        for (int i = 0; i < N + 1; i++) {
            if (set.contains(prefix[i])) {
                // there is a subarray with sum 0
                return 1;
            } else {
                // add element to set
                set.add(prefix[i]);
            }
        }

        // return 0 if no subarray with sum 0 is present
        return 0;

    }

    public static void main(String[] args) {
        int[] input1 = { 1, 2, 3, 4, 5 };
        int output1 = solve(input1); // expected output 0
        System.out.println("answer -> " + output1);
        int[] input2 = { -1, 1 };
        int output2 = solve(input2); // expected output 1
        System.out.println("answer -> " + output2);
    }
}
