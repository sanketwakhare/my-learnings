import java.util.Stack;

/* Double Character Trouble */

/***
 * Problem Description
 * 
 * You are given a string A.
 * An operation on the string is defined as follows:
 * 
 * Remove the first occurrence of same consecutive characters. eg for a string
 * "abbcd", the first occurrence of same consecutive characters is "bb".
 * 
 * Therefore the string after this operation will be "acd".
 * 
 * Keep performing this operation on the string until there are no more
 * occurrences of same consecutive characters and return the final string.
 * 
 * Problem Constraints
 * 1 <= |A| <= 100000
 * 
 * Input Format
 * First and only argument is string A.
 * 
 * Output Format
 * Return the final string.
 * 
 * Example Input
 * Input 1:
 * A = abccbc
 * Input 2:
 * A = ab
 * 
 * Example Output
 * Output 1:
 * "ac"
 * Output 2:
 * "ab"
 * 
 * Example Explanation
 * 
 * Explanation 1:
 * Remove the first occurrence of same consecutive characters. eg for a string
 * "abbc", the first occurrence of same consecutive characters is "bb".
 * Therefore the string after this operation will be "ac".
 * Explanation 2:
 * No removals are to be done.
 */

public class q2_DoubleCharacterTrouble {

    public static String solve(String A) {

        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < A.length(); i++) {
            char currentChar = A.charAt(i);
            if (!stack.isEmpty() && stack.peek() == currentChar) {
                // if consecutive character is found, pop element from stack
                stack.pop();
            } else {
                // push element to stack
                stack.push(currentChar);
            }
        }

        // Retrieve the elements from stack and store as string
        // using StringBuilder here is faster
        StringBuilder out = new StringBuilder();
        while (!stack.isEmpty()) {
            char currentChar = stack.peek();
            stack.pop();
            out.append(currentChar);
        }

        // reverse the string and return
        return out.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(solve("abccbc"));
        System.out.println(solve("ab"));
        System.out.println(solve("abcjgffrredsdotittdditod"));
    }

}
