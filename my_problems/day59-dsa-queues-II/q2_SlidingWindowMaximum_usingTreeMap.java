import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/* Sliding Window Maximum */

/***
 * Problem Description
 * 
 * Given an array of integers A. There is a sliding window of size B which is
 * moving from the very left of the array to the very right. You can only see
 * the B numbers in the window. Each time the sliding window moves rightwards by
 * one position. You have to find the maximum for each window.
 * 
 * Return an array C, where C[i] is the maximum value in the array from A[i] to
 * A[i+B-1].
 * 
 * Refer to the given example for clarity.
 * NOTE: If B > length of the array, return 1 element with the max of the array.
 * 
 * Problem Constraints
 * 1 <= |A|, B <= 106
 * 
 * Input Format
 * The first argument given is the integer array A.
 * The second argument given is the integer B.
 * 
 * Output Format
 * Return an array C, where C[i] is the maximum value of from A[i] to A[i+B-1].
 * 
 * Example Input
 * Input 1:
 * A = [1, 3, -1, -3, 5, 3, 6, 7]
 * B = 3
 * Input 2:
 * A = [1, 2, 3, 4, 2, 7, 1, 3, 6]
 * B = 6
 * 
 * Example Output
 * 
 * Output 1:
 * [3, 3, 5, 5, 6, 7]
 * Output 2:
 * [7, 7, 7, 7]
 * 
 * Example Explanation
 * Explanation 1:
 * Window position | Max
 * --------------------|-------
 * [1 3 -1] -3 5 3 6 7 | 3
 * 1 [3 -1 -3] 5 3 6 7 | 3
 * 1 3 [-1 -3 5] 3 6 7 | 5
 * 1 3 -1 [-3 5 3] 6 7 | 5
 * 1 3 -1 -3 [5 3 6] 7 | 6
 * 1 3 -1 -3 5 [3 6 7] | 7
 * 
 * Explanation 2:
 * Window position | Max
 * --------------------|-------
 * [1 2 3 4 2 7] 1 3 6 | 7
 * 1 [2 3 4 2 7 1] 3 6 | 7
 * 1 2 [3 4 2 7 1 3] 6 | 7
 * 1 2 3 [4 2 7 1 3 6] | 7
 */

/**
 * using sliding window + treeMap approach
 * TC: O(N logK)
 * SC: O(N)
 */
public class q2_SlidingWindowMaximum_usingTreeMap {

    /* This approach uses the TreeMap + sliding window */
    /* TC: O(N logK) */
    /* SC: O(N) */

    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public static ArrayList<Integer> slidingMaximum(final List<Integer> A, int B) {

        // use approach of TreeMap and sliding window
        TreeMap<Integer, Integer> treeMap = new TreeMap<Integer, Integer>();
        ArrayList<Integer> output = new ArrayList<Integer>();

        // for first window, update treeMap with frequencies
        for (int i = 0; i < B; i++) {
            int currentEle = A.get(i);
            if (treeMap.containsKey(currentEle)) {
                treeMap.put(currentEle, treeMap.get(currentEle) + 1);
            } else {
                treeMap.put(currentEle, 1);
            }
        }
        // update max value in output
        output.add(treeMap.lastKey());

        // for remaining windows, perform same operations
        for (int i = 1; i <= A.size() - B; i++) {
            int eleToRemove = A.get(i - 1);
            int eleToAdd = A.get(i + B - 1);

            // remove (i-1)th element
            Integer currFreq = treeMap.get(eleToRemove);
            if (currFreq == 1) {
                // remove entry from map
                treeMap.remove(eleToRemove);
            } else {
                // decrement entry
                treeMap.put(eleToRemove, currFreq - 1);
            }

            // add (i+B-1)th element
            if (treeMap.containsKey(eleToAdd)) {
                treeMap.put(eleToAdd, treeMap.get(eleToAdd) + 1);
            } else {
                treeMap.put(eleToAdd, 1);
            }

            // update answer at every step
            output.add(treeMap.lastKey());

        }

        return output;
    }

    public static void print(ArrayList<Integer> list) {
        System.out.println();
        for (int temp : list) {
            System.out.print(temp + " ");
        }
    }

    public static void main(String[] args) {

        // test case 1
        List<Integer> A1 = new ArrayList<Integer>();
        A1.add(1);
        A1.add(3);
        A1.add(-1);
        A1.add(-3);
        A1.add(5);
        A1.add(3);
        A1.add(6);
        A1.add(7);
        int B1 = 3;
        ArrayList<Integer> output = slidingMaximum(A1, B1);
        print(output); // expected output [3,3,5,5,6,7]

        // test case 2
        List<Integer> A2 = new ArrayList<Integer>();
        A2.add(1);
        A2.add(2);
        A2.add(3);
        A2.add(4);
        A2.add(2);
        A2.add(7);
        A2.add(1);
        A2.add(3);
        A2.add(6);
        int B2 = 6;
        ArrayList<Integer> output2 = slidingMaximum(A2, B2);
        print(output2); // expected output [7,7,7,7]

    }

}
