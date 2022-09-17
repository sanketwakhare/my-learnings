// Block Scope and setTimeout

const testScope1 = function () {
    for (var i = 1; i <= 5; i++) {
        setTimeout(() => {
            console.log(i);
        }, i * 1000);
    }
}();
// prints 6, five times


// -----------------------------
// using let instead of var
const testScope2 = function () {
    for (let i = 1; i <= 5; i++) {
        setTimeout(() => {
            console.log(i);
        }, i * 1000);
    }
}();
// logs 1 2 3 4 5 after every second

// -----------------------------
// without let
const testScope3 = function () {

    for (var i = 1; i <= 5; i++) {
        function inner(ind) {
            // local scope
            setTimeout(() => {
                console.log(ind);
            }, ind * 1000);
        }
        inner(i);
    }
}();
// logs 1 2 3 4 5 after every second
