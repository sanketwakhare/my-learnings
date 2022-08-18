/* All Unique Permutations */

//param A : array of integers
//return a array of array of integers
const permute = function (A) {

    let result = [];
    backtrack(A, 0, result);
    result = Array.from(new Set(result.map(JSON.stringify)), JSON.parse);
    console.log(result.length);
    return result;

    function backtrack(A, index, result) {
        if (index === A.length) {
            result.push([...A]);
        }

        for (let i = index; i < A.length; i++) {
            swap(A, i, index);
            backtrack(A, index + 1, result);
            swap(A, i, index);
        }
    }

    function swap(A, i, j) {
        let temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}

console.log(permute([1, 1, 2]));
console.log(permute([1, 2]));
console.log(permute([2, 5, 3, 4, 2, 5, 3, 1, 6]));