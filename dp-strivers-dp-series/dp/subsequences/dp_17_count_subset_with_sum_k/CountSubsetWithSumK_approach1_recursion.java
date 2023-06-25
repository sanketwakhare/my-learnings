package dp.subsequences.dp_17_count_subset_with_sum_k;

/**
 * Count the number of subsets with a sum K.
 * <p>
 * <a href="https://www.codingninjas.com/codestudio/problems/number-of-subsets_3952532">Count the number of subsets with a sum K.</a>
 */
public class CountSubsetWithSumK_approach1_recursion {

    // TC: O(2^n) & SC: O(n) recursive stack space
    public static void main(String[] args) {
        // test 1
        int k1 = 5;
        int[] arr1 = new int[]{4, 3, 2, 1};
        System.out.println(new CountSubsetWithSumK_approach1_recursion().findWays(arr1, k1)); // 2

        // test 2
        int k2 = 4;
        int[] arr2 = new int[]{2, 5, 1, 6, 7};
        System.out.println(new CountSubsetWithSumK_approach1_recursion().findWays(arr2, k2)); // 0

        // test 3
        int k3 = 5;
        int[] arr3 = new int[]{1, 4, 4, 5};
        System.out.println(new CountSubsetWithSumK_approach1_recursion().findWays(arr3, k3)); // 3

        // test 4
        int k4 = 53;
        int[] arr4 = new int[]{7, 7, 7, 9, 1, 4, 4, 7, 8, 2, 10, 3, 9, 8, 1, 9, 7, 1, 2, 8, 7, 3, 5, 3, 9, 8, 9, 7, 8, 3, 2, 4, 2, 6, 10, 1, 6, 4, 10, 5, 3, 7, 1, 6, 5, 6, 1, 8, 6, 7, 5, 1, 2, 3, 5, 2, 9, 10, 3, 1, 2, 10, 5, 7, 10, 2, 7, 9, 3, 4, 2, 8, 10, 5};
        System.out.println(new CountSubsetWithSumK_approach1_recursion().findWays(arr4, k4)); // 728567579 - will give TLE
    }

    public int findWays(int num[], int tar) {
        int n = num.length;
        return f(n - 1, tar, num);
    }

    public int f(int index, int target, int[] arr) {

        if (target == 0) return 1;
        if (index == 0) {
            return arr[0] == target ? 1 : 0;
        }
        int notPick = f(index - 1, target, arr);
        int pick = 0;
        if (target >= arr[index]) {
            pick = f(index - 1, target - arr[index], arr);
        }
        return pick + notPick;
    }
}
