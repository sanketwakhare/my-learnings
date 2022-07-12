/*  Colorful Number */

//param A : integer
//return an integer
const colorful = function (A) {

    // convert into string and consider every subarray product
    let digits = String(A).split('');

    let hashSet = new Set();
    for (let i = 0; i < digits.length; i++) {
        let product = 1;
        for (let j = i; j < digits.length; j++) {
            product = product * Number(digits[j]);
            if (hashSet.has(product)) {
                // if product is already present, return 0
                return 0;
            } else {
                hashSet.add(product);
            }
        }
    }

    return 1;
}

console.log(colorful(23));
console.log(colorful(236));