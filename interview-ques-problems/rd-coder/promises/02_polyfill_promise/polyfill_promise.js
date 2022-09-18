// Promise polyfill

function MyPromise(executor) {
    let onResolve;
    let onReject;
    let isFulfilled = false;
    let isRejected = false;
    let isCalled = false;
    let result;

    function resolve(value) {
        isFulfilled = true;
        result = value;
        if (typeof onResolve === 'function') {
            onResolve(result);
            isCalled = true;
        }
    }

    function reject(value) {
        isRejected = true;
        result = value;
        if (typeof onReject == 'function') {
            onReject(result);
            isCalled = true;
        }
    }

    this.then = (function (cb) {
        onResolve = cb;
        if (isFulfilled && !isCalled) {
            isCalled = true;
            onResolve(result);
        }
        return this;
    });

    this.catch = (function (cb) {
        onReject = cb;
        if (isRejected && !isCalled) {
            isCalled = true;
            onReject(result);
        }
        return this;
    });
    try {
        executor(resolve, reject);
    } catch(error) {
        reject(error);
    }
}

const testExecutor = new MyPromise((resolve, reject) => {
    // asynchronous
    setTimeout(() => {
        // resolve(1)
        reject(10)
    }, 100);

    // synchronous
    // resolve(5);
    // reject(5);
});

const result = testExecutor.then((result) => {
    console.log(result);
}).catch((error) => {
    console.log(error);
});
console.log(result);