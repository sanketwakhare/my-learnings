import java.util.Arrays;

/* Given N array elements, find (i,j) such that |A[i] - A[j]| is minimized. and i!=j */
public class class_q4_min_pair_difference_Possible {

    public static void main(String[] args) {

        class_q4_min_pair_difference_Possible t1 = new class_q4_min_pair_difference_Possible();
        int[] A;
        {
            A = new int[] { 9, 14, 21, 7, -3, 4, 26, 10 };
            int out = t1.minDiff(A);
            System.out.println(out); // 1
        }
        {
            A = new int[] { 4, 3, -1, 3 };
            int out = t1.minDiff(A);
            System.out.println(out); // 0
        }
    }

    private int minDiff(int[] A) {
        // step1: sort the array
        Arrays.sort(A);

        int minDiff = Integer.MAX_VALUE;
        // find min diff by comparing consecutive elements
        for (int i = 1; i < A.length; i++) {
            minDiff = Math.min(minDiff, Math.abs(A[i] - A[i - 1]));
        }
        return minDiff;
    }
}
