/**
 * Add Binary Strings
Problem Description

Given two binary strings, return their sum (also a binary string).
Example:

a = "100"

b = "11"
Return a + b = "111".
 */

const addBinary = function (A, B) {
  // add 0s to start of the string so that both the lengths are same
  if (A.length > B.length) {
    B = B.padStart(A.length, "0");
  } else if (A.length < B.length) {
    A = A.padStart(B.length, "0");
  }
  // calculate sum
  let carry = 0;
  let sum = 0;
  let reversedSum = [];
  for (let i = A.length - 1; i >= 0; i--) {
    sum = Number(A[i]) + Number(B[i]) + carry;
    quotient = Math.floor(sum % 2);
    carry = Math.floor(sum / 2);
    reversedSum.push(quotient);
  }
  // handle additional carry
  let binaryCarry = "";
  if (carry > 0) {
    binaryCarry = carry.toString(2);
  }
  // append the sum from reversed array
  while (reversedSum.length > 0) {
    binaryCarry += String(reversedSum.pop());
  }
  console.log(binaryCarry);
};

addBinary("100", "11");
addBinary("1100", "1010");
addBinary("1", "1010");
addBinary("11", "1111");
