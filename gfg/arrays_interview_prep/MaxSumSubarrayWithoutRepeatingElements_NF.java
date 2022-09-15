package arrays_interview_prep;

import java.util.HashSet;
import java.util.Set;

/* Largest Sum Contiguous Subarray having unique elements */
/* https://www.geeksforgeeks.org/largest-sum-contiguous-subarray-having-unique-elements/ */
public class MaxSumSubarrayWithoutRepeatingElements_NF {
    public static void main(String[] args) {
        MaxSumSubarrayWithoutRepeatingElements_NF obj = new MaxSumSubarrayWithoutRepeatingElements_NF();
        System.out.println(obj.solve(new int[]{1, 2, 3, 3, 4, 5, 2, 1})); // 15
        System.out.println(obj.solve(new int[]{2, 3, 1, 5})); // 11
        System.out.println(obj.solve(new int[]{4, 2, 4, 5, 6})); // 17
    }

    private int solve(int[] nums) {

        int n = nums.length;
        Set<Integer> set = new HashSet<>();

        int maxSum = 0;
        int sum = 0;
        int start = 0;
        for (int end = 0; end < n; end++) {
            int curr = nums[end];
            if (set.contains(curr)) {
                while (set.contains(curr)) {
                    int oldEle = nums[start++];
                    set.remove(oldEle);
                    sum -= oldEle;
                }
                set.add(nums[start]);
            } else {
                set.add(curr);
            }
            sum += curr;
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }
}
