import MinHeapGenericsImpl.MinHeap;

/* Find Kth largest element in an array */

/**
 * TC: O(N*logK)
 * SC: O(K) - max heap size
 */
public class class_q3_Kth_Largest_in_array {

    public int kthLargest(int[] A, int k) {

        /*
         * maintain a minHeap of size K
         * insert only when
         * a) when heap size < K
         * b) when new element is > min element from heap
         */
        MinHeap<Integer> minHeap = new MinHeap<Integer>();
        for (int i = 0; i < A.length; i++) {
            if (minHeap.size() < k) {
                minHeap.insert(A[i]);
            } else {
                if (A[i] > minHeap.peekMin()) {
                    minHeap.getMinimum();
                    minHeap.insert(A[i]);
                }
            }
        }
        return minHeap.peekMin();

    }

    public static void main(String[] args) {
        class_q3_Kth_Largest_in_array t1 = new class_q3_Kth_Largest_in_array();
        int[] A = new int[] { 7, 13, 1, 2, 5, 7, 6, 8, 2, 10, 3, 14 };
        System.out.print("\ninput array: ");
        ArrayUtils.printArray(A);
        int K = 3;
        System.out.println(t1.kthLargest(A, K)); // 10
        System.out.println(t1.kthLargest(A, 5)); // 7
        System.out.println(t1.kthLargest(A, 2)); // 13
        System.out.println(t1.kthLargest(A, 8)); // 5
    }

}
