/* Pairs with Given Difference */

/**
 * Problem Description

Given an one-dimensional integer array A of size N and an integer B.

Count all distinct pairs with difference equal to B.

Here a pair is defined as an integer pair (x, y), where x and y are both numbers in the array and their absolute difference is B.

Problem Constraints
1 <= N <= 10^4
0 <= A[i], B <= 10^5

Input Format
First argument is an one-dimensional integer array A of size N.
Second argument is an integer B.

Output Format
Return an integer denoting the count of all distinct pairs with difference equal to B.

Example Input
Input 1:
 A = [1, 5, 3, 4, 2]
 B = 3
Input 2:
 A = [8, 12, 16, 4, 0, 20]
 B = 4
Input 3:
 A = [1, 1, 1, 2, 2]
 B = 0

Example Output
Output 1:
 2
Output 2:
 5
Output 3:
 2

Example Explanation
Explanation 1:
 There are 2 unique pairs with difference 3, the pairs are {1, 4} and {5, 2} 
Explanation 2:
 There are 5 unique pairs with difference 4, the pairs are {0, 4}, {4, 8}, {8, 12}, {12, 16} and {16, 20} 
Explanation 3:
 There are 2 unique pairs with difference 0, the pairs are {1, 1} and {2, 2}.
 */

import java.util.Arrays;

/**
 * Iterations: N logN + N
 * TC: O(N logN) -> as sorting is involved
 * SC: O(1)
 */
public class q2_PairsWithGivenDifference {

    public static int countPairs(int[] A, int B) {

        int N = A.length;
        int count = 0;

        // sort the input array
        Arrays.sort(A);

        // initialize pointers
        int i = 0;
        int j = 1;

        // iterate while we reach till end of array
        while (i < N - 1 && j < N) {
            if ((A[j] - A[i]) == B) {

                // if we find the pair with difference B, increase count by 1 as we have to find
                // the unique pairs only
                int x = A[j];
                int y = A[i];
                count += 1;
                // check if there are any other pairs with same A[i] and A[j] and ignore them
                i++;
                j++;
                while (j < N && A[j] == x) {
                    j++;
                }
                while (i < N - 1 && A[i] == y) {
                    i++;
                }
            } else if ((A[j] - A[i]) > B) {
                // if current difference is > than B, increase i pointer so that difference will
                // be lesser for next comparison
                i++;
                if (i == j) {
                    j++;
                }
            } else {
                // if current difference is < B, increase j pointer so that difference will be
                // greater for next comparison
                j++;
            }
        }

        System.out.println("answer ->" + count);
        return count;

    }

    public static void main(String[] args) {

        int[] A1 = { 1, 5, 3, 4, 2 };
        int B1 = 3;
        countPairs(A1, B1); // expected count 2

        int[] A2 = { 8, 12, 16, 4, 0, 20 };
        int B2 = 4;
        countPairs(A2, B2); // expected count 5

        int[] A3 = { 1, 1, 1, 2, 2 };
        int B3 = 0;
        countPairs(A3, B3); // expected count 2

        int[] A4 = { 8, 5, 1, 10, 5, 9, 9, 3, 5, 6, 6, 2, 8, 2, 2, 6, 3, 8, 7, 2, 5, 3, 4, 3, 3, 2, 7, 9, 6, 8, 7, 2, 9,
                10, 3, 8, 10, 6, 5, 4, 2, 3 };
        int B4 = 3;
        countPairs(A4, B4); // expected count 7

    }

}
