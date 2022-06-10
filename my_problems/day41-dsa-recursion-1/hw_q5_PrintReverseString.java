/****
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

public class hw_q5_PrintReverseString {

    private static String reverseRecursive(String inp) {

        if(inp.length() == 1) {
            return inp.substring(0,1);
        }

        // System.out.print(inp.substring(0,1));
        return reverseRecursive(inp.substring(1)) + inp.substring(0,1);
    }

    public static void main(String[] args) {
        // YOUR CODE GOES HERE
        // Please take input and print output to standard input/output (stdin/stdout)
        // DO NOT USE ARGUMENTS FOR INPUTS
        // E.g. 'Scanner' for input & 'System.out' for output

        Scanner scanner = new Scanner(System.in);
        String inp = scanner.nextLine();

        String output = reverseRecursive(inp);

        System.out.print(output);
    }
}