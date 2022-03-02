import java.util.HashMap;
import java.util.Map;

/* Valid Phone Directory! */

/* Problem Description

Given a phone directory in the form of string array A containing N numeric strings.

If any phone number is prefix of another phone number then phone directory is invalid else it is valid.

You need to check whether the given phone directory is valid or not if it is valid then return 1 else return 0.


Problem Constraints
2 <= N <= 10^5
1 <= |A[i]| <= 50
A[i] consists only of numeric digits.

Input Format
First and only argument is an string array A.

Output Format
Return 1 if the given phone directory is valid else return 0.

Example Input

Input 1:
 A = ["1234", "2342", "567"]
Input 2:
 A = ["00121", "001"]


Example Output

Output 1:
 1
Output 2:
 0

Example Explanation

Explanation 1:
 No number is prefix of any other number so phone directory is valid so we will return 1.
Explanation 2:
 "001" is prefix of "00121" so phone directory is invalid so we will return 0. */

/**
 * Check while insertion operation of the Trie
 * TC: O(N * lengthOfWord) where N is no of words
 * SC: O(N * lengthOfWord * sizeof(TrieNode) )
 */
public class hw_q2_Valid_Phone_Directory {

    class TrieNode {
        Character data;
        boolean isEnd;
        Map<Integer, TrieNode> children;

        public TrieNode(Character data) {
            this.data = data;
            this.isEnd = false;
            this.children = new HashMap<Integer, TrieNode>(10);
        }

        // insert a phone number into Trie
        public boolean insert(String phoneNumber) {
            TrieNode temp = this;
            for (int i = 0; i < phoneNumber.length(); i++) {
                Character c = phoneNumber.charAt(i);
                int ind = c - 'a';
                if (!temp.children.containsKey(ind)) {
                    temp.children.put(ind, new TrieNode(c));
                }
                temp = temp.children.get(ind);
                // case - 1 if current character is end of any existing word
                if (temp.isEnd) {
                    return false;
                }
            }
            temp.isEnd = true;
            // case - 2 if there are more children at the end of the current word that means
            // the
            // current word is prefix of another word
            if (temp.children.size() > 0) {
                return false;
            }
            return true;
        }
    }

    public boolean isValidPhoneDirectory(String[] A) {

        // build Trie
        TrieNode trie = new TrieNode('$');
        for (int i = 0; i < A.length; i++) {
            if (!trie.insert(A[i])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        String[] A = new String[] { "1234", "2342", "567" };
        hw_q2_Valid_Phone_Directory t1 = new hw_q2_Valid_Phone_Directory();
        System.out.println(t1.isValidPhoneDirectory(A)); // true

        A = new String[] { "001", "00121" };
        t1 = new hw_q2_Valid_Phone_Directory();
        System.out.println(t1.isValidPhoneDirectory(A)); // false

        A = new String[] { "5678", "5678" };
        t1 = new hw_q2_Valid_Phone_Directory();
        System.out.println(t1.isValidPhoneDirectory(A)); // false

    }
}
