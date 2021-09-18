/***
 * Single Number III
Problem Description
Given an array of numbers A , in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once.

Note: Output array must be sorted.

Problem Constraints
2 <= |A| <= 100000
1 <= A[i] <= 109

Input Format
First argument is an array of interger of size N.

Output Format
Return an array of two integers that appear only once.

Example Input
Input 1:

A = [1, 2, 3, 1, 2, 4]
Input 2:

A = [1, 2]

Example Output
Output 1:

[3, 4]
Output 2:

[1, 2]

Example Explanation
Explanation 1:

 3 and 4 appear only once.
Explanation 2:

 1 and 2 appear only once.

 */

/**
  * Solution Approach
  * step1: xor of all the elements

    step2: find the set bit from the xor output from step 1

    step3: create two groups based on the set bit/unset bit

    step4: xor of all the elements from each group separately

    step5: group1 and group 2 has the final unique elemnts
  * @param {Array} A input array
  * @returns {Array} output two non repeating elements from array A
  */

const findTwoUniqueElements = (A) => {
  // step 1: find xor of all the elements
  const xorOfAllElements = A.reduce((accumulator, current) => {
    return current ^ accumulator;
  }, 0);

  // step 2: find any set bit from xor value of all the elements
  let setBitPosition = 0;
  for (let i = 0; i < 109; i++) {
    if (((xorOfAllElements >> i) & 1) === 1) {
      // set bit found
      setBitPosition = i;
      break;
    }
  }

  // step 3: create two groups based on set bit position
  let setValue = 0;
  let unsetValue = 0;
  A.forEach((current) => {
    if (((current >> setBitPosition) & 1) === 1) {
      setValue = setValue ^ current;
    } else {
      unsetValue = unsetValue ^ current;
    }
  });
  // step 4: sort output array
  let output = [];
  if (setValue < unsetValue) {
    output = [setValue, unsetValue];
  } else {
    output = [unsetValue, setValue];
  }
  return output;
};

console.log(findTwoUniqueElements([1, 2, 3, 1, 2, 4]));
console.log(findTwoUniqueElements([186, 256, 102, 377, 186, 377]));
