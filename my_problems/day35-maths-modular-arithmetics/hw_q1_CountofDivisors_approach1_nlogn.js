/**
 * Count of divisors
 */

/* 
Problem Description
Given an array of integers A, find and return the count of divisors of each element of the array.
NOTE: Order of the resultant array should be same as the input array.

Problem Constraints
1 <= length of the array <= 100000
1 <= A[i] <= 10^6

Input Format
The only argument given is the integer array A.

Output Format
Return the count of divisors of each element of the array in the form of an array.

Example Input
Input 1:
 A = [2, 3, 4, 5]
Input 2:
 A = [8, 9, 10]

Example Output
Output 1:
 [2, 2, 3, 2]
Output 1:
 [4, 3, 4]

Example Explanation
Explanation 1:
 The number of divisors of 2 : [1, 2], 3 : [1, 3], 4 : [1, 2, 4], 5 : [1, 5]
 So the count will be [2, 2, 3, 2].
Explanation 2:
 The number of divisors of 8 : [1, 2, 4, 8], 9 : [1, 3, 9], 10 : [1, 2, 5, 10]
 So the count will be [4, 3, 4]. */

/**
 * Count of Divisors
 * TC: O(N logN) where N = max of A[i]
 * SC: O(max(A[i]))
 * @param {Array} A array of integers
 * @returns 
 */
const countOfDivisors = (A) => {

    const N = A.length;

    // find max so that count array would be generated till max element only
    let max = A[0];
    for (let i = 0; i < N; i++) {
        max = Math.max(A[i], max);
    }

    // initialize the output array with every eleme3nt count as 2 except 1
    let count = new Array(1000001);
    count[1] = 1;

    for (let i = 2; i <= 1000000; i++) {
        count[i] = 2;
    }

    // for each element in range, generate count array with count of divisors
    for (let i = 2; i <= 1000000; i++) {
        for (let j = i * 2; j <= 1000000; j = j + i) {
            count[j]++;
        }
    }

    // for given input array, return the count of divisors
    for (let i = 0; i < N; i++) {
        A[i] = count[A[i]];
    }
    console.log('output -> ', A);
    return A;
}

countOfDivisors([2, 3, 4, 5]);
countOfDivisors([8, 9, 10]);
countOfDivisors([1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20]);