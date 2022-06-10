/* Double Character Trouble */

module.exports = {
    //param A : string
    //return a strings
    solve: function (A) {
        let stack = [];
        stack.push(A.charAt(0));
        for (let index = 1; index < A.length; index++) {
            let ch = A.charAt(index);
            if (ch === stack[stack.length - 1]) {
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        return stack.join("");
    }
};
