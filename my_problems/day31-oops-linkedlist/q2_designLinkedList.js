// Definition for singly-linked list.
class Node {
    constructor(data) {
        this.data = data;
        this.next = null;
    }
}

//param A : array of array of integers
//return the head node in the linked list
const designLinkedListMain = (A) => {
    // console.log(A);
    let noOfTestCases = A.length;

    let head = null;
    let size = 0;

    let i = 0;
    while (noOfTestCases > 0) {

        // read input test case array
        const testCase = A[i++];
        const testType = Number(testCase[0]);
        const x = Number(testCase[1]);
        const pos = Number(testCase[2]);

        if (testType === 0) {
            // add element x to start
            let newNode = new Node(x);
            if (head === null) {
                head = newNode;
                size++;
            } else {
                newNode.next = head;
                head = newNode;
                size++;
            }
        }

        else if (testType === 1) {
            // add element x to last
            let newNode = new Node(x);
            if (head === null) {
                // if head is null
                head = newNode;
                size++;
                noOfTestCases--;
                continue;
            } else {
                // if there are already elements in list
                let temp = head;
                while (temp.next != null) {
                    temp = temp.next;
                }
                temp.next = newNode;
                size++;
            }
        }

        else if (testType === 2) {
            // add element x to index pos. 0-based index
            if (pos > size) {
                noOfTestCases--;
                continue;
            }
            else if (pos === size) {
                // insert at last
                let newNode = new Node(x);
                if (head === null) {
                    // if head is null
                    head = newNode;
                    size++;
                    noOfTestCases--;
                    continue;
                } else {
                    // add element to last
                    let temp = head;
                    while (temp.next !== null) {
                        temp = temp.next;
                    }
                    temp.next = newNode;
                    size++;
                }
            } else {
                // insert in between at index pos
                let newNode = new Node(x);
                if (pos === 0) {
                    // if index is 0, add element to head
                    newNode.next = head;
                    head = newNode;
                    size++;

                }
                else {
                    // traverse till position-1 and insert new element at position pos
                    let currentPos = 0;
                    let temp = head;
                    while ((currentPos + 1) < pos) {
                        temp = temp.next;
                        currentPos++;
                    }
                    newNode.next = temp.next;
                    temp.next = newNode;
                    size++;
                }
            }
        }

        else if (testType === 3) {
            // delete element at index x from linked list
            if (x > size) {
                noOfTestCases--;
                continue;
            }
            if (x === 0) {
                // delete head
                let temp = head;
                head = temp.next;
                temp.next = null;
                temp = null;
                size--;

            } else if (x <= size - 1) {
                // delete last element OR
                // delete element at index x, x is position here
                // traverse till position-1 and insert new element at position pos
                let currentPos = 0;
                let temp = head;
                while ((currentPos + 1) < x) {
                    temp = temp.next;
                    currentPos++;
                }
                let nodeToDelete = temp.next;
                temp.next = nodeToDelete.next;
                nodeToDelete.next = null;
                nodeToDelete = null;
                size--;
            }
        }
        noOfTestCases--;
    }
    console.log(head);
    return head;
}

designLinkedListMain([
    [2, 18, 0],
    [2, 5, 1],
    [2, 8, 0],
    [1, 7, -1],
    [1, 5, -1]
]);

designLinkedListMain([
    [1, 13, -1],
    [3, 0, -1],
    [3, 1, -1],
    [2, 15, 0],
    [3, 0, -1],
    [1, 12, -1],
    [3, 0, -1],
    [1, 19, -1],
    [1, 13, -1],
    [3, 0, -1],
    [0, 12, -1],
    [1, 13, -1],
    [3, 2, -1]
]);

designLinkedListMain([
    [3, 1, -1],
    [1, 13, -1],
    [3, 0, -1],
    [2, 18, 0],
    [0, 8, -1],
    [3, 0, -1],
    [0, 4, -1],
    [2, 11, 1],
    [3, 1, -1],
    [1, 10, -1]
]);

designLinkedListMain([
    [2, 6, 0],
    [1, 17, -1],
    [1, 19, -1],
    [2, 16, 1],
    [1, 13, -1],
    [3, 3, -1],
    [1, 19, -1]
]);