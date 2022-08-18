import java.util.*;

public class ReduceArraySizeToHalf {

    public static void main(String[] args) {
        ReduceArraySizeToHalf t1 = new ReduceArraySizeToHalf();
        int res = t1.minSetSize(new int[]{3, 3, 3, 3, 5, 5, 5, 2, 2, 7});
        System.out.println(res);
        res = t1.minSetSize(new int[]{3, 5, 2, 2, 7, 9, 9, 8, 8, 10, 11, 3, 4, 2});
        System.out.println(res);
    }

    public int minSetSize(int[] arr) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int ele : arr) {
            int currFreq = freqMap.getOrDefault(ele, 0);
            freqMap.put(ele, currFreq + 1);
        }
        Map<Integer, List<Integer>> map = new TreeMap<>(Collections.reverseOrder());
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            List<Integer> list = map.getOrDefault(value, new ArrayList<>());
            list.add(key);
            map.put(value, list);
        }

        int n = arr.length;
        int expectedSize = n / 2;
        int count = 0;
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            int freq = entry.getKey();
            List<Integer> list = entry.getValue();
            if (freq * list.size() <= expectedSize) {
                expectedSize -= freq * list.size();
                count += list.size();
            } else {
                int size = list.size();
                while (size >= 0 && expectedSize > 0) {
                    expectedSize -= freq;
                    count += 1;
                    size--;
                }
            }
            if (expectedSize <= 0) break;
        }
        return count;
    }
}
