public class q1_Max_Absolute_Difference {

    public int maxArr(int[] A) {

        // break the Mod value into possible equations
        // A[i] - A[j] + (i - j) => (A[i] + i) - (A[j] + j) -> x
        // A[j] - A[i] + (j - i) => (A[j] + j) - (A[i] + i) -> same as x
        // A[i] - A[j] + (j - i) => (A[i] - i) - (A[j] - j) -> y
        // A[j] - A[i] + (i - j) => (A[j] - j) - (A[i] - i) -> same as y as i and j
        // represents same array index

        // To find a Max difference, we need to find difference for each equation

        // case 1 -> find value of x
        int maxAdd = A[0] + 0;
        int minAdd = A[0] + 0;
        for (int i = 0; i < A.length; i++) {
            maxAdd = Math.max(maxAdd, A[i] + i);
            minAdd = Math.min(minAdd, A[i] + i);
        }
        int case1 = maxAdd - minAdd;

        // case 1 -> find value of y
        int maxSub = A[0] - 0;
        int minSub = A[0] - 0;
        for (int i = 0; i < A.length; i++) {
            maxSub = Math.max(maxSub, A[i] - i);
            minSub = Math.min(minSub, A[i] - i);
        }
        int case2 = maxSub - minSub;

        return Math.max(case1, case2);
    }

    public static void main(String[] args) {
        q1_Max_Absolute_Difference t1 = new q1_Max_Absolute_Difference();
        {
            int[] A = new int[] { 6, 1, 8, 3, 4, 5 };
            System.out.println(t1.maxArr(A)); // 8
        }
        {
            int[] A = new int[] { 1, 3, -1 };
            System.out.println(t1.maxArr(A)); // 5
        }
    }
}
