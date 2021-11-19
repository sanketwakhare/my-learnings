package com.abc;

import java.util.Scanner;

/**
 * 
 * Even Odd Elements
Problem Description

You are given T(number of test cases) integer arrays. For each array A, you have to find the value of absolute difference between the counts of even and odd elements in the array.

Problem Constraints
1 <= T <= 10
1 <= |A| <= 10^5
1 <= A[i] <= 10^9

Input Format
First line contains a single integer T.
Each of the next T lines begin with an integer denoting the length of the array A (|A|), followed by |A| integers which indicate the elements in the array.

Output Format
For each test case, print an integer in a separate line.

Example Input
Input 1:

 1 
 4 1 2 3 4 
Input 2:

 1
 4 2 3 5 1 
Input 3:

 1
 1 4 

Example Output
Output 1:
 0 
Output 2:
 2 
Output 3:
 1


Example Explanation
Explanation 1:

 For 1st test case:
 Number of even elements = 2 
 Number of odd elements = 2
 |Number of even elements - Number of odd elements| = |2 - 2| = 0 
Explanation 2:

 For 1st test case:
 Number of even elements = 1 
 Number of odd elements = 3
 |Number of even elements - Number of odd elements| = |1 - 3| = |-2| = 2 
Explanation 3:

 For 1st test case:
 Number of even elements = 1 
 Number of odd elements = 0
 |Number of even elements - Number of odd elements| = |1 - 0| = |1| = 1  


 *
 */
public class Q4_EvenOdd {
	public static void main(String[] args) {
        // YOUR CODE GOES HERE
        // Please take input and print output to standard input/output (stdin/stdout)
        // DO NOT USE ARGUMENTS FOR INPUTS
        // E.g. 'Scanner' for input & 'System.out' for output
		Scanner scanner =  new Scanner(System.in);
		int noOfTestCases = Integer.parseInt(scanner.nextLine());
		while(noOfTestCases > 0) {
			String  test= scanner.nextLine();
			String[] tokens = test.split(" ");
			int oddCount = 0;
			int evenCount = 0;
			for (int i = 1; i < tokens.length; i++) {
				int currentNo = Integer.parseInt(tokens[i]);
				if((currentNo & 1) == 1) {
					// odd
					oddCount++;
				}
				else {
					//even
					evenCount++;
				}
			}
			System.out.println(oddCount > evenCount ? oddCount-evenCount: evenCount-oddCount);
			noOfTestCases--;
		}
		scanner.close();
	}
}
