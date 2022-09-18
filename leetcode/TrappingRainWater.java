/* Trapping Rain Water */
/* https://leetcode.com/problems/trapping-rain-water/ */
public class TrappingRainWater {

    public static void main(String[] args) {
        TrappingRainWater obj = new TrappingRainWater();
        {
            int[] height = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
            System.out.println(obj.trap_using_prefixLeft_and_prefixRight(height));
            System.out.println(obj.trap_using_prefixRight_only(height));
            System.out.println(obj.trap(height));
        }
        {
            int[] height = new int[]{4, 2, 0, 3, 2, 5};
            System.out.println(obj.trap_using_prefixLeft_and_prefixRight(height));
            System.out.println(obj.trap_using_prefixRight_only(height));
            System.out.println(obj.trap(height));
        }
    }

    // TC: O(N)
    // SC: O(1)
    public int trap(int[] height) {

        int prevMax = height[0];
        int nextMax = height[height.length - 1];

        int start = 0;
        int end = height.length - 1;

        int water = 0;
        while (start < end) {
            if (height[start] <= height[end]) {
                water += Math.max(Math.min(prevMax, nextMax) - height[start], 0);
                start++;
            } else {
                water += Math.max(Math.min(prevMax, nextMax) - height[end], 0);
                end--;
            }
            prevMax = Math.max(prevMax, height[start]);
            nextMax = Math.max(nextMax, height[end]);
        }
        return water;
    }

    // Iterations - 3N
    // TC: O(N)
    // SC: O(N)
    public int trap_using_prefixLeft_and_prefixRight(int[] height) {

        int n = height.length;

        int[] lMax = new int[n];
        int[] rMax = new int[n];

        lMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            lMax[i] = Math.max(height[i], lMax[i - 1]);
        }

        rMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rMax[i] = Math.max(height[i], rMax[i + 1]);
        }

        int water = 0;
        for (int i = 1; i < n - 1; i++) {
            water += Math.max(Math.min(lMax[i - 1], rMax[i + 1]) - height[i], 0);
        }
        return water;
    }

    // Iterations - 2N
    // TC: O(N)
    // SC: O(N)
    public int trap_using_prefixRight_only(int[] height) {

        int n = height.length;

        int[] rMax = new int[n];

        rMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rMax[i] = Math.max(height[i], rMax[i + 1]);
        }

        int water = 0;
        int lMax = height[0];
        for (int i = 1; i < n - 1; i++) {
            water += Math.max(Math.min(lMax, rMax[i + 1]) - height[i], 0);
            lMax = Math.max(lMax, height[i]);
        }
        return water;
    }
}
