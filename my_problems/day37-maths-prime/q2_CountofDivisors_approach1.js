/**
 * Count of divisors
 * 
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
 So the count will be [4, 3, 4].
 */

/**
 * Generate smallestPrimeFactor array and return
 * @param {Number} N integer
 * @returns array of integers
 */
const smallestPrimeFactor = (N) => {

    let spf = new Array(N + 1);
    for (let i = 1; i <= N; i++) {
        spf[i] = i;
    }

    for (let i = 2; i * i <= N; i++) {
        if (spf[i] === i) {
            // i is prime number/prime factor
            for (let j = i * i; j <= N; j = j + i) {
                // update factors if it is not already present
                if (spf[j] === j) {
                    spf[j] = i;
                }
            }
        }
    }
    return spf;
}

/**
 * Count the no of Divisors for a given number N
 * @param {Number} N 
 * @param {Array} spf smallest prime factors array form 1 to N
 * @returns 
 */
const countNoOfDivisors = (N, spf) => {
    let ans = 1;
    while (N > 1) {
        let x = spf[N];
        let count = 0;
        while (N % x === 0) {
            N = N / x;
            count++;
        }
        ans = ans * (count + 1);
    }
    return ans;
}

/**
 * Count the no of divisors for all the numbers in array
 * @param {Array} A array of integers
 * @returns array of integers
 */
const countOfDivisorsMain_approach1 = (A) => {

    const N = A.length;

    // find max so that count array would be generated till max element only
    let max = A[0];
    for (let i = 0; i < N; i++) {
        max = Math.max(A[i], max);
    }

    // initialize the count array with every element's count as 2 except 1
    // as every element is divisible by 1 and itself
    let count = new Array(max);
    count[1] = 1;
    for (let i = 2; i <= max; i++) {
        count[i] = 2;
    }

    // for each element in range, update count array when there is multiple of i
    for (let i = 2; i <= max; i++) {
        for (let j = i * 2; j <= max; j = j + i) {
            count[j]++;
        }
    }

    // for given input array, return the count of divisors
    for (let i = 0; i < N; i++) {
        A[i] = count[A[i]];
    }
    console.log(A);
    return A;
}

countOfDivisorsMain_approach1([2, 3, 4, 5]);
countOfDivisorsMain_approach1([8, 9, 10]);