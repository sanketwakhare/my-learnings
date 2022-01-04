/**
 * Given unsorted array of size N, find any local minima
 * 
 * TC: O(logN) using binary search
 * We are able to apply Binary Search for this problem because we can reduce
 * searching on some condition
 */

public class class_q5_localMinima {
    public static int localMinima(int[] A) {

        // initialize search space - start and end indexes
        int l = 0;
        int r = A.length - 1;

        // edge cases
        if (r == 0) {
            // if only single element is present in array
            return A[r];
        }
        if (A[l] < A[l + 1]) {
            // if first element is larger than second element
            return A[l];
        }
        if (A[r] < A[r - 1]) {
            // if last element is larger than second last element
            return A[r];
        }

        // binary search
        while (l <= r) {
            // find mid
            int mid = l + (r - l) / 2;

            if (A[mid] < A[mid - 1] && A[mid] < A[mid + 1]) {
                // A[mid] is one of the minima
                return A[mid];
            } else if (A[mid + 1] < A[mid]) {
                // go to right side, as there would be at least one minima on right
                l = mid + 1;
            } else {
                // go to left side as there is at least one minima on left
                r = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] input1 = { 1, 2, 3, 4, 5 };
        int out = localMinima(input1);
        System.out.println(out);
        int[] input2 = { 110, 75, 34, 15, 17, 100, 11, 201 };
        out = localMinima(input2);
        System.out.println(out);
        int[] input3 = { 12, 8, 3, 76, 4, 10, 15 };
        out = localMinima(input3);
        System.out.println(out);
        int[] input4 = { 12, 8, 5, 4, 3, 2 };
        out = localMinima(input4);
        System.out.println(out);

    }
}
