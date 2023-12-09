import java.util.Arrays;

/*
Hard Investigation
Given range [a, b] both inclusive, find how many numbers are present
whose sum of digits is divisible by K and the number itself is also divisible by K.
 */
public class class_q3_Hard_Investigation {
    public static void main(String[] args) {
        class_q3_Hard_Investigation t = new class_q3_Hard_Investigation();
        {
            int a = 10;
            int b = 28;
            int k = 2;
            System.out.println(t.solve(a, b, k)); // 5
        }
        {
            int a = 100;
            int b = 200;
            int k = 2;
            System.out.println(t.solve(a, b, k)); // 43
        }
    }

    // Iterations: (log(N) base 10) * 2 * 10 * k * k
    // TC: O( k^2 * log(N) )
    // SC: 9 * 2 * k * k = O(k^2)
    int solve(int a, int b, int k) {
        int answer;
        // dp[position][isSmaller][sumModK][numModK]
        int[][][][] dp;

        int[] numB = intToDigitArray(b);
        // sum will always be less than k so keep third state size as k
        // num will always be less than k so keep fourth state size as k
        dp = new int[numB.length][2][k][k];
        initDPArray(dp, -1);
        int f1 = f(0, 0, 0, 0, numB, k, dp);

        int[] numA = intToDigitArray(a - 1);
        dp = new int[numA.length][2][k][k];
        initDPArray(dp, -1);
        int f2 = f(0, 0, 0, 0, numA, k, dp);

        answer = f1 - f2;
        return answer;
    }

    public void initDPArray(int[][][][] dp, int val) {
        for (int[][][] t : dp) {
            for (int[][] r : t) {
                for (int[] s : r) {
                    Arrays.fill(s, val);
                }
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

    int f(int position, int isSmaller, int sumModK, int numModK, int[] num, int k, int[][][][] dp) {

        // base cases
        if (position == num.length) {
            if (sumModK == 0 && numModK == 0) return 1;
            return 0;
        }

        // memoization
        if (dp[position][isSmaller][sumModK][numModK] != -1) {
            return dp[position][isSmaller][sumModK][numModK];
        }

        int answer = 0;
        // find maxDigit possible
        int maxDigit = 9;
        if (isSmaller == 0) {
            maxDigit = num[position];
        }

        // i represents new_digit
        for (int i = 0; i <= maxDigit; i++) {

            int tmpSumModK = sumModK + i;
            tmpSumModK %= k;

            int tmpNumModK = (10 * numModK) + i;
            tmpNumModK %= k;

            int tmpIsSmaller = isSmaller;
            if (tmpIsSmaller == 0 && i < maxDigit) {
                tmpIsSmaller = 1;
            }

            answer += f(position + 1, tmpIsSmaller, tmpSumModK, tmpNumModK, num, k, dp);
        }

        return dp[position][isSmaller][sumModK][sumModK] = answer;
    }
}
