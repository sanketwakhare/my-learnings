// Definition for singly-linked list.
//    function Node(data){
//      this.data = data
//      this.next = null
//    }

module.exports = {
    //param A : head node of linked list
    //param B : integer
    //param C : integer
    //return the head node in the linked list
    reverseBetween: function(A, B, C) {

        // base conditions
        let head = A;
        if (head == null || head.next == null) return head;

        // traverse B times
        let temp = head;
        let prev = null;
        for (let i = 1; i < B; i++) {
            prev = temp;
            temp = temp.next;
        }

        // append the prev to new head
        if (prev == null) {
            // if B is start of the linked list
            head = reverse(temp, C - B + 1);
            return head;
        }
        // if B is any node in between
        prev.next = reverse(temp, C - B + 1);
        return head;
    }
};

/* Reverse Linked List k nodes only starting from given node */
function reverse(head, k) {
    // reverse k elements from list
    let prev = null;
    let curr = head;
    let next = head;

    while (next != null && k > 0) {
        next = next.next;
        curr.next = prev;
        prev = curr;
        curr = next;
        k--;
    }

    // assign new tails's next to (k+1)th node
    head.next = curr;

    // return new head
    return prev;
}