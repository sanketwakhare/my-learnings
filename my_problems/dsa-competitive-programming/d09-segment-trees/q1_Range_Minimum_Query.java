import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Range Minimum Query

Problem Description
Given an integer array A of size N.

You have to perform two types of query, in each query you are given three integers x,y,z.

If x = 0, then update A[y] = z.
If x = 1, then output the minimum element in the array A between index y and z inclusive.
Queries are denoted by a 2-D array B of size M x 3 where B[i][0] denotes x, B[i][1] denotes y, B[i][2] denotes z.

Problem Constraints

1 <= N, M <= 10^5
1 <= A[i] <= 10^9
If x = 0, 1<= y <= N and 1 <= z <= 10^9
If x = 1, 1<= y <= z <= N

Input Format
First argument is an integer array A of size N.
Second argument is a 2-D array B of size M x 3 denoting queries.

Output Format
Return an integer array denoting the output of each query where value of x is 1.

Example Input

Input 1:

 A = [1, 4, 1]
 B = [
        [1, 1, 3]
        [0, 1, 5]
        [1, 1, 2]
     ]
Input 2:

 A = [5, 4, 5, 7]
 B = [
        [1, 2, 4]
        [0, 1, 2]
        [1, 1, 4]
     ]

Example Output
Output 1:
 [1, 4]
Output 2:
 [4, 2]

Example Explanation
Explanation 1:
 For 1st query, the minimum element from range (1, 3) is 1.
 For 2nd query, update A[1] = 5, now A = [5, 4, 1].
 For 3rd query, the minimum element from range (1, 2) is 4.

Explanation 2:
 For 1st query, the minimum element from range (2, 4) is 4.
 For 2nd query, update A[1] = 2, now A = [2, 4, 5, 7].
 For 3rd query, the minimum element from range (1, 4) is 2.
 */
public class q1_Range_Minimum_Query {

    public static void main(String[] args) {
        q1_Range_Minimum_Query t = new q1_Range_Minimum_Query();
        {
            int[] A = {1, 4, 1};
            int[][] B = {{1, 1, 3}, {0, 1, 5}, {1, 1, 2}};
            System.out.println(Arrays.toString(t.solve(A, B))); // [1, 4]
        }
        {
            int[] A = {5, 4, 5, 7};
            int[][] B = {{1, 2, 4}, {0, 1, 2}, {1, 1, 4}};
            System.out.println(Arrays.toString(t.solve(A, B))); // [4, 2]
        }
    }

    // total TC: O(N + logN)
    public int[] solve(int[] A, int[][] B) {
        int n = A.length;
        int[] seg = new int[4 * n];
        build(0, 0, n - 1, A, seg);

        List<Integer> res = new ArrayList<>();
        for (int[] q : B) {
            int x = q[0];
            int y = q[1];
            int z = q[2];
            if (x == 1) {
                res.add(query(0, 0, n - 1, y - 1, z - 1, seg));
            } else if (x == 0) {
                update(0, 0, n - 1, y - 1, z, A, seg);
            }
        }
        return res.stream().mapToInt(i -> i).toArray();
    }

    // TC: O(N) where N is no of element in array
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

    // TC: O(logN)
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
        int leftMin = query(leftChildIndex, start, mid, l, r, seg);
        int rightMin = query(rightChildIndex, mid + 1, end, l, r, seg);
        return Math.min(leftMin, rightMin);
    }

    // TC: O(logN)
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
