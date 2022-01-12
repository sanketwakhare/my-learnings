import java.util.HashMap;
import java.util.Map;

/**
 * Largest Continuous Sequence Zero Sum
 * 
 * Problem Description
 * 
Given an array A of N integers.
Find the largest continuous sequence in a array which sums to zero.

Problem Constraints
1 <= N <= 10^6
-10^7 <= A[i] <= 10^7

Input Format
Single argument which is an integer array A.

Output Format
Return an array denoting the longest continuous sequence with total sum of zero.

NOTE : If there are multiple correct answers, return the sequence which occurs first in the array.

Example Input
A = [1,2,-2,4,-4]
Example Output
[2,-2,4,-4]

Example Explanation
[2,-2,4,-4] is the longest sequence with total sum of zero.
 */

/**
 * TC: O(N)
 * SC: O(N)
 */
public class q4_LargestContinuousSequenceZeroSum {
    public static int[] largestSubarrayWithSUmZero(int[] A) {

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

        int maxLength = 0;
        int startIndex = 0;
        // Check occurrences and store the first occurrence inside HashMap
        Map<Long, Integer> map = new HashMap<Long, Integer>();
        for (int i = 0; i < N + 1; i++) {
            if (map.containsKey(prefix[i])) {
                // there is a subarray with sum 0
                // perform calculations of max length
                int currLength = i - map.get(prefix[i]);
                if (currLength > maxLength) {
                    // update max length and start index of output array
                    maxLength = currLength;
                    startIndex = map.get(prefix[i]);
                }
            } else {
                // add element to map
                map.put(prefix[i], i);
            }
        }

        int[] output = new int[maxLength];
        int ind = 0;
        for (int i = startIndex; i < maxLength + startIndex; i++) {
            output[ind++] = A[i];
            System.out.println(A[i]);
        }

        System.out.println(output);
        return output;

    }

    public static void main(String[] args) {
        int[] input1 = { 1, 2, -2, 4, -4 };
        int[] output1 = largestSubarrayWithSUmZero(input1); // expected output [2,-2,4,-4]
        System.out.println("answer -> " + output1);
        int[] input2 = { -1, 1 };
        int[] output2 = largestSubarrayWithSUmZero(input2); // expected output [-1,1]
        System.out.println("answer -> " + output2);
    }
}
