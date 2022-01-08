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
        System.out.println(findRank("string"));
        System.out.println(findRank("acb"));
        System.out.println(findRank("a"));
        System.out.println(findRank("baa"));
    }

}
