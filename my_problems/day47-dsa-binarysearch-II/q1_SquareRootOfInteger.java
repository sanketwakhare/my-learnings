/**
 * Square Root of Integer
 * 
 * Problem Description
 * Given an integer A.
 * Compute and return the square root of A.
 * If A is not a perfect square, return floor(sqrt(A)).
 * DO NOT USE SQRT FUNCTION FROM STANDARD LIBRARY.
 * NOTE: Do not use sort function from standard library. Users are expected to
 * solve this in O(log(A)) time.
 * 
 * Problem Constraints
 * 0 <= A <= 10^10
 * 
 * Input Format
 * The first and only argument given is the integer A.
 * 
 * Output Format
 * Return floor(sqrt(A))
 * 
 * Example Input
 * Input 1:
 * 11
 * Input 2:
 * 9
 * 
 * Example Output
 * Output 1:
 * 3
 * Output 2:
 * 3
 * 
 * Example Explanation
 * Explanation:
 * When A = 11 , square root of A = 3.316. It is not a perfect square so we
 * return the floor which is 3.
 * When A = 9 which is a perfect square of 3, so we return 3.
 */

/**
 * TC: O(logN) - apply Binary search on range [1 to N]
 * SC: O(1)
 */
public class q1_SquareRootOfInteger {

    // Apply Binary Search on range/answer value
    public static int findSqrt(int N) {
        // search space
        long l = 1;
        long r = N;
        long ans = 0;

        while (l <= r) {
            long mid = l + (r - l) / 2;

            if (mid * mid == N) {
                // found the answer
                return (int) mid;
            } else if (mid * mid > N) {
                // search in left part
                r = mid - 1;
            } else {
                // update the possible answer
                ans = mid;
                // search in right part
                l = mid + 1;
            }
        }
        return (int) ans;
    }

    public static void main(String[] args) {
        int ans = findSqrt(11);
        System.out.println("srqt(" + 11 + ") -> " + ans);
        ans = findSqrt(9);
        System.out.println("srqt(" + 9 + ") -> " + ans);
        ans = findSqrt(0);
        System.out.println("srqt(" + 0 + ") -> " + ans);
        ans = findSqrt(1);
        System.out.println("srqt(" + 1 + ") -> " + ans);
        ans = findSqrt(100);
        System.out.println("srqt(" + 100 + ") -> " + ans);
        ans = findSqrt(55);
        System.out.println("srqt(" + 55 + ") -> " + ans);
        ans = findSqrt(1000);
        System.out.println("srqt(" + 1000 + ") -> " + ans);
        ans = findSqrt(143);
        System.out.println("srqt(" + 143 + ") -> " + ans);
    }
}