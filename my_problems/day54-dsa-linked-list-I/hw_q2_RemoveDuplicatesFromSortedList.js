/* Remove Duplicates from Sorted List */

// Definition for singly-linked list.
//    function Node(data){
//      this.data = data
//      this.next = null
//    }

module.exports = {
    //param A : head node of linked list
    //return the head node in the linked list
    deleteDuplicates: function(A) {

        if (A === null || A.next === null) return A;

        let first = A;
        let second = A.next;
        while (second !== null) {
            if (first.data === second.data) {
                // if adjacent node values are same, eliminate one of the node from list
                second = second.next;
                first.next = second;
            } else {
                // if adjacent node values are different, move to next
                first = first.next;
                second = first.next;
            }
        }
        return A;
    }
};