import java.util.HashMap;

/* Common Nodes in Two BST */

/* Problem Description

Given two BST's A and B, return the (sum of all common nodes in both A and B) % (109 +7) .

In case there is no common node, return 0.

NOTE:
Try to do it one pass through the trees.

Problem Constraints
1 <= Number of nodes in the tree A and B <= 10^5
1 <= Node values <= 10^6

Input Format
First argument represents the root of BST A.
Second argument represents the root of BST B.

Output Format
Return an integer denoting the (sum of all common nodes in both BST's A and B) % (109 +7) .

Example Input
Input 1:
 Tree A:
    5
   / \
  2   8
   \   \
    3   15
        /
        9

 Tree B:
    7
   / \
  1  10
   \   \
    2  15
       /
      11

Input 2:
  Tree A:
    7
   / \
  1   10
   \   \
    2   15
        /
       11

 Tree B:
    7
   / \
  1  10
   \   \
    2  15
       /
      11


Example Output
Output 1:
 17
Output 2:
 46

Example Explanation
Explanation 1:
 Common Nodes are : 2, 15
 So answer is 2 + 15 = 17
Explanation 2:
 Common Nodes are : 7, 2, 1, 10, 15, 11
 So answer is 7 + 2 + 1 + 10 + 15 + 11 = 46 */

public class hw_q2_Common_Nodes_In_Two_BST {

    public static void buildMap(TreeNode root, HashMap<Integer, Integer> map) {

        if (root == null) {
            return;
        }
        if (map.containsKey(root.val)) {
            int currentFreq = map.get(root.val);
            map.put(root.val, currentFreq + 1);
        } else {
            map.put(root.val, 1);
        }
        buildMap(root.left, map);
        buildMap(root.right, map);
    }

    public static long findCommonAndGetSum(TreeNode root, HashMap<Integer, Integer> map) {
        if (root == null) {
            return 0;
        }
        long sum = 0;
        if (map.containsKey(root.val)) {
            int currentFreq = map.get(root.val);
            if (currentFreq == 1) {
                // remove key from map
                map.remove(root.val);
            } else {
                // decrease frequency
                map.put(root.val, currentFreq - 1);
            }
            sum = root.val;
        }
        long m = 1000000007;
        long leftSum = findCommonAndGetSum(root.left, map) % m;
        long rightSum = findCommonAndGetSum(root.right, map) % m;
        long temp = (leftSum + rightSum) % m;
        return (temp + (sum % m)) % m;
    }

    public static int solve(TreeNode A, TreeNode B) {

        // Idea: traverse each node and store frequency in hashMap
        // find common elements if element is present in hashMap and return sum
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();

        buildMap(A, hashMap);
        return (int) findCommonAndGetSum(B, hashMap);
    }

    public static void main(String[] args) {

        // test case 1
        // @formatter:off
        /* Tree A = 
         *     5
         *    /  \
         *   2    8
         *    \     \
         *     3     15
         *          /
         *         9    
         */
        /* Tree B = 
         *     7
         *    /  \
         *   1    10
         *    \     \
         *     2     15
         *          /
         *         11    
         */
        // @formatter:on
        TreeNode A = new TreeNode(5);
        A.left = new TreeNode(2);
        A.right = new TreeNode(8);
        A.left.right = new TreeNode(3);
        A.right.right = new TreeNode(15);
        A.right.right.left = new TreeNode(9);

        TreeNode B = new TreeNode(7);
        B.left = new TreeNode(1);
        B.right = new TreeNode(10);
        B.left.right = new TreeNode(2);
        B.right.right = new TreeNode(15);
        B.right.right.left = new TreeNode(11);

        int sum = solve(A, B);
        System.out.println(sum); // expected result 17

        // test case 2
        // @formatter:off
        /* Tree A = 
         *     7
         *    /  \
         *   1    10
         *    \     \
         *     2     15
         *          /
         *         11    
         */
        /* Tree B = 
         *     7
         *    /  \
         *   1    10
         *    \     \
         *     2     15
         *          /
         *         11    
         */
        // @formatter:on
        A = new TreeNode(7);
        A.left = new TreeNode(1);
        A.right = new TreeNode(10);
        A.left.right = new TreeNode(2);
        A.right.right = new TreeNode(15);
        A.right.right.left = new TreeNode(11);

        B = new TreeNode(7);
        B.left = new TreeNode(1);
        B.right = new TreeNode(10);
        B.left.right = new TreeNode(2);
        B.right.right = new TreeNode(15);
        B.right.right.left = new TreeNode(11);

        sum = solve(A, B);
        System.out.println(sum); // expected result 46

    }

}
