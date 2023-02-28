// Private counter
let counter = function (init = 0) {
    let value = init;
    return function (increment = 1) {
        return value += increment;
    }
}

const ctr1 = counter(10);
console.log(ctr1());
console.log(ctr1());
console.log(ctr1());

const ctr2 = counter();
console.log(ctr2());
console.log(ctr2());
console.log(ctr2());

