/***
 * Quick Sort
 * 
 * Problem Description
Given an integer array A, sort the array using QuickSort.

Problem Constraints
1 <= |A| <= 10^5
1 <= A[i] <= 10^9

Input Format
First argument is an integer array A.

Output Format
Return the sorted array.

Example Input
Input 1:
 A = [1, 4, 10, 2, 1, 5]
Input 2:
 A = [3, 7, 1]

Example Output
Output 1:
 [1, 1, 2, 4, 5, 10]
Output 2:
 [1, 3, 7]

Example Explanation
Explanation 1:
 Return the sorted array.
 */

/**
 * 
 * TC: O(N logN)
 * SC: O(N logN) for recursive call stack
 * In place sorting: Yes
 * 
 * Rearrange range within array
 * @param {Array} A array of integers
 * @param {Number} l start index of range
 * @param {Number} r end index of range
 * @returns 
 */
const rearrangeRange = (A, l, r) => {
    const pivot = A[l];

    // initialize pointers p1 and p2
    let p1 = l + 1;
    let p2 = r;

    // while p1 and p2 does not cross
    while (p1 <= p2) {

        // swap A[p1] and A[p2] if below condition is met
        // if (A[p1] >= pivot && A[p2] < pivot) {
        // }
        if (A[p1] <= pivot) {
            // increase p1 if A[p1] is less than pivot
            p1++;
        } else if (A[p2] > pivot) {
            // decrease p2 if A[p2] is greater than pivot
            p2--;
        } else {
            // swap A[p1] and A[p2]
            A[p1] = A[p1] ^ A[p2];
            A[p2] = A[p1] ^ A[p2];
            A[p1] = A[p1] ^ A[p2];
            p1++;
            p2--;
        }
    }

    // swap pivot element and A[p1-1]
    // do not swap if p1-1 === start index of range
    if (l !== p1 - 1) {
        A[l] = A[l] ^ A[p1 - 1];
        A[p1 - 1] = A[l] ^ A[p1 - 1];
        A[l] = A[l] ^ A[p1 - 1];
    }

    // return sorted position: this would be used for quick sort
    return p1 - 1;
}

/**
 * Recursive function
 * @param {Array} A array of integers
 * @param {Number} l start index of range
 * @param {Number} r end index of range
 * @returns 
 */
const quickSort = (A, l, r) => {
    if (l >= r) {
        return;
    }
    const index = rearrangeRange(A, l, r);
    quickSort(A, l, index - 1);
    quickSort(A, index + 1, r);
}

/**
 * Quick Sort
 * Sort the given array:
 * @param {Array} A array of integers
 */
const quickSortMain = (A) => {
    console.log('input array -> ', A);
    quickSort(A, 0, A.length - 1);
    console.log('sorted array -> ', A);
}

/**
 * Idea: select pivot at start, and rearrange the elements in array such that, 
 * all the elements left of the array are smaller than pivot and
 * all the elements right of the array are greater than pivot
 * 
 * The pivot element would be sorted after 1 rearrangements
 */
quickSortMain([10, 3, 8, 15, 6, 12, 2, 18, 7, 1]);