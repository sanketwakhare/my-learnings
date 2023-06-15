/**
 * Throttle
 * @param {Function} callback callback function
 * @param {Number} wait wait time in milliseconds
 * @returns throttled function
 */
const throttle = (callback, wait = 0) => {
    let flag = true;
    return function (...args) {
        let context = this;
        if (!flag) return;
        // call fn and set flag as true
        callback.call(context, ...args);
        flag = false;
        // clear flag
        setTimeout(() => {
            flag = true;
        }, wait);
    }
}

let counter = 0;
const fn = () => {
    console.log('resized', counter++);
}

const throttledFn = throttle(fn, 500);

// normal function
// window.addEventListener('resize', fn);
// throttled function
window.addEventListener('resize', throttledFn);