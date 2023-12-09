import java.util.Arrays;

/*
Reference: https://www.spoj.com/problems/RAONE/
RAONE - Ra-One Numbers (slightly different from this problem)
Given range [a, b] both inclusive, find how many numbers are present
where | sum of digits at even location - sum of digits at odd location | = 1
 */
public class class_q4_Ra_One_Numbers {
    public static void main(String[] args) {
        class_q4_Ra_One_Numbers t = new class_q4_Ra_One_Numbers();
        {
            int a = 1;
            int b = 10;
            System.out.println(t.solve(a, b)); // 2 [01 and 10]
        }
        {
            int a = 10;
            int b = 100;
            System.out.println(t.solve(a, b)); // 18 [10, 12, 21, 23, 32, 34, 43, 45, 54, 56, 65, 67, 76, 78, 87, 89, 98, 100]
        }
        {
            int a = 100;
            int b = 500;
            System.out.println(t.solve(a, b)); // 18 [100, 111, 120, 122, 131, 34, 43, 45, 54, 56, 65, 67, 76, 78, 87, 89, 98, 100]
        }
    }

    // Iterations: (log(N) base 10) * 2 * 10 * sumSize * sumSize
    // assume sumSize = k
    // TC: O( k^2 * log(N) )
    // SC: 9 *   2 * k * k = O(k^2)
    int solve(int a, int b) {
        int answer;
        // dp[position][isSmaller][oddPosSum][evenPosSum]
        int[][][][] dp;

        int[] numB = intToDigitArray(b);
        // sum of even or odd numbers will always be less than total digits in [(total_digits_in_number+1)/2 * 9] at max
        // i.e. <= ((num.length +1)/2) * 9;
        // so keep third and fourth state size as 9 * ((numB.length + 1) / 2) + 1
        int sumSize = 9 * ((numB.length + 1) / 2) + 1;
        dp = new int[numB.length][2][sumSize][sumSize];
        initDPArray(dp, -1);
        int f1 = f(0, 0, 0, 0, numB, dp);

        int[] numA = intToDigitArray(a - 1);
        sumSize = 9 * ((numA.length + 1) / 2) + 1;
        dp = new int[numA.length][2][sumSize][sumSize];
        initDPArray(dp, -1);
        int f2 = f(0, 0, 0, 0, numA, dp);

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

    int f(int position, int isSmaller, int oddPosSum, int evenPosSum, int[] num, int[][][][] dp) {

        // base cases
        if (position == num.length) {
            return Math.abs(oddPosSum - evenPosSum) == 1 ? 1 : 0;
        }

        // memoization
        if (dp[position][isSmaller][oddPosSum][evenPosSum] != -1) {
            return dp[position][isSmaller][oddPosSum][evenPosSum];
        }

        int answer = 0;
        // find maxDigit possible
        int maxDigit = 9;
        if (isSmaller == 0) {
            maxDigit = num[position];
        }

        // i represents new_digit
        for (int i = 0; i <= maxDigit; i++) {

            int tmpOddPosSum = oddPosSum;
            int tmpEvenPosSum = evenPosSum;
            if (i % 2 == 0) {
                tmpEvenPosSum += i;
            } else {
                tmpOddPosSum += i;
            }

            int tmpIsSmaller = isSmaller;
            if (tmpIsSmaller == 0 && i < maxDigit) {
                tmpIsSmaller = 1;
            }

            answer += f(position + 1, tmpIsSmaller, tmpOddPosSum, tmpEvenPosSum, num, dp);
        }

        return dp[position][isSmaller][oddPosSum][evenPosSum] = answer;
    }
}
