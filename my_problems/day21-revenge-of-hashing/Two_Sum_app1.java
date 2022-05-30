import java.util.HashMap;
import java.util.Map;

/* 2 Sum */
/* Approach 1 -with HashMap with frequencies */
public class Two_Sum_app1 {

    public int[] twoSum(int[] nums, int target) {
        // Build HashMap with frequencies
        Map<Integer, Integer> map = new HashMap<>();
        for (int ele : nums) {
            int freq = map.getOrDefault(ele, 0);
            map.put(ele, freq + 1);
        }

        int[] output = new int[2];
        int secondEle = 0;
        // find target - nums[i] in HashMap
        for (int i = 0; i < nums.length; i++) {
            int ele = nums[i];
            int key = target - ele;
            if (map.containsKey(key)) {
                if (key == ele) {
                    if (map.get(key) > 1) {
                        output[0] = i;
                        secondEle = key;
                        break;
                    }
                } else {
                    output[0] = i;
                    secondEle = key;
                    break;
                }
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == secondEle && i != output[0]) {
                output[1] = i;
                break;
            }
        }
        return output;
    }

    public static void main(String[] args) {
        Two_Sum_app1 t1 = new Two_Sum_app1();
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
