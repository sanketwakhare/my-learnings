new Promise((resolve) => {
    resolve(
        new Promise((res) => {
            setTimeout(res, 1000);
        }),
    );
}).then((onfulfilled) => {
    console.log('fulfilled', onfulfilled);
}, (onrejected) => {
    console.log('rejected', onrejected);
})

const myPromise = new Promise((resolve, reject) => {
    setTimeout(() => {
        console.log("called after 400 ms");
        resolve("resolved after 400 ms");
    }, 400);
});

myPromise
    .then(handleFulfilledCallback)
    .catch(handleRejectedCallback);

function handleFulfilledCallback() {
    console.log('promise resolved');
}

function handleRejectedCallback() {
    console.log('promise rejected');
}

myPromise
    .then((value) => `${value} and bar`)
    .then((value) => `${value} and bar again`)
    .then((value) => `${value} and again`)
    .then((value) => `${value} and again`)
    .then((value) => `${value} and again`)
    .then((value) => {
        console.log(value);
        // throw Error('failed')
    })
    .catch((err) => {
        console.error('catch1', err);
        // throw new Error('failed again')
    })
    .catch((err) => {
        console.error('catch2', err);
    })
    .then((value) => console.log('finally1'))
    .then((value) => console.log('finally2'));


