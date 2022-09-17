// generic curry function

function multiply(a, b, c) {
    return a * b * c;
}

console.log(multiply(2, 3, 4));


// convert f(a,b,c) to f(a)(b)(c)

const curriedMultiply = genericCurry(multiply);

console.log(curriedMultiply(2)(3)(4));

function genericCurry(callbackFn) {
    return function curriedFn(...args) {
        if (args.length < callbackFn.length) {
            return function (...next) {
                return curriedFn(...args, ...next);
            }
        } else {
            // below all three statements are valid
            // return callbackFn.call(this, ...args);
            return callbackFn.apply(this, args);
            // return callbackFn(...args);
        }
    }
}