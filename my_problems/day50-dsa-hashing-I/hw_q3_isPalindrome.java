/* Check Palindrome! */

/* Problem Description
Given a string A consisting of lowercase characters.
Check if characters of the given string can be rearranged to form a palindrome.
Return 1 if it is possible to rearrange the characters of the string A such that it becomes a palindrome else return 0.


Problem Constraints
1 <= |A| <= 10^5
A consists only of lower-case characters.

Input Format
First argument is an string A.

Output Format
Return 1 if it is possible to rearrange the characters of the string A such that it becomes a palindrome else return 0.

Example Input
Input 1:
 A = "abcde"
Input 2:
 A = "abbaee"

Example Output
Output 1:
 0
Output 2:
 1

Example Explanation
Explanation 1:
 No possible rearrangement to make the string palindrome.
Explanation 2:
 Given string "abbaee" can be rearranged to "aebbea" to form a palindrome. */

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
