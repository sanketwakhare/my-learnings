const findEvenSubarray = (A) => {
    const N = A.length;

    let start = 0;
    let end = N - 1;

    // check if start element is even
    while (start < end && (A[start] & 1) === 1) {
        //if odd, increment start index by 1
        start++;
    }
    while (end > start && (A[end] & 1) === 1) {
        //if odd, decrement end index by 1
        end--;
    }
    // now both start and end are pointing to even element

    // check if even length subarray is possible
    let tempStart = start + 1;
    let tempEnd = end - 1;
    // check if there exist a even element
    while (A[tempStart] % 2 !== 0 && tempStart < tempEnd) {
        tempStart += 2;
    }
    while (A[tempEnd] % 2 !== 0 && tempStart < tempEnd) {
        tempEnd -= 2;
    }

    if (tempStart < tempEnd) {
        console.log("YES")
    } else {
        console.log("NO")
    }
}

// findEvenSubarray([2, 4, 5, 6, 8, 9]);
// findEvenSubarray([2, 4, 6, 8]);
// findEvenSubarray([2, 4, 6, 7]);
findEvenSubarray([121, 351, 314, 562, 953, 319, 859, 413, 201, 640, 66, 723, 998, 612, 291, 539, 463, 340, 64, 251, 807, 457, 584, 944, 315, 327, 769, 675, 113, 364, 488, 579, 674, 340, 950, 516, 618, 599, 186, 496, 403, 450, 833, 79, 229, 150, 497, 256, 971, 687, 318, 717, 540, 126, 906, 843, 417, 557, 97, 370, 409, 148, 968, 562, 534, 845, 378]);