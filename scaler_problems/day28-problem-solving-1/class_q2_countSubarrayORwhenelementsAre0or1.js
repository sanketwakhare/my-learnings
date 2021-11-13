/* Given N array elements, each element is either 0 or 1, calculate no of subarray whose OR of all elements is 1*/

const countSubarrayOR = (A) => {

    // calculate no of subarray whose OR of all elements is 1
    const N = A.length;
    let count = 0;
    let subArrayCount = 0;
    for (let i = 0; i < A.length; i++) {
        if (A[i] === 1) {
            subArrayCount += (count * (count + 1)) / 2;
            // reset count to 0
            count = 0;
        } else {
            count++;
        }
    }
    const result = Math.floor(((N) * (N + 1)) / 2) - subArrayCount;
    console.log(result);
    return result;
}

// countSubarrayOR([0, 1, 0, 0, 1]);
// countSubarrayOR([0, 1, 0, 0, 1, 0]);
countSubarrayOR([0, 0, 0, 1, 0, 0, 1, 0, 0, 1, 1, 0, 0]);