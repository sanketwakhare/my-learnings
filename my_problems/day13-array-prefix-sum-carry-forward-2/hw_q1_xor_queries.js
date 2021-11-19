/**
 * Xor queries
Problem Description

You are given an array A (containing only 0 and 1) as element of N length.
Given L and R, you need to determine value of XOR of all elements from L to R (both inclusive) and number of unset bits (0's) in the given range of the array.



Problem Constraints
1<=N,Q<=100000
1<=L<=R<=N


Input Format
First argument contains the array of size N containing 0 and 1 only. 
Second argument contains a 2D array with Q rows and 2 columns, each row represent a query with 2 columns representing L and R.


Output Format
Return an 2D array of Q rows and 2 columns i.e the xor value and number of unset bits in that range respectively for each query.


Example Input
A=[1,0,0,0,1]
B=[ [2,4],
    [1,5],
    [3,5] ]


Example Output
[[0 3]
[0 3]
[1 2]]


Example Explanation
In the given case the bit sequence is of length 5 and the sequence is 1 0 0 0 1. 
For query 1 the range is (2,4), and the answer is (array[2] xor array[3] xor array[4]) = 0, and number of zeroes are 3, so output is 0 3. 
Similarly for other queries.
 */

const xorQueriesWorkingSolution = (A, B) => {
    // store unset bits count
    let cntZero = [];
    cntZero.push(0);
    for (let i = 1; i <= A.length; i++) {

        if (A[i - 1] === 0) {
            cntZero.push(cntZero[i - 1] + 1);
        } else {
            cntZero.push(cntZero[i - 1]);
        }
    }

    // console.log(cntZero);

    let result = [];
    for (let i = 0; i < B.length; i++) {

        let L = B[i][0];
        let R = B[i][1];

        let innerArray = [];

        //count of 1s = total - count of zeros
        if (((R - L + 1) - (cntZero[R] - cntZero[L - 1])) % 2 === 0) {
            // even->xor 0
            innerArray.push(0);
        } else {
            innerArray.push(1);
        }


        innerArray.push((cntZero[R] - cntZero[L - 1]));
        result.push(innerArray);
    }

    console.log(result);
    return result;
}

/**
 * TC: O(N)
 * SC: O(N) for maintaining prefix array
 * @param {Array} A 
 * @param {Object} B 
 * @returns 
 */
const xorQueries = (A, B) => {

    // generate prefix array of no of unset bits
    let prefixNoOfZerosArray = [];
    // 0th index will have 0 unset bits
    prefixNoOfZerosArray.push(0);
    // given constraints are starting from 1
    for (let i = 1; i <= A.length; i++) {
        prefixNoOfZerosArray.push(prefixNoOfZerosArray[i - 1] + (A[i - 1] === 0 ? 1 : 0));
    }
    console.log(prefixNoOfZerosArray);

    // we have already have no of 0s in prefix array for a given index, we can easily find the no of 1s in prefix array
    let Q = B.length;

    let i = 0;
    let outputArray = [];
    while (Q--) {
        [L, R] = B[i];
        // innerArray will contain the output for single query
        let innerArray = [];

        // xor calculations
        let totalNoOfElementsFromLtoR = (R - L + 1);
        let noOfZerosPresentFromLtoR = (prefixNoOfZerosArray[R] - prefixNoOfZerosArray[L - 1]);
        let noOfOnesPresentFromLtoR = totalNoOfElementsFromLtoR - noOfZerosPresentFromLtoR;

        // if no of 1st present from L to R are even, the XOR will be 0
        // else if no of 1st present from L to R are odd, the XOR will be 1
        if (noOfOnesPresentFromLtoR % 2 === 0) {
            //even
            innerArray.push(0);
        } else {
            innerArray.push(1);
        }

        // unset bits = no of 0s present from L to R
        innerArray.push(noOfZerosPresentFromLtoR);
        outputArray.push(innerArray);
        // increase the index i for next query
        i++;
    }
    console.log(outputArray);
    return outputArray;
}

xorQueries([1, 0, 0, 0, 1],
    [[2, 4],
    [1, 5],
    [3, 5]]);