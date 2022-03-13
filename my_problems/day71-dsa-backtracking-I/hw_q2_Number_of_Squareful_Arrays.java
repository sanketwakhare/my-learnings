import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/* Number of Squareful Arrays */

/* Problem Description

Given an array of integers A, the array is squareful if for every pair of adjacent elements, their sum is a perfect square.

Find and return the number of permutations of A that are squareful. Two permutations A1 and A2 differ if and only if there is some index i such that A1[i] != A2[i].

Problem Constraints

1 <= length of the array <= 12
1 <= A[i] <= 10^9


Input Format

The only argument given is the integer array A.


Output Format

Return the number of permutations of A that are squareful.


Example Input

Input 1:

 A = [2, 2, 2]
Input 2:

 A = [1, 17, 8]


Example Output

Output 1:

 1
Output 2:

 2


Example Explanation

Explanation 1:

 Only permutation is [2, 2, 2], the sum of adjacent element is 4 and 4 and both are perfect square.
Explanation 2:

 Permutation are [1, 8, 17] and [17, 8, 1]. */

/**
 * TC: O(N!)
 * SC: (N)
 */
public class hw_q2_Number_of_Squareful_Arrays {

    static int count = 0;

    public int solve(ArrayList<Integer> A) {

        count = 0;
        squarefulPermutations(0, A);
        return count;
    }

    // recursive function
    public void squarefulPermutations(int i, ArrayList<Integer> A) {

        // edge case for size=0
        if (A.size() == 0) {
            count = 0;
        }
        // edge case when size of array is 1
        if (A.size() == 1) {
            if (isSquare(A.get(0))) {
                count++;
            }
            return;
        }

        // base condition
        if (i == A.size()) {
            count++;
        }

        // maintain a set to avoid repeated elements
        Set<Integer> set = new HashSet<Integer>();
        for (int k = i; k < A.size(); k++) {
            if (!set.contains(A.get(k))) {
                // do swap
                swap(A, i, k);
                // if i==0, call recursive function
                if (i == 0) {
                    squarefulPermutations(i + 1, A);
                } else {
                    // if sum is perfect square, call recursive function
                    int sum = A.get(i) + A.get(i - 1);
                    if (isSquare(sum)) {
                        squarefulPermutations(i + 1, A);
                    }
                }
                // undo swap
                swap(A, i, k);
                // insert current element into set
                set.add(A.get(k));
            }
        }
    }

    // util function
    public boolean isSquare(long sum) {
        double sqrt = Math.sqrt(sum);
        if (sqrt - Math.floor(sqrt) != 0) {
            return false;
        }
        return true;
    }

    // util function
    public void swap(ArrayList<Integer> A, int i, int k) {
        int temp = A.get(i);
        A.set(i, A.get(k));
        A.set(k, temp);
    }

    public static void main(String[] args) {

        hw_q2_Number_of_Squareful_Arrays t1 = new hw_q2_Number_of_Squareful_Arrays();
        // test case 1
        Integer[] A = new Integer[] { 2, 2, 2 };
        ArrayList<Integer> inputList = new ArrayList<Integer>(Arrays.asList(A));
        int count = t1.solve(inputList);
        System.out.println(count); // 1

        // test case 2
        A = new Integer[] { 1, 17, 8 };
        inputList = new ArrayList<Integer>(Arrays.asList(A));
        count = t1.solve(inputList);
        System.out.println(count); // 2

        // test case 3
        A = new Integer[] { 41 };
        inputList = new ArrayList<Integer>(Arrays.asList(A));
        count = t1.solve(inputList);
        System.out.println(count); // 0

        // test case 4
        A = new Integer[] { 5050, 879, 82, 18, 82, 18, 18, 31, 33, 88, 137 };
        inputList = new ArrayList<Integer>(Arrays.asList(A));
        count = t1.solve(inputList);
        System.out.println(count); // 4

        // test case 5
        A = new Integer[] { 36 };
        inputList = new ArrayList<Integer>(Arrays.asList(A));
        count = t1.solve(inputList);
        System.out.println(count); // 1
    }

}