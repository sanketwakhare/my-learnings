/**
 * 
 */

const strangeEquality = (A) => {
    // Idea:
    // To find X = smaller closest number to A
    // omit last set bit /MSB bit and toggle all remaining bits
    // e.g. if A = 5, (101) => omit first MSB set bit at index 2 and toggle remaining bits i.e. 01 to 10
    // To find Y = greater closest number to A
    // make all bits as 0 and add 1 MSB bit to left of last set MSB bit
    // e.g. A= 5(101) => add 2^(i+1) to 0 where i is MSB set bit => 8(1000)

    // Formula:
    //  A+B = (A ^ B) + 2 (A & B)

    // Find X
    let X = A;
    let i;
    // find the first set bit
    for (i = 31; i >= 0; i--) {
        if ((1 << i) & X) {
            X = X - (1 << i);
            break;
        }
    }
    // toggle remaining bits to the right (toggle ith bit in X)
    for (i = i - 1; i >= 0; i--) {
        if ((1 << i) & X) {
            // if set bit found, subtract 2^i from X
            X = X - (1 << i);
        } else {
            // if unset bit found, add 2^i from X
            X = X + (1 << i);
        }
    }
    console.log(`X = ${X}`);

    // Find Y
    let Y = 0;
    // add 1 set bit to the right of MSB and make remaining bits 0
    // e.g. if A=1010 then Y should be 10000
    for (i = 31; i >= 0; i--) {
        // if set bit is found, add 2^(i+1) to 0
        if ((1 << i) & A) {
            Y = Y + (1 << (i + 1));
            break;
        }
    }
    console.log(`Y = ${Y}`);

    const ans = X ^ Y;
    console.log(`ans = ${ans}`);

}
strangeEquality(5);
strangeEquality(10);
strangeEquality(8);
strangeEquality(28);