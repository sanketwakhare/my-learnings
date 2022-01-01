/**
 * Find gcd of a and b
 * TC: depends upon the value of b
 * @param {Number} a integer
 * @param {Number} b integer 
 * @returns 
 */
const gcd_approach2 = (a, b) => {

    const tempA = a;
    const tempB = b;
    if (a > b) {
        // swap a and b if a > b
        const temp = b;
        b = a;
        a = temp;
    }
    while (a > 0) {
        if (a > b) {
            // swap a and b if a > b
            const temp = b;
            b = a;
            a = temp;
        }
        let temp = a;
        a = b - a;
        b = temp;
    }
    console.log('gcd of', tempA, tempB, 'is', b);
    return b;
}

gcd_approach2(3, 9);
gcd_approach2(1, 10);
gcd_approach2(10, 1);
gcd_approach2(101, 44);
gcd_approach2(12, 15);
gcd_approach2(270, 120);
gcd_approach2(500, 510);
gcd_approach2(8632, 8650);