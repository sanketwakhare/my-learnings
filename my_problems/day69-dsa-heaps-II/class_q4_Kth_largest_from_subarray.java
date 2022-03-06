import MinHeapGenericsImpl.MinHeap;

/* Find Kth largest element from every subarray starting with 0 
i.e. from index [0 to i]
*/

/* Idea : use MinHeap of size K */
/**
 * TC: O(N logK)
 * SC: O(K)
 */
public class class_q4_Kth_largest_from_subarray {

    public int[] kthLargest(int[] A, int k) {

        /*
         * maintain a minHeap of size K
         * insert only when
         * a) when heap size < K
         * b) when new element is > min element from heap
         */
        MinHeap<Integer> minHeap = new MinHeap<Integer>();
        int[] output = new int[A.length];
        int index = 0;
        for (int i = 0; i < A.length; i++) {
            if (minHeap.size() < k) {
                // a) when heap size < K
                minHeap.insert(A[i]);
                if (minHeap.size() == k) {
                    output[index++] = minHeap.peekMin();
                } else {
                    output[index++] = -1;
                }
            } else {
                // b) when new element is > min element from heap
                if (A[i] > minHeap.peekMin()) {
                    minHeap.getMinimum();
                    minHeap.insert(A[i]);
                }
                output[index++] = minHeap.peekMin();
            }
        }
        return output;

    }

    public static void main(String[] args) {
        class_q4_Kth_largest_from_subarray t1 = new class_q4_Kth_largest_from_subarray();
        int[] A = new int[] { 7, 13, 1, 2, 5, 7, 6, 8, 2, 10, 3, 14 };
        System.out.print("\ninput array: ");
        ArrayUtils.printArray(A);

        int K = 3;
        int[] output = t1.kthLargest(A, K);
        System.out.print("output array: ");
        ArrayUtils.printArray(output); // [ -1, -1, 1, 2, 5, 7, 7, 7, 7, 8, 8, 10 ]

        K = 4;
        output = t1.kthLargest(A, K);
        System.out.print("output array: ");
        ArrayUtils.printArray(output); // [ -1, -1, -1, 1, 2, 5, 6, 7, 7, 7, 7, 8 ]

        A = new int[] { 1, 2, 3, 4, 5, 6 };
        System.out.print("\ninput array: ");
        ArrayUtils.printArray(A);
        K = 4;
        output = t1.kthLargest(A, K);
        System.out.print("output array: ");
        ArrayUtils.printArray(output); // [-1, -1, -1, 1, 2, 3]

        A = new int[] { 15, 20, 99, 1 };
        System.out.print("\ninput array: ");
        ArrayUtils.printArray(A);
        K = 2;
        output = t1.kthLargest(A, K);
        System.out.print("output array: ");
        ArrayUtils.printArray(output); // [-1, 15, 20, 20]

    }

}
