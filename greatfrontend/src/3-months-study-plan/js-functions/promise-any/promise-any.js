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
