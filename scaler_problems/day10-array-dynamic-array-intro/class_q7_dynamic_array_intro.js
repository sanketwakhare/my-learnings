/**
 * Given an array A of size N, convert the array into Dynamic Array
 * 
 * Time Complexity: O(N)
 */

const convertArrayToDynamicArray = (A) => {

    let dynamicArray = []
    for (let i = 0; i < A.length; i++) {
        dynamicArray.push(A[i]);
    }
    console.log(dynamicArray);
    return dynamicArray;
}

convertArrayToDynamicArray([3, 5, 4, 2, 7, 6, 8, 2, 1, 9, 10]);
convertArrayToDynamicArray([-4, 3, -7, 2, 8]);