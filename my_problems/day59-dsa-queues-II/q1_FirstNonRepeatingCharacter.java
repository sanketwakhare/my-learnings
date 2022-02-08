/* First non-repeating character */

/** 
 * Problem Description
Given a string A denoting a stream of lowercase alphabets.
You have to make new string B. B is formed such that we have to find first non-repeating character each time a character is inserted to the stream and append it at the end to B. if no non-repeating character is found then append '#' at the end of B.

Problem Constraints
1 <= |A| <= 100000

Input Format
The only argument given is string A.

Output Format
Return a string B after processing the stream of lowercase alphabets A.

Example Input
Input 1:
 A = "abadbc"
Input 2:
 A = "abcabc"

Example Output
Output 1:
"aabbdd"
Output 2:
"aaabc#"

Example Explanation
Explanation 1:
"a"      -   first non repeating character 'a'
"ab"     -   first non repeating character 'a'
"aba"    -   first non repeating character 'b'
"abad"   -   first non repeating character 'b'
"abadb"  -   first non repeating character 'd'
"abadbc" -   first non repeating character 'd'
Explanation 2:
"a"      -   first non repeating character 'a'
"ab"     -   first non repeating character 'a'
"abc"    -   first non repeating character 'a'
"abca"   -   first non repeating character 'b'
"abcab"  -   first non repeating character 'c'
"abcabc" -   no non repeating character so '#'
*/

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * Idea: Use hashmap with frequency to identify if element is repeated or not
 * And use queue as we have to get the first non repeating character. As queue
 * supports the pop from first/start ->dequeue operation
 * TC: O(N)
 * SC: O(N) -> N for each hashmap and queue
 */
public class q1_FirstNonRepeatingCharacter {

    public static String solve(String A) {

        // initialize HashMap
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        // initialize simple Queue
        Queue<Character> queue = new LinkedList<Character>();
        // initialize output string
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < A.length(); i++) {

            char currentChar = A.charAt(i);

            // step 1 : insert new character into HashMap and update frequency
            if (!map.containsKey(currentChar)) {
                map.put(currentChar, 1);
            } else {
                // It means the character is repeating and can not be possible answer
                // update frequency in map
                map.put(currentChar, map.get(currentChar) + 1);
            }

            // step 2: update queue - add current character only when it's frequency is == 1
            if (map.get(currentChar) == 1) {
                queue.add(currentChar);
            }

            // step 3: remove all elements from front whose frequencey in map > 1 as these
            // can not be possible answers
            while (!queue.isEmpty() && map.get(queue.peek()) > 1) {
                queue.remove();
            }

            // step 4: update answer
            if (queue.isEmpty()) {
                sb.append("#");
            } else {
                sb.append(queue.peek());
            }

        }
        return sb.toString();
    }

    public static void main(String[] args) {

        // test case 1
        System.out.println("answer -> " + solve("abadbc"));
        // test case 2
        System.out.println("answer -> " + solve("abcabc"));
        // test case 3
        System.out.println("answer -> " + solve("ab"));
        // test case 4
        System.out.println("answer -> " + solve("iergxwhddh"));
        // test case 5
        System.out.println("answer -> " + solve("hspkzrqozquywqsnumncuclkrrwsormkfprzotxrcotbnteiizlvt"));
        // test case 6
        System.out.println("answer -> " + solve("jyhrcwuengcbnuchctluxjgtxqtfvrebveewgasluuwooupcyxwgl"));
    }

}
