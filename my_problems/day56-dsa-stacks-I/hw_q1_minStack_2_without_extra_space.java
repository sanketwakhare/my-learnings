/* Min Stack */

/**
 * Problem Description

Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.

NOTE:
All the operations have to be constant time operations.
getMin() should return -1 if the stack is empty.
pop() should return nothing if the stack is empty.
top() should return -1 if the stack is empty.

Problem Constraints
1 <= Number of Function calls <= 10^7

Input Format
Functions will be called by the checker code automatically.

Output Format
Each function should return the values as defined by the problem statement.

Example Input

Input 1:
push(1)
push(2)
push(-2)
getMin()
pop()
getMin()
top()

Input 2:
getMin()
pop()
top()


Example Output

Output 1:
 -2 1 2

Output 2:
 -1 -1

Example Explanation

Explanation 1:
Let the initial stack be : []
1) push(1) : [1]
2) push(2) : [1, 2]
3) push(-2) : [1, 2, -2]
4) getMin() : Returns -2 as the minimum element in the stack is -2.
5) pop() : Return -2 as -2 is the topmost element in the stack.
6) getMin() : Returns 1 as the minimum element in stack is 1.
7) top() : Return 2 as 2 is the topmost element in the stack.

Explanation 2:
Let the initial stack be : []
1) getMin() : Returns -1 as the stack is empty.
2) pop() :  Returns nothing as the stack is empty.
3) top() : Returns -1 as the stack is empty.
 */

import java.util.Stack;

/**
 * Solved without using extra space
 * SC: O(N) for main stack only. no space for current minimum
 * TC: O(1)
 */
public class hw_q1_minStack_2_without_extra_space {

    Stack<Integer> stack;
    int currentMin;

    public hw_q1_minStack_2_without_extra_space() {
        // initialize 2 stacks. one for storing array elements and one for min till
        // current element in stack
        stack = new Stack<Integer>();
        currentMin = Integer.MAX_VALUE;
    }

    public void push(int x) {

        if ((2 * x) - currentMin < x) {
            // x is less than current minimum
            // we are storing x and current minimum both information in the stack
            stack.push((2 * x) - currentMin);
            // update current minimum
            currentMin = Math.min(x, currentMin);
        } else {
            stack.push(x);
        }
    }

    public void pop() {
        // remove top from the stack and update current minimum
        if (!stack.isEmpty()) {

            int currentTop = stack.peek();
            if (currentTop < currentMin) {
                // if information is hidden, retrieve the previous minimum value
                // update current minimum
                int prevMin = 2 * currentMin - currentTop;
                currentMin = prevMin;
            }
            // remove element from stack
            stack.pop();
        }
    }

    public int top() {
        // if stack is empty return -1, else return top of the stack
        if (stack.isEmpty()) {
            return -1;
        }
        int currentTop = stack.peek();
        if (currentTop < currentMin) {
            // if information is hidden, retrieve the current actual top/x value
            return currentMin;
        }
        return stack.peek();
    }

    public int getMin() {
        // if minStack is empty return -1, else return top of the minStack
        if (stack.isEmpty()) {
            return -1;
        }
        return currentMin;
    }

    public static void main(String[] args) {
        // test case 1
        hw_q1_minStack_2_without_extra_space test1 = new hw_q1_minStack_2_without_extra_space();
        test1.push(1);
        test1.push(2);
        test1.push(-2);
        System.out.print(test1.getMin() + " ");
        test1.pop();
        System.out.print(test1.getMin() + " ");
        System.out.print(test1.top() + " ");
        // expected output -2 1 2

        // test case 2
        System.out.println();
        hw_q1_minStack_2_without_extra_space test2 = new hw_q1_minStack_2_without_extra_space();
        System.out.print(test2.getMin() + " ");
        test2.pop();
        System.out.print(test2.top() + " ");
        // expected output -1 -1

        // test case 3
        System.out.println();
        hw_q1_minStack_2_without_extra_space test3 = new hw_q1_minStack_2_without_extra_space();
        test3.push(10);
        test3.push(20);
        System.out.print(test3.getMin() + " ");
        System.out.print(test3.top() + " ");
        test3.push(30);
        System.out.print(test3.getMin() + " ");
        System.out.print(test3.top() + " ");
        test3.push(6);
        System.out.print(test3.getMin() + " ");
        System.out.print(test3.top() + " ");
        test3.push(8);
        System.out.print(test3.getMin() + " ");
        System.out.print(test3.top() + " ");
        test3.pop();
        System.out.print(test3.getMin() + " ");
        System.out.print(test3.top() + " ");
        test3.push(2);
        System.out.print(test3.getMin() + " ");
        System.out.print(test3.top() + " ");

    }

}
