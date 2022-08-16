/* Permutations */

//param A : array of integers
//return a array of array of integers
const permute = function (A) {

    let result = [];
    backtrack(A, 0, result);
    return result;

    function backtrack(A, index, result) {

        // base condition - save permutation
        if (index === A.length) {
            result.push([...A]);
        }

        for (let k = index; k < A.length; k++) {
            swap(A, index, k);
            backtrack(A, index + 1, result);
            swap(A, index, k);
        }
    }

    // swap index i and index j
    function swap(A, i, j) {
        let temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}

console.log(permute([1, 2, 3]));
console.log(permute([1, 2, 3, 4]));