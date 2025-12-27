/**
 * 
 * Implement the Array.prototype.filter() method
 * 
 * Array.prototype.filter
 * 
 * Array.prototype.filter creates a new array populated with the results of calling a provided function on every element in the calling array.

For sparse arrays (e.g. [1, 2, , 4]), the empty values should be ignored while traversing the array (i.e. they should not be in the resulting array).

Implement Array.prototype.filter. To avoid overwriting the actual Array.prototype.filter which is being used by the autograder, we shall instead implement it as Array.prototype.myFilter.

Examples
[1, 2, 3, 4].myFilter((value) => value % 2 == 0); // [2, 4]
[1, 2, 3, 4].myFilter((value) => value < 3); // [1, 2]

Notes
The filter callback function takes in more than just the element! There's also a second parameter for Array.prototype.filter as well. You are recommended to read the specification for Array.prototype.filter on MDN Docs before attempting.
 */

interface Array<T> {
  myFilter(
    callbackFn: (value: T, index: number, array: Array<T>) => boolean,
    thisArg?: any
  ): Array<T>;
}

Array.prototype.myFilter = function (callbackFn, thisArg) {
  // 'this' here is actual array on which myFilter is called
  if (!this) {
    throw new TypeError("Array.prototype.myFilter called on null or undefined");
  }
  if (typeof callbackFn !== "function") {
    throw new TypeError(callbackFn + " is not a function");
  }

  const result = [] as any[];
  for (let index = 0; index < this.length; index++) {
    const curr = this[index];
    if (callbackFn.call(thisArg, curr, index, this)) {
      result.push(curr);
    }
  }
  // Alternatively, we can use forEach
  // this.forEach((curr, index) => {
  //   if (callbackFn.call(thisArg, curr, index, this)) {
  //     result.push(curr);
  //   }
  // })
  return result;
};

// Array.prototype.myFilter = function (callbackFn, thisArg) {
//   if (this == null) {
//     throw new TypeError('Array.prototype.myFilter called on null or undefined');
//   }

//   if (typeof callbackFn !== 'function') {
//     throw new TypeError(callbackFn + ' is not a function');
//   }

//   const O = Object(this) as any;
//   const len = O.length >>> 0;
//   const res: any[] = [];

//   for (let i = 0; i < len; i++) {
//     if (i in O) {
//       const val = O[i];
//       const keep = callbackFn.call(thisArg, val, i, O);
//       if (keep) {
//         res.push(val);
//       }
//     }
//   }

//   return res;
// };
