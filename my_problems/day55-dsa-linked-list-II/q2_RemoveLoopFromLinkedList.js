/* Remove Loop from Linked List */

// Definition for singly-linked list.
function Node(data) {
    this.data = data
    this.next = null
}

//param A : head node of linked list
//return the head node in the linked list
const solve = function(head) {

    if (head == null) return head;

    let slow = head;
    let fast = head;
    let prev = new Node('dummy');
    while (fast != null && fast.next != null) {
        prev = slow;
        slow = slow.next;
        fast = fast.next.next;
        if (slow == fast) {
            break;
        }
    }

    // console.log('here', slow.data, fast.data);
    if (slow != fast) {
        // no cycle
        return head;
    }

    // cycle is present, find start of the loop/cycle
    let temp = head;
    while (temp != slow) {
        // pointer starting from head node
        temp = temp.next;
        // pointer starting from slow within loop
        prev = slow;
        slow = slow.next;
    }

    prev.next = null;
    return head;
}

let head = new Node(6);
let temp = head;

let x = new Node(5);
temp.next = x;
temp = temp.next;

x = new Node(5);
temp.next = x;
temp = temp.next;

x = new Node(3);
temp.next = x;
temp = temp.next;

x = new Node(8);
x.next = temp;
temp.next = x;
temp = temp.next;


solve(head);