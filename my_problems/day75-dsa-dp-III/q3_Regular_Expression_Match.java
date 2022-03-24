import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* Regular Expression Match */

/* Problem Description

Implement wildcard pattern matching with support for ' ? ' and ' * ' for strings A and B.

' ? ' : Matches any single character.
' * ' : Matches any sequence of characters (including the empty sequence).
The matching should cover the entire input string (not partial).



Problem Constraints

1 <= length(A), length(B) <= 10^4


Input Format

The first argument of input contains a string A.
The second argument of input contains a string B.


Output Format

Return 1 if the patterns match else return 0.



Example Input

Input 1:

 A = "aaa"
 B = "a*"
Input 2:

 A = "acz"
 B = "a?a"


Example Output

Output 1:

 1
Output 2:

 0


Example Explanation

Explanation 1:

 Since '*' matches any sequence of characters. Last two 'a' in string A will be match by '*'.
 So, the pattern matches we return 1.
Explanation 2:

 '?' matches any single character. First two character in string A will be match. 
 But the last character i.e 'z' != 'a'. Return 0. */

public class q3_Regular_Expression_Match {

    /**
     * Approach 1 - backtracking
     * TC: O(n x m)
     * SC: recursion stack space => O(max(n,m))
     */
    public boolean backtrack(int n, int m, String A, String B) {

        if (n < 0 && m < 0) {
            // if no more characters left for comparison
            return true;
        } else if (n >= 0 && m < 0) {
            // if no more characters left in pattern and there are still some characters
            // left in input string
            return false;
        } else if (n < 0 && m >= 0) {
            // if no more characters left from input string and some characters left in
            // pattern
            while (m >= 0) {
                // return true only when there are only * left in string B
                if (B.charAt(m) != '*') {
                    return false;
                }
                m--;
            }
            return true;
        }

        char aChar = A.charAt(n);
        char bChar = B.charAt(m);

        boolean state = false;
        if ((aChar == bChar) || (bChar == '?')) {
            // both characters match or ? is present in pattern
            state = backtrack(n - 1, m - 1, A, B);
        } else if (bChar == '*') {
            // pick nothing for * || pick a character for *
            state = (backtrack(n, m - 1, A, B) || backtrack(n - 1, m, A, B));
        }
        return state;
    }

    /**
     * Approach 2 - recursion + DP - using HashMap [as using dp array not working -
     * TLE- heap space error as constraints are 10^4]
     * TC: O(n x m)
     * SC: recursion stack space O(max(n,m)) + map size O(n x m)
     */
    public int recursion_dp(int n, int m, String A, String B, Map<String, Integer> map) {

        if (n < 0 && m < 0) {
            // if no more characters left for comparison
            return 1;
        } else if (n >= 0 && m < 0) {
            // if no more characters left in pattern and there are still some characters
            // left in input string
            return 0;
        } else if (n < 0 && m >= 0) {
            // if no more characters left from input string and some characters left in
            // pattern
            while (m >= 0) {
                // return true only when there are only * left in string B
                if (B.charAt(m) != '*') {
                    return 0;
                }
                m--;
            }
            return 1;
        }

        char aChar = A.charAt(n);
        char bChar = B.charAt(m);
        // prepare key/hash for map
        String key = new String(String.valueOf(n) + "+" + String.valueOf(m));

        // reuse if subproblem already solved
        if (map.containsKey(key)) {
            return map.get(key);
        }

        int state = -1;
        if ((aChar == bChar) || (bChar == '?')) {
            // both characters match or ? is present in pattern
            state = recursion_dp(n - 1, m - 1, A, B, map);
        } else if (bChar == '*') {
            // pick nothing for * || pick a character for *
            state = ((recursion_dp(n, m - 1, A, B, map) == 1) || (recursion_dp(n - 1, m, A, B, map) == 1)) ? 1 : 0;
        } else {
            // if characters does not match
            state = 0;
        }
        // add newly calculated value in map
        map.put(key, state);
        return state;
    }

    /**
     * Approach 3 - recursion + DP - using HashMap [as using dp array not working -
     * TLE- heap space error as constraints are 10^4]
     * TC: O(n x m)
     * SC: recursion stack space O(max(n,m)) + map size O(n x m)
     */
    public int tabulation_dp(String A, String B) {

        // TODO
        return -1;
    }

    // TODO: Approach 4 space optimization

    public static void main(String[] args) {

        q3_Regular_Expression_Match t1 = new q3_Regular_Expression_Match();
        String A; // input string to test
        String B; // pattern
        int n, m;
        int[][] dp;

        {
            // Approach 1 - backtracking
            System.out.println("Approach 1 - backtracking");

            // test case 1
            A = "aaa";
            B = "a*";
            n = A.length();
            m = B.length();
            System.out.println(t1.backtrack(n - 1, m - 1, A, B)); // true

            // test case 2
            A = "acz";
            B = "a?a";
            n = A.length();
            m = B.length();
            System.out.println(t1.backtrack(n - 1, m - 1, A, B)); // false
        }
        {
            // Approach 2 - recursion + DP
            System.out.println("Approach 2 - recursion + DP");

            // test case 1
            A = "aaa";
            B = "a*";
            n = A.length();
            m = B.length();
            Map<String, Integer> map = new HashMap<String, Integer>();
            System.out.println(t1.recursion_dp(n - 1, m - 1, A, B, map)); // 1

            // test case 2
            A = "acz";
            B = "a?a";
            n = A.length();
            m = B.length();
            map = new HashMap<String, Integer>();
            System.out.println(t1.recursion_dp(n - 1, m - 1, A, B, map)); // 0

            A = "cbabbbaaabaaaaacacbccacbaabcbbaabaccaaccabbcabccabcbbbcbbcacacccacbbacabbbaabaabbbccacbccacbcbbcbbabcaccccaabcaccacaabcacacbbaccccbaccabbccaacaabcacaaccbcaabababbbacbbcccaabbbbbbcbcaaaaabbbbcaabbaccbcaccbcaccbaabbabbcabcbbcacaccbbacbcbbbbbbbaccabaccaccaababccabcbaaaccbbcacacccbcaacbbbcaabbbacabcbabaababcacabacaabbbaaabcaabbccbbcabaacbcbcbbcccabacccbaacabcababcbcabbbcbcbcbbbcbacbbbccccabbcbbcbbcccbabbbbcccacccacbbbacbacbbacabbcabcaaabccacbbccccaacbaacbbccccbcbbabacbbccaacabababbabccaaaabcccaabbccbcbabbbccacbccacaaccaaaccbbbcabbaccaaaaacaabaccbaccccbcacaacbacabcaacaccabcaaccaabbbcbcbcbccacaaacbccaabbbcccabbababbbcabcbccacccccbcbcacccbbcbabcbcaacbaaabbaacbaccaabaccbaabcabbcbcbcccccbabccaaabbcccbababaabcabbbccabcacccbabaccacaacccaacbccacaccbcbabcbcaacbcaabcaabcccbccbcbccbcccacccbbbbcacbbcccacbabaabacaccbbbccbcbaaaaaaabcbbbcbcababaccacbcaccaabbbaabcaaabcccbccbcbccaaabcabcaccaccbbbbcaaabbccbbaccccaaabbbcbacbcabbbcbccaaababcabaabcccbaaaabcbbcaccbacccbbbabaaaaacabacccbbbacbcbccabbbbbbbccbbbbcacbaaacbbcaaaacaaccacaacbccabbcbabbccaabcbccbbaccacbccabacbbcbccbcbabbacbbcccbaaccbccacccbbaacaaaaaaaccacababbabbbcccaabbcccccbabbcbcacaacbacbccbbabccbaabacbcacbaccccacbabbacaabbaacbaabcaccccabaaacabbcbbbbbaabcaabaabbbcababcaaacabaabcaabaacabacccbcbaccbcabbcbcabccbabbbacbabacaaacababacbbaccacabacbabcaabacbbbaacbaaccbacaccabaacbcabbbaccbaacccacbaacacaacaabcaabbbbcbababaacaacbacbcbaaccbaabcbccbacccbcabccbbccabcaacbbbcababbbaaabaabbacbaababcacbcab";
            B = "c*c*?a*ac?*cb?b?abaccc?abb?cb?bc??b**c?b*?bbac**a*c*a?b?cb??***a?*b?b?a?*c??**?a??b*?*cb?aa*caca*a*aba*accbaaaa*?b*abc*a*cccbb?b*aababac?*cc**b?ac**?**b*abb?cba?a?a??cb**a?a?b*a*?a??caca????ac?b*?*cc??bcb*acb?*cacb*a?cab*cabc???*a?bcaaaaaaba*?b**a?*?baccbbaa*abba??ba?b?bb??ab**b*?ab?cacccb*b?cacbaba??cabac?bba*babaccab?a?baaab?*a?b**accc*cacbbac*?*?bcbb?c?ca?ccabb*c*bcc*??b?c??c*b*ac??*c?acaa*?a?caabaabccacbc??ca??bba*ba*aa*cbcbbc*bbb?aabacac*cbb*acabbab?c*bcaccaa*c?a?a?ac*ac?*a*ac**??*?a*?ac*aba**??aa?b**abab?a*c?b?abac?**?*ac**aacc*babac*c?*??accb*cb?ab*abba?aaaa**acccc*cc?a?bbc?*bccca????*ab*accbba?b**caa?*abbc*??aa?ba?aaab???cbbaabc?*a*b?ba?aacb*cc?c???bbaaaaa?bc*aabc??c*?acabab?cab*cba*b?**b*baa*b*b*b?ac**?*?aca?**cc*??a***?a?*?ca?b?b??bb?*b??abbc????caac****?a?bacba*b*ac*?bbcb?ccc??*?aab?b*c?a?caab*?*?b?ac*cb*c**?ccc?abb*cabc??a*?a?b????c?aaca*bacc?*cacb**c**?b*?ccb?bb*bab*c?a*bbaccb?b??*a*c??cc?cbbcccbca*a*c**?b*c?*c?abcb*c?a*ab**?a*bbbc?a?b?b*bacc?b*cab?aa?a???*a*c?a??*a?*c?a?cc*ac?ccbb*?b?b??a?**ca*acbbaca*??bbaba*c?b*aa??bc?bc?aa?a*bab*ca?bcb?c*****ab?*b*ca*?aa?*cca?*caabcc*abb*c?*??b?ac*?a*cab??*aa?bb?*acc*aca*b*ac?acb*?bbaabbb?b*bbb?c??aacb?cb?c**?b??c*bc?*ccb*?ccbc*c*b*?bb?**cb?**abb?c?babac*cc*bbb?a*abbbbc*b*??ccba**b?aac*ac*cab*a?ab?*acb?aab*aabbaab?bcb??b?*aa*c*ac?*cb*b?a*bcabb*aa*a*bc?aa**??**aa?aaac*a**ca*cc?accacc***?a*cb*b*?*?c*?*a?cacac**??cb*?**c?ac?a?ababc??abc?*a*?*ac*?*ab?bc*?b?ac??b*c**acb*b?a?a*b*??a??accc??cca???*c**c?**?bbb*c?abbaac*bcb*ac*b**cc?a?cb?*cc****ca?**ba*a?ccba*cb*caca**?ab??ccc*ab?acb??caaa*bc*ab*bb*c?*a*c*a**?*cc**ba?babacacbb*a*ba?a?c*bacba?ba?cbcc*cbb*bb*a*??accac?bca?b?c*ab??**ac?*?a*?b*?ccbaa*bb*aaabb*bcaa*?abba?aba????ac*a*c??*a*c*bbb??**acb***?bcc?ba?caabc**b*?a*b*c??cba?bb**?*?ba*?cb**?a**aa*accc?abbabb*bab*cca*??aaccabc**b*bcc??c?aabb?*?*b**b?*a*a?baaa?cac?aca????ab?cb?b*ba*c****a*?bba**a?abca**??**a*a?baaba?cccc**a?c*acca*aaaab?b*?bac??*b?cba?cbbbbab???ca*b?ba**bca**ac*?*cabaaba?ac???*c**c?bcc?cc*??bc?a*?a*cabca?cbb*bc*??aaba??c*abab?b***?b?ab**c*bab?bbbac?caa**c???*abc**b*c?cc?b**?*c??*bb*aac**acb**?a*a?b*cbbac*b*bc*bbbcabbc*aabb??a**?ab**b?ac?b*c?*?a??bb?cc*?c?ac?*cbcabbcbaca*aba*b*b*a*aa?b*abcaaa**ac?cbbabacb*??bcaaa*caa?*abcbbc?c?*b?bcbcac**b*cb*?*a**b*bacca?bbab?a*?ac*aac?*?aaba*c*bcab?a*?bb?c?acbcba?*a*b?cbaac??c*ab**cbc*a*abbc*b?*?cbbb?*bccc?bcba*ca???*cb**a*cb?*ab???**?b??aac???*??b?ca*b*c?***?cc?c?c?cbaaca*b*??c?cb*?bc?bca?a*??bcaa*a???cccac**aa??cbc*?c*a*?ab?*cbacb?cbc**a*aab?cbacb?**cbac*ac?a*?**a*c*aa**?bcbacaccccbb?*ac?a?cb?*c*ba*aa?ab?aacbbbbc?*?*a*?ab?*??aacbaaccc**a?c***a?b*c*a?cbac*ccacc*a?c?ccaa*a?*bcb*?a*aaa?aa??acaab??ca?ac??aba?bc?***?abcc?*?b*caabab*cabccc*ac*b*a**cb*a*aabaa*cb**ca?cc?ac??ccbb**cab**cba*caab?a?*ba**ba?baa*ba*ab*?a*baa?cb?abb?bcca*bb**?*bb?a****c*?aaacb*c?*b*c?bb*a?*aa*b*accab?ab***a?c*a?*accb*abccbbc*bb?a?bcac?cb?a?bc?bcc?aaaba*?b*cc?*cab*?cabca?b??*??bc*??*a*c*?*bcccbcbbc?c?b*c*bcaab*baac?b?bca*?cc*baa*ccc?aba?a**a?*b*bbc?cba**b?a?****c*a?*c*bbbcca*ab*aac*b*baac*b*cb?a*ca?**?*c**?acaa?**bba*?bab**??aabaacabbcac?**??**accaa*cc?c?bc?b?aa*c??ccc*?b?aac?*ab??**ac**ccc*abb*?b??***?cc*a?*ba?c?*?b?ccbbcb*cb*??ac***a*";
            n = A.length();
            m = B.length();
            map = new HashMap<String, Integer>();
            System.out.println(t1.recursion_dp(n - 1, m - 1, A, B, map)); // 0
        }

        {
            // Approach 3 - tabulation + DP
            System.out.println("Approach 3 - tabulation + DP");

            // test case 1
            A = "aaa";
            B = "a*";
            n = A.length();
            m = B.length();
            Map<String, Integer> map = new HashMap<String, Integer>();
            System.out.println(t1.tabulation_dp(A, B)); // 1

            // test case 2
            A = "acz";
            B = "a?a";
            n = A.length();
            m = B.length();
            map = new HashMap<String, Integer>();
            System.out.println(t1.recursion_dp(n - 1, m - 1, A, B, map)); // 0

            A = "cbabbbaaabaaaaacacbccacbaabcbbaabaccaaccabbcabccabcbbbcbbcacacccacbbacabbbaabaabbbccacbccacbcbbcbbabcaccccaabcaccacaabcacacbbaccccbaccabbccaacaabcacaaccbcaabababbbacbbcccaabbbbbbcbcaaaaabbbbcaabbaccbcaccbcaccbaabbabbcabcbbcacaccbbacbcbbbbbbbaccabaccaccaababccabcbaaaccbbcacacccbcaacbbbcaabbbacabcbabaababcacabacaabbbaaabcaabbccbbcabaacbcbcbbcccabacccbaacabcababcbcabbbcbcbcbbbcbacbbbccccabbcbbcbbcccbabbbbcccacccacbbbacbacbbacabbcabcaaabccacbbccccaacbaacbbccccbcbbabacbbccaacabababbabccaaaabcccaabbccbcbabbbccacbccacaaccaaaccbbbcabbaccaaaaacaabaccbaccccbcacaacbacabcaacaccabcaaccaabbbcbcbcbccacaaacbccaabbbcccabbababbbcabcbccacccccbcbcacccbbcbabcbcaacbaaabbaacbaccaabaccbaabcabbcbcbcccccbabccaaabbcccbababaabcabbbccabcacccbabaccacaacccaacbccacaccbcbabcbcaacbcaabcaabcccbccbcbccbcccacccbbbbcacbbcccacbabaabacaccbbbccbcbaaaaaaabcbbbcbcababaccacbcaccaabbbaabcaaabcccbccbcbccaaabcabcaccaccbbbbcaaabbccbbaccccaaabbbcbacbcabbbcbccaaababcabaabcccbaaaabcbbcaccbacccbbbabaaaaacabacccbbbacbcbccabbbbbbbccbbbbcacbaaacbbcaaaacaaccacaacbccabbcbabbccaabcbccbbaccacbccabacbbcbccbcbabbacbbcccbaaccbccacccbbaacaaaaaaaccacababbabbbcccaabbcccccbabbcbcacaacbacbccbbabccbaabacbcacbaccccacbabbacaabbaacbaabcaccccabaaacabbcbbbbbaabcaabaabbbcababcaaacabaabcaabaacabacccbcbaccbcabbcbcabccbabbbacbabacaaacababacbbaccacabacbabcaabacbbbaacbaaccbacaccabaacbcabbbaccbaacccacbaacacaacaabcaabbbbcbababaacaacbacbcbaaccbaabcbccbacccbcabccbbccabcaacbbbcababbbaaabaabbacbaababcacbcab";
            B = "c*c*?a*ac?*cb?b?abaccc?abb?cb?bc??b**c?b*?bbac**a*c*a?b?cb??***a?*b?b?a?*c??**?a??b*?*cb?aa*caca*a*aba*accbaaaa*?b*abc*a*cccbb?b*aababac?*cc**b?ac**?**b*abb?cba?a?a??cb**a?a?b*a*?a??caca????ac?b*?*cc??bcb*acb?*cacb*a?cab*cabc???*a?bcaaaaaaba*?b**a?*?baccbbaa*abba??ba?b?bb??ab**b*?ab?cacccb*b?cacbaba??cabac?bba*babaccab?a?baaab?*a?b**accc*cacbbac*?*?bcbb?c?ca?ccabb*c*bcc*??b?c??c*b*ac??*c?acaa*?a?caabaabccacbc??ca??bba*ba*aa*cbcbbc*bbb?aabacac*cbb*acabbab?c*bcaccaa*c?a?a?ac*ac?*a*ac**??*?a*?ac*aba**??aa?b**abab?a*c?b?abac?**?*ac**aacc*babac*c?*??accb*cb?ab*abba?aaaa**acccc*cc?a?bbc?*bccca????*ab*accbba?b**caa?*abbc*??aa?ba?aaab???cbbaabc?*a*b?ba?aacb*cc?c???bbaaaaa?bc*aabc??c*?acabab?cab*cba*b?**b*baa*b*b*b?ac**?*?aca?**cc*??a***?a?*?ca?b?b??bb?*b??abbc????caac****?a?bacba*b*ac*?bbcb?ccc??*?aab?b*c?a?caab*?*?b?ac*cb*c**?ccc?abb*cabc??a*?a?b????c?aaca*bacc?*cacb**c**?b*?ccb?bb*bab*c?a*bbaccb?b??*a*c??cc?cbbcccbca*a*c**?b*c?*c?abcb*c?a*ab**?a*bbbc?a?b?b*bacc?b*cab?aa?a???*a*c?a??*a?*c?a?cc*ac?ccbb*?b?b??a?**ca*acbbaca*??bbaba*c?b*aa??bc?bc?aa?a*bab*ca?bcb?c*****ab?*b*ca*?aa?*cca?*caabcc*abb*c?*??b?ac*?a*cab??*aa?bb?*acc*aca*b*ac?acb*?bbaabbb?b*bbb?c??aacb?cb?c**?b??c*bc?*ccb*?ccbc*c*b*?bb?**cb?**abb?c?babac*cc*bbb?a*abbbbc*b*??ccba**b?aac*ac*cab*a?ab?*acb?aab*aabbaab?bcb??b?*aa*c*ac?*cb*b?a*bcabb*aa*a*bc?aa**??**aa?aaac*a**ca*cc?accacc***?a*cb*b*?*?c*?*a?cacac**??cb*?**c?ac?a?ababc??abc?*a*?*ac*?*ab?bc*?b?ac??b*c**acb*b?a?a*b*??a??accc??cca???*c**c?**?bbb*c?abbaac*bcb*ac*b**cc?a?cb?*cc****ca?**ba*a?ccba*cb*caca**?ab??ccc*ab?acb??caaa*bc*ab*bb*c?*a*c*a**?*cc**ba?babacacbb*a*ba?a?c*bacba?ba?cbcc*cbb*bb*a*??accac?bca?b?c*ab??**ac?*?a*?b*?ccbaa*bb*aaabb*bcaa*?abba?aba????ac*a*c??*a*c*bbb??**acb***?bcc?ba?caabc**b*?a*b*c??cba?bb**?*?ba*?cb**?a**aa*accc?abbabb*bab*cca*??aaccabc**b*bcc??c?aabb?*?*b**b?*a*a?baaa?cac?aca????ab?cb?b*ba*c****a*?bba**a?abca**??**a*a?baaba?cccc**a?c*acca*aaaab?b*?bac??*b?cba?cbbbbab???ca*b?ba**bca**ac*?*cabaaba?ac???*c**c?bcc?cc*??bc?a*?a*cabca?cbb*bc*??aaba??c*abab?b***?b?ab**c*bab?bbbac?caa**c???*abc**b*c?cc?b**?*c??*bb*aac**acb**?a*a?b*cbbac*b*bc*bbbcabbc*aabb??a**?ab**b?ac?b*c?*?a??bb?cc*?c?ac?*cbcabbcbaca*aba*b*b*a*aa?b*abcaaa**ac?cbbabacb*??bcaaa*caa?*abcbbc?c?*b?bcbcac**b*cb*?*a**b*bacca?bbab?a*?ac*aac?*?aaba*c*bcab?a*?bb?c?acbcba?*a*b?cbaac??c*ab**cbc*a*abbc*b?*?cbbb?*bccc?bcba*ca???*cb**a*cb?*ab???**?b??aac???*??b?ca*b*c?***?cc?c?c?cbaaca*b*??c?cb*?bc?bca?a*??bcaa*a???cccac**aa??cbc*?c*a*?ab?*cbacb?cbc**a*aab?cbacb?**cbac*ac?a*?**a*c*aa**?bcbacaccccbb?*ac?a?cb?*c*ba*aa?ab?aacbbbbc?*?*a*?ab?*??aacbaaccc**a?c***a?b*c*a?cbac*ccacc*a?c?ccaa*a?*bcb*?a*aaa?aa??acaab??ca?ac??aba?bc?***?abcc?*?b*caabab*cabccc*ac*b*a**cb*a*aabaa*cb**ca?cc?ac??ccbb**cab**cba*caab?a?*ba**ba?baa*ba*ab*?a*baa?cb?abb?bcca*bb**?*bb?a****c*?aaacb*c?*b*c?bb*a?*aa*b*accab?ab***a?c*a?*accb*abccbbc*bb?a?bcac?cb?a?bc?bcc?aaaba*?b*cc?*cab*?cabca?b??*??bc*??*a*c*?*bcccbcbbc?c?b*c*bcaab*baac?b?bca*?cc*baa*ccc?aba?a**a?*b*bbc?cba**b?a?****c*a?*c*bbbcca*ab*aac*b*baac*b*cb?a*ca?**?*c**?acaa?**bba*?bab**??aabaacabbcac?**??**accaa*cc?c?bc?b?aa*c??ccc*?b?aac?*ab??**ac**ccc*abb*?b??***?cc*a?*ba?c?*?b?ccbbcb*cb*??ac***a*";
            n = A.length();
            m = B.length();
            map = new HashMap<String, Integer>();
            System.out.println(t1.recursion_dp(n - 1, m - 1, A, B, map)); // 0
        }
    }

}
