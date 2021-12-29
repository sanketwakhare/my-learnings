/******
 * Problem Description
Given an array of integers A and an integer B, find and return the minimum number of swaps required to bring all the numbers less than or equal to B together.
Note: It is possible to swap any two elements, not necessarily consecutive.

Problem Constraints
1 <= length of the array <= 100000
-10^9 <= A[i], B <= 10^9

Input Format
The first argument given is the integer array A.
The second argument given is the integer B.

Output Format
Return the minimum number of swaps.

Example Input
Input 1:
 A = [1, 12, 10, 3, 14, 10, 5]
 B = 8
Input 2:
 A = [5, 17, 100, 11]
 B = 20

Example Output
Output 1:
 2
Output 2:
 1

Example Explanation
Explanation 1:
 A = [1, 12, 10, 3, 14, 10, 5]
 After swapping  12 and 3, A => [1, 3, 10, 12, 14, 10, 5].
 After swapping  the first occurence of 10 and 5, A => [1, 3, 5, 12, 14, 10, 10].
 Now, all elements less than or equal to 8 are together.
Explanation 2:
 A = [5, 17, 100, 11]
 After swapping 100 and 11, A => [5, 17, 11, 100].
 Now, all elements less than or equal to 20 are together.
 */

/**
 * Use Sliding window approach to find the minimum swaps in each window
 * count of elements which are > B in a window = no of swaps required
 * Observations: Find the (count of numbers which are <= B) = windowSize
 * There can be max possible windowSize swaps
 * 
 * For each window, find Min(no of elements > B)
 * In a window of size windowSize, find the count of elements which are > B, which is exactly same as no of swaps required
 * 
 * TC: O(N)
 * SC: O(1)
 * @param {Array} A array of integers.
 * @param {*} B 
 * @returns 
 */
const minimumSwaps = (A, B) => {

    console.log(A, B);

    const N = A.length;
    let countOfEleGreaterThanBInAWindow = 0;

    // find no of elements <=B
    let windowSize = 0;
    for (let i = 0; i < N; i++) {
        if (A[i] <= B) {
            windowSize++;
        }
    }
    console.log('windowSize -> ', windowSize)

    // find no of elements which are > B in 1st window
    for (let i = 0; i < windowSize; i++) {
        if (A[i] > B) {
            countOfEleGreaterThanBInAWindow++;
        }
    }

    console.log('no of ele > B in first window -> ', countOfEleGreaterThanBInAWindow)

    let minSwapsRequired = countOfEleGreaterThanBInAWindow;
    for (let i = windowSize; i < N; i++) {
        // if previous element before start of new window is > B, decrease count
        if (A[i - windowSize] > B) {
            countOfEleGreaterThanBInAWindow--;
        }
        // if new element at the end of new window is > B, increase count
        if (A[i] > B) {
            countOfEleGreaterThanBInAWindow++;
        }
        console.log(`no of ele > B in ${i - windowSize + 2} window -> `, countOfEleGreaterThanBInAWindow)

        // maintain the min count
        minSwapsRequired = Math.min(countOfEleGreaterThanBInAWindow, minSwapsRequired);
    }

    console.log('minimum Swaps Required -> ', minSwapsRequired);
    return minSwapsRequired;
}

/*  Test Case 1: 
                A = [52, 7, 93, 47, 68, 26, 51, 44, 5, 41, 88, 19, 78, 38, 17, 13, 24, 74, 92, 5, 84, 27, 48, 49, 37, 59, 3, 56, 79, 26, 55, 60, 16, 83, 63, 40, 55, 9, 96, 29, 7, 22, 27, 74, 78, 38, 11, 65, 29, 52, 36, 21, 94, 46, 52, 47, 87, 33, 87, 70]
                B = 19
                Expected output = 7
    Test Case 2: 
                A = [1, 12, 10, 3, 14, 10, 5]
                B = 8
                Expected output = 2
    Test Case 3: 
                A = [5, 17, 100, 11]
                B = 20
                Expected output = 1
    Test Case 4: 
                A = [1, 12, 10, 3, 14, 10, 5]
                B = 13
                Expected output = 1
*/
minimumSwaps([52, 7, 93, 47, 68, 26, 51, 44, 5, 41, 88, 19, 78, 38, 17, 13, 24, 74, 92, 5, 84, 27, 48, 49, 37, 59, 3, 56, 79, 26, 55, 60, 16, 83, 63, 40, 55, 9, 96, 29, 7, 22, 27, 74, 78, 38, 11, 65, 29, 52, 36, 21, 94, 46, 52, 47, 87, 33, 87, 70], 19);
minimumSwaps([1, 12, 10, 3, 14, 10, 5], 8);
minimumSwaps([5, 17, 100, 11], 20);
minimumSwaps([1, 12, 10, 3, 14, 10, 5], 13);