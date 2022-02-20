import java.util.ArrayList;

/* Floor and Ceil in BST */

/* Problem Description

Given a Binary Search Tree rooted at A.

Given an integer array B of size N. Find the floor and ceil of every element of the array B.

Floor(X) is the highest element in the tree <= X, while the ceil(X) is the lowest element in the tree >= X.

NOTE: If floor or ceil of any element of B doesn't exists, output -1 for the value which doesn't exists.

Problem Constraints

0 <= Number of nodes in the tree <= 1000000
0 <= node values <= 10^9
0 <= N <= 100000
0 <= B[i] <= 10^9

Input Format

First argument represents the root of binary tree A.
Second argument is an integer array B.

Output Format
Return an integer array C of size N*2. C[i][0] denotes the floor value of B[i] and C[i][1] represents the ceil value of B[i] in the given tree.


Example Input
Input 1:
Given Tree A:
           10
         /    \
        4      15
       / \
      1   8
B = [4, 19]

Input 2:
Given Tree A:
            8
          /   \
         5     19
        / \     \
       4   7     100
B = [1, 11]       

Example Output
Output 1:
[
    [4, 4]
    [15, -1]
]
Output 2:
[
    [-1, 4]
    [8, 19]
]

Example Explanation

Explanation 1:
Take all elements of given tree in sorted form: [1, 4, 8, 10, 15].
4 is present in the tree. So, for B[0] = 4, output is [4, 4] as both floor and ceil value is 4.

For B[1] = 19,
Highest element <= 19 is 15. So the floor value of 19 is 15. 
19 is greater than all elements in the tree. So, the ceil value of 19 doesn't exists.
So, output is [15, -1].

Explanation 2:
All elements of tree in sorted form: [4, 5, 7, 8, 19, 100].

For B[0] = 1, 
There is no element in the tree <= 1. So, the floor value doesn't exists.
Lowest element >= 1 is 4. So, the ceil value is 4.
So, output is [-1, 4]

Similarly for B[1] = 11, output is [8, 19]. */

public class q3_FloorAndCeilInBST {

    public static int floor(TreeNode root, int K) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }
        if (root.val == K) {
            return root.val;
        }
        if (root.val > K) {
            return floor(root.left, K);
        }
        return Math.max(root.val, floor(root.right, K));
    }

    public static int ceil(TreeNode root, int K) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }
        if (root.val == K) {
            return root.val;
        }
        if (root.val < K) {
            return ceil(root.right, K);
        }
        return Math.min(root.val, ceil(root.left, K));
    }

    public static ArrayList<ArrayList<Integer>> solve(TreeNode root, ArrayList<Integer> B) {

        ArrayList<ArrayList<Integer>> output = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < B.size(); i++) {
            ArrayList<Integer> temp = new ArrayList<Integer>();
            int currentEle = B.get(i);
            int floorValue = floor(root, currentEle);
            int ceilValue = ceil(root, currentEle);
            temp.add(floorValue == Integer.MIN_VALUE ? -1 : floorValue);
            temp.add(ceilValue == Integer.MAX_VALUE ? -1 : ceilValue);
            output.add(temp);
        }
        return output;
    }

    public static void main(String[] args) {

        // test cas 1
        // @formatter:off
        /* Given Tree A:
                    10
                  /   \
                 4     15
               /   \ 
              1     8 
        */
        // @formatter:on
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(4);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(8);
        ArrayList<Integer> B = new ArrayList<Integer>();
        B.add(4);
        B.add(19);

        ArrayList<ArrayList<Integer>> output = solve(root, B);
        for (int i = 0; i < output.size(); i++) {
            ArrayList<Integer> curr = output.get(i);
            System.out.println();
            for (int j = 0; j < curr.size(); j++) {
                System.out.print(" " + curr.get(j));
            }
        }

        // test cas 2
        // @formatter:off
        /* Given Tree A:
                    8
                  /   \
                 5     19
               /   \     \
              4     7     100
        */
        // @formatter:on
        root = new TreeNode(8);
        root.left = new TreeNode(5);
        root.right = new TreeNode(19);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(7);
        root.right.right = new TreeNode(100);
        B = new ArrayList<Integer>();
        B.add(1);
        B.add(11);

        output = solve(root, B);
        for (int i = 0; i < output.size(); i++) {
            ArrayList<Integer> curr = output.get(i);
            System.out.println();
            for (int j = 0; j < curr.size(); j++) {
                System.out.print(" " + curr.get(j));
            }
        }

    }

}
