/* Container with most water */
const maxArea = function(A) {

    // edge case
    let N = A.length;
    if (N < 2) return 0;

    let start = 0;
    let end = N - 1;
    let maxArea = 0;
    while (start < end) {
        // find area and update max area
        let height = Math.min(A[end], A[start]);
        let width = end - start;
        maxArea = Math.max(maxArea, height * width);

        // move pointes with min element
        if (A[start] < A[end]) start++;
        else end--;
    }
    console.log(maxArea);
    return maxArea;
}

maxArea([1, 5, 4, 3]);