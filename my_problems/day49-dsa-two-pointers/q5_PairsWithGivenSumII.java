/**
 * Pairs with given sum II
 * 
 * non distinct elements can be present
 * 
 * 
 * Problem Description
 * 
 * Given a sorted array of integers (not necessarily distinct) A and an integer
 * B, find and return how many pair of integers ( A[i], A[j] ) such that i != j
 * have sum equal to B.
 * 
 * Since the number of such pairs can be very large, return number of such pairs
 * modulo (109 + 7).
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
 * Return the number of pairs for which sum is equal to B modulo (10^9+7).
 * 
 * Example Input
 * Input 1:
 * A = [1, 1, 1]
 * B = 2
 * Input 2:
 * A = [1, 1]
 * B = 2
 * 
 * Example Output
 * Output 1:
 * 3
 * Output 2:
 * 1
 * 
 * Example Explanation
 * Explanation 1:
 * Any two pairs sum up to 2.
 * Explanation 2:
 * only pair (1, 2) sums up to 2.
 */

public class q5_PairsWithGivenSumII {
    public static int countPairs(int[] A, int B) {

        int N = A.length;
        long count = 0;
        long m = 1000000007;

        int i = 0;
        int j = N - 1;

        while (i < j) {
            // if we found the pair
            if (A[i] + A[j] == B) {

                if (A[i] == A[j]) {
                    // apply nC2 when A[i] and A[j] are same
                    int cnt = j - i + 1;
                    long tempCnt = ((cnt % m) * ((cnt - 1) % m) / 2) % m;
                    count = ((count % m) + (tempCnt % m)) % m;
                    break;
                } else {
                    // apply cnt1 * cnt2 when A[i] and A[j] are different
                    int cnt1 = 0;
                    int x = A[i];
                    while (i <= j && x == A[i]) {
                        cnt1++;
                        i++;
                    }
                    int cnt2 = 0;
                    x = A[j];
                    while (i <= j && x == A[j]) {
                        cnt2++;
                        j--;
                    }
                    // add to final count
                    long tempCnt = ((cnt1 % m) * (cnt2 % m)) % m;
                    count = ((count % m) + (tempCnt % m)) % m;
                }

            } else if ((A[i] + A[j]) > B) {
                // if sum is > expected sum, move j--;
                j--;
            } else {
                // if sum is < expected sum, move i++;
                i++;
            }
        }
        System.out.println("answer ->" + count);
        return (int) count;
    }

    public static void main(String[] args) {

        int[] A1 = { 1, 1, 1 };
        int B1 = 2;
        countPairs(A1, B1);

        int[] A2 = { 1, 1 };
        int B2 = 2;
        countPairs(A2, B2);

        int[] A3 = { 1, 3, 4, 4, 5, 6, 7, 10 };
        int B3 = 10;
        countPairs(A3, B3);

        int[] A4 = { 1, 3, 4, 4, 5, 5, 5, 5, 6, 6, 6, 7, 10 };
        int B4 = 10;
        countPairs(A4, B4);

        int[] A5 = { 1, 2, 6, 6, 7, 9, 9 };
        int B5 = 13;
        countPairs(A5, B5);

    }
}
