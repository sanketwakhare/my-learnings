/*
Coin Game

Problem Description
Two people are playing the Coin Game! The rules of the game are:

The game is played on a line of N squares. The i-th square contains A[i] coins.
The players move in alternate turns. During each move, the current player must remove exactly 1 coin from i-th square and move it to j-th square if and only if 1 <= j < i.
The game ends when all coins are in square 1 and nobody can make a move. The first player to have no available move loses the game.
Determine whether the person who wins the game is the first or second person to move. Assume both players move optimally.


Problem Constraints
1 <= N <= 2^15
0 <= A[i] <= 10^9 (for i in [1 ... N])

Input Format
The first and only argument of the input is the array A.


Output Format
Your function should return the string "First" if the first player wins or "Second" otherwise.


Example Input
Input 1:
 A = [0, 2, 3, 0, 6]
Input 2:
 A = [0, 0, 0, 0]


Example Output:
Output 1:
 "First"
Output 2:
 "Second"

Example Explanation:
Explanation 1:
 The first player will shift one coin from squre 3 to square 1.
 Hence, the second player is left with the squares [1,2,2,0,6].
 Now whatever be his/her move is, the first player can always nullify the change by shifting a coin to the same square where he/she shifted it.
 Hence the last move is always played by the first player, so he wins.

Explanation 2:
 There are no coins in any of the squares so the first player cannot make any move, hence second player wins.
 */
public class q4_Coin_Game {

    public static void main(String[] args) {
        q4_Coin_Game t = new q4_Coin_Game();
        {
            int[] A = {0, 2, 3, 0, 6};
            System.out.println(t.solve(A)); // First
        }
        {
            int[] A = {0, 0, 0, 0};
            System.out.println(t.solve(A)); // Second
        }
    }

    public String solve(int[] A) {
        int xor = 0;
        for (int i = 0; i < A.length; i++) {
            // take xor of indexes of the odd elements
            if (A[i] % 2 == 1) {
                xor ^= i;
            }
        }
        return xor == 0 ? "Second" : "First";
    }
}

/*
Solution Approach

If a coin is located at the i-th square, it can go to squares at index 1 to i-1.
So there are possibilities for every coin in each square.
So, you can think of it just as you would think of a pile of i stones.
Moving a coin to the left is just like taking a stone from a stone pile.

After you reduce the game to standard Nim, you can find the XOR sum to solve the game.
Notice that square i has A[i] stones of size i.
So we can just take one instance of size i pile if A[i] is odd, as XOR sum of even number of identical elements is zero.
So, no matter how large the value of A[i] is, you can easily find the XOR sum by checking if A[i] is even or odd.

Time Complexity : O(N)
Space Complexity : O(1)
 */