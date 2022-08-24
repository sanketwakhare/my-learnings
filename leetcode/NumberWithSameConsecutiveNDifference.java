import java.util.*;

public class NumberWithSameConsecutiveNDifference {

    public static void main(String[] args) {
        NumberWithSameConsecutiveNDifference t1 = new NumberWithSameConsecutiveNDifference();
        {
            int[] result = t1.numsSameConsecDiff(3, 7);
            System.out.println(Arrays.toString(result));
        }
        {
            int[] result = t1.numsSameConsecDiff(2, 1);
            System.out.println(Arrays.toString(result));
        }
        {
            int[] result = t1.numsSameConsecDiff(2, 0);
            System.out.println(Arrays.toString(result));
        }
    }

    public int[] numsSameConsecDiff(int n, int k) {
        Set<Integer> result = new LinkedHashSet<>();
        for (int i = 0; i < 10; i++)
            backtrack(i, n, k, result);
        return result.stream().mapToInt(i -> i).toArray();
    }

    public void backtrack(int val, int n, int k, Set<Integer> result) {

        // convert to string value
        String nValue = String.valueOf(val);
        // edge case as there can not be leading 0s
        if ("0".equals(nValue)) {
            return;
        }

        // when required number is formed, add it to result adn return
        if (nValue.length() == n) {
            // add
            result.add(val);
            return;
        }

        // compare last 2 digits of the new number
        int oldDigit = val % 10;
        for (int i = 0; i < 10; i++) {
            int newNumber = (val * 10 + i);
            int lastDigit = newNumber % 10;
            // consider only when difference is matching
            if (oldDigit - lastDigit == k) {
                backtrack(newNumber, n, k, result);
            }
            if (lastDigit - oldDigit == k) {
                backtrack(newNumber, n, k, result);
            }
        }
    }
}
