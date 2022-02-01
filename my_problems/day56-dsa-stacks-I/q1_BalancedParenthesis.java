import java.util.Stack;
/* Balanced Parenthesis */

/***
 * Problem Description

Given an expression string A, examine whether the pairs and the orders of “{“,”}”, ”(“,”)”, ”[“,”]” are correct in A.

Refer to the examples for more clarity.

Problem Constraints
1 <= |A| <= 100

Input Format
The first and the only argument of input contains the string A having the parenthesis sequence.

Output Format
Return 0, if the parenthesis sequence is not balanced.
Return 1, if the parenthesis sequence is balanced.

Example Input
Input 1:
 A = {([])}
Input 2:
 A = (){
Input 3:
 A = ()[] 

Example Output
Output 1:
 1 
Output 2:
 0 
Output 3:
 1 

Example Explanation
You can clearly see that the first and third case contain valid parenthesis.
In the second case, there is no closing bracket for {, thus the parenthesis sequence is invalid.
 */

/**
 * TC: O(N)
 * SC: O(N)
 */
public class q1_BalancedParenthesis {

    public static int solve(String A) {

        Stack<Character> stack = new Stack<Character>();
        int isBalanced = 1;

        for (int i = 0; i < A.length(); i++) {

            char currentChar = A.charAt(i);
            switch (currentChar) {
                case '{':
                case '(':
                case '[':
                    stack.push(currentChar);
                    break;

                case '}':
                    if (!stack.isEmpty() && stack.peek() == '{') {
                        stack.pop();
                    } else {
                        isBalanced = 0;
                    }
                    break;
                case ')':
                    if (!stack.isEmpty() && stack.peek() == '(') {
                        stack.pop();
                    } else {
                        isBalanced = 0;
                    }
                    break;
                case ']':
                    if (!stack.isEmpty() && stack.peek() == '[') {
                        stack.pop();
                    } else {
                        isBalanced = 0;
                    }
                    break;
            }
            if (isBalanced == 0) {
                break;
            }
        }
        if (!stack.isEmpty()) {
            isBalanced = 0;
        }
        return isBalanced;
    }

    public static void main(String[] args) {

        System.out.println(solve("{([])}"));
        System.out.println(solve("((((()))))"));
        System.out.println(solve("}}}}"));
        System.out.println(solve("((())}"));
    }
}