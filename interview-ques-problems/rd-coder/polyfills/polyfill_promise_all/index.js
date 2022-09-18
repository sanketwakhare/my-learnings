// Polyfill for Promise.all

Promise.myAll = function (promises = []) {
    return new Promise((resolve, reject) => {
        let results = [];
        let n = promises.length;

        if (n === 0) return;
        if (!Array.isArray(promises)) return;

        let count = 0;
        for (let i = 0; i < n; i++) {
            Promise.resolve(promises[i])
                .then((currResult) => {
                    results.push(currResult);
                    count++;
                    // if all are resolved, return combined array of results
                    if (count === n) {
                        resolve(results);
                    }
                })
                .catch(error => {
                    //  reject when any of the promise fails
                    reject(error);
                })
        }
    });
}

Promise.myAll([
    Promise.resolve(123),
    456,
    // Promise.reject('rejected'),
    new Promise((resolve, reject) => {
        setTimeout(() => {
            reject('async fun')
        }, 100);
    })
]).then(result => {
    console.log(result);
}).catch((error) => {
    console.error(error, `promise failed`);
})