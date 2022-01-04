/**
 * Given a sorted array , find ceil value of K
 * Floor of K ~ smallest element >=K
 * 
 * Divide and conquer
 * TC: O(logN)
 */
public class class_q3_FindCeilOfK {
    public static int ceilOfK(int[] A, int K) {

        // initialize l and r index values
        int l = 0;
        int r = A.length - 1;

        int ceilValue = Integer.MAX_VALUE;

        // iterate while there is search space available
        while (l <= r) {
            // find mid index
            int mid = l + (r - l) / 2;
            if (A[mid] == K) {
                // return A[mid] if element K is found
                return A[mid];
            } else if (A[mid] > K) {
                // update answer as A[mid] can be the answer
                ceilValue = A[mid];
                // search in left part
                r = mid - 1;
            } else {
                // ignore left part as ceil value can not be smaller than K
                // search in right part
                l = mid + 1;
            }
        }
        // return floorValue
        return ceilValue;
    }

    public static void main(String[] args) {
        int[] input1 = { 3, 6, 9, 12, 14, 19, 20, 23, 25, 27 };
        int out = ceilOfK(input1, 12);
        System.out.println(out);
        int[] input2 = { -5, 2, 3, 6, 9, 10, 11, 14, 18 };
        out = ceilOfK(input2, 5);
        System.out.println(out);
        int[] input3 = { 10, 15, 17, 24, 25, 34, 45, 46 };
        out = ceilOfK(input3, 4);
        System.out.println(out);
        int[] input4 = { 10, 15, 17, 24, 25, 34, 45, 46 };
        out = ceilOfK(input4, 22);
        System.out.println(out);
        int[] input5 = { 10, 15, 17, 24, 25, 34, 45, 46 };
        out = ceilOfK(input5, 62);
        System.out.println(out);
    }
}
