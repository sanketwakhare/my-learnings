function myFn(num) {
    return new Promise((resolve, reject) => {
        setTimeout(() => {
            resolve(num);
            console.log('resolved ', num)
        }, 1000);
    });
}

const arr = [4, 3, 6, 5, 7];
// arr.map(ele => myFn(ele).then((result) => console.log(result)));

// arr.reduce((acc, ele) => {
//     return new Promise((resolve, reject) => {
//         resolve(acc.then(() => myFn(ele)));
//     })
// }, Promise.resolve());

// for(let ind in arr) {
//     const test = myFn(arr[ind]);
// }

arr.reduce((accumulator, element) => {
    return new Promise((resolve) => {
        resolve(accumulator.then(() => {
            return myFn(element);
        }));
    })
}, Promise.resolve('start'));