/* Linked-List Implementation */

// YOUR CODE GOES HERE
// Please take input and print output to standard input/output (stdin/stdout)
// DO NOT USE ARGUMENTS FOR INPUTS

class ListNode {
    constructor(value) {
        this.val = value;
        this.next = null;
    }
}

class LinkedList {
    constructor() {
        this.head = new ListNode('dummy');
        this.size = 1;
    }

    insert_node(pos, no) {
        // edge cases
        if (this.size < pos || pos < 1) {
            return;
        }
        // create new node
        let x = new ListNode(no);
        // traverse till previous node
        let temp = this.head;
        while (temp.next != null && pos > 1) {
            pos--;
            temp = temp.next;
        }
        // append node in between
        x.next = temp.next;
        temp.next = x;
        this.size++;
    }

    delete_node(pos) {
        if (this.size <= pos || pos < 1) {
            return;
        }
        let temp = this.head;
        while (temp.next != null && pos > 1) {
            pos--;
            temp = temp.next;
        }
        // delete next element from ll
        let x = temp.next;
        temp.next = x.next;
        x.next = null;
        this.size--;
    }

    print_ll() {
        let sb = new String();
        let temp = this.head.next;
        while (temp != null) {
            sb += (temp.val + " ");
            temp = temp.next;
        }
        sb = sb.trimEnd();
        console.log(sb.toString());
    }
}