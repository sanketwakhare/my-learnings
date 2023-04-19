public class q7_LongestPalindromicSubString {

    public String longestPalindrome(String A) {
        String answer = A.substring(0, 1);
        for(int i=0; i<A.length(); i++) {
            String curr = expand(A, i, i);
            if(curr.length() > answer.length()) {
                answer = curr;
            }
        }
        for(int i=0; i<A.length() - 1; i++) {
            String curr = expand(A, i, i + 1);
            if(curr.length() > answer.length()) {
                answer = curr;
            }
        }
        return answer;
    }

    public String expand(String s, int start, int end) {
        while(start >=0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            start--;
            end++;
        }
        return s.substring(start + 1, end);
    }

    public static void main(String[] args) {
        q7_LongestPalindromicSubString t1 = new q7_LongestPalindromicSubString();
        String answer = t1.longestPalindrome("bccbcbcacbab");
        System.out.println(answer);
        answer = t1.longestPalindrome("aaaabaaa");
        System.out.println(answer);
    }
}
