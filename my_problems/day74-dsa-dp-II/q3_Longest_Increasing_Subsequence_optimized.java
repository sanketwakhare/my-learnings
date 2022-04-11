import java.util.ArrayList;
import java.util.List;

public class q3_Longest_Increasing_Subsequence_optimized {

    /**
     * TC: O(N * logN)
     */
    public int lis(int[] A) {

        List<Integer> list = new ArrayList<Integer>();
        list.add(A[0]);

        for (int i = 1; i < A.length; i++) {
            if (list.get(list.size() - 1) < A[i]) {
                // if new elements is > last element from list, insert the new element
                list.add(A[i]);
            } else {
                // find ceil of the current element and replace it with current element
                int ind = ceilOfK_binarySearch(list, 0, list.size() - 1, A[i]);
                list.set(ind, A[i]);
            }
        }
        return list.size();
    }

    /**
     * Binary Search- find ceil of K
     * TC: o(logN)
     */
    public int ceilOfK_binarySearch(List<Integer> list, int start, int end, int k) {

        int ans = end;
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (list.get(mid) == k) {
                return mid;
            } else if (list.get(mid) < k) {
                start = mid + 1;
            } else {
                ans = Math.min(ans, mid);
                end = mid - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {

        q3_Longest_Increasing_Subsequence_optimized t1 = new q3_Longest_Increasing_Subsequence_optimized();
        int[] A;

        {
            A = new int[] { 1, 2, 1, 5 };
            System.out.println(t1.lis(A)); // 3
        }
        {
            A = new int[] { 0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15 };
            System.out.println(t1.lis(A)); // 6
        }
        {
            A = new int[] { 69, 54, 19, 51, 16, 54, 64, 89, 72, 40, 31, 43, 1, 11, 82, 65, 75, 67, 25, 98, 31, 77, 55,
                    88, 85, 76, 35, 101, 44, 74, 29, 94, 72, 39, 20, 24, 23, 66, 16, 95, 5, 17, 54, 89, 93, 10, 7, 88,
                    68, 10, 11, 22, 25, 50, 18, 59, 79, 87, 7, 49, 26, 96, 27, 19, 67, 35, 50, 10, 6, 48, 38, 28, 66,
                    94, 60, 27, 76, 4, 43, 66, 14, 8, 78, 72, 21, 56, 34, 90, 89 };
            System.out.println(t1.lis(A)); // 15
        }
    }
}
