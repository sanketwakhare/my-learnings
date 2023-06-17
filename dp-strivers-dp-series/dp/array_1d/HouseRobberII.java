package dp.array_1d;

/**
 * House Robber II
 * <p>
 * <a href="https://leetcode.com/problems/house-robber-ii/">House Robber II</a>
 * <a href="https://www.codingninjas.com/codestudio/problems/house-robber_839733">House Robber II Code Studio</a>
 */
public class HouseRobberII {

    public static void main(String[] args) {
        HouseRobberII t1 = new HouseRobberII();
        {
            // test case 1
            int[] input = new int[]{2, 3, 2};
            System.out.println(t1.rob(input)); // 3
        }
        {
            // test case 2
            int[] input = new int[]{1, 2, 3, 1};
            System.out.println(t1.rob(input)); // 4
        }
        {
            // test case 3
            int[] input = new int[]{5};
            System.out.println(t1.rob(input)); // 5
        }
        {
            // test case 4
            int[] input = new int[]{1, 2, 1, 1};
            System.out.println(t1.rob(input)); // 3
        }
        {
            // test case 5
            int[] input = new int[]{13, 24, 34, 47, 56, 61, 73, 84, 99};
            System.out.println(t1.rob(input)); // 262
        }
    }

    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        // create 2 temp array by excluding first or last element each and apply MaxSumNonAdjacentElements solution
        int[] t1 = new int[n - 1];
        int[] t2 = new int[n - 1];
        for (int i = 0; i < n; i++) {
            if (i != 0) t1[i - 1] = nums[i];
            if (i != n - 1) t2[i] = nums[i];
        }
        return Math.max(maxSum_4(t1), maxSum_4(t2));
    }

    private int maxSum_4(int[] input) {

        int n = input.length;
        if (n == 0) return 0;
        int prev2 = 0;
        int prev1 = input[0];

        for (int index = 2; index <= n; index++) {
            int pick = input[index - 1] + prev2;
            int dontPick = prev1;
            int curr = Math.max(pick, dontPick);
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }
}
