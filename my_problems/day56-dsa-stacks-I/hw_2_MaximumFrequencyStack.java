/* Maximum Frequency stack */

/** 
 * Problem Description

You are given a matrix A which represent operations of size N x 2. Assume initially you have a stack-like data structure you have to perform operations on it.

Operations are of two types:
1 x: push an integer x onto the stack and return -1
2 0: remove and return the most frequent element in the stack.

If there is a tie for the most frequent element, the element closest to the top of the stack is removed and returned.
A[i][0] describes the type of operation to be performed. A[i][1] describe the element x or 0 corresponding to the operation performed.

Problem Constraints
1 <= N <= 100000
1 <= A[i][0] <= 2
0 <= A[i][1] <= 10^9

Input Format
The only argument given is the integer array A.

Output Format
Return the array of integers denoting answer to each operation.

Example Input
Input 1:
A = [
            [1, 5]
            [1, 7]
            [1, 5]
            [1, 7]
            [1, 4]
            [1, 5]
            [2, 0]
            [2, 0]
            [2, 0]
            [2, 0]  ]
Input 2:
 A =  [   
        [1, 5]
        [2 0]
        [1 4]   ]

Example Output
Output 1:
 [-1, -1, -1, -1, -1, -1, 5, 7, 5, 4]
Output 2:
 [-1, 5, -1]

Example Explanation
Explanation 1:
 Just simulate given operations
Explanation 2:
 Just simulate given operations
*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Idea is to use 2 maps
 * 1) for storing freq of x -> <x, freq>
 * 2) for storing freq stack -> <freq, Stack<int>>
 * 
 * TC: O(N)
 * SC: O(N)
 */
public class hw_2_MaximumFrequencyStack {

    int maxFreq;
    Map<Integer, Integer> eleFreqMap;
    Map<Integer, Stack<Integer>> stackFreqMap;

    public hw_2_MaximumFrequencyStack() {
        maxFreq = 0;
        eleFreqMap = new HashMap<Integer, Integer>();
        stackFreqMap = new HashMap<Integer, Stack<Integer>>();
    }

    public int push(int x) {

        int currentFreqOfX = 1;
        // step 1 - update current frequency x in eleFreqMap
        if (eleFreqMap.containsKey(x)) {
            currentFreqOfX = eleFreqMap.get(x);
            currentFreqOfX = currentFreqOfX + 1;
        }
        eleFreqMap.put(x, currentFreqOfX);

        // step 2 - update maxFreq value if currentFreqOfX is > maxFreq
        maxFreq = Math.max(maxFreq, currentFreqOfX);

        // step 3 - update stackFreqMap with currentFreqOfX as key and value in stack
        Stack<Integer> stack;
        if (stackFreqMap.containsKey(currentFreqOfX)) {
            stack = stackFreqMap.get(currentFreqOfX);
            stack.push(x);
        } else {
            stack = new Stack<Integer>();
            stack.push(x);
        }
        stackFreqMap.put(currentFreqOfX, stack);

        return -1;
    }

    public int pop() {

        int x = -1;
        // step 1 - retrieve the stack of the current max freq element
        if (stackFreqMap.containsKey(maxFreq)) {
            Stack<Integer> stack = stackFreqMap.get(maxFreq);
            x = stack.pop();

            // step 2 - if there are no more elements with max freq in stack, remove entry
            // and
            // decrement maxFreq
            if (stack.isEmpty()) {
                stackFreqMap.remove(maxFreq);
                maxFreq--;
            }
        }

        // step 3 - update eleFreqMap for current max freq element
        if (eleFreqMap.containsKey(x)) {
            int currentFreqOfX = eleFreqMap.get(x) - 1;
            if (currentFreqOfX == 0) {
                eleFreqMap.remove(x);
            } else {
                eleFreqMap.put(x, currentFreqOfX);
            }
        }
        return x;
    }

    public ArrayList<Integer> solve(ArrayList<ArrayList<Integer>> A) {

        ArrayList<Integer> outputList = new ArrayList<Integer>();

        for (int i = 0; i < A.size(); i++) {
            ArrayList<Integer> currentRec = A.get(i);
            int operation = currentRec.get(0);
            int x = currentRec.get(1);

            int result;
            if (operation == 1) {
                // push operation
                result = push(x);
            } else {
                // pop operation
                result = pop();
            }
            // store result
            outputList.add(result);

        }
        return outputList;
    }

    public static void main(String[] args) {

        // test 1
        // expected answer [-1 -1 -1 -1 -1 -1 5 7 5 4 ]
        ArrayList<ArrayList<Integer>> A = new ArrayList<ArrayList<Integer>>();
        A.add(buildListElement(1, 5));
        A.add(buildListElement(1, 7));
        A.add(buildListElement(1, 5));
        A.add(buildListElement(1, 7));
        A.add(buildListElement(1, 4));
        A.add(buildListElement(1, 5));
        A.add(buildListElement(2, 0));
        A.add(buildListElement(2, 0));
        A.add(buildListElement(2, 0));
        A.add(buildListElement(2, 0));
        hw_2_MaximumFrequencyStack minFreStackMain1 = new hw_2_MaximumFrequencyStack();
        ArrayList<Integer> outList = minFreStackMain1.solve(A);
        System.out.println();
        for (Integer result : outList) {
            System.out.print(result + " ");
        }

        // test 2
        // expected answer [-1 5 -1 ]
        A = new ArrayList<ArrayList<Integer>>();
        A.add(buildListElement(1, 5));
        A.add(buildListElement(2, 0));
        A.add(buildListElement(1, 4));
        hw_2_MaximumFrequencyStack minFreStackMain2 = new hw_2_MaximumFrequencyStack();
        outList = minFreStackMain2.solve(A);
        System.out.println();
        for (Integer result : outList) {
            System.out.print(result + " ");
        }

        // test 3
        // expected answer [-1 4 -1 9 -1 -1 6 ]
        A = new ArrayList<ArrayList<Integer>>();
        A.add(buildListElement(1, 4));
        A.add(buildListElement(2, 0));
        A.add(buildListElement(1, 9));
        A.add(buildListElement(2, 0));
        A.add(buildListElement(1, 6));
        A.add(buildListElement(1, 6));
        A.add(buildListElement(2, 0));
        hw_2_MaximumFrequencyStack minFreStackMain3 = new hw_2_MaximumFrequencyStack();
        outList = minFreStackMain3.solve(A);
        System.out.println();
        for (Integer result : outList) {
            System.out.print(result + " ");
        }

        // test 4
        // expected answer [-1 2 -1 -1 7 2 -1 -1 -1 7 1 4 ]
        A = new ArrayList<ArrayList<Integer>>();
        A.add(buildListElement(1, 2));
        A.add(buildListElement(2, 0));
        A.add(buildListElement(1, 2));
        A.add(buildListElement(1, 7));
        A.add(buildListElement(2, 0));
        A.add(buildListElement(2, 0));
        A.add(buildListElement(1, 4));
        A.add(buildListElement(1, 1));
        A.add(buildListElement(1, 7));
        A.add(buildListElement(2, 0));
        A.add(buildListElement(2, 0));
        A.add(buildListElement(2, 0));
        hw_2_MaximumFrequencyStack minFreStackMain4 = new hw_2_MaximumFrequencyStack();
        outList = minFreStackMain4.solve(A);
        System.out.println();
        for (Integer result : outList) {
            System.out.print(result + " ");
        }

    }

    private static ArrayList<Integer> buildListElement(int operation, int x) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(operation);
        list.add(x);
        return list;
    }

}
