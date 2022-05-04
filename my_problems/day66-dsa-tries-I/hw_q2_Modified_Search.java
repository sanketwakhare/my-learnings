/* Modified Search */

/* Problem Description

Given two arrays of strings A of size N and B of size M.

Return a binary string C where C[i] = '1' if B[i] can be found in dictionary A using exactly one modification in B[i], Else C[i] = '0'.

NOTE: modification is defined as converting a character into another character.


Problem Constraints
1 <= N <= 30000
1 <= M <= 2500
1 <= length of any string either in A or B <= 20

strings contains only lowercase alphabets


Input Format

First argument is the string array A.

Second argument is the string array B.


Output Format

Return a binary string C where C[i] = '1' if B[i] can be found in dictionary A using one modification in B[i], Else C[i] = '0'.



Example Input

Input 1:

 A = [data, circle, cricket]
 B = [date, circel, crikket, data, circl]
Input 2:

 A = [hello, world]
 B = [hella, pello, pella]


Example Output

Output 1:

 "10100"
Output 2:

 "110"


Example Explanation

Explanation 1:

 1. date = dat*(can be found in A)
 2. circel =(cannot be found in A using exactly one modification)
 3. crikket = cri*ket(can be found in A)
 4. data = (cannot be found in A using exactly one modification)
 5. circl = (cannot be found in A using exactly one modification)
Explanation 2:

 Only pella cannot be found in A using only one modification. */
public class hw_q2_Modified_Search {

    class TrieNode {
        Character data;
        TrieNode[] children;
        boolean isLeaf;

        public TrieNode(char data) {
            this.data = data;
            children = new TrieNode[26];
            isLeaf = false;
        }

        // add word to Trie
        public void addWord(String word) {
            TrieNode root = this;
            for (int i = 0; i < word.length(); i++) {
                Character ch = word.charAt(i);
                int chIndex = ch - 'a';
                if (root.children[chIndex] == null) {
                    root.children[chIndex] = new TrieNode(ch);
                }
                root = root.children[chIndex];
            }
            root.isLeaf = true;
        }

        public boolean searchWord(String word, boolean isChanged, int ind) {
            TrieNode root = this;

            if (ind == word.length()) {
                // if we reach to end and only 1 character is replaced
                return root.isLeaf && isChanged;
            }

            if (isChanged == false) {
                // if character is not replaced, try all possibilities of replacing current
                // character
                for (int i = 0; i < 26; i++) {
                    if (root.children[i] != null) {
                        // consider replacing only when next character is not present in trie
                        if (root.children[i].data != word.charAt(ind)
                                && root.children[i].searchWord(word, true, ind + 1)) {
                            return true;
                        }
                    }
                }
            }

            if (root.children[word.charAt(ind) - 'a'] != null) {
                // move next if we find the matching character in Trie
                if (root.children[word.charAt(ind) - 'a'].searchWord(word, isChanged, ind + 1)) {
                    return true;
                }
            }

            return false;
        }
    }

    public String solve(String[] A, String[] B) {

        StringBuilder C = new StringBuilder();

        // build Trie
        TrieNode root = new TrieNode('$');
        for (String word : A) {
            root.addWord(word);
        }

        for (int i = 0; i < B.length; i++) {
            boolean isFound = root.searchWord(B[i], false, 0);
            if (isFound)
                C.append("1");
            else
                C.append("0");
        }
        return C.toString();
    }

    public static void main(String[] args) {

        hw_q2_Modified_Search t1 = new hw_q2_Modified_Search();
        String[] A, B;
        {
            A = new String[] { "data", "circle", "cricket" };
            B = new String[] { "date", "circel", "crikket", "data", "circl" };
            // B = new String[] { "data" };
            String answer = t1.solve(A, B);
            System.out.println(answer);
        }
        {
            A = new String[] { "hello", "world", "cut", "put", "curry", "current" };
            B = new String[] { "hella", "pello", "pella", "corrent", "murry" };
            String answer = t1.solve(A, B);
            System.out.println(answer);
        }

    }
}
