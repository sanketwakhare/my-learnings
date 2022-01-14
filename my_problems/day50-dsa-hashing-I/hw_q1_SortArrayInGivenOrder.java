import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* Sort Array in given Order */

/**
 * Problem Description
 * 
 * Given two array of integers A and B, Sort A in such a way that the relative
 * order among the elements will be the same as those are in B. For the elements
 * not present in B, append them at last in sorted order.
 * 
 * Return the array A after sorting from the above method.
 * 
 * NOTE: Elements of B are unique.
 * 
 * Problem Constraints
 * 1 <= length of the array A <= 100000
 * 1 <= length of the array B <= 100000
 * -10^9 <= A[i] <= 10^9
 * 
 * 
 * Input Format
 * The first argument given is the integer array A.
 * The second argument given is the integer array B.
 * 
 * Output Format
 * Return the array A after sorting as described.
 * 
 * Example Input
 * 
 * Input 1:
 * A = [1, 2, 3, 4, 5]
 * B = [5, 4, 2]
 * Input 2:
 * A = [5, 17, 100, 11]
 * B = [1, 100]
 * 
 * Example Output
 * Output 1:
 * [5, 4, 2, 1, 3]
 * Output 2:
 * [100, 5, 11, 17]
 * 
 * Example Explanation
 * Explanation 1:
 * Simply sort as described.
 * Explanation 2:
 * Simply sort as described.
 */

/**
 * TC: O(N logN + M) for sorting A
 * SC: O(N) for hashmap
 */
public class hw_q1_SortArrayInGivenOrder {

    public static int[] sortArrayInGivenOrder(int[] A, int[] B) {

        int N = A.length;

        // initialize output array
        int[] output = new int[N];
        int index = 0;

        // Generate map for array A
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < N; i++) {
            int currentEle = A[i];
            if (!map.containsKey(currentEle)) {
                map.put(currentEle, 1);
            } else {
                int freq = map.get(currentEle);
                map.put(currentEle, freq + 1);
            }
        }

        // iterate over array B and check if B[i] is present in map
        // and put B[i] in output array
        for (int i = 0; i < B.length; i++) {
            if (map.containsKey(B[i])) {
                int freq = map.get(B[i]);
                while (freq > 0) {
                    output[index++] = B[i];
                    freq--;
                }
                // remove element from map
                map.remove(B[i]);
            }
        }

        // maintain list of remaining elements which are not present in array B and sort
        List<Integer> list = new ArrayList<Integer>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            // System.out.println(entry.getKey() + ":" + entry.getValue());
            int freq = entry.getValue();
            while (freq > 0) {
                list.add(entry.getKey());
                freq--;
            }
        }
        // sort the list
        Object[] remArray = list.toArray();
        Arrays.sort(remArray);

        // push remaining elements from list into output array
        for (int i = 0; i < remArray.length; i++) {
            output[index++] = (int) remArray[i];
        }

        // print output
        String str = "";
        for (int i = 0; i < output.length; i++) {
            str += output[i] + " ";
        }
        System.out.println(str);

        return output;
    }

    public static void main(String[] args) {

        int[] A1 = { 1, 2, 3, 4, 5 };
        int[] B1 = { 5, 4, 2 };
        int[] output1 = sortArrayInGivenOrder(A1, B1); // expected output [5, 4, 2, 1, 3]
        System.out.println("answer -> " + output1);

        int[] A2 = { 5, 17, 100, 11 };
        int[] B2 = { 1, 100 };
        int[] output2 = sortArrayInGivenOrder(A2, B2); // expected output [100, 5, 11, 17]
        System.out.println("answer -> " + output2);

        int[] A3 = { 2, 2, 3, 4, 4 };
        int[] B3 = { 1, 2, 3 };
        int[] output3 = sortArrayInGivenOrder(A3, B3); // expected output [2, 2, 3, 4, 4]
        System.out.println("answer -> " + output3);
    }

}
