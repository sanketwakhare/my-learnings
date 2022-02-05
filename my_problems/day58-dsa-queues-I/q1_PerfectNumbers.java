import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/* Perfect Numbers */

/**
 * Problem Description
 * 
 * Given an integer A, you have to find the Ath Perfect Number.
 * A Perfect Number has the following properties:
 * It comprises only 1 and 2.
 * The number of digits in a Perfect number is even.
 * It is a palindrome number.
 * 
 * For example 11, 22, 112211 are Perfect numbers, where 123, 121, 782, 1 are
 * not.
 * 
 * Problem Constraints
 * 1 <= A <= 100000
 * 
 * Input Format
 * The only argument given is an integer A.
 * 
 * Output Format
 * Return a string that denotes the Ath Perfect Number.
 * 
 * Example Input
 * Input 1:
 * A = 2
 * Input 2:
 * A = 3
 * 
 * Example Output
 * Output 1:
 * 22
 * Output 2:
 * 1111
 * 
 * Example Explanation
 * Explanation 1:
 * First four perfect numbers are:
 * 1. 11
 * 2. 22
 * 3. 1111
 * 4. 1221
 * Explanation 2:
 * First four perfect numbers are:
 * 1. 11
 * 2. 22
 * 3. 1111
 * 4. 1221
 */

/**
 * TC: O(N)
 * SC: O(N)
 */
public class q1_PerfectNumbers {

    public static String solve(int A) {

        Queue<Long> queue = new LinkedList<Long>();
        ArrayList<String> list = new ArrayList<String>();

        int count = 0;
        long[] numbers = { 1, 2 };
        while (count < A && count < numbers.length) {

            StringBuilder strBld = new StringBuilder();
            strBld.append(numbers[count]);
            strBld.append(strBld.reverse());
            list.add(strBld.toString());
            queue.add(numbers[count]);
            count++;
        }
        if (count < numbers.length) {
            return list.get(A - 1);
        }

        // A > 2 here
        while (count < A && !queue.isEmpty()) {
            long x = queue.poll();
            int i = 0;
            while (count < A && i < numbers.length) {
                long next = (x * (long) 10) + (long) numbers[i];

                StringBuilder strBld = new StringBuilder();
                String strLeft = String.valueOf(next);
                String strRight = new StringBuilder(String.valueOf(next)).reverse().toString();
                strBld.append(strLeft);
                strBld.append(strRight);
                list.add(strBld.toString());
                queue.add(next);
                i++;
                count++;
            }
        }
        // for(String str: list) {
        // System.out.println(str);
        // }
        return list.get(A - 1);
    }

    public static void main(String[] args) {
        System.out.println("answer ->" + solve(1));
        System.out.println("answer ->" + solve(10));
        System.out.println("answer ->" + solve(2));
        System.out.println("answer ->" + solve(3));
        System.out.println("answer ->" + solve(4));
        System.out.println("answer ->" + solve(5));
        System.out.println("answer ->" + solve(10000));

    }

}
