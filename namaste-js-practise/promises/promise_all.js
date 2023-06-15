function createPromise(time) {
    return new Promise((resolve, reject) => {
        setTimeout(function () {
            resolve(time);
        }, time);
    })
}

const tasks = [createPromise(400), createPromise(600), createPromise(200), new Promise(() => {
    throw Error('can not create')
})];

Promise.all(tasks)
    .then(result => {
        console.log("all promises fulfilled", result);
    }).catch((error) => {
        console.log("promise rejected", error);
    });

function myAll(tasksPromises) {
    const arr = [];
    let tasksDone = 0;

    return new Promise((resolve, reject) => {

        tasksPromises.forEach((currentPromise, i) => {
            currentPromise.then((value) => {
                arr[i] = value;
                tasksDone++;
                if (tasksDone === tasksPromises.length) {
                    resolve(arr);
                }
            }).catch((err) => {
                reject(err);
            });
        });
    })
}

// Promise.prototype.myAll = myAll;

myAll(tasks)
    .then(result => {
        console.log("all promises fulfilled", result);
    }).catch(console.log);