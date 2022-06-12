const nextGreater = function (A) {

    let result = new Array(A.length);
    let stack = [];
    for (let i = A.length - 1; i >= 0; i--) {
        while (stack.length > 0 && stack[stack.length - 1] <= A[i]) {
            // keep removing all elements <= A[i] from stack
            // as those can not be valid answers for any of the upcoming elements
            stack.pop();
        }
        if (stack.length === 0) {
            result[i] = -1;
        } else {
            result[i] = stack[stack.length - 1];
        }
        stack.push(A[i]);
    }
    return result;
}

console.log(nextGreater([34, 35, 27, 42, 5, 28, 39, 20, 28]));
console.log(nextGreater([39, 27, 11, 4, 24, 32, 32, 1]));