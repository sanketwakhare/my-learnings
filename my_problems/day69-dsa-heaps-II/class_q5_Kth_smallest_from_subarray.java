import MaxHeapGenericsImpl.MaxHeap;

/* Find Kth smallest element from every subarray starting with 0 
i.e. from index [0 to i]
*/

/* Idea : use MaxHeap of size K */
/**
 * TC: O(N logK)
 * SC: O(K)
 */
public class class_q5_Kth_smallest_from_subarray {
    public int[] kthLargest(int[] A, int k) {

        /*
         * maintain a maxHeap of size K
         * insert only when
         * a) when heap size < K
         * b) when new element is < max element from heap
         */
        MaxHeap<Integer> maxHeap = new MaxHeap<Integer>();
        int[] output = new int[A.length];
        int index = 0;
        for (int i = 0; i < A.length; i++) {
            if (maxHeap.size() < k) {
                // a) when heap size < K
                maxHeap.insert(A[i]);
                if (maxHeap.size() == k) {
                    output[index++] = maxHeap.peekMax();
                } else {
                    output[index++] = -1;
                }
            } else {
                // b) when new element is < max element from heap
                if (A[i] < maxHeap.peekMax()) {
                    maxHeap.getMaximum();
                    maxHeap.insert(A[i]);
                }
                output[index++] = maxHeap.peekMax();
            }
        }
        return output;

    }

    public static void main(String[] args) {
        class_q5_Kth_smallest_from_subarray t1 = new class_q5_Kth_smallest_from_subarray();
        int[] A = new int[] { 7, 13, 1, 2, 5, 7, 6, 8, 2, 10, 3, 14 };
        System.out.print("\ninput array: ");
        ArrayUtils.printArray(A);

        int K = 3;
        int[] output = t1.kthLargest(A, K);
        System.out.print("output array: ");
        ArrayUtils.printArray(output); // [ -1, -1, 13, 7, 5, 5, 5, 5, 2, 2, 2, 2 ]

        K = 4;
        output = t1.kthLargest(A, K);
        System.out.print("output array: ");
        ArrayUtils.printArray(output); // [ -1, -1, -1, 13, 7, 7, 6, 6, 5, 5, 3, 3 ]

        A = new int[] { 10, 20, 3, 4, 15, 6 };
        System.out.print("\ninput array: ");
        ArrayUtils.printArray(A);
        K = 4;
        output = t1.kthLargest(A, K);
        System.out.print("output array: ");
        ArrayUtils.printArray(output); // [ -1, -1, -1, 20, 15, 10 ]

        A = new int[] { 15, 20, 99, 1 };
        System.out.print("\ninput array: ");
        ArrayUtils.printArray(A);
        K = 2;
        output = t1.kthLargest(A, K);
        System.out.print("output array: ");
        ArrayUtils.printArray(output); // [ -1, 20, 20, 15 ]

    }

}
