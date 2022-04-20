/* Closest MinMax */

public class q3_Closest_min_max {

    public int solve(int[] A) {

        // initialize min and max index with -1
        int min_e = -1;
        int max_e = -1;
        // initialize answer with N as max length would be N
        int answer = A.length;

        // find min and max element from array
        int min = A[0];
        int max = A[0];
        for (int i = 1; i < A.length; i++) {
            min = Math.min(A[i], min);
            max = Math.max(A[i], max);
        }

        for (int i = 0; i < A.length; i++) {
            // if we find min, update min index
            if (A[i] == min) {
                min_e = i;
            }
            // if we find max, update max index
            if (A[i] == max) {
                max_e = i;
            }
            // update only if we have both the min and max indices > -1
            if (min_e > -1 && max_e > -1) {
                answer = Math.min(answer, Math.abs(min_e - max_e) + 1);
            }
        }
        return answer;

    }

    public static void main(String[] args) {

        q3_Closest_min_max t1 = new q3_Closest_min_max();
        int[] A;
        {
            A = new int[] { 1, 3 };
            System.out.println(t1.solve(A));
        }
        {
            A = new int[] { 1, 3, 4, 5, 6, 3, 2, 1, 6, 2, 1 };
            System.out.println(t1.solve(A));
        }
        {
            A = new int[] { 377, 448, 173, 307, 108 };
            System.out.println(t1.solve(A));
        }
        {
            A = new int[] { 834, 563, 606, 221, 165 };
            System.out.println(t1.solve(A));
        }

    }

}
