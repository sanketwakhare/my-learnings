/**
 * Given an array A of size N, count no of elements which have at least one element greater than itself.
 *
 * eg. A= [3,-2,6,8,4,8,5]
 * 3,-2,6,4,5 have greater elements than themselves i.e. 8
 * count would be 5
 * Output: 5
 *
 * * eg. A= [3,2,3,10,10,5,10]
 * 3,2,3,5 have greater elements than themselves i.e. 10
 * count would be 4
 * Output: 4
 */

/**
 * no of iteration: 2N
 * Time Complexity : O(N)
 * 
 * @param {array} A 
 * @returns count
 */
const countElementsGreaterThanItself = (A) => {
    // find max element
    let max = A[0];
    for (let i = 0; i < A.length; i++) {
        if (max < A[i]) {
            max = A[i];
        }
    }
    // compare each element with max and update the count
    let count = 0;
    for (let i = 0; i < A.length; i++) {
        if (A[i] === max) {
            count++;
        }
    }
    console.log(A.length - count);
    // return all the elements except the max element
    return A.length - count;
};

countElementsGreaterThanItself([3, -2, 6, 8, 4, 8, 5])
countElementsGreaterThanItself([3, 2, 3, 10, 10, 5, 10])