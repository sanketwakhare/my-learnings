/**
 * Container With Most Water
 * 
 * Problem Description
 * 
 * Given n non-negative integers A[0], A[1], …, A[n-1] , where each represents a
 * point at coordinate (i, A[i]).
 * N vertical lines are drawn such that the two endpoints of line i is at (i,
 * A[i]) and (i, 0).
 * Find two lines, which together with x-axis forms a container, such that the
 * container contains the most water.
 * Note: You may not slant the container.
 * 
 * Problem Constraints
 * 0 <= N <= 10^5
 * 1 <= A[i] <= 10^5
 * 
 * Input Format
 * Single Argument representing a 1-D array A.
 * 
 * Output Format
 * Return single Integer denoting the maximum area you can obtain.
 * 
 * Example Input
 * Input 1:
 * A = [1, 5, 4, 3]
 * Input 2:
 * A = [1]
 * 
 * Example Output
 * Output 1:
 * 6
 * Output 2:
 * 0
 * 
 * Example Explanation
 * Explanation 1:
 * 
 * 5 and 3 are distance 2 apart. So size of the base = 2. Height of container =
 * min(5, 3) = 3.
 * So total area = 3 * 2 = 6
 * Explanation 2:
 * 
 * No container is formed.
 */

/**
 * TC: O(N)
 * SC: O(1)
 * Idea: use area of rectangle formula
 * 
 */
public class q3_ContainerWithMostWater {
    public static int findContainerAreaWithMostWater(int[] A) {

        // initialize pointers each at two ends
        int i = 0;
        int j = A.length - 1;

        // initialize initial water accumulation
        int answer = 0;

        while (i < j) {

            // find area of container
            int diff = j - i;
            int min = Math.min(A[i], A[j]);
            int area = diff * min;

            // update answer
            answer = Math.max(answer, area);

            // move pointer ti left or right for min element out of two
            if (A[i] < A[j]) {
                i++;
            } else {
                j--;
            }

        }
        System.out.println("answer: " + answer);
        return answer;

    }

    public static void main(String[] args) {

        int[] A1 = { 6, 2, 7, 4, 5 };
        findContainerAreaWithMostWater(A1);

        int[] A2 = { 1, 5, 4, 3 };
        findContainerAreaWithMostWater(A2);

        int[] A3 = { 1 };
        findContainerAreaWithMostWater(A3);

        int[] A4 = { 3, 5, 4, 7, 3, 6, 5, 4, 1, 2 };
        findContainerAreaWithMostWater(A4);

    }
}
