// Definition for singly-linked list.
function Node(data) {
    this.data = data
    this.next = null
}

const sortList = (head) => {
    // base condition
    if (head == null || head.next == null) return head;

    // find mid
    let mid = findMid(head);

    // split into 2 lists
    let h2 = mid.next;
    mid.next = null;
    console.log('head', head);
    console.log('mid', mid);

    // merge/combine lists 
    head = sortList(head);
    h2 = sortList(h2);

    // merge 2 lists
    return mergeTwoLists(head, h2);

}

const findMid = (head) => {
    if (head == null || head.next == null) return head;

    let slow = head;
    let fast = head;
    let prev = slow;
    while (fast != null && fast.next != null) {
        prev = slow;
        slow = slow.next;
        fast = fast.next.next;

    }
    return prev;
}

const mergeTwoLists = (h1, h2) => {

    let result = new Node('dummy');
    let curr = result;
    while (h1 != null && h2 != null) {
        if (h1.data < h2.data) {
            curr.next = h1;
            h1 = h1.next;
            curr = curr.next;
        } else {
            curr.next = h2;
            h2 = h2.next;
            curr = curr.next;
        }
    }
    if (h1 != null) {
        curr.next = h1;
    }
    if (h2 != null) {
        curr.next = h2;
    }

    return result.next;
}

let head = new Node(6);
let temp = head;

let x = new Node(4);
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
temp = temp.next;


sortList(head);