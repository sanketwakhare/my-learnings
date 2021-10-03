/**
 * Count ways to make sum of odd and even indexed elements equal by removing an array element
Problem Description
Given an array, arr[] of size N, the task is to find the count of array indices such that removing an element from these indices makes the sum of even-indexed and odd-indexed array elements equal.

Problem Constraints
1<=n<=1e5
-1e5<=A[i]<=1e5

Input Format
First argument contains an array A of integers of size N

Output Format
Return the count of array indices such that removing an element from these indices makes the sum of even-indexed and odd-indexed array elements equal.

Example Input
Input 1:
A=[2, 1, 6, 4]
Input 2:
A=[1, 1, 1]

Example Output
Output 1:
1
Output 2:
3

Example Explanation
Explanation 1:
Removing arr[1] from the array modifies arr[] to { 2, 6, 4 } such that, arr[0] + arr[2] = arr[1].
Therefore, the required output is 1.
Explanation 2:

 Removing arr[0] from the given array modifies arr[] to { 1, 1 } such that arr[0] = arr[1]
Removing arr[1] from the given array modifies arr[] to { 1, 1 } such that arr[0] = arr[1]
Removing arr[2] from the given array modifies arr[] to { 1, 1 } such that arr[0] = arr[1]
Therefore, the required output is 3.
 */

/**
 * Count ways to make sum of odd and even indexed elements equal by removing an array element
 * @param {Array} A input
 * @returns count of even and odd are equal after removing ith element
 */
const sumOfEvenOdd = (A) => {
    const N = A.length;
    // create left prefix array with odd and even indexes
    let left = [];
    // create right prefix array with odd and even indexes
    let right = [];
    let z = 3;
    while (z > 0) {
        // add first 3 elements as 0
        left.push(0);
        // add last 3 elements as 0
        right.unshift(0);
        z--;
    }

    let leftEvenSum = 0;
    let leftOddSum = 0;
    let rightEvenSum = 0;
    let rightOddSum = 0;
    for (let i = 0; i < N; i++) {
        if (i % 2 === 0) {
            leftEvenSum += A[i];
            left.push(leftEvenSum);
        } else if (i % 2 === 1) {
            leftOddSum += A[i];
            left.push(leftOddSum);
        }
        let j = (N - 1) - i;
        if (j % 2 === 0) {
            rightEvenSum += A[i];
            right.unshift(rightEvenSum);
        } else if (j % 2 === 1) {
            rightOddSum += A[i];
            right.unshift(rightOddSum);
        }
    }

    // for (let i = N - 1; i >= 0; i--) {
    // }
    console.log('left', left);
    console.log('right', right);

    // add left and right arrays
    let sumArray = [];
    for (let i = 0; i < left.length; i++) {
        sumArray.push(left[i] + right[i]);
    }

    // console.log('sumArray',sumArray);
    let count = 0;
    for (let i = 2; i <= sumArray.length - 2; i++) {
        let prev = sumArray[i - 1];
        let next = sumArray[i];
        if (prev === next) {
            count++;
        }
    }
    console.log(count);
    return count;
}

sumOfEvenOdd([1, 1, 1, 1, 1, 1, 1, 1]);
sumOfEvenOdd([1, 1, 1, 1, 1, 1, 1]);

const sameApproachCode2 = (A) => {
    const N = A.length;
    // create left prefix array with odd and even indexes
    let left = [];
    // add first 3 elemnts as 0
    let z = 3;
    while (z > 0) {
        left.push(0);
        z--;
    }
    let evenSum = 0;
    let oddSum = 0;
    for (let i = 0; i < N; i++) {
        if (i % 2 === 0) {
            evenSum += A[i];
            left.push(evenSum);
        } else {
            oddSum += A[i];
            left.push(oddSum);
        }
    }

    // create right prefix array with odd and even indexes
    let right = [];
    // add last 3 elemnts as 0
    z = 3;
    while (z > 0) {
        right.unshift(0);
        z--;
    }
    evenSum = 0;
    oddSum = 0;
    for (let i = N - 1; i >= 0; i--) {
        if (i % 2 === 0) {
            evenSum += A[i];
            right.unshift(evenSum);
        } else {
            oddSum += A[i];
            right.unshift(oddSum);
        }
    }
    // console.log('left',left);
    // console.log('right',right);

    // add left and right arrays
    let sumArray = [];
    for (let i = 0; i < left.length; i++) {
        sumArray.push(left[i] + right[i]);
    }

    // console.log('sumArray',sumArray);

    let count = 0;
    for (let i = 2; i <= sumArray.length - 2; i++) {
        let prev = sumArray[i - 1];
        let next = sumArray[i];

        if (prev === next) {
            count++;
        }
    }

    return count;
}