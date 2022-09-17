// Polyfill Memoize

const memoize = (cb) => {
    const cache = new Map();

    return function (...args) {
        const key = JSON.stringify(...args);
        if (cache.has(key)) {
            return cache.get(key);
        }
        const result = cb(...args);
        cache.set(key, result);
    };
}

const square = (num) => {
    for (let i = 0; i < 1000000; i++) {
    }
    for (let i = 0; i < 1000000; i++) {
    }
    for (let i = 0; i < 1000000; i++) {
    }
    return num * num;
}

const optimizedSquare = memoize(square);

console.time("10000-1");
console.log(optimizedSquare(100));
console.timeEnd("10000-1");

console.time("10000-2");
console.log(optimizedSquare(100));
console.timeEnd("10000-2");

