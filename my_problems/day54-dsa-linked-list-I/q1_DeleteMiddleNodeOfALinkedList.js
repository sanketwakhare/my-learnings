/* Delete middle node of a Linked List */

// Definition for singly-linked list.
//    function Node(data){
//      this.data = data
//      this.next = null
//    }

module.exports = {
    //param A : head node of linked list
    //return the head node in the linked list
    solve: function(A) {

        // base conditions
        if (A == null || A.next == null) return null;

        // slow and fast pointers to find mid node
        let slow = A;
        let fast = A;
        // previous pointer to delte node at slow position
        let prev = null;

        // traverse till mid
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        // if first/head node itself is mid
        if (prev == null) return A.next;

        // middle node to be deleted
        prev.next = slow.next;
        slow.next = null;

        return A;
    }
};