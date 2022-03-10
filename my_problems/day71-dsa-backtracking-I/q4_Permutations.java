import java.util.ArrayList;
import java.util.Arrays;

/* Permutations */

/* Problem Description

Given an integer array A of size N denoting collection of numbers , return all possible permutations.

NOTE:

No two entries in the permutation sequence should be the same.
For the purpose of this problem, assume that all the numbers in the collection are unique.
Return the answer in any order
WARNING: DO NOT USE LIBRARY FUNCTION FOR GENERATING PERMUTATIONS. Example : next_permutations in C++ / itertools.permutations in python.
If you do, we will disqualify your submission retroactively and give you penalty points.


Problem Constraints

1 <= N <= 9


Input Format

Only argument is an integer array A of size N.


Output Format

Return a 2-D array denoting all possible permutation of the array.


Example Input

A = [1, 2, 3]

Example Output

[ [1, 2, 3]
  [1, 3, 2]
  [2, 1, 3] 
  [2, 3, 1] 
  [3, 1, 2] 
  [3, 2, 1] ]


Example Explanation

All the possible permutation of array [1, 2, 3]. */

/**
 * Recursive relation: T(N) = T(N) * T(N-1) + 1
 * TC: O(2^N)
 * SC: O(N)
 */
public class q4_Permutations {

    public static ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {

        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        permutations(0, new ArrayList<Integer>(), A, list);
        return list;
    }

    public static void permutations(int i, ArrayList<Integer> temp, ArrayList<Integer> A,
            ArrayList<ArrayList<Integer>> list) {

        // base condition
        if (i == A.size()) {
            ArrayList<Integer> currList = new ArrayList<Integer>(temp);
            list.add(currList);
        }

        for (int k = 0; k < A.size(); k++) {
            if (temp.contains(A.get(k))) {
                continue;
            }
            temp.add(A.get(k));
            permutations(i + 1, temp, A, list);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {

        // test case 1
        Integer[] A = { 4, 7, 8 };
        ArrayList<Integer> inputList = new ArrayList<Integer>(Arrays.asList(A));
        ArrayList<ArrayList<Integer>> outputList = permute(inputList);
        System.out.println(outputList); // [[4, 7, 8], [4, 8, 7], [7, 4, 8], [7, 8, 4], [8, 7, 4], [8, 4, 7]]

        // test case 2
        A = new Integer[] { 1, 2, 3 };
        inputList = new ArrayList<Integer>(Arrays.asList(A));
        outputList = permute(inputList);
        System.out.println(outputList); // [[1, 2, 3], [1, 3, 2], [2, 1, 3], [2, 3, 1], [3, 2, 1], [3, 1, 2]]

    }

}
