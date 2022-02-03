import java.util.ArrayList;
import java.util.Stack;

/* Evaluate Expression */

/**
 * Problem Description
 * 
 * An arithmetic expression is given by a character array A of size N. Evaluate
 * the value of an arithmetic expression in Reverse Polish Notation.
 * Valid operators are +, -, *, /. Each character may be an integer or an
 * operator.
 * 
 * Problem Constraints
 * 1 <= N <= 10^5
 * 
 * Input Format
 * The only argument given is character array A.
 * 
 * Output Format
 * Return the value of arithmetic expression formed using reverse Polish
 * Notation.
 * 
 * Example Input
 * Input 1:
 * A = ["2", "1", "+", "3", "*"]
 * Input 2:
 * A = ["4", "13", "5", "/", "+"]
 * 
 * Example Output
 * Output 1:
 * 9
 * Output 2:
 * 6
 * 
 * Example Explanation
 * Explanation 1:
 * starting from backside:
 * : () * ()
 * 3 : () * (3)
 * + : (() + ()) * (3)
 * 1 : (() + (1)) * (3)
 * 2 : ((2) + (1)) * (3)
 * ((2) + (1)) * (3) = 9
 * Explanation 2:
 * + : () + ()
 * / : () + (() / ())
 * 5 : () + (() / (5))
 * 1 : () + ((13) / (5))
 * 4 : (4) + ((13) / (5))
 * (4) + ((13) / (5)) = 6
 */

/**
 * Idea: use stack to evaluate postfix expression ~ reverse polish notation
 * TC: O(N)
 * SC: O(N)
 */
public class q1_EvaluateExpression {

    public static int evalRPN(ArrayList<String> A) {

        // initialize stack
        Stack<Integer> stack = new Stack<Integer>();

        for (int i = 0; i < A.size(); i++) {
            String currentStr = A.get(i);

            int operand1;
            int operand2;
            int currentResult;
            switch (currentStr) {
                // if current string is operator, perform operation and push result to stack
                case "+":
                    operand1 = stack.pop();
                    operand2 = stack.pop();
                    currentResult = operand2 + operand1;
                    stack.push(currentResult);
                    break;
                case "-":
                    operand1 = stack.pop();
                    operand2 = stack.pop();
                    currentResult = operand2 - operand1;
                    stack.push(currentResult);
                    break;
                case "*":
                    operand1 = stack.pop();
                    operand2 = stack.pop();
                    currentResult = operand2 * operand1;
                    stack.push(currentResult);
                    break;
                case "/":
                    operand1 = stack.pop();
                    operand2 = stack.pop();
                    currentResult = operand2 / operand1;
                    stack.push(currentResult);
                    break;

                // if current string is operand, push to stack
                default:
                    stack.push(Integer.valueOf(currentStr));
                    break;
            }
        }

        // return final result from stack
        return stack.pop();

    }

    public static void main(String[] args) {
        ArrayList<String> A = new ArrayList<String>();
        A.add("2");
        A.add("1");
        A.add("+");
        A.add("3");
        A.add("*");
        int answer = evalRPN(A);
        System.out.println(answer);

        A = new ArrayList<String>();
        A.add("4");
        A.add("13");
        A.add("5");
        A.add("/");
        A.add("+");
        answer = evalRPN(A);
        System.out.println(answer);
    }

}
