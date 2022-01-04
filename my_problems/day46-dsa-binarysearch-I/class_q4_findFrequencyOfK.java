/**
 * Given a sorted array of N elements, Find the frequency of element K
 * 
 * Iteration: 2(logN) each for first and last occurrence
 * TC: O(logN)
 */
public class class_q4_findFrequencyOfK {

    /**
     * Find first occurrence index of K
     */
    public static int findFirstOccurrenceIndex(int[] A, int K) {
        int l = 0;
        int r = A.length - 1;

        int firstOccurrenceIndex = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (A[mid] == K) {
                // update answer as this mid can be the first occurrence but this is not sure
                firstOccurrenceIndex = mid;
                // check for first occurrence on left side
                r = mid - 1;
            } else if (A[mid] > K) {
                // check on left side
                r = mid - 1;
            } else {
                // check on right side
                l = mid + 1;
            }
        }
        return firstOccurrenceIndex;
    }

    /**
     * Find last occurrence index of K
     */
    public static int findLastOccurrenceIndex(int[] A, int K) {
        int l = 0;
        int r = A.length - 1;

        int lastOccurrenceIndex = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (A[mid] == K) {
                // update answer as this mid can be the last occurrence but this is not sure
                lastOccurrenceIndex = mid;
                // check for last occurrence on right side
                l = mid + 1;
            } else if (A[mid] > K) {
                // check on left side
                r = mid - 1;
            } else {
                // check on right side
                l = mid + 1;
            }
        }
        return lastOccurrenceIndex;
    }

    public static int frequencyOfK(int[] A, int K) {

        // find first occurrence of K
        int firstOccurrenceIndex = findFirstOccurrenceIndex(A, K);

        // find last occurrence of K
        int lastOccurrenceIndex = findLastOccurrenceIndex(A, K);

        // return frequency -> last occurrence index - first occurrence index + 1
        int frequency = lastOccurrenceIndex - firstOccurrenceIndex + 1;
        if (frequency < 0) {
            frequency = 0;
        }
        return frequency;

    }

    public static void main(String[] args) {
        int[] input1 = { 3, 5, 5, 5, 6, 6, 9, 12, 12, 14, 14, 14, 14, 19, 19, 20, 23, 25, 27 };
        int out = frequencyOfK(input1, 6);
        System.out.println(out);
        int[] input2 = { -5, -5, -3, 0, 0, 1, 1, 5, 5, 5, 5, 5, 5, 5, 8, 10, 10, 15, 15 };
        out = frequencyOfK(input2, 5);
        System.out.println(out);
    }
}
