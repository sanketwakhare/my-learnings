import MinHeapGenericsImpl.MinHeap;

/* K places apart
Given an nearly sorted array A, 
where every element in an array is almost K position away from its sorted position.
Sort the given array.
*/
/**
 * TC: O(N * log K)
 * SC: O(K)
 */
public class class_q6_sort_nearly_sorted_array {

    public void sortArray(int[] A, int K) {

        // insert first K+1 elements into MinHeap
        MinHeap<Integer> minHeap = new MinHeap<Integer>();
        int i = 0;
        int index = 0;
        for (; i < A.length && i <= K; i++) {
            minHeap.insert(A[i]);
        }

        // extractMin and insert new element
        for (; i < A.length; i++) {
            A[index++] = minHeap.getMinimum();
            minHeap.insert(A[i]);
        }

        // extract all remaining elements from heap
        while (!minHeap.isEmpty()) {
            A[index++] = minHeap.getMinimum();
        }
    }

    public static void main(String[] args) {

        class_q6_sort_nearly_sorted_array t1 = new class_q6_sort_nearly_sorted_array();

        int[] A = new int[] { 2, 3, 7, 1, 6, 5, 9, 12, 8, 14, 10 };
        System.out.print("\ninput array: ");
        ArrayUtils.printArray(A);
        int K = 3;
        t1.sortArray(A, K);
        System.out.print("output array: ");
        ArrayUtils.printArray(A); // [ -1, -1, 13, 7, 5, 5, 5, 5, 2, 2, 2, 2 ]

        A = new int[] { 1, 40, 2, 3 };
        System.out.print("\ninput array: ");
        ArrayUtils.printArray(A);
        K = 2;
        t1.sortArray(A, K);
        System.out.print("output array: ");
        ArrayUtils.printArray(A); // [ 1, 2, 3, 40 ]

        A = new int[] { 2, 1, 17, 10, 21, 95 };
        System.out.print("\ninput array: ");
        ArrayUtils.printArray(A);
        K = 1;
        t1.sortArray(A, K);
        System.out.print("output array: ");
        ArrayUtils.printArray(A); // [ 1, 2, 10, 17, 21, 95 ]

        A = new int[] { 25, 16, 11, 31, 28, 20, 3, 8 };
        System.out.print("\ninput array: ");
        ArrayUtils.printArray(A);
        K = 6;
        t1.sortArray(A, K);
        System.out.print("output array: ");
        ArrayUtils.printArray(A); // [ 3, 8, 11, 16, 20, 25, 28, 31 ]

    }

}
