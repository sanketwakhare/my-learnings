/**
 * Reverse pairs
 * 
 * Problem Description

Given an array of integers A, we call (i, j) an important reverse pair if i < j and A[i] > 2*A[j].
Return the number of important reverse pairs in the given array A.

Problem Constraints
1 <= length of the array <= 10^5
-2 * 10^9 <= A[i] <= 2 * 10^9

Input Format
The only argument given is the integer array A.

Output Format
Return the number of important reverse pairs in the given array A.

Example Input
Input 1:
 A = [1, 3, 2, 3, 1]
Input 2:
 A = [4, 1, 2]

Example Output
Output 1:
 2
Output 2:
 1

Example Explanation
Explanation 1:
 There are two pairs which are important reverse i.e (3, 1) and (3, 1).
Explanation 2:
 There is only one pair i.e (4, 1).
 */

const merge = (A, l, m, r) => {

    // initialize pointers
    let p1 = l;
    let p2 = m;

    // initialize temp array
    let p3 = 0;
    let temp = new Array(r - l + 1).fill(0);

    let count = 0;
    while (p1 < m && p2 <= r) {
        if (A[p1] <= A[p2]) {
            temp[p3] = A[p1];
            p1++;
            p3++;
        } else {
            let tempPtr = p1;
            while (tempPtr < m) {
                if (A[tempPtr] > (2 * A[p2])) {
                    count = count + 1;
                }
                tempPtr++;
            }
            temp[p3] = A[p2];
            p2++;
            p3++;
        }
    }

    while (p1 < m) {
        temp[p3] = A[p1];
        p1++;
        p3++;
    }
    while (p2 <= r) {
        temp[p3] = A[p2];
        p2++;
        p3++;
    }

    for (let i = 0; i < r - l + 1; i++) {
        A[l + i] = temp[i];
    }

    return count;

}


const reversePair = (A, l, r) => {

    if (l === r) {
        return 0;
    }
    const mid = l + Math.floor((r - l) / 2);
    const x = reversePair(A, l, mid);
    const y = reversePair(A, mid + 1, r);

    const z = merge(A, l, mid + 1, r);

    return (x + y + z);
}


const reversePairsMain = (A) => {
    const answer = reversePair(A, 0, A.length - 1);
    console.log('no of pairs found->', answer);
    return answer;
}

reversePairsMain([10, 3, 8, 15, 6, 12, 2, 18, 7, 1]);
reversePairsMain([1, 3, 2, 3, 1]);
reversePairsMain([4, 1, 2]);
reversePairsMain([769, -71, 599, -1438, -530, -512, 1680, 1907, -301, 492, -844, 1765, -188, 685, -1879, -699, -990, 1022, 459, 528, -930, 1051, 1412, -1598, 245, -480, 1979, 1212, 1177, 447, -509, 881, 1968, -1603, -429, 1165, 405, 426, -1610, 931, -835, -1156, 1273, -143, -940, 199, -1886, -1646, 390, -1349, -256, -256, -103, -135, 637, -605, 55, -1805, -17, -229, 1162, 288, -818, -922, 32, -1032, -1823, -1874, -1650, 146, 721, 1586, 1969, 1720, -993, -1137, -1233, -1629, -879, -277, 444, -1191, -1273, 127, 1785, 1407, -1460, 414, -1578, -1348, 72, -794, 632, 877, 338, 1921, -650, -1314, 1187, -40]);