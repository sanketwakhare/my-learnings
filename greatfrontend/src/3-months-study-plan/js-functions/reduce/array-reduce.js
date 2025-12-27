/**
 * Implement the Array.prototype.reduce() method
 * 
 * Array.prototype.reduce
 * 
 * 
 * Array.prototype.reduce is a way of "reducing" elements in an array by calling a "reducer" callback function on each element of the array in order, passing in the return value from the calculation on the preceding element. The final result of running the reducer across all elements of the array is a single value.

Implement Array.prototype.reduce. To avoid overwriting the actual Array.prototype.reduce which is being used by the autograder, we shall instead implement it as Array.prototype.myReduce.

Examples

[1, 2, 3].myReduce((prev, curr) => prev + curr, 0); // 6
[1, 2, 3].myReduce((prev, curr) => prev + curr, 4); // 10

Notes
There are some nuances regarding how the Array.prototype.reduce function works and what values are being passed to the reducer callback. You are recommended to read the specification for Array.prototype.reduce on MDN Docs before attempting.
 */

/**
 * @template T, U
 * @param {(previousValue: U, currentValue: T, currentIndex: number, array: T[]) => U} callbackFn
 * @param {U} [initialValue]
 * @return {U}
 */
Array.prototype.myReduce = function (callbackFn, initialValue) {
  if(initialValue === undefined && this.length === 0) {
    throw new TypeError('empty array with no initial value')
  }

  let accumulator = initialValue === undefined ? this[0] : initialValue;
  const startingIndex = initialValue === undefined ? 1 : 0;
  for(let index = startingIndex; index < this.length; index++) {
    if(Object.hasOwn(this, index)) {
      accumulator = callbackFn(accumulator, this[index], index, this)
    }
  }
  return accumulator;
};