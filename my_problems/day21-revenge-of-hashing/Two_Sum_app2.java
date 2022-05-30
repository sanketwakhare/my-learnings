import java.util.HashMap;
import java.util.Map;

/* Approach 1 -with HashMap with frequencies */
public class Two_Sum_app2 {

    public int[] twoSum(int[] A, int target) {
        // Build HashMap on the Fly
        // HashMap<Element, Index>
        int[] output = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            int firstEle = A[i];
            int secondEle = target - firstEle;
            if (map.containsKey(secondEle)) {
                output[0] = i;
                output[1] = map.get(secondEle);
                break;
            }
            map.put(firstEle, i);
        }

        return output;
    }

    public static void main(String[] args) {
        Two_Sum_app2 t1 = new Two_Sum_app2();
        int[] A, out;
        int target;
        {
            A = new int[] { 2, 7, 11, 15 };
            target = 9;
            out = t1.twoSum(A, target);
            ArrayUtils.printArray(out); // [0, 1]
        }
        {
            A = new int[] { 3, 3 };
            target = 6;
            out = t1.twoSum(A, target);
            ArrayUtils.printArray(out); // [0, 1]
        }
    }
}
