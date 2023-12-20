/*
A Game of Queries

Problem Description

You are given an array A of numbers, which is circular and an array B of size M X 3, having operations as follows.
If B[i][0] is not equal to 2, increase all numbers in the segment [ B[i][1], B[i][2] ] by B[i][0] .
If B[i][0] = 2, calculate the minimum of the array in given range inclusive of both B[i][1] and B[i][2] .
Return an array of answers to the Type 2 queries.
Assuming circular segments, if we consider 5 elements and the segment [3, 1], we refer to index sequence [3, 4, 1].


Problem Constraints
1 <= |A| <= 100000
1 <= |B| <= 100000
1 <= A[i] <= 500
It is assured that after any operation, all the numbers will fit into 32 bit integers.


Input Format
First argument is vector A.
Second argument is the vector of vectors B.


Output Format
Return an array, consisting of answers to the type 2 queries.


Example Input

Input 1:
 A = [2, 3, 4]
B = [    [1, 1, 2]
         [2, 3, 1]
    ]

Input 2:
A = [1, 2, 3]
B = [    [1, 3, 3]
         [2, 1, 3]
         [2, 1, 1]
    ]

Example Output
Output 1:
 [3]
Output 2:
 [1, 1]


Example Explanation:
Explanation 1:
 After first operation, array is [3, 4, 4]. Now minimum across next range is 3.
Explanation 2:
 After first operation, array is [1, 2, 4]. Minimums can now be calculated.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class hw_q1_A_Game_of_Queries {
    public static void main(String[] args) {
        hw_q1_A_Game_of_Queries t = new hw_q1_A_Game_of_Queries();
        {
            int[] A = {4, 7, 2, 8, 9, 1, 2, 5};
            int[][] B = new int[][]{{3, 7, 1}, {2, 8, 2}, {1, 3, 3}, {2, 7, 3}, {1, 4, 4}, {2, 5, 4}};
            System.out.println(Arrays.toString(t.solve(A, B))); // [7, 3, 1]
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
                if (l > r) {
                    int a1 = query(0, 0, n - 1, l, n - 1, seg, lazy);
                    int a2 = query(0, 0, n - 1, 0, r, seg, lazy);
                    result.add(Math.min(a1, a2));
                } else {
                    int answer = query(0, 0, n - 1, l, r, seg, lazy);
                    result.add(answer);
                }
            } else {
                // update
                int x = q[0];
                if (l > r) {
                    update(0, 0, n - 1, l, n - 1, x, seg, lazy);
                    update(0, 0, n - 1, 0, r, x, seg, lazy);
                } else {
                    update(0, 0, n - 1, l, r, x, seg, lazy);
                }
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
