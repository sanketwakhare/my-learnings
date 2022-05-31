/* Reorder List */

// Definition for singly-linked list.
//    function Node(data){
//      this.data = data
//      this.next = null
//    }

module.exports = {
    //param A : head node of linked list
    //return the head node in the linked list
    reorderList: function(A) {
        if (A == null || A.next == null) return A;

        // step 1 - find Mid element
        let mid = findMid(A);

        // step 2 - make 2 lists out of 1 and break links
        let h2 = mid.next;
        mid.next = null;

        // step 3 - reverse h2
        h2 = reverse(h2);

        // step 4 - merge 2 lists head and h2
        let result = merge(A, h2);
        return result;
    }
};

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

const findMid = (head) => {
    // find mid
    let slow = head;
    let fast = head;
    while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;
    }
    return slow;
}

const merge = (h1, h2) => {

    let dummy = new Node(Number.MIN_VALUE);
    let result = dummy;
    while (h1 != null && h2 != null) {
        result.next = h1;
        result = result.next;
        h1 = h1.next;

        result.next = h2;
        result = result.next;
        h2 = h2.next;
    }
    if (h1 != null) {
        result.next = h1;
    }
    if (h2 != null) {
        result.next = h2;
    }

    return dummy.next;
}