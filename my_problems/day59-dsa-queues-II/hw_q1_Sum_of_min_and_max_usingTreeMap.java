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
import java.util.TreeMap;

/**
 * Approach: using TreeMap and Sliding WIndow technique, find the sum of minimum
 * and maximum of each window
 * 
 * TC: O(N LogK) - as treeMap maintains the items in sorted order
 * SC: O(N) - treeMap space
 */
public class hw_q1_Sum_of_min_and_max_usingTreeMap {

    public static int solve(int[] A, int B) {

        int N = A.length;
        long answer = 0;
        long m = 1000000007;
        TreeMap<Integer, Integer> treeMap = new TreeMap<Integer, Integer>();

        // perform for first window
        for (int i = 0; i < B; i++) {
            int currentEle = A[i];
            if (treeMap.containsKey(currentEle)) {
                treeMap.put(currentEle, (treeMap.get(currentEle) + 1));
            } else {
                treeMap.put(currentEle, 1);
            }
        }
        // update answer
        long currentMin = (long) treeMap.firstKey();
        long currentMax = (long) treeMap.lastKey();
        answer = ((currentMax % m) + (currentMin % m)) % m;
        // for negative answer, convert to +ve
        if (answer < 0) {
            answer = answer + m;
        }

        // perform similar operations for remaining windows
        for (int i = 1; i <= N - B; i++) {
            int eleToAdd = A[i + B - 1];
            int eleToRemove = A[i - 1];

            // add element to treeMap
            if (!treeMap.containsKey(eleToAdd)) {
                treeMap.put(eleToAdd, 1);
            } else {
                treeMap.put(eleToAdd, treeMap.get(eleToAdd) + 1);
            }

            // remove previous window element from treeMap
            if (treeMap.get(eleToRemove) == 1) {
                // remove
                treeMap.remove(eleToRemove);
            } else {
                // decrease freq by 1
                treeMap.put(eleToRemove, treeMap.get(eleToRemove) - 1);
            }

            currentMin = (long) treeMap.firstKey();
            currentMax = (long) treeMap.lastKey();
            long currentAns = ((currentMax % m) + (currentMin % m)) % m;
            answer = ((answer % m) + (currentAns % m)) % m;
            // for negative answer, convert to +ve
            if (answer < 0) {
                answer = answer + m;
            }
        }
        return (int) (answer % m);
    }

    public static void main(String[] args) {

        // test case 1
        int[] A1 = { 2, 5, -1, 7, -3, -1, -2 };
        int B1 = 4;
        int answer1 = solve(A1, B1);
        System.out.println("answer = " + answer1); // expected answer 18

        // test case 2
        int[] A2 = { 2, -1, 3 };
        int B2 = 2;
        int answer2 = solve(A2, B2);
        System.out.println("answer = " + answer2); // expected answer 3

        // test case 3
        int[] A3 = { 2, -3, 1 };
        int B3 = 2;
        int answer3 = solve(A3, B3);
        System.out.println("answer = " + answer3); // expected answer

    }

}
