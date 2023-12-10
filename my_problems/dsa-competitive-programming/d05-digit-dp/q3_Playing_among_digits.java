/*
Playing among digits!

Problem Description
Determine the number of integers that are available from L to R (both inclusive) and satisfy the following conditions:

Sum of its digits is equal to a prime number
Divisible by C
Please try to use any fast language to solve this problem like C++, Java etc. (not Python)

Problem Constraints
1 <= L, R, C <= 2 × 10^10
It is guaranteed that A <= B, the number of digits in A and B don't exceed 11.


Input Format
First argument is a numeric string A denoting the integer L.
Second argument is a numeric string B denoting the integer R.
Third argument is an integer C.
NOTE: A and B doesn't contain leading zeroes and 1 <= |A|, |B| <= 11

Output Format
Return a single integer that denotes the answer to this question modulo 109 + 7

Example Input
Input 1:
 A = "5"
 B = "86"
 C = 4
Input 2:
 A = "1"
 B = "20"
 C = 2

Example Output:
Output 1:
 7
Output 2:
 5

Example Explanation:
Explanation 1:
 There are 7 such numbers: 12 16 20 32 52 56 76

 */
import java.math.BigInteger;
import java.util.Arrays;

public class q3_Playing_among_digits {
    public static void main(String[] args) {
        q3_Playing_among_digits t = new q3_Playing_among_digits();
        {
            String A = "5";
            String B = "86";
            int C = 4;
            System.out.println(t.solve(A, B, C)); // 7 [12, 16, 20, 32, 52, 56, 76]
        }
        {
            String A = "1";
            String B = "20";
            int C = 2;
            System.out.println(t.solve(A, B, C)); // 5 [2, 12, 14, 16, 20]
        }
        {
            String A = "1955";
            String B = "20000000000";
            int C = 1;
            System.out.println(t.solve(A, B, C)); // 727666089
        }
        {
            String A = "1624";
            String B = "4521";
            int C = 3907;
            System.out.println(t.solve(A, B, C)); // 1 [3907]
        }
    }

    int mod = 1000000007;
    boolean[] sieve;

    public int solve(String A, String B, int C) {

        // using sieve[] brute force approach as C can not fit into dp array
        if (C > 1000) {
            sieve = generatePrimeSieve(200);
            long a = Long.parseLong(A);
            long b = Long.parseLong(B);
            // start from first element in the range [a, b] which is divisible by C
            long start = a % C == 0 ? a : (a / C + 1) * C;
            long answer = 0;
            for (long i = start; i <= b; i += C) {
                // find sum of digits in number i
                long tmp = i;
                int s = 0;
                while (tmp > 0) {
                    s = s + (int) (tmp % 10);
                    tmp = tmp / 10;
                }
                // if sum is prime, update answer
                if (sieve[s]) {
                    answer++;
                    answer %= mod;
                }
            }
            return (int) answer;
        }

        // using dp array approach if C<=1000 as it can fit into dp array
        int[][][][] dp;

        // [0, A-1]
        String AMinus1 = subtract(A, "1");
        int[] numA = toDigitArray(AMinus1);
        dp = new int[numA.length][2][100][C];
        fill(dp, -1);
        int f1 = f(0, 0, 0, 0, dp, numA, C);

        // [0, B]
        int[] numB = toDigitArray(B);
        dp = new int[numB.length][2][100][C];
        fill(dp, -1);
        int f2 = f(0, 0, 0, 0, dp, numB, C);

        return f2 - f1;
    }

    public int f(int position, int isSmaller, int sumDigits, int numModC, int[][][][] dp, int[] nums, int C) {
        // base case
        if (position == nums.length) {
            return isPrime(sumDigits) && (numModC == 0) ? 1 : 0;
        }

        // memoization
        if (dp[position][isSmaller][sumDigits][numModC] != -1) {
            return dp[position][isSmaller][sumDigits][numModC];
        }

        int maxDigit = 9;
        if (isSmaller == 0) {
            maxDigit = nums[position];
        }

        long answer = 0;
        for (int i = 0; i <= maxDigit; i++) {
            int tmpIsSmaller = isSmaller;
            if (i < maxDigit) {
                tmpIsSmaller = 1;
            }

            int tmpSumDigits = sumDigits + i;
            int tmpNumModC = (numModC * 10) + i;
            tmpNumModC %= C;

            answer += f(position + 1, tmpIsSmaller, tmpSumDigits, tmpNumModC, dp, nums, C);
            answer %= mod;
        }
        return dp[position][isSmaller][sumDigits][numModC] = (int) (answer % mod);
    }

    public int[] toDigitArray(String A) {
        int[] num = new int[A.length()];
        int i = 0;
        for (char ch : A.toCharArray()) {
            num[i++] = ch - 48;
        }
        return num;
    }

    public void fill(int[][][][] dp, int val) {
        for (int[][][] l : dp) {
            for (int[][] p : l) {
                for (int[] q : p) {
                    Arrays.fill(q, val);
                }
            }
        }
    }

    public boolean isPrime(int N) {
        boolean isPrime = true;
        int count = 2;
        // iterate from 2 to sqrt(N)
        for (int i = 2; i * i <= N; i++) {
            if (N % i == 0) {
                count++;
                if (i != Math.floor(N / i)) {
                    // if i is a factor then N/i is also factor
                    // count only when i != N/i
                    count++;
                }
            }
        }
        if (count > 2 || N == 1 || N == 0) {
            isPrime = false;
        }
        return isPrime;
    }

    public boolean[] generatePrimeSieve(int max) {
        // initialize prime array from 1 to N with true (assumption)
        boolean[] prime = new boolean[max + 1];
        Arrays.fill(prime, true);
        prime[0] = prime[1] = false;

        // mark all numbers which are multiples of the previous numbers
        for (int i = 2; i * i <= max; i++) {
            for (int j = i * i; j <= max; j = j + i) {
                if (prime[j]) {
                    prime[j] = false;
                }
            }
        }
        return prime;
    }

    // subtract 2 digit strings
    public String subtract(String a, String b) {

        // Create BigInteger objects from strings
        BigInteger num1 = new BigInteger(a);
        BigInteger num2 = new BigInteger(b);

        // Perform subtraction
        BigInteger result = num1.subtract(num2);

        // Convert result back to a string
        return result.toString();
    }
}
