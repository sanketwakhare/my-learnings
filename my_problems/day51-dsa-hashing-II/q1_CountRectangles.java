import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* 
Count Rectangles

Problem Description

Given two arrays of integers A and B of size N each, where each pair (A[i], B[i]) for 0 <= i < N represents a unique point (x, y) in 2-D Cartesian plane.

Find and return the number of unordered quadruplet (i, j, k, l) such that (A[i], B[i]), (A[j], B[j]), (A[k], B[k]) and (A[l], B[l]) form a rectangle with the rectangle having all the sides parallel to either x-axis or y-axis.

Problem Constraints
1 <= N <= 2000
0 <= A[i], B[i] <= 10^9

Input Format
The first argument given is the integer array A.
The second argument given is the integer array B.

Output Format
Return the number of unordered quadruplet that form a rectangle.

Example Input
Input 1:
 A = [1, 1, 2, 2]
 B = [1, 2, 1, 2]
Input 1:
 A = [1, 1, 2, 2, 3, 3]
 B = [1, 2, 1, 2, 1, 2]

Example Output
Output 1:
 1
Output 2:
 3

Example Explanation
Explanation 1:
 All four given points make a rectangle. So, the answer is 1.
Explanation 2:
 3 quadruplets which make a rectangle are: (1, 1), (2, 1), (2, 2), (1, 2)
                                           (1, 1), (3, 1), (3, 2), (1, 2)
                                           (2, 1), (3, 1), (3, 2), (2, 2) */

public class q1_CountRectangles {

    public int solve(int[] A, int[] B) {

        // Generate set of coordinates
        // use array list as it implements the equals and hashCode method
        // which will verify the equality of coordinate in set
        Set<List<Integer>> set = new HashSet<List<Integer>>();
        for (int i = 0; i < A.length; i++) {
            List<Integer> list = new ArrayList<Integer>(2);
            list.add(A[i]);
            list.add(B[i]);
            set.add(list);
        }

        // initialize count of rectangles
        int count = 0;

        // N^2 approach: fix one coordinate and consider each other coordinate as
        // diagonal
        for (int i = 0; i < A.length - 1; i++) {

            // first coordinate
            int x1 = A[i];
            int y1 = B[i];

            // for every coordinate, select another co-ordinate and consider it as diagonal
            for (int j = i + 1; j < A.length; j++) {

                // second coordinate
                int x3 = A[j];
                int y3 = B[j];

                // get coordinates remaining points of rectangles from diagonal points
                int x2 = x3;
                int y2 = y1;
                List<Integer> c2 = new ArrayList<Integer>(2);
                c2.add(x2);
                c2.add(y2);

                int x4 = x1;
                int y4 = y3;
                List<Integer> c4 = new ArrayList<Integer>(2);
                c4.add(x4);
                c4.add(y4);

                // check if given coordinate exist in set
                if (set.contains(c2) && set.contains(c4)) {
                    // condition for checking horizontal line and vertical line
                    // lines will not form the rectangels
                    if (y1 == y3 || x1 == x3) {
                        continue;
                    }
                    // otherwise increase count
                    count++;
                }
            }
        }

        // divide the rectangles count by 2 as those are considered 2 times
        return count / 2;
    }

}
