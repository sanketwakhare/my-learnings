/**
 * Multiplication of previous and next
Given an array of integers A, update every element with multiplication of previous and next elements with following exceptions. a) First element is replaced by multiplication of first and second. b) Last element is replaced by multiplication of last and second last.

Input Format
The only argument given is the integer array A.
Output Format

Return the updated array.
Constraints

1 <= length of the array <= 100000
-10^4 <= A[i] <= 10^4
For Example

Input 1:
    A = [1, 2, 3, 4, 5]
Output 1:
    [2, 3, 8, 15, 20]

Input 2:
    A = [5, 17, 100, 11]
Output 2:
    [85, 500, 187, 1100]
 */

const multiplicationOfPrevAndNext = (A) => {

    // for array of length 1
    if (A.length <= 1) {
        console.log(A);
        return A;
    }

    // create dynamic array to store the updated values
    let outArray = [];
    outArray.push(A[0] * A[1]);
    for (let i = 1; i < A.length - 1; i++) {
        const prev = A[i - 1];
        const next = A[i + 1];
        outArray.push(prev * next);
    }
    outArray.push(A[A.length - 2] * A[A.length - 1]);

    console.log(outArray);
    return outArray;
}

multiplicationOfPrevAndNext([1, 2, 3, 4, 5]);
multiplicationOfPrevAndNext([5, 17, 100, 11]);
multiplicationOfPrevAndNext([4]);
multiplicationOfPrevAndNext([4, 6]);
multiplicationOfPrevAndNext([4, -2, 0]);