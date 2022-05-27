/* Reverse Bits */
public class hw_q2_Reverse_Bits {
    public long reverse(long A) {
        long result = 0;

        for (int i = 0; i < 32; i++) {
            if (checkBit(A, i)) {
                result += (((long) 1) << (31 - i));
            }
        }
        return result;
    }

    private boolean checkBit(long A, int pos) {
        if (((A >> pos) & 1) == 1)
            return true;
        return false;
    }

    public static void main(String[] args) {
        hw_q2_Reverse_Bits t1 = new hw_q2_Reverse_Bits();
        long A;
        {
            A = 0;
            System.out.println(t1.reverse(A)); // 0
        }
        {
            A = 3;
            System.out.println(t1.reverse(A)); // 3221225472
        }
        {
            A = 16;
            System.out.println(t1.reverse(A)); // 134217728
        }
    }
}
