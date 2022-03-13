/* Subsets II */

/* Problem Description

Given a collection of integers denoted by array A of size N that might contain duplicates, return all possible subsets.

NOTE:

Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
The subsets must be sorted lexicographically.


Problem Constraints

0 <= N <= 16


Input Format

Only argument is an integer array A of size N.


Output Format

Return a 2-D vector denoting all the possible subsets.


Example Input

Input 1:

 A = [1, 2, 2]
Input 2:

 A = [1, 1]


Example Output

Output 1:

 [
    [],
    [1],
    [1, 2],
    [1, 2, 2],
    [2],
    [2, 2]
 ]
Output 2:

 [
    [],
    [1],
    [1, 1]
 ]


Example Explanation

Explanation 1:

All the subsets of the array [1, 2, 2] in lexicographically sorted order. */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Recursive Relation: T(N) = T(N-1) * N + 1
 * TC: O(2^N)
 * SC:O(N) => for storing each element in list
 */
public class hw_q1_Subsets_II {

    public ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> A) {

        // sort the input data as we have return the subsets in lexicographic order
        Collections.sort(A);

        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        backtrack(0, A, new ArrayList<Integer>(), list);
        return list;

    }

    public void backtrack(int index, ArrayList<Integer> A, ArrayList<Integer> temp,
            ArrayList<ArrayList<Integer>> list) {

        // add subset only when is is unique
        if (!list.contains(temp)) {
            list.add(new ArrayList<Integer>(temp));
        }

        for (int i = index; i < A.size(); i++) {
            // do
            temp.add(A.get(i));
            // call recursive function
            backtrack(i + 1, A, temp, list);
            // undo
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        hw_q1_Subsets_II t1 = new hw_q1_Subsets_II();

        // test case 1
        Integer[] inputArray = new Integer[] { 1, 2, 2 };
        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(inputArray));
        ArrayList<ArrayList<Integer>> subset = t1.subsetsWithDup(A);
        t1.printSubset(subset);

        // test case 2
        inputArray = new Integer[] { 1, 1 };
        A = new ArrayList<Integer>(Arrays.asList(inputArray));
        subset = t1.subsetsWithDup(A);
        t1.printSubset(subset);

        // test case 3
        inputArray = new Integer[] { 9 };
        A = new ArrayList<Integer>(Arrays.asList(inputArray));
        subset = t1.subsetsWithDup(A);
        t1.printSubset(subset);

    }

    // util function
    private void printSubset(ArrayList<ArrayList<Integer>> subset) {
        System.out.println();
        System.out.print("\n\nsubset: ");
        for (List<Integer> currSubset : subset) {
            printList(currSubset);
        }
    }

    // util function
    private void printList(List<Integer> list) {

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
}
