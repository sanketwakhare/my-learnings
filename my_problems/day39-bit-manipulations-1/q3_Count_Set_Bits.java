/* Count set bits */
public class q3_Count_Set_Bits {

    public int numSetBits(int A) {
        int cnt = 0;
        while (A > 0) {
            A = A & (A - 1);
            cnt++;
        }
        System.out.println(cnt);
        return cnt;
    }

    public static void main(String[] args) {
        q3_Count_Set_Bits t1 = new q3_Count_Set_Bits();
        t1.numSetBits(5);
        t1.numSetBits(3);
        t1.numSetBits(103);
        t1.numSetBits(54268);
        t1.numSetBits(16);
    }
}