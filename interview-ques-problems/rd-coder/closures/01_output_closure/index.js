// Output Closure

// global scope
let count = 0;
(function immediate() {
    // function scope
    // outer scope of below if condition
    let count = 0;
    if (count === 0) {
        // inner scope
        let count = 1;// shadowed
        console.log(count); // Output? -> 1
    }
    count = 2;
    // access to count from global scope
    console.log(count); // Output? -> 2
})(); // IIFE - Immediately Invoked Function Expression

// global scope
console.log(count); // Output? -> 0