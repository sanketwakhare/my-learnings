/**
 * Change character
Problem Description

Given a string A of size N consisting of lowercase alphabets.

You can change at most B characters in the given string to any other lowercase alphabet such that the number of distinct characters in the string is minimized.

Find the minimum number of distinct characters in the resulting string.

Problem Constraints
1 <= N <= 100000
0 <= B < N

Input Format
First argument is a string A.
Second argument is an integer B.

Output Format
Return an integer denoting the minimum number of distinct characters in the string.

Example Input
A = "abcabbccd"
B = 3

Example Output
2

Example Explanation
We can change both 'a' and one 'd' into 'b'.So the new string becomes "bbcbbbccb".
So the minimum number of distinct character will be 2.
 */

/**
 * change characters B times to obtain minimum distinct character array
 * @param {String} A input string
 * @param {Number} B no of characters can be replaced
 * @returns 
 */
const changeCharacter = (A, B) => {

    // maintain count array of 26 for lower case characters
    let cnt = new Array(26).fill(0);

    // store frequency of each character
    for (let i = 0; i < A.length; i++) {
        const currentCharacter = A[i];
        let currentCharCode = currentCharacter.charCodeAt(0);
        cnt[currentCharCode - 97] += 1;
    }
    console.log(cnt);

    // sort the array by ascending order
    cnt = cnt.sort((a, b) => a - b);

    console.log(cnt);

    // reduce count from cnt array if count is non zero
    for (let i = 0; i < cnt.length && B > 0; i++) {
        while (cnt[i] > 0 && B > 0) {
            cnt[i] -= 1;
            B--;
        }
    }

    // count non zero elements in cnt array
    let answer = 0;
    for (let i = 0; i < cnt.length; i++) {
        if (cnt[i] > 0) {
            answer++;
        }
    }
    console.log(answer);
    return answer;

}

changeCharacter("abcabbccd", 3);
changeCharacter("ppwwoorrbbffggrr", 6);