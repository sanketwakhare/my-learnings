public class ReverseWordsInAString {

    public static void main(String[] args) {
        ReverseWordsInAString obj = new ReverseWordsInAString();
        System.out.println(obj.reverseWords("Let's take LeetCode contest"));
    }

    public String reverseWords(String s) {
        int start = 0;
        int end = 0;
        char[] chArr = s.toCharArray();
        while (start < s.length()) {
            while (end < s.length() && s.charAt(end) != ' ') {
                end++;
            }
            reverse(chArr, start, end - 1);
            start = ++end;
        }
        return new String(chArr);
    }

    public String reverse(char[] chArr, int start, int end) {
        while (start < end) {
            char temp = chArr[start];
            chArr[start] = chArr[end];
            chArr[end] = temp;
            start++;
            end--;
        }
        return String.copyValueOf(chArr);
    }
}
