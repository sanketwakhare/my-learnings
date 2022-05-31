/* Middle element of linked list */


// Definition for singly-linked list.
//    function Node(data){
//      this.data = data
//      this.next = null
//    }
module.exports = {
    //param A : head node of linked list
    //return an integer
    solve: function(A) {

        // if only single element is present in linked list
        if (A.next == null) return A.data;

        // using single pass. N/2 iterations
        let slow = A;
        let fast = A;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow.data;
    }
};