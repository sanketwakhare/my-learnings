/******
 * Given no N, print numbers from 1 to N in increasing order
 */

const increment = (N) => {

    // base condition
    if (N === 0) {
        return;
    }
    // this order is important
    // push the function to stack and then print later

    increment(N - 1);

    /* use setTimeout to not block the main thread/ avoid the stack overflow error */
    setTimeout(function () { increment(N - 1) }, 1);

    // print current N
    console.log(N);
}

increment(10);
increment(15);