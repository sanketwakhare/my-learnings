// Playground
/*
Number of 1 Bits
Problem Description

Write a function that takes an integer and returns the number of 1 bits it has.

Problem Constraints
1 <= A <= 109

Input Format
First and only argument contains integer A

Output Format
Return an integer as the answer

Example Input
Input1:
11

Example Output
Output1:
3

Example Explanation
Explaination1:
11 is represented as 1011 in binary.
*/
const N = 252;

console.log(N.toString(2));

const binary = N.toString(2);
const charArray = binary.split("");

const noOfOnes = charArray.reduce((acc, curr) => {
  if (curr === "1") {
    acc++;
  }
  return acc;
}, 0);

console.log(noOfOnes);
