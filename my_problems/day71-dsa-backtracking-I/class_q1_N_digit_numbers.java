/* Find/Print all N digit numbers which can be formed with given array elements */
public class class_q1_N_digit_numbers {

    public static void printAllNDigitNumbers(int[] A, int N) {

        int arr[] = new int[N];
        printAll(0, N, arr, A);
    }

    /**
     * Recursive relation: T(N) = T(N-1) * K
     * TC: O(2^n)
     * SC: recursive stack O(N)
     * 
     */
    private static void printAll(int i, int n, int[] arr, int[] A) {

        // base condition
        if (i == n) {
            System.out.println();
            for (int j = 0; j < n; j++) {
                System.out.print(arr[j]);
            }
            return;
        }

        // for all k possibilities of digit, repeat teh function call
        for (int k = 0; k < A.length; k++) {
            arr[i] = A[k];
            printAll(i + 1, n, arr, A);
        }

        // for only 2 possibilities when A= {1,2}
        // arr[i] = 1;
        // printAll(i + 1, n, arr, A);
        // arr[i] = 2;
        // printAll(i + 1, n, arr, A);

    }

    public static void main(String[] args) {

        // test case 1
        int[] A = new int[] { 1, 2 };
        int N = 3;
        printAllNDigitNumbers(A, N);

        // test case 2
        A = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        N = 2;
        printAllNDigitNumbers(A, N);
    }
}