/*
Bob and Queries

Problem Description
Bob has an array A of N integers. Initially, all the elements of the array are zero. Bob asks you to perform Q operations on this array.

You have to perform three types of query, in each query you are given three integers x, y and z.

if x = 1: Update the value of A[y] to 2 * A[y] + 1.
if x = 2: Update the value A[y] to ⌊A[y]/2⌋ , where ⌊⌋ is The Greatest Integer Function.
if x = 3: Take all the A[i] such that y <= i <= z and convert them into their corresponding binary strings. Now concatenate all the binary strings and find the total no. of '1' in the resulting string.
Queries are denoted by a 2-D array B of size M x 3 where B[i][0] denotes x, B[i][1] denotes y, B[i][2] denotes z.


Problem Constraints
1 <= N, Q <= 100000
1 <= y, z <= N
1 <= x <= 3

Input Format
The first argument has the integer A.
The second argument is a 2d matrix B, of size Q x 3, representing the queries.

Output Format
Return an array of integers where ith index represents the answer of the ith type 3 query.

Example Input
Input 1:
 A = 5
 B = [
        [1, 1, -1]
        [1, 2, -1]
        [1, 3, -1]
        [3, 1, 3]
        [3, 2, 4]
     ]
Input 2:
 A = 5
 B = [
        [1, 1, -1]
        [1, 2, -1]
        [3, 1, 3]
        [2, 1, -1]
        [3, 1, 3]
     ]

Example Output:
Output 1:
 [3, 2]
Output 2:
 [2, 1]

Example Explanation:
Explanation 1:
 Initial array A = [0, 0, 0, 0, 0]
 After query 1, A => [1, 0, 0, 0, 0]
 After query 2, A => [1, 1, 0, 0, 0]
 After query 3, A => [1, 1, 1, 0, 0]
 For query 4, Concatenation of Binary String between index 1 and 3 : 111. So, number of 1's = 3
 For query 5, Concatenation of Binary String between index 2 and 4 : 110. So, number of 1's = 2
 So, output array is [3, 2].

Explanation 2:
 Initial array A = [0, 0, 0, 0, 0]
 After query 1, A => [1, 0, 0, 0, 0]
 After query 2, A => [1, 1, 0, 0, 0]
 For query 3, Concatenation of Binary String between index 1 and 3 : 110. So, number of 1's = 2
 After query 4, A => [0, 1, 0, 0, 0]
 For query 5, Concatenation of Binary String between index 2 and 4 : 010. So, number of 1's = 1.
 So, output array is [2, 1].
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class q2_Bob_and_Queries {

    public static void main(String[] args) {
        q2_Bob_and_Queries t = new q2_Bob_and_Queries();
        {
            int A = 5;
            int[][] B = {{1, 1, -1}, {1, 2, -1}, {1, 3, -1}, {3, 1, 3}, {3, 2, 4}};
            System.out.println(Arrays.toString(t.solve(A, B))); // [3, 2]
        }
        {
            int A = 5;
            int[][] B = {{1, 1, -1}, {1, 2, -1}, {3, 1, 3}, {2, 1, -1}, {3, 1, 3}};
            System.out.println(Arrays.toString(t.solve(A, B))); // [2, 1]
        }
    }

    public int[] solve(int A, int[][] B) {
        // just initialize segment tree, no need to build as initially all elements are 0
        // and hence count of set bits will also be 0
        int[] seg = new int[4 * A];

        List<Integer> list = new ArrayList<>();
        for (int[] q : B) {
            int x = q[0];
            int y = q[1] - 1;
            int z = q[2] - 1;
            if (x == 1) {
                // update count = count + 1 at index y
                update(0, 0, A - 1, y, true, seg);
            } else if (x == 2) {
                // update count = max(count -1, 0) at index y
                update(0, 0, A - 1, y, false, seg);
            } else {
                // query - count sum of all set bits for a range
                int count = query(0, 0, A - 1, y, z, seg);
                list.add(count);
            }
        }
        return list.stream().mapToInt(i -> i).toArray();
    }

    public int query(int currIndex, int start, int end, int l, int r, int[] seg) {
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
        int leftCount = query(leftChildIndex, start, mid, l, r, seg);
        int rightCount = query(rightChildIndex, mid + 1, end, l, r, seg);
        return leftCount + rightCount;
    }

    public void update(int currIndex, int start, int end, int index, boolean isTypeOne, int[] seg) {
        // update the value
        if (start == end) {
            seg[currIndex] = isTypeOne ? seg[currIndex] + 1 : Math.max(seg[currIndex] - 1, 0);
            return;
        }
        int mid = start + (end - start) / 2;
        int leftChildIndex = 2 * currIndex + 1;
        int rightChildIndex = 2 * currIndex + 2;
        if (index <= mid) {
            update(leftChildIndex, start, mid, index, isTypeOne, seg);
        } else {
            update(rightChildIndex, mid + 1, end, index, isTypeOne, seg);
        }
        // keep updating the bits count in the traversed path as the value is changed
        seg[currIndex] = seg[leftChildIndex] + seg[rightChildIndex];
    }

}

/*
Solution Approach
For each node in a segment tree, you could store the number of 1s in the binary representation of the numbers stored in them.

For type 1 query, the number of 1s increase by 1.
For type 2 query, the number of 1s decrease by 1 but make sure to keep them greater than or equal to 0.
For type 3 query, you can simply return a range sum query over the required indices.
 */
