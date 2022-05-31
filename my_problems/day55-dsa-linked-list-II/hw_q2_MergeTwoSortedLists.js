/* Merge Two Sorted Lists */

// Definition for singly-linked list.
//    function Node(data){
//      this.data = data
//      this.next = null
//    }

module.exports = {
    //param A : head node of linked list
    //param B : head node of linked list
    //return the head node in the linked list
    mergeTwoLists: function(h1, h2) {

        let result = new Node('dummy');
        let curr = result;
        while (h1 != null && h2 != null) {
            if (h1.data < h2.data) {
                curr.next = h1;
                h1 = h1.next;
                curr = curr.next;
            } else {
                curr.next = h2;
                h2 = h2.next;
                curr = curr.next;
            }
        }
        if (h1 != null) {
            curr.next = h1;
        }
        if (h2 != null) {
            curr.next = h2;
        }

        return result.next;
    }
};