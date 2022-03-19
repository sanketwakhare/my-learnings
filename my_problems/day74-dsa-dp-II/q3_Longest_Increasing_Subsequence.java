import java.util.ArrayList;
import java.util.List;

/* Longest Increasing Subsequence */
public class q3_Longest_Increasing_Subsequence {

    static int max = Integer.MIN_VALUE;

    public void backtrack(int index, int n, int[] A, List<Integer> list) {

        if (index == n) {
            ArrayList<Integer> temp = new ArrayList<Integer>(list);
            if (max < list.size()) {
                max = list.size();
                System.out.println(temp);
            }
            return;
        }

        if ((list.size() == 0) || (list.size() > 0 && A[index] >= list.get(list.size() - 1))) {
            list.add(A[index]);
            backtrack(index + 1, n, A, list);
            list.remove(list.size() - 1);
        }
        backtrack(index + 1, n, A, list);
    }

    public static void main(String[] args) {

        q3_Longest_Increasing_Subsequence t1 = new q3_Longest_Increasing_Subsequence();
        int[] A;

        {
            System.out.println("Approach 1 - backtrack");
            A = new int[] { 1, 2, 1, 5 };
            t1.backtrack(0, A.length, A, new ArrayList<Integer>());
            System.out.println(max);

            A = new int[] { 0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15 };
            t1.backtrack(0, A.length, A, new ArrayList<Integer>());
            System.out.println(max);
        }

    }
}