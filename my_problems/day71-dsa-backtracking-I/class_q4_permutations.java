/* Permutations */

import java.util.ArrayList;
import java.util.Arrays;

/* Q) Generate all permutations of numbers given in an array */

public class class_q4_permutations {

    public static ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {

        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        permutations(0, A.size(), A, list);
        return list;
    }

    public static void permutations(int i, int n, ArrayList<Integer> A, ArrayList<ArrayList<Integer>> list) {

        // base condition
        if (i == n) {
            ArrayList<Integer> currList = new ArrayList<Integer>();
            for (int j = 0; j < n; j++) {
                currList.add(A.get(j));
            }
            list.add(currList);
        }

        for (int k = i; k < n; k++) {
            // swap to get different permutations
            swap(A, i, k);
            permutations(i + 1, n, A, list);
            // swap back to original state
            swap(A, i, k);
        }
    }

    private static void swap(ArrayList<Integer> A, int i, int k) {
        int temp = A.get(i);
        A.set(i, A.get(k));
        A.set(k, temp);
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
