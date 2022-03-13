/* Letter Phone */

/* Problem Description

Given a digit string A, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below.


The digit 0 maps to 0 itself. The digit 1 maps to 1 itself.

NOTE: Make sure the returned strings are lexicographically sorted.


Problem Constraints

1 <= |A| <= 10


Input Format

The only argument is a digit string A.


Output Format

Return a string array denoting the possible letter combinations.


Example Input

Input 1:

 A = "23"
Input 2:

 A = "012"


Example Output

Output 1:

 ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"]
Output 2:

 ["01a", "01b", "01c"]


Example Explanation

Explanation 1:

 There are 9 possible letter combinations.
Explanation 2:

 Only 3 possible letter combinations. */
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/***
 * Iterative Approach
 * TC: O(N^k) where N is no of digits and k = max no of letters in a digit
 * SC: O(N^k) to store all combinations
 */
public class q3_Letter_Phone {
    public ArrayList<String> letterCombinations(String A) {

        ArrayList<String> result = new ArrayList<String>();

        // build dictionary of characters
        Map<String, String> map = new HashMap<String, String>();
        map.put("0", "0");
        map.put("1", "1");
        map.put("2", "abc");
        map.put("3", "def");
        map.put("4", "ghi");
        map.put("5", "jkl");
        map.put("6", "mno");
        map.put("7", "pqrs");
        map.put("8", "tuv");
        map.put("9", "wxyz");

        Deque<String> deque = new ArrayDeque<String>();

        // insert characters of first digit
        String values = map.get(String.valueOf(A.charAt(0)));
        for (int i = 0; i < values.length(); i++) {
            String currChar = String.valueOf(values.charAt(i));
            deque.addLast(currChar);
        }
        // add $ at last to identify end of current digit data
        deque.addLast("$");

        // for next characters, find all combinations
        for (int i = 1; i < A.length(); i++) {

            String value = map.get(String.valueOf(A.charAt(i)));

            // remove character form deque and find all combinations
            String x = deque.pollFirst();
            while (deque.size() > 0 && x != "$") {
                for (int j = 0; j < value.length(); j++) {
                    // insert new character
                    StringBuilder sb = new StringBuilder();
                    String newChar = String.valueOf(value.charAt(j));
                    sb.append(x).append(newChar);
                    deque.addLast(sb.toString());
                }
                x = deque.pollFirst();
            }
            // add $ at last to identify end of current digit data
            deque.addLast("$");
        }

        // at last we will have all teh combinations, fetch from deque and return
        while (deque.size() > 1) {
            result.add(deque.pollFirst());
        }

        System.out.println(result);
        return result;

    }

    public static void main(String[] args) {

        q3_Letter_Phone t1 = new q3_Letter_Phone();
        t1.letterCombinations("23");
        t1.letterCombinations("173");
        t1.letterCombinations("432");
        t1.letterCombinations("4356");
        t1.letterCombinations("675");
        t1.letterCombinations("1612");
    }

}
