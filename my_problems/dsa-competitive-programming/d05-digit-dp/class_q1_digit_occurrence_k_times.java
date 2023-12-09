import java.util.Arrays;

/*
    How many numbers in range [a, b], inclusive of a and b, are there where the digit d occurs exactly k times
 */
public class class_q1_digit_occurrence_k_times {
    public static void main(String[] args) {
        class_q1_digit_occurrence_k_times t = new class_q1_digit_occurrence_k_times();
        {
            int a = 7;
            int b = 58;
            int d = 7;
            int k = 1;
            System.out.println(t.solve(a, b, d, k)); // 6
        }
        {
            int a = 11;
            int b = 99999;
            int d = 8;
            int k = 2;
            System.out.println(t.solve(a, b, d, k)); // 7290
        }
    }

    // TC: O( k. log(N) )
    int solve(int a, int b, int d, int k) {
        int answer;
        int[][][] dp;

        int[] numB = intToDigitArray(b);
        // count will always be <= k, so keep dp state countOfd size as k + 1
        dp = new int[numB.length][2][k + 1];
        initDPArray(dp, -1);
        int f1 = f(0, 0, 0, numB, d, k, dp);

        int[] numA = intToDigitArray(a - 1);
        dp = new int[numA.length][2][k + 1];
        initDPArray(dp, -1);
        int f2 = f(0, 0, 0, numA, d, k, dp);

        answer = f1 - f2;
        return answer;
    }

    public void initDPArray(int[][][] dp, int val) {
        for (int[][] t : dp) {
            for (int[] r : t) {
                Arrays.fill(r, val);
            }
        }
    }

    public int[] intToDigitArray(int x) {
        String s = String.valueOf(x);
        int[] num = new int[s.length()];
        int i = 0;
        for (char ch : s.toCharArray()) {
            num[i++] = ch - 48;
        }
        return num;
    }

    int f(int position, int isSmaller, int countOfd, int[] num, int d, int k, int[][][] dp) {

        // base cases
        if (countOfd > k) return 0;
        if (position == num.length) {
            if (countOfd == k) return 1;
            return 0;
        }

        // memoization
        if (dp[position][isSmaller][countOfd] != -1) {
            return dp[position][isSmaller][countOfd];
        }

        int answer = 0;
        // find maxDigit possible
        int maxDigit = 9;
        if (isSmaller == 0) {
            maxDigit = num[position];
        }

        // i represents new_digit
        for (int i = 0; i <= maxDigit; i++) {

            int tmpCount = countOfd;
            if (i == d) tmpCount++;

            int tmpIsSmaller = isSmaller;
            if (i < maxDigit) {
                tmpIsSmaller = 1;
            }

            answer += f(position + 1, tmpIsSmaller, tmpCount, num, d, k, dp);
        }

        return dp[position][isSmaller][countOfd] = answer;
    }
}
