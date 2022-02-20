import java.util.ArrayList;

/* Check for BST with One Child */
public class hw_q1_Check_for_BST_with_One_Child {

    public static String solve(ArrayList<Integer> A) {

        int startRange = Integer.MIN_VALUE;
        int endRange = Integer.MAX_VALUE;

        if (A == null || A.size() == 0 || A.size() == 1) {
            return "YES";
        }

        // assume root is inserted, the range does not change
        int prev = A.get(0);

        for (int i = 1; i < A.size(); i++) {
            int curr = A.get(i);
            if (curr < startRange || curr > endRange) {
                return "NO";
            }
            if (curr > prev) {
                // update start range
                startRange = prev + 1;
            } else if (curr < prev) {
                // update end range
                endRange = prev - 1;
            }
            // update prev
            prev = curr;
        }
        return "YES";
    }

    public static void main(String[] args) {

        // test case 1 A = [4, 10, 5, 8]
        ArrayList<Integer> A = new ArrayList<Integer>();
        A.add(4);
        A.add(10);
        A.add(5);
        A.add(8);
        System.out.println(solve(A));

        // test case 1 A = [1, 5, 6, 4]
        A = new ArrayList<Integer>();
        A.add(1);
        A.add(5);
        A.add(6);
        A.add(4);
        System.out.println(solve(A));

    }

}
