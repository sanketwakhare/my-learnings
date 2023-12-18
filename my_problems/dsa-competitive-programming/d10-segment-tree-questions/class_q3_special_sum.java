import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given array of size N, and Q queries
Type 1: update value of element at index to value
Type 2: find special sum for a given range [l, r]
where special sum between  [l, r]= 1 * A[l] + 2 * A[l+1] + 3 * A[l+2] + .. + (r-l) * A[r-1] + (r-l+1) * A[r]
 */
public class class_q3_special_sum {
    public static void main(String[] args) {
        class_q3_special_sum t = new class_q3_special_sum();
        {
            int[] A = new int[]{7, 4, 2, 5, 1, 6, 3};
            int[][] B = new int[][]{{2, 2, 5}, {2, 2, 4}};
            System.out.println(Arrays.toString(t.solve(A, B))); // [27, 23]
        }
        {
            int[] A = new int[]{3, 7, 8, 5, 3, 8, 10};
            int[][] B = new int[][]{{2, 2, 6}, {1, 2, 4}, {1, 3, 8}, {2, 4, 5}, {2, 1, 6}, {1, 6, 2}, {2, 5, 6}};
            System.out.println(Arrays.toString(t.solve(A, B))); // [90, 11, 118, 7]
        }
        {
            int[] A = new int[]{10, 3, 8, 10, 3, 3, 5, 2};
            int[][] B = new int[][]{{2, 3, 6}, {1, 7, 6}, {1, 5, 1}, {2, 2, 3}, {1, 6, 3}, {1, 8, 7}, {2, 1, 3}, {2, 3, 7}, {1, 2, 1}};
            System.out.println(Arrays.toString(t.solve(A, B))); // [49, 19, 40, 73]
        }
    }

    int mod = 1000000007;

    public int[] solve(int[] A, int[][] B) {

        int n = A.length;
        int[][] seg = new int[4 * n][2];
        build(0, 0, n - 1, A, seg);

        List<Integer> result = new ArrayList<>();
        for (int[] query : B) {
            int type = query[0];
            if (type == 2) {
                // get
                int l = query[1] - 1;
                int r = query[2] - 1;
                int[] res = get(0, 0, n - 1, l, r, seg);
                result.add(res[1]);
            } else {
                // update
                int index = query[1] - 1;
                int value = query[2];
                update(0, 0, n - 1, index, value, A, seg);
            }
        }
        return result.stream().mapToInt(i -> i).toArray();
    }

    private void update(int currIndex, int start, int end, int index, int value, int[] A, int[][] seg) {
        if (start == end) {
            A[index] = value;
            seg[currIndex] = new int[]{value, value};
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

        long x1 = seg[leftChildIndex][0];
        long y1 = seg[leftChildIndex][1];
        long x2 = seg[rightChildIndex][0];
        long y2 = seg[rightChildIndex][1];

        long x = (x1 + x2 + mod) % mod;

        long y = (y1 + y2) % mod;
        long leftRangeLength = (mid - start + 1);
        long remSum = (leftRangeLength * x2) % mod;
        y = (y + remSum + mod) % mod;

        seg[currIndex] = new int[]{(int) x, (int) y};
    }

    private int[] get(int currIndex, int start, int end, int l, int r, int[][] seg) {
        // disjoint range
        if (end < l || r < start) {
            return new int[]{0, 0};
        }
        // completely overlapping
        if (start >= l && end <= r) {
            return seg[currIndex];
        }

        int mid = start + (end - start) / 2;
        int leftChildIndex = 2 * currIndex + 1;
        int rightChildIndex = 2 * currIndex + 2;
        int[] left = get(leftChildIndex, start, mid, l, r, seg);
        int[] right = get(rightChildIndex, mid + 1, end, l, r, seg);

        long x1 = left[0];
        long y1 = left[1];
        long x2 = right[0];
        long y2 = right[1];

        long x = (x1 + x2 + mod) % mod;

        long leftRangeLength = mid - l >= 0 ? mid - l + 1 : 0;
        leftRangeLength = l < start ? mid - start + 1 : leftRangeLength;

        long y = (y1 + y2) % mod;
        long remSum = (leftRangeLength * x2) % mod;
        y = (y + remSum + mod) % mod;
        return new int[]{(int) x, (int) y};
    }

    private void build(int currIndex, int start, int end, int[] A, int[][] seg) {
        if (start == end) {
            // seg[i][0] = sum
            // seg[i][1] = special sum
            seg[currIndex][0] = A[start];
            seg[currIndex][1] = A[start];
            return;
        }

        int mid = start + (end - start) / 2;
        int leftChildIndex = 2 * currIndex + 1;
        int rightChildIndex = 2 * currIndex + 2;
        build(leftChildIndex, start, mid, A, seg);
        build(rightChildIndex, mid + 1, end, A, seg);

        long x1 = seg[leftChildIndex][0];
        long y1 = seg[leftChildIndex][1];
        long x2 = seg[rightChildIndex][0];
        long y2 = seg[rightChildIndex][1];

        long x = (x1 + x2 + mod) % mod;

        long y = (y1 + y2) % mod;
        long leftRangeLength = (mid - start + 1);
        long remSum = (leftRangeLength * x2) % mod;
        y = (y + remSum + mod) % mod;

        seg[currIndex] = new int[]{(int) x, (int) y};
    }
}
