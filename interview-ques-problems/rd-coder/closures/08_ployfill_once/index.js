// Polyfill Once

function once(cb, context) {
    let output;
    return function () {
        if (cb) {
            output = cb.apply(context || this, arguments);
            cb = null;
        }
        return output;
    }
}

const hello = once(function () {
    console.log("Hello!");
});

hello();
hello();
hello();
hello();
hello();