/* Distance between Nodes of BST */

// Definition for a  binary tree node
function TreeNode(data) {
    this.data = data
    this.left = null
    this.right = null
}

const solve = function (A, B, C) {
    let path1 = [];
    findPath(A, B, path1);
    let path2 = [];
    findPath(A, C, path2);
    // console.log(path1);
    // console.log(path2);

    let p1 = path1.length - 1;
    let p2 = path2.length - 1;
    while (p1 >= 0 && p2 >= 0 && path1[p1] === path2[p2]) {
        p1--;
        p2--;
    }
    console.log(p1 + p2 + 2);
    return p1 + p2 + 2;
}

const findPath = (root, target, path) => {
    if (root == null) return;
    if (root.data === target) {
        path.push(root.data);
        return true;
    }
    let isLeftPartOfPath = findPath(root.left, target, path);
    if (isLeftPartOfPath) {
        path.push(root.data);
        return true;
    }
    let isRightPartOfPath = findPath(root.right, target, path);
    if (isRightPartOfPath) {
        path.push(root.data);
        return true;
    }
    return false;
}

let root = new TreeNode(5);
root.left = new TreeNode(2);
root.right = new TreeNode(8);
root.left.left = new TreeNode(1);
root.left.right = new TreeNode(4);
root.right.left = new TreeNode(6);
root.right.right = new TreeNode(11);

solve(root, 2, 11); // 3
solve(root, 2, 5); // 1
solve(root, 6, 4); // 4