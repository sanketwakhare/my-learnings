// generic curry function

function multiply(a, b, c) {
    return a * b * c;
}

console.log(multiply(2, 3, 4));


// convert f(a,b,c) to f(a)(b)(c)

// valid as well
function curry(cb) {
    console.log(cb.length);
    return function curriedFunc(...args) {
        console.log(args);
        if (args.length < cb.length) {
            return function (...next) {
                return curriedFunc(...args, ...next);
            }
        } else {
            return cb(...args)
        }
    }
}

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