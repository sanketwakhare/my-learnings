/*  Another Coin Problem */

/* Problem Description
The monetary system in DarkLand is really simple and systematic. The locals-only use coins. The coins come in different values. The values used are:

 1, 5, 25, 125, 625, 3125, 15625, ...
Formally, for each K >= 0 there are coins worth 5K.

Given an integer A denoting the cost of an item, find and return the smallest number of coins necessary to pay exactly the cost of the item (assuming you have a sufficient supply of coins of each of the types you will need).


Problem Constraints
1 <= A <= 2×10^9

Input Format
The only argument given is integer A.

Output Format
Return the smallest number of coins necessary to pay exactly the cost of the item.

Example Input
Input 1:

 A = 47
Input 2:

 A = 9


Example Output
Output 1:

 7
Output 2:

 5


Example Explanation
Explanation 1:

 Representation of 7 coins will be : (1 + 1 + 5 + 5 + 5 + 5 + 25).
Explanation 2:

 Representation of 5 coins will be : (1 + 1 + 1 + 1 + 5). */

public class hw_q2_Another_Coin_Problem {
    public int solve(int A) {

        // all possible values within range 0 to 2* 10^9
        long[] coins = new long[] { 1l,
                5l,
                25l,
                125l,
                625l,
                3125l,
                15625l,
                78125l,
                390625l,
                1953125l,
                9765625l,
                48828125l,
                244140625l,
                1220703125l,
                6103515625l };

        long value = (long) A;
        long ans = 0;
        int index = 0;
        while (value > 0) {
            // find floor of number
            index = findFloor(coins, 0, coins.length - 1, value);
            if (index >= 0) {
                ans += (value / coins[index]);
                value = value % coins[index];
            } else {
                break;
            }
        }
        return (int) ans;
    }

    // Binary search to find the floor of a number
    private int findFloor(long[] coins, int start, int end, long target) {

        int mid = 0;
        int answer = -1;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (coins[mid] == target) {
                return mid;
            } else if (coins[mid] < target) {
                start = mid + 1;
                answer = mid;
            } else {
                end = mid - 1;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        hw_q2_Another_Coin_Problem t1 = new hw_q2_Another_Coin_Problem();

        System.out.println(t1.solve(47));
        System.out.println(t1.solve(9));
    }
}
