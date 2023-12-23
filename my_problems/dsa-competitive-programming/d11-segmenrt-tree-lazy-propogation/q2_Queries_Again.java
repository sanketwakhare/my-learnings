import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Queries Again?

Problem Description

Given a string A consisting only of digits 4 and 7. Also given an array B of size M X 3 denoting operations as follows.

If B[i][0]=1, "switch" digits (i.e. replace them with their opposites) at all positions with indexes from B[i][1] to B[i][2].

If B[i][0]=2, find the length of the longest non-decreasing subsequence of string A. Ignore the values of B[i][1] and B[i][2] here.

Return an array consisting of answers for type 2 queries.



Problem Constraints

1 <= |A| <= 100000

1 <= |B| <= 100000



Input Format

First argument is vector A.

Second argument is the vector of vectors B.



Output Format

Return an array, consisting of answers to the type 2 queries.



Example Input

Input 1:

 A = "47"
B = [    [2, 1, 1]
         [1, 1, 2]
         [2, 1, 1]
    ]
Input 2:

 A = "747"
B = [    [2, 1, 1]
         [1, 1, 2]
         [2, 1, 1]
    ]


Example Output

Output 1:

 [2, 1]
Output 2:

 [2, 3]


Example Explanation

Explanation 1:

 After changing string is "74".
Explanation 2:

After changing string is "477".
 */
public class q2_Queries_Again {
    public static void main(String[] args) {
        q2_Queries_Again t = new q2_Queries_Again();
        {
            String A = "47";
            int[][] B = new int[][]{{2, 1, 1}, {1, 1, 2}, {2, 1, 1}};
            System.out.println(Arrays.toString(t.solve(A, B)));
        }
        {
            String A = "747";
            int[][] B = new int[][]{{2, 1, 1}, {1, 1, 2}, {2, 1, 1}};
            System.out.println(Arrays.toString(t.solve(A, B)));
        }
    }

    public int[] solve(String A, int[][] B) {
        int n = A.length();
        // seg[i][0] = count of 4s
        // seg[i][1] = count of 7s
        // seg[i][2] = max non-decreasing subsequence length
        // seg[i][3] = max non-increasing subsequence length
        int[][] seg = new int[n * 4][4];
        boolean[] lazy = new boolean[n * 4];
        build(0, 0, n - 1, A, seg);

        List<Integer> result = new ArrayList<>();
        for (int[] q : B) {
            int type = q[0];
            if (type == 1) {
                // update
                int l = q[1] - 1;
                int r = q[2] - 1;
                update(0, 0, n - 1, l, r, seg, lazy);
            } else {
                // get
                int answer = Math.max(seg[0][2], Math.max(seg[0][0], seg[0][1]));
                result.add(answer);
            }
        }
        return result.stream().mapToInt(i -> i).toArray();
    }

    private void update(int currIndex, int start, int end, int l, int r, int[][] seg, boolean[] lazy) {
        int leftChildIndex = 2 * currIndex + 1;
        int rightChildIndex = 2 * currIndex + 2;

        if (lazy[currIndex]) {
            propagate(start, end, lazy, leftChildIndex, rightChildIndex, seg[currIndex]);
            // reset
            lazy[currIndex] = false;
        }
        // disjoint
        if (start > r || l > end) {
            return;
        }
        // overlapping
        if (start >= l && end <= r) {
            // swap 4 with 7 currIndex
            propagate(start, end, lazy, leftChildIndex, rightChildIndex, seg[currIndex]);
            return;
        }

        int mid = start + (end - start) / 2;
        update(leftChildIndex, start, mid, l, r, seg, lazy);
        update(rightChildIndex, mid + 1, end, l, r, seg, lazy);

        populateParentNodes(currIndex, seg, leftChildIndex, rightChildIndex);
    }

    private void populateParentNodes(int currIndex, int[][] seg, int leftChildIndex, int rightChildIndex) {
        seg[currIndex][0] = seg[leftChildIndex][0] + seg[rightChildIndex][0];
        seg[currIndex][1] = seg[leftChildIndex][1] + seg[rightChildIndex][1];
        // 47-7, 4-47
        seg[currIndex][2] = Math.max(seg[leftChildIndex][2] + seg[rightChildIndex][1],
                seg[leftChildIndex][0] + seg[rightChildIndex][2]);
        // 74-4, 7-74
        seg[currIndex][3] = Math.max(seg[leftChildIndex][3] + seg[rightChildIndex][0],
                seg[leftChildIndex][1] + seg[rightChildIndex][3]);
    }

    private void propagate(int start, int end, boolean[] lazy, int leftChildIndex, int rightChildIndex, int[] seg) {
        // perform update at current index
        // swap 4 with 7 currIndex
        swap(seg, 0, 1);
        // swap 47 with 74 currIndex
        swap(seg, 2, 3);

        if (start != end) {
            // pass on the updates to child nodes
            lazy[leftChildIndex] = !lazy[leftChildIndex];
            lazy[rightChildIndex] = !lazy[rightChildIndex];
        }
    }

    private void swap(int[] ints, int i, int j) {
        int tmp = ints[i];
        ints[i] = ints[j];
        ints[j] = tmp;
    }

    private void build(int currIndex, int start, int end, String A, int[][] seg) {
        if (start == end) {
            char ch = A.charAt(start);
            seg[currIndex][0] = ch == '4' ? 1 : 0;
            seg[currIndex][1] = ch == '7' ? 1 : 0;
            seg[currIndex][2] = 1;
            seg[currIndex][3] = 1;
            return;
        }
        int mid = start + (end - start) / 2;
        int leftChildIndex = 2 * currIndex + 1;
        int rightChildIndex = 2 * currIndex + 2;
        build(leftChildIndex, start, mid, A, seg);
        build(rightChildIndex, mid + 1, end, A, seg);

        populateParentNodes(currIndex, seg, leftChildIndex, rightChildIndex);
    }
}
