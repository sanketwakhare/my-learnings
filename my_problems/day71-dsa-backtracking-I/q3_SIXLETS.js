/* SIX-LETS */

/* return number of non-empty subsequences of size B with sum <= 1000 */


//param A : array of integers
//param B : integer
//return an integer
const solve = function (A, B) {

    let sum = 0;
    let size = 0;
    return subsequenceSum(A, 0, sum, size);

    function subsequenceSum(A, index, sum, size) {
        if (index > A.length) return 0;
        if (size === B && sum <= 1000) {
            return 1;
        }
        // pick
        sum += A[index];
        let x = subsequenceSum(A, index + 1, sum, size + 1);
        // not pick
        sum -= A[index];
        let y = subsequenceSum(A, index + 1, sum, size);
        // return combined count(x + y)
        return x + y;
    }
}

console.log(solve([1, 2, 8], 2));
console.log(solve([5, 17, 1000, 11], 4));