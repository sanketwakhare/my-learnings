/**
 * Maximum Unsorted Subarray
 * 
 * Problem Description

Given an array A of non-negative integers of size N. Find the minimum sub-array Al, Al+1 ,…, Ar such that if we sort(in ascending order) that sub-array, then the whole array should get sorted. If A is already sorted, output -1.

Problem Constraints
1 <= N <= 1000000
1 <= A[i] <= 1000000

Input Format
First and only argument is an array of non-negative integers of size N.

Output Format
Return an array of length 2 where First element denotes the starting index(0-based) and second element denotes the ending index(0-based) of the sub-array. If the array is already sorted, return an array containing only one element i.e. -1.

Example Input
Input 1:
A = [1, 3, 2, 4, 5]
Input 2:
A = [1, 2, 3, 4, 5]

Example Output
Output 1:
[1, 2]
Output 2:
[-1]

Example Explanation
Explanation 1:
If we sort the sub-array A1, A2, then the whole array A gets sorted.
Explanation 2:
A is already sorted.
 */

/*****
 * Test case 1: [4, 5, 8, 6, 7], expected output = [2,4]
 * Test case 1: [1, 3, 2, 4, 5], expected output = [1,2]
 * Test case 1: [1, 2, 3, 4, 5], expected output = [-1]
 */

/**
 * Approach 1: 
 *      Maintain a copy of array and sort it -> temp array is sorted
 *      Find the startIndex and endIndex by comparing original and sorted temp array
 * TC: O(N logN)
 * SC: O(N)
 * @param {Array} A array of integers
 * @returns 
 */
const MaximumUnsortedArrayApproach1 = (A) => {

    console.log('Approach 1 -> ');

    // create copy os original array
    const N = A.length;
    let temp = [];
    for (let i = 0; i < N; i++) {
        temp.push(A[i]);
    }

    // sort the temp array
    temp.sort((a, b) => a - b);

    // compare sorted array and original array

    // start from start and find the start index
    let startIndex = -1;
    for (let i = 0; i < N; i++) {
        if (A[i] !== temp[i]) {
            startIndex = i;
            break;
        }
    }

    // start from end and find the end index
    let endIndex = -1;
    for (let i = N - 1; i >= 0; i--) {
        if (A[i] !== temp[i]) {
            endIndex = i;
            break;
        }
    }

    // if start index and end index are not updated, that means the array is already sorted
    if (startIndex === -1 && endIndex === -1) {
        console.log('answer -> ', [-1]);
        return [-1];
    }

    console.log('answer -> ', [startIndex, endIndex]);
    return [startIndex, endIndex];
}

/*****
 * Test case 1: [4, 5, 8, 6, 7], expected output = [2,4]
 * Test case 2: [1, 3, 2, 4, 5], expected output = [1,2]
 * Test case 3: [1, 2, 3, 4, 5], expected output = [-1]
 * Test case 4: [1, 2, 3], expected output = [-1]
 * Test case 5: [1, 7, 10, 5, 6, 11, 15, 12, 13, 20], expected output = [1, 8]
 */
MaximumUnsortedArrayApproach1([4, 5, 8, 6, 7]);
MaximumUnsortedArrayApproach1([1, 3, 2, 4, 5]);
MaximumUnsortedArrayApproach1([1, 2, 3, 4, 5]);
MaximumUnsortedArrayApproach1([1, 2, 3]);
MaximumUnsortedArrayApproach1([1, 7, 10, 5, 6, 11, 15, 12, 13, 20]);


/**
 * Approach 2: 
 *      Use prefixMax and suffixMin arrays
 *      To find startIndex, compare A and suffixMin
 *      To find endIndex, compare A and prefixMax
 * TC: O(N)
 * SC: O(N)
 * @param {Array} A array of integers
 * @returns 
 */
const MaximumUnsortedArrayApproach2 = (A) => {

    console.log('Approach 2 -> ');
    const N = A.length;

    // generate prefix array
    let prefixMax = new Array(N).fill(0);
    prefixMax[0] = A[0];
    for (let i = 1; i < N; i++) {
        prefixMax[i] = Math.max(prefixMax[i - 1], A[i]);
    }
    console.log('prefixMax -> ', prefixMax);

    // generate suffix array
    let suffixMin = new Array(N).fill(0);
    suffixMin[N - 1] = A[N - 1];
    for (let i = N - 2; i >= 0; i--) {
        suffixMin[i] = Math.min(suffixMin[i + 1], A[i]);
    }
    console.log('suffixMin -> ', suffixMin);

    // find startIndex value by comparing array A and suffixMin array
    let startIndex = -1;
    for (let i = 0; i < N - 1; i++) {
        // this means there is an element less than A[i] after ith index or to the right side of A[i]
        if (A[i] > suffixMin[i + 1]) {
            startIndex = i;
            break;
        }
    }

    // find endIndex value by comparing array A and prefixMax array
    let endIndex = -1;
    for (let i = N - 1; i >= 1; i--) {
        // this means there is an element greater than A[i] before ith index or to the left side of A[i]
        if (A[i] < prefixMax[i - 1]) {
            endIndex = i;
            break;
        }
    }

    // if start index and end index are not updated, that means the array is already sorted
    if (startIndex === -1 && endIndex === -1) {
        console.log('answer -> ', [-1]);
        return [-1];
    }

    console.log('answer -> ', [startIndex, endIndex]);
    return [startIndex, endIndex];
}

/*****
 * Test case 1: [4, 5, 8, 6, 7], expected output = [2,4]
 * Test case 2: [1, 3, 2, 4, 5], expected output = [1,2]
 * Test case 3: [1, 2, 3, 4, 5], expected output = [-1]
 * Test case 4: [1, 2, 3], expected output = [-1]
 * Test case 5: [1, 7, 10, 5, 6, 11, 15, 12, 13, 20], expected output = [1, 8]
 */
MaximumUnsortedArrayApproach2([4, 5, 8, 6, 7]);
MaximumUnsortedArrayApproach2([1, 3, 2, 4, 5]);
MaximumUnsortedArrayApproach2([1, 2, 3, 4, 5]);
MaximumUnsortedArrayApproach2([1, 2, 3]);
MaximumUnsortedArrayApproach2([1, 7, 10, 5, 6, 11, 15, 12, 13, 20]);


/**
 * Approach 3: 
 *      Step 1: a) Find s = index of element which is greater than next element-> from left to right -> from 0 to n-1
 *      Step 1: b) Find e = index of element which is smaller than previous element - >from right to left -> from n-1 to 0
 * 
 *      Step 2: Find Min and Max within range [s,e]
 *      Step 3: Search from left to right within range [0, s-1] and find if there is any element which is greater than Min
 *               If found, update s with index of that element
 *      Step 4: Search from right to left within range [s+1, n-1] and find if there is any element which is less than Max
 *               If found, update e with index of that element
 *      Step 5: return [s,e]
 * TC: O(N)
 * SC: O(1)
 * @param {Array} A array of integers
 * @returns 
 */
const MaximumUnsortedArrayApproach3 = (A) => {

    console.log('Approach 3 -> ');

    const N = A.length;
    let startIndex = -1;
    let endIndex = -1;

    // Step 1: a)
    for (let i = 0; i < N - 1; i++) {
        if (A[i] > A[i + 1]) {
            startIndex = i;
            break;
        }
    }

    // Step 2: b)
    for (let i = N - 1; i >= 1; i--) {
        if (A[i] < A[i - 1]) {
            endIndex = i;
            break;
        }
    }

    // if start index and end index are not updated, that means the array is already sorted
    if (startIndex === -1 && endIndex === -1) {
        console.log('answer -> ', [-1]);
        return [-1];
    }

    // Step 2: Find Min and Max within range [s,e]
    let min = A[startIndex];
    let max = A[startIndex];
    for (let i = startIndex; i <= endIndex; i++) {
        if (A[i] < min) {
            min = A[i];
        }
        if (A[i] > max) {
            max = A[i];
        }
    }

    // Step 3: Update startIndex if possible, increase the range of max possible subarray
    for (let i = 0; i < startIndex; i++) {
        if (A[i] > min) {
            startIndex = i;
            break;
        }
    }

    // Step 4: Update endIndex if possible, increase the range of max possible subarray
    for (let i = N - 1; i >= endIndex + 1; i--) {
        if (A[i] < max) {
            endIndex = i;
            break;
        }
    }

    // Step 5: return startIndex and endIndex
    console.log('answer -> ', [startIndex, endIndex]);
    return [startIndex, endIndex];
}

/*****
 * Test case 1: [4, 5, 8, 6, 7], expected output = [2,4]
 * Test case 2: [1, 3, 2, 4, 5], expected output = [1,2]
 * Test case 3: [1, 2, 3, 4, 5], expected output = [-1]
 * Test case 4: [1, 2, 3], expected output = [-1]
 * Test case 5: [1, 7, 10, 5, 6, 11, 15, 12, 13, 20], expected output = [1, 8]
 */
MaximumUnsortedArrayApproach3([4, 5, 8, 6, 7]);
MaximumUnsortedArrayApproach3([1, 3, 2, 4, 5]);
MaximumUnsortedArrayApproach3([1, 2, 3, 4, 5]);
MaximumUnsortedArrayApproach3([1, 2, 3]);
MaximumUnsortedArrayApproach3([1, 7, 10, 5, 6, 11, 15, 12, 13, 20]);