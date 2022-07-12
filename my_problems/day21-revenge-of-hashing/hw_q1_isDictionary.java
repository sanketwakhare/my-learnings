/* Is Dictionary? */

import java.util.HashMap;
import java.util.Map;

public class hw_q1_isDictionary {

    public static void main(String[] args) {
        hw_q1_isDictionary t1 = new hw_q1_isDictionary();

        // test case 2
        String[] A = new String[]{"hello", "scaler", "interviewbit"};
        String B = "adhbcfegskjlponmirqtxwuvzy";
        System.out.println(t1.solve(A, B)); // 1

        // test case 2
        A = new String[]{"fine", "none", "no"};
        B = "qwertyuiopasdfghjklzxcvbnm";
        System.out.println(t1.solve(A, B)); // 0
    }

    public int solve(String[] A, String B) {
        // create hashmap
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < B.length(); i++) {
            char ch = B.charAt(i);
            map.put(ch, i);
        }

        // now compare 2 adjacent words
        for (int i = 1; i < A.length; i++) {
            String firstWord = A[i - 1];
            String secondWord = A[i];
            if (!compare(firstWord, secondWord, map)) return 0;
        }
        return 1;
    }

    public boolean compare(String firstWord, String secondWord, Map<Character, Integer> map) {
        int length1 = firstWord.length();
        int length2 = secondWord.length();
        int index1 = 0;
        int index2 = 0;
        while (index1 < length1 && index2 < length2) {
            char ch1 = firstWord.charAt(index1);
            char ch2 = secondWord.charAt(index2);
            if (ch1 == ch2) {
                index1++;
                index2++;
            } else if (map.get(ch2) < map.get(ch1)) {
                return false;
            } else break;
        }
        return length1 <= length2;
    }

}
