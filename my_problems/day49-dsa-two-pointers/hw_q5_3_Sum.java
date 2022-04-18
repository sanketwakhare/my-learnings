import java.util.Arrays;

/* 3 Sum */

/* Problem Description
Given an array A of N integers, find three integers in A such that the sum is closest to a given number B. Return the sum of those three integers.

Assume that there will only be one solution.

Problem Constraints
-10^8 <= B <= 10^8
1 <= N <= 104
-10^8 <= A[i] <= 10^8


Input Format
First argument is an integer array A of size N.

Second argument is an integer B denoting the sum you need to get close to.

Output Format
Return a single integer denoting the sum of three integers which is closest to B.

Example Input
Input 1:

A = [-1, 2, 1, -4]
B = 1
Input 2:

 
A = [1, 2, 3]
B = 6


Example Output
Output 1:

2
Output 2:

6


Example Explanation
Explanation 1:

 The sum that is closest to the target is 2. (-1 + 2 + 1 = 2)
Explanation 2:

 Take all elements to get exactly 6. */

public class hw_q5_3_Sum {
    public int threeSumClosest(int[] A, int B) {

        // sort teh array
        Arrays.sort(A);

        if (A.length < 3) {
            int sm = 0;
            for (int i = 0; i < A.length; i++) {
                sm += A[i];
            }
            return sm;
        }

        int sum = A[0] + A[1] + A[2];
        int answer = sum;
        // fix i and apply 2 pointers method
        for (int i = 0; i < A.length - 2; i++) {

            int low = i + 1;
            int high = A.length - 1;

            while (low < high) {

                sum = A[i] + A[low] + A[high];
                if (sum == B) {
                    return sum;
                } else if (sum > B) {
                    high--;
                } else {
                    low++;
                }
                // check if we get the min difference
                if (Math.abs(sum - B) < Math.abs(answer - B)) {
                    answer = sum;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {

        hw_q5_3_Sum t1 = new hw_q5_3_Sum();
        int[] A;
        int B;

        {
            A = new int[] { -1, 2, 1, -4 };
            B = 1;
            System.out.println(t1.threeSumClosest(A, B)); // 2
        }
        {
            A = new int[] { 1, 2, 3 };
            B = 50;
            System.out.println(t1.threeSumClosest(A, B)); // 6
        }
        {
            A = new int[] { 1, 12, 3, 4, 13, 15, 14, 9, 8, 7 };
            B = 1;
            System.out.println(t1.threeSumClosest(A, B)); // 8
        }
    }
}
