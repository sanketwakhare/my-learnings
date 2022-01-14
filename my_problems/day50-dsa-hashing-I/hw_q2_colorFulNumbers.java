import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

/* Colorful Number */
/**
 * 
 * Problem Description
 * 
 * For Given Number A find if its COLORFUL number or not.
 * If number A is a COLORFUL number return 1 else return 0.
 * What is a COLORFUL Number:
 * 
 * A number can be broken into different contiguous sub-subsequence parts.
 * Suppose, a number 3245 can be broken into parts like 3 2 4 5 32 24 45 324
 * 245.
 * And this number is a COLORFUL number, since product of every digit of a
 * contiguous subsequence is different.
 * 
 * Problem Constraints
 * 1 <= A <= 2 * 10^9
 * 
 * Input Format
 * Single Argument which denotes integer A.
 * 
 * Output Format
 * Return 1 if integer A is COLORFUL else return 0.
 * 
 * Example Input
 * Input 1:
 * A = 23
 * 
 * Input 2:
 * A = 236
 * 
 * Example Output
 * Output 1:
 * 1
 * Output 2:
 * 0
 * 
 * Example Explanation
 * Explanation 1:
 * Possible Sub-sequences: [2, 3, 23] where
 * 2 -> 2
 * 3 -> 3
 * 23 -> 6 (product of digits)
 * This number is a COLORFUL number since product of every digit of a
 * sub-sequence are different.
 * 
 * Explanation 2:
 * Possible Sub-sequences: [2, 3, 6, 23, 36, 236] where
 * 2 -> 2
 * 3 -> 3
 * 6 -> 6
 * 23 -> 6 (product of digits)
 * 36 -> 18 (product of digits)
 * 236 -> 36 (product of digits)
 * This number is not a COLORFUL number since the product sequence 23 and
 * sequence 6 is same.
 */

/**
 * TC: O(no of digits in A)
 */
public class hw_q2_colorFulNumbers {

    public static int isColorFulNumber(int A) {

        // get all the digits within number n
        List<Integer> digitList = new ArrayList<Integer>();
        while (A > 0) {
            int digit = A % 10;
            digitList.add(digit);
            A = A / 10;
        }

        Set<Integer> hashSet = new HashSet<Integer>();
        for (int i = digitList.size() - 1; i >= 0; i--) {
            int prod = 1;
            for (int j = i; j >= 0; j--) {
                prod = prod * digitList.get(j);
                if (hashSet.contains(prod)) {
                    // products are repeating
                    return 0;
                } else {
                    hashSet.add(prod);
                }
            }
        }

        // if colorful number, return 1
        return 1;
    }

    public static void main(String[] args) {

        int output1 = isColorFulNumber(23);
        System.out.println("is " + 23 + " colorful number :-> " + output1);
        int output2 = isColorFulNumber(236);
        System.out.println("is " + 236 + " colorful number :-> " + output2);
        int output3 = isColorFulNumber(1);
        System.out.println("is " + 1 + " colorful number :-> " + output3);
        int output4 = isColorFulNumber(99);
        System.out.println("is " + 99 + " colorful number :-> " + output4);

    }
}
