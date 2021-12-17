/**
 * Smallest XOR problem
 */

const countSetBits = (A) => {
    let count = 0;
    for (let i = 0; i < 32; i++) {
        if (A & (1 << i)) {
            count++;
        }
    }
    return count;
}

const smallestXOR = (A, B) => {

    const noOfSetBitsInA = countSetBits(A);
    console.log(noOfSetBitsInA);

}

smallestXOR(15, 2);
smallestXOR(3, 3);
smallestXOR(14, 2);
smallestXOR(8, 3);