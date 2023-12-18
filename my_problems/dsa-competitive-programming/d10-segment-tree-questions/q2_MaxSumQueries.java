/*
Max Sum Queries

Problem Description

You are given an array A of size N consisting of integers.
You have to process Q queries of two types on it:
i x, change the i-th element of A to x.
l r, find the maximum value of (A[i]+A[i+1]…A[j]) over all pairs (i,j) such that l <= i <= j <= r.


Problem Constraints
1 <= N,Q <= 105
-1000 <= A[i] <= 1000 (for all i in [1…N])
For query of the 1st type,

1 <= i <= N
-1000 <= x <= 1000
For query of the 2nd type,
1 <= l <= r <= N

Input Format
The first argument of the input is the array A.
The second argument of the input is a 2-D array B containing the description of the queries.


Output Format
You should return an array of answers to each query of the 2nd type, in the same order they were asked in the input.

Example Input
Input 1:
A: [3, -1, 2, -9, -15]
B: [
        [2,1,4],
        [1,3,7],
        [2,5,5],
        [2,1,3]
    ]
Input 2:
A: [6, -1, 9]
B:  [
        [2,1,3],
        [1,2,10],
        [2,1,3]
    ]

Example Output
Output 1:
[4, -15, 9]
Output 2:
[14, 25]

Example Explanation:

Explanation 1:
For the 1st query, the required sum is A[1] + A[2] + A[3] = 4.
After the 2nd query, array becomes [3,-1,7,-9,-15].
For the 3rd query, there is only one answer possible, -15, which is thus the answer itself.
For the 4th query, the required sum is A[1] + A[2] + A[3] = 9.

Explanation 2:
For the 1st query, the required sum is A[1] + A[2] + A[3] = 14.
After the 2nd query, array becomes [6, 10, 9].
For the 3rd query, the required sum is A[1] + A[2] + A[3] = 14.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class q2_MaxSumQueries {

    public static void main(String[] args) {
        q2_MaxSumQueries t = new q2_MaxSumQueries();
        {
            int[] A = {3, -1, 2, -9, -15};
            int[][] B = new int[][]{
                    {2, 1, 4},
                    {1, 3, 7},
                    {2, 5, 5},
                    {2, 1, 3}
            };
            System.out.println(Arrays.toString(t.solve(A, B))); // [4, -15, 9]
        }
        {
            int[] A = {6, -1, 9};
            int[][] B = new int[][]{
                    {2, 1, 3},
                    {1, 2, 10},
                    {2, 1, 3}
            };
            System.out.println(Arrays.toString(t.solve(A, B))); // [14, 25]
        }
        {
            int[] A = {-457, 381, -781, 410, -752, 86, 924, 115, 953};
            int[][] B = new int[][]{
                    {2, 2, 4}, {1, 2, -134}, {1, 9, 759}, {2, 3, 7}, {2, 3, 5}, {1, 3, -915}, {1, 1, -375}, {2, 7, 8}, {2, 2, 6}
            };
            System.out.println(Arrays.toString(t.solve(A, B))); // [410, 1010, 410, 1039, 410]
        }
    }

    /*
        int max_value = Math.max(max_value_left, max_value_right, max_suffix_left + max_prefix_right);
        int maxPrefix = Math.max(max_prefix_left, max_total + max_prefix_right);
        int maxSuffix = Math.max(max_suffix_right, total_right + max_suffix_left);
        int totalSum = total_left + total_right;
     */
    public int[] solve(int[] A, int[][] B) {
        int n = A.length;
        int[][] seg = new int[4 * n][4];
        build(0, 0, n - 1, A, seg);

        List<Integer> list = new ArrayList<>();
        for (int[] query : B) {
            int type = query[0];
            if (type == 1) {
                // update
                int index = query[1] - 1;
                int value = query[2];
                update(0, 0, n - 1, index, value, A, seg);
            } else {
                // get
                int l = query[1] - 1;
                int r = query[2] - 1;
                int[] currRes = get(0, 0, n - 1, l, r, seg);
                list.add(currRes[0]);
            }
        }
        return list.stream().mapToInt(i -> i).toArray();
    }

    private int[] calculateCurrValue(int[] left, int[] right) {
        int maxValue = Math.max(left[0], right[0]);
        maxValue = Math.max(maxValue, left[2] + right[1]);
        int maxPrefix = Math.max(left[1], left[3] + right[1]);
        int maxSuffix = Math.max(right[2], right[3] + left[2]);
        int totalSum = left[3] + right[3];
        return new int[]{maxValue, maxPrefix, maxSuffix, totalSum};
    }

    private void build(int currIndex, int start, int end, int[] A, int[][] seg) {
        if (start == end) {
            int x = A[start];
            // maxValue, maxPrefix, maxSuffix, totalSum
            seg[currIndex] = new int[]{x, x, x, x};
            return;
        }
        int mid = start + (end - start) / 2;
        int leftChildIndex = 2 * currIndex + 1;
        int rightChildIndex = 2 * currIndex + 2;

        build(leftChildIndex, start, mid, A, seg);
        build(rightChildIndex, mid + 1, end, A, seg);

        int[] left = seg[leftChildIndex];
        int[] right = seg[rightChildIndex];

        seg[currIndex] = calculateCurrValue(left, right);
    }

    private void update(int currIndex, int start, int end, int index, int value, int[] A, int[][] seg) {
        if (start == end) {
            A[index] = value;
            // maxValue, maxPrefix, maxSuffix, totalSum
            seg[currIndex] = new int[]{value, value, value, value};
            return;
        }
        int mid = start + (end - start) / 2;
        int leftChildIndex = 2 * currIndex + 1;
        int rightChildIndex = 2 * currIndex + 2;

        if (index <= mid) {
            update(leftChildIndex, start, mid, index, value, A, seg);
        } else {
            update(rightChildIndex, mid + 1, end, index, value, A, seg);
        }

        int[] left = seg[leftChildIndex];
        int[] right = seg[rightChildIndex];

        seg[currIndex] = calculateCurrValue(left, right);
    }

    private int[] get(int currIndex, int start, int end, int l, int r, int[][] seg) {
        // disjoint condition
        if (l > end || r < start) {
            int x = -1000000;
            return new int[]{x, x, x, 0};
        }
        // completely overlapping condition
        if (start >= l && end <= r) {
            return seg[currIndex];
        }
        int mid = start + (end - start) / 2;
        int leftChildIndex = 2 * currIndex + 1;
        int rightChildIndex = 2 * currIndex + 2;

        int[] left = get(leftChildIndex, start, mid, l, r, seg);
        int[] right = get(rightChildIndex, mid + 1, end, l, r, seg);

        return calculateCurrValue(left, right);
    }
}
