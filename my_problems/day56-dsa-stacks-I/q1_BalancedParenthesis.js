/* Balanced Parenthesis */
module.exports = {
    //param A : string
    //return an integer
    solve: function (A) {
        let stack = [];
        for (let index = 0; index < A.length; index++) {
            const ch = A.charAt(index);
            if (ch === '(' || ch === '{' || ch === '[') {
                stack.push(ch);
            } else {
                if (ch === ')') {
                    if (stack[stack.length - 1] === '(') {
                        stack.pop();
                    } else return 0;
                } else if (ch === ']') {
                    if (stack[stack.length - 1] === '[') {
                        stack.pop();
                    } else return 0;
                } else if (ch === '}') {
                    if (stack[stack.length - 1] === '{') {
                        stack.pop();
                    } else return 0;
                }
            }
        }
        if (stack.length > 0) return 0;
        return 1;
    }
};
