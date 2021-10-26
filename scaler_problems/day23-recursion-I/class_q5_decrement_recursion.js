/******
 * Given no N, print numbers from N to 1 in decreasing order
 */

const decrement = (N) => {

    // base condition
    if (N === 0) {
        return;
    }
    // this order is important
    // print current N
    console.log(N);
    // and then push the function to stack
    decrement(N - 1);
}

decrement(10);
decrement(15);
decrement(20);