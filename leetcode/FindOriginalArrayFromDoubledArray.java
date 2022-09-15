import java.util.Arrays;

/* 2007. Find Original Array From Doubled Array */
/* https://leetcode.com/problems/find-original-array-from-doubled-array/ */
public class FindOriginalArrayFromDoubledArray {

    public static void main(String[] args) {
        FindOriginalArrayFromDoubledArray t1 = new FindOriginalArrayFromDoubledArray();
        {
            int[] result = t1.findOriginalArray(new int[]{1, 3, 4, 2, 6, 8});
            System.out.println(Arrays.toString(result));
        }
        {
            int[] result = t1.findOriginalArray(new int[]{8, 4});
            System.out.println(Arrays.toString(result));
        }
        {
            int[] result = t1.findOriginalArray(new int[]{6, 3, 0, 1});
            System.out.println(Arrays.toString(result));
        }
        {
            int[] result = t1.findOriginalArray(new int[]{1, 2, 3, 2, 4, 6, 2, 4, 6, 4, 8, 12});
            System.out.println(Arrays.toString(result));
        }
        {
            int[] result = t1.findOriginalArray(new int[]{3, 3, 3, 3});
            System.out.println(Arrays.toString(result));
        }
        {
            int[] result = t1.findOriginalArray(new int[]{1, 1});
            System.out.println(Arrays.toString(result));
        }
        {
            int[] result = t1.findOriginalArray(new int[]{0, 0, 0, 0});
            System.out.println(Arrays.toString(result));
        }
    }

    public int[] findOriginalArray(int[] changed) {
        int n = changed.length;

        // if array length is odd, return
        if (n % 2 == 1) return new int[]{};

        // find max
        int max = 0;
        for (int num : changed) {
            max = Math.max(max, num);
        }
        // build frequency array
        int[] freq = new int[max + 1];
        for (int num : changed) {
            freq[num]++;
        }
        // iterate over frequency array till half and find if doubled value is present in array
        // and decrement frequencies after checking
        int[] result = new int[n / 2];
        int cnt = 0;
        for (int current = 0; current < (freq.length + 1) / 2; current++) {
            int doubled = current * 2;
            while (freq[current] > 0 && freq[doubled] > 0) {
                // repeat until current element freq > 0
                freq[current]--;
                freq[doubled]--;
                result[cnt++] = current;
            }
            // base case
            if (freq[current] > 0) return new int[]{};
        }
        // if there is non-zero element is second half of the array, return empty array
        for (int i = freq.length / 2; i < freq.length; i++) {
            if (freq[i] > 0) return new int[]{};
        }
        return result;
    }
}
