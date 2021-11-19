/**
 * Multiple left rotations of the array
Problem Description

Given an array of integers A and multiple values in B which represents number of times array A needs to be left rotated.

Find the rotated array for each value and return the result in the from of a matrix where i'th row represents the rotated array for the i'th value in B.

Problem Constraints
1 <= length of both arrays <= 2000 -10^9 <= A[i] <= 10^9 0 <= B[i] <= 2000


Input Format
The first argument given is the integer array A.
The second argument given is the integer array B.

Output Format
Return the resultant matrix.


Example Input
Input 1:
    A = [1, 2, 3, 4, 5]
    B = [2, 3]

Input 2:
    A = [5, 17, 100, 11]
    B = [1]


Example Output
Output 1:
    [ [3, 4, 5, 1, 2]
     [4, 5, 1, 2, 3] ]

Output 2:
    [ [17, 100, 11, 5] ]

Example Explanation
for input 1 -> B[0] = 2 which requires 2 times left rotations
1: [2, 3, 4, 5, 1]
2: [3, 4, 5, 1, 2]

B[1] = 3 which requires 3 times left rotation
1: [2, 3, 4, 5, 1]
2: [3, 4, 5, 1, 2]
2: [4, 5, 1, 2, 4]
 */

// reverse subarray from given start to end index
const reverseSubArray = (A, startIndex, endIndex) => {
    let i = startIndex;
    let j = endIndex;
    while (i < j) {
        A[i] = A[i] ^ A[j];
        A[j] = A[i] ^ A[j];
        A[i] = A[i] ^ A[j];
        i++;
        j--;
    }
}

const multipleLeftRotations = (A, B) => {

    let outArray = [];
    for (let i = 0; i < B.length; i++) {
        let rotations = B[i] % A.length;

        let tempArray = [...A];
        // reverse entire array
        reverseSubArray(tempArray, 0, A.length - 1);

        // split into 2 subarray starting B from right
        let secondSubArrayStartIndex = tempArray.length - rotations;

        // reverse both the subArrays
        reverseSubArray(tempArray, 0, secondSubArrayStartIndex - 1);
        reverseSubArray(tempArray, secondSubArrayStartIndex, tempArray.length - 1);

        // merge
        console.log('reversed', tempArray, 'after', rotations, 'rotations');
        // console.log(tempArray);
        outArray.push(tempArray);

    }
    return outArray;

}

multipleLeftRotations([1, 2, 3, 4, 5], [2, 3]);