/* Rain Water Trapped */

/* TC: O(N)
SC: O(N) */
public class q2_Rain_Water_Trapped_space_optimized {

    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int trap(final int[] A) {

        // initialization
        int LMax = 0;
        int RMax = 0;
        int total = 0;
        int i = 0;
        int j = A.length - 1;

        while (i < j) {
            // water accumulated at ith building
            int iWater = 0;
            // minimum height out of 2
            int minHeight = Math.min(LMax, RMax);
            if (A[i] < A[j]) {
                // if ith element < jth element, calculate the water accumulated at ith level
                if (minHeight > A[i]) {
                    iWater = minHeight - A[i];
                    total += iWater;
                }
                // recalculate LMax and RMax
                LMax = Math.max(A[i], LMax);
                RMax = Math.max(A[j], RMax);
                // move right
                i++;
            } else {
                // if jth element < ith element, calculate the water accumulated at ith level
                if (minHeight > A[j]) {
                    iWater = minHeight - A[j];
                    total += iWater;
                }
                // recalculate LMax and RMax
                RMax = Math.max(A[j], RMax);
                LMax = Math.max(A[i], LMax);
                // move left
                j--;
            }
        }
        System.out.println(total);
        return total;
    }

    public static void main(String[] args) {

        q2_Rain_Water_Trapped_space_optimized t1 = new q2_Rain_Water_Trapped_space_optimized();

        t1.trap(new int[] { 0, 1, 0, 2 }); // 1
        t1.trap(new int[] { 1, 2 }); // 0
        t1.trap(new int[] { 4, 2, 5, 7, 4, 2, 3, 6, 8, 2, 3 }); // 16

    }

}
