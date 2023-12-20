import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Flip Sign
Given an array A and Q queries
Perform below types operations
1. Find sum from range [l, r] and return value - query
2. Flip the sign of all elements in range [l, r] - range update

Flip sign means +5 becomes -5; -3 becomes +3 etc.
 */
public class class_q2_Flip_Sign {
    public static void main(String[] args) {
        class_q2_Flip_Sign t = new class_q2_Flip_Sign();
        {
            int[] A = new int[]{1, 4, 3, 6, -5, 2};
            int[][] B = new int[][]{{1, 2, 4}, {1, 1, 3}, {2, 1, 5}, {1, 2, 4}, {1, 1, 3}};
            System.out.println(Arrays.toString(t.solve(A, B))); // [4, 13, -4, -13]
        }
        {
            int[] A = new int[]{2, 3, 4};
            int[][] B = new int[][]{{2, 0, 1}, {1, 0, 2}};
            System.out.println(Arrays.toString(t.solve(A, B))); // [-1]
        }
    }

    // TC: O(Q * logN)
    public int[] solve(int[] A, int[][] B) {
        int n = A.length;
        int[] seg = new int[n * 4];
        int[] lazy = new int[n * 4];
        build(0, 0, n - 1, A, seg, lazy);
        List<Integer> result = new ArrayList<>();
        for (int[] q : B) {
            int type = q[0];
            int l = q[1];
            int r = q[2];
            if (type == 1) {
                // get
                int answer = query(0, 0, n - 1, l, r, seg, lazy);
                result.add(answer);
            } else {
                // update
                update(0, 0, n - 1, l, r, seg, lazy);
            }
        }
        return result.stream().mapToInt(i -> i).toArray();
    }

    private void update(int currIndex, int start, int end, int l, int r, int[] seg, int[] lazy) {
        int leftChildIndex = 2 * currIndex + 1;
        int rightChildIndex = 2 * currIndex + 2;

        if (lazy[currIndex] != 0) {
            // perform update at current index
            seg[currIndex] = seg[currIndex] * -1;
            if (start != end) {
                // pass on the updates to child nodes
                lazy[leftChildIndex] = lazy[leftChildIndex] == 0 ? 1 : 0;
                lazy[rightChildIndex] = lazy[rightChildIndex] == 0 ? 1 : 0;
            }
            // reset
            lazy[currIndex] = 0;
        }

        // disjoint range
        if (end < l || r < start) {
            return;
        }

        // overlapping range
        if (start >= l && end <= r) {
            seg[currIndex] = seg[currIndex] * -1;
            if (start != end) {
                lazy[leftChildIndex] = lazy[leftChildIndex] == 0 ? 1 : 0;
                lazy[rightChildIndex] = lazy[rightChildIndex] == 0 ? 1 : 0;
            }
            // reset
            return;
        }

        int mid = start + (end - start) / 2;
        update(leftChildIndex, start, mid, l, r, seg, lazy);
        update(rightChildIndex, mid + 1, end, l, r, seg, lazy);
        seg[currIndex] = seg[leftChildIndex] + seg[rightChildIndex];
    }

    private int query(int currIndex, int start, int end, int l, int r, int[] seg, int[] lazy) {
        int leftChildIndex = 2 * currIndex + 1;
        int rightChildIndex = 2 * currIndex + 2;

        if (lazy[currIndex] != 0) {
            // perform update at current index
            seg[currIndex] = seg[currIndex] * -1;
            if (start != end) {
                // pass on the updates to child nodes
                lazy[leftChildIndex] = lazy[leftChildIndex] == 0 ? 1 : 0;
                lazy[rightChildIndex] = lazy[rightChildIndex] == 0 ? 1 : 0;
            }
            // reset
            lazy[currIndex] = 0;
        }

        // disjoint range
        if (end < l || r < start) {
            return 0;
        }

        // overlapping range
        if (start >= l && end <= r) {
            return seg[currIndex];
        }

        int mid = start + (end - start) / 2;

        int leftSum = query(leftChildIndex, start, mid, l, r, seg, lazy);
        int rightSum = query(rightChildIndex, mid + 1, end, l, r, seg, lazy);
        return leftSum + rightSum;
    }

    private void build(int currIndex, int start, int end, int[] A, int[] seg, int[] lazy) {
        if (start == end) {
            seg[currIndex] = A[start];
            lazy[currIndex] = 0;
            return;
        }
        int mid = start + (end - start) / 2;
        int leftChildIndex = 2 * currIndex + 1;
        int rightChildIndex = 2 * currIndex + 2;

        build(leftChildIndex, start, mid, A, seg, lazy);
        build(rightChildIndex, mid + 1, end, A, seg, lazy);
        seg[currIndex] = seg[leftChildIndex] + seg[rightChildIndex];
    }
}
