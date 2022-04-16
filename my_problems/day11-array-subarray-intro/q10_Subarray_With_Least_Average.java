public class q10_Subarray_With_Least_Average {
    public int solve(int[] A, int B) {

        // sliding window approach
        int leastSum = 0;
        int sum = 0;
        for (int i = 0; i < B; i++) {
            sum += A[i];
        }
        leastSum = sum;
        int startInd = 0;

        for (int i = B; i < A.length; i++) {
            int eleToRemove = A[i - B];
            int eleToAdd = A[i];

            sum = sum + eleToAdd - eleToRemove;

            if (sum < leastSum) {
                startInd = i - B + 1;
                leastSum = sum;
            }
        }
        return startInd;
    }

    public static void main(String[] args) {

        q10_Subarray_With_Least_Average t1 = new q10_Subarray_With_Least_Average();
        int[] A;
        int B;
        {
            A = new int[] { 15, 7, 11, 7, 9, 8, 18, 1, 16, 18, 6, 1, 1, 4, 18 };
            B = 6;
            System.out.println(t1.solve(A, B));
        }
    }
}
