public class hw_q1_Interesting_Array {
    // if sum of all array element is 0, then it can be divided into 2 equal parts
    // and a^a = 0 , the array can be converted to single element 0
    public String solve(int[] A) {
        int val = 0;
        for (int i = 0; i < A.length; i++) {
            val ^= A[i];
        }
        if ((val ^ 1) == val + 1) {
            // even val
            return "Yes";
        }
        return "No";
    }

    public static void main(String[] args) {
        hw_q1_Interesting_Array t1 = new hw_q1_Interesting_Array();
        {
            System.out.println(t1.solve(new int[] { 9, 17 }));
            System.out.println(t1.solve(new int[] { 1 }));
            System.out.println(t1.solve(new int[] { 3, 5, 7, 9, 12, 42, 20, 16 }));
            System.out.println(t1.solve(new int[] { 20, 16 }));
        }
    }
}
