// Function Currying using bind method
let multiply = function (x, y) {
  return x * y;
};

let multiplyByTwo = multiply.bind(this, 2);

console.log(multiplyByTwo(6));

// Function Currying using Closure
let multiplyClosure = function (x) {
  return function (y) {
    console.log(x * y);
  };
};

let multiplyByTwoClosure = multiplyClosure(2);
multiplyByTwoClosure(5);

// generic curry method
function curry(fun) {
  return function curried(...args) {
    if (args.length >= fun.length) {
      return fun.apply(this, args);
    } else if (args.length) {
      return function (...args2) {
        return curried.apply(this, args.concat(args2));
      };
    }
  };
}
let curriedMultiply = curry(multiply);
console.log(curriedMultiply(33)(2));
