/* In and integer array of size N, every element appears thrice except for one, find which occurs once. */
public class q1_SingleNumber_II {

    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int singleNumber(final int[] A) {
        int ans = 0;
        for (int pos = 0; pos < 32; pos++) {
            int cnt = 0;
            for (int i = 0; i < A.length; i++) {
                cnt += checkBit(A[i], pos) ? 1 : 0;
            }
            if (cnt % 3 > 0) {
                ans += (1 << pos);
            }
        }
        return ans;
    }

    private boolean checkBit(int n, int pos) {
        if ((1 & (n >> pos)) == 1)
            return true;
        return false;
    }

    public static void main(String[] args) {
        q1_SingleNumber_II t1 = new q1_SingleNumber_II();
        {
            int ans = t1.singleNumber(new int[] { 5, 4, 11, 4, 11, 9, 11, 5, 5, 4 });
            System.out.println(ans); // 9
        }
        {
            int ans = t1.singleNumber(new int[] { 1, 1, 2, 3, 1, 2, 3, 7, 2, 3 });
            System.out.println(ans); // 7
        }
    }
}
