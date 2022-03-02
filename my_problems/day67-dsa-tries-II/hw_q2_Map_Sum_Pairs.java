import java.util.ArrayList;

/* Map Sum Pairs! */

/* 
Problem Description

Rishabh was sitting ideally in his office and then suddenly his boss gave him some operations to perform.

You being his friend tried to help him in finishing the task fast.

So you have to perform Q operation of two types:

Operation 1: INSERT : You are given an pair of (string, integer).The string represents the key and the integer represents the value. Insert the key-value pair in the hash and If the key already exists in hash, then the original key-value pair will be overridden to the new one.
Operation 2: SUM : you'll be given an pair of (string, -1) where string representing the prefix, and you need to return the sum of all the pairs' value in the hash whose key starts with the prefix.


Problem Constraints
1 <= Q <= 10^3
1 <= Length of string in any operation <= 30
Strings in each operations only consists of lowercase characters.
1 <= Integer in Operation 1 <= 100
Integer in operation 2 is always -1 so this parameter will help you in distinguishing between the two opearations.


Input Format
First argument is an string array A of size Q denoting the first parameter of each operations.
Second argument is an integer array B of size Q denoting the second parameter of each operations.

NOTE: ith query will be like (A[i], B[i])

Output Format
Return an integer array denoting the answer for each operation of type: 2

Example Input

Input 1:
 A = ["apple", "ap", "app", "ap"]
 B = [3, -1, 2, -1]
Input 2:
 A = ["ban", "banana", "ba"]
 B = [10, -1, -1]

Example Output

Output 1:

 [3, 5]
Output 2:

 [0, 10]


Example Explanation

Explanation 1:

 1. (A[0], B[0]) is a type-1 operation as B[0] != -1 so we will insert "apple" in our hash and store its value as 3.
 2. (A[1], B[1]) is a type-2 operation as B[1] == -1 so we will search for every string inserted in our 
    hash whose prefix is  "ap". Only "apple" has its prefix as "ap" so we will return 3
 3. (A[2], B[2]) is a type-1 operation as B[2] != -1 so we will insert "app" in our hash and store its value as 2.
 4. (A[3], B[3]) is a type-2 operation as B[3] == -1 so we will search for every string inserted in our 
    hash whose prefix is  "ap". So both ["apple", "app"] has its prefix as "ap" so we will return 3 + 2 i.e 5
Explanation 2:

 1. (A[0], B[0]) is a type-1 operation as B[0] != -1 so we will insert "ban" in our hash and store its value as 10.
 2. (A[1], B[1]) is a type-2 operation as B[1] == -1 so we will search for every string inserted in our 
    hash whose prefix is  "banana". So there doesn't exist any string whose prefix is "banana" so we will return 0
 3. (A[2], B[2]) is a type-2 operation as B[2] == -1 so we will search for every string inserted in our 
    hash whose prefix is  "ba". Only "ban" has its prefix as "ba" so we will return 10.
 */
public class hw_q2_Map_Sum_Pairs {

    class TrieNode {
        Character data;
        int hashSum;
        boolean isEnd;
        TrieNode[] children;
        int hash;

        public TrieNode(Character data) {
            this.data = data;
            this.hashSum = 0;
            this.isEnd = false;
            this.children = new TrieNode[26];
            this.hash = -1;
        }

        public void insertWord(String word, int hash) {

            // get existing hash for a word. this will be helpful is word is repeating
            int oldHash = getHash(word);

            TrieNode temp = this;
            for (int i = 0; i < word.length(); i++) {
                Character currChar = word.charAt(i);
                int ind = currChar - 'a';
                if (temp.children[ind] == null) {
                    temp.children[ind] = new TrieNode(currChar);
                }
                // increase the current hashSum
                temp.children[ind].hashSum += hash;
                // if word is repeating subtract the old hash value
                if (oldHash != -1) {
                    temp.children[ind].hashSum -= oldHash;
                }
                temp = temp.children[ind];
            }
            // update end of current word
            temp.isEnd = true;
            // update new hash value of the current word
            temp.hash = hash;
        }

        public int getHash(String word) {

            TrieNode temp = this;
            for (int i = 0; i < word.length(); i++) {
                Character currChar = word.charAt(i);
                int ind = currChar - 'a';
                if (temp.children[ind] == null) {
                    // prefix not found
                    return -1;
                }
                temp = temp.children[ind];
            }
            if (temp.isEnd) {
                return temp.hash;
            }
            // return -1 if word does not exist
            return -1;
        }

        public int getHashSum(String prefix) {

            TrieNode temp = this;
            for (int i = 0; i < prefix.length(); i++) {
                Character currChar = prefix.charAt(i);
                int ind = currChar - 'a';
                if (temp.children[ind] == null) {
                    // prefix not found
                    return 0;
                }
                temp = temp.children[ind];
            }
            return temp.hashSum;
        }

    }

    public int[] maxSumPairs(String[] A, int[] B) {

        TrieNode trie = new TrieNode('$');
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < A.length; i++) {
            if (B[i] != -1) {
                trie.insertWord(A[i], B[i]);
            } else {
                list.add(trie.getHashSum(A[i]));
            }
        }

        // convert int list to array
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {

        // test 1
        String[] A = new String[] { "apple", "ap", "app", "ap" };
        int[] B = new int[] { 3, -1, 2, -1 };
        hw_q2_Map_Sum_Pairs t1 = new hw_q2_Map_Sum_Pairs();
        int[] output = t1.maxSumPairs(A, B);
        t1.printArray(output);

        // test 2
        A = new String[] { "ban", "banana", "ba" };
        B = new int[] { 10, -1, -1 };
        t1 = new hw_q2_Map_Sum_Pairs();
        output = t1.maxSumPairs(A, B);
        t1.printArray(output);

        // test 3
        A = new String[] { "aaac", "aaca", "babb", "ccca", "ccbc", "ccac", "bcbb", "abbb", "bbca", "cbba", "ccaa",
                "ccbb", "baac", "bbaa", "caaa", "aaca", "cbcb", "abaa", "accb", "abcb", "bb", "cb", "ab", "ba", "aa",
                "cc", "aa", "aa", "bc", "aa" };
        B = new int[] { 42, 68, 35, 1, 70, 25, 79, 59, 63, 65, 6, 46, 82, 28, 62, 92, 96, 43, 28, 37, -1, -1, -1, -1,
                -1, -1, -1, -1, -1, -1 };
        t1 = new hw_q2_Map_Sum_Pairs();
        output = t1.maxSumPairs(A, B);
        t1.printArray(output);

    }

    private void printArray(int[] A) {
        System.out.print("[ ");
        int i = 0;
        for (int temp : A) {
            if (i == A.length - 1)
                System.out.print(temp);
            else
                System.out.print(temp + ", ");
            i++;
        }
        System.out.print(" ]");
        System.out.println();
    }
}
