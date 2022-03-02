/* Given N strings as array, and integer K 
(N % K = 0) -> N will always be divisible by K

Divide string into K groups such that we get Maximum total score of all groups
where score = length of longest common prefix of that group

https://codingcompetitions.withgoogle.com/kickstart/round/000000000019ffc7/00000000001d3ff3


e.g. S = ["A", "A", "AB, "ABB", "ABB", "ABB"], K= 2
The groups can be formed as 
    ABB
    ABB  => score for group1 is 3 as ABB is max common prefix
    ABB
    AB => score for group2 is 2 as AB is max common prefix
    A
    A => score for group3 is 1 as A is max common prefix

    answer = 3+2+1 = 6

Problem
Pip has N strings. Each string consists only of letters from A to Z. Pip would like to bundle their strings into groups of size K. Each string must belong to exactly one group.

The score of a group is equal to the length of the longest prefix shared by all the strings in that group. For example:

The group {RAINBOW, RANK, RANDOM, RANK} has a score of 2 (the longest prefix is 'RA').
The group {FIRE, FIREBALL, FIREFIGHTER} has a score of 4 (the longest prefix is 'FIRE').
The group {ALLOCATION, PLATE, WORKOUT, BUNDLING} has a score of 0 (the longest prefix is '').
Please help Pip bundle their strings into groups of size K, such that the sum of scores of the groups is maximized.

Input
The first line of the input gives the number of test cases, T. T test cases follow. Each test case begins with a line containing the two integers N and K. Then, N lines follow, each containing one of Pip's strings.

Output
For each test case, output one line containing Case #x: y, where x is the test case number (starting from 1) and y is the maximum sum of scores possible.

Limits
Time limit: 20 seconds.
Memory limit: 1 GB.
1 ≤ T ≤ 100.
2 ≤ N ≤ 105.
2 ≤ K ≤ N.
K divides N.
Each of Pip's strings contain at least one character.
Each string consists only of letters from A to Z.

Test Set 1
Each of Pip's strings contain at most 5 characters.

Test Set 2
The total number of characters in Pip's strings across all test cases is at most 2 × 106.

Sample
Note: there are additional samples that are not run on submissions down below.
Sample Input
save_alt
content_copy
2
2 2
KICK
START
8 2
G
G
GO
GO
GOO
GOO
GOOO
GOOO
Sample Output
save_alt
content_copy
Case #1: 0
Case #2: 10
In Sample Case #1, Pip can achieve a total score of 0 by making the groups:

{KICK, START}, with a score of 0.
In Sample Case #2, Pip can achieve a total score of 10 by making the groups:

{G, G}, with a score of 1.
{GO, GO}, with a score of 2.
{GOO, GOO}, with a score of 3.
{GOOO, GOOO}, with a score of 4.

Additional Sample - Test Set 2
The following additional sample fits the limits of Test Set 2. It will not be run against your submitted solutions.
Sample Input
save_alt
content_copy
1
6 3
RAINBOW
FIREBALL
RANK
RANDOM
FIREWALL
FIREFIGHTER
Sample Output
save_alt
content_copy
Case #1: 6
In Sample Case #1, Pip can achieve a total score of 6 by making the groups:

{RAINBOW, RANK, RANDOM}, with a score of 2.
{FIREBALL, FIREWALL, FIREFIGHTER}, with a score of 4.
Note: Unlike previous editions, in Kick Start 2020, all test sets are visible verdict test sets, meaning you receive instant feedback upon submission.


*/

public class class_q3_bundledStrings {

    class TrieNode {
        Character data;
        boolean isEnd;
        int freq;
        TrieNode[] children;

        public TrieNode(Character data) {
            this.data = data;
            this.isEnd = false;
            this.freq = 0;
            children = new TrieNode[26];
        }

        public void insert(String word) {

            TrieNode temp = this;
            for (int i = 0; i < word.length(); i++) {
                Character c = word.charAt(i);
                int ind = c - 'A';
                if (temp.children[ind] == null) {
                    temp.children[ind] = new TrieNode(c);
                }
                temp = temp.children[ind];
                temp.freq++;
            }
            temp.isEnd = true;
        }
    }

    private int traverseTrie(class_q3_bundledStrings.TrieNode trie, int K) {
        if (trie == null) {
            return 0;
        }
        int currScore = trie.freq / K;
        for (int i = 0; i < trie.children.length; i++) {
            if (trie.children[i] != null && trie.children[i].freq >= K) {
                currScore += traverseTrie(trie.children[i], K);
            }
        }
        return currScore;
    }

    public int findScore(String[] A, int K) {

        // build Trie
        TrieNode trie = new TrieNode('$');
        for (int i = 0; i < A.length; i++) {
            trie.insert(A[i]);
        }

        // get total score
        int score = traverseTrie(trie, K);
        return score;
    }

    public static void main(String[] args) {
        String[] A = new String[] { "RAINBOW", "FIREBALL", "RANK", "RANDOM", "FIREWALL", "FIREFIGHTER" };
        int K = 3;
        class_q3_bundledStrings t1 = new class_q3_bundledStrings();
        System.out.println(t1.findScore(A, K)); // 6

        A = new String[] { "AB", "ABB", "ABB", "A", "A", "ABB" };
        K = 2;
        t1 = new class_q3_bundledStrings();
        System.out.println(t1.findScore(A, K)); // 6

        A = new String[] { "G", "G", "GO", "GO", "GOO", "GOO", "GOOO", "GOOO" };
        K = 2;
        t1 = new class_q3_bundledStrings();
        System.out.println(t1.findScore(A, K)); // 10

        A = new String[] { "KICK", "START" };
        K = 2;
        t1 = new class_q3_bundledStrings();
        System.out.println(t1.findScore(A, K)); // 0
    }

}
