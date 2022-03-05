/* Max Heap Implementation */

/**
 * TC: O(N log N)
 * SC: O(N)
 */
public class class_MaxHeap_approach1 {
    class MaxHeap {
        int[] heap;
        int size;

        public MaxHeap(int size) {
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
                    if (heap[i] > heap[parentIndex]) {
                        swap(i, parentIndex);
                        i = parentIndex;
                    } else {
                        return;
                    }
                }
            }
        }

        public int getMaximum() {
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
                    int max = Math.max(heap[leftChildIndex], heap[i]);
                    if (rightChildIndex < size) {
                        max = Math.max(max, heap[rightChildIndex]);
                    }

                    if (max == heap[i]) {
                        break;
                    } else if (max == heap[leftChildIndex]) {
                        swap(i, leftChildIndex);
                        i = leftChildIndex;
                    } else if (rightChildIndex < size && max == heap[rightChildIndex]) {
                        swap(i, rightChildIndex);
                        i = rightChildIndex;
                    }
                }
            }
            return x;
        }

        public int peekMax() {
            if (!isEmpty()) {
                return heap[0];
            }
            return -1;
        }

        private void swap(int i, int j) {
            int temp = heap[i];
            heap[i] = heap[j];
            heap[j] = temp;
        }

    }

    public static void main(String[] args) {
        int[] A = new int[] { 24, 34, 13, 20, 25, 22, 29, 5, 12 };
        MaxHeap maxHeap = new class_MaxHeap_approach1().new MaxHeap(A.length);
        for (int i = 0; i < A.length; i++) {
            maxHeap.insert(A[i]);
        }
        printArray(maxHeap.getHeap());
        while (!maxHeap.isEmpty()) {
            System.out.println(maxHeap.getMaximum());
        }
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
