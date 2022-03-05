/* Min Heap implementation with constant space */
// meaning we need to modify the input array A as heap

public class class_MinHeap_approach2_constant_space {

    /**
     * bubble up the min element every time and traverse till end top to bottom
     */
    public static void minHeapify(int[] heap, int i) {

        while ((2 * i) + 1 < heap.length) {

            int leftChildIndex = (2 * i) + 1;
            int rightChildIndex = (2 * i) + 2;

            // find min out of 3 elements
            int min = Math.min(heap[leftChildIndex], heap[i]);
            if (rightChildIndex < heap.length) {
                min = Math.min(min, heap[rightChildIndex]);
            }

            if (min == heap[i]) {
                return;
            } else if (min == heap[leftChildIndex]) {
                // swap left child element with current root
                swap(heap, i, leftChildIndex);
                i = leftChildIndex;
            } else if (rightChildIndex < heap.length && min == heap[rightChildIndex]) {
                // swap right child element with current root
                swap(heap, i, rightChildIndex);
                i = rightChildIndex;
            }
        }

    }

    /**
     * bubble up the max element every time and traverse till end top to bottom
     */
    public static void maxHeapify(int[] heap, int i) {

        while ((2 * i) + 1 < heap.length) {

            int leftChildIndex = (2 * i) + 1;
            int rightChildIndex = (2 * i) + 2;

            // find min out of 3 elements
            int max = Math.max(heap[leftChildIndex], heap[i]);
            if (rightChildIndex < heap.length) {
                max = Math.max(max, heap[rightChildIndex]);
            }

            if (max == heap[i]) {
                return;
            } else if (max == heap[leftChildIndex]) {
                // swap left child element with current root
                swap(heap, i, leftChildIndex);
                i = leftChildIndex;
            } else if (rightChildIndex < heap.length && max == heap[rightChildIndex]) {
                // swap right child element with current root
                swap(heap, i, rightChildIndex);
                i = rightChildIndex;
            }
        }

    }

    public static void swap(int heap[], int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    public static void main(String[] args) {
        int[] A = new int[] { 24, 34, 13, 20, 25, 22, 29, 5, 12 };
        ArrayUtils.printArray(A);
        // find count of leaves
        int totalLeaves = (A.length + 1) / 2;
        for (int i = A.length - 1 - totalLeaves; i >= 0; i--) {
            minHeapify(A, i);
        }
        System.out.print("minHeap: ");
        ArrayUtils.printArray(A);

        A = new int[] { 15, 45, 32, 9, 17, 6, 30, 26, 75, 38 };
        ArrayUtils.printArray(A);
        // find count of leaves
        totalLeaves = (A.length + 1) / 2;
        for (int i = A.length - 1 - totalLeaves; i >= 0; i--) {
            maxHeapify(A, i);
        }
        System.out.print("maxHeap: ");
        ArrayUtils.printArray(A);
    }

}
