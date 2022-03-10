/*  Combination Sum II */

/* 
Problem Description

Given an array of size N of candidate numbers A and a target number B. Return all unique combinations in A where the candidate numbers sums to B.

Each number in A may only be used once in the combination.

Note:

All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
The solution set must not contain duplicate combinations.
Warning:

DO NOT USE LIBRARY FUNCTION FOR GENERATING COMBINATIONS.

Example : itertools.combinations in python. If you do, we will disqualify your submission and give you penalty points.


Problem Constraints

1 <= N <= 20


Input Format

First argument is an integer array A denoting the collection of candidate numbers.
Second argument is an integer which represents the target number.


Output Format

Return all unique combinations in A where the candidate numbers sums to B.


Example Input

Input 1:

 A = [10, 1, 2, 7, 6, 1, 5]
 B = 8
Input 2:

 A = [2, 1, 3]
 B = 3


Example Output

Output 1:

 [ 
  [1, 1, 6 ],
  [1, 2, 5 ],
  [1, 7 ], 
  [2, 6 ] 
 ]
Output 2:

 [
  [1, 2 ],
  [3 ]
 ]


Example Explanation

Explanation 1:

 1 + 1 + 6 = 8
 1 + 2 + 5 = 8
 1 + 7 = 8
 2 + 6 = 8
 All the above combinations sum to 8 and are arranged in ascending order.
Explanation 2:

 1 + 2 = 3
 3 = 3
 All the above combinations sum to 3 and are arranged in ascending order.
*/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class hw_q1_Combinations_Sum_II {

    public static ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B) {

        Collections.sort(A);

        ArrayList<ArrayList<Integer>> subsetsWithSumB = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> temp = new ArrayList<Integer>();
        int sum = 0;

        combinationsSumII(0, A, temp, B, sum, subsetsWithSumB);
        return subsetsWithSumB;

    }

    public static void combinationsSumII(int i, ArrayList<Integer> A, ArrayList<Integer> temp,
            int B, int sum, ArrayList<ArrayList<Integer>> list) {

        // base condition
        if (i == A.size()) {
            // do not insert duplicates
            if (sum == B && !list.contains(temp)) {
                list.add(new ArrayList<Integer>(temp));
            }
            return;
        }

        int currEle = A.get(i);

        // add
        sum = sum + currEle;
        temp.add(currEle);
        combinationsSumII(i + 1, A, temp, B, sum, list);

        // remove
        sum = sum - currEle;
        temp.remove(temp.size() - 1);
        combinationsSumII(i + 1, A, temp, B, sum, list);
    }

    public static void main(String[] args) {

        // test case 1
        Integer[] A = new Integer[] { 2, 3, 6, 7 };
        ArrayList<Integer> inputList = new ArrayList<Integer>(Arrays.asList(A));
        int B = 9;
        ArrayList<ArrayList<Integer>> outputList = combinationSum(inputList, B);
        /* expected output: [[2, 2, 2, 3], [2, 7], [3, 3, 3],[3, 6]] */
        System.out.println(outputList);

        // test case 2
        A = new Integer[] { 10, 17, 8, 17, 20, 20, 18, 14, 15, 20, 3 };
        inputList = new ArrayList<Integer>(Arrays.asList(A));
        B = 14;
        outputList = combinationSum(inputList, B); // [[8, 3, 3], [14]]
        System.out.println(outputList);

        // test case 3
        A = new Integer[] { 8, 10, 6, 11, 1, 16, 8 };
        inputList = new ArrayList<Integer>(Arrays.asList(A));
        B = 28;
        outputList = combinationSum(inputList, B);
        System.out.println(outputList); // [[1, 1, 6], [1, 2, 5], [1, 7], [2, 6]]

        // test case 4
        A = new Integer[] { 10, 1, 2, 7, 6, 1, 5 };
        inputList = new ArrayList<Integer>(Arrays.asList(A));
        B = 8;
        outputList = combinationSum(inputList, B);
        System.out.println(outputList); // [[1, 6, 10, 11], [1, 8, 8, 11], [1, 11, 16]]

        // test case 5
        A = new Integer[] { 2, 1, 3 };
        inputList = new ArrayList<Integer>(Arrays.asList(A));
        B = 3;
        outputList = combinationSum(inputList, B);
        System.out.println(outputList); // [[1, 2], [3]]

        // test case 6
        A = new Integer[] { 15, 8, 15, 10, 19, 18, 10, 3, 11, 7, 17 };
        inputList = new ArrayList<Integer>(Arrays.asList(A));
        B = 33;
        outputList = combinationSum(inputList, B);
        System.out.println(outputList); // [[3, 7, 8, 15], [3, 11, 19], [3, 15, 15], [7, 8, 18], [7, 11, 15], [8, 10,
                                        // 15], [15, 18]]

    }
}
