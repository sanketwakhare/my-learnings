/* N max pair combinations */

/* Problem Description
Given two integers arrays, A and B, of size N each.

Find the maximum N elements from the sum combinations (Ai + Bj) formed from elements in arrays A and B.



Problem Constraints
1 <= N <= 2 * 10^5

-1000 <= A[i], B[i] <= 1000



Input Format
The first argument is an integer array A.
The second argument is an integer array B.



Output Format
Return an integer array denoting the N maximum element in descending order.



Example Input
Input 1:

 A = [1, 4, 2, 3]
 B = [2, 5, 1, 6]
Input 2:

 A = [2, 4, 1, 1]
 B = [-2, -3, 2, 4]


Example Output
Output 1:

 [10, 9, 9, 8]
Output 2:

 [8, 6, 6, 5]


Example Explanation
Explanation 1:

 4 maximum elements are 10(6+4), 9(6+3), 9(5+4), 8(6+2).
Explanation 2:

 4 maximum elements are 8(4+4), 6(4+2), 6(4+2), 5(4+1). */

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * TC: O(n log n) - Heap operations and sorting
 * SC: O(n)
 */
public class hw_q2_N_max_pair_combinations {

    class Pair {
        int p1, p2;

        public Pair(int p1, int p2) {
            this.p1 = p1;
            this.p2 = p2;
        }

        @Override
        public boolean equals(Object o) {
            if (o == null) {
                return false;
            }
            Pair p = (Pair) o;
            return (p.p1 == p1 && p.p2 == p2);
        }

        @Override
        public int hashCode() {
            return Objects.hash(p1, p2);
        }
    }

    class HeapNode {
        int sum, p1, p2;

        public HeapNode(int sum, int p1, int p2) {
            this.sum = sum;
            this.p1 = p1;
            this.p2 = p2;
        }
    }

    class HeapComparator implements Comparator<HeapNode> {
        @Override
        public int compare(HeapNode o1, HeapNode o2) {
            return o2.sum - o1.sum;
        }
    }

    public int[] solve(int[] A, int[] B) {

        // sort the arrays
        Arrays.sort(A);
        Arrays.sort(B);

        // maintain set to identify we are not inserting duplicate pair
        Set<String> pairs = new HashSet<String>();
        // maxHeap
        PriorityQueue<HeapNode> maxHeap = new PriorityQueue<HeapNode>(new HeapComparator());

        // take kast 2 elements and insert into heap as this will always be maximum
        int p1 = A.length - 1;
        int p2 = B.length - 1;
        // insert pair into set
        pairs.add(p1 + "" + p2);
        maxHeap.add(new HeapNode(A[p1] + B[p2], p1, p2));

        // initialize result array
        int[] result = new int[A.length];
        int k = 0;

        for (int i = 0; i < A.length; i++) {

            // insert the max sum into result array
            HeapNode maxNode = maxHeap.poll();
            result[k++] = maxNode.sum;

            // decrement p2 index and keep p1 same
            int temp_p1 = maxNode.p1;
            int temp_p2 = maxNode.p2 - 1;
            if (temp_p1 >= 0 && temp_p2 >= 0 && !pairs.contains(temp_p1 + "" + temp_p2)) {
                pairs.add(temp_p1 + "" + temp_p2);
                maxHeap.add(new HeapNode(A[temp_p1] + B[temp_p2], temp_p1, temp_p2));
            }

            // decrement p1 index and keep p2 same
            temp_p1 = maxNode.p1 - 1;
            temp_p2 = maxNode.p2;
            if (temp_p1 >= 0 && temp_p2 >= 0 && !pairs.contains(temp_p1 + "" + temp_p2)) {
                pairs.add(temp_p1 + "" + temp_p2);
                maxHeap.add(new HeapNode(A[temp_p1] + B[temp_p2], temp_p1, temp_p2));
            }
        }
        return result;
    }

    public static void main(String[] args) {

        hw_q2_N_max_pair_combinations t1 = new hw_q2_N_max_pair_combinations();
        int[] A, B, output;

        {
            A = new int[] { 1, 4, 2, 3 };
            B = new int[] { 2, 5, 1, 6 };
            output = t1.solve(A, B);
            ArrayUtils.printArray(output); // [ 10, 9, 9, 8 ]
        }
        {
            A = new int[] { 2, 4, 1, 1 };
            B = new int[] { -2, -3, 2, 4 };
            output = t1.solve(A, B);
            ArrayUtils.printArray(output); // [ 8, 6, 6, 5 ]
        }
        {
            A = new int[] { -12, 0, 5 };
            B = new int[] { 42, -45, -29 };
            output = t1.solve(A, B);
            ArrayUtils.printArray(output); // [ 47, 42, 30 ]
        }
    }
}
