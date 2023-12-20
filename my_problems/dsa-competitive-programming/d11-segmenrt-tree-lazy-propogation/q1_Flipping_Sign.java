import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Flipping Sign

Problem Description
You are given an array A of numbers and an array B of size M X 3, having operations as follows.
If B[i][0] = 1, flip( multiply A[i] by -1) the value of A[i] where B[i][1] <= i <= B[i][2] .
If B[i][0] = 2, calculate the sum of the array in given range inclusive of both B[i][1] and B[i][2] .
Return an array of answers to the Type 2 queries.

Problem Constraints
1 <= |A| <= 100000
1 <= |B| <= 100000
1 <= A[i] <= 500

Input Format
First argument is vector A.
Second argument is the vector of vectors B.

Output Format
Return an array, consisting of asnwers to the type 2 queries.

Example Input
Input 1:
 A = [2, 3, 4]
B = [    [1, 1, 2]
         [2, 1, 3]
    ]

Input 2:
A = [1, 2, 3]
B = [    [1, 3, 3]
         [2, 1, 3]
         [2, 1, 1]
    ]

Example Output:
Output 1:
 [-1]
Output 2:
 [0, 1]

Example Explanation:
Explanation 1:
 After first operation, array is [-2, -3, 4]. Then sum for [1, 3] is -1.
Explanation 2:
 After first operation, array is [1, 2, -3]. Sums can now be calculated.
 */
public class q1_Flipping_Sign {

    public static void main(String[] args) {
        q1_Flipping_Sign t = new q1_Flipping_Sign();
        {
            int[] A = {2, 3, 4};
            int[][] B = new int[][]{{1, 1, 2}, {2, 1, 3}};
            System.out.println(Arrays.toString(t.solve(A, B))); // [-1]
        }
        {
            int[] A = {1, 2, 3};
            int[][] B = new int[][]{{1, 3, 3}, {2, 1, 3}, {2, 1, 1}};
            System.out.println(Arrays.toString(t.solve(A, B))); // [0, 1]
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
            int l = q[1] - 1;
            int r = q[2] - 1;
            if (type == 2) {
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
