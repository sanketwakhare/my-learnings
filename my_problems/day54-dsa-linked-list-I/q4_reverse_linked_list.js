/* Reverse Linked List */


// Definition for singly-linked list.
//    function Node(data){
//      this.data = data
//      this.next = null
//    }

module.exports = {
    //param A : head node of linked list
    //return the head node in the linked list
    reverseList: function(A) {

        let head = A;
        if (head == null || head.next == null) return head;

        // if length is  > 1
        let prev = null;
        let curr = head;
        let next = curr;

        while (next != null) {
            next = next.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;

    }
};