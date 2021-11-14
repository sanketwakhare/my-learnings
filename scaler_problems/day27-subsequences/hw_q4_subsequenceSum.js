/******
 * Problem Description
You are given an array of integers of N size.
You have to find that there is any subsequence exists or not whose sum is equal to B.

Problem Constraints
1 <= N <= 20
1 <= A[i] <= 100000
0 <= B <= 1e9

Input Format
First Argument is array of integers A
Second Argument is B

Output Format
Return 1 if any subsequence sum is equal to B otherwise return 0.

Example Input
Input 1:
A=[1,20,13,4,5]
B=18
Input 2:
A=[2,2,2,2]
B=5

Example Output
1
Output 1:
1
Output 2:
0

Example Explanation
Explanation 1:
 There is as subsequence present at indexes 1,3,4 whose sum is 18
Explanation 2:
There is no possible subsequence whose sum is 5

NOTE: Array is considered 1 based indexing for the above explanation.
 */

/* checkBit function */
const checkBit = (N, i) => {
    N = N >> i;
    if ((N & 1) === 1) {
        return true;
    }
    return false;
}


/* main function which will compare sub of each subsequence with B */
const subSequenceSum = function (A, B) {

    // given an array of size N, there are 2^N subsequences
    const N = A.length;

    // 1<<N ~ 2^N
    // check for each subsequence
    for (let i = 0; i < (1 << N); i++) {
        let sum = 0;
        // check every bit of size N
        for (let j = 0; j < N; j++) {
            if (checkBit(i, j)) {
                sum = sum + A[j];
            }
        }
        if (sum === B) {
            return 1;
        }
    }
    return 0;
}

subSequenceSum([27, 1, 38], 66);