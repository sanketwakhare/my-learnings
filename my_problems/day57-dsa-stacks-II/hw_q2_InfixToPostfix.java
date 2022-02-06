import java.util.Stack;

/* Infix to Postfix */

/**
 * Problem Description

Given string A denoting an infix expression. Convert the infix expression into postfix expression.
String A consists of ^, /, *, +, -, (, ) and lowercase english alphabets where lowercase english alphabets are operands and ^, /, *, +, - are operators.
Find and return the postfix expression of A.

NOTE:
^ has highest precedence.
/ and * have equal precedence but greater than + and -.
+ and - have equal precedence and lowest precedence among given operators.

Problem Constraints
1 <= length of the string <= 500000

Input Format
The only argument given is string A.

Output Format
Return a string denoting the postfix conversion of A.

Example Input
Input 1:
 A = "x^y/(a*z)+b"
Input 2:
 A = "a+b*(c^d-e)^(f+g*h)-i"

Example Output
Output 1:
 "xy^az* /b+"
Output 2:
"abcd^e-fgh*+^*+i-"

Example Explanation
Explanation 1:
Output denotes the postfix expression of the given input.
 */

/**
 * Infix to Postfix conversion
 */
public class hw_q2_InfixToPostfix {

    public static int getPrecedence(char c) {
        int precedenceValue;
        switch (c) {
            case '+':
            case '-':
                precedenceValue = 1;
                break;

            case '*':
            case '/':
                precedenceValue = 2;
                break;

            case '^':
                precedenceValue = 3;
                break;
            default:
                precedenceValue = 0;
                break;
        }
        return precedenceValue;
    }

    public static boolean isOperator(char currentChar) {
        boolean isOperator = false;
        switch (currentChar) {
            case '+':
            case '-':
            case '*':
            case '/':
            case '^':
                isOperator = true;
        }
        return isOperator;
    }

    public static String solve(String A) {

        Stack<Character> stack = new Stack<Character>();
        StringBuilder postfix = new StringBuilder();

        for (int i = 0; i < A.length(); i++) {
            char currentChar = A.charAt(i);

            if (isOperator(currentChar)) {
                // if operator, check the precedence of current character with precedence of top
                // of stack
                if (!stack.isEmpty()) {
                    int currPrec = getPrecedence(currentChar);
                    char top = stack.peek();
                    int topPrec = getPrecedence(top);
                    while (!stack.isEmpty() && topPrec >= currPrec) {
                        // pop and append to postfix expression
                        postfix.append(stack.pop());
                        if (!stack.isEmpty()) {
                            top = stack.peek();
                            topPrec = getPrecedence(top);
                        }
                    }
                }
                // push operator to stack
                stack.push(currentChar);
            } else if (currentChar == '(') {
                // push to stack only
                stack.push(currentChar);
            } else if (currentChar == ')') {
                // pop until we encounter '('
                while (stack.peek() != '(') {
                    postfix.append(stack.pop());
                }
                // remove '(' bracket from stack as we do not add this in postfix expression
                stack.pop();
            } else {
                postfix.append(currentChar);
            }
        }

        // append all the remaining characters in stack to postfix expression
        while (!stack.isEmpty()) {
            // pop and append to postfix expression
            postfix.append(stack.pop());
        }

        return postfix.toString();
    }

    public static void main(String[] args) {
        // test case 1
        String A1 = "x^y/(a*z)+b";
        System.out.println("answer -> " + solve(A1)); // expected output "xy^az*/b+"

        // test case 2
        String A2 = "a+b*(c^d-e)^(f+g*h)-i";
        System.out.println("answer -> " + solve(A2)); // expected output "abcd^e-fgh*+^*+i-"
    }
}
