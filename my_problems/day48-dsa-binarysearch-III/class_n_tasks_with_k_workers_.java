/***
 * Given N tasks and K workers
 * Array A represents N tasks
 * A[i] represents time taken to complete ith task
 * Find minimum time taken to complete all tasks
 * Conditions:
 * #one task can only be completed by one worker
 * #a worker can only do continuous tasks
 * #workers can work in parallel
 */

public class class_n_tasks_with_k_workers_ {

    /**
     * find min time to complete all tasks
     * 
     * @param A array of integers
     * @param K no of workers
     * @return minimum time
     */
    public static int findMinTime(int[] A, int K) {

        int N = A.length;
        int answer = 0;

        // apply Binary Search on value range
        int max = A[0];
        int sum = A[0];
        for (int i = 1; i < N; i++) {
            max = Math.max(A[i], max);
            sum += A[i];
        }
        // start range would be max value from array
        int l = max;
        // end range would be sum of array
        int r = sum;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (check(A, K, mid)) {
                // update possible answer
                answer = mid;
                // check for min value on left of mid
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return answer;
    }

    // TC: O(N)
    private static boolean check(int[] A, int K, int mid) {

        int currentTime = A[0];
        int worker = 1;
        for (int i = 1; i < A.length; i++) {
            if (currentTime + A[i] > mid) {
                // re initialize the time with A[i] for new worker
                worker++;
                currentTime = A[i];
            } else {
                // add time required to complete the current task A[i]
                currentTime += A[i];
            }
        }
        if (worker <= K) {
            // task can be done with K workers with time mid
            return true;
        }
        return false;
    }

    public static void main(String[] args) {

        int[] input1 = { 3, 5, 1, 7, 8, 2, 5, 3, 10, 1, 4, 7, 5, 4, 6 };
        int output1 = findMinTime(input1, 3); // expected output 25
        System.out.println("answer -> " + output1);
    }

}
