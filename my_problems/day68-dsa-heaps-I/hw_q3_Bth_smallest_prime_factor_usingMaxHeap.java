/* B-th Smallest Prime Fraction */

/* B-th Smallest Prime Fraction */

/* Problem Description

A sorted array of integers, A contains 1, plus some number of primes. Then, for every p < q in the list, we consider the fraction p/q.

What is the B-th smallest fraction considered?

Return your answer as an array of integers, where answer[0] = p and answer[1] = q.


Problem Constraints

1 <= length(A) <= 2000
1 <= A[i] <= 30000
1 <= B <= length(A)*(length(A) - 1)/2


Input Format

The first argument of input contains the integer array, A.
The second argument of input contains an integer B.


Output Format

Return an array of two integers, where answer[0] = p and answer[1] = q.


Example Input

Input 1:

 A = [1, 2, 3, 5]
 B = 3
Input 2:

 A = [1, 7]
 B = 1


Example Output

Output 1:

 [2, 5]
Output 2:

 [1, 7]


Example Explanation

Explanation 1:

 The fractions to be considered in sorted order are:
 [1/5, 1/3, 2/5, 1/2, 3/5, 2/3]
 The third fraction is 2/5.
Explanation 2:

 The fractions to be considered in sorted order are:
 [1/7]
 The first fraction is 1/7. */

import MaxHeapGenericsImpl.MaxHeap;

/* For this problem, using MaxHeap has better TC/SC as compared to solution with MinHeap
as we are finding a smallest kth number 
we can ignore few pairs and only K space is required for heap
*/

// Custom Pair type
class Pair implements Comparable<Pair> {
    double key;
    int p;
    int q;

    public Pair(double key, int p, int q) {
        this.key = key;
        this.p = p;
        this.q = q;
    }

    @Override
    public int compareTo(Pair o2) {
        if (this.key > o2.key)
            return 1;
        else if (this.key < o2.key)
            return -1;
        return 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        sb.append(key + ", ");
        sb.append(p + "/" + q);
        sb.append(']');
        return sb.toString();
    }
}

public class hw_q3_Bth_smallest_prime_factor_usingMaxHeap {

    public int[] solve(int[] A, int B) {

        MaxHeap<Pair> maxHeap = new MaxHeap<Pair>();
        for (int i = 0; i < A.length - 1; i++) {
            for (int j = i + 1; j < A.length; j++) {
                double fractionValue = (double) A[i] / (double) A[j];
                Pair pair = new Pair(fractionValue, A[i], A[j]);
                if (maxHeap.size() < B) {
                    maxHeap.insert(pair);
                } else {
                    if (pair.compareTo(maxHeap.peekMax()) < 0) {
                        maxHeap.getMaximum();
                        maxHeap.insert(pair);
                    }
                }
            }
        }

        Pair answer = maxHeap.getMaximum();
        return new int[] { answer.p, answer.q };
    }

    public static void main(String[] args) {

        hw_q3_Bth_smallest_prime_factor_usingMaxHeap t1 = new hw_q3_Bth_smallest_prime_factor_usingMaxHeap();
        int[] A = { 1, 719, 983, 9293, 11321, 14447, 16411, 17881, 22079, 28297 };
        int B = 42;
        int[] output = t1.solve(A, B);
        System.out.println(output[0] + " " + output[1]); // 17881 22079

    }
}
