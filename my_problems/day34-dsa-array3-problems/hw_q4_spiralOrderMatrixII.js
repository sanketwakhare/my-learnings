/**
 * Spiral Order Matrix II
 * 
 * Problem Description

Given an integer A, generate a square matrix filled with elements from 1 to A2 in spiral order.

Problem Constraints
1 <= A <= 1000

Input Format
First and only argument is integer A

Output Format
Return a 2-D matrix which consists of the elements in spiral order.

Example Input
Input 1:
1
Input 2:
2

Example Output
Output 1:
[ [1] ]
Output 2:
[ [1, 2], [4, 3] ]

Example Explanation
Explanation 1:
Only 1 is to be arranged.
Explanation 2:
1 --> 2
      |
      |
4<--- 3
 */

//param A : integer
//return a array of array of integers
const generateMatrix = (A) => {

    let N = A;
    let M = A;
    // store spiral traversal in an array
    let output = [];
    for (let i = 0; i < N; i++) {
        let row = new Array(M).fill(0);
        output.push(row);
    }

    let i = 0;
    let j = 0;
    let count = 1;
    while (N > 1 && M > 1) {
        //  print ith row till M-1 elements
        for (let k = 0; k < M - 1; k++) {
            output[i][j] = count++;
            j++;
        }
        // j would point to M-1th column after above for loop
        //  print jth column till N-1 elements
        for (let k = 0; k < N - 1; k++) {
            output[i][j] = count++;
            i++;
        }
        // i would point to N-1th row after above for loop
        //  print ith row in reverse direction till M-1 elements
        for (let k = 0; k < M - 1; k++) {
            output[i][j] = count++;
            j--;
        }
        // j would point to 0th column after above for loop
        for (let k = 0; k < N - 1; k++) {
            output[i][j] = count++;
            i--;
        }
        // i would point to 0th row after above for loop

        i++;
        j++;
        N = N - 2;
        M = M - 2;
    }

    //  add middle element in case A is odd
    if (N === 1 || M === 1) {
        output[i][j] = count++;
    }

    console.log(`Spiral Traversal = `, output);
    return output;
}

generateMatrix(1);
generateMatrix(2);
generateMatrix(3);
generateMatrix(4);
generateMatrix(5);
generateMatrix(6);
generateMatrix(7);
generateMatrix(10);