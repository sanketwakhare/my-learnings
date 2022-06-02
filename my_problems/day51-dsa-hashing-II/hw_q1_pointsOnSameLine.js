const gcd = (A, B) => {

    A = Math.abs(A);
    B = Math.abs(B);

    // Consider B> A for all the cases
    if (A > B) {
        // swap A and B
        const temp = A;
        A = B;
        B = temp;
    }

    // GCD can be written as [gcd(A,B) = gcd(A, B - A) where B > A],
    // (B-A) % A = B % A are nothing but the same

    // GCD can also be simplified as [gcd (A,B) = gcd(A, B % A) where B > A]
    while (A > 0) {
        const temp = A;
        A = B % A;
        B = temp;
    }
    return B;
}

const slope = (x1, y1, x2, y2) => {
    const rise = y2 - y1;
    const run = x2 - x1;
    const gcdValue = gcd(rise, run);
    let numerator = rise / gcdValue;
    let denominator = run / gcdValue;

    return numerator.toString() + "/" + denominator.toString();
    // return rise/run;
}

//param A : array of integers
//param B : array of integers
//return an integer
const solve = function(A, B) {

    let ans = 2;
    for (let i = 0; i < A.length; i++) {
        let slopesMap = new Map();
        const x1 = A[i];
        const y1 = B[i];

        let same = 0;
        let localMax = 0;
        for (let j = 0; j < A.length; j++) {
            if (i !== j) {
                const x2 = A[j];
                const y2 = B[j];

                // count same points/coordinates
                if (x1 === x2 && y1 === y2) {
                    same++;
                    continue;
                }

                const slopeData = slope(x1, y1, x2, y2);
                const slopeValue = slopeData;
                // const value = slopeData[1];

                if (slopesMap.has(slopeValue)) {
                    const value = slopesMap.get(slopeValue) + 1;
                    slopesMap.set(slopeValue, value);
                    localMax = Math.max(localMax, value);
                } else {
                    slopesMap.set(slopeValue, 2);
                    localMax = Math.max(localMax, 2);
                }
            }
        }

        ans = Math.max(ans, localMax + same);
        // "4/2" -> gcd(4,2) = 2 => 2/1
        // "2/1"
        // console.log(slopesMap);
    }
    console.log(ans);
    return ans;

}



let A = [48, 45, -3, 7, -25, 38, 2, 13, 13, 18, -44, 34, -27, -46, 48, -39, -41, -32, -16, 17, -6, 44, -28, -44, -6, -43, -16, 30, -3, -27, 32, 38, -26, 20, 4, -44, -37];
let B = [47, -42, 41, 22, -4, -35, -45, -22, 5, -20, 21, -13, 47, 32, -48, 47, 17, -23, 30, -30, 37, 42, 44, 23, 1, -40, -9, 34, -34, 49, 16, -35, 2, -19, 31, 23, -37];
solve(A, B); //expected result 4

A = [-1, 0, 1, 2, 3, 3];
B = [1, 0, 1, 2, 3, 4];
solve(A, B); // expected result 2

A = [3, 1, 4, 5, 7, -9, -8, 6];
B = [4, -8, -3, -2, -1, 5, 7, -4];
solve(A, B); // expected result 2

A = [1, 1, 1, 1];
B = [1, 1, 1, 1];
solve(A, B); // expected result 3