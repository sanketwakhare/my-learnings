// Function Currying

function sum(a) {

    return function () {
        let val = 0;
        for (let i = 0; i < arguments.length; i++) {
            val += arguments[i];
        }
        if (arguments.length > 0) {
            return sum(a + val);
        }
        return a;

    }
}

// console.log(sum(5)(6)(7)(4, 5)(3)(-20)(...[1, 2, 3, 4])());


function curry(a = 0) {
    let init = a;
    return function () {
        let currSum = 0;
        for (let i = 0; i < arguments.length; i++) {
            currSum += arguments[i];
        }
        if(arguments.length > 1) {
            return currSum + init;
        }
        else if (arguments.length === 0) {
            return init;
        }
        return curry(currSum + init);
    };
}

const curriedSum = curry();

console.log(curriedSum(1, 2, 3));
// 6, still callable normally
console.log(curriedSum(1)(2, 3));
// 6, currying of 1st arg
console.log(curriedSum(1)(2)(3)());
// 6, full currying
