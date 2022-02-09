/* Sum of min and max */

/**
 * Problem Description

Given an array A of both positive and negative integers.

Your task is to compute sum of minimum and maximum elements of all sub-array of size B.

NOTE: Since the answer can be very large, you are required to return the sum modulo 109 + 7.


Problem Constraints
1 <= size of array A <= 10^5
-10^9 <= A[i] <= 10^9
1 <= B <= size of array

Input Format
The first argument denotes the integer array A.
The second argument denotes the value B


Output Format
Return an integer that denotes the required value.



Example Input
Input 1:
 A = [2, 5, -1, 7, -3, -1, -2]
 B = 4
Input 2:
 A = [2, -1, 3]
 B = 2

Example Output
Output 1:
 18
Output 2:
 3

Example Explanation
Explanation 1:
 Subarray of size 4 are : 
    [2, 5, -1, 7],   min + max = -1 + 7 = 6
    [5, -1, 7, -3],  min + max = -3 + 7 = 4      
    [-1, 7, -3, -1], min + max = -3 + 7 = 4
    [7, -3, -1, -2], min + max = -3 + 7 = 4   
    Sum of all min & max = 6 + 4 + 4 + 4 = 18 

Explanation 2:
 Subarray of size 2 are : 
    [2, -1],   min + max = -1 + 2 = 1
    [-1, 3],   min + max = -1 + 3 = 2
    Sum of all min & max = 1 + 2 = 3 
 */
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Approach: using 2 Dequeues and Sliding Window technique, find the sum of
 * minimum
 * and maximum of each window
 * 
 * TC: O(N)
 * SC: O(N) - Dequeue space
 */
public class hw_q1_Sum_of_min_and_max_using2Dequeues {

    public static int solve(List<Integer> A, int B) {

        // using Deque approach to find min and max from each window of size B
        int N = A.size();
        long answer = 0;
        long m = 1000000007;

        Deque<Integer> maxDeque = new LinkedList<Integer>();
        Deque<Integer> minDeque = new LinkedList<Integer>();

        // perform operation for first window
        for (int i = 0; i < B; i++) {
            int currentEle = A.get(i);

            // maxDeque
            // add currentEle to dequeue
            while (maxDeque.size() != 0 && maxDeque.peekLast() < currentEle) {
                maxDeque.pollLast();
            }
            // add current element to last
            maxDeque.offerLast(currentEle);

            // minDeque
            while (minDeque.size() != 0 && minDeque.peekLast() > currentEle) {
                // poll last till current element is smaller than last element in dequeue
                // only greater elements can be placed at the end of minDeque
                minDeque.pollLast();
            }
            // add current element to last
            minDeque.offerLast(currentEle);
        }
        // update answer for first window
        long maxFromWindow = (long) maxDeque.peekFirst();
        long minFromWindow = (long) minDeque.peekFirst();
        answer = ((maxFromWindow % m) + (minFromWindow % m)) % m;
        answer = (answer + m) % m;

        // perform similar operations for all windows
        for (int i = 1; i <= N - B; i++) {

            int eleToRemove = A.get(i - 1);
            int eleToAdd = A.get(i + B - 1);

            // maxDeque
            while (maxDeque.size() != 0 && maxDeque.peekLast() < eleToAdd) {
                // poll last till current element is greater.
                // only smaller elements can be placed at end of maxDeque
                maxDeque.pollLast();
            }
            // add eleToAdd to last
            maxDeque.offerLast(eleToAdd);

            if (maxDeque.peekFirst() == eleToRemove) {
                maxDeque.pollFirst();
            }

            // minDeque
            while (minDeque.size() != 0 && minDeque.peekLast() > eleToAdd) {
                // poll last till current element is smaller than last element in dequeue
                // only greater elements can be placed at the end of minDeque
                minDeque.pollLast();
            }
            // add current element to last
            minDeque.offerLast(eleToAdd);

            if (minDeque.peekFirst() == eleToRemove) {
                minDeque.pollFirst();
            }

            // perform addition of max and min of current window
            maxFromWindow = (long) maxDeque.peekFirst();
            minFromWindow = (long) minDeque.peekFirst();

            // add it to the answer
            long currentAns = ((maxFromWindow % m) + (minFromWindow % m)) % m;
            answer = ((answer % m) + (currentAns % m)) % m;
            answer = (answer + m) % m;

        }

        return (int) answer;

    }

    public static void main(String[] args) {

        // test case 1
        Integer[] a1 = { 2, 5, -1, 7, -3, -1, -2 };
        List<Integer> A1 = Arrays.asList(a1);
        int B1 = 4;
        int answer1 = solve(A1, B1);
        System.out.println("answer = " + answer1); // expected answer 18

        // test case 2
        Integer[] a2 = { 2, -1, 3 };
        List<Integer> A2 = Arrays.asList(a2);
        int B2 = 2;
        int answer2 = solve(A2, B2);
        System.out.println("answer = " + answer2); // expected answer 3

        // test case 3
        Integer[] a3 = { 2, -3, 1 };
        List<Integer> A3 = Arrays.asList(a3);
        int B3 = 2;
        int answer3 = solve(A3, B3);
        System.out.println("answer = " + answer3); // expected answer

    }

}
