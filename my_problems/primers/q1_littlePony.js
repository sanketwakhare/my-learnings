const searchItemIndex = (inputArray, start, end, find) => {
    let mid = Math.floor((start + end) / 2);
    if (start > end) {
        return mid + 1;
    }
    if (find === inputArray[mid]) {
        return mid + 1;
    } else if (find < inputArray[mid]) {
        // search in left subtree
        return searchItemIndex(inputArray, start, mid - 1, find);
    } else if (find > inputArray[mid]) {
        // search in right subtree
        return searchItemIndex(inputArray, mid + 1, end, find);
    }
};

//param A : array of integers
//param B : array of integers
//return a array of integers
const solve = function (A, B) {
    let sumArray = [];
    // sum array
    let sum = A.reduce((sum, x) => {
        sum = sum + x;
        sumArray.push(sum);
        return sum;
    }, 0);
    const output = B.map((element) => {
        return searchItemIndex(sumArray, 0, sumArray.length - 1, element);
    });
    return output;
}

// console.log(solve([3, 4, 4, 6], [20, 4, 10, 2]));
console.log(solve([2, 3, 4, 6], [20, 4, 10, 2]));