/*
  Playing Among Digits
 */
public class q3_working_solution {

    public static void main(String[] args) {
        q3_working_solution t = new q3_working_solution();
        int res = t.solve("34242", "53535345", 4); // 3296840
        System.out.println(res);
    }
    static boolean[] p;
    static long mod = 1000000007;

    static void seive(boolean p[]) {

        p[0] = true;
        p[1] = true;
        for (int i = 2; i * i < p.length; i++)
            if (p[i] == false) {
                for (int j = i * i; j < p.length; j = j + i)
                    p[j] = true;
            }
    }

    static long[][][][] dp;

    static long calc(char s[], int pos, int sum, int rem, int flag, int k) {

        if (pos == s.length)
            return (p[sum] == false && rem == 0) ? 1 : 0;
        if (dp[pos][sum][rem][flag] != -1)
            return dp[pos][sum][rem][flag];

        long ans = 0;

        int maxd = flag == 1 ? 9 : (s[pos] - '0');

        for (int i = 0; i <= maxd; i++) {
            int zz = (flag == 1 || i < maxd) ? 1 : 0;
            ans = ans + calc(s, pos + 1, sum + i, (rem * 10 + i) % k, zz, k);
            ans %= mod;
        }
        return dp[pos][sum][rem][flag] = ans;
    }

    static long solve1(long n, int k1) {
        char s[] = (n + "").toCharArray();
        dp = new long[s.length][200][k1][2];
        for (int i = 0; i < s.length; i++)
            for (int j = 0; j < 200; j++)
                for (int k = 0; k < k1; k++)
                    for (int l = 0; l < 2; l++)
                        dp[i][j][k][l] = -1;

        return calc(s, 0, 0, 0, 0, k1);
    }

    static boolean check(long num) {
        int s = 0;
        while (num > 0) {
            s = s + (int) (num % 10);
            num = num / 10;
        }
        return p[s] == false ? true : false;
    }

    public int solve(String a, String b, int C) {
        p = new boolean[200];
        seive(p);
        long A = 0;
        long B = 0;
        long k = (long) C;
        for (int i = 0; i < a.length(); i++)
            A = (A * 10) + (a.charAt(i) - '0');
        for (int i = 0; i < b.length(); i++)
            B = (B * 10) + (b.charAt(i) - '0');
        long ans = 0;
        if (k <= 1500)
            ans = solve1(B, (int) k) - solve1(A - 1, (int) k);
        else {
            long st = 0;
            if (A % k == 0)
                st = A;
            else
                st = (A / k + 1) * k;
            for (long j = st; j <= B; j = j + k)
                if (check(j)) {
                    ans++;
                    ans %= mod;
                }
        }
        return (int) ans;
    }
}