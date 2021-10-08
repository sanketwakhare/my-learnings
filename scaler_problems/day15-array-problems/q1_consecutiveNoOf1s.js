/*******
 * Length of longest consecutive ones
Given a binary string A. It is allowed to do at most one swap between any 0 and 1. Find and return the length of the longest consecutive 1’s that can be achieved.

Input Format
The only argument given is string A.

Output Format
Return the length of the longest consecutive 1’s that can be achieved.

Constraints
1 <= length of string <= 1000000
A contains only characters 0 and 1.

For Example
Input 1:
    A = "111000"
Output 1:
    3
Input 2:
    A = "111011101"
Output 2:
    7
 * 
 */


/**
 * 
 * @param {Array} A 
 */
const lengthOfLongestConsecutive1s = (A) => {
    const input = A.split('');
    console.log(input);

    // let leftPrefixSum = Array.apply(null, { length: input.length }).map(function () { return 0; });

    let leftPrefixSum = [];
    let sum = 0;
    let noOf1s = 0;
    for (let i = 0; i < input.length; i++) {
        if (input[i] === '0') {
            sum = 0;
        } else {
            sum++;
            noOf1s++;
        }
        leftPrefixSum.push(sum);
    }
    console.log(leftPrefixSum);

    let rightPrefixSum = [];
    sum = 0;
    for (let i = input.length - 1; i >= 0; i--) {
        if (input[i] === '0') {
            sum = 0;
        } else {
            sum++;
        }
        rightPrefixSum.unshift(sum);
    }
    // rightPrefixSum.reverse();


    console.log(rightPrefixSum);

    let max = 0;
    for (let i = 0; i < leftPrefixSum.length; i++) {
        max = Math.max(max, leftPrefixSum[i]);
    }

    for (let i = 0; i < input.length - 2; i++) {
        //add 1
        max = Math.max(max, leftPrefixSum[i] + rightPrefixSum[i + 2] + 1);
    }

    console.log('max: ', max, 'noOf1s: ', noOf1s, 'result:', Math.min(max, noOf1s));
    return Math.min(max, noOf1s);

}

const solve = function (A) {
    const input = A.split('');
    let leftPrefixSum = [];
    let sum = 0, k = 0;
    for (let i = 0; i < input.length; i++) {
        if (input[i] === '0') {
            sum = 0;
        } else {
            sum++;
            k++;
        }
        leftPrefixSum.push(sum);
    }
    let rightPrefixSum = new Array(A.length);
    sum = 0;
    for (let i = input.length - 1; i >= 0; i--) {
        if (input[i] === '0') {
            sum = 0;
        } else {
            sum++;
        }
        rightPrefixSum[i] = sum;
    }
    let max = 0;
    for (let i = 0; i < input.length; i++) {
        if (leftPrefixSum[i] > max) {
            max = leftPrefixSum[i] + (A[i] === '0');
        }
    }

    for (let i = 0; i < input.length - 2; i++) {

        max = Math.max(max, leftPrefixSum[i] + rightPrefixSum[i + 2] + 1);

    }
    console.log(Math.min(max, k));
    return Math.min(max, k);
}

lengthOfLongestConsecutive1s('111011101');
lengthOfLongestConsecutive1s('111000');
lengthOfLongestConsecutive1s('111011101111');
lengthOfLongestConsecutive1s('111111');
lengthOfLongestConsecutive1s('0000011');
lengthOfLongestConsecutive1s('001010');
lengthOfLongestConsecutive1s('10');
lengthOfLongestConsecutive1s('01');
lengthOfLongestConsecutive1s('11');
lengthOfLongestConsecutive1s('1');
lengthOfLongestConsecutive1s('0');
lengthOfLongestConsecutive1s('110011');

// solve('110011');
// solve('111011101');
// solve('111000');
// solve('111011101111');
// solve('111111');
// solve('0000011');
// solve('001010');
// solve('10');
// solve('01');
// solve('11');
// solve('1');
// solve('0');
// solve('110011');