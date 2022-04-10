import java.util.ArrayList;
import java.util.List;

/* Special Median */

/* Problem Description

You are given an array A containing N numbers. This array is called special if it satisfies one of the following properties:

There exists an element A[i] in the array such that A[i] is equal to the median of elements [A[0], A[1], ...., A[i-1]]
There exists an element A[i] in the array such that A[i] is equal to the median of elements [A[i+1], A[i+2], ...., A[N-1]]
Median is the middle element in the sorted list of elements. If the number of elements are even then median will be (sum of both middle elements)/2.

Return 1 if the array is special else return 0.

NOTE:
For A[0] consider only the median of elements [A[1], A[2], …, A[N-1]] (as there are no elements to the left of it)
For A[N-1] consider only the median of elements [A[0], A[1], …., A[N-2]]


Problem Constraints
1 <= N <= 1000000.
A[i] is in the range of a signed 32-bit integer.



Input Format
First and only argument is an integer array A.



Output Format
Return 1 if the given array is special else return 0.


Example Input

Input 1:
 A = [4, 6, 8, 4]
Input 2:
 A = [2, 7, 3, 1]


Example Output

Output 1:
 1
Output 2:
 0

Example Explanation

Explanation 1:

 Here, 6 is equal to the median of [8, 4].
Explanation 2:

 No element satisfies any condition. */

/**
 * TC: O(N * N logN)
 * SC: O(N)
 */
public class hw_q3_Special_Median {

    public int solve(int[] A) {

        MinHeap minHeap = new MinHeap();
        MaxHeap maxHeap = new MaxHeap();

        // find if there exist a median matching with A[i] on left of A[i]
        for (int i = 0; i < A.length; i++) {
            boolean isMedianFound = isMedianFound(maxHeap, minHeap, i, A);
            if (isMedianFound) {
                return 1;
            }
        }
        minHeap.clear();
        maxHeap.clear();

        // find if there exist a median matching with A[i] on right of A[i]
        for (int i = A.length - 1; i >= 0; i--) {
            boolean isMedianFound = isMedianFound(maxHeap, minHeap, i, A);
            if (isMedianFound) {
                return 1;
            }
        }

        return 0;

    }

    private boolean isMedianFound(hw_q3_Special_Median.MaxHeap maxHeap, hw_q3_Special_Median.MinHeap minHeap, int i,
            int[] A) {

        if (maxHeap.isEmpty()) {
            maxHeap.add(A[i]);
        } else {
            // calculate median
            int size1 = maxHeap.size();
            int size2 = minHeap.size();

            int median = Integer.MAX_VALUE;
            if ((size1 + size2) % 2 == 0) {
                // if combines size of both the heaps is even
                int sum = minHeap.peekMin() + maxHeap.peekMax();
                if (sum % 2 == 0) {
                    // consider median only when sum is completely divisible by 2
                    median = sum / 2;
                }
            } else {
                // if combined size of both the heaps is odd
                if (size1 > size2) {
                    median = maxHeap.peekMax();
                } else {
                    median = minHeap.peekMin();
                }
            }
            // if median is matching with current element
            if (median == A[i])
                return true;

            // add element into eligible heap so that both the heaps are balanced
            if (A[i] > maxHeap.peekMax()) {
                minHeap.add(A[i]);
                if (Math.abs(minHeap.size() - maxHeap.size()) > 1) {
                    maxHeap.add(minHeap.getMin());
                }
            } else {
                maxHeap.add(A[i]);
                if (Math.abs(minHeap.size() - maxHeap.size()) > 1) {
                    minHeap.add(maxHeap.getMax());
                }
            }
        }
        return false;
    }

    class MinHeap {
        List<Integer> heap;

        public MinHeap() {
            heap = new ArrayList<Integer>();
        }

        public int size() {
            return heap.size();
        }

        public boolean isEmpty() {
            if (heap.size() == 0)
                return true;
            return false;
        }

        public void add(int x) {
            if (heap.isEmpty()) {
                heap.add(x);
            } else {
                heap.add(x);
                int x_index = heap.size() - 1;
                int p_index = (x_index - 1) / 2;
                while (heap.get(x_index) < heap.get(p_index)) {
                    // if parent is < than x
                    // swap parent and x
                    int temp = heap.get(x_index);
                    heap.set(x_index, heap.get(p_index));
                    heap.set(p_index, temp);

                    // update x_index
                    x_index = p_index;
                    p_index = (x_index - 1) / 2;
                }
            }
        }

        public int getMin() {
            if (heap.isEmpty()) {
                return -1;
            }
            // swap last element with min
            int min = heap.get(0);

            // swap first and last elements
            int x = heap.get(heap.size() - 1);
            heap.set(0, x);
            heap.remove(heap.size() - 1);

            int p_index = 0;
            while (p_index * 2 + 1 < heap.size()) {
                int l_index = p_index * 2 + 1;
                int r_index = p_index * 2 + 2;

                int min_put_of_3 = Math.min(heap.get(p_index), heap.get(l_index));
                if (r_index < heap.size()) {
                    min_put_of_3 = Math.min(min_put_of_3, heap.get(r_index));
                }

                if (min_put_of_3 == heap.get(p_index)) {
                    break;
                } else if (min_put_of_3 == heap.get(l_index)) {
                    int temp = heap.get(p_index);
                    heap.set(p_index, heap.get(l_index));
                    heap.set(l_index, temp);
                    p_index = l_index;
                } else if (min_put_of_3 == heap.get(r_index) && r_index < heap.size()) {
                    int temp = heap.get(p_index);
                    heap.set(p_index, heap.get(r_index));
                    heap.set(r_index, temp);
                    p_index = r_index;
                }
            }

            return min;
        }

        public int peekMin() {
            if (heap.isEmpty()) {
                return -1;
            }
            return heap.get(0);
        }

        public void clear() {
            heap.clear();
        }

    }

    class MaxHeap {
        List<Integer> heap;

        public MaxHeap() {
            heap = new ArrayList<Integer>();
        }

        public int size() {
            return heap.size();
        }

        public boolean isEmpty() {
            if (heap.size() == 0)
                return true;
            return false;
        }

        public void add(int x) {
            if (heap.isEmpty()) {
                heap.add(x);
            } else {
                heap.add(x);
                int x_index = heap.size() - 1;
                int p_index = (x_index - 1) / 2;
                while (heap.get(x_index) > heap.get(p_index)) {
                    // if parent is < than x
                    // swap parent and x
                    int temp = heap.get(x_index);
                    heap.set(x_index, heap.get(p_index));
                    heap.set(p_index, temp);

                    // update x_index
                    x_index = p_index;
                    p_index = (x_index - 1) / 2;
                }
            }
        }

        public int getMax() {
            if (heap.isEmpty()) {
                return -1;
            }
            // swap last element with min
            int max = heap.get(0);

            // swap first and last elements
            int x = heap.get(heap.size() - 1);
            heap.set(0, x);
            heap.remove(heap.size() - 1);

            int p_index = 0;
            while (p_index * 2 + 1 < heap.size()) {
                int l_index = p_index * 2 + 1;
                int r_index = p_index * 2 + 2;

                int max_put_of_3 = Math.max(heap.get(p_index), heap.get(l_index));
                if (r_index < heap.size()) {
                    max_put_of_3 = Math.max(max_put_of_3, heap.get(r_index));
                }

                if (max_put_of_3 == heap.get(p_index)) {
                    break;
                } else if (max_put_of_3 == heap.get(l_index)) {
                    int temp = heap.get(p_index);
                    heap.set(p_index, heap.get(l_index));
                    heap.set(l_index, temp);
                    p_index = l_index;
                } else if (max_put_of_3 == heap.get(r_index) && r_index < heap.size()) {
                    int temp = heap.get(p_index);
                    heap.set(p_index, heap.get(r_index));
                    heap.set(r_index, temp);
                    p_index = r_index;
                }
            }

            return max;
        }

        public int peekMax() {
            if (heap.isEmpty()) {
                return -1;
            }
            return heap.get(0);
        }

        public void clear() {
            heap.clear();
        }

    }

    public static void main(String[] args) {

        hw_q3_Special_Median t1 = new hw_q3_Special_Median();
        int[] A;

        // {
        // A = new int[] { 4, 6, 8, 4 };
        // System.out.println(t1.solve(A));
        // }
        // {
        // A = new int[] { 2, 7, 3, 1 };
        // System.out.println(t1.solve(A));
        // }
        // {
        // A = new int[] { 4, 14, 4, 15, 9, 8, 2, 10, 4, 3 };
        // System.out.println(t1.solve(A));
        // }
        {
            A = new int[] { 2147483647, -2147483648, 0 };
            System.out.println(t1.solve(A));
        }
    }

}
