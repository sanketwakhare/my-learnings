/*******
 * Given an array of integers A and an integer B. Find and return the maximum value of | s1 - s2 |
where s1 = sum of any subset of size B, s2 = sum of elements of A - sum of elemets of s1
Note |x| denotes the absolute value of x.

Input Format
The arguments given are the integer array A and integer B.

Output Format
Return the maximum value of | s1 - s2 |.

Constraints
1 <= B < length of the array <= 100000
1 <= A[i] <= 10^5 

For Example
Input 1:
    A = [1, 2, 3, 4, 5]
    B = 2
Output 1:
    9
Input 2:
    A = [5, 17, 100, 11]
    B = 3
Output 2:
    123
 */

//param A : array of integers
//param B : integer
//return an integer
const maximumDifference = (A, B) => {

    const N = A.length;
    const halfLength = Math.floor(N / 2);

    // sort the input array in descending order
    if (B > halfLength) {
        A = A.sort((a, b) => b - a);
    } else {
        A = A.sort((a, b) => a - b);
    }

    // iterate and find max B elements
    let s1 = 0;
    let arraySum = 0;
    let i = 0;
    while (i < B) {
        s1 = s1 + A[i];
        arraySum += A[i];
        i++;
    }
    while (i < N) {
        arraySum = arraySum + A[i];
        i++;
    }
    const s2 = (arraySum - s1);

    const ans = Math.abs(s1 - s2);
    console.log(ans);
    return ans;

}

maximumDifference([1, 2, 3, 4, 5], 2);
maximumDifference([5, 17, 100, 11], 3);