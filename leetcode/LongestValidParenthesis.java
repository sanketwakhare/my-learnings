import java.util.Stack;

/* DP Problem */
public class LongestValidParenthesis {

    public int longestValidParentheses(String s) {
        int maxCount = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.empty()) {
                    stack.push(i);
                } else {
                    maxCount = Math.max(maxCount, i - stack.peek());
                }
            }
        }
        System.out.println(maxCount);
        return maxCount;
    }

    public static void main(String[] args) {
        LongestValidParenthesis t1 = new LongestValidParenthesis();
        String s;
        {
            s = "(()";
            t1.longestValidParentheses(s); // 2
        }
        {
            s = ")()())";
            t1.longestValidParentheses(s); // 4
        }
        {
            s = "";
            t1.longestValidParentheses(s); // 0
        }
        {
            s = "()(()";
            t1.longestValidParentheses(s); // 2
        }
        {
            s = ")()())";
            t1.longestValidParentheses(s); // 4
        }
    }
}
