import MaxHeapGenericsImpl.MaxHeap;
import MinHeapGenericsImpl.MinHeap;

/* Given Infinite Stream of integers, find Median of the current set of integer elements */

/**
 * Idea: use min and max heap to balance the contents
 * TC: O(N logN)
 * SC: O(N)
 */
public class class_q7_findMedian_InfiniteStream {

    public int[] findMedian(int[] A) {

        int[] output = new int[A.length];
        MaxHeap<Integer> maxHeap = new MaxHeap<Integer>();
        MinHeap<Integer> minHeap = new MinHeap<Integer>();

        int index = 0;
        for (int i = 0; i < A.length; i++) {
            // insert into maxHeap if empty
            if (maxHeap.isEmpty()) {
                maxHeap.insert(A[i]);
            } else {
                if (A[i] < maxHeap.peekMax()) {
                    // insert into maxHeap
                    maxHeap.insert(A[i]);
                    if (maxHeap.size() - minHeap.size() > 1) {
                        // if size(maxHeap) - size(minHeap) > 1, insert top element from maxHeap into
                        // minHeap
                        minHeap.insert(maxHeap.getMaximum());
                    }
                } else {
                    // insert into minHeap
                    minHeap.insert(A[i]);
                    if (minHeap.size() > maxHeap.size()) {
                        // if size(minHeap) > size(minHeap), insert top element from minHeap into
                        // maxHeap
                        maxHeap.insert(minHeap.getMinimum());
                    }
                }
            }
            output[index++] = maxHeap.peekMax();
        }
        return output;
    }

    public static void main(String[] args) {

        class_q7_findMedian_InfiniteStream t1 = new class_q7_findMedian_InfiniteStream();
        int[] A = new int[] { 2, 3, 7, 1, 6, 5, 9, 12, 8, 14, 10 };
        System.out.print("\ninput array: ");
        ArrayUtils.printArray(A);
        int[] output = t1.findMedian(A);
        System.out.print("output array: ");
        ArrayUtils.printArray(output); // [ 2, 2, 3, 2, 3, 3, 5, 5, 6, 6, 7 ]

        A = new int[] { 1, 2, 5, 4, 3 };
        System.out.print("\ninput array: ");
        ArrayUtils.printArray(A);
        output = t1.findMedian(A);
        System.out.print("output array: ");
        ArrayUtils.printArray(output); // [ 1, 1, 2, 2, 3 ]

        A = new int[] { 5, 17, 100, 11 };
        System.out.print("\ninput array: ");
        ArrayUtils.printArray(A);
        output = t1.findMedian(A);
        System.out.print("output array: ");
        ArrayUtils.printArray(output); // [ 5, 5, 17, 11 ]

    }

}
