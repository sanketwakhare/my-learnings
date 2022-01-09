/***
 * Sorted Permutation Rank with Repeats
 * 
 * Problem Description
 * 
 * Given a string A, find the rank of the string amongst its permutations sorted
 * lexicographically. Note that the characters might be repeated. If the
 * characters are repeated, we need to look at the rank in unique permutations.
 * Look at the example for more details.
 * 
 * NOTE:
 * The answer might not fit in an integer, so return your answer % 1000003 where
 * 1000003 is a prime number.
 * String A can consist of both lowercase and uppercase letters. Characters with
 * lesser ascii value are considered smaller i.e. 'a' > 'Z'.
 * 
 * 
 * Problem Constraints
 * 1 <= len(A) <= 1000000
 * 
 * Input Format
 * First argument is a string A.
 * 
 * Output Format
 * Return an integer denoting the rank.
 * 
 * Example Input
 * Input 1:
 * A = "aba"
 * Input 2:
 * A = "bca"
 * 
 * Example Output
 * Output 1:
 * 2
 * Output 2:
 * 4
 * 
 * Example Explanation
 * Explanation 1:
 * The order permutations with letters 'a', 'a', and 'b' :
 * aab
 * aba
 * baa
 * So, the rank is 2.
 * 
 * Explanation 2:
 * The order permutations with letters 'a', 'b', and 'c' :
 * abc
 * acb
 * bac
 * bca
 * cab
 * cba
 * So, the rank is 4.
 */

public class hw_q1_findRankOfStringRepeatedChars {

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

    private static long getProductOfFactOfFrequencies(String A, int m, int i) {
        // repeat this process till last character
        int[] freq = new int[52];
        for (int j = i; j < A.length(); j++) {
            if ((int) A.charAt(j) >= 97) {
                freq[(int) (A.charAt(j) - 65 - 6)]++;
            } else if ((int) A.charAt(j) <= 90) {
                freq[(int) (A.charAt(j) - 65)]++;
            }
        }
        long prod = 1;
        // repeat this process till last character
        for (int j = 0; j < freq.length; j++) {
            if (freq[j] > 0) {
                prod = ((prod % m) * (fact(freq[j], m) % m)) % m;
            }
        }
        return prod % m;
    }

    // power mod function required to calculate the prod inverse using Fermat's
    // theorem
    public static long myPower(long a, long n, long m) {
        if (n == 0) {
            return 1 % m;
        }
        if (n == 1) {
            return a % m;
        }
        long p = myPower(a, n / 2, m);
        long value = ((p % m) * (p % m)) % m;

        if (n % 2 != 0) {
            value = ((value % m) * (a % m)) % m;
        }
        if (value < 0) {
            value = value + m;
        }
        return value % m;
    }

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

            // from current index i including i
            long prod = getProductOfFactOfFrequencies(A, m, i);
            // divide by prod = product of factorial of all frequencies after index i
            temp = ((temp % m) * (myPower(prod, m - 2, m) % m)) % m;
            // update final answer
            rank = ((rank % m) + (temp % m)) % m;

            i++;
        }

        return (int) rank % m;
    }

    public static void main(String[] args) {
        System.out.println(findRank("aba")); // 2
        System.out.println(findRank("bca")); // 4
        System.out.println(findRank("baa")); // 3
        System.out.println(findRank("acb")); // 2
        System.out.println(findRank("xyyx")); // 3
        System.out.println(findRank("abab")); // 2
        System.out.println(findRank("settLe")); // 107
        System.out.println(findRank("sadasdsasassasas")); // 208526
        System.out.println(findRank("bbbbaaaa")); // 70
        System.out.println(findRank("IhSKbdvuqfmGHh")); // 356974
    }

}
