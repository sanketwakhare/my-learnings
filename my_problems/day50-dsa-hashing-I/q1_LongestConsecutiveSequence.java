import java.util.HashSet;
import java.util.Set;

/**
 * Longest Consecutive Sequence
 * 
 * Problem Description
 * 
 * Given an unsorted integer array A of size N.
 * Find the length of the longest set of consecutive elements from the array A.
 * 
 * Problem Constraints
 * 1 <= N <= 10^6
 * -10^6 <= A[i] <= 10^6
 * 
 * Input Format
 * First argument is an integer array A of size N.
 * 
 * Output Format
 * Return an integer denoting the length of the longest set of consecutive
 * elements from the array A.
 * 
 * Example Input
 * Input 1:
 * A = [100, 4, 200, 1, 3, 2]
 * Input 2:
 * A = [2, 1]
 * 
 * Example Output
 * Output 1:
 * 4
 * Output 2:
 * 2
 * 
 * Example Explanation
 * Explanation 1:
 * The set of consecutive elements will be [1, 2, 3, 4].
 * Explanation 2:
 * The set of consecutive elements will be [1, 2].
 */

public class q1_LongestConsecutiveSequence {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public static int longestConsecutive(final int[] A) {

        // Idea:-> to ignore the elements which can not be the start of the
        // chain/consecutive sequence.

        // Generate set of each element in array
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < A.length; i++) {
            set.add(A[i]);
        }

        int answer = 1;
        // check if previous element is present or not, it present the current element
        // can not be the start of the chain
        for (int i = 0; i < A.length; i++) {
            if (!set.contains(A[i] - 1)) {
                // A[i] can be start of the chain
                // initialize chain length as 1 for chain starting from A[i]
                int chainLength = 1;
                // initialize first chian element as A[i]
                int currentEle = A[i];
                // iterate till consecutive elements are present and increase chainLength and
                // currentEle
                while (set.contains(currentEle + 1)) {
                    currentEle++;
                    chainLength++;
                }
                // update the max possible chainLength
                answer = Math.max(answer, chainLength);
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] input1 = { 100, 4, 200, 1, 3, 2 };
        int output1 = longestConsecutive(input1); // expected output 4
        System.out.println("answer -> " + output1);
        int[] input2 = { 2, 1 };
        int output2 = longestConsecutive(input2); // expected output 2
        System.out.println("answer -> " + output2);
        int[] input3 = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
        int output3 = longestConsecutive(input3); // expected output 10
        System.out.println("answer -> " + output3);
    }

}
