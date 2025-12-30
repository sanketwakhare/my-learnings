/**
 * Promise.allSettled
 * 
 * Implement the Promise.allSettled() function that resolves to an array of outcomes when all the input elements are either resolved or rejected
 * 
 * Note: If you haven't completed the Promise.all question, you should attempt that first.

The Promise.allSettled() method returns a promise that resolves after all of the given promises have either fulfilled or rejected, with an array of objects that each describes the outcome of each promise.

However, if and only if an empty iterable is passed as an argument, Promise.allSettled() returns a Promise object that has already been resolved as an empty array.

For each outcome object, a status string is present. If the status is 'fulfilled', then a value is present. If the status is 'rejected', then a reason is present. The value (or reason) reflects what value each promise was fulfilled (or rejected) with.

Source: Promise.allSettled() - JavaScript | MDN

Promise.allSettled() is frequently used when there are multiple independent asynchronous tasks and we want to know the result of each promise, regardless of whether they were fulfilled or rejected.

Let's implement our own version of Promise.allSettled(), a promiseAllSettled function, with the difference being the function takes in an array instead of an iterable. Be sure to read the description carefully and implement accordingly!

Examples:
const p0 = Promise.resolve(3);
const p1 = 42;
const p2 = new Promise((resolve, reject) => {
  setTimeout(() => {
    reject('foo');
  }, 100);
});

await promiseAllSettled([p0, p1, p2]);
// [
//   { status: 'fulfilled', value: 3 },
//   { status: 'fulfilled', value: 42 },
//   { status: 'rejected', reason: 'foo' },
// ];

 */

/**
 * @param {Array} iterable
 * @return {Promise<Array<{status: 'fulfilled', value: *}|{status: 'rejected', reason: *}>>}
 */
export default function promiseAllSettled(iterable) {
  return new Promise((resolve) => {
    // Initialize results array with the correct length
    const result = new Array(iterable.length);

    // Handle empty array case - resolve immediately
    if (iterable.length === 0) {
      resolve(result);
      return;
    }

    // Track how many promises are settled
    let settledCount = 0;

    iterable.forEach((currPromise, index) => {
      // Wrap in Promise.resolve to handle non-promise values
      Promise.resolve(currPromise)
        .then((res) => {
          // Promise fulfilled
          result[index] = { status: "fulfilled", value: res };
        })
        .catch((err) => {
          // Promise rejected
          result[index] = { status: "rejected", reason: err };
        })
        .finally(() => {
          // Update counter and resolve if all promises have settled
          settledCount += 1;
          if (settledCount === iterable.length) {
            resolve(result);
          }
        });
      // async function inner() {
      //   try {
      //     const res = await currPromise;
      //     result[index] = { status: "fulfilled", value: res };
      //   } catch (err) {
      //     result[index] = { status: "rejected", reason: err };
      //   } finally {
      //     settledCount += 1;
      //     if (settledCount === iterable.length) {
      //       resolve(result);
      //     }
      //   }
      // }
      // inner();
    });
  });
}
