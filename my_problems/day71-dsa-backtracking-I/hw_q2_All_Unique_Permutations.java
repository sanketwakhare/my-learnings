import java.util.ArrayList;
import java.util.Arrays;

/* All Unique Permutations */

/**
 * Recursive relation: T(N) = N * T(N-1) + 1
 * T(N) = N * [(N-1) * T(N-2) + 1] + 1
 * = N * (N-1) * T(N-2) + N + 1
 * = N * (N-1) * [N-2 * T(N-3) + 1] + N + 1
 * = N * (N-1) * (N-2) * T(N-3) + N *(N-1) + N + 1
 * = equivalent to N!
 * 
 * TC: O(2^N)
 * SC: O(1) - as we are using swapping
 */
public class hw_q2_All_Unique_Permutations {

    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {

        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        backtrack(0, A.size(), A, list);
        return list;

    }

    public void backtrack(int index, int n, ArrayList<Integer> A, ArrayList<ArrayList<Integer>> list) {

        // base condition
        if (index == n) {
            // only add unique combinations
            if (!list.contains(A)) {
                list.add(new ArrayList<Integer>(A));
            }
        }

        for (int i = index; i < n; i++) {
            // do: swap
            swap(A, index, i);
            backtrack(index + 1, n, A, list);
            // undo: swap
            swap(A, index, i);
        }
    }

    public void swap(ArrayList<Integer> A, int i, int k) {
        Integer temp = A.get(i);
        A.set(i, A.get(k));
        A.set(k, temp);
    }

    public static void main(String[] args) {

        hw_q2_All_Unique_Permutations t1 = new hw_q2_All_Unique_Permutations();

        // test case 1
        Integer[] A = { 1, 1, 2 };
        ArrayList<Integer> inputList = new ArrayList<Integer>(Arrays.asList(A));
        ArrayList<ArrayList<Integer>> outputList = t1.permute(inputList);
        System.out.println(outputList); // [[1, 1, 2], [1, 2, 1], [2, 1, 1]]

        // test case 2
        A = new Integer[] { 1, 2 };
        inputList = new ArrayList<Integer>(Arrays.asList(A));
        outputList = t1.permute(inputList);
        System.out.println(outputList); // [[1, 2], [2, 1]]

        // test case 3
        A = new Integer[] { 5, 6, 6, 5 };
        inputList = new ArrayList<Integer>(Arrays.asList(A));
        outputList = t1.permute(inputList);
        System.out.println(outputList); // [[1, 2], [2, 1]]
    }
}
