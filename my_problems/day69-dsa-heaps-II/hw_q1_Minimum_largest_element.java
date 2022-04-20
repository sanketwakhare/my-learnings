import java.util.Comparator;
import java.util.PriorityQueue;

/* Minimum largest element */

/* Problem Description
Given an array A of N numbers, you have to perform B operations. In each operation, you have to pick any one of the N elements and add the original value(value stored at the index before we did any operations) to its current value. You can choose any of the N elements in each operation.

Perform B operations in such a way that the largest element of the modified array(after B operations) is minimized.
Find the minimum possible largest element after B operations.


Problem Constraints
1 <= N <= 10^6
0 <= B <= 10^5
-10^5 <= A[i] <= 10^5


Input Format
The first argument is an integer array A.
The second argument is an integer B.



Output Format
Return an integer denoting the minimum possible largest element after B operations.



Example Input
Input 1:

 A = [1, 2, 3, 4] 
 B = 3
Input 2:

 A = [5, 1, 4, 2] 
 B = 5


Example Output
Output 1:

 4
Output 2:

 5


Example Explanation
Explanation 1:

 Apply operation on element at index 0, the array would change to [2, 2, 3, 4]
 Apply operation on element at index 0, the array would change to [3, 2, 3, 4]
 Apply operation on element at index 0, the array would change to [4, 2, 3, 4]
 Minimum possible largest element after 3 operations is 4.
Explanation 2:

 Apply operation on element at index 1, the array would change to [5, 2, 4, 2]
 Apply operation on element at index 1, the array would change to [5, 3, 4, 2]
 Apply operation on element at index 1, the array would change to [5, 4, 4, 2]
 Apply operation on element at index 1, the array would change to [5, 5, 4, 2]
 Apply operation on element at index 3, the array would change to [5, 5, 4, 4]
 Minimum possible largest element after 5 operations is 5. */

public class hw_q1_Minimum_largest_element {

    class Pair {
        int value;
        int originalValue;

        public Pair(int value) {
            this.value = value;
            this.originalValue = value;
        }

        public int peekUpdatedValue() {
            return this.value + this.originalValue;
        }

        public void updateValue() {
            this.value = this.value + this.originalValue;
        }
    }

    class PairComparator implements Comparator<Pair> {
        @Override
        public int compare(Pair o1, Pair o2) {
            return (o1.value + o1.originalValue) - (o2.value + o2.originalValue);
        }
    }

    public int solve(int[] A, int B) {

        // initialize max value
        int max = A[0];
        // Maintain a MinHeap of Pair
        PriorityQueue<Pair> minHeap = new PriorityQueue<Pair>(new PairComparator());
        // build minHeap and find max
        for (int i = 0; i < A.length; i++) {
            minHeap.add(new Pair(A[i]));
            max = Math.max(A[i], max);
        }

        // perform B operations
        for (int i = 0; i < B; i++) {
            // retrieve pair from minHeap
            Pair curr = minHeap.poll();
            if (curr.peekUpdatedValue() > max) {
                // update max
                max = Math.max(max, curr.peekUpdatedValue());
            }
            // perform operation
            curr.updateValue();
            // insert the updated value into heap
            minHeap.add(curr);
        }

        return max;
    }

    public static void main(String[] args) {

        hw_q1_Minimum_largest_element t1 = new hw_q1_Minimum_largest_element();
        int[] A;
        int B;
        {
            A = new int[] { 1, 2, 3, 4 };
            B = 3;
            System.out.println(t1.solve(A, B)); // 4
        }
        {
            A = new int[] { 5, 1, 4, 2 };
            B = 5;
            System.out.println(t1.solve(A, B)); // 5
        }
        {
            A = new int[] { 8, 6, 2, 4, 10 };
            B = 8;
            System.out.println(t1.solve(A, B)); // 12
        }

    }
}