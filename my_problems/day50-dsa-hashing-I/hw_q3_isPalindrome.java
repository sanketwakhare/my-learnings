import java.util.HashMap;
import java.util.Map;

public class hw_q3_isPalindrome {

    public static int checkPalindrome(String A) {

        // the palindrome string can be formed if frequency of every character in string
        // is even except single character which can have odd frequency

        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < A.length(); i++) {
            char currentChar = A.charAt(i);
            if (map.containsKey(currentChar)) {
                int currentFreq = map.get(currentChar);
                map.put(currentChar, currentFreq + 1);
            } else {
                map.put(currentChar, 1);
            }
        }

        // if off count is >1 , the palindrome can not be possible
        int countOfOdd = 0;
        for (Character key : map.keySet()) {
            int freq = map.get(key);
            if (freq % 2 == 1) {
                countOfOdd++;
            }
            if (countOfOdd > 1) {
                // can not be palindrome
                return 0;
            }
        }

        // palindrome can be possible
        return 1;
    }

    public static void main(String[] args) {

        int output1 = checkPalindrome("abcde");
        System.out.println("answer -> " + output1);
        int output2 = checkPalindrome("abbaee");
        System.out.println("answer -> " + output2);
    }
}
