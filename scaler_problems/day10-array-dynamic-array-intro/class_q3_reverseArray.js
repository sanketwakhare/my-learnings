/**
 * Given an array A of size N, reverse an array elements
 * No extra space: O(1) is allowed
 *
 * Input1:
 * A = [2,5,3,4,8,6]
 * Output1:
 * [6,8,4,3,5,2]
 *
 * Input2:
 * A = [2,5,3,6,4,8,6]
 * Output2:
 * [6,8,4,6,3,5,2]
 */

/**
 * No of Iterations: N/2
 * Time Complexity: O(N)
 * 
 * @param {Array} A 
 * @returns reversed array
 */
const reverse = (A) => {
    // use no extra space
    // swap elements within array
    i = 0;
    j = A.length - 1;
    while (i < j) {
        //swap elements without using extra variable
        A[i] = A[i] ^ A[j];
        A[j] = A[i] ^ A[j];
        A[i] = A[i] ^ A[j];

        i++;
        j--;
    }

    console.log('reversed array: ', A);
    return A;
}

reverse([2, 5, 3, 4, 8, 6]);
reverse([2, 5, 3, 7, 4, 8, 6]);