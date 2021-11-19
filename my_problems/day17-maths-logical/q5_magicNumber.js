/***
 * Find nth Magic Number
Problem Description
Given an integer A, find and return the Ath magic number.
A magic number is defined as a number which can be expressed as a power of 5 or sum of unique powers of 5.
First few magic numbers are 5, 25, 30(5 + 25), 125, 130(125 + 5), ….

Problem Constraints
1 <= A <= 5000

Input Format
The only argument given is integer A.

Output Format
Return the Ath magic number.

Example Input
Example Input 1:
 A = 3
Example Input 2:
 A = 10

Example Output
Example Output 1:
 30
Example Output 2:
 650

Example Explanation
Explanation 1:
 A in increasing order is [5, 25, 30, 125, 130, ...]
 3rd element in this is 30
Explanation 2:
 In the sequence shown in explanation 1, 10th element will be 650.
 */

/**
 * Find Magic number
 * @param {Input integer number} A 
 */

const magicNumber = (A) => {

    // Accepted Solution 1:
    console.time("firstSolution");
    const binaryRepresentation = A.toString(2);
    console.log(binaryRepresentation);
    const N = binaryRepresentation.length;

    let pow = 5;
    let ans = 0;
    for (let i = N - 1; i >= 0; i--) {
        if (binaryRepresentation[i] === '1') {
            ans = ans + pow;
        }
        pow = pow * 5;
    }
    console.log(ans);
    console.timeEnd("firstSolution");

    // Accepted Solution 2:
    console.time("secondSolution");
    pow = 1;
    ans = 0;
    while (A > 0) {
        pow = pow * 5;
        if (A & 1 === 1) {
            ans = ans + pow;
        }
        A = Math.floor(A / 2);
    }
    console.log(ans);
    console.timeEnd("secondSolution");
}

magicNumber(3);
magicNumber(10);
magicNumber(15);
magicNumber(5000);