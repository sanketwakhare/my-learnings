import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class RateLimiter {

    public int[] solve(int[] A, int[] B) {
        Map<Integer, LinkedList<Integer>> requestsMap = new HashMap<>();
        int[] result = new int[A.length];
        int MAX_REQUESTS = 3;
        int TIME_WINDOW = 10;
        for (int i = 0; i < A.length; i++) {
            int userId = A[i];
            int currTime = B[i];
            LinkedList<Integer> clientRequests = requestsMap.getOrDefault(userId, new LinkedList<>());
            // remove all requests out of the current window
            while (!clientRequests.isEmpty() && clientRequests.getFirst() <= currTime - TIME_WINDOW) {
                clientRequests.removeFirst();
            }

            // deny if threshold is reached
            if (clientRequests.size() >= MAX_REQUESTS) {
                result[i] = 0;
            } else {
                // if threshold is not yet reached, allow request to be processed
                clientRequests.add(currTime);
                requestsMap.put(userId, clientRequests);
                result[i] = 1;
            }
        }
        System.out.println(Arrays.toString(result));
        return result;
    }

    public static void main(String[] args) {
        int[] A = new int[]{181, 181, 859, 245, 181, 859, 859, 700, 181, 859, 859, 700, 181, 700, 245, 859, 859, 470, 470, 181, 245, 700, 859, 700, 700, 181, 859, 181, 470, 470, 859, 700, 859, 181, 245, 470, 245, 470, 700, 859, 181, 470, 470, 700, 470, 859, 245, 859, 245, 245, 470, 181, 700, 245, 859, 181, 245};
        int[] B = new int[]{2, 4, 5, 5, 6, 8, 10, 12, 12, 14, 15, 17, 18, 18, 20, 20, 21, 21, 21, 21, 21, 23, 24, 24, 25, 26, 27, 28, 30, 31, 32, 34, 34, 35, 37, 38, 39, 41, 41, 41, 42, 44, 45, 47, 49, 50, 52, 52, 54, 55, 55, 57, 57, 58, 58, 59, 61};
        RateLimiter rateLimiter = new RateLimiter();
        int[] result = rateLimiter.solve(A, B);
        // expected answer
        // [1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0]

        A = new int[]{1, 1, 2, 1, 1, 1};
        B = new int[]{1, 2, 2, 9, 10, 11};
        result = rateLimiter.solve(A, B);
        // expected answer
        // [1, 1, 1, 1, 0, 1]

        A = new int[]{2, 2, 2, 2};
        B = new int[]{3, 3, 8, 12};
        result = rateLimiter.solve(A, B);
        // expected answer
        // [1, 1, 1, 0]
    }
}
