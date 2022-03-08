/* Free Cars */

/* Problem Description

Given two arrays A and B of size N. A[i] represents the time by which you can buy ith car without paying any money.

B[i] represents the profit you can earn by buying ith car. It takes 1 minute to buy a car so, you can only buy the ith car when the current time <= A[i] - 1.

Your task is to find maximum profit one can earn by buying cars considering that you can only buy one car at a time.

NOTE:

You can start buying from time = 0.
Return you answer modulo 10^9 + 7.


Problem Constraints

1 <= N <= 10^5
1 <= A[i] <= 10^9
0 <= B[i] <= 10^9


Input Format

First argument is an integer array A represents the deadline of buying the cars.
Second argument is an integer array B represents the profit obtained after buying the cars.


Output Format

Return an integer denoting the maximum profit you can earn.


Example Input

Input 1:

 A = [1, 3, 2, 3, 3]
 B = [5, 6, 1, 3, 9]
Input 2:

 A = [3, 8, 7, 5]
 B = [3, 1, 7, 19]


Example Output

Output 1:

 20
Output 2:

 30


Example Explanation

Explanation 1:

 At time 0, buy car with profit 5.
 At time 1, buy car with profit 6.
 At time 2, buy car with profit 9.
 At time = 3 or after , you can't buy any car, as there is no car with deadline >= 4.
 So, total profit that one can earn is 20.
Explanation 2:

 At time 0, buy car with profit 3.
 At time 1, buy car with profit 1.
 At time 2, buy car with profit 7.
 At time 3, buy car with profit 19.
 We are able to buy all cars within their deadline. So, total profit that one can earn is 30. */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import MinHeapGenericsImpl.MinHeap;

/**
 * Use min Heap to calculate the maximum profit
 * SC: O(N)
 * TC: O(N logN) sorting and heap operations are involved
 */
public class q3_Free_Cars {

    class Pair implements Comparable<Pair> {
        int deadline;
        int profit;

        public Pair(int deadline, int profit) {
            this.deadline = deadline;
            this.profit = profit;
        }

        @Override
        public int compareTo(Pair o2) {
            if (this.profit > o2.profit)
                return 1;
            else if (this.profit < o2.profit)
                return -1;
            return 0;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append('[');
            sb.append("[" + deadline + ", " + profit + "]");
            sb.append(']');
            return sb.toString();
        }
    }

    // comparator for deadline property
    class DeadlineComparator implements Comparator<Pair> {

        @Override
        public int compare(q3_Free_Cars.Pair o1, q3_Free_Cars.Pair o2) {
            if (o1.deadline > o2.deadline)
                return 1;
            else if (o1.deadline < o2.deadline)
                return -1;
            return 0;
        }
    }

    public int solve(int[] A, int[] B) {

        // prepare all pairs
        List<Pair> pairs = new ArrayList<Pair>();
        for (int i = 0; i < A.length; i++) {
            pairs.add(new Pair(A[i], B[i]));
        }

        // sort according to deadline/ time /array A
        Collections.sort(pairs, new DeadlineComparator());

        // maintain a min heap and a count for no of days passed
        MinHeap<Integer> minHeap = new MinHeap<Integer>();
        int currentDay = 0;
        for (int i = 0; i < pairs.size(); i++) {
            Pair temp = pairs.get(i);
            if (currentDay < temp.deadline) {
                // if we have not crossed the deadline
                currentDay++;
                minHeap.insert(temp.profit);
            } else if (minHeap.peekMin() < temp.profit) {
                // we have crossed deadline for current pair but check mif any previous
                // completed task has less profit
                minHeap.getMinimum();
                minHeap.insert(temp.profit);
            }
        }

        // calculate final profit value
        long maxProfit = 0;
        long m = 1000000007;
        while (!minHeap.isEmpty()) {
            maxProfit = (maxProfit % m + minHeap.getMinimum() % m) % m;
        }
        return (int) maxProfit;
    }

    public static void main(String[] args) {
        q3_Free_Cars t1 = new q3_Free_Cars();

        int[] A = new int[] { 1, 7, 6, 2, 8, 4, 4, 6, 8, 2 };
        int[] B = new int[] { 8, 11, 7, 7, 10, 8, 7, 5, 4, 9 };
        System.out.println("answer: " + t1.solve(A, B)); // 65

        A = new int[] { 1, 3, 2, 3, 3 };
        B = new int[] { 5, 6, 1, 3, 9 };
        System.out.println("answer: " + t1.solve(A, B)); // 20

        A = new int[] { 3, 8, 7, 5 };
        B = new int[] { 3, 1, 7, 19 };
        System.out.println("answer: " + t1.solve(A, B)); // 30
    }
}
