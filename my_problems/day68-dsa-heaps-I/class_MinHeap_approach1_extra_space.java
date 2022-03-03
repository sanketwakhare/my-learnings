/* Min Heap Implementation using arrays */

/** Build Min Heap */
/** Approach 1: build using insert() method and using extra space */
/**
 * TC: O(N log N)
 * SC: O(N)
 */
public class class_MinHeap_approach1_extra_space {

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
        MinHeap minHeap = new class_MinHeap_approach1_extra_space().new MinHeap(A.length);
        for (int i = 0; i < A.length; i++) {
            minHeap.insert(A[i]);
        }
        printArray(minHeap.getHeap());
        while (!minHeap.isEmpty()) {
            System.out.println(minHeap.getMinimum());
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
