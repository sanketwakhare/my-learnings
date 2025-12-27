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