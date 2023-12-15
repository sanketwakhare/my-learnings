/*
Binary Updates

Problem Description:

Given an integer A denoting the size of the array consisting all ones.

You are given Q queries, for each query there are two integer x and y:

If x is 0, then update the value of array at index y to 0.
If x is 1, then output the index of yth one in the array. If there is no such index then output -1.
NOTE 1: There will at least 1 query where value of x is 1.


Problem Constraints
1 <= A, Q <= 10^5
0 <= x <= 1
1 <= y <= A

Input Format
First argument is an integer A denoting the size of array.
Second argument is a 2-D array B of size Q x 2 where B[i][0] denotes x and B[i][1] denotes y.


Output Format
Return an integer array denoting the output of each query where x is 1.


Example Input
Input 1:
 A = 4
 B = [ [1, 2],
       [0, 2],
       [1, 4] ]
Input 2:
 A = 5
 B = [ [0, 3],
       [1, 4],
       [0, 3],
       [1, 5] ]

Example Output
Output 1:
 [2, -1]
Output 2:
 [5, -1]

Example Explanation:
Explanation 1:
 Initially array = [1, 1, 1, 1]. For first query 2nd one is at index 2.
 After Second query array becomes [1, 0, 1, 1].
 For third query there is no 4th one.
Explanation 2:
 Initially array = [1, 1, 1, 1, 1]. After first query array becomes [1, 1, 0, 1, 1].
 For second query 4th one is at index 5.
 After third query array remains same [1, 1, 0, 1, 1].
 For fourth query there is no 5th one.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class q1_Binary_Updates {

    public static void main(String[] args) {
        q1_Binary_Updates t = new q1_Binary_Updates();
        {
            int[] result = t.solve(5, new int[][]{{1, 5}, {1, 4}, {1, 3}, {1, 2}, {1, 1}, {1, 8}});
            System.out.println(Arrays.toString(result)); // 10 6 8
        }
        {
            int[] result = t.solve(13, new int[][]{{0, 7}, {1, 8}, {0, 5}, {0, 12}, {1, 1}, {1, 6}, {1, 11}, {1, 9}, {1, 3}});
            System.out.println(Arrays.toString(result)); // 9 1 8 -1 11 3
        }
    }

    public int[] solve(int A, int[][] B) {
        int n = A;
        int[] seg = new int[4 * n];
        build(0, 0, n - 1, seg);

        List<Integer> res = new ArrayList<>();
        for (int[] query : B) {
            int x = query[0];
            int y = query[1];
            if (x == 0) {
                // y-1 as 0 based indexing used
                update(0, 0, n - 1, y - 1, seg);
            } else {
                int value = get(n, y, seg);
                // if answer is not -1, return answer w.r.t 1 based indexing
                res.add(value != -1 ? value + 1 : value);
            }
        }
        return res.stream().mapToInt(i -> i).toArray();
    }

    private void build(int currIndex, int start, int end, int[] seg) {
        if (start == end) {
            seg[currIndex] = 1;
            return;
        }
        int leftChildIndex = 2 * currIndex + 1;
        int rightChildIndex = 2 * currIndex + 2;
        int mid = start + (end - start) / 2;
        build(leftChildIndex, start, mid, seg);
        build(rightChildIndex, mid + 1, end, seg);
        // store sum of left + sum of right into curr node
        seg[currIndex] = seg[leftChildIndex] + seg[rightChildIndex];
    }

    private void update(int currIndex, int start, int end, int y, int[] seg) {
        if (start == end) {
            seg[currIndex] = 0;
            return;
        }
        int leftChildIndex = 2 * currIndex + 1;
        int rightChildIndex = 2 * currIndex + 2;
        int mid = start + (end - start) / 2;
        if (y <= mid) {
            update(leftChildIndex, start, mid, y, seg);
        } else {
            update(rightChildIndex, mid + 1, end, y, seg);
        }
        // update sum
        seg[currIndex] = seg[leftChildIndex] + seg[rightChildIndex];
    }

    private int query(int currIndex, int start, int end, int l, int r, int[] seg) {
        // disjoint condition/ non overlapping condition
        if (l > end || r < start) {
            return 0;
        }
        // completely overlapping condition
        if (start >= l && end <= r) {
            return seg[currIndex];
        }

        int mid = start + (end - start) / 2;
        int leftChildIndex = 2 * currIndex + 1;
        int rightChildIndex = 2 * currIndex + 2;
        int leftSum = query(leftChildIndex, start, mid, l, r, seg);
        int rightSum = query(rightChildIndex, mid + 1, end, l, r, seg);
        return leftSum + rightSum;
    }

    private int get(int n, int y, int[] seg) {
        int answer = -1;
        int start = 0;
        int end = n - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int sum = query(0, 0, n - 1, 0, mid, seg);
            if (sum == y) {
                // update possible answer and search for best answer on left side of mid
                answer = mid;
                end = mid - 1;
            } else if (sum > y) {
                // search on left side of mid
                end = mid - 1;
            } else {
                // search on right side of mid
                start = mid + 1;
            }
        }
        return answer;
    }
}
