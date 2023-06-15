function createPromise(time) {
    return new Promise((resolve, reject) => {
        setTimeout(function () {
            resolve(time);
        }, time);
    })
}

function createErrorPromise(time) {
    return new Promise((resolve, reject) => {
        setTimeout(function () {
            reject(time);
        }, time);
    })

}

const promises = [createPromise(2000), createErrorPromise(300)];

Promise.any(promises)
    .then((response) => {
        console.log("one of the promise resolved", response);
    })
    .catch((error) => {
        console.log("all  promises failed", error);
    });


function myAny(promises) {
    let value;
    let promisesRejectedCount = 0;
    let promisesRejected = [];

    return new Promise((resolve, reject) => {
        promises.forEach(promise => {
            promise.then(response => {
                resolve(response);
            }).catch((error) => {
                promisesRejectedCount++;
                promisesRejected.push(error);
                if (promisesRejectedCount === promises.length) {
                    reject(promisesRejected)
                }
            })
        });
    })
}

const promisesList = [createErrorPromise(2000), createErrorPromise(300), Promise.reject('failed')];

myAny(promisesList).then(console.log).catch(console.error);

