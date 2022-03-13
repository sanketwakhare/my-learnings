/* Subset */

/* Problem Description

Given a set of distinct integers A, return all possible subsets.

NOTE:

Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
Also, the subsets should be sorted in ascending ( lexicographic ) order.
The list is not necessarily sorted.


Problem Constraints

1 <= |A| <= 16
INT_MIN <= A[i] <= INT_MAX


Input Format

First and only argument of input contains a single integer array A.



Output Format

Return a vector of vectors denoting the answer.



Example Input

Input 1:

A = [1]
Input 2:

A = [1, 2, 3]


Example Output

Output 1:

[
    []
    [1]
]
Output 2:

[
 []
 [1]
 [1, 2]
 [1, 2, 3]
 [1, 3]
 [2]
 [2, 3]
 [3]
]


Example Explanation

Explanation 1:

 You can see that these are all possible subsets.
Explanation 2:

You can see that these are all possible subsets. */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Recursive Relation: T(N) = T(N-1) * N + 1
 * TC: O(2^N)
 * SC:O(N) => for storing each element in list
 */
public class q1_Subset {

    public static List<List<Integer>> solve(int[] A) {

        // sort the input array
        Arrays.sort(A);

        int n = A.length;
        List<Integer> list = new ArrayList<Integer>();
        List<List<Integer>> subsetList = new ArrayList<List<Integer>>();

        // call recursive function
        subsets(0, n, A, list, subsetList);
        return subsetList;
    }

    private static void subsets(int i, int n, int[] a, List<Integer> list, List<List<Integer>> subsetList) {

        // add list elements until now
        subsetList.add(new ArrayList<Integer>(list));

        // fix current i, and next elements in array into list and add list on every
        // insertion
        for (int j = i; j < n; j++) {
            list.add(a[j]);
            subsets(j + 1, n, a, list, subsetList);
            list.remove(list.size() - 1);
        }

    }

    private static void printSubset(List<List<Integer>> subset) {
        System.out.println();
        System.out.print("\n\nsubset: ");
        for (List<Integer> currSubset : subset) {
            printList(currSubset);
        }
    }

    private static void printList(List<Integer> list) {

        StringBuilder sb = new StringBuilder();
        if (list.size() > 0) {
            sb.append("{");
        } else {
            sb.append("{ ");
        }
        for (Integer item : list) {
            sb.append(" " + item + ",");
        }
        sb.replace(sb.length() - 1, sb.length(), " ");
        sb.append("}");
        System.out.print("\n" + sb.toString());
    }

    public static void main(String[] args) {

        // test case 1
        int[] A = new int[] { 1 };
        List<List<Integer>> subsets = solve(A);
        printSubset(subsets);

        // test case 2
        A = new int[] { 1, 2, 3 };
        subsets = solve(A);
        printSubset(subsets);

        // test case 3
        A = new int[] { 9, 10, 13 };
        subsets = solve(A);
        printSubset(subsets);

        // test case 4
        A = new int[] { 15, 20, 12, 19, 4 };
        subsets = solve(A);
        printSubset(subsets);
    }
}
