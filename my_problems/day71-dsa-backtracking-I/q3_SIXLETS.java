/* SIXLETS */

/* 
Problem Description
Given a array of integers A of size N and an integer B.

Return number of non-empty subsequences of A of size B having sum <= 1000.


Problem Constraints
1 <= N <= 20
1 <= A[i] <= 1000
1 <= B <= N


Input Format
The first argument given is the integer array A.

The second argument given is the integer B.


Output Format
Return number of subsequences of A of size B having sum <= 1000.


Example Input
Input 1:

    A = [1, 2, 8]
    B = 2
Input 2:

    A = [5, 17, 1000, 11]
    B = 4


Example Output
Output 1:

3
Output 2:

0


Example Explanation
Explanation 1:

 {1, 2}, {1, 8}, {2, 8}
Explanation 1:

 No valid subsequence
 */

import java.util.ArrayList;
import java.util.Arrays;

public class q3_SIXLETS {

    public static int solve(ArrayList<Integer> A, int B) {

        ArrayList<Integer> temp = new ArrayList<Integer>();
        return subsequences(0, A, temp, B, 0);
    }

    public static int subsequences(int i, ArrayList<Integer> A, ArrayList<Integer> temp, int B, int sum) {

        // base condition
        if (i == A.size()) {
            if (sum <= 1000 && temp.size() == B) {
                System.out.println(temp);
                return 1;
            } else {
                return 0;
            }
        }

        int currEle = A.get(i);

        // add
        sum = sum + currEle;
        temp.add(currEle);
        int x = subsequences(i + 1, A, temp, B, sum);

        // remove
        sum = sum - currEle;
        temp.remove(temp.size() - 1);
        int y = subsequences(i + 1, A, temp, B, sum);

        return x + y;
    }

    public static void main(String[] args) {

        // test case 1
        Integer[] A = new Integer[] { 1, 2, 8 };
        ArrayList<Integer> inputList = new ArrayList<Integer>(Arrays.asList(A));
        int B = 2;
        int count = solve(inputList, B);
        /* expected output: 3 */
        System.out.println(count);

        // test case 2
        A = new Integer[] { 5, 17, 1000, 11 };
        inputList = new ArrayList<Integer>(Arrays.asList(A));
        B = 1000;
        count = solve(inputList, B);
        /* expected output: 0 */
        System.out.println(count);

        // test case 3
        A = new Integer[] { 3, 5, 7, 8, 1, 2, 4 };
        inputList = new ArrayList<Integer>(Arrays.asList(A));
        B = 6;
        count = solve(inputList, B);
        /* expected output: 0 */
        System.out.println(count);
    }

}
