import java.util.ArrayList;
import java.util.List;

/* Given array of integers A, Print/ Return all the subsets/subsequences with sum=K */

public class class_q3_print_subsets_with_sum_K {

    static List<List<Integer>> subsetList;

    public static int solve(int[] A, int K) {

        subsetList = new ArrayList<List<Integer>>();
        int N = A.length;
        List<Integer> list = new ArrayList<Integer>();
        return countSubsets(0, N, A, list, K, 0);

    }

    private static int countSubsets(int i, int n, int[] arr, List<Integer> list, int k, int sum) {

        // base condition, return count only when we reach leaf node
        if (i == n) {
            if (sum == k) {
                subsetList.add(list);
                printList(list);
                return 1;
            }
            return 0;
        }

        // every number in array have 2 options, either to come in subset or not come in
        // subset

        // arr[i] is considered in subset => sum
        sum = sum + arr[i];
        // add element into current list
        list.add(arr[i]);
        int x = countSubsets(i + 1, n, arr, list, k, sum);

        // arr[i] is not considered in subset => sum
        sum = sum - arr[i];
        // pop last element current list
        list.remove(list.size() - 1);
        int y = countSubsets(i + 1, n, arr, list, k, sum);

        // return count from left tree and right tree
        return x + y;
    }

    private static void printList(List<Integer> list) {

        StringBuilder sb = new StringBuilder();
        if (list.size() > 0) {
            sb.append("{");
        } else {
            sb.append("{ ");
        }
        for (Integer item : list) {
            sb.append(" " + item + ",");
        }
        sb.replace(sb.length() - 1, sb.length(), " ");
        sb.append("}");
        System.out.print("\n" + sb.toString());
    }

    public static void main(String[] args) {

        // test case 1
        int[] A = new int[] { 5, -2, 9 };
        int K = 7;
        System.out.println("\ncount: " + solve(A, K)); // 1

        // test case 2
        A = new int[] { 10, 2, 8 };
        K = 10;
        System.out.println("\ncount: " + solve(A, K)); // 2

        // test case 3
        A = new int[] { 1, 4, 3, 2, 8, 5, -4 };
        K = 6;
        System.out.println("\ncount: " + solve(A, K)); // 7
    }

}
