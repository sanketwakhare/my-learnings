/* Connect ropes */

/* Problem Description

Given an array of integers A representing the length of ropes.

You need to connect these ropes into one rope. The cost of connecting two ropes is equal to the sum of their lengths.

Find and return the minimum cost to connect these ropes into one rope.

Problem Constraints
1 <= length of the array <= 100000
1 <= A[i] <= 1000

Input Format
The only argument given is the integer array A.

Output Format
Return an integer denoting the minimum cost to connect these ropes into one rope.

Example Input
Input 1:
 A = [1, 2, 3, 4, 5]
Input 2:
 A = [5, 17, 100, 11]

Example Output
Output 1:
 33
Output 2:
 182

Example Explanation
Explanation 1:
 Given array A = [1, 2, 3, 4, 5].
 Connect the ropes in the following manner:
 1 + 2 = 3
 3 + 3 = 6
 4 + 5 = 9
 6 + 9 = 15

 So, total cost  to connect the ropes into one is 3 + 6 + 9 + 15 = 33.

Explanation 2:
 Given array A = [5, 17, 100, 11].
 Connect the ropes in the following manner:
 5 + 11 = 16
 16 + 17 = 33
 33 + 100 = 133

 So, total cost  to connect the ropes into one is 16 + 33 + 133 = 182. */

/** Build Min Heap */
/** Approach 1: build using insert() method and using extra space */
public class q1_connect_ropes {

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

    public static void main(String[] args) {
        int[] A = new int[] { 24, 34, 13, 20, 25, 22, 29, 5, 12 };

        MinHeap minHeap = new q1_connect_ropes().new MinHeap(A.length);
        // build minHeap
        for (int i = 0; i < A.length; i++) {
            minHeap.insert(A[i]);
        }
        printArray(minHeap.getHeap());
        int cost = 0;
        while (minHeap.getSize() > 1) {
            int x = minHeap.getMinimum();
            int y = minHeap.getMinimum();
            cost += (x + y);
            minHeap.insert(x + y);
        }
        System.out.println("cost: " + cost);
    }

    private static void printArray(int[] A) {
        System.out.print("[ ");
        int i = 0;
        for (int temp : A) {
            if (i == A.length - 1)
                System.out.print(temp);
            else
                System.out.print(temp + ", ");
            i++;
        }
        System.out.print(" ]");
        System.out.println();
    }

}
