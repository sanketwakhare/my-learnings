/*******
 * Colorful Number
Problem Description
For Given Number A find if its COLORFUL number or not.
If number A is a COLORFUL number return 1 else return 0.

What is a COLORFUL Number:
A number can be broken into different contiguous sub-subsequence parts.
Suppose, a number 3245 can be broken into parts like 3 2 4 5 32 24 45 324 245.
And this number is a COLORFUL number, since product of every digit of a contiguous subsequence is different.

Problem Constraints
1 <= A <= 2 * 10^9

Input Format
Single Argument which denotes integer A.

Output Format
Return 1 if integer A is COLORFUL else return 0.

Example Input
Input 1:
 A = 23
Input 2:
 A = 236

Example Output
Output 1:
 1
Output 2:
 0

Example Explanation
Explanation 1:
 Possible Sub-sequences: [2, 3, 23] where
 2 -> 2
 3 -> 3
 23 -> 6  (product of digits)
 This number is a COLORFUL number since product of every digit of a sub-sequence are different.

Explanation 2:
 Possible Sub-sequences: [2, 3, 6, 23, 36, 236] where
 2 -> 2
 3 -> 3
 6 -> 6
 23 -> 6  (product of digits)
 36 -> 18  (product of digits)
 236 -> 36  (product of digits)
 This number is not a COLORFUL number since the product sequence 23  and sequence 6 is same.
 */


const isColorFulNumber = (A) => {

    // break all digits and create array of each digit
    let digitsArray = [];
    while (A) {
        const mod = A % 10;
        digitsArray.push(mod);
        A = Math.floor(A / 10);
    }
    // reverse digits array
    for (let i = 0, j = digitsArray.length - 1; i < j; i++, j--) {
        // swap
        digitsArray[i] = digitsArray[i] ^ digitsArray[j];
        digitsArray[j] = digitsArray[i] ^ digitsArray[j];
        digitsArray[i] = digitsArray[i] ^ digitsArray[j];
    }
    // console.log(digitsArray);

    // create hashSet to store the unique products
    let hashSet = new Set();
    for (let i = 0; i < digitsArray.length; i++) {
        let product = 1;
        for (let j = i; j < digitsArray.length; j++) {
            product = product * digitsArray[j];
            if (hashSet.has(product)) {
                // if product is already present, return 0
                return 0;
            } else {
                hashSet.add(product);
            }
        }
    }

    // return 1 if product of each subarray is distinct
    return 1;

}

isColorFulNumber(2345);