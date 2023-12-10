import java.util.Arrays;

/*
2,3,5 Game

Problem Description
Two players called Alice and Bob are playing T independent games, each game starting with A[i] number of stones. In each game, Alice always plays first, and the two players move in alternating turns.

The game's rules are as follows:

In a single move, a player can remove either 2, 3, or 5 stones from the game board.
If a player is unable to make a move, that player loses the game.
Given the starting number of stones, find and print the name of the winner.

Each player plays optimally, meaning they will not make a move that causes them to lose the game if a winning move exists.


Problem Constraints
1 <= T <= 10^5
1 <= A[i] <= 10^5 (for all i in [ 1....T ])


Input Format
The first and only input argument is the array A


Output Format
You have to return an array of strings denoting the winner of the i-th game. The i-th string should be "Alice" if Alice wins the i-th game, otherwise it should be "Bob".


Example Input
Input 1:
A: [1, 6, 4]
Input 2:
A: [2, 3, 5]


Example Output:
Output 1:
["Bob", "Alice", "Alice"]
Output 2:
["Alice", "Alice", "Alice"]


Example Explanation:
Explanation 1:

If Alice starts with 1 stone, she can't make any move, so she loses.
If Alice starts with 6 stones, she removes 5 stones and Bob can't remove any stone. So Bob loses.
If Alice starts with 4 stone, she removes 3 stones and Bob can't remove any stone. So Bob loses.
Explanation 2:

If Alice starts with 2 stones, she removes 2 stones and Bob can't remove any stone. So Bob loses.
If Alice starts with 3 stones, she removes 3 stones and Bob can't remove any stone. So Bob loses.
If Alice starts with 5 stones, she removes 5 stones and Bob can't remove any stone. So Bob loses.
 */
public class q1_2_3_5_Game {

    public static void main(String[] args) {
        q1_2_3_5_Game t = new q1_2_3_5_Game();
        {
            int[] A = {1, 6, 4};
            System.out.println(Arrays.toString(t.solve(A)));
        }
        {
            int[] A = {2, 3, 5};
            System.out.println(Arrays.toString(t.solve(A)));
        }
    }

    public String[] solve(int[] A) {
        String[] res = new String[A.length];
        for (int i = 0; i < A.length; i++) {
            int x = A[i] % 7;
            res[i] = x == 0 || x == 1 ? "Bob" : "Alice";
        }
        return res;
    }
}

/*
Solution Approach:

Solution 1:

If the current player cannot force their opponent into any losing position, then this is a losing position.
Any move of either 2, 3, or 5 stones puts the next player in a winning state.
If no possible move results in the next state being a losing position, then the player loses.
In other words, if a player cannot make a move from their current state that results in the next state being a losing position,
the player is in a losing position, otherwise he/she is in winning position!

Let dp[i] represent if the person is going to win or not if currently there are i stones.

i.e.
dp[i] = 1 if the person is going to win when there are i stones.
dp[i] = 0 otherwise

This gives the following recursion:

Base case:
dp[0] = 0 (0 means losing position)
dp[1] = 0
dp[2] = 1
dp[3] = 1
dp[4] = 1

For i >= 5:
dp[i] = 1 if(dp[i-2]=0 or dp[i-3]=0 or dp[i-5]=0)
dp[i] = 0 otherwise

Time Complexity : O(T)
Space Complexity : O(maxA)

Solution 2:

There is another solution that exists for this problem. If you write a bruteforce/solve by hand for let us say, 21 values, you will get the following pattern:
[0, 0, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1]
where 0 at position i means that if the pile has i stones, then the current player will lose, otherwise he’ll win. We can see in the first 21 values, that there is a period of
7 values, that repeats everytime. In this period of 7 values, we can see that only the 0th and 1st position is losing. Thus, we can come up with the following algorithm:

Let us say that the pile has X stones. If X%7 == 0 or X%7 == 1, then Bob will win, otherwise Alice.

Time Complexity : O(T)
Space Complexity : O(1)
 */