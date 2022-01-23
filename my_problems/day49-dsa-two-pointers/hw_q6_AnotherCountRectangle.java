/* Another Count Rectangles */

/***
 * Problem Description
 * 
 * Given a sorted array of distinct integers A and an integer B, find and return
 * how many rectangles with distinct configurations can be created using
 * elements of this array as length and breadth whose area is lesser than B.
 * (Note that a rectangle of 2 x 3 is different from 3 x 2 if we take
 * configuration into view)
 * 
 * Problem Constraints
 * 1 <= |A| <= 100000
 * 1 <= A[i] <= 10^9
 * 1 <= B <= 10^9
 * 
 * Input Format
 * The first argument given is the integer array A.
 * The second argument given is integer B.
 * 
 * Output Format
 * Return the number of rectangles with distinct configurations with area less
 * than B modulo (109 + 7).
 * 
 * Example Input
 * Input 1:
 * A = [1, 2]
 * B = 5
 * Input 2:
 * A = [1, 2]
 * B = 1
 * 
 * Example Output
 * Output 1:
 * 4
 * Output 2:
 * 0
 * 
 * Example Explanation
 * Explanation 1:
 * All 1X1, 2X2, 1X2 and 2X1 have area less than 5.
 * Explanation 2:
 * No Rectangle is valid.
 */

/**
 * TC: O(N)
 * 2 pointers approach
 */
public class hw_q6_AnotherCountRectangle {

    public static int countRectangle(int[] A, int B) {
        long area = 0;
        int m = 1000000007;

        // initialize pointers
        int i = 0;
        int j = A.length - 1;
        long ans = 0;
        while (i <= j) {
            area = (A[i] % m * A[j] % m) % m;

            if (area >= B) {
                j--;
            } else {
                // count the pairs from i to j which are satisfying the condition
                long diff = j - i;
                ans = ans + (diff * 2) + 1;
                i++;
            }
        }

        System.out.println("answer -> " + ans);
        return (int) ans;
    }

    public static void main(String[] args) {

        int[] A1 = { 1, 2, 3, 4, 5 };
        countRectangle(A1, 5);

    }

}
