/**
 * Promise.any
 * 
 * Implement the Promise.any() function that resolves when any of the input elements are resolved
 * 
 * Promise.any() takes an iterable of elements (usually Promises). It returns a single promise that resolves as soon as any of the elements in the iterable fulfills, with the value of the fulfilled promise. If no promises in the iterable fulfill (if all of the given elements are rejected), then the returned promise is rejected with an AggregateError, a new subclass of Error that groups together individual errors.

If an empty iterable is passed, then the promise returned by this method is rejected synchronously. The rejected reason is an AggregateError object whose errors property is an empty array.

Source: Promise.any() - JavaScript | MDN

Let's implement our own version of Promise.any(), a promiseAny function, with the difference being the function takes in an array instead of an iterable and AggregateErrors returned just have to return an array of error reasons, the message doesn't have to be set. Refer to the AggregateError constructor examples on MDN.

Be sure to read the description carefully and implement accordingly!

Examples:

const p0 = Promise.resolve(42);
const p1 = new Promise((resolve, reject) => {
  setTimeout(() => {
    resolve(21);
  }, 100);
});

await promiseAny([p0, p1]); // 42


const p0 = new Promise((resolve) => {
  setTimeout(() => {
    resolve(42);
  }, 100);
});
const p1 = new Promise((resolve, reject) => {
  setTimeout(() => {
    reject('Err!');
  }, 400);
});

await promiseAny([p0, p1]); // 42


const p0 = new Promise((resolve) => {
  setTimeout(() => {
    reject(42);
  }, 400);
});
const p1 = new Promise((resolve, reject) => {
  setTimeout(() => {
    reject('Err!');
  }, 100);
});

try {
  await promiseAny([p0, p1]);
} catch (err) {
  console.log(e instanceof AggregateError); // true
  console.log(e.errors); // [ 42, "Err!" ]
}

 */

/**
 * @param {Array} iterable
 * @return {Promise}
 */
export default function promiseAny(iterable) {
  return new Promise((resolve, reject) => {
    const promisesLength = iterable.length;
    if (promisesLength === 0) {
      reject(new AggregateError([]));
      return;
    }

    let rejectedCount = 0;
    const rejectedReasons = new Array(promisesLength);

    iterable.forEach((currPromise, index) => {
      Promise.resolve(currPromise)
        .then((res) => {
          resolve(res);
        })
        .catch((err) => {
          rejectedCount += 1;
          rejectedReasons[index] = err;
          if (rejectedCount === promisesLength) {
            reject(new AggregateError(rejectedReasons));
          }
        });
    });
  });
}
