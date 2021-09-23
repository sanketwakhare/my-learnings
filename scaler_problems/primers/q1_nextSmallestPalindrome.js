/**
 * Next Smallest Palindrome!
Problem Description

Given a numeric string A representing a large number you need to find the next smallest palindrome greater than this number.

Problem Constraints
1 <= |A| <= 100

A doesn't start with zeroes and always contain digits from 0-9.

Input Format
First and only argument is an string A.

Output Format
Return a numeric string denoting the next smallest palindrome greater than A.

Example Input
Input 1:

 A = "23545"
Input 2:

 A = "999"

Example Output
Output 1:

 "23632"
Output 2:

 "1001"
 */

//TODO: problem is unsolved

const nextSmallestPalindrome = (A) => {
  let nextPalindrome = "";
  // find mid
  let mid = Math.floor(A.length / 2);

  let traverseIndex = 1;

  while (mid >= traverseIndex) {
    let left = Number(A[mid - traverseIndex]);
    let right = Number(A[mid + traverseIndex]);

    if (left > right) {
      let leftString = A.substring(0, mid);
      let rightString = leftString.split("").reverse().join("");
      nextPalindrome = leftString + A[mid] + rightString;
    } else if (left < right) {
      let leftString = A.substring(0, mid + 1);
      let lastElement = Number(leftString.charAt(leftString.length - 1));

      while (lastElement === 9) {}
      lastElement++;
      leftString = leftString.substring(0, mid);
      leftString += lastElement;
      leftString = leftString.substring(0, mid);
      let rightString = leftString.split("").reverse().join("");
      nextPalindrome = leftString + lastElement + rightString;
    } else {
      traverseIndex++;
      if (mid < traverseIndex) {
        let leftString = A.substring(0, mid);
        let lastElement = Number(leftString.charAt(leftString.length - 1));
        while (lastElement === 9) {}
        lastElement++;
        leftString = leftString.substring(0, mid);
        leftString += lastElement;
        leftString = leftString.substring(0, mid);
        let rightString = leftString.split("").reverse().join("");
        nextPalindrome = leftString + lastElement + rightString;
      }
    }
  }

  console.log(nextPalindrome);
};

// nextSmallestPalindrome("23512");
// nextSmallestPalindrome("23545");
nextSmallestPalindrome("999");
