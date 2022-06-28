/* Distribute Candy */

//param A : array of integers
//return an integer
const candy = function (A) {

    // initialize candies array
    let n = A.length;
    let candies = new Array(n).fill(0);

    // assign 1 candy to first child
    candies[0] = 1;
    for (let i = 1; i < n; i++) {
        // if current child's rating is > previous child and has less candies, update candies
        if (A[i] > A[i - 1] && candies[i] < candies[i - 1]) {
            candies[i] = candies[i - 1] + 1;
        } else {
            candies[i] = 1;
        }
    }

    // traverse form right to left
    for (let i = n - 2; i >= 0; i--) {
        if (A[i] > A[i + 1] && candies[i] <= candies[i + 1]) {
            candies[i] = candies[i + 1] + 1;
        }
    }

    // find sum and return
    let sum = candies.reduce((acc, x) => acc += x, 0);
    return sum;
}

console.log(candy([1, 5, 2, 1]));