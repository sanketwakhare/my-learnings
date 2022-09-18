// Polyfill for Promise.any

Promise.myAny = function (promises = []) {
    return new Promise((resolve, reject) => {
        let n = promises.length;
        if (n === 0) return;
        if (!Array.isArray(promises)) throw Error('array expected but Object found');

        let failed = [];
        for (let i = 0; i < n; i++) {
            Promise.resolve(promises[i])
                // resolve whenever any promise is resolved
                .then(resolve)
                // if all failed, return error
                .catch((error) => {
                    failed.push(error);
                    if (failed.length === n) {
                        reject(failed);
                    }
                })
        }
    });
}

Promise.myAny(
    [
        Promise.reject(123),
        Promise.resolve(456),
        // Promise.reject('rejected'),
        new Promise((resolve, reject) => {
            setTimeout(() => {
                resolve('async fun')
            }, 100);
        }),
        789
    ]
).then(result => {
    console.log(result);
}).catch((error) => {
    console.error(error);
})