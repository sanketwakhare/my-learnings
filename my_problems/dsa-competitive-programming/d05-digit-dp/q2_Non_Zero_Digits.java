import java.util.Arrays;

/*
Non Zero Digits

Problem Description
Nobita's teacher gave him some problems to solve.

He has to solve q queries. He is given a list A of strings. List A contains numbers in string format. The ith query consists of numbers A[2*i] and A[2*i+1]. The answer to ith query is the count from A[2*i] to A[2*i+1] whose decimal representation contains no more than 3 non-zero digits. Since the answer can be large, return it modulo 109 + 7.

Can you help him?

Problem Constraints
2 <= |A| <= 2*10^4
|A| is even
1 <= |A[i]| <= 18
A[i] does not contain leading zeroes


Input Format
The first line of input contains A- list of numbers in string format.

Output Format
Return a vector of size q- ith of which contains the answer for ith query.

Example Input
Input 1:
  ["1", "10"]
Input 2:
  ["1109", "1115"]

Example Output
Output 1:
  10
Output 2:
  2

Example Explanation
Explanation 1:
  All numbers have less than or equal to 3 non-zero digits.
Explanation 2:
  The valid numbers are- 1109, 1110.
 */
public class q2_Non_Zero_Digits {

    public static void main(String[] args) {
        q2_Non_Zero_Digits t = new q2_Non_Zero_Digits();
        {
            System.out.println(Arrays.toString(t.solve(new String[]{"1", "10"}))); // [10]
            System.out.println(Arrays.toString(t.solve(new String[]{"1109", "1115"})));// [2]
            System.out.println(Arrays.toString(t.solve(new String[]{"1", "10", "1109", "1115"})));// [10, 2]
            System.out.println(Arrays.toString(t.solve(
                    new String[]{"66", "95", "542", "9540", "744", "864", "166", "60007"})));// [30, 2816, 121, 5896]
            System.out.println(Arrays.toString(t.solve(
                    new String[]{"64", "835", "65", "6403", "17", "553", "592", "968"})));// [772, 2451, 537, 377]
        }
    }

    /* TC: Q * 2 * 10 * logN
        where Q = no of queries,
            2 = dp state isSmaller,
            10 = dp state countOfNonZeros
            N = no of digits in given number*/
    // SC: negligible - O(1) as max dp array size = new int[18][2][10]
    public int[] solve(String[] A) {
        int[] answer = new int[A.length / 2];
        int ind = 0;
        for (int i = 0; i < A.length; i += 2) {
            long a = Long.parseLong(A[i]);
            long b = Long.parseLong(A[i + 1]);
            int currAns = solveForRange(a, b);
            answer[ind++] = currAns;
        }
        return answer;
    }

    int solveForRange(long a, long b) {
        int answer;
        int[][][] dp;

        int[] numB = toDigitArray(b);
        // count will always be < 10, so keep dp state countOfNonZeros size as 10
        dp = new int[numB.length][2][10];
        fillDpArray(dp, -1);
        int f1 = f(0, 0, 0, numB, dp);

        int[] numA = toDigitArray(a - 1);
        dp = new int[numA.length][2][10];
        fillDpArray(dp, -1);
        int f2 = f(0, 0, 0, numA, dp);

        answer = f1 - f2;
        return answer;
    }

    public void fillDpArray(int[][][] dp, int val) {
        for (int[][] t : dp) {
            for (int[] r : t) {
                Arrays.fill(r, val);
            }
        }
    }

    public int[] toDigitArray(long x) {
        String s = String.valueOf(x);
        int[] num = new int[s.length()];
        int i = 0;
        for (char ch : s.toCharArray()) {
            num[i++] = ch - 48;
        }
        return num;
    }

    int f(int position, int isSmaller, int countOfNonZeros, int[] num, int[][][] dp) {

        // base cases
        if (countOfNonZeros > 3) return 0;
        if (position == num.length) {
            return 1;
        }

        // memoization
        if (dp[position][isSmaller][countOfNonZeros] != -1) {
            return dp[position][isSmaller][countOfNonZeros];
        }

        int answer = 0;
        // find maxDigit possible
        int maxDigit = 9;
        if (isSmaller == 0) {
            maxDigit = num[position];
        }

        // i represents new_digit
        for (int i = 0; i <= maxDigit; i++) {

            int tmpCountOfNonZeros = countOfNonZeros;
            // if new digit is non-zero, increase count
            if (i != 0) tmpCountOfNonZeros++;

            int tmpIsSmaller = isSmaller;
            if (i < maxDigit) {
                tmpIsSmaller = 1;
            }

            answer += f(position + 1, tmpIsSmaller, tmpCountOfNonZeros, num, dp);
        }

        return dp[position][isSmaller][countOfNonZeros] = answer;
    }
}

