import java.util.HashMap;
import java.util.Map;

/* Distinct Numbers in Window */
public class q4_Distinct_Numbers_In_Window {
    public int[] dNums(int[] A, int B) {
        int n = A.length;
        int totalWindows = n - B + 1;
        int[] output = new int[totalWindows];
        int j = 0;

        // Maintain HashMap with frequencies count as value
        Map<Integer, Integer> map = new HashMap<>();
        // first window
        for (int i = 0; i < B; i++) {
            int freq = map.getOrDefault(A[i], 0);
            map.put(A[i], freq + 1);
        }
        // update answer for first window
        output[j++] = map.size();

        // for remaining windows, update same HashMap after removing previous element
        // and adding new element from window
        for (int i = 1; i < n - B + 1; i++) {
            int eleToRemove = A[i - 1];
            int eleToInsert = A[B + i - 1];

            // insert frequency of new element
            int freq = map.getOrDefault(eleToInsert, 0);
            map.put(eleToInsert, freq + 1);

            // remove frequency of element which is getting removed from window
            freq = map.get(eleToRemove);
            if (freq == 1)
                map.remove(eleToRemove);
            else
                map.put(eleToRemove, freq - 1);

            // update output array
            output[j++] = map.size();
        }
        return output;
    }

    public static void main(String[] args) {
        q4_Distinct_Numbers_In_Window t1 = new q4_Distinct_Numbers_In_Window();
        int[] A, out;
        {
            A = new int[] { 1, 2, 1, 3, 4, 3 };
            out = t1.dNums(A, 3);
            ArrayUtils.printArray(out); // [ 2, 3, 3, 2 ]
        }
        {
            A = new int[] { 1, 1, 2, 2 };
            out = t1.dNums(A, 1);
            ArrayUtils.printArray(out); // [ 1, 1, 1, 1 ]
        }
    }
}
