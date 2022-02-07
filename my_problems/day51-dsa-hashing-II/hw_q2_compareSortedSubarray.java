import java.util.HashMap;
import java.util.Map;

/**
 * Accepted solution
 */
public class hw_q2_compareSortedSubarray {

    public static int randomWithRange(int min, int max) {
        int range = (max - min) + 1;
        return (int) (Math.random() * range) + min;
    }

    public static int[] solve(int[] A, int[][] B) {

        // Idea: Generate random hash for each element in Array A
        // as [5,2,8] and [6,1,1] sum is equal but segments are not same
        // this is the reason, we are generating random hash values
        // Generate prefix sum for array A with randomHash values -> this is required as
        // only prefix sum with values can give false result
        // not compare sum of 2 segments using constant time

        int[] output = new int[B.length];

        // Generate random hash
        Map<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < A.length; i++) {
            if (!hashMap.containsKey(A[i])) {
                int randomHash = randomWithRange(1, Integer.MAX_VALUE);
                hashMap.put(A[i], randomHash);
            }
        }

        // Generate prefix sum array with random hash
        long[] prefix = new long[A.length];
        prefix[0] = hashMap.get(A[0]);
        for (int i = 1; i < A.length; i++) {
            prefix[i] = prefix[i - 1] + hashMap.get(A[i]);
        }

        // for ech query check the sum of 2 segments with constant time
        for (int i = 0; i < B.length; i++) {

            int l1 = B[i][0];
            int r1 = B[i][1];
            int l2 = B[i][2];
            int r2 = B[i][3];

            long sum1 = 0;
            long sum2 = 0;

            if (l1 == 0) {
                sum1 = prefix[r1];
            } else {
                sum1 = prefix[r1] - prefix[l1 - 1];
            }

            if (l2 == 0) {
                sum2 = prefix[r2];
            } else {
                sum2 = prefix[r2] - prefix[l2 - 1];
            }

            if (sum1 == sum2) {
                output[i] = 1;
            } else {
                output[i] = 0;
            }
        }
        for (int i = 0; i < output.length; i++) {
            System.out.println(output[i]);
        }
        return output;
    }

    public static void main(String[] args) {
        // test case 1
        int[] A1 = { 1, 7, 11, 8, 11, 7, 1 };
        int[][] B1 = new int[][] { { 0, 2, 4, 6 } };
        solve(A1, B1);

        // test case 2
        int[] A2 = { 1, 3, 2 };
        int[][] B2 = new int[][] { { 0, 1, 1, 2 } };
        solve(A2, B2);

        // test case 3
        int[] A3 = { 0, 100000 };
        int[][] B3 = new int[][] { { 0, 0, 0, 0 }, { 1, 1, 1, 1 }, { 0, 1, 0, 1 } };
        solve(A3, B3); // expected output [1,1,1]

        // test case 4
        int[] A4 = { 100000, 100000, 100000, 100000, 100000 };
        int[][] B4 = new int[][] { { 0, 3, 1, 4 }, { 0, 1, 2, 3 }, { 4, 4, 1, 1 }, { 1, 3, 0, 0 }, { 2, 4, 1, 1 } };
        solve(A4, B4); // expected output [1, 1, 1, 0, 0 ]

    }
}
