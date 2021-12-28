/*****
 * Problem Description

You have an array A with N elements. We have 2 types of operation available on this array :
We can split a element B into 2 elements C and D such that B = C + D.
We can merge 2 elements P and Q as one element R such that R = P^Q i.e XOR of P and Q.
You have to determine whether it is possible to make array A containing only 1 element i.e. 0 after several splits and/or merge?

Problem Constraints
1 <= N <= 100000
1 <= A[i] <= 10^6

Input Format
The first argument is an integer array A of size N.

Output Format
Return "Yes" if it is possible otherwise return "No".

Example Input
Input 1:
 A = [9, 17]
Input 2:
 A = [1]

Example Output
Output 1:
 Yes
Output 2:
 No

Example Explanation

Explanation 1:
 Following is one possible sequence of operations -  
 1) Merge i.e 9 XOR 17 = 24  
 2) Split 24 into two parts each of size 12  
 3) Merge i.e 12 XOR 12 = 0  
 As there is only 1 element i.e 0. So it is possible.
Explanation 2:
 There is no possible way to make it 0.
 */

/**
 * Interesting array
 * TC: O(N)
 * SC: O(1)
 * @param {Array} A array of integers.
 * @returns 
 */
const interestingArray = (A) => {

    // Observation: if sum of all array elements is even, then it is possilbe
    // else it is not possible
    // this is because if sum is even, teh array can e splitted into two same half and xor of same elements is 0

    let answer = "No";
    let sum = 0;
    for (let i = 0; i < A.length; i++) {
        // sum += A[i];
        sum = sum ^ A[i];
    }
    if (sum % 2 === 0) {
        answer = "Yes";
    }
    console.log(answer);
    return answer;

}

interestingArray([9, 17]);
interestingArray([1]);
interestingArray([20, 17]);
interestingArray([20, 16]);
interestingArray([3, 5, 7, 9, 12, 42, 20, 16]);