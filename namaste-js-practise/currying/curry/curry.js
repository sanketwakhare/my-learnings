function curry(func) {

    return function curried(...args) {
        if (args.length >= func.length) {
            return func.call(this, ...args);
        }
        return function (...args2) {
            return curried.call(this, ...args, ...args2);
        }
    }
}
