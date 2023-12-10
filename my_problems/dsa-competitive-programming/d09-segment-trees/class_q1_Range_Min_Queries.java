import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 Implementation of Min Segment Tree
 */
/*
Given integer Array of size N, build a segment trees and perform below 2 types of operations on it randomly multiple times
    1. Given i, v => update element at index i with value v
    2. Given l, r => find minimum from the range [l, r] inclusive of l and r

    // Note: indexes are 0-based
 */
public class class_q1_Range_Min_Queries {

    public static void main(String[] args) {
        class_q1_Range_Min_Queries t = new class_q1_Range_Min_Queries();
        {
            int[] A = {10, 2, 7, -3, 5, 8, 1, 15};
            // B[i][0] = type of operation. 1 = update, 2 = find min
            // B[i][1] = for type=1. index; for type=2, l
            // B[i][2] = for type=1. v; for type=2, r
            int[][] B = {{2, 1, 4}, {2, 4, 6}, {1, 2, -7}, {2, 0, 5}};
            int[] res = t.solve(A, B);
            System.out.println(Arrays.toString(res));
        }
    }

    public int[] solve(int[] A, int[][] B) {
        int n = A.length;
        int[] seg = new int[4 * n];
        build(0, 0, n - 1, A, seg);

        List<Integer> res = new ArrayList<>();
        for (int[] q : B) {
            if (q[0] == 2) {
                res.add(query(0, 0, n - 1, q[1], q[2], seg));
            } else if (q[0] == 1) {
                update(0, 0, n - 1, q[1], q[2], A, seg);
            }
        }
        return res.stream().mapToInt(i -> i).toArray();
    }

    public void build(int currIndex, int start, int end, int[] A, int[] seg) {
        if (start == end) {
            seg[currIndex] = A[start];
            return;
        }
        int mid = start + (end - start) / 2;
        int leftChildIndex = 2 * currIndex + 1;
        int rightChildIndex = 2 * currIndex + 2;
        build(leftChildIndex, start, mid, A, seg);
        build(rightChildIndex, mid + 1, end, A, seg);
        // update min in parent nodes
        seg[currIndex] = Math.min(seg[leftChildIndex], seg[rightChildIndex]);
    }

    public int query(int currIndex, int start, int end, int l, int r, int[] seg) {
        // disjoint condition/ non overlapping condition
        if (l > end || r < start) {
            return Integer.MAX_VALUE;
        }
        // completely overlapping condition
        if (start >= l && end <= r) {
            return seg[currIndex];
        }

        int mid = start + (end - start) / 2;
        int leftChildIndex = 2 * currIndex + 1;
        int rightChildIndex = 2 * currIndex + 2;
        return Math.min(query(leftChildIndex, start, mid, l, r, seg),
                query(rightChildIndex, mid + 1, end, l, r, seg));
    }

    public void update(int currIndex, int start, int end, int index, int value, int[] A, int[] seg) {
        // update the element
        if (start == end) {
            seg[currIndex] = value;
            A[index] = value;
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
        // keep updating the min in the traversed path as the value is changed
        seg[currIndex] = Math.min(seg[leftChildIndex], seg[rightChildIndex]);
    }


}
