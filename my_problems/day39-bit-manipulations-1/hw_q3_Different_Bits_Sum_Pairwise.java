/* Different Bits Sum Pairwise - find contribution of 1s after XORing every pair*/
public class hw_q3_Different_Bits_Sum_Pairwise {
    public int cntBits(int[] A) {

        // Idea: contribution technique
        long answer = 0;
        long m = 1000000007;
        // for every bit position, find the set and unset bits
        // and consider every pair which can contribute the the final answer
        for (int pos = 0; pos < 32; pos++) {
            int setBits = 0;
            for (int i = 0; i < A.length; i++) {
                if (checkBit(A[i], pos)) {
                    setBits++;
                }
            }
            int unsetBits = A.length - setBits;
            // multiply by 2 as we are considering pair (i,j) and (j,i)
            long contribution = (long) setBits * (long) unsetBits * (long) 2;
            answer = (answer % m + contribution % m) % m;
        }
        return (int) answer;

    }

    private boolean checkBit(int n, int pos) {
        if (((n >> pos) & 1) == 1)
            return true;
        return false;
    }

    public static void main(String[] args) {
        hw_q3_Different_Bits_Sum_Pairwise t1 = new hw_q3_Different_Bits_Sum_Pairwise();
        System.out.println(t1.cntBits(new int[] { 1, 3, 5 }));
        System.out.println(t1.cntBits(new int[] { 2, 3 }));
        System.out.println(t1.cntBits(new int[] { 2, 6, 5, 4, 8 }));
        System.out.println(t1.cntBits(new int[] { 9 }));
    }
}

/* Different Bits Sum Pairwise - Approach */

// Brute Force
// f(X, Y) {
// val = X^Y
// 101 => count set in val = 2
// return countsetbits(2);
// }

// Contribution Technique
// 1, 3, 5 => 8

// 0001
// 0011
// 0101
// -----
// 0

// bit pos 0 1
// 0 0 3 => 3*0 = 0
// 1 2 1 => 2
// 2 2 1 => 2
// 3 3 0 => 0
// ==========================
// 4 * 2