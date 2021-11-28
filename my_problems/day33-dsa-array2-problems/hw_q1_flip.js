/****
 * FLIP
 * 
Problem Description

You are given a binary string A(i.e. with characters 0 and 1) consisting of characters A1, A2, …, AN. In a single operation, you can choose two indices L and R such that 1 ≤ L ≤ R ≤ N and flip the characters AL, AL+1, …, AR. By flipping, we mean change character 0 to 1 and vice-versa.

Your aim is to perform ATMOST one operation such that in final string number of 1s is maximised.

If you don't want to perform the operation, return an empty array. Else, return an array consisting of two elements denoting L and R. If there are multiple solutions, return the lexicographically smallest pair of L and R.

NOTE: Pair (a, b) is lexicographically smaller than pair (c, d) if a < c or, if a == c and b < d.

Problem Constraints
1 <= size of string <= 100000

Input Format
First and only argument is a string A.

Output Format
Return an array of integers denoting the answer.

Example Input
Input 1:
A = "010"
Input 2:
A = "111"

Example Output
Output 1:
[1, 1]
Output 2:
[]

Example Explanation
Explanation 1:
A = "010"

Pair of [L, R] | Final string
_______________|_____________
[1 1]          | "110"
[1 2]          | "100"
[1 3]          | "101"
[2 2]          | "000"
[2 3]          | "001"

We see that two pairs [1, 1] and [1, 3] give same number of 1s in final string. So, we return [1, 1].
Explanation 2:

No operation can give us more than three 1s in final string. So, we return empty array [].
 */

/**
 * Flip the bits
 * @param {String} inputString 
 * @returns subarray with max (count of 0's - count of 1's)
 */
const flip = (inputString) => {
    //param A : string
    //return a array of integers

    // const N = inputString.length;
    let A = inputString.split("");
    // find the subarray such that there are maximum no of 0s and min no of 1s => max(count of 0's - count of 1's)
    const N = A.length;
    // convert array: replace 0 with 1 and 1 with -1
    for (let i = 0; i < N; i++) {
        if (A[i] === '1') {
            A[i] = -1;
        } else {
            A[i] = 1;
        }
    }

    console.log(A);

    // use Kadence algorithm
    // generate prefix array with max Sum and find max sum and index = r
    let sum = 0;
    let maxSum = A[0];
    let r = 0;
    let prefSum = new Array(N).fill(-1);
    for (let i = 0; i < N; i++) {
        sum = sum + A[i];
        if (sum > maxSum) {
            maxSum = sum;
            r = i;
        }
        if (sum < 0) {
            sum = 0;
        } else {
            prefSum[i] = sum;
        }
    }
    console.log(prefSum);
    console.log(maxSum, r);

    // find start index of subarray
    let l = r;
    while (l >= 0) {
        if (prefSum[l] >= 0) {
            l--;
        } else {
            l++;
            break;
        }
    }
    if (l === -1) {
        l = 0;
    }
    console.log(l + 1, r + 1)

    return [l + 1, r + 1];

}

flip('010');
flip('110101110110011');
flip('100111101');
flip('0111000100010');
flip('100101101');