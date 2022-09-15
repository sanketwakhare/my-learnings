package arrays_interview_prep;
/* Kadane's Algorithm */
/* https://practice.geeksforgeeks.org/problems/kadanes-algorithm-1587115620/1 */
public class KadenceAlgo {

    public static void main(String[] args) {
        KadenceAlgo obj = new KadenceAlgo();
        {
            int[] nums = new int[]{1, 2, 3, -2, 5};
            System.out.println(obj.maxSubarraySum(nums, nums.length)); // 9
        }
        {
            int[] nums = new int[]{-1, -2, -3, -4};
            System.out.println(obj.maxSubarraySum(nums, nums.length)); // -1
        }
        {
            int[] nums = new int[]{-2, -3, -5, 4, -1, 2, 2, -2, -1};
            System.out.println(obj.maxSubarraySum(nums, nums.length)); // 7
        }
        {
            int[] nums = new int[]{5, 3, 4, 7, 6, 1, 2};
            System.out.println(obj.maxSubarraySum(nums, nums.length)); // 28
        }
    }

    // arr: input array
    // n: size of array
    //Function to find the sum of contiguous subarray with maximum sum.
    long maxSubarraySum(int[] arr, int n) {

        // Your code here
        int max = Integer.MIN_VALUE;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            int curr = arr[i];
            sum += curr;
            max = Math.max(max, sum);
            if (sum < 0) {
                sum = 0;
            }
        }
        return max;
    }


}
