interface Array<T> {
  myMap<U>(
    callbackFn: (value: T, index: number, array: Array<T>) => U,
    thisArg?: any,
  ): Array<U>;
}
/**
 * Array.prototype.map implementation
 * 
 * Array.prototype.map creates a new array populated with the results of calling a provided function on every element in the calling array.

Implement Array.prototype.map. To avoid overwriting the actual Array.prototype.map which is being used by the autograder, we shall instead implement it as Array.prototype.myMap.

Examples
[1, 2, 3, 4].myMap((i) => i); // [1, 2, 3, 4]
[1, 2, 3, 4].myMap((i) => i * i); // [1, 4, 9, 16]


Notes
The map callback function takes in more than just the element! There's also a second parameter for Array.prototype.map as well. You are recommended to read the specification for Array.prototype.map on MDN Docs before attempting.
 */
Array.prototype.myMap = function (callbackFn, context) {
  if (!this) {
    throw new TypeError("Array.prototype.myMap called on null or undefined");
  }

  if (typeof callbackFn !== "function") {
    throw new TypeError(`${callbackFn} is not a function`);
  }

  const result = new Array(this.length);
  for (let index = 0; index < this.length; index++) {
    if (Object.prototype.hasOwnProperty.call(this, index)) {
      result[index] = callbackFn.call(context, this[index], index, this);
    }
  }
  return result;
};
