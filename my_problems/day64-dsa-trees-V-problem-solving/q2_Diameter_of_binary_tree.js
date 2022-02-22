/* Diameter of binary tree */

//param A : root node of tree
//return an integer
const getDiameter = (A) => {
    // reset for every test case
    diameter = 0;
    height(A, diameter);
    console.log(diameter);
    return diameter;
}

var diameter = 0;
const height = (root) => {

    if (root == null) {
        return -1;
    }
    let l = height(root.left, diameter);
    let r = height(root.right, diameter);

    diameter = Math.max(diameter, l + r + 2);
    // console.log(diameter);

    return Math.max(l, r) + 1;
}

getDiameter(new TreeNode(10));
getDiameter(createSampleTree());

// Definition for a  binary tree node
function TreeNode(data) {
    this.data = data
    this.left = null
    this.right = null
}

function createSampleTree() {
    let root = new TreeNode(94);

    root.left = new TreeNode(91);
    root.right = new TreeNode(21);

    root.left.left = new TreeNode(2);
    root.left.right = new TreeNode(24);
    root.right.left = new TreeNode(46);
    root.right.right = new TreeNode(51);

    root.left.left.left = new TreeNode(78);
    root.left.left.right = new TreeNode(55);
    return root;
}