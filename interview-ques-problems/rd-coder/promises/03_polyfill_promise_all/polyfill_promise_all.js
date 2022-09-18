// Promise.all polyfill

Promise.myAll = function (promises) {
    return new Promise((resolve, reject) => {
        let result = [];
        if (!Array.isArray(promises)) {
            return new Error('invalid arguments')
        }
        if (!promises.length) {
            resolve(result);
            return;
        }

        let count = 0;
        for (let i = 0; i < promises.length; i++) {
            Promise.resolve(promises[i])
                .then((res) => {
                    result[i] = res;
                    count++;
                    if (count === promises.length) {
                        resolve(result);
                    }
                }, reject)
        }

    })
}

const likeVideo = (video) => {
    return new Promise((resolve, reject) => {
        setTimeout(() => {
            resolve(`like video ${video}`);
        }, 1000);
    })
}

Promise.myAll([
    Promise.resolve('test1'),
    new Promise((resolve, reject) => {
        reject(new Error('test4'));
    }),
    likeVideo('system design', (msg) => console.log(msg)),
    Promise.resolve('test3'),
]).then(res => {
    console.log(res);
}).catch(error => {
    console.log(error + ' rejected');
})

