/* Promises Intro */

// Synchronous vs Asynchronous code
console.log('start');

function walk() {
    setTimeout(() => {
        console.log('walk');
    }, 500);
}

walk();
console.log('end');

// --------------------------------------
// callbacks
function like(video, cb) {
    setTimeout(() => {
        cb(`like ${video} video`)
    }, 500);
}

function subscribe(channel, cb) {
    setTimeout(() => {
        cb(`subscribe ${channel} channel`)
    }, 500);
}

function share(video, cb) {
    setTimeout(() => {
        cb(`share ${video} video`)
    }, 500);
}

// callback hell/ pyramid of doom
function performActions() {
    like('Promises', (action) => {
        console.log(action);
        subscribe('RoadsideCoder', (action) => {
            console.log(action);
            share('Polyfills', (action) => {
                console.log(action)
            })
        })
    })
}

performActions();

// --------------------------------------
// Promise
// fulfilled, rejected
const promise = new Promise((resolve, reject) => {
    setTimeout(() => {
        const flag = true;
        if (flag)
            resolve('perform action');
        else
            reject(new Error('cannot perform action'))
    }, 2000);
});

promise
    .then((result) => {
        console.log(result);
    }).catch((error) => {
    console.log(error);
});
console.log(promise);
// -------------------------------------
// synchronous promise
let promise1 = Promise.resolve('done');
promise1.then((result) => {
    console.log(result);
});
// -------------------------------------------
// Promise chaining

// -------------------------------------------
// Promise combinators
let result = Promise.all([
    Promise.resolve('wakeup'),
    Promise.resolve('have tea'),
    new Promise((resolve, reject) => {
        setTimeout(() => {
            resolve('read book')
        }, 1000);
    })
]).then((result) => {
    console.log(result);
}).catch((error) => {
    console.log(error);
})
// -------------------------------------------------------
// async and await
function print(msg) {
    console.log(msg);
}

(async function doTasks() {
    await like('frontend interview', print);
    await like('system design', print);
    await like('dsa mock interview', print);
})(); //iife

// TODO : interview code snippets