import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// Binary Trees With Factors
// https://leetcode.com/problems/binary-trees-with-factors/

public class NumFactoredBinaryTrees {

    public static void main(String[] args) {
        NumFactoredBinaryTrees t1 = new NumFactoredBinaryTrees();
        System.out.println(t1.numFactoredBinaryTrees(new int[]{2, 4}));
        System.out.println(t1.numFactoredBinaryTrees(new int[]{2, 4, 5, 10}));
        System.out.println(t1.numFactoredBinaryTrees(new int[]{2, 3, 6, 4, 5, 10}));
        System.out.println(t1.numFactoredBinaryTrees(new int[]{2, 3, 6, 4, 5, 12}));
    }

    public int numFactoredBinaryTrees(int[] arr) {
        int n = arr.length;
        Map<Integer, Long> map = new HashMap<>();
        Arrays.sort(arr);

        long result = 0;
        long p = (long) 1e9 + 7;

        for (int i = 0; i < n; i++) {
            map.put(arr[i], 1L);
            for (int j = 0; j < i; j++) {
                if (arr[i] % arr[j] == 0) {
                    int x = arr[j];
                    int y = arr[i] / arr[j];
                    long currRes = ((map.get(x) % p * map.getOrDefault(y, 0L) % p) % p);
                    map.put(arr[i], map.get(arr[i]) + currRes);
                }
            }
            result = (result % p + map.get(arr[i]) % p) % p;
        }
        return (int) result;
    }
}
