/*
Max Sum Queries with Frequency of max element
Given array A, and Q queries
    Type 1: find max element in range [l, r] and it's frequency
    Type 2: update element at index ind to given value
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Note: each node can store teh max along with its frequency in range
public class class_q2_max_range_freq {
    public static void main(String[] args) {
        class_q2_max_range_freq t = new class_q2_max_range_freq();
        {
            int[] A = {7, 4, 2, 5, 2, 5, 10};
            int[][] B = {{1, 2, 4}, {1, 3, 5}, {2, 4, 5}, {1, 3, 5}};
            List<int[]> res = t.solve(A, B);
            List<String> list = toStringList(res);
            System.out.println(list);
        }
        {
            int[] A = {4, 3, 2, 5, 2, 3, 6, 4, 3, 7, 5, 8, 7};
            int[][] B = {{1, 2, 4}, {1, 3, 5}, {2, 4, 5}, {1, 3, 5}, {1, 0, 8}, {2, 3, 8}, {2, 6, 8}, {1, 1, 10}, {1, 2, 7}, {1, 7, 11}};
            List<int[]> res = t.solve(A, B);
            List<String> list = toStringList(res);
            System.out.println(list);
        }
    }

    private static List<String> toStringList(List<int[]> res) {
        List<String> list = new ArrayList<>();
        for (int[] r : res) {
            list.add(Arrays.toString(r));
        }
        return list;
    }

    /*
        Idea

        seg[i][0] - represents max element
        seg[i][1] - represents frequency of max element
     */
    public List<int[]> solve(int[] A, int[][] B) {
        int n = A.length;
        int[][] seg = new int[4 * n][2];
        build(0, 0, n - 1, A, seg);

        List<int[]> result = new ArrayList<>();
        for (int[] query : B) {
            int type = query[0];
            if (type == 1) {
                // get
                int l = query[1];
                int r = query[2];
                int[] value = get(0, 0, n - 1, l, r, seg);
                result.add(value);
            } else {
                // update
                int index = query[1];
                int value = query[2];
                update(0, 0, n - 1, index, value, A, seg);
            }
        }
        return result;
    }

    private void update(int currIndex, int start, int end, int index, int value, int[] A, int[][] seg) {
        if (start == end) {
            A[index] = value;
            seg[currIndex] = new int[]{value, 1};
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
        int x1 = seg[leftChildIndex][0];
        int y1 = seg[leftChildIndex][1];
        int x2 = seg[rightChildIndex][0];
        int y2 = seg[rightChildIndex][1];

        int x = Math.max(x1, x2);
        int y;
        if (x1 > x2) {
            y = y1;
        } else if (x2 > x1) {
            y = y2;
        } else {
            // if x1 == x2, add frequencies from both sides
            y = y1 + y2;
        }
        seg[currIndex] = new int[]{x, y};
    }

    private int[] get(int currIndex, int start, int end, int l, int r, int[][] seg) {
        // disjoint range
        if (r < start || end < l) {
            return new int[]{Integer.MIN_VALUE, 0};
        }
        // completely overlapping range
        if (start >= l && end <= r) {
            return seg[currIndex];
        }
        int mid = start + (end - start) / 2;
        int leftChildIndex = 2 * currIndex + 1;
        int rightChildIndex = 2 * currIndex + 2;
        int[] leftValue = get(leftChildIndex, start, mid, l, r, seg);
        int x1 = leftValue[0];
        int y1 = leftValue[1];
        int[] rightValue = get(rightChildIndex, mid + 1, end, l, r, seg);
        int x2 = rightValue[0];
        int y2 = rightValue[1];

        int x = Math.max(x1, x2);
        int y;
        if (x1 > x2) {
            y = y1;
        } else if (x2 > x1) {
            y = y2;
        } else {
            // if x1 == x2, add frequencies from both sides
            y = y1 + y2;
        }
        return new int[]{x, y};
    }

    private void build(int currIndex, int start, int end, int[] A, int[][] seg) {
        if (start == end) {
            seg[currIndex][0] = A[start];
            // store initial frequency as 1 as only single element in this range
            seg[currIndex][1] = 1;
            return;
        }
        int mid = start + (end - start) / 2;
        int leftChildIndex = 2 * currIndex + 1;
        int rightChildIndex = 2 * currIndex + 2;
        build(leftChildIndex, start, mid, A, seg);
        build(rightChildIndex, mid + 1, end, A, seg);

        // x represents max element
        // y represents frequency of max element
        int x1 = seg[leftChildIndex][0];
        int y1 = seg[leftChildIndex][1];
        int x2 = seg[rightChildIndex][0];
        int y2 = seg[rightChildIndex][1];

        int x = Math.max(x1, x2);
        int y;
        if (x1 > x2) {
            y = y1;
        } else if (x2 > x1) {
            y = y2;
        } else {
            // if x1 == x2, add frequencies from both sides
            y = y1 + y2;
        }
        seg[currIndex] = new int[]{x, y};
    }
}
