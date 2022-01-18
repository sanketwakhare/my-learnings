import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * TC: O(n^2)
 * SC: O(N)
 */
public class q4_3SumZero {

    public static int[][] threeSum(int[] A) {

        int N = A.length;

        // sort the input array
        Arrays.sort(A);

        Set<List<Integer>> triplets = new HashSet<List<Integer>>();

        for (int k = 0; k < N; k++) {

            // fix current element and apply 2 Sum approach
            int i = k + 1;
            int j = N - 1;

            while (i < j) {
                if (A[i] + A[j] + A[k] == 0) {
                    // found the triplet

                    // store triplet in set of list
                    List<Integer> triplet = new ArrayList<Integer>(3);
                    triplet.add(A[k]);
                    triplet.add(A[i]);
                    triplet.add(A[j]);
                    triplets.add(triplet);

                    int x = A[i];
                    while (x == A[i] && i < j) {
                        i++;
                    }
                    int y = A[j];
                    while (y == A[j] && i < j) {
                        j--;
                    }
                } else if (A[i] + A[j] + A[k] > 0) {
                    j--;
                } else {
                    i++;
                }
            }
        }
        // convert set of list to 2d array
        int[][] output = new int[triplets.size()][3];
        int ind = 0;
        for (List<Integer> triplet : triplets) {
            int[] tripleArray = new int[triplet.size()];
            for (int i = 0; i < triplet.size(); i++) {
                tripleArray[i] = triplet.get(i);
            }
            output[ind++] = tripleArray;
        }

        return output;
    }

    public static void print2D(int mat[][]) {
        System.out.println();
        // Loop through all rows
        for (int[] row : mat) {

            System.out.print("[");
            // Loop through all columns of current row
            for (int x : row) {
                System.out.print(x + " ");
            }
            System.out.print("]");
        }
    }

    public static void main(String[] args) {

        int[] A1 = { 1, -4, 0, 0, 5, -5, 1, 0, -2, 4, -4, 1, -1, -4, 3, 4, -1, -1, -3 };
        int[][] ans1 = threeSum(A1);
        print2D(ans1);
        // expected answer -> [-5 0 5 ] [-5 1 4 ] [-4 -1 5 ] [-4 0 4 ] [-4 1 3 ] [-3 -2
        // 5 ] [-3 -1 4 ] [-3 0 3 ] [-2 -1 3 ] [-2 1 1 ] [-1 0 1 ] [0 0 0 ]

        int[] A2 = { -1, 0, 1, 2, -1, 4 };
        int[][] ans2 = threeSum(A2); // expected output [ [-1,0,1], [-1,-1,2] ]
        print2D(ans2);

    }

}
