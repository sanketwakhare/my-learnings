/**
 * Implement a function that recursively flattens an array into a single level deep
 * 
 * 
 * Implement a function flatten that returns a newly-created array with all sub-array elements concatenated recursively into a single level.

Examples
// Single-level arrays are unaffected.
flatten([1, 2, 3]); // [1, 2, 3]

// Inner arrays are flattened into a single level.
flatten([1, [2, 3]]); // [1, 2, 3]
flatten([
  [1, 2],
  [3, 4],
]); // [1, 2, 3, 4]

// Flattens recursively.
flatten([1, [2, [3, [4, [5]]]]]); // [1, 2, 3, 4, 5]

 * 
 * 
 * @param {Array<*|Array>} value
 * @return {Array}
 */
export default function flatten(arr) {
  const result = [];
  for (let index = 0; index < arr.length; index++) {
    const curr = arr[index];
    if (Array.isArray(curr)) {
      result.push(...flatten(curr));
    } else {
      result.push(curr);
    }
  }
  return result;
}
