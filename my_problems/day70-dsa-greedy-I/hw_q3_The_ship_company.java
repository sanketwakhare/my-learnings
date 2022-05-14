import java.util.Collections;
import java.util.PriorityQueue;

/* The ship company */

/* Problem Description
The local ship renting service has a special rate plan:

It is up to a passenger to choose a ship.
If the chosen ship has X (X > 0) vacant places at the given moment, then the ticket for such a ship costs X.
The passengers buy tickets in turn, the first person in the queue goes first, then the second one, and so on up to A-th person.

You need to tell the maximum and the minimum money that the ship company can earn if all A passengers buy tickets.



Problem Constraints
1 ≤ A ≤ 3000
1 ≤ B ≤ 1000
1 ≤ C[i] ≤ 1000
It is guaranteed that there are at least A empty seats in total.



Input Format
First argument is a integer A denoting the number of passengers in the queue.
Second arugument is a integer B deonting the number of ships.
Third argument is an integer array C of size B where C[i] denotes the number of empty seats in the i-th ship before the ticket office starts selling tickets.



Output Format
Return an array of size 2 denoting the maximum and minimum money that the ship company can earn.



Example Input
Input 1:

 A = 4
 B = 3
 C = [2, 1, 1]
Input 2:

 A = 4
 B = 3
 C = [2, 2, 2]


Example Output
Output 1:

 [5, 5]
Output 2:

 [7, 6]


Example Explanation
Explantion 1:

 Maximum money can be earned if the passenger choose : 2(first ship) + 1(first ship) + 1(second ship) + 1(third ship).
 So, the cost will be 5.
 Minimum money can be earned if the passenger choose : 1(senocd ship) + 2(first ship) + 1(first ship) + 1(third ship).
 So, the cost will be 5.
Explanation 2:

 Maximum money can be earned if the passenger choose : 2(first ship) + 2(second ship) + 2(third ship) + 1(first ship).
 So, the cost will be 7.
 Minimum money can be earned if the passenger choose : 2(senocd ship) + 2(first ship) + 1(first ship) + 1(second ship).
 So, the cost will be 6. */

public class hw_q3_The_ship_company {

    public int[] solve(int A, int B, int[] C) {
        // create max heap of size B
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(B, Collections.reverseOrder());
        // create min heap of size B
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(B);

        int maxMoney = 0;
        int minMoney = 0;
        for (int i = 0; i < C.length; i++) {
            maxHeap.add(C[i]);
            minHeap.add(C[i]);
        }

        for (int i = 0; i < A; i++) {
            // update the max cost
            int max = maxHeap.poll();
            maxMoney += max;
            max = max - 1;
            if (max > 0) {
                maxHeap.add(max);
            }

            // update teh min cost
            int min = minHeap.poll();
            minMoney += min;
            min = min - 1;
            if (min > 0) {
                minHeap.add(min);
            }
        }

        System.out.println("[" + maxMoney + ", " + minMoney + "]");
        return new int[] { maxMoney, minMoney };
    }

    public static void main(String[] args) {
        hw_q3_The_ship_company t1 = new hw_q3_The_ship_company();
        int A, B;
        int[] C;

        {
            A = 4;
            B = 3;
            C = new int[] { 2, 1, 1 };
            t1.solve(A, B, C);
        }
        {
            A = 4;
            B = 3;
            C = new int[] { 2, 2, 2 };
            t1.solve(A, B, C);
        }
    }
}
