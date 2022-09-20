// https://codesandbox.io/live/6442b954097?file=/src/index.js

// Promises - throttle function
let itr = 1;

function getBal() {
    console.log("getBal called");
    return itr++;
}

function throttle(cb, delay = 3000) {
    let resp = null;
    return function () {
        if (resp === null) {
            return new Promise((resolve, reject) => {
                resp = cb();
                resolve(resp);
                setTimeout(() => {
                    resp = null;
                }, delay);
            });
        }
        return Promise.resolve(resp);
    }
}

const throttledGetBal = throttle(getBal, 3000);

// getBal Called
throttledGetBal().then((resp) => console.log(resp)); // 1
throttledGetBal().then((resp) => console.log(resp)); // 1
throttledGetBal().then((resp) => console.log(resp)); // 1
throttledGetBal().then((resp) => console.log(resp)); //  1

setTimeout(() => {
    // getBal Called
    throttledGetBal().then((resp) => console.log(resp)); // 2
    throttledGetBal().then((resp) => console.log(resp)); // 2
    throttledGetBal().then((resp) => console.log(resp)); // 2
    throttledGetBal().then((resp) => console.log(resp)); //  2
    setTimeout(() => {
        // will be invoked after 13 seconds
        throttledGetBal().then((resp) => console.log(resp)); //  3
    }, 8000);
}, 5000);

setTimeout(() => {
    // getBal Called
    throttledGetBal().then((resp) => console.log(resp)); // 1
}, 2000);

setTimeout(() => {
    // getBal Called
    throttledGetBal().then((resp) => console.log(resp)); // 2
}, 8000);

setTimeout(() => {
    // getBal Called
    throttledGetBal().then((resp) => console.log(resp)); // 3
}, 15000);