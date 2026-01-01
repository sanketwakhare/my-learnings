/**
 * Deep Equal
 * 
 * Implement a function deepEqual that performs a deep comparison between two values. It returns true if two input values are deemed equal, and returns false if not.

You can assume there are only JSON-serializable values (numbers, strings, boolean, null, objects, arrays).
There wouldn't be cyclic objects, i.e. objects with circular references.
Examples

deepEqual('foo', 'foo'); // true
deepEqual({ id: 1 }, { id: 1 }); // true
deepEqual([1, 2, 3], [1, 2, 3]); // true
deepEqual([{ id: '1' }], [{ id: '2' }]); // false
 */

/**
 * @param {*} valueA
 * @param {*} valueB
 * @return {boolean}
 */
export default function deepEqual(valueA, valueB) {
  if (typeof valueA !== typeof valueB) {
    return false;
  }

  // Handle arrays
  if (Array.isArray(valueA) && Array.isArray(valueB)) {
    if (valueA.length !== valueB.length) {
      return false;
    }
    return valueA.every((val, index) => {
      return deepEqual(val, valueB[index]);
    });
  }

  if (Array.isArray(valueA) || Array.isArray(valueB)) {
    return false;
  }

  // Handle objects
  if (typeof valueA === "object" && valueA !== null && valueB !== null) {
    const keysA = Object.keys(valueA);
    const keysB = Object.keys(valueB);
    if (keysA.length !== keysB.length) {
      return false;
    }
    return keysA.every((k) => {
      if (!keysB.includes(k)) {
        return false;
      }
      return deepEqual(valueA[k], valueB[k]);
    });
  }

  // Handle primitives and null
  return valueA === valueB;
}
