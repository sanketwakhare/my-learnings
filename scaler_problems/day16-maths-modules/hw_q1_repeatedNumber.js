/***
 * Repeat and Missing Number Array
You are given a read only array of n integers from 1 to n.
Each integer appears exactly once except A which appears twice and B which is missing.
Return A and B.

Note: Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
Note that in your output A should precede B.

Example:
Input:[3 1 2 5 3] 
Output:[3, 4] 
A = 3, B = 4
 */

/**
 * TC: O(N), SC: O(1)
 * @param {Array} A 
 * @returns 
 */
const repeatedNumber = function (A) {

    const N = A.length;

    let sum = BigInt(0);
    let squareSum = BigInt(0);
    let arrSum = BigInt(0);
    let arrSquareSum = BigInt(0);

    // for(let i=1; i<=N; i++) {
    //     sum = sum + i;
    //     squareSum = squareSum + i*i;
    // }

    for (let i = 1; i <= N; i++) {

        sum = sum + BigInt(i);
        squareSum = squareSum + BigInt(i * i);

        const currentElement = BigInt(A[i - 1]);
        arrSum = arrSum + currentElement;
        arrSquareSum = arrSquareSum + BigInt(currentElement * currentElement);
    }

    let duplicate;
    let missing;

    duplicate = ((((BigInt(squareSum - arrSquareSum) / BigInt(sum - arrSum)) - sum + arrSum) / BigInt(2)));
    missing = BigInt(sum - arrSum) + BigInt(duplicate);

    return [duplicate, missing];

}

repeatedNumber([3, 1, 2, 5, 3]);
repeatedNumber([2, 5, 4, 5, 3]);