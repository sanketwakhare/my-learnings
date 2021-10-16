/****
 * Sort by Color
Problem Description

Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.
Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
Note: Using library sort function is not allowed.

Problem Constraints
1 <= N <= 1000000
0 <= A[i] <= 2

Input Format
First and only argument of input contains an integer array A.

Output Format
Return an integer array in asked order

Example Input
Input 1 :
    A = [0 1 2 0 1 2]
Input 2:
    A = [0]

Example Output
Output 1:
    [0 0 1 1 2 2]
Output 2:
    [0]

Example Explanation
Explanation 1:
    [0 0 1 1 2 2] is the required order.
 */

const mergeSubArray = (leftSubArray, rightSubArray) => {
    let mergedArray = [];
    let i = 0;
    let j = 0;
    while (i < leftSubArray.length && j < rightSubArray.length) {
        if (leftSubArray[i] <= rightSubArray[j]) {
            mergedArray.push(leftSubArray[i]);
            i++;
        } else {
            mergedArray.push(rightSubArray[j]);
            j++;
        }
    }

    while (i < leftSubArray.length) {
        mergedArray.push(leftSubArray[i]);
        i++;
    }

    while (j < rightSubArray.length) {
        mergedArray.push(rightSubArray[j]);
        j++;
    }
    return mergedArray;
}

const mergeSort = (array, left, right) => {
    if (left >= right) {
        return [array[left]];
    }
    const mid = left + Math.floor((right - left) / 2);
    const leftSubArray = mergeSort(array, left, mid);
    const rightSubArray = mergeSort(array, mid + 1, right);

    let mergedArray = mergeSubArray(leftSubArray, rightSubArray);
    return mergedArray;
}

/*****
 * Main function
 */
const mergeSortMainFunction = (A) => {
    // merge sort
    const result = mergeSort(A, 0, A.length - 1);
    console.log(result);

}

mergeSortMainFunction([0, 1, 2, 0, 1, 2]);