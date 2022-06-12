const prevGreater = function (A) {

    let result = [];
    let stack = [];
    for (let i = 0; i < A.length; i++) {
        while (stack.length > 0 && stack[stack.length - 1] <= A[i]) {
            // keep removing all elements <= A[i] from stack
            // as those can not be valid answers for any of the upcoming elements
            stack.pop();
        }
        if (stack.length === 0) {
            result.push(-1);
        } else {
            result.push(stack[stack.length - 1]);
        }
        stack.push(A[i]);
    }
    return result;
}

console.log(prevGreater([34, 35, 27, 42, 5, 28, 39, 20, 28]));
console.log(prevGreater([39, 27, 11, 4, 24, 32, 32, 1]));