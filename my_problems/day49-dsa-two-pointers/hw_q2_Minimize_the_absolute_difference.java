/* Minimize the absolute difference */

/* Given three sorted arrays A, B and Cof not necessarily same sizes.

Calculate the minimum absolute difference between the maximum and minimum number from the triplet a, b, c such that a, b, c belongs arrays A, B, C respectively. i.e. minimize | max(a,b,c) - min(a,b,c) |.

Example :

Input:

A : [ 1, 4, 5, 8, 10 ]
B : [ 6, 9, 15 ]
C : [ 2, 3, 6, 6 ]
Output:

1
Explanation: We get the minimum difference for a=5, b=6, c=6 as | max(a,b,c) - min(a,b,c) | = |6-5| = 1. */

public class hw_q2_Minimize_the_absolute_difference {
    public int solve(int[] A, int[] B, int[] C) {

        // Idea:
        // take 3 pointers for a, b and c resp
        // calculate the diff between max- min for each triplet (a,b,c)
        // increase the pointer of min number out of 3 and repeat until we reach to end
        // of any of the array

        int a = 0, b = 0, c = 0;
        // find abd diff for first 3 numners
        int min = Math.min(Math.min(A[a], B[b]), C[c]);
        int max = Math.max(Math.max(A[a], B[b]), C[c]);
        int minDiff = Math.abs(max - min);

        while (a < A.length && b < B.length && c < C.length) {

            // find min and max out of 3
            min = Math.min(Math.min(A[a], B[b]), C[c]);
            max = Math.max(Math.max(A[a], B[b]), C[c]);

            // update better answer if any
            int currDiff = Math.abs(max - min);
            if (currDiff < minDiff) {
                minDiff = currDiff;
            }
            // increase the pointer of min out of 3
            if (min == A[a])
                a++;
            if (min == B[b])
                b++;
            if (min == C[c])
                c++;
        }
        return minDiff;
    }

    public static void main(String[] args) {
        hw_q2_Minimize_the_absolute_difference t1 = new hw_q2_Minimize_the_absolute_difference();
        int[] A, B, C;
        {
            A = new int[] { 1, 4, 5, 8, 10 };
            B = new int[] { 6, 9, 15 };
            C = new int[] { 2, 3, 6, 6 };
            System.out.println(t1.solve(A, B, C)); // 1
        }
        {
            A = new int[] { 11, 14, 25, 28, 20 };
            B = new int[] { 4, 19, 35 };
            C = new int[] { 1, 2, 18, 26 };
            System.out.println(t1.solve(A, B, C)); // 5
        }
    }
}
