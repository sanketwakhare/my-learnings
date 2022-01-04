/**
 * Given a sorted array , find floor of K
 * Floor of K ~ greatest element <=K
 * 
 * Divide and conquer
 * TC: O(logN)
 */
public class class_q2_FindFloorOfK {
    public static int floorOfK(int[] A, int K) {

        // initialize l and r index values
        int l = 0;
        int r = A.length - 1;

        int floorValue = Integer.MIN_VALUE;

        // iterate while there is search space available
        while (l <= r) {
            // find mid index
            int mid = l + (r - l) / 2;
            if (A[mid] == K) {
                // return A[mid] if element K is found
                return A[mid];
            } else if (A[mid] > K) {
                // ignore right part as floor value can not be greater than K
                // search in left part
                r = mid - 1;
            } else {
                // search in right part
                // update answer as A[mid] can be the answer
                floorValue = A[mid];
                l = mid + 1;
            }
        }
        // return floorValue
        return floorValue;
    }

    public static void main(String[] args) {
        int[] input1 = { 3, 6, 9, 12, 14, 19, 20, 23, 25, 27 };
        int out = floorOfK(input1, 12);
        System.out.println(out);
        int[] input2 = { -5, 2, 3, 6, 9, 10, 11, 14, 18 };
        out = floorOfK(input2, 5);
        System.out.println(out);
        int[] input3 = { 10, 15, 17, 24, 25, 34, 45, 46 };
        out = floorOfK(input3, 4);
        System.out.println(out);
        int[] input4 = { 10, 15, 17, 24, 25, 34, 45, 46 };
        out = floorOfK(input4, 22);
        System.out.println(out);
    }
}
