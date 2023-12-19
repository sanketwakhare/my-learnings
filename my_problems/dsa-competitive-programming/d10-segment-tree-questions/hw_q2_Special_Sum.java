import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Special Sums

Problem Description

You are given an array A of size N.

You need to process Q queries of following types on it:

X val, change the value of the Xth element of array A to val.
L R, find the sum: 1*a[L] + 2*a[L+1] + . . . + (R-L+1)*a[R].
Since, the result can be large, print it modulo 109 + 7


Problem Constraints
1 ≤ N, Q ≤ 10^5
1 ≤ A[i] ≤ 10^5

For query of the 1st type,
1 ≤ X ≤ N
1 ≤ val ≤ 10^5

For query of the 2nd type,
1 ≤ L ≤ R ≤ N


Input Format

The first argument of the input is the array A.
The second argument of the input is a 2-D array B containing the description of the queries.
Each query is an array of 3 elements, representing either (1 X val) or (2 L R).


Output Format
Return an array of answers to each query of the 2nd type, in the same order they were asked in the input.


Example Input
Input 1:
A: [2, 1, 4, 3]
B:  [
        [2, 1, 3],
        [1, 2, 5],
        [2, 1, 3]
    ]
Input 2:
A: [5, 6, 3, 7, 9]
B:  [
        [2, 1, 5],
        [2, 3, 4],
        [1, 3, 7],
        [2, 2, 4]
    ]

Example Output
Output 1:
[16, 24]
Output 2:
[99, 17, 41]

Example Explanation:
Explanation 1:
For the 1st query, the sum is: 1*2 + 2*1 + 3*4 = 16.
After the 2nd query, the array becomes: [2, 5, 4, 3].
For the 3rd query, the sum is: 1*2 + 2*5 + 3*4 = 24.

Explanation 2:
For the 1st query, the sum is: 1*5 + 2*6 + 3*3 + 4*7 + 5*9 = 99.
For the 2nd query, the sum is: 1*3 + 2*7 = 17.
After the 3rd query, the array becomes: [5, 6, 7, 7, 9].
For the 4th query, the sum is: 1*6 + 2*7 + 3*7 = 41.
 */
public class hw_q2_Special_Sum {

    public static void main(String[] args) {
        hw_q2_Special_Sum t = new hw_q2_Special_Sum();
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
