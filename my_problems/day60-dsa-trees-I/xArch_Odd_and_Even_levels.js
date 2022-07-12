/* Odd and Even Levels
* https://www.scaler.com/academy/mentee-dashboard/class/20839/homework/problems/4677/?navref=cl_pb_nv_tb
*
*
* Problem Description
Given a binary tree of integers. Find the difference between the sum of nodes at odd level and sum of nodes at even level.

NOTE: Consider the level of root node as 1.


Problem Constraints
1 <= Number of nodes in binary tree <= 100000
0 <= node values <= 10^9


Input Format
First and only argument is a root node of the binary tree, A


Output Format
Return an integer denoting the difference between the sum of nodes at odd level and sum of nodes at even level.


Example Input
Input 1:

        1
      /   \
     2     3
    / \   / \
   4   5 6   7
  /
 8
Input 2:

        1
       / \
      2   10
       \
        4


Example Output
Output 1:
 10
Output 2:
 -7

Example Explanation
Explanation 1:

 Sum of nodes at odd level = 23
 Sum of ndoes at even level = 13
Explanation 2:

 Sum of nodes at odd level = 5
 Sum of ndoes at even level = 12
* */

//param A : root node of tree
//return an integer
const oddEvenLevelSumDifference = (A) => {
    // sums[0] represents odd sum
    // sums[1] represents even sum
    let sums = [0, 0];
    getSum(A, 1, sums);
    return sums[0] - sums[1];
}

const getSum = (root, level, sums) => {
    if (root === null) return;

    if (level % 2 === 1) {
        // odd level
        sums[0] += root.data;
    } else {
        // even level
        sums[1] += root.data;
    }
    getSum(root.left, level + 1, sums);
    getSum(root.right, level + 1, sums);
}

// Definition for a  binary tree node
function TreeNode(data) {
    this.data = data
    this.left = null
    this.right = null
}

let root1 = new TreeNode(1);
root1.left = new TreeNode(2);
root1.right = new TreeNode(3);
root1.left.left = new TreeNode(4);
root1.left.right = new TreeNode(5);
root1.right.left = new TreeNode(6);
root1.right.right = new TreeNode(7);
root1.left.left.left = new TreeNode(8);
console.log(oddEvenLevelSumDifference(root1)); // 10

root1 = new TreeNode(1);
root1.left = new TreeNode(2);
root1.right = new TreeNode(10);
root1.left.right = new TreeNode(4);
console.log(oddEvenLevelSumDifference(root1)); // -7