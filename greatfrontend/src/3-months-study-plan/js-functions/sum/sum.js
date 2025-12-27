/**
 * Implement a sum function that accepts a number and allows for repeated calling with more numbers. Calling the function without an argument will sum up all the arguments thus far and return the total.

Examples
sum(1)(); // 1
sum(1)(2)(); // 3
sum(1)(2)(-3)(); // 0


 */

/**
 * @param {number} value
 * @return {Function}
 */
export default function sum(a) {
  return function (b) {
    return b === undefined ? a : sum(a + b)
  }
}