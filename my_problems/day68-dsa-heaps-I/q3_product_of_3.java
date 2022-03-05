/* Product of 3 */

/* Problem Description

Given an integer array A of size N.

You have to find the product of the 3 largest integers in array A from range 1 to i, where i goes from 1 to N.

Return an array B where B[i] is the product of the largest 3 integers in range 1 to i in array A. If i < 3, then the integer at index i is -1.

Problem Constraints
1 <= N <= 10^5
0 <= A[i] <= 10^3

Input Format
First and only argument is an integer array A.

Output Format
Return an integer array B. B[i] denotes the product of the largest 3 integers in range 1 to i in array A.

Example Input

Input 1:

 A = [1, 2, 3, 4, 5]
Input 2:

 A = [10, 2, 13, 4]


Example Output

Output 1:

 [-1, -1, 6, 24, 60]
Output 2:

 [-1, -1, 260, 520]


Example Explanation

Explanation 1:

 For i = 1, ans = -1
 For i = 2, ans = -1
 For i = 3, ans = 1 * 2 * 3 = 6
 For i = 4, ans = 2 * 3 * 4 = 24
 For i = 5, ans = 3 * 4 * 5 = 60

 So, the output is [-1, -1, 6, 24, 60].
 
Explanation 2:

 For i = 1, ans = -1
 For i = 2, ans = -1
 For i = 3, ans = 10 * 2 * 13 = 260
 For i = 4, ans = 10 * 13 * 4 = 520

 So, the output is [-1, -1, 260, 520]. */

/* Use Min heap of size 3 and extract product of 3 elements on each iteration*/
public class q3_product_of_3 {

    public static int[] solve(int[] A) {

        int[] output = new int[A.length];
        if (output.length < 3) {
            for (int i = 0; i < output.length; i++) {
                output[i] = -1;
            }
            return output;
        }
        // initialize output
        for (int i = 0; i < 2; i++) {
            output[i] = -1;
        }
        // create MinHeap of size 3
        MinHeap heap = new q3_product_of_3().new MinHeap(3);
        // insert first 2 elements into max heap
        for (int i = 0; i < 3; i++) {
            heap.insert(A[i]);
            int currProd = heap.productOfThree();
            output[i] = currProd;
        }
        for (int i = 3; i < A.length; i++) {
            int currMin = heap.peekMin();
            if (A[i] > currMin) {
                // extract and insert
                heap.getMinimum();
                heap.insert(A[i]);
            }
            int currProd = heap.productOfThree();
            output[i] = currProd;
        }
        return output;

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

        public int peekMin() {
            if (!isEmpty()) {
                return heap[0];
            }
            return -1;
        }

        public int productOfThree() {
            if (!isEmpty() && this.size >= 3) {
                return heap[0] * heap[1] * heap[2];
            }
            return -1;
        }
    }

    public static void main(String[] args) {

        int[] A = { 1, 2, 3, 4, 5 };
        int[] output = solve(A);
        ArrayUtils.printArray(output); // [ -1, -1, 6, 24, 60 ]

        A = new int[] { 10, 2, 13, 4 };
        output = solve(A);
        ArrayUtils.printArray(output); // [ -1, -1, 260, 520 ]
    }
}
