/* Flatten a linked list */

// Definition for the linked list.
//			function Node(data){
//				this.data = data
//				this.right = null
//              this.down = null
//			}
function flatten(root) {

    // base condition
    if (root == null) return root;

    // sort 2 lists at a time
    let l1 = root;
    let l2 = null;

    let temp = root;
    while (temp != null) {
        l2 = temp.right;
        l1 = mergeTwoSortedLists(l1, l2);
        temp = temp.right;
    }
    return l1;
}

function mergeTwoSortedLists(h1, h2) {

    let result = new Node('dummy');
    let temp = result;
    while (h1 != null && h2 != null) {
        if (h1.data < h2.data) {
            temp.down = h1;
            h1 = h1.down;
        } else {
            temp.down = h2;
            h2 = h2.down;
        }
        temp = temp.down;
    }

    if (h1 != null) {
        temp.down = h1;
    }
    if (h2 != null) {
        temp.down = h2;
    }
    return result.down;
}