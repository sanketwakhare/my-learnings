/* Remove Nth Node from List End */

// Definition for singly-linked list.
//    function Node(data){
//      this.data = data
//      this.next = null
//    }

module.exports = {
    //param A : head node of linked list
    //param B : integer
    //return the head node in the linked list
    removeNthFromEnd: function(A, B) {

        // perform B iterations
        let temp = A;
        while (temp.next != null && B >= 1) {
            B--;
            temp = temp.next;
        }

        // remove first node if B >= size
        if (temp.next == null) {
            A = A.next;
            return A;
        }

        // now take 2 pointes and increment each by 1.
        // when temp reached till end, the slow will reach to (N-B-1)th node
        // and we can delete (N-B)th node
        let slow = A;
        while (temp.next != null) {
            temp = temp.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return A;

    }
};