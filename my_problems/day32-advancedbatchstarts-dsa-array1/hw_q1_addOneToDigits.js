const addOneToDigits = (A) => {
    const N = A.length;
    let isElementUpdatedWithRemainder = false;
    // start from reverse direction
    for (let i = N - 1; i >= 0; i--) {
        // add 1 to the current element at index i
        let currentEle = A[i];
        let no = currentEle + 1;

        // calculate remainder
        const rem = no % 10;

        // if remainder is not 0, add 1 to the current element A[i]
        if (rem !== 0) {
            // update current digit with rem value
            A[i] = rem;
            isElementUpdatedWithRemainder = true;
            break;
        } else {
            // update current digit with rem value
            A[i] = rem;
        }
        // otherwise continue iterating next elements, carry would always be 1 if remainder of n%10 is 0
    }
    if (!isElementUpdatedWithRemainder) {
        // add digit 1 to start if carry is still present
        A.unshift(1);
    }
    // remove all 0s from start
    while (A[0] === 0) {
        A.shift();
    }

    console.log(A);
    return A;
}

addOneToDigits([1, 0, 0, 0, 0, 0]);
addOneToDigits([2, 0, 0, 9, 9]);
addOneToDigits([2, 0, 0, 0, 0]);
addOneToDigits([9, 9, 9, 9, 9]);
addOneToDigits([0, 3, 7, 6, 4, 0, 5, 5, 5]);
addOneToDigits([0, 0, 0, 3, 8, 9, 1, 3, 4]);
addOneToDigits([1, 0, 0, 3, 8, 9, 1, 3, 4]);
addOneToDigits([0, 0, 0]);
