/**
 * Print reverse string
Problem Description
Write a recursive function that, given a string S, prints the characters of S in reverse order.

Problem Constraints
1 <= |s| <= 1000

Input Format
First line of input contains a string S.

Output Format
Print the character of the string S in reverse order.

Example Input
Input 1:
 scaleracademy
Input 2:
 cool

Example Output
Output 1:
 ymedacarelacs
Output 2:
 looc

Example Explanation
Explanation 1:
 Print the reverse of the string in a single line.
 */

 import java.lang.*;
import java.util.*;

public class q4_PrintReverseStringRecursive {
    public static void main(String[] args) {
        // YOUR CODE GOES HERE
        // Please take input and print output to standard input/output (stdin/stdout)
        // DO NOT USE ARGUMENTS FOR INPUTS
        // E.g. 'Scanner' for input & 'System.out' for output
        
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();

        /**Approach which call the recursive function first and then print the character after reaching base condition */
        reversePrint(s, 0);
        
        /**Alternate Approach: to print first and then call recursive function */
        // int N = s.length();
        // reversePrint(s, N-1);
        
    }
    
    private static void reversePrint(String s, int index) {

        /**Approach which call the recursive function first and then print the character after reaching base condition */
        if(index >= s.length()) {
            return;
        }
        reversePrint(s, index+1);
        System.out.print(s.charAt(index));


        /**Alternate Approach: to print first and then call recursive function */       
        // if(index < 0) {
        //     return;
        // }
        // System.out.print(s.charAt(index));
        // reversePrint(s, index-1);
    }
}