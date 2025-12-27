/**
 * @param {any} thisArg
 * @param {...*} argArray
 * @return {Function}
 */
Function.prototype.myBind = function (thisArg, ...argArray) {
    const originalFunction = this;
    return function (...newArgs) {
        // return originalFunction.call(thisArg, ...argArray, ...newArgs);
        return originalFunction.apply(thisArg, [...argArray, ...newArgs]);
    };
};