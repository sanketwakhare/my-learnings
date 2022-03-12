import java.util.ArrayList;
import java.util.Arrays;

/* Number of Squareful Arrays */
// TODO: complete the problem
public class hw_q2_Number_of_Squareful_Arrays {

    public static int solve(ArrayList<Integer> A) {

        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();

        squarefulPermutations(0, A, list);
        System.out.println(list);
        return list.size();
    }

    public static void squarefulPermutations(int i, ArrayList<Integer> A,
            ArrayList<ArrayList<Integer>> list) {

        // base condition
        if (i == A.size()) {
            if (!list.contains(A)) {
                if (checkConsecutiveSum(A)) {
                    list.add(new ArrayList<Integer>(A));
                }
            }
            return;
        }

        for (int k = i; k < A.size(); k++) {
            swap(A, i, k);
            if (i != k) {
                long sum = A.get(i) + A.get(k);
                if (isSquare(sum)) {
                    squarefulPermutations(i + 1, A, list);
                }
            } else {
                squarefulPermutations(i + 1, A, list);
            }
            swap(A, i, k);
        }
    }

    public static boolean isSquare(long sum) {
        double sqrt = Math.sqrt(sum);
        if (sqrt - Math.floor(sqrt) != 0) {
            return false;
        }
        return true;
    }

    public static boolean checkConsecutiveSum(ArrayList<Integer> A) {

        // edge ase for size=0
        if (A.size() == 0) {
            return false;
        }
        // edge case when size of array is 1
        if (A.size() == 1) {
            double sqrt = Math.sqrt(A.get(0));
            if (sqrt - Math.floor(sqrt) != 0) {
                return false;
            }
        }
        for (int i = 0; i < A.size() - 1; i++) {
            int j = i + 1;
            // sum of consecutive elements
            int sum = A.get(i) + A.get(j);
            // return false if sum is not perfect square
            double sqrt = Math.sqrt(sum);
            if (sqrt - Math.floor(sqrt) != 0) {
                return false;
            }
        }
        return true;
    }

    public static void swap(ArrayList<Integer> A, int i, int k) {
        int temp = A.get(i);
        A.set(i, A.get(k));
        A.set(k, temp);
    }

    public static void main(String[] args) {

        // test case 1
        // Integer[] A = { 2, 2, 2 };
        // ArrayList<Integer> inputList = new ArrayList<Integer>(Arrays.asList(A));
        // int count = solve(inputList);
        // System.out.println(count); // 1

        // // test case 2
        // A = new Integer[] { 1, 17, 8 };
        // inputList = new ArrayList<Integer>(Arrays.asList(A));
        // count = solve(inputList);
        // System.out.println(count); // 2

        // // test case 3
        // A = new Integer[] { 41 };
        // inputList = new ArrayList<Integer>(Arrays.asList(A));
        // count = solve(inputList);
        // System.out.println(count); // 0

        // test case 4
        Integer[] A = new Integer[] { 5050, 879, 82, 18, 82, 18, 18, 31, 33, 88, 137 };
        ArrayList<Integer> inputList = new ArrayList<Integer>(Arrays.asList(A));
        int count = solve(inputList);
        System.out.println(count); // 0
    }

}