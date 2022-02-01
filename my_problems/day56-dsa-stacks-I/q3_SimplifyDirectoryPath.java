import java.util.Stack;

/* Simplify Directory Path */

/***
 * Given a string A representing an absolute path for a file (Unix-style).
 * 
 * Return the string A after simplifying the absolute path.
 * Note:
 * Absolute path always begin with '/' ( root directory ).
 * Path will not have whitespace characters.
 * 
 * Input Format
 * The only argument given is string A.
 * Output Format
 * Return a string denoting the simplified absolute path for a file
 * (Unix-style).
 * 
 * For Example
 * Input 1:
 * A = "/home/"
 * Output 1:
 * "/home"
 * 
 * Input 2:
 * A = "/a/./b/../../c/"
 * Output 2:
 * "/c"
 */

public class q3_SimplifyDirectoryPath {

    public static String simplifyPath(String A) {

        // push / at start
        // push all consecutive characters as string
        // pop when .. is found->means back from current directory
        // continue when / is found
        // return final answer as string by combining the elements in stack

        // initialize stack with "/" as first element
        Stack<String> stack = new Stack<String>();
        stack.push("/");

        for (int i = 0; i < A.length(); i++) {
            String tempStr = "";
            // combine consecutive characters will we find "/"
            while (i < A.length() && '/' != A.charAt(i)) {
                tempStr += A.charAt(i);
                i++;
            }
            // if tempStr is .. ->means pop the element from stack
            if ("..".compareTo(tempStr) == 0) {
                if ("/".compareTo(stack.peek()) != 0) {
                    stack.pop();
                }
            }
            // if tempStr is not empty and any other string except ".", push the element
            // into stack
            else if (!tempStr.isEmpty() && ".".compareTo(tempStr) != 0) {
                stack.push(tempStr);
            }
        }

        // extract the elements from stack and form teh required output string
        String outStr = new String();
        while (!stack.isEmpty()) {

            String x = stack.pop();
            if ("/".compareTo(x) != 0) {
                outStr = "/" + x + outStr;
            }
        }

        // if output string is empty, return "/" else return output string
        return outStr.isEmpty() ? "/" : outStr;
    }

    public static void main(String[] args) {

        String A = "/home/";
        System.out.println(simplifyPath(A)); // /home
        A = "/a/./b/../../c/";
        System.out.println(simplifyPath(A)); // /c
        A = "/../";
        System.out.println(simplifyPath(A)); // /
        A = "/home//foo/";
        System.out.println(simplifyPath(A)); // /home/foo

    }

}
