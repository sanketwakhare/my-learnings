/*****
 * Given an array A of size N of integers, check if there exist a subset with GCD 1
 * Return true if yes , return false otherwise
 */


const gcd = (a, b) => {
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
        a = b % a;
        b = temp;
    }
    return b;
}

const checkSubsetWithGCD1 = (A) => {

    let tempGcd = A[0];
    for (let i = 1; i < A.length; i++) {
        tempGcd = gcd(A[i], tempGcd);
    }
    if (tempGcd === 1) {
        console.log(true);
        return true;
    }
    console.log(false, 'gcd is', tempGcd);
    return false;
}

checkSubsetWithGCD1([2, 30, 70, 15, 8, 30]);
checkSubsetWithGCD1([6, 30, 10, 60, 15]);
checkSubsetWithGCD1([10, 8, 6, 90, 14, 12]);