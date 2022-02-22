// Definition for a  binary tree node
function TreeNode(data) {
    this.data = data
    this.left = null
    this.right = null
}

function createTree() {
    const input = "19 94 91 21 2 24 46 51 78 55 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1";
    const test = input.split(" ");
    const intInput = Number(test[i])
    console.log(test);
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

//param A : root node of tree
//param B : integer
//param K : integer
//return a array of integers
function solve(A, B, K) {

    // step-1: find the path of node B from root
    var path = [];
    var output = [];
    findPath(A, B, path);

    // now find the nodes at distance K from node B
    getNodes(path[0], K, output);

    // move up and find K-1 distance node
    K = K - 1;
    for (let i = 1; i < path.length; i++) {
        if (K == 0) {
            output.push(path[i].data);
            break;
        }
        if (path[i - 1] == path[i].left) {
            getNodes(path[i].right, K - 1, output);
        } else {
            getNodes(path[i].left, K - 1, output);
        }
        // again move up and find K-1 node
        K = K - 1;
    }
    return output;
}

const findPath = (root, B, path) => {
    if (root == null) {
        return false;
    }
    if (root.data === B) {
        path.push(root);
        return true;
    }
    if (findPath(root.left, B, path) || findPath(root.right, B, path)) {
        path.push(root);
        return true;
    }
}

const getNodes = (root, K, output) => {
    if (root == null) {
        return;
    }
    if (K == 0) {
        output.push(root.data);
        return;
    }
    getNodes(root.left, K - 1, output);
    getNodes(root.right, K - 1, output);
}

let A = createSampleTree();
solve(A, 46, 1);