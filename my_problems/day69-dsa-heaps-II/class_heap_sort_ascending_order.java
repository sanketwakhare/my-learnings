/* Sort the array in ascending order using Heap sort */

/* Heap Sort*/
/**
 * TC: O(N log N)
 * SC: O(1)
 */
public class class_heap_sort_ascending_order {

    public void sort(int[] A) {

        // step 1
        // find no of leaves
        int leafCount = (A.length + 1) / 2;
        // and generate max heap in constant space within same array
        for (int i = A.length - leafCount - 1; i >= 0; i--) {
            heapify(A, i, A.length);
        }
        System.out.print("After converting array to MaxHeap: ");
        ArrayUtils.printArray(A);

        // step 2: now extract A[0] and push into correct sorted position
        int i = A.length;
        while (i >= 0) {
            getMaximum(A, i);
            i--;
        }

        System.out.print("Sorted array: ");
        ArrayUtils.printArray(A);
    }

    public void heapify(int[] A, int i, int size) {
        while ((2 * i) + 1 < size) {
            int leftChildIndex = (2 * i) + 1;
            int rightChildIndex = (2 * i) + 2;

            int max = Math.max(A[i], A[leftChildIndex]);
            if (rightChildIndex < size) {
                max = Math.max(max, A[rightChildIndex]);
            }

            if (A[i] == max) {
                return;
            } else if (A[leftChildIndex] == max) {
                swap(A, i, leftChildIndex);
                i = leftChildIndex;
            } else if (rightChildIndex < size && A[rightChildIndex] == max) {
                swap(A, i, rightChildIndex);
                i = rightChildIndex;
            }
        }
    }

    public void getMaximum(int[] A, int size) {

        if (size > 0) {
            // swap A[0] and A[last]
            swap(A, 0, size - 1);
            // apply heapify on remaining elements
            size--;
            if (size > 1) {
                heapify(A, 0, size);
            }
        }
    }

    private void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    public static void main(String[] args) {
        class_heap_sort_ascending_order t1 = new class_heap_sort_ascending_order();
        int[] A = new int[] { 7, 13, 1, 2, 5, 7, 6, 8, 2, 10, 3, 14 };
        System.out.print("\ninput array: ");
        ArrayUtils.printArray(A);
        t1.sort(A);

        A = new int[] { 5, 3, 4, 7, 8, 1, 10, 9 };
        System.out.print("\ninput array: ");
        ArrayUtils.printArray(A);
        t1.sort(A);

        A = new int[] { 50, 30 };
        System.out.print("\ninput array: ");
        ArrayUtils.printArray(A);
        t1.sort(A);
    }
}
