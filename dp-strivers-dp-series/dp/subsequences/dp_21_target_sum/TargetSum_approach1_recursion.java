package dp.subsequences.dp_21_target_sum;

/**
 * Target Sum
 *
 * <a href="https://www.codingninjas.com/studio/problems/target-sum_4127362">Target Sum</a>
 */
public class TargetSum_approach1_recursion {

    public static void main(String[] args) {

        // test 1
        int n1 = 5;
        int d1 = 3;
        int[] arr1 = {1, 1, 1, 1, 1};
        System.out.println(new TargetSum_approach1_recursion().targetSum(n1, d1, arr1)); // 5

        // test 2
        int n2 = 4;
        int d2 = 3;
        int[] arr2 = {1, 2, 3, 1};
        System.out.println(new TargetSum_approach1_recursion().targetSum(n2, d2, arr2)); // 2
    }

    public int targetSum(int n, int target, int[] arr) {
        return f(n -1, target, arr);
    }

    public int f(int index, int target, int[] arr) {

        if (index == 0) {
            if (target == 0 && arr[0] == 0) {
                return 2;
            }
            if (target == arr[0] || target == -arr[0]) {
                return 1;
            }
            return 0;
        }

        int neg = f(index - 1, target + arr[index], arr);
        int pos = f(index - 1, target - arr[index], arr);
        return neg + pos;
    }

}
