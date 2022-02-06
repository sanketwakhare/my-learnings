import java.util.ArrayList;
import java.util.Comparator;

/* Sort by Color */

/***
 * Problem Description
 * 
 * Given an array with n objects colored red, white or blue, sort them so that
 * objects of the same color are adjacent, with the colors in the order red,
 * white and blue.
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white,
 * and blue respectively.
 * 
 * Note: Using library sort function is not allowed.
 * 
 * Problem Constraints
 * 1 <= N <= 1000000
 * 0 <= A[i] <= 2
 * 
 * Input Format
 * First and only argument of input contains an integer array A.
 * 
 * Output Format
 * Return an integer array in asked order
 * 
 * Example Input
 * Input 1 :
 * A = [0 1 2 0 1 2]
 * Input 2:
 * A = [0]
 * 
 * Example Output
 * Output 1:
 * [0 0 1 1 2 2]
 * Output 2:
 * [0]
 * 
 * Example Explanation
 * Explanation 1:
 * [0 0 1 1 2 2] is the required order.
 */

public class hw_q3_sortByColor {
    public static ArrayList<Integer> sortColors(ArrayList<Integer> A) {

        // custom sort in java
        A.sort(new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1 < o2) {
                    return -1;
                } else if (o1 > o2) {
                    return 1;
                }
                // if equal return 0
                return 0;
            }
        });
        return A;
    }

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<Integer>();
        A.add(1);
        A.add(2);
        A.add(0);
        A.add(2);
        A.add(1);
        A.add(0);
        A.add(2);
        A.add(1);
        A.add(0);
        A.add(1);
        A = sortColors(A);
        System.out.println(A);
    }
}