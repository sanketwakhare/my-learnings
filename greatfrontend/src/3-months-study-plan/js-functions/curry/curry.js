/**
 * Currying is the technique of converting a function that takes multiple arguments into a sequence of functions that each takes a single argument.

Implement the curry function which accepts a function as the only argument and returns a function that accepts single arguments and can be repeatedly called until at least the minimum number of arguments have been provided (determined by how many arguments the original function accepts). The initial function argument is then invoked with the provided arguments.

Examples
function add(a, b) {
  return a + b;
}

const curriedAdd = curry(add);
curriedAdd(3)(4); // 7

const alreadyAddedThree = curriedAdd(3);
alreadyAddedThree(4); // 7


function multiplyThreeNumbers(a, b, c) {
  return a * b * c;
}

const curriedMultiplyThreeNumbers = curry(multiplyThreeNumbers);
curriedMultiplyThreeNumbers(4)(5)(6); // 120

const containsFour = curriedMultiplyThreeNumbers(4);
const containsFourMulFive = containsFour(5);
containsFourMulFive(6); // 120

 */

/**
 * @param {func} func - The function to be curried
 * @return {Function} - A curried version of the function
 */
export default function curry(func) {
  // Return a new function that will handle the currying logic
  return function curried(...args) {
    // Check if we have received enough arguments to call the original function
    // func.length gives us the number of parameters the original function expects
    if (args.length >= func.length) {
      // We have enough arguments, so invoke the original function
      // Use apply to maintain the correct 'this' context
      return func.apply(this, args);
    }

    // Not enough arguments yet, so return another function that waits for more
    return (arg) =>
      // Recursively call curried with all accumulated arguments plus the new one
      curried.apply(
        this,
        // Combine previous arguments with the new argument
        // Filter out undefined values to handle cases where no argument is passed
        [...args, arg].filter((x) => x !== undefined)
      );
  };
}
