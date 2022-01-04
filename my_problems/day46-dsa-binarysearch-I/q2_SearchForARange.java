public class q2_SearchForARange {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public static int[] searchRange(final int[] A, int K) {

        int[] output = new int[2];

        // initialize start and end index - search space
        int l = 0;
        int r = A.length - 1;

        // find first occurrence of K
        int firstOccIndex = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (A[mid] == K) {
                // update answer and search on left for first occurrence if available
                firstOccIndex = mid;
                r = mid - 1;
            } else if (A[mid] < K) {
                // search on right side as all the elements to left will be smaller than K
                l = mid + 1;
            } else {
                // search on left side as all the elements to right will be larger than K
                r = mid - 1;
            }
        }
        output[0] = firstOccIndex;

        // re initialize start and end index - search space
        l = 0;
        r = A.length - 1;
        // find last occurrence of K
        int lastOccIndex = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (A[mid] == K) {
                lastOccIndex = mid;
                l = mid + 1;
            } else if (A[mid] < K) {
                // search on right side
                l = mid + 1;
            } else {
                // search on left side
                r = mid - 1;
            }
        }
        output[1] = lastOccIndex;

        return output;
    }

    public static void main(String[] args) {
        int[] input1 = { 5, 7, 7, 8, 8, 10 };
        int[] out = searchRange(input1, 8);
        System.out.println(out[0] + " " + out[1]);
        int[] input2 = { 5, 17, 100, 111 };
        out = searchRange(input2, 3);
        System.out.println(out[0] + " " + out[1]);
        int[] input3 = { 10, 15, 15, 15, 15, 17, 24, 24, 25, 25, 25, 25, 34, 34, 45, 45 };
        out = searchRange(input3, 25);
        System.out.println(out[0] + " " + out[1]);
        out = searchRange(input3, 17);
        System.out.println(out[0] + " " + out[1]);
    }
}
