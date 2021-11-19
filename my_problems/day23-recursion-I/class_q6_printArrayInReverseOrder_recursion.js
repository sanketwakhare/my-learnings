/**
 * Given an array A and size N, print the array elements in reverse direction. [last element to first element]
 */

const reverse = (A, index) => {

    // base condition
    if (index === 0) {
        return;
    }
    // print element from last
    console.log(A[index - 1]);
    // recursive call, decrease index by 1
    reverse(A, index - 1);

}

const main = (A) => {
    const N = A.length;
    reverse(A, N);
}

main([3, 5, 4, 8, 6, 9, 1, 2]);
main(['s', 'c', 'a', 'l', 'e', 'r']);