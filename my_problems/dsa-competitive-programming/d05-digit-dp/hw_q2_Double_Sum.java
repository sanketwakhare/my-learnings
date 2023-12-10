/*
Double Sum

Problem Description
Digit sum of a number is the sum of digits of a number.

You have to solve q queries. You are given a list A of strings. List A contains numbers in string format. The ith query consists of numbers A[2*i] and A[2*i+1]. The answer to ith query is the digit sum of set of numbers from A[2*i] to A[2*i+1]. Since the answer can be large, return it modulo 109 + 7.


Problem Constraints
2 <= |A| <= 200
|A| is even
1 <= |A[i]| <= 15
A[i] does not contain leading zeroes.

Input Format
The first line of input contains A- list of numbers in string format.

Output Format
Return a vector of size q- ith of which contains the answer for ith query.

Example Input
Input 1:
  ["1", "5", "22", "23"]
Input 2:
  ["10", "15"]


Example Output:
Output 1:
  [15, 9]
Output 2:
  [21]

Example Explanation:
Explanation 1:

  For first query, 1 + 2 + 3 + 4 + 5 = 15.
  For second query, 2 + 2 + 2 + 3 = 9.
Explanation 2:

  1 + 0 + 1 + 1 + 1 + 2 + 1 + 3 + 1 + 4 + 1 + 5 = 21
 */
import java.util.Arrays;

public class hw_q2_Double_Sum {

    public static void main(String[] args) {
        hw_q2_Double_Sum t = new hw_q2_Double_Sum();
        {
            System.out.println(Arrays.toString(t.solve(new String[]{"1", "5", "22", "23"}))); // [15, 9]
        }
        {
            System.out.println(Arrays.toString(t.solve(new String[]{"10", "15"}))); // [21]
        }
        {
            System.out.println(Arrays.toString(t.solve(new String[]{"2939816", "221087595"}))); // [931482723]
        }
        {
            String[] s = {"1065826", "626259157884", "645", "96482787", "35", "58735796892386", "35", "7876976155055", "11566", "46175798471", "481", "89255", "45772", "3208498698999", "13888139", "609648241026308", "10447", "93182", "66", "6870288", "54852", "4886169577536", "809", "890294274034628", "3785085", "8446017", "632", "8385072", "49", "70", "710", "6976655918562", "699", "405427", "44", "34074", "92611", "5024627279892", "58586", "9227996", "34945", "9885336", "7346", "4821137", "2177144", "94539242", "5053098", "9571435175763", "694317", "26378826", "8189", "337076180", "8623", "72907003324", "356992", "260041342632", "3436", "9723", "78595", "5967246", "476319", "112864729", "857", "1741956808", "21", "615", "86538159", "998601953957927", "4466", "7347630073120", "933", "277533", "5261", "15252400430387", "137", "1134510", "90", "99990402", "75796", "808152542", "3566", "13463127397", "6456112", "278949498", "59", "6246355", "4829", "85491018", "756", "755964", "4231215", "692099382209", "1033", "87416122", "9788", "216504", "54", "514", "99210366", "9211549854474", "5886163", "499447599008", "4564848", "49638515", "1492", "2832778", "41290", "9563527807532", "2637", "632629772471227", "43", "29837608512", "740", "9356043", "7806", "796404890055292", "122787", "9846300", "72640536", "681093110917756", "711", "44095793490", "2309293", "5886661281", "5695", "696827", "89348", "2442757", "63", "68766782", "9896", "27975", "774", "106036", "3595", "495721", "31", "5391", "2243320", "340092249", "4098158", "37469102", "65288", "54173020429233", "883", "1737211800", "6728", "293015", "94818", "513092", "208858", "1060473", "53748", "73808", "712", "336046", "580562", "199681627630876", "9421", "85594", "35588", "41593466", "15083714", "164288808472460", "457", "65880", "13326579", "13630973", "157", "768", "1757314", "9928852580", "84", "3990542459", "667", "30003", "580", "82774827611", "36850", "91359934547602", "98503", "7991900", "42", "5781", "68", "47264660131397", "79", "894702223556", "2657", "60070", "28093", "34787385126216", "587", "97371323", "45", "340790387", "2939816", "221087595"};
            System.out.println(Arrays.toString(t.solve(s)));
            // [22566335, 444947139, 229180014, 653998034, 58888229, 1951062, 416452489, 979118567, 1869222, 205058424, 471533933, 358248102, 151612332, 256217537, 220, 676978896, 9697432, 642833, 32744939, 285039611, 309634938, 138519386, 305896856, 204680328, 823352706, 419463002, 435958164, 682997204, 123348, 174006732, 998586244, 216933478, 6960, 756031783, 985730921, 6390723, 12204278, 30069056, 599477937, 912188827, 750894734, 21733057, 184077540, 3276380, 19357488, 140011536, 82176499, 4749740, 5284, 998481463, 944159280, 529106323, 78325918, 666169171, 146055054, 841833830, 290540354, 848139146, 306005469, 626448720, 183000110, 214615254, 17644491, 64527435, 362433032, 344084, 2342989, 12052075, 83352, 481662561, 105426717, 535427231, 10630309, 6727682, 10446273, 23526936, 479178, 7834321, 887569342, 1686355, 368071842, 833351559, 1353678, 9370383, 8055, 2972537, 499675733, 562233, 159671408, 121301198, 241441566, 90792, 667570285, 122446995, 1194021, 998451069, 482694761, 566002566, 931482723]
        }
    }

    int mod = (int) 1e9 + 7;

    public int[] solve(String[] A) {
        int[] answer = new int[A.length / 2];
        int ind = 0;
        for (int i = 0; i < A.length; i += 2) {
            String aStr = A[i];
            String bStr = A[i + 1];
            long a = Long.parseLong(aStr);
            long b = Long.parseLong(bStr);
            int sum = findSumForRange(a, b);
            answer[ind++] = sum;
        }
        return answer;
    }

    public int findSumForRange(long a, long b) {
        // find for [0, a-1]
        // max sum of digits can be 15*9 = 135 as 15 digit string at max,
        // taking 150 to be on safer side
        int[] numA = toDigitArray(a - 1);
        int[][][] dp = new int[numA.length][2][150];
        fill(dp, -1);
        int f1 = f(0, 0, 0, dp, numA);

        // find for [0, b]
        int[] numB = toDigitArray(b);
        dp = new int[numB.length][2][150];
        fill(dp, -1);
        int f2 = f(0, 0, 0, dp, numB);

        return (int) ((long) f2 - f1 + mod) % mod;
    }

    public int f(int position, int isSmaller, int sum, int[][][] dp, int[] nums) {
        // base cases
        if (position == nums.length) {
            return sum;
        }

        // memoization
        if (dp[position][isSmaller][sum] != -1) {
            return dp[position][isSmaller][sum];
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

            int tmpSum = sum + i;

            answer = answer + f(position + 1, tmpIsSmaller, tmpSum, dp, nums);
            answer %= mod;
        }

        return dp[position][isSmaller][sum] = (int) answer;
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

    public void fill(int[][][] dp, int val) {
        for (int[][] t : dp) {
            for (int[] r : t) {
                Arrays.fill(r, val);
            }
        }
    }
}
