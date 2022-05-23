import java.util.Arrays;

public class hw_q1_Minimum_Cost {
    public int solve(int[] A) {
        // step1: find total sum
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
        }
        // step2: sort the array
        Arrays.sort(A);
        // step3: find cost after each element removal and add to total cost
        int cost = 0;
        for (int i = A.length - 1; i >= 0; i--) {
            cost += sum;
            sum -= A[i];
        }
        return cost;
    }

    public static void main(String[] args) {
        hw_q1_Minimum_Cost t1 = new hw_q1_Minimum_Cost();
        int[] A;
        {
            A = new int[] { 2, 4, 1 };
            System.out.println(t1.solve(A)); // 11
        }
    }
}
