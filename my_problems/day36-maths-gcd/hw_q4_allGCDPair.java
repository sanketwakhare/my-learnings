/**
ALL GCD PAIR

Problem Description

Given an array of integers A of size N containing GCD of every possible pair of elements of another array.

Find and return the original numbers which are used to calculate the GCD array in any order. For example, if original numbers are {2, 8, 10} then the given array will be {2, 2, 2, 2, 8, 2, 2, 2, 10}.

Problem Constraints
1 <= N <= 10000
1 <= A[i] <= 10^9

Input Format
The first and only argument given is the integer array A.

Output Format
Find and return the original numbers which are used to calculate the GCD array in any order.

Example Input
Input 1:
 A = [2, 2, 2, 2, 8, 2, 2, 2, 10]
Input 2:
 A = [5, 5, 5, 15]

Example Output
Output 1:
 [2, 8, 10]
Output 2:
 [5, 15]

Example Explanation
Explanation 1:
 Initially, array A = [2, 2, 2, 2, 8, 2, 2, 2, 10].
 2 is the gcd between 2 and 8, 2 and 10.
 8 and 10 are the gcds pair with itself.
 Therefore, [2, 8, 10] is the original array.
Explanation 2:
 Initially, array A = [5, 5, 5, 15].
 5 is the gcd between 5 and 15.
 15 is the gcds pair with itself.
 Therefore, [5, 15] is the original array.
 */

import java.lang.*;
public class Solution {
    public int[] solve(int[] A) {

        // Observation: for n elements there are n*n pairs
        int N = A.length;
        // take sqrt to find the length of output array
        int M = (int)Math.sqrt(N);
        int[] output = new int[M];
        // System.out.println(M);

        // find the maximum in every M range e.g. 0 to M-1, M to 2M-1, 2M to 3M-1 etc...
        // max elements would be original element in array
        for( int i=0; i<M ; i++ ) {
            int max = Integer.MIN_VALUE;
            // find max element in range
            for( int j=(i * M); j < (i * M) + M; j++) {
                if(A[j] > max) {
                    max = A[j];
                }
            }
            output[i] = max;
        }

        return output;
    }
}
