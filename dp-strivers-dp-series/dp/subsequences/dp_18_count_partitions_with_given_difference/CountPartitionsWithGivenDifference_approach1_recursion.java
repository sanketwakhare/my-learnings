package dp.subsequences.dp_18_count_partitions_with_given_difference;

/**
 * Count Partitions With Given Difference
 * <p>
 * <a href="https://www.codingninjas.com/studio/problems/partitions-with-given-difference_3751628">Count Partitions With Given Difference</a>
 */
public class CountPartitionsWithGivenDifference_approach1_recursion {

    // TC: O(2^n) & SC: O(n) recursive stack space
    public static void main(String[] args) {
        // test 1
        int n1 = 4;
        int d1 = 3;
        int[] arr1 = new int[]{5, 2, 6, 4};
        System.out.println(new CountPartitionsWithGivenDifference_approach1_recursion().countPartitions(n1, d1, arr1)); // 1

        // test 2
        int n2 = 4;
        int d2 = 0;
        int[] arr2 = new int[]{1, 1, 1, 1};
        System.out.println(new CountPartitionsWithGivenDifference_approach1_recursion().countPartitions(n2, d2, arr2)); // 6

        // test 3
        int n3 = 6;
        int d3 = 17;
        int[] arr3 = new int[]{1, 0, 8, 5, 1, 4};
        System.out.println(new CountPartitionsWithGivenDifference_approach1_recursion().countPartitions(n3, d3, arr3)); // 4
    }

    public int findWays(int[] num, int tar) {
        int n = num.length;
        return f(n - 1, tar, num);
    }

    public int f(int index, int target, int[] arr) {
        if (index == 0) {
            // case for 0
            if (target == 0 && arr[0] == 0)
                return 2;
            // case when target is 0 OR array element at index 0 is equal to target
            if (target == 0 || target == arr[0])
                return 1;
            // otherwise return 0
            return 0;
        }
        int notPick = f(index - 1, target, arr);
        int pick = 0;
        if (target >= arr[index]) {
            pick = f(index - 1, target - arr[index], arr);
        }
        return pick + notPick;
    }

    public int countPartitions(int n, int d, int[] arr) {
        // Write your code here.
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }
        int target = (sum - d) / 2;

        // base cases
        if ((sum + d) % 2 != 0) return 0;
        if (target < 0) return 0;

        // dp 1-7
        return findWays(arr, target);
    }
}
