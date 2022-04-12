/* Given integer array of length N, for all B queries,
check if given subarray is non-decrementing or not 
Return boolean array where result[i] represents output for ith query
*/

public class class_q3_subarray_non_decrementing {

    public boolean[] solve(int[] A, int[][] B) {

        int[] decPoints = new int[A.length];
        int[] pf = new int[A.length];
        boolean[] result = new boolean[B.length];

        // step1: find decrement point in array
        decPoints[0] = 0;
        for (int i = 1; i < A.length; i++) {
            if (A[i] < A[i - 1]) {
                decPoints[i] = 1;
            } else {
                decPoints[i] = 0;
            }
        }

        // step2: generate prefix array using decPoints array
        pf[0] = decPoints[0];
        for (int i = 1; i < decPoints.length; i++) {
            pf[i] = pf[i - 1] + decPoints[i];
        }

        // step 3: for each query, find there exist a decrement point using prefix array
        for (int i = 0; i < B.length; i++) {
            int start = B[i][0];
            int end = B[i][1];

            if ((pf[end] - pf[start]) > 0) {
                // decrementing
                result[i] = false;
            } else {
                // non decrementing
                result[i] = true;
            }
        }

        return result;
    }

    public static void main(String[] args) {

        class_q3_subarray_non_decrementing o = new class_q3_subarray_non_decrementing();
        int[] A;

        {
            A = new int[] { 1, 3, 3, 4, 2, 8, 6, 5, 10, 10, 14, 11 };
            int[][] B = new int[][] {
                    { 4, 5 },
                    { 2, 5 },
                    { 3, 7 },
                    { 1, 3 },
                    { 8, 10 }
            };
            boolean[] result = o.solve(A, B);
            for (boolean b : result) {
                System.out.print(b + " ");
            }
        }

    }
}
