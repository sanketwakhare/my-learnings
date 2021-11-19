/**
 * MAX - MIN
Given an array of integers A and an integer B, find and return the difference of B'th max element and B'th min element of the array A.


Input Format

The first argument given is the integer array A.
The second argument given is integer B.
Output Format

Return the value of B'th max element of A - B'th min element of A.
Constraints

1 <= B <= length of the array <= 100000
-10^9 <= A[i] <= 10^9 
For Example

Input 1:
    A = [1, 2, 3, 4, 5]
    B = 2
Output 1:
    2   (4 - 2 = 2)

Input 2:
    A = [5, 17, 100, 11]
    B = 1
Output 2:
    95  (100 - 5 = 95)
 */

const merge = (leftSubArray, rightSubArray) => {
    const leftSubArrayLength = leftSubArray.length;
    const rightSubArrayLength = rightSubArray.length;

    // merge two subarray
    let mergedSubArray = [];
    i = 0;
    j = 0;
    while (i < leftSubArrayLength && j < rightSubArrayLength) {
        if (leftSubArray[i] <= rightSubArray[j]) {
            mergedSubArray.push(leftSubArray[i]);
            i++;
        } else if (leftSubArray[i] > rightSubArray[j]) {
            mergedSubArray.push(rightSubArray[j]);
            j++;
        }
    }

    // push remaining elements from left subarray
    while (i < leftSubArrayLength) {
        mergedSubArray.push(leftSubArray[i]);
        i++;
    }
    // push remaining elements from right subarray
    while (j < rightSubArrayLength) {
        mergedSubArray.push(rightSubArray[j]);
        j++;
    }
    // console.log(mergedSubArray)
    return mergedSubArray;
}

const mergeSort = (array, left, right) => {
    if (left >= right) {
        return [array[left]];
    }
    const mid = left + Math.floor((right - left) / 2);
    const leftSubArray = mergeSort(array, left, mid);
    const rightSubArray = mergeSort(array, mid + 1, right);

    return merge(leftSubArray, rightSubArray);
}

/**
 * 
 * @param {Array} A 
 * @param {Integer} B 
 * @returns 
 */
const bthMaxMinusBthMin = (A, B) => {
    // sort the array
    // A.sort((a, b) => a - b);
    // merge sort time Complexity: O(N logN)
    const sortedArray = mergeSort(A, 0, A.length - 1);
    console.log(sortedArray[sortedArray.length - B] - sortedArray[B - 1])
    return sortedArray[sortedArray.length - B] - sortedArray[B - 1];

}

bthMaxMinusBthMin([1, 2, 3, 4, 5], 2);
bthMaxMinusBthMin([40, 15, -17, 100, 11], 1)
