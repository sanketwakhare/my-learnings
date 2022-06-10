public class q3_PowerMod {

    public long myPower(long a,long n, long m) {
        if(n==0) {
            return 1 % m;
        }
        if(n==1) {
            return a % m;
        }
        long p = myPower(a,n/2,m);
        long value = ((p%m) * (p%m))%m;

        if(n%2 != 0) {
            value = ((value % m) * (a % m)) % m;
        }
        return value % m;
    }

    public int pow(int A, int B, int C) {
        int ans =  (int)myPower(A,B,C);
        if(ans < 0) {
            ans = ans + C;
        }
        return ans;
    }
}
