/*
K-th smallest in a range

Problem Description

Given an integer array A of size N.
You are also given Q queries denoted by 2D array B of size Q x 3 where B[i][0] denotes L, B[i][1] denotes R and B[i][2] denotes K.

For each query, find the Kth smallest in the range from array index L to R (both inclusive).



Problem Constraints

1 <= N, Q <= 50000
-10^9 <= A[i] <= 10^9
1 <= L <= R <= N
1 <= K <= R - L + 1


Input Format

First argument is an integer array A of size N.
Second argument is a 2D array B of size Q x 3.

Output Format
Return an integer array of size Q, denoting the output of each query.


Example Input

Input 1:

 A = [1, -2, 6, 1, 3]
 B = [
       [2, 4, 2]
       [1, 5, 4]
       [3, 3, 1]
     ]
Input 2:

 A = [23, -12, -16, 1, 9, 2]
 B = [
       [3, 6, 1]
       [1, 4, 4]
     ]

Example Output

Output 1:
 [1, 3, 6]
Output 2:
 [-16, 23]


Example Explanation

Explanation 1:

 For 1st query, array in the range (2, 4) is [-2, 6, 1] and 2nd smallest element will be 1.
 For 2nd query, array in the range (1, 5) is [1, -2, 6, 1, 3] and 4th smallest element will be 3.
 For 3rd query, array in the range (3, 3) is [6] and 1st smallest element will be 6.
Explanation 2:

 For 1st query, array in the range (3, 6) is [-16, 1, 9, 2] and 1st smallest element will be -16.
 For 2nd query, array in the range (1, 4) is [23, -12, -16, 1] and 4th smallest element will be 23.
 */
import java.util.Arrays;
import java.util.Comparator;

public class Kth_Smallest_In_Range {

    public static void main(String[] args) {
        Kth_Smallest_In_Range t = new Kth_Smallest_In_Range();
        {
            int[] A = new int[]{1, -2, 6, 1, 3};
            int[][] B = new int[][]{{2, 4, 2}, {1, 5, 4}, {3, 3, 1}};
            int[] res = t.solve(A, B);
            System.out.println(Arrays.toString(res)); // [1, 3, 6]
        }
        {
            int[] A = new int[]{23, -12, -16, 1, 9, 2};
            int[][] B = new int[][]{{3, 6, 1}, {1, 4, 4}};
            int[] res = t.solve(A, B);
            System.out.println(Arrays.toString(res)); // [-16, 23]
        }
    }

    public int[] solve(int[] A, int[][] B) {
        int n = A.length;
        int[][] seg = new int[n * 4][];

        int[][] pair = new int[n][2];
        for (int i = 0; i < A.length; i++) {
            pair[i] = new int[]{A[i], i};
        }
        // sort by index, second parameter in pair
        Arrays.sort(pair, Comparator.comparingInt(a -> a[0]));

        build(0, 0, n - 1, pair, seg);

        int[] result = new int[B.length];
        int i = 0;
        for (int[] q : B) {
            int l = q[0] - 1;
            int r = q[1] - 1;
            int k = q[2];
            int index = query(0, 0, n - 1, l, r, k, seg);
            result[i++] = A[index];
        }
        return result;
    }

    // build segment tree
    public void build(int currIndex, int start, int end, int[][] pair, int[][] seg) {
        if (start == end) {
            // if only single element, take the index value from pair
            seg[currIndex] = new int[]{pair[start][1]};
            return;
        }
        int mid = start + (end - start) / 2;
        int leftChildIndex = 2 * currIndex + 1;
        int rightChildIndex = 2 * currIndex + 2;
        build(leftChildIndex, start, mid, pair, seg);
        build(rightChildIndex, mid + 1, end, pair, seg);
        seg[currIndex] = merge(seg[leftChildIndex], seg[rightChildIndex]);
    }

    // merge 2 sorted arrays
    public int[] merge(int[] left, int[] right) {
        int n = left.length;
        int m = right.length;
        int[] res = new int[n + m];
        int i = 0;
        int j = 0;
        int ind = 0;
        while (i < n && j < m) {
            if (left[i] < right[j]) {
                res[ind++] = left[i++];
            } else {
                res[ind++] = right[j++];
            }
        }
        while (i < n) {
            res[ind++] = left[i++];
        }
        while (j < m) {
            res[ind++] = right[j++];
        }
        return res;
    }

    public int query(int currIndex, int start, int end, int l, int r, int k, int[][] seg) {

        if (start == end) {
            return seg[currIndex][0];
        }
        int leftChildIndex = 2 * currIndex + 1;
        int rightChildIndex = 2 * currIndex + 2;
        int mid = start + (end - start) / 2;

        // find how many element in seg array of left falls in a range [l, r]
        int count = check(seg[leftChildIndex], l, r);
        if (count >= k) {
            return query(leftChildIndex, start, mid, l, r, k, seg);
        } else {
            return query(rightChildIndex, mid + 1, end, l, r, k - count, seg);
        }
    }

    public int check(int[] arr, int l, int r) {
        int count = 0;
        for (int currEle : arr) {
            if (currEle >= l && currEle <= r) {
                count++;
            }
        }
        return count;
    }
}
