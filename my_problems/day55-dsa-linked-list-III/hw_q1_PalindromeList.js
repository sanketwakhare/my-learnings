/* Palindrome List */

// Definition for singly-linked list.
//    function Node(data){
//      this.data = data
//      this.next = null
//    }

module.exports = {
    //param head : head node of linked list
    //return an integer
    lPalin: function(head) {
        if (head == null || head.next == null) return 1;

        // find middle node
        let mid = findMid(head);
        let h2 = mid.next;
        mid.next = null;

        // reverse one of the list
        h2 = reverse(h2);

        while (head != null && h2 != null) {
            if (head.data !== h2.data) {
                return 0;
            }
            head = head.next;
            h2 = h2.next;
        }
        return 1;
    }
};

const findMid = (head) => {
    let slow = head;
    let fast = head;
    let prev = new Node('dummy');
    prev.next = head;

    while (fast != null && fast.next != null) {
        prev = slow;
        slow = slow.next;
        fast = fast.next.next;
    }
    return prev;
}

const reverse = (head) => {

    let prev = null;
    let curr = head;
    let next = curr;

    while (curr != null) {
        next = next.next;
        curr.next = prev;
        prev = curr;
        curr = next;
    }
    return prev;
}