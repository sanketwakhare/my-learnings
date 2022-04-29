/* Make String Pallindrome */

/* Problem Description
Given a string A of size N consisting only of lowercase alphabets. The only operation allowed is to insert characters in the beginning of the string.

Find and return how many minimum characters are needed to be inserted to make the string a palindrome string.


Problem Constraints
1 <= N <= 10^6


Input Format
The only argument given is a string A.


Output Format
Return an integer denoting the minimum characters needed to be inserted in the beginning to make the string a palindrome string.


Example Input
Input 1:

 A = "abc"
Input 2:

 A = "bb"


Example Output
Output 1:

 2
Output 2:

 0


Example Explanation
Explanation 1:

 Insert 'b' at beginning, string becomes: "babc".
 Insert 'c' at beginning, string becomes: "cbabc".
Explanation 2:

 There is no need to insert any character at the beginning as the string is already a palindrome.  */

public class hw_q3_Make_String_Pallindrome {

    public int solve(String A) {

        int i = 0;
        int j = A.length() - 1;
        int count = 0;

        while (i < j) {
            char iChar = A.charAt(i);
            char jChar = A.charAt(j);
            if (iChar != jChar) {
                if (i > 0) {
                    // increase count by no of elements from 0 to i
                    count = count + i;
                    // reset i pointer
                    i = 0;
                } else {
                    // increase count by 1
                    count = count + 1;
                    // decrease j pointer
                    j--;
                }
            } else {
                // if characters are matching, move both pointers
                i++;
                j--;
            }
        }
        // return final count
        return count;
    }

    public static void main(String[] args) {

        hw_q3_Make_String_Pallindrome t1 = new hw_q3_Make_String_Pallindrome();
        {
            System.out.println(t1.solve("abc")); // 2
            System.out.println(t1.solve("aa")); // 0
            System.out.println(t1.solve("abcefba")); // 6
            System.out.println(t1.solve("rgdgrae")); // 2
            System.out.println(t1.solve("qwrgdgr")); // 6
        }
    }

}
