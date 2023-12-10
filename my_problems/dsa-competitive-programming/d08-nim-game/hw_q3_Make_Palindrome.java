import java.util.HashMap;
import java.util.Map;

/*
Make Palindrome

Problem Description

Two players have got a string A, consisting of lowercase English letters. They play a game that is described by the following rules:

The players move in turns; In one move the player can remove an arbitrary letter from string A.
If the player before his turn can reorder the letters in string A so as to get a palindrome, this player wins.

NOTE:
A palindrome is a string that reads the same both ways (from left to right, and vice versa). For example, string "abba" is a palindrome and string "abc" isn't.

Problem Constraints
1 ≤ |A| ≤ 10^3


Input Format
The input contains a single line, containing string A.

Output Format
Return a single integer, 1 or 2, depending upon which player wins.

Example Input
Input 1:
 A = "aba"
Input 2:
 A = "abca"

Example Output:
Output 1:
 1
Output 2:
 2

Example Explanation:
Explanation 1:
 The string is already a palindrome. Hence player 1 wins.
Explanation 2:
 If player 1 erases characters 'b' or 'c', the string becomes a palindrome and player 2 wins.
 If player 1 erases character 'a', the string becoms "abc", since all characters are different now, any sequence of moves leads to winning of player 2.
 */
public class hw_q3_Make_Palindrome {
    public static void main(String[] args) {
        hw_q3_Make_Palindrome t = new hw_q3_Make_Palindrome();
        {
            System.out.println(t.solve("aba")); // 1
        }
        {
            System.out.println(t.solve("abca")); // 2
        }
    }

    public int solve(String A) {

        // find frequency of each character
        int oddFreqCharCount = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (char c : A.toCharArray()) {
            if (map.containsKey(c)) {
                int currFreq = map.get(c);
                map.put(c, currFreq + 1);
            } else {
                map.put(c, 1);
            }
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            int freq = entry.getValue();
            if (freq % 2 == 1) oddFreqCharCount++;
        }

        // edge case: if no of odd frequency characters are 0 , Player 1 wins as string is already palindrome
        if (oddFreqCharCount == 0) return 1;

        // if no of odd frequency characters are even, player 2 wins
        // if no of odd frequency characters are odd, player 1 wins
        return oddFreqCharCount % 2 == 0 ? 2 : 1;
    }
}
