import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
    Sum Queries
    Type 1: get sum from range [l, r]
    Type 2: update A[index] to value
 */
public class class_q1_sum_queries {
    public static void main(String[] args) {
        class_q1_sum_queries t = new class_q1_sum_queries();
        {
            int[] A = {4, 3, 6, 5, 9, 10, -3, -5, -2, 9, 3};
            int[][] B = {{1, 0, 5}, {1, 5, 8}, {1, 2, 6}, {2, 3, -17}, {1, 2, 6}, {2, 6, 5}, {1, 5, 8}};
            System.out.println(Arrays.toString(t.solve(A, B)));
        }
    }

    public int[] solve(int[] A, int[][] B) {

        // build segment tree
        int n = A.length;
        int[] seg = new int[4 * n];
        build(0, 0, n - 1, A, seg);

        System.out.println(Arrays.toString(seg));

        List<Integer> result = new ArrayList<>();
        for (int[] query : B) {
            int type = query[0];
            if (type == 1) {
                // get
                int l = query[1];
                int r = query[2];
                int answer = get(0, 0, n - 1, l, r, seg);
                result.add(answer);
            } else {
                // update
                int index = query[1];
                int value = query[2];
                update(0, 0, n - 1, index, value, A, seg);
            }
        }
        return result.stream().mapToInt(i -> i).toArray();
    }

    private void update(int currIndex, int start, int end, int index, int value, int[] A, int[] seg) {
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
        seg[currIndex] = seg[leftChildIndex] + seg[rightChildIndex];
    }

    private int get(int currIndex, int start, int end, int l, int r, int[] seg) {
        // disjoint range
        if (end < l || r < start) {
            return 0;
        }
        // completely overlapping
        if (start >= l && end <= r) {
            return seg[currIndex];
        }

        int mid = start + (end - start) / 2;
        int leftChildIndex = 2 * currIndex + 1;
        int rightChildIndex = 2 * currIndex + 2;
        int leftSum = get(leftChildIndex, start, mid, l, r, seg);
        int rightSum = get(rightChildIndex, mid + 1, end, l, r, seg);
        return leftSum + rightSum;
    }

    private void build(int currIndex, int start, int end, int[] A, int[] seg) {
        if (start == end) {
            seg[currIndex] = A[start];
            return;
        }
        int mid = start + (end - start) / 2;
        int leftChildIndex = 2 * currIndex + 1;
        int rightChildIndex = 2 * currIndex + 2;
        build(leftChildIndex, start, mid, A, seg);
        build(rightChildIndex, mid + 1, end, A, seg);
        seg[currIndex] = seg[leftChildIndex] + seg[rightChildIndex];
    }
}
