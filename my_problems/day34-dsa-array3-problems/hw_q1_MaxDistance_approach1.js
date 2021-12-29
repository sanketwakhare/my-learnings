/**
 * Problem Description
Given an array A of integers of size N. Find the maximum of value of j - i such that A[i] <= A[j].

Problem Constraints
1 <= N <= 1000000
-10^9 <= A[i] <= 10^9

Input Format
First argument is an integer array A of size N.

Output Format
Return an integer denoting the maximum value of j - i.

Example Input
Input 1:
A = [3, 5, 4, 2]

Example Output
Output 1:
2

Example Explanation
Explanation 1:
For A[0] = 3 and A[2] = 4, the ans is (2 - 0) = 2. 
 */

/**
 * Test case 1:  A = [11, 5, 12, 4, 9, 2], expected output = 3
 * Test case 2:  A = [3, 5, 4, 2], expected output = 2
 * Test case 3:  A = [1, 5, 12, 4, 9], expected output = 4
 */

/**
 * Approach 1: Using hashMap
 * TC: O(N logN)
 * SC: O(N)
 * @param {Array} A array of integers
 * @returns 
 */
const maximumGapApproach1_hashMapAndSorting = (A) => {

    /**
     * Approach 1: TC: (N logN), SC: O(N): Accepted Solution
     * Idea: Using hashMap[to maintain the indexes of elements] and sorting to satisfy condition A[i]<=A[j]
     *  Step 1: Create hashMap with key = A[i] and value = [i1,i2...in]
     *  Step 2: Sort the hashMap according to keys = sortedMap
     *  Step 3: Create/Populate the indexArray from sortedMap in order
     *  Step 4: Generate the suffix Max/RMax array from indexArray
     *  Step 5: Compare array generated in Step 3 and Step 4, and find ma difference
     */

    const N = A.length;
    // Create a hashMap with <A[i],[i1,i2...in]> which will maintain the original indices of the array elements
    // hashMap <key, value> => <A[i], [List of indices]>
    let hashMap = new Map();
    for (let i = 0; i < N; i++) {

        if (!hashMap.has(A[i])) {
            hashMap.set(A[i], [i]);
        } else {
            let list = hashMap.get(A[i]);
            list.push(i);
            hashMap.set(A[i], list);
        }
    }
    console.log('hashMap<A[i], [i1,i2...in]> -> ', hashMap);

    // sort the hashMap based on keys i.e. A[i]
    let sortedMap = [...hashMap.entries()].sort((a, b) => {
        return a[0] - b[0];
    });
    console.log('sorted HashMap -> ', sortedMap);

    // maintain a copy of all the indices of sorted map in order
    let indexArray = [];
    for (let entries of sortedMap) {
        // copy all indices into indexArray
        const indices = entries[1];
        for (let j = 0; j < indices.length; j++) {
            indexArray.push(indices[j]);
        }
    }

    // create RMax array/suffix max array of indexArray
    let suffixMax = new Array(indexArray.length).fill(0);
    suffixMax[indexArray.length - 1] = indexArray[indexArray.length - 1];
    for (let i = indexArray.length - 2; i >= 0; i--) {
        suffixMax[i] = Math.max(suffixMax[i + 1], indexArray[i]);
    }

    // compare RMax and indexArray's corresponding elements at ith pos and find the max difference
    let maxDiff = Number.MIN_SAFE_INTEGER;
    for (let i = 0; i < indexArray.length; i++) {
        maxDiff = Math.max(maxDiff, (suffixMax[i] - indexArray[i]));
    }

    console.log('max difference j-i -> ', maxDiff);
    return maxDiff;

}

/**
 * Test Case 1: A = [11, 5, 12, 4, 9, 2], expected output = 3
 * Test Case 2: A = [3, 5, 4, 2], expected output = 2
 * Test Case 3: A = [1, 5, 12, 4, 9], expected output = 4
 * Test Case 4: A = [1, 5, 12, 9, 5, 4, 9], expected output = 6
 */
maximumGapApproach1_hashMapAndSorting([11, 5, 12, 4, 9, 2]);
maximumGapApproach1_hashMapAndSorting([3, 5, 4, 2]);
maximumGapApproach1_hashMapAndSorting([1, 5, 12, 4, 9]);
maximumGapApproach1_hashMapAndSorting([1, 5, 12, 9, 5, 4, 9]);