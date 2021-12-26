/***
 * Unique Elements
 * 
 * Problem Description
You are given an array A of N elements. You have to make all elements unique, to do so in one step you can increase any number by one.
Find the minimum number of steps.

Problem Constraints
1 <= N <= 10^5
1 <= A[i] <= 10^9

Input Format
The only argument given is an Array A, having N integers.

Output Format
Return the Minimum number of steps required to make all elements unique.

Example Input
Input 1:
 A = [1, 1, 3]
Input 2:
 A = [2, 4, 5]

Example Output
Output 1:
 1
Output 2:
 0

Example Explanation
Explanation 1:
 We can increase the value of 1st element by 1 in 1 step and will get all unique elements. i.e [2, 1, 3].
Explanation 2:
 All elements are distinct.
 */

/**
 * Form Unique Elements
 * Iterations: N LogN + N for iterating over array elements
 * TC: O(N logN) => for sorting 
 * SC: O(1)
 * @param {Array} A array of integers
 * @returns no of steps required to form the unique elements array.
 */
const uniqueElements = (A) => {

    // Idea: sort the array and increment element by 1 if it is same than previous element

    A.sort((a, b) => a - b);
    console.log('sorted array-> ', A);

    let count = 0;
    for (let i = 1; i < A.length; i++) {
        if (A[i] === A[i - 1]) {
            // if current and prev elements are same, increment the count by 1
            count++;
            // and update the A[i] by A[i] + 1
            A[i] = A[i] + 1;
        } else if (A[i] < A[i - 1]) {
            // if current element is less than prev element, increment count by (prev-current+1)
            count = count + A[i - 1] - A[i] + 1;
            // update the A[i] with => A[i] + (A[i-1] - A[i] + 1) => A[i-1] + 1
            A[i] = A[i - 1] + 1;
        }
    }

    // final updated array with unique elements
    console.log('array with unique elements-> ', A);
    console.log('no of steps required-> ', count);
    // return final count
    return count;
}

uniqueElements([
    51, 6, 10, 8, 22, 61, 56, 48, 88, 85, 21, 98, 81, 76, 71, 68, 18, 6, 14, 23, 72, 18, 56, 30, 97, 100, 81, 5, 99, 2, 85, 67, 46, 32, 66, 51, 76, 53, 36, 31, 81, 56, 26, 75, 69, 54, 54, 54, 83, 41, 86, 48, 7, 32, 85, 23, 47, 23, 18, 45, 79, 95, 73, 15, 55, 16, 66, 73, 13, 85, 14, 80, 39, 92, 66, 20, 22, 25, 34, 14, 51, 14, 17, 10, 100, 35, 9, 83, 31, 60, 24, 37, 69, 62
]);
uniqueElements([1, 1, 3]);
uniqueElements([2, 4, 5]);
uniqueElements([1, 6, 3, 2, 3, 2, 4, 1]);
uniqueElements([5, 8, 7, 3, 2, 2, 4, 7, 5, 6, 8]);