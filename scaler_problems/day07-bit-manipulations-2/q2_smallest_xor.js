/**
 * Smallest XOR
Problem Description

Given two integers A and B, find a number X such that A xor X is minimum possible, and the number of set bits in X equals B.



Problem Constraints
0 <= A <= 109
0 <= B <= 30



Input Format
First argument contains a single integer A. Second argument contains a single integer B.



Output Format
Return a single integer X.



Example Input
Input 1:

 A = 3
 B = 3
Input 2:

 A = 15
 B = 2


Example Output
Output 1:

 7
Output 2:

 12


Example Explanation
Explanation 1:

 3 xor 7 = 4 which is minimum
Explanation 2:

 15 xor 12 = 3 which is minimum
 */
const findSmallestXOR = (A, B) => {
  let xor;
  // convert no to binary string representation
  let N = A.toString(2).padStart(32, "0");
  let charArray = N.split("");
  const noOfSetBits = countSetBits(A);

  let outString = "";
  if (noOfSetBits > B) {
    // start from right
    for (let i = 0; i < charArray.length; i++) {
      if (B > 0 && charArray[i] === "1") {
        charArray[i] = "0";
        B--;
      }
      outString = outString + charArray[i];
    }
  } else {
    // start from left
    noOfZerosToReplaceFromRight = B - noOfSetBits;
    for (let i = charArray.length - 1; i >= 0; i--) {
      if (B > 0 && charArray[i] === "1") {
        charArray[i] = "0";
      } else if (noOfZerosToReplaceFromRight > 0 && charArray[i] === "0") {
        charArray[i] = "1";
        noOfZerosToReplaceFromRight--;
      }
    }
    outString = charArray.join("");
  }

  // convert the string representation to decimal
  let decimal = parseInt(outString, 2);

  xor = decimal ^ A;
  return xor;
};

const countSetBits = (N) => {
  // count no of set bits
  let count = 0;
  while (N > 0) {
    if ((N & 1) !== 0) {
      count++;
    }
    N = N >> 1;
  }
  return count;
};

console.log(findSmallestXOR(9, 3));
console.log(findSmallestXOR(15, 2));
console.log(findSmallestXOR(4, 6));
