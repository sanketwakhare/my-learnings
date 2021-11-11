/****
 * Problem Description
You are given an integer array A of length N.
You have to find the sum of all subarray sums of A.
More formally, a subarray is a defined as a contiguous part of an array,
which we can obtain by deleting zero or more elements from either end of the array.
A subarray sum denotes the sum of all the elements of that subarray.

Problem Constraints
1 <= N <= 10^5
1 <= A[i] <= 10^4

Input Format
The first argument is the integer array A.

Output Format
Return a single integer denoting the sum of all subarray sums of the given array.

Example Input
Input 1:
A = [1, 2, 3]
Input 2:
A = [2, 1, 3]

Example Output
Output 1:
20
Output 2:
19

Example Explanation:
Explanation 1:
The different subarray for the given array are: [1], [2], [3], [1, 2], [2, 3], [1, 2, 3].
Their sums are: 1 + 2 + 3 + 3 + 5 + 6 = 20

Explanation 2:
Similar to the first example, the sum of all subarray sums for this array is 19.
 */

//param A : array of integers
//return a long integers
const subarraySum = (A) => {

    // calculate contribution of set bits in an subset
    // this formula/observation is derived manually using bit manipulation method

    /* Wrong solution:
    const N = A.length;
    if (N === 1) {
        return BigInt(A[0]);
    }
    let sum = BigInt(0);
    if (N > 1) {
        // add contribution of first and last element of an array
        sum = sum + BigInt(A[0]) * BigInt(N);
        sum = sum + BigInt(A[A.length - 1]) * BigInt(N);

        // not iterate over array and add contribution of each element except first and last elements
        const contributionOfMiddleElements = BigInt((2 * N) - 2);
        for (let i = 1; i < N - 1; i++) {
            sum = sum + A[i] * contributionOfMiddleElements;
        }
    }
    return sum; */



    // Accepted solution
    /* Contribution of each element of the array is (i + 1) * (N - i)*/
    const N = BigInt(A.length);
    let sum = BigInt(0);
    for (let i = BigInt(0); i < N; i++) {
        sum += (i + 1n) * (N - i) * (A[i]);
    }
    return sum;
}


subarraySum([3, 10, 1, 10, 6, 2, 4, 5, 1, 4]);