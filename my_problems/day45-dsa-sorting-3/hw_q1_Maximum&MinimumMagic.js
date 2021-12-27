/********
 * Maximum & Minimum Magic
 *
 * Problem Description
Given an array of integers A of size N where N is even.
Divide the array into two subsets such that

1.Length of both subset is equal.
2.Each element of A occurs in exactly one of these subset.
Magic number = sum of absolute difference of corresponding elements of subset.

Note: You can reorder the position of elements within the subset to find the value of magic number.

For Ex:-
subset 1 = {1, 5, 1},
subset 2 = {1, 7, 11}
Magic number = abs(1 - 1) + abs(5 - 7) + abs(1 - 11) = 12
Return an array B of size 2, where B[0] = maximum possible value of Magic number modulo 109 + 7, B[1] = minimum possible value of a Magic number modulo 109 + 7.

Problem Constraints
1 <= N <= 105
-10^9 <= A[i] <= 10^9
N is even

Input Format
The first argument given is the integer array A.

Output Format
Return an array B of size 2, where B[0] = maximum possible value of Magic number % 109 + 7,B[1] = minimum possible value of a Magic number % 109 + 7.

Example Input
Input 1:
 A = [3, 11, -1, 5]
Input 2:
 A = [2, 2]

Example Output
Output 1:
 [14, 10]
Output 2:
 [0, 0]


Example Explanation
Explanation 1:

 All possible magical numbers:-
 sub1 = {3, 11}, sub2 = {-1, 5}, Magic Number = abs(3 - -1) + abs(11 - 5) = 10
 sub1 = {3, -1}, sub2 = {11, 5}, Magic Number = abs(3 - 11) + abs(-1 - 5) = 14
 sub1 = {3, 5}, sub2 = {11, -1}, Magic Number = abs(3 - 11) + abs(5 - -1) = 14
 sub1 = {11, -1}, sub2 = {3, 5}, Magic Number = abs(11 - 3) + abs(-1 - 5) = 14
 sub1 = {11, 5}, sub2 = {3, -1}, Magic Number = abs(11 - 3) + abs(5 - -1) = 14
 sub1 = {-1, 5}, sub2 = {3, 11}, Magic Number = abs(-1 - 3) + abs(5 - 11) = 10
 maximum of all magic number = 14 % 10^9 + 7 = 14
 minimum of all magic number = 10 % 10^9 + 7 = 10
Explanation 2:
 Answer is evident.
 */


// Test case 1:  A = [1, 8, -7, 6, 3, 4], expected output = [21,11]
// Test case 2:  A = [7, 8, 5, 9, -4, -5, 2, 10, 3, 1], expected output = [42,6]
// Test case 3:  A = [ -98, 54, -52, 15, 23, -97, 12, -64, 52, 85 ], expected output = [528,76]

/**
 * !important 
 * Idea: Sort the array
 * Max value would be difference between elements from either ends
 * Min value would be difference between consecutive elements
 * 
 * e.g. Input A =[1, 8, -7, 6, 3, 4]
 * 
 * -> Step 1 -> Sort A = [-7,1,3,4,6,8]
 * 
 * Max Magic no = abs(-7-8) + abs(1-6) + abs(3-4)
 *              = 15 + 5 + 1
 *              = 21
 * Min Magic no = abs(-7-1) + abs(3-4) + abs(6-8)
 *              = 8 + 1 + 2
 *              = 11
 * 
 * Ans = [21,11]
 */

/**
 * Iteration: NLogN + N/2 + N/2 = N logN + N
 * TC: O(N logN)
 * SC: O(1)
 * Find Max and Min magic number
 * @param {Array} A array of integers
 * @returns 
 */
const MaximumAndMinimumMagic = (A) => {

    console.log('input', A);
    const m = BigInt(1000000007);

    // Step 1: Sort the array
    A.sort((a, b) => a - b);

    // initialize max and min magic numbers
    let maxMagic = BigInt(0);
    let minMagic = BigInt(0);

    // initialize pointers
    let p1 = 0;
    let p2 = A.length - 1;

    // find max magic number
    // check elements from either ends of sorted array
    while (p1 < p2) {
        const diff = BigInt(A[p2] - A[p1]);
        maxMagic = (maxMagic % m + diff % m) % m;
        p1++;
        p2--;
    }

    // re initialize pointers
    p1 = 0;
    p2 = p1 + 1;

    // find min magic number
    // check consecutive elements of sorted array
    while (p1 < A.length) {
        const diff = BigInt(A[p2] - A[p1]);
        minMagic = (minMagic % m + diff % m) % m;
        p1 = p1 + 2;
        p2 = p2 + 2;
    }

    console.log([maxMagic, minMagic]);
    // return required output
    return [maxMagic, minMagic];
}

MaximumAndMinimumMagic([3, 11, -1, 5]);
MaximumAndMinimumMagic([2, 2]);
MaximumAndMinimumMagic([1, 8, -7, 6, 3, 4]);
MaximumAndMinimumMagic([-98, 54, -52, 15, 23, -97, 12, -64, 52, 85]);
MaximumAndMinimumMagic([7, 8, 5, 9, -4, -5, 2, 10, 3, 1]);