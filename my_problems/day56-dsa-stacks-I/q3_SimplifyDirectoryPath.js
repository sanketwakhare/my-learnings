/*  Simplify Directory Path */

module.exports = {
    //param A : string
    //return a strings
    simplifyPath: function (A) {
        let arr = A.split('/');
        arr = arr.filter(x => {
            return (!(x === '' || x === '.'));
        });

        let stack = [];
        for (let index = 0; index < arr.length; index++) {
            const ch = arr[index];
            if (ch === '..') {
                stack.pop();
            } else stack.push(ch);
        }

        return "/" + stack.join("/");
    }
};

const m = module.exports;
console.log(m.simplifyPath("/c/a/../d/../e/"));