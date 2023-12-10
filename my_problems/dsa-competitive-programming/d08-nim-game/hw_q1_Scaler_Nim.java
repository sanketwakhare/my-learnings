/*
Scaler Nim!

Problem Description

Two people are playing game of Scaler Nim. The basic rules for this game are as follows:

The game starts with N piles of stones indexed from 0 to (N - 1). Each pile i (where 0 <= i <= N ) has Ai stones.
The players move in alternating turns. During each move, the current player must remove one or more stones from a single pile.
The player who removes the last stone loses the game.
Given an integer array A of size N denoting the number of stones in each pile, determine whether the person who wins the game is the first or second person to move. If the first player to move wins, return "First"; otherwise, return "Second". Assume both players move optimally.


Problem Constraints

1 <= N <= 100
1 <= A[i] <= 10^9

Player 1 always goes first.


Input Format
First and only argument is an integer array A of size N denoting the number of stones in each pile.


Output Format
Return an string denoting the name of the winner(i.e., either First or Second).


Example Input
Input 1:
 A = [1, 1]
Input 2:
 A = [2, 1, 3]


Example Output
Output 1:
 First
Output 2:
 Second

Example Explanation:
Explanation 1:
 In the first testcase, the first player removes 1 stone from the first pile and then the second player has no moves other than removing
 the only stone in the second pile. So first wins.
Explanation 2:
 In the second testcase, the series of moves can be depicted as:
 In every possible move of first player we see that the last stone is picked by him, so second player wins.
 */
public class hw_q1_Scaler_Nim {

    public static void main(String[] args) {
        hw_q1_Scaler_Nim t = new hw_q1_Scaler_Nim();
        {
            int[] A = {1, 1};
            System.out.println(t.solve(A)); // First
        }
        {
            int[] A = {2, 1, 3};
            System.out.println(t.solve(A)); // Second
        }
    }

    public String solve(int[] A) {
        boolean allOnes = true;
        for (int e : A) {
            if (e != 1) {
                allOnes = false;
                break;
            }
        }
        if (allOnes) {
            int n = A.length;
            return n % 2 == 0 ? "First" : "Second";
        }
        int xor = 0;
        for (int e : A) {
            xor ^= e;
        }
        return xor == 0 ? "Second" : "First";
    }
}
/*
Solution Approach:

Scaler Nim is exactly like the standard Nim game, except for one critical difference.
If the size of every pile is 1, then we need to treat it as a special case where we count the number of piles.
If the count is even, then the first player will win; if the count is odd, then the first player will lose.

If the size of every pile is not 1, then you can use XOR sum to determine who will win the game.
If the XOR sum is zero the first player picks the last stone from the last pile hence looses,
else the first player wins.
*/