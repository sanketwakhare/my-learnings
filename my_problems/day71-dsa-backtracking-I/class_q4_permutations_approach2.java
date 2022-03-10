/* Permutations */

import java.util.ArrayList;
import java.util.Arrays;

/* Q) Generate all permutations of numbers given in an array */

public class class_q4_permutations_approach2 {

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
            if (temp.contains(A.get(k)))
                continue;
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
