/**
 * Using single pass of binary search
 * 1) To find element K
 * 
 * TC: O(logN)
 * SC: O(1)
 */
public class q2_RotatedSortedArraySearch_approach2 {

    public static int searchKInRotatedSortedArray(int[] A, int K) {

        int N = A.length;
        int answer = -1;

        // initialize search space
        int l = 0;
        int r = N - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (A[mid] == K) {
                // found the answer
                return mid;
            } else if (A[0] < A[mid]) {
                // we are in left subArray now
                // now check if K lies within A[0] to A[mid]
                if (A[0] <= K && K < A[mid]) {
                    // if K lies within range A[0] to A[mid], ignore right part of mid
                    r = mid - 1;
                } else {
                    // ignore left part of mid
                    l = mid + 1;
                }
            } else {
                // we are in right subArray now
                // now check if K lies within A[mid] to A[N-1]
                if (A[mid] < K && K <= A[N - 1]) {
                    // if K lies within range A[mid] to A[N-1], ignore left part of mid
                    l = mid + 1;
                } else {
                    // ignore right part of mid
                    r = mid - 1;
                }
            }
        }

        // if K is not found, return -1
        return answer;
    }

    public static void main(String[] args) {
        int[] input1 = { 4, 5, 6, 7, 0, 1, 2, 3 };
        int out = searchKInRotatedSortedArray(input1, 4);
        System.out.println("answer -> " + out);
        int[] input2 = { 1, 2, 3 };
        out = searchKInRotatedSortedArray(input2, 2);
        System.out.println("answer -> " + out);
        int[] input3 = { 24, 25, 34, 45, 46, 10, 15, 17 };
        out = searchKInRotatedSortedArray(input3, 45);
        System.out.println("answer -> " + out);
        int[] input4 = { 101, 103, 106, 109, 158, 164, 182, 187, 202, 205, 2, 3, 32, 57, 69, 74, 81, 99, 100 };
        out = searchKInRotatedSortedArray(input4, 202);
        System.out.println("answer -> " + out);
        int[] input5 = { 180, 181, 182, 183, 184, 187, 188, 189, 191, 192, 193, 194, 195, 196, 201, 202, 203, 204, 3, 4,
                5, 6, 7, 8, 9, 10, 14, 16, 17, 18, 19, 23, 26, 27, 28, 29, 32, 33, 36, 37, 38, 39, 41, 42, 43, 45, 48,
                51, 52, 53, 54, 56, 62, 63, 64, 67, 69, 72, 73, 75, 77, 78, 79, 83, 85, 87, 90, 91, 92, 93, 96, 98, 99,
                101, 102, 104, 105, 106, 107, 108, 109, 111, 113, 115, 116, 118, 119, 120, 122, 123, 124, 126, 127, 129,
                130, 135, 137, 138, 139, 143, 144, 145, 147, 149, 152, 155, 156, 160, 162, 163, 164, 166, 168, 169, 170,
                171, 172, 173, 174, 175, 176, 177 };
        out = searchKInRotatedSortedArray(input5, 42);
        System.out.println("answer -> " + out);
    }
}
