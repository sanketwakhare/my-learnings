/* Sliding Window Maximum */

//param A : array of integers
//param B : integer
//return a array of integers
const slidingMaximum = function (A, B) {
    let result = [];
    // maintain dequeue in descending order
    let dequeue = [];

    // for first window of size B
    for (let i = 0; i < B; i++) {
        const curr = A[i];

        // maintain dequeue in descending order
        while (dequeue.length !== 0 && dequeue[dequeue.length - 1] < curr) {
            dequeue.pop();
        }
        if (dequeue.length === 0 || dequeue[dequeue.length - 1] >= curr) {
            dequeue.push(curr);
        }
    }
    result.push(dequeue[0]);

    // for remaining windows
    const N = A.length;
    for (let i = 1; i < N - B + 1; i++) {
        const outgoing = A[i - 1];
        const incoming = A[i - 1 + B];

        // remove first element in dequeue if outgoing element is same
        if (dequeue[0] === outgoing) dequeue.shift();

        // maintain dequeue in descending order
        while (dequeue.length !== 0 && dequeue[dequeue.length - 1] < incoming) {
            dequeue.pop();
        }
        if (dequeue.length === 0 || dequeue[dequeue.length - 1] >= incoming) {
            dequeue.push(incoming);
        }
        // update result
        result.push(dequeue[0]);
    }

    console.log(result);
    return result;
}

slidingMaximum([1, 3, -1, -3, 5, 3, 6, 7], 3);

// 1, 3, -1, -3, 5, 3, 6, 7
// B = 3


// queue = 7

// ans = [3, 3, 5, 5, 6, 7]