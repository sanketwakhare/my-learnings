/*****
 * Checkpoint
 * How would you make sure that the below function does not overflow the stack when value of a is more
 */

const printRecursion = (a) => {

    if (a === 0) {
        return;
    }
    console.log(a);
    printRecursion(a - 1);
}
// printRecursion(10);


// Ans -> 

let sm = 0;
async function print(a) {

    if (a === 0) {
        return;
    }
    setTimeout(function () {
        console.log(Number(a));
        print(a - 1);
    }, 1000);
}
print(10);