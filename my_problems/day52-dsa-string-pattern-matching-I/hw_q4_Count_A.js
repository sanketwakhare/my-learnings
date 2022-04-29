/* Count A */

/* Problem Description
You are given a string A. Find the number of substrings that start and end with 'a'.



Problem Constraints
1 <= |A| <= 105

The string will have only lowercase English letters.



Input Format
Given the only argument is a String A.



Output Format
Return number of substrings that start and end with 'a'.



Example Input
Input 1:

 A = "aab"
Input 2:

 A = "bcbc"


Example Output
Output 1:

 3
Output 2:

 0


Example Explanation
Explanation 1:

 Substrings that start and end with 'a' are:
    1. "a"
    2. "aa"
    3. "a"
Explanation 2:

 There are no substrings that start and end with 'a'. */

//param A : string
//return an integer
const solve = function(A) {
    let count = 0;
    let subSequenceCount = 0;
    const M = 1000000007;

    for (let i = A.length - 1; i >= 0; i--) {
        if (A[i] === 'a') {
            count++;
            subSequenceCount += count;
        }
    }
    console.log(subSequenceCount % M);
    return subSequenceCount % M;
}

solve("aab");
solve("bcfetggdsr");
solve("ngdkfjnaiwerjiankgernag");