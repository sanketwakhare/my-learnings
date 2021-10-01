/**
 * Closest MinMax
Problem Description

Given an array A. Find the size of the smallest subarray such that it contains atleast one occurrence of the maximum value of the array
and atleast one occurrence of the minimum value of the array.

Problem Constraints
1 <= |A| <= 2000

Input Format
First and only argument is vector A

Output Format
Return the length of the smallest subarray which has atleast one occurrence of minimum and maximum element of the array

Example Input
Input 1:
A = [1, 3]
Input 2:
A = [2]

Example Output
Output 1:
 2
Output 2:
 1

Example Explanation
Explanation 1:
 Only choice is to take both elements.
Explanation 2:

 Take the whole array.
 */


//  TODO

const closestMinMax = (A) => {

    let min = 2000;
    let max = 1;
    for (let i = 0; i < A.length; i++) {
        if (A[i] > max) {
            max = A[i];
        }
        if (A[i] < min) {
            min = A[i];
        }
    }
    console.log('min', min);
    console.log('max', max);

    let minIndex = A.length - 1;
    let maxIndex = A.length - 1;
    let minSubArrayLength = A.length;

    for (let i = 0; i < A.length; i++) {
        if (A[i] === min) {
            minSubArrayLength = Math.min(minSubArrayLength, Math.abs(i - maxIndex) + 1);
            minIndex = i;
        }
        if (A[i] === max) {
            minSubArrayLength = Math.min(minSubArrayLength, Math.abs(i - minIndex) + 1);
            maxIndex = i;
        }
    }

    console.log('minSubArrayLength', minSubArrayLength)
}

closestMinMax([1, 3]);
closestMinMax([1, 3, 4, 5, 6, 3, 2, 1, 6, 2, 1]);
closestMinMax([377, 448, 173, 307, 108]);
closestMinMax([834, 563, 606, 221, 165]);