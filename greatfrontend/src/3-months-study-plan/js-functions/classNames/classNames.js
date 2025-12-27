/**
 * @param {...(any|Object|Array<any|Object|Array>)} args
 * @return {string}
 */
export default function classNames(...args) {
  const classes = [];
  for (const curr of args) {
    if (!curr) continue;
    if (Array.isArray(curr)) {
      classes.push(classNames(...curr));
    } else if (typeof curr === "object") {
      const keys = Object.keys(curr);
      for (const currKey of keys) {
        if (curr[currKey]) classes.push(currKey);
      }
    } else {
      classes.push(curr);
    }
  }
  return classes.join(" ");
}

console.log(classNames([]));
