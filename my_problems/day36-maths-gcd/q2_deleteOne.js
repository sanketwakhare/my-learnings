/**
 * Problem Description

Given an integer array A of size N. You have to delete one element such that the GCD(Greatest common divisor) of the remaining array is maximum.
Find the maximum value of GCD.

Problem Constraints
2 <= N <= 10^5
1 <= A[i] <= 10^9

Input Format
First argument is an integer array A.

Output Format
Return an integer denoting the maximum value of GCD.

Example Input
Input 1:
 A = [12, 15, 18]
Input 2:
 A = [5, 15, 30]

Example Output
Output 1:
 6
Output 2:
 15

Example Explanation
Explanation 1:
 If you delete 12, gcd will be 3.
 If you delete 15, gcd will be 6.
 If you delete 18, gcd will 3.
 Maximum value of gcd is 6.

Explanation 2:
 If you delete 5, gcd will be 15.
 If you delete 15, gcd will be 5.
 If you delete 30, gcd will be 5.
 */

const gcd = (A, B) => {
    const a = A;
    const b = B;

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

//param A : array of integers
//return an integer
const deleteOne = (A) => {

    // initialize GCD value to 0 as gcd(0,x) = x
    let ans = 0;

    // generate prefix array of GCDs
    let gcdPrefix = [];
    gcdPrefix[0] = gcd(0, A[0]);
    for (let i = 1; i < A.length; i++) {
        gcdPrefix.push(gcd(gcdPrefix[i - 1], A[i]));
    }

    // generate suffix array of GCDs
    let gcdSuffix = new Array(A.length).fill(0);
    gcdSuffix[A.length - 1] = gcd(0, A[A.length - 1]);
    for (let i = A.length - 2; i >= 0; i--) {
        gcdSuffix[i] = gcd(gcdSuffix[i + 1], A[i]);
    }

    for (let i = 0; i < A.length; i++) {
        if (i === 0) {
            // edge case 1
            ans = Math.max(ans, gcdSuffix[i + 1]);
        } else if (i === A.length - 1) {
            // edge case 2
            ans = Math.max(ans, gcdPrefix[i - 1]);
        } else {
            // max of ans, gcd(gcd of left, gcd of right)
            ans = Math.max(ans, gcd(gcdPrefix[i - 1], gcdSuffix[i + 1]));
        }
    }
    return ans;

}


deleteOne([3, 9, 6, 8, 3]);
deleteOne([208610688, 48106344, 135402124, 34168992, 95013776, 35218040, 117231114, 172905590, 66652014, 45970782, 222323244, 203402914, 35292972, 159829956, 154584716, 107190226, 71335264, 42786172, 203327982, 3484338, 28062034, 64179258, 210993, 94938844, 155858560, 123562868, 223447224, 116744056, 55711942, 88082566, 45671054, 16072914, 165299992, 136601036, 44659472, 219063702, 202953322, 188341582, 116931386, 127759060, 131318330, 49867246, 92278758, 40875406, 218314382, 135889182, 6893744, 97111872, 56236466, 96662280, 52340002, 195010530, 44884268, 167435554, 155746162, 201679478, 54138370, 103481092, 25814074, 186093622, 208498290, 31883566, 122101694, 128058788, 133566290, 55749408, 178675354, 186056156, 155071774, 35180574, 82050540, 7755462, 29448276, 100333948, 130156884, 67850926, 44509608, 17084496, 216703344, 197295956, 174479162, 18058612, 51290954, 173917172, 51815478, 218426780, 184032992, 148140564, 108951128]);