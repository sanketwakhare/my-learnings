public class hw_q1_Check_for_BST_with_One_Child_practise {
    public static void main(String[] args) {
        hw_q1_Check_for_BST_with_One_Child_practise t1 = new hw_q1_Check_for_BST_with_One_Child_practise();
        System.out.println(t1.solve(new int[]{1, 5, 6, 4}));
        System.out.println(t1.solve(new int[]{12, 1, 9, 6, 2}));

    }

    public String solve(int[] A) {

        // base case
        if (A == null || A.length == 0 || A.length == 1) return "YES";

        // valid range
        int start = Integer.MIN_VALUE;
        int end = Integer.MAX_VALUE;
        // maintain previous value
        int prev = A[0];
        for (int index = 1; index < A.length; index++) {
            // current value
            int curr = A[index];
            if (curr < start || curr > end) return "NO";
            if (curr < prev) {
                end = prev - 1;
            } else {
                start = prev + 1;
            }
            // update previous value
            prev = curr;
        }
        return "YES";
    }

}
