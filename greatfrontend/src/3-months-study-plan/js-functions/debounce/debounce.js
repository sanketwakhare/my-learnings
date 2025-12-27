/**
 * Implement a function to limit how many times a function can be executed by delaying the execution of the function until after a specified time after its last execution attempt
 */

/**
 * @param {Function} func
 * @param {number} wait
 * @return {Function}
 */
export default function debounce(func, wait = 0) {
  let timeoutId;
  return function (...args) {
    clearTimeout(timeoutId);
    timeoutId = setTimeout(() => func.apply(this, args), wait);
    // timeoutId = setTimeout(() => func.call(this, ...args), wait);
  };
}