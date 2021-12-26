/**
 * Given an array of N elements, rearrange the array such that
 * A[0] should go to its sorted position.
 * All the elements smaller than A[0] should go to its left and
 * all the elements greater than A[0] should go to its right
 */

const rearrangeArray = (A) => {

    console.log('input array -> ', A);

    // initialize pointers: use two pointers approach
    let p1 = 1;
    let p2 = A.length - 1;

    // while p1 and p2 does not cross
    while (p1 < p2) {

        // swap A[p1] and A[p2] if condition is met
        if (A[p1] >= A[0] && A[p2] < A[0]) {
            // swap A[p1] and A[p2]
            let temp = A[p1];
            A[p1] = A[p2];
            A[p2] = temp;
        }
        if (A[p1] <= A[0]) {
            // increase p1 when A[p1] is less than or equal to A[0]
            p1++;
        } else if (A[p2] > A[0]) {
            // decrement p2 when A[p2] is greater than A[0]
            p2--;
        }
    }

    // at last, swap A[0] and A[p1-1]
    A[0] = A[0] ^ A[p1 - 1];
    A[p1 - 1] = A[0] ^ A[p1 - 1];
    A[0] = A[0] ^ A[p1 - 1];

    console.log('array after rearrangement -> ', A);
}

rearrangeArray([10, 3, 8, 15, 6, 12, 2, 18, 7, 1]);