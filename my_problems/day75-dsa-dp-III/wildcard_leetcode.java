/* https://leetcode.com/problems/regular-expression-matching/ */

public class wildcard_leetcode {
    public boolean isMatch(String s, String p) {

        return fn(s, p, s.length() - 1, p.length() - 1);

    }

    public boolean fn(String s, String p, int n, int m) {

        if (n < 0 && m < 0) {
            return true;
        } else if (n < 0 && m >= 0) {
            while (m >= 0) {
                // return true only when there are only * left in string B
                if (p.charAt(m) != '*') {
                    return false;
                }
                m = m - 2;
            }
            return true;
        } else if (n >= 0 && m < 0) {
            return false;
        }

        boolean state = false;
        if (s.charAt(n) == p.charAt(m) || p.charAt(m) == '.') {
            state = fn(s, p, n - 1, m - 1);
        } else if (p.charAt(m) == '*' && (p.charAt(m - 1) == s.charAt(n) || p.charAt(m - 1) == '.')) {
            state = (fn(s, p, n, m - 2) || fn(s, p, n - 1, m));
        } else if (p.charAt(m) == '*' && p.charAt(m - 1) != s.charAt(n)) {
            state = fn(s, p, n, m - 2);
        }
        return state;
    }

    public static void main(String[] args) {
        wildcard_leetcode t1 = new wildcard_leetcode();
        String s, p;

        {
            s = "aa";
            p = "a";
            System.out.println(t1.isMatch(s, p));
            s = "abcddddxy";
            p = "abcd*x*y";
            System.out.println(t1.isMatch(s, p));
        }
    }
}
