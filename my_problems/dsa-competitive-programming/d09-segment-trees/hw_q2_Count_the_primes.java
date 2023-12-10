import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Count the primes

Problem Description

Given an array A, containing positive integers. You need to perform some queries on it.

You will be given Q Queries. Each query will have one string and two integers. Each Query can be of two type :

"C" X Y - Here "C" says that we need to Change the integer at position X to integer Y.
"A" X Y - Here "A" say that we are Asked number of primes in the the range : [X, Y] (inclusive)
For each Query of type 2, you need to calculate an integer denoting the answer to it.

NOTE:
Assume 1-indexing for all queries.
Your code will be run on multiple test cases (< 10). Make sure to come up with an optimised solution and take care of clearing global variables.

Problem Constraints
1 <= Size of A <= 4 * 10^4
1 <= A[i] <= 10^6
1 <= Number of Queries (Size of B, C, D) <= 5 * 10^4

Input Format
First argument is an integer array A.
Second argument is a string array B.
Third argument is an integer array C.
Fourth argument is an integer array D.
In the i-th query, B[i] dentotes the string, C[i] denotes X and D[i] denotes Y.

Output Format
Return an integer array, where each of the element represents the answer to the queries of type 2, in chronological order.


Example Input
Input 1:
 A = [1, 3, 121, 20, 17, 26, 29]
 B = ["A", "C", "A"]
 C = [1, 3,  1]
 D = [7, 19, 7]
Input 2:
 A = [7, 15, 11]
 B = ["C", "A"]
 C = [2, 2]
 D = [9, 3]


Example Output
Output 1:
 [3, 4]
Input 2:
 [1]

Example Explanation

Explanation 1:

 Given array A = [1, 3, 121, 20, 17, 26, 29]. Let's list down queries:
 1. A 1 7 :  Number of primes in complete array [1-7] is 3 => 3, 17, 29
 2. C 3 19 : Change the number at index-3 to 19. So Array becomes : [1, 3, 19, 20, 17, 26, 29]
 3. A 1 7 : Number of primes in complete array [1-7] is 4 => 3, 19, 17, 29
 So output : [3, 4]
Explanation 2:

 Given array A = [7, 15, 11]. Let's list down queries:
 1. C 2 9 :  Change the number at index-2 to 9. So Array becomes : [7, 9, 11]
 2. A 2 3 : Number of primes in array [2 - 3] is 1 => 11
 So output : [1]
 */
public class hw_q2_Count_the_primes {

    public static void main(String[] args) {
        hw_q2_Count_the_primes t = new hw_q2_Count_the_primes();
        {
            int[] A = {1, 3, 121, 20, 17, 26, 29};
            String[] B = {"A", "C", "A"};
            int[] C = {1, 3, 1};
            int[] D = {7, 19, 7};
            System.out.println(Arrays.toString(t.solve(A, B, C, D))); // [3, 4]
        }
        {
            int[] A = {7, 15, 11};
            String[] B = {"C", "A"};
            int[] C = {2, 2};
            int[] D = {9, 3};
            System.out.println(Arrays.toString(t.solve(A, B, C, D))); // [1]
        }
    }

    // TC: O(N + logN)
    public int[] solve(int[] A, String[] B, int[] C, int[] D) {
        // build segment tree storing count of prime as value in given range
        int n = A.length;
        int[] seg = new int[n * 4];
        build(0, 0, n - 1, A, seg);

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < B.length; i++) {
            String type = B[i];
            if (type.equals("A")) {
                // find in range [l, r]
                int l = C[i];
                int r = D[i];
                int answer = query(0, 0, n - 1, l - 1, r - 1, seg);
                list.add(answer);
            } else {
                // update
                int index = C[i];
                int value = D[i];
                update(0, 0, n - 1, index - 1, value, A, seg);
            }
        }
        return list.stream().mapToInt(i -> i).toArray();
    }

    public void build(int currIndex, int start, int end, int[] A, int[] seg) {
        if (start == end) {
            seg[currIndex] = isPrime(A[start]) ? 1 : 0;
            return;
        }
        int mid = start + (end - start) / 2;
        int leftChildIndex = 2 * currIndex + 1;
        int rightChildIndex = 2 * currIndex + 2;
        build(leftChildIndex, start, mid, A, seg);
        build(rightChildIndex, mid + 1, end, A, seg);
        // update prime count value in parent nodes
        seg[currIndex] = seg[leftChildIndex] + seg[rightChildIndex];
    }

    public int query(int currIndex, int start, int end, int l, int r, int[] seg) {
        // disjoint condition/ non overlapping condition
        if (l > end || r < start) {
            return 0;
        }
        // completely overlapping condition
        if (start >= l && end <= r) {
            return seg[currIndex];
        }

        int mid = start + (end - start) / 2;
        int leftChildIndex = 2 * currIndex + 1;
        int rightChildIndex = 2 * currIndex + 2;
        int leftPrimes = query(leftChildIndex, start, mid, l, r, seg);
        int rightPrimes = query(rightChildIndex, mid + 1, end, l, r, seg);
        return leftPrimes + rightPrimes;
    }

    public void update(int currIndex, int start, int end, int index, int value, int[] A, int[] seg) {
        // update the element
        if (start == end) {
            seg[currIndex] = isPrime(value) ? 1 : 0;
            A[index] = value;
            return;
        }
        int mid = start + (end - start) / 2;
        int leftChildIndex = 2 * currIndex + 1;
        int rightChildIndex = 2 * currIndex + 2;
        if (index <= mid) {
            update(leftChildIndex, start, mid, index, value, A, seg);
        } else {
            update(rightChildIndex, mid + 1, end, index, value, A, seg);
        }
        // keep updating the prime count in the traversed path as the value is changed
        seg[currIndex] = seg[leftChildIndex] + seg[rightChildIndex];
    }

    public boolean isPrime(int N) {
        boolean isPrime = true;
        int count = 2;
        // iterate from 2 to sqrt(N)
        for (int i = 2; i * i <= N; i++) {
            if (N % i == 0) {
                count++;
                if (i != N / i) {
                    // if number i is a factor then N/i is also factor
                    // count only when i != N/i
                    count++;
                }
            }
        }
        if (count > 2 || N == 1 || N == 0) {
            isPrime = false;
        }
        return isPrime;
    }
}
