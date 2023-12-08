import java.util.Arrays;

/*
Given range [a, b] inclusive of both a and b, find the total numbers whose sum of digits is divisible by k
 */
public class class_q2_sum_of_digits_mod_k {
    public static void main(String[] args) {
        class_q2_sum_of_digits_mod_k t = new class_q2_sum_of_digits_mod_k();
        {
            int a = 10;
            int b = 28;
            int k = 3;
            System.out.println(t.solve(a, b, k)); // 6
        }
        {
            int a = 106;
            int b = 365;
            int k = 6;
            System.out.println(t.solve(a, b, k)); // 43
        }
    }

    // TC: O( k. log(N) )
    int solve(int a, int b, int k) {
        int answer;
        // dp[position][isSmaller][sumModK]
        int[][][] dp;

        int[] numB = intToDigitArray(b);
        // sum will always be less than k so keep third state size as k
        dp = new int[numB.length][2][k];
        for (int[][] t : dp) {
            for (int[] r : t) {
                Arrays.fill(r, -1);
            }
        }
        int f1 = f(0, 0, 0, numB, k, dp);

        int[] numA = intToDigitArray(a - 1);
        dp = new int[numA.length][2][k];
        for (int[][] t : dp) {
            for (int[] r : t) {
                Arrays.fill(r, -1);
            }
        }
        int f2 = f(0, 0, 0, numA, k, dp);

        answer = f1 - f2;
        return answer;
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

    int f(int position, int isSmaller, int sumModK, int[] num, int k, int[][][] dp) {

        // base cases
        if (position == num.length) {
            if (sumModK == 0) return 1;
            return 0;
        }

        if (dp[position][isSmaller][sumModK] != -1) {
            return dp[position][isSmaller][sumModK];
        }

        int answer = 0;
        // find maxDigit possible
        int maxDigit = 9;
        if (isSmaller == 0) {
            maxDigit = num[position];
        }

        for (int i = 0; i <= maxDigit; i++) {
            int tmpSumModK = sumModK;
            int tmpIsSmaller = isSmaller;
            tmpSumModK = tmpSumModK + i;
            tmpSumModK %= k;
            if (i < maxDigit) {
                tmpIsSmaller = 1;
            }
            answer += f(position + 1, tmpIsSmaller, tmpSumModK, num, k, dp);
        }

        return dp[position][isSmaller][sumModK] = answer;
    }
}
