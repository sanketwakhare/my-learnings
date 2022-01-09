/***
 * Sorted Permutation Rank
 * 
 * Problem Description
 * 
 * Given a string A. Find the rank of the string amongst its permutations sorted
 * lexicographically.
 * Assume that no characters are repeated.
 * 
 * Note: The answer might not fit in an integer, so return your answer % 1000003
 * 
 * Problem Constraints
 * 1 <= |A| <= 1000
 * 
 * Input Format
 * First argument is a string A.
 * 
 * Output Format
 * Return an integer denoting the rank of the given string.
 * 
 * Example Input
 * Input 1:
 * A = "acb"
 * Input 2:
 * A = "a"
 * 
 * Example Output
 * Output 1:
 * 2
 * Output 2:
 * 1
 * 
 * Example Explanation
 * Explanation 1:
 * Given A = "acb".
 * The order permutations with letters 'a', 'c', and 'b' :
 * abc
 * acb
 * bac
 * bca
 * cab
 * cba
 * So, the rank of A is 2.
 * 
 * Explanation 2:
 * Given A = "a".
 * Rank is clearly 1.
 */

public class hw_q1_findRankOfString {

    // find count of characters less than current character to right
    public static int getCount(char curr, int index, String A) {
        int count = 0;
        for (int i = index + 1; i < A.length(); i++) {
            if (A.charAt(i) < curr) {
                count++;
            }
        }
        return count;
    }

    // factorial iterative function
    // TC: O(N)
    public static int fact(int n, int m) {
        long ans = 1;
        for (long i = 1; i <= n; i++) {
            ans = (ans % m * i % m) % m;
        }
        if (ans < 0) {
            ans = ans + m;
        }
        return (int) ans;
    }

    /**
     * TC: O(N)
     * 
     * @param A string
     * @return Number rank
     */
    public static int findRank(String A) {

        long rank = 1;
        int m = 1000003;

        // find how many chars are greater than current char to right side of string
        int i = 0;
        while (i < A.length()) {
            // find count of characters less than current char to right part
            long count = getCount(A.charAt(i), i, A);
            // find factorial value of (N-1-i) places remaining on right of i
            long factVal = fact(A.length() - 1 - i, m);
            // find permutation of chars with count * factValue
            long temp = ((count % m) * (factVal % m)) % m;
            // update final answer
            rank = ((rank % m) + (temp % m)) % m;
            // repeat this process till last character
            i++;
        }
        return (int) rank;
    }

    public static void main(String[] args) {
        System.out.println(findRank("string")); // expected output 598
        System.out.println(findRank("acb")); // expected output 2
        System.out.println(findRank("a")); // expected output 1
        System.out.println(findRank("baa")); // expected output 5
    }
}