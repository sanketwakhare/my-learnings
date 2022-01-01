/**
 * Enumerating GCD
 * 
 * Problem Description

You are given a number A and a number B. Greatest Common Divisor (GCD) of all numbers between A and B inclusive is taken (GCD(A, A+1, A+2 … B)).
As this problem looks a bit easy, it is given that numbers A and B can be in the range of 10100.

You have to return the value of GCD found.

Greatest common divisor of 2 numbers A and B is the largest number D that divides both A and B perfectly.

Problem Constraints
1 <= A <= B <= 10100

Input Format
First argument is a string denoting A.
Second argument is a string denoting B.

Output Format
Return a string which contains the digits of the integer which represents the GCD. The returned string should not have any leading zeroes.

Example Input
A = "1"
B = "3"

Example Output
1

Example Explanation
Greatest divisor that divides both 1 and 3 is 1.
 */

const enumerateGCD = (A, B) => {

    // Observation 1 -> gcd of two consecutive numbers is always 1
    // gcd(a,a+1) = gcd(a,a+1-a) = gcd(a,1) = 1

    // Observation 2 -> gcd of two same number is that number itself
    // gcd(a,a) = a
    let ans;
    if (A === B) {
        ans = A;
    } else {
        ans = "1";
    }
    console.log('answer -> ', ans);
    return ans;
}

enumerateGCD("1", "3");
enumerateGCD('122121212', '111111111111111');
enumerateGCD('4444444444444444444444', '4444444444444444444444');
enumerateGCD('4444444444444444444444', '4444444444444444444442');