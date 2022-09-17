// Time Optimization with Closures

// function without Closure
function find(index) {
    let arr = [];
    for (let i = 0; i < 1000000; i++) {
        arr[i] = i * i;
    }
    console.log(arr[index]);
}

console.time("firstCall");
find(6);
console.timeEnd("firstCall");
console.time("secondCall");
find(50);
console.timeEnd("secondCall");

// ----------------------------------------------------------------------

// Closure - Time Optimization
function find() {
    let arr = [];
    for (let i = 0; i < 1000000; i++) {
        arr[i] = i * i;
    }

    return function (index) {
        console.log(arr[index]);
    }
}

console.time("find");
const closure = find();
console.timeEnd("find");

console.time("firstCall");
closure(6);
console.timeEnd("firstCall");
console.time("secondCall");
closure(50);
console.timeEnd("secondCall");