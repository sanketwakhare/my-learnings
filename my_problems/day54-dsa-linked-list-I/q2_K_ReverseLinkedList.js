/* K reverse linked list */


// Definition for singly-linked list.
//    function Node(data){
//      this.data = data
//      this.next = null
//    }

module.exports = {
    //param A : head node of linked list
    //param B : integer
    //return the head node in the linked list
    reverseList: function(A, B) {
        // base conditions
        let head = A;
        if (head == null || head.next == null) return head;

        // use dummy node at front
        let dummy = new Node('dummy');
        dummy.next = head;

        // initialize previous and temp node
        let prev = dummy;
        let temp = head;
        // maintain count
        let count = 0;
        while (temp != null) {
            // reverse at each B interval
            if ((count % B) == 0) {
                // link the previous list with new head
                prev.next = reverse(temp, B);
            }
            // move to next nodes
            prev = prev.next;
            temp = prev.next;
            count++;
        }
        return dummy.next;
    }
};

/* Reverse first K nodes of list starting with given head */
const reverse = (head, K) => {

    // base conditions
    if (head == null || head.next == null || K == 1) return head;

    // save original Head pointer, this will be used to link next nodes in list
    let originalHead = head;

    // reverse linked list logic
    let prev = null;
    let curr = head;
    let next = curr;
    while (curr != null && K > 0) {
        next = next.next;
        curr.next = prev;
        prev = curr;
        curr = next;
        K--;
    }
    // link the current sub list with next nodes in list
    originalHead.next = curr;
    return prev;
}