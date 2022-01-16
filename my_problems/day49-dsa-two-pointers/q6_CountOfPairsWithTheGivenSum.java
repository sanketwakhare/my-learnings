/* Count of pairs with the given sum */

/* 
Given a sorted array of distinct integers A and an integer B, find and return how many pair of integers ( A[i], A[j] ) such that i != j have sum equal to B.

Input Format
The first argument given is the integer array A.
The second argument given is integer B.

Output Format
Return the number of pairs for which sum is equal to B.

Constraints
1 <= length of the array <= 100000
1 <= A[i] <= 10^9 
1 <= B <= 10^9

For Example
Input 1:
    A = [1, 2, 3, 4, 5]
    B = 5
Output 1:
    2

Input 2:
    A = [5, 10, 20, 100, 105]
    B = 110
Output 2:
    2
 */

/**
 * TC: O(N): Two pointers approach
 */
public class q6_CountOfPairsWithTheGivenSum {

    public static int countPairs(int[] A, int B) {
        // p1 from start
        // p2 from end
        // if A[p1] == A[p2] increase the count and p1++ and p2--

        int N = A.length;
        int count = 0;

        int i = 0;
        int j = N - 1;

        while (i < j) {
            if (A[i] + A[j] == B) {
                // if we found the pair, increase the count and move i++ and j--
                count++;
                i++;
                j--;
            } else if ((A[i] + A[j]) > B) {
                // if sum is > expected sum, move j--;
                j--;
            } else {
                // if sum is < expected sum, move i++;
                i++;
            }
        }
        System.out.println("answer ->" + count);
        return count;
    }

    public static void main(String[] args) {

        int[] A1 = { 1, 2, 3, 4, 5 };
        int B1 = 5;
        countPairs(A1, B1);

        int[] A2 = { 5, 10, 20, 100, 105 };
        int B2 = 110;
        countPairs(A2, B2);

        int[] A3 = { -3, 0, 1, 3, 6, 8, 11, 14, 18, 25 };
        int B3 = 17;
        countPairs(A3, B3);

        int[] A4 = { -3, 0, 1, 3, 6, 8, 11, 14, 18, 25 };
        int B4 = 11;
        countPairs(A4, B4);

    }
}
