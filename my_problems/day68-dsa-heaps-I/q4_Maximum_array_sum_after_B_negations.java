/* Maximum array sum after B negations */

/* Problem Description

Given an array of integers A and an integer B. You must modify the array exactly B number of times. In single modification, we can replace any one array element A[i] by -A[i].

You need to perform these modifications in such a way that after exactly B modifications, sum of the array must be maximum.


Problem Constraints
1 <= length of the array <= 5*10^5
1 <= B <= 5 * 10^6
-100 <= A[i] <= 100

Input Format

First argument given is an integer array A.
Second argument given is an integer B.



Output Format

Return an integer denoting the maximum array sum after B modifications.



Example Input

Input 1:
 A = [24, -68, -29, -9, 84]
 B = 4

Input 2:
 A = [57, 3, -14, -87, 42, 38, 31, -7, -28, -61]
 B = 10

Example Output

Output 1:
 196

Output 2:
 362

Example Explanation

Explanation 1:

 Final array after B modifications = [24, 68, 29, -9, 84]
Explanation 2:

 Final array after B modifications = [57, -3, 14, 87, 42, 38, 31, 7, 28, 61] */

public class q4_Maximum_array_sum_after_B_negations {

    public static int solve(int[] A, int B) {
        // Idea: build a min heap and for every iteration remove min and insert its
        // negation into heap
        // after all the iteration is complete. extract every element from heap and
        // return total sum.

        MinHeap heap = new q4_Maximum_array_sum_after_B_negations().new MinHeap(A.length);
        // build heap
        for (int i = 0; i < A.length; i++) {
            heap.insert(A[i]);
        }
        // perform B operation
        for (int i = 0; i < B; i++) {
            int min = heap.getMinimum();
            int x = -min;
            heap.insert(x);
        }

        // get total sum of remaining elements in heap
        int sum = 0;
        while (!heap.isEmpty()) {
            sum += heap.getMinimum();
        }
        return sum;
    }

    public static void main(String[] args) {

        int[] A = { 24, -68, -29, -9, 84 };
        int output = solve(A, 4);
        System.out.println(output); // 196

        A = new int[] { 57, 3, -14, -87, 42, 38, 31, -7, -28, -61 };
        output = solve(A, 10);
        System.out.println(output); // 362
    }

    class MinHeap {
        int[] heap;
        int size;

        public MinHeap(int size) {
            this.heap = new int[size];
            this.size = 0;
        }

        public int getSize() {
            return size;
        }

        public int[] getHeap() {
            return this.heap;
        }

        public boolean isEmpty() {
            if (this.size == 0) {
                return true;
            }
            return false;
        }

        public boolean isFull() {
            if (this.size == heap.length) {
                return true;
            }
            return false;
        }

        public void insert(int x) {

            // insert x into last position
            if (!isFull()) {
                heap[size] = x;
                size++;

                int i = size - 1;
                while (i > 0) {
                    int parentIndex = (i - 1) / 2;
                    if (heap[i] < heap[parentIndex]) {
                        swap(i, parentIndex);
                        i = parentIndex;
                    } else {
                        return;
                    }
                }
            }
        }

        public int getMinimum() {
            int x = -1;
            if (!isEmpty()) {
                x = heap[0];
                // swap last element and x
                swap(0, size - 1);
                heap[size - 1] = -1;
                size--;

                int i = 0;

                while ((2 * i) + 1 < size) {
                    int leftChildIndex = (2 * i) + 1;
                    int rightChildIndex = (2 * i) + 2;
                    int min = Math.min(heap[leftChildIndex], heap[i]);
                    if (rightChildIndex < size) {
                        min = Math.min(min, heap[rightChildIndex]);
                    }

                    if (min == heap[i]) {
                        break;
                    } else if (min == heap[leftChildIndex]) {
                        swap(i, leftChildIndex);
                        i = leftChildIndex;
                    } else if (rightChildIndex < size && min == heap[rightChildIndex]) {
                        swap(i, rightChildIndex);
                        i = rightChildIndex;
                    }
                }

            }
            return x;
        }

        private void swap(int i, int j) {
            int temp = heap[i];
            heap[i] = heap[j];
            heap[j] = temp;
        }

    }

}
