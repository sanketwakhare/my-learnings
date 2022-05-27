/* Smallest XOR */
public class hw_q1_Smallest_XOR {
    public int solve(int A, int B) {

        int count_setBits = 0;
        // count set bits
        for (int i = 0; i < 32; i++) {
            if (checkBit(A, i)) {
                count_setBits++;
            }
        }
        // compare B and count, if no of set bits in A are same as B, min xor will be 0
        if (B == count_setBits)
            return A;

        int X = A;
        if (count_setBits > B) {
            X = 0;
            // start from right, do this B times
            for (int i = 31; i >= 0 && B > 0; i--) {
                if (checkBit(A, i)) {
                    X = X + (1 << i);
                    B--;
                }
            }
        } else {
            // start from left, do this temp time
            int temp = B - count_setBits;
            for (int i = 0; i < 32 && temp > 0; i++) {
                if (!checkBit(A, i)) {
                    X = X + (1 << i);
                    temp--;
                }
            }
        }
        return X;

    }

    private boolean checkBit(int A, int pos) {
        if (((A >> pos) & 1) == 1)
            return true;
        return false;
    }

    public static void main(String[] args) {
        int A, B;
        hw_q1_Smallest_XOR t1 = new hw_q1_Smallest_XOR();
        {
            A = 11;
            B = 1;
            int x = t1.solve(A, B);
            System.out.println(x);
        }
        {
            A = 3;
            B = 3;
            int x = t1.solve(A, B);
            System.out.println(x);
        }
        {
            A = 4;
            B = 1;
            int x = t1.solve(A, B);
            System.out.println(x);
        }
        {
            A = 15;
            B = 2;
            int x = t1.solve(A, B);
            System.out.println(x);
        }
    }
}

// A = 3 = 00101
// X = ? ^ 0111
// ----
// temp 1

// (no of set bits in X = B = 3)

// 100 1011 B = 1 temp = 2
// 6
