const evalRPN = function (A) {
    let stack = [];
    for (let i = 0; i < A.length; i++) {
        const curr = A[i];
        let opr1, opr2;
        switch (curr) {
            case "+":
                opr1 = stack.pop();
                opr2 = stack.pop();
                stack.push(Number(opr2 + opr1));
                break;
            case "-":
                opr1 = stack.pop();
                opr2 = stack.pop();
                stack.push(Number(opr2 - opr1));
                break;
            case "*":
                opr1 = stack.pop();
                opr2 = stack.pop();
                stack.push(Number(opr2 * opr1));
                break;
            case "/":
                opr1 = stack.pop();
                opr2 = stack.pop();
                stack.push(Math.floor(Number(opr2 / opr1)));
                break;
            default:
                stack.push(Number(curr));
                break;
        }
    }
    return stack.pop();
}

console.log(evalRPN(["2", "1", "+", "3", "*"]));
console.log(evalRPN(["4", "13", "5", "/", "+"]));