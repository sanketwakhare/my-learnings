/**
 * XOR-ing the Subarrays!
Problem Description

Given an integer array A of size N.
You need to find the value obtained by XOR-ing the contiguous subarrays, followed by XOR-ing the values thus obtained. Determine and return this value.
For example, if A = [3, 4, 5] :
Subarray    Operation   Result
3        None            3
4        None            4
5        None            5
3,4      3 XOR 4         7
4,5      4 XOR 5         1
3,4,5    3 XOR 4 XOR 5   2     
Now we take the resultant values and XOR them together:

3 ⊕ 4 ⊕ 5 ⊕ 7 ⊕ 1⊕ 2 = 6 we will return 6.

Problem Constraints
1 <= N <= 105

1 <= A[i] <= 108

Input Format
First and only argument is an integer array A.

Output Format
Return a single integer denoting the value as described above.

Example Input
Input 1:

 A = [1, 2, 3]
Input 2:

 A = [4, 5, 7, 5]

Example Output
Output 1:
 2
Output 2:
 0

Example Explanation
Explanation 1:

 1 ⊕ 2 ⊕ 3 ⊕  (1 ⊕ 2 ) ⊕ (2 ⊕ 3) ⊕ (1 ⊕ 2 ⊕ 3) = 2
Explanation 2:

 4 ⊕ 5 ⊕ 7 ⊕ 5 ⊕ (4 ⊕ 5) ⊕ (5 ⊕ 7) ⊕ (7 ⊕ 5) ⊕ (4 ⊕ 5 ⊕ 7) ⊕ (5 ⊕ 7 ⊕ 5) ⊕ (4 ⊕ 5 ⊕ 7 ⊕ 5) = 0
 * 
 * 
 */

const solve = function (A) {
  let result = 0;
  // console.log(A.length);
  if ((A.length & 1) === 1) {
    //odd
    for (let i = 0; i < A.length; i++) {
      if (i % 2 === 0) result = result ^ A[i];
    }
  } else {
    // even
    result = 0;
  }
  return result;
};

console.log(
  "res",
  solve([
    18468, 6335, 26501, 19170, 15725, 11479, 29359, 26963, 24465, 5706, 28146,
    23282, 16828, 9962, 492, 2996, 11943, 4828, 5437, 32392, 14605, 3903, 154,
    293, 12383, 17422, 18717, 19719, 19896, 5448, 21727, 14772, 11539, 1870,
    19913, 25668, 26300, 17036, 9895, 28704, 23812, 31323, 30334, 17674, 4665,
    15142, 7712, 28254, 6869, 25548, 27645, 32663, 32758, 20038, 12860, 8724,
    9742, 27530, 779, 12317, 3036,
  ])
);
console.log("res", solve([3, 4, 5]));
console.log(solve([4, 5, 7, 5]));
console.log(solve([6, 7, 8, 9, 10]));
