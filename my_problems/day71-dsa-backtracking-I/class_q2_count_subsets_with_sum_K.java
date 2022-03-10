/* Given array of integers A, Count no of subsets/subsequences with sum=K */

public class class_q2_count_subsets_with_sum_K {

    public static int solve(int[] A, int K) {

        int N = A.length;
        return countSubsets(0, N, A, K, 0);

    }

    private static int countSubsets(int i, int n, int[] arr, int k, int sum) {

        // base condition, return count only when we reach leaf node
        if (i == n) {
            if (sum == k) {
                return 1;
            }
            return 0;
        }

        // every number in array have 2 options, either to come in subset or not come in
        // subset

        // A[i] is considered in subset => sum
        sum = sum + arr[i];
        int x = countSubsets(i + 1, n, arr, k, sum);
        // A[i] is not considered in subset => sum
        sum = sum - arr[i];
        int y = countSubsets(i + 1, n, arr, k, sum);

        // return count from left tree and right tree
        return x + y;
    }

    public static void main(String[] args) {

        // test case 1
        int[] A = new int[] { 5, -2, 9 };
        int K = 7;
        System.out.println("count: " + solve(A, K)); // 1

        // test case 2
        A = new int[] { 10, 2, 8 };
        K = 10;
        System.out.println("count: " + solve(A, K)); // 2

        // test case 3
        A = new int[] { 1, 4, 3, 2, 8, 5, -4 };
        K = 6;
        System.out.println("count: " + solve(A, K)); // 7
    }

}
