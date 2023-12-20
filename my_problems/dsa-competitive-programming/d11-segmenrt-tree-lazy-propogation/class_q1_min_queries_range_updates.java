import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given array A and Q queries
Perform below 2 types of queries
1. Find min in the range [l, r]
2. add x in all the element in range [l, r]
B[i][0] = type of query
B[i][1] = l
B[i][2] = r
B[i][3] = x if type is 2
 */
public class class_q1_min_queries_range_updates {

    public static void main(String[] args) {
        class_q1_min_queries_range_updates t = new class_q1_min_queries_range_updates();
        {
            int[] A = new int[]{1, 4, 3, 6, -5, 2};
            int[][] B = new int[][]{{1, 2, 4}, {1, 1, 3}, {2, 1, 5, 2}, {1, 2, 4}, {1, 1, 3}};
            System.out.println(Arrays.toString(t.solve(A, B))); // [-5, 3, -3, 5]
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
                int x = q[3];
                update(0, 0, n - 1, l, r, x, seg, lazy);
            }
        }
        return result.stream().mapToInt(i -> i).toArray();
    }

    private void update(int currIndex, int start, int end, int l, int r, int x, int[] seg, int[] lazy) {
        int leftChildIndex = 2 * currIndex + 1;
        int rightChildIndex = 2 * currIndex + 2;

        if (lazy[currIndex] != 0) {
            // perform update at current index
            seg[currIndex] += lazy[currIndex];
            if (start != end) {
                // pass on the updates to child nodes
                lazy[leftChildIndex] += lazy[currIndex];
                lazy[rightChildIndex] += lazy[currIndex];
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
            seg[currIndex] += x;
            if (start != end) {
                lazy[leftChildIndex] += x;
                lazy[rightChildIndex] += x;
            }
            return;
        }

        int mid = start + (end - start) / 2;
        update(leftChildIndex, start, mid, l, r, x, seg, lazy);
        update(rightChildIndex, mid + 1, end, l, r, x, seg, lazy);
        seg[currIndex] = Math.min(seg[leftChildIndex], seg[rightChildIndex]);
    }

    private int query(int currIndex, int start, int end, int l, int r, int[] seg, int[] lazy) {
        int leftChildIndex = 2 * currIndex + 1;
        int rightChildIndex = 2 * currIndex + 2;

        if (lazy[currIndex] != 0) {
            // perform update at current index
            seg[currIndex] += lazy[currIndex];
            if (start != end) {
                // pass on the updates to child nodes
                lazy[leftChildIndex] += lazy[currIndex];
                lazy[rightChildIndex] += lazy[currIndex];
            }
            // reset
            lazy[currIndex] = 0;
        }

        // disjoint range
        if (end < l || r < start) {
            return Integer.MAX_VALUE;
        }

        // overlapping range
        if (start >= l && end <= r) {
            return seg[currIndex];
        }

        int mid = start + (end - start) / 2;

        return Math.min(query(leftChildIndex, start, mid, l, r, seg, lazy),
                query(rightChildIndex, mid + 1, end, l, r, seg, lazy));
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
        seg[currIndex] = Math.min(seg[leftChildIndex], seg[rightChildIndex]);
    }
}
