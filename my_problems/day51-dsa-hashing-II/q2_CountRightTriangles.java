/* Count Right Triangles */

/***
 * Problem Description

Given two arrays of integers A and B of size N each, where each pair (A[i], B[i]) for 0 <= i < N represents a unique point (x, y) in 2D Cartesian plane.
Find and return the number of unordered triplets (i, j, k) such that (A[i], B[i]), (A[j], B[j]) and (A[k], B[k]) form a right angled triangle with the triangle having one side parallel to the x-axis and one side parallel to the y-axis.

NOTE: The answer may be large so return the answer modulo (109 + 7).

Problem Constraints
1 <= N <= 10^5
0 <= A[i], B[i] <= 10^9

Input Format
The first argument given is an integer array A.
The second argument given is the integer array B.

Output Format
Return the number of unordered triplets that form a right angled triangle modulo (109 + 7).

Example Input
Input 1:
 A = [1, 1, 2]
 B = [1, 2, 1]
Input 2:
 A = [1, 1, 2, 3, 3]
 B = [1, 2, 1, 2, 1]

Example Output
Output 1:
 1
Output 2:
 6

Example Explanation
Explanation 1:
 All three points make a right angled triangle. So return 1.
Explanation 2:
 6 quadruplets which make a right angled triangle are: (1, 1), (1, 2), (2, 2)
                                                       (1, 1), (3, 1), (3, 2)
                                                       (2, 1), (3, 1), (3, 2)
                                                       (1, 1), (1, 2), (3, 2)
                                                       (1, 2), (3, 1), (3, 2)
 */

import java.util.HashMap;
import java.util.Map;

/**
 * TC: O(N) for iterating over each coordinate and calculate no of triangles
 * SC: O(N) for hashmap
 */
public class q2_CountRightTriangles {

    public static int countRightTriangles(int[] A, int[] B) {

        long m = 1000000007;

        // Idea: store the frequency of x and y coordinates on a single line
        // and for each coordinate, count the coordinates which are on single line for x
        // and y axis and multiply to get the no of triangles

        // prepare map for x axis with count of coordinates in current horizontal line
        Map<Integer, Integer> xMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < A.length; i++) {
            if (xMap.containsKey(A[i])) {
                xMap.put(A[i], xMap.get(A[i]) + 1);
            } else {
                xMap.put(A[i], 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : xMap.entrySet()) {
            System.out.println(entry.getKey() + "->" + entry.getValue());
        }

        // prepare map for y axis with count of coordinates in current vertical line
        Map<Integer, Integer> yMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < B.length; i++) {
            if (yMap.containsKey(B[i])) {
                yMap.put(B[i], yMap.get(B[i]) + 1);
            } else {
                yMap.put(B[i], 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : yMap.entrySet()) {
            System.out.println(entry.getKey() + "->" + entry.getValue());
        }

        long answer = 0;
        // now iterate over array and for each coordinate calculate no of triangles
        // which can be formed
        for (int i = 0; i < A.length; i++) {

            int x = A[i];
            int y = B[i];

            int noOfPointsOnXAxis = xMap.get(x);
            int noOfPointsOnYAxis = yMap.get(y);

            // count no of triangles which can be formed with current coordinate as middle
            // point/ 90deg
            long trianglesCount = (((noOfPointsOnXAxis - 1) % m) * ((noOfPointsOnYAxis - 1) % m)) % m;

            answer = ((answer % m) + (trianglesCount % m)) % m;
        }

        return (int) answer;
    }

    public static void main(String[] args) {

        // expected answer 1
        int[] A1 = { 1, 1, 2 };
        int[] B1 = { 1, 2, 1 };
        int answer1 = countRightTriangles(A1, B1);
        System.out.println("answer1 -> " + answer1);

        // expected answer 6
        int[] A2 = { 1, 1, 2, 3, 3 };
        int[] B2 = { 1, 2, 1, 2, 1 };
        int answer2 = countRightTriangles(A2, B2);
        System.out.println("answer2 -> " + answer2);

        // expected answer 2
        int[] A3 = { 19, 66, 70, 82, 55, 1, 22, 18, 10, 69, 60, 67, 51, 63, 81, 13, 65, 87, 65, 66, 97, 86, 9, 53, 47,
                3, 50, 16, 43 };
        int[] B3 = { 30, 31, 8, 83, 8, 100, 35, 0, 3, 93, 81, 27, 21, 89, 24, 4, 54, 50, 31, 59, 36, 96, 0, 63, 44, 51,
                44, 93, 48 };
        int answer3 = countRightTriangles(A3, B3);
        System.out.println("answer3 -> " + answer3);

        // expected answer 0
        int[] A4 = { 0 };
        int[] B4 = { 0 };
        int answer4 = countRightTriangles(A4, B4);
        System.out.println("answer4 -> " + answer4);
    }

}
