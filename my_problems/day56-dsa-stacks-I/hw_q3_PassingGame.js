/* Passing game */

//param A : integer
//param B : integer
//param C : array of integers
//return an integer
const solve = function (A, B, C) {
    let stack = [];
    stack.push(B);
    for (let index = 0; index < C.length; index++) {
        const curr = C[index];
        if (curr === 0 && stack.length > 0) {
            // pop
            stack.pop();
        } else {
            // push
            stack.push(curr);
        }
    }
    return stack.pop();
}
