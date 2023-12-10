/*
Poker Nim!

Problem Description

Poker Nim is another 2 -player game that's a simple variation on a Nim game. The rules of the games are as follows:

The game starts with N piles of chips indexed from 0 to N - 1. Each pile i (where 0 <= i < N) has Ai chips.
The players move in alternating turns. During each move, the current player must perform either of the following actions:
Remove one or more chips from a single pile.
Add one or more chips to a single pile.
At least 1 chip must be added or removed during each turn.

To ensure that the game ends in finite time, a player cannot add chips to any pile i more than B times.
The player who removes the last chip wins the game.
Given the values of N, B and the numbers of chips in each of the N piles, determine whether the person who wins the game is the first or second person to move. Assume both players move optimally.

Problem Constraints
1 <= N <= 100
0 <= B <= 100
1 <= A[i] <= 10^9

Player 1 always goes first.

Input Format:
First argument is an integer array A of size N denoting the number of chips in each pile.
Second argument is an integer B

Output Format:
Return a string denoting the name of the winner(i.e., either First or Second).

Example Input:
Input 1:
 A = [1, 2]
 B = 5
Input 2:
 A = [2, 1, 3]
 B = 5

Example Output:
Output 1:
 First
Output 2:
 Second
 */
public class q3_Poker_Nim {

    public static void main(String[] args) {
        q3_Poker_Nim t = new q3_Poker_Nim();
        {
            int[] A = {1, 2};
            int B = 5;
            System.out.println(t.solve(A, B)); // First
        }
        {
            int[] A = {2, 1, 3};
            int B = 5;
            System.out.println(t.solve(A, B)); // Second
        }
    }

    public String solve(int[] A, int B) {
        int xor = 0;
        for (int i : A) {
            xor ^= i;
        }
        return xor == 0 ? "Second" : "First";
    }
}
/*
Solution Approach:

This problem is identical to standard nim game.
If the current player is in winning position and the opponent adds some chips,
the current player can remove those chips in his move and remain in winning position.
As the current player can mirror his opponent’s “add” move all the time, that move has no value.

Now you can find xor-sum like standard nim game and determine who will win the game.

Time Complexity : O(N)
Space Complexity : O(1)
 */