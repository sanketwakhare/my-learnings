// Closure Scope Chain

let e = 10;

function sum(a) {
    // outer scope of function d, c and b
    // inner/local scope of sum
    return function b(b) {
        // outer scope of function d and c
        // inner/local scope of b
        return function c(c) {
            // outer scope of function d
            // inner/local scope of c
            return function d(d) {
                // inner/local scope of d
                return a + b + c + d + e;
            }
        }
    }
}

console.log(sum(1)(2)(3)(4)); // 20