/**
 * Implement the Promise.all() function that resolves to an array of results if all the input elements are resolved or rejects otherwise.
 * 
 * 
 * Examples:
 * 

// Resolved example.
const p0 = Promise.resolve(3);
const p1 = 42;
const p2 = new Promise((resolve, reject) => {
  setTimeout(() => {
    resolve('foo');
  }, 100);
});

await promiseAll([p0, p1, p2]); // [3, 42, 'foo']


// Rejection example.
const p0 = Promise.resolve(30);
const p1 = new Promise((resolve, reject) => {
  setTimeout(() => {
    reject('An error occurred!');
  }, 100);
});

try {
  await promiseAll([p0, p1]);
} catch (err) {
  console.log(err); // 'An error occurred!'
}

 */

/**
 * @param {Array} iterable
 * @return {Promise<Array>}
 */
export default function promiseAll(iterable) {
  return new Promise((resolve, reject) => {
    const result = new Array(iterable.length);
    if (iterable.length === 0) {
      resolve(result);
      return;
    }

    let unresolved = iterable.length;

    for (let index = 0; index < iterable.length; index += 1) {
      const currPromise = iterable[index];
      async function inner() {
        try {
          const res = await currPromise;
          result[index] = res;
          unresolved -= 1;
          if (unresolved === 0) {
            resolve(result);
          }
        } catch (err) {
          reject(err);
        }
      }
      inner();
    }
  });
}
