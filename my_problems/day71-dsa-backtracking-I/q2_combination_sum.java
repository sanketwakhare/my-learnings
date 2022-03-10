/* Combination Sum */

/* Problem Description

Given a set of candidate numbers A and a target number B, find all unique combinations in A where the candidate numbers sums to B.

The same repeated number may be chosen from A unlimited number of times.

Note:

1) All numbers (including target) will be positive integers.

2) Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).

3) The combinations themselves must be sorted in ascending order.

4) CombinationA > CombinationB iff (a1 > b1) OR (a1 = b1 AND a2 > b2) OR ... (a1 = b1 AND a2 = b2 AND ... ai = bi AND ai+1 > bi+1)

5) The solution set must not contain duplicate combinations.



Problem Constraints

1 <= |A| <= 20

1 <= A[i] <= 50

1 <= B <= 500



Input Format

First argument is the vector A.

Second argument is the integer B.



Output Format

Return a vector of all combinations that sum up to B.



Example Input

Input 1:

A = [2, 3]
B = 2
Input 2:

A = [2, 3, 6, 7]
B = 7


Example Output

Output 1:

[ [2] ]
Output 2:

[ [2, 2, 3] , [7] ]


Example Explanation

Explanation 1:

All possible combinations are listed.
Explanation 2:

All possible combinations are listed. */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * TC: O(2^n)
 * SC: O(N)
 */
public class q2_combination_sum {

    public static ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B) {

        // sort the array
        Collections.sort(A);

        // initialize list, temp and sum
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> temp = new ArrayList<Integer>();
        int sum = 0;

        combinationRec(0, A, B, temp, sum, list);

        return list;
    }

    public static void combinationRec(int i, ArrayList<Integer> A, int B, ArrayList<Integer> temp, int sum,
            ArrayList<ArrayList<Integer>> list) {

        // base condition to check sum and insert only unique combination
        if (sum == B && !list.contains(temp)) {
            list.add(new ArrayList<Integer>(temp));
        }

        // base condition
        if (sum > B) {
            return;
        }

        // initializing k=i will eliminate the duplicates
        for (int k = i; k < A.size(); k++) {
            int currEle = A.get(k);

            // add
            temp.add(currEle);
            sum = sum + currEle;

            combinationRec(k, A, B, temp, sum, list);

            // remove
            temp.remove(temp.size() - 1);
            sum = sum - currEle;
        }

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
        System.out.println(outputList);
        /*
         * expected output:
         * [[1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
         * 1, 1, 1], [1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
         * 6], [1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 8], [1, 1,
         * 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 10], [1, 1, 1, 1, 1, 1, 1, 1,
         * 1, 1, 1, 1, 1, 1, 1, 1, 1, 11], [1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
         * 1, 6, 6], [1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
         * 1, 1, 1, 6, 8], [1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 6, 10], [1, 1, 1, 1, 1,
         * 1, 1, 1, 1, 1, 1, 1, 8, 8], [1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 16], [1, 1,
         * 1, 1, 1, 1, 1, 1, 1, 1, 1, 6, 11], [1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 6, 6, 6],
         * [1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 8, 10], [1, 1, 1, 1, 1, 1, 1, 1, 1, 8, 11],
         * [1, 1, 1, 1, 1, 1, 1, 1, 6, 6, 8], [1, 1, 1, 1, 1, 1, 1, 1, 10, 10], [1, 1,
         * 1, 1, 1, 1, 1, 10, 11], [1, 1, 1, 1, 1, 1, 6, 6,
         * 10], [1, 1, 1, 1, 1, 1, 6, 8, 8], [1, 1, 1, 1, 1, 1, 6, 16], [1, 1, 1, 1, 1,
         * 1, 11, 11], [1, 1, 1, 1, 1, 6, 6, 11], [1, 1, 1, 1, 6, 6, 6, 6], [1, 1, 1, 1,
         * 6, 8, 10], [1, 1, 1, 1, 8, 8, 8], [1, 1, 1, 1, 8, 16], [1, 1, 1, 6, 8, 11],
         * [1, 1, 6, 6, 6, 8], [1, 1, 6, 10, 10], [1, 1, 8, 8, 10], [1, 1, 10, 16], [1,
         * 6, 10, 11], [1, 8, 8, 11], [1, 11, 16], [6, 6, 6, 10], [6, 6, 8, 8], [6, 6,
         * 16], [6, 11, 11], [8, 10, 10]]
         */

    }

}
