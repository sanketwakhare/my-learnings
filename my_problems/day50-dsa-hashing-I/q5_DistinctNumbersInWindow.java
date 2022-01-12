import java.util.HashMap;
import java.util.Map;

/**
 * Distinct Numbers in Window
 * 
 * Problem Description
 * You are given an array of N integers, A1, A2 ,…, AN and an integer B. Return
 * the of count of distinct numbers in all windows of size B.
 * Formally, return an array of size N-B+1 where i'th element in this array
 * contains number of distinct elements in sequence Ai, Ai+1 ,..., Ai+B-1.
 * 
 * NOTE: if B > N, return an empty array.
 * 
 * Input Format
 * First argument is an integer array A
 * Second argument is an integer B.
 * 
 * Output Format
 * Return an integer array.
 * 
 * Example Input
 * Input 1:
 * A = [1, 2, 1, 3, 4, 3]
 * B = 3
 * Input 2:
 * A = [1, 1, 2, 2]
 * B = 1
 * 
 * Example Output
 * Output 1:
 * [2, 3, 3, 2]
 * Output 2:
 * [1, 1, 1, 1]
 * 
 * Example Explanation
 * 
 * Explanation 1:
 * 
 * A=[1, 2, 1, 3, 4, 3] and B = 3
 * All windows of size B are
 * [1, 2, 1]
 * [2, 1, 3]
 * [1, 3, 4]
 * [3, 4, 3]
 * So, we return an array [2, 3, 3, 2].
 * Explanation 2:
 * 
 * Window size is 1, so the output array is [1, 1, 1, 1].
 */

/**
 * Using sliding window + hashMap
 * TC: O(N)
 * SC: O(B) ~ O(N)
 */
public class q5_DistinctNumbersInWindow {
    public static int[] distinctNumbersInWIndow(int[] A, int B) {

        int N = A.length;
        if (B > N) {
            return new int[0];
        }

        // we have to apply sliding window technique using hashMap

        // create/maintain a hashMap of size window
        // hashmap will store the element and its frequency, if frequency is 0, entry
        // would be deleted from hashmap
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        // add elements from first window to hashMap
        for (int i = 0; i < B; i++) {
            if (!map.containsKey(A[i])) {
                map.put(A[i], 1);
            } else {
                int currentFreq = map.get(A[i]);
                map.put(A[i], currentFreq + 1);
            }
        }
        // now HashMap size will provide us the no of distinct elements in a window of
        // size B
        // initialize answer array with size of hashMap
        int[] answer = new int[N - B + 1];
        int index = 0;
        answer[index++] = map.size();

        // for check for every window of size B
        for (int i = 1; i < N - B + 1; i++) {

            int eleToAdd = A[i - 1 + B];
            if (map.containsKey(eleToAdd)) {
                int currFreqOfEleToAdd = map.get(eleToAdd);
                // increment freq of eleToAdd by 1
                map.put(eleToAdd, currFreqOfEleToAdd + 1);
            } else {
                // add entry to map
                map.put(eleToAdd, 1);
            }

            int eleToDelete = A[i - 1];
            if (map.containsKey(eleToDelete)) {
                int currFreqOfEleToDelete = map.get(eleToDelete);
                if (currFreqOfEleToDelete == 1) {
                    // remove entry from map
                    map.remove(eleToDelete);
                } else {
                    // decrement freq of eleToDelete by 1
                    map.put(eleToDelete, currFreqOfEleToDelete - 1);
                }
            }
            answer[index++] = map.size();
        }

        String out = "";
        for (int i = 0; i < answer.length; i++) {
            out += answer[i] + " ";
        }
        System.out.println(out);
        return answer;
    }

    public static void main(String[] args) {
        int[] input1 = { 1, 2, 1, 3, 4, 3 };
        int[] output1 = distinctNumbersInWIndow(input1, 3); // expected output [2, 3, 3, 2]
        System.out.println("answer -> " + output1);
        int[] input2 = { 1, 1, 2, 2 };
        int[] output2 = distinctNumbersInWIndow(input2, 1); // expected output [1, 1, 1, 1]
        System.out.println("answer -> " + output2);
    }

}
