/*******
 * Problem Description

Design and implement a Linked List data structure. A node in a linked list should have the following attributes - an integer value and a pointer to the next node. It should support the following operations:

insert_node(position, value) - To insert the input value at the given position in the linked list.
delete_node(position) - Delete the value at the given position from the linked list.
print_ll() - Print the entire linked list, such that each element is followed by a single space.

Note:
If an input position does not satisfy the constraint, no action is required.
Each print query has to be executed in new line.

Problem Constraints
1 <= position <= n where, n is the size of the linked-list.

Input Format
First line contains an integer denoting number of cases, let's say t.
Next t line denotes the cases.

Output Format
When there is a case of print_ll(),  Print the entire linked list, such that each element is followed by a single space.

NOTE: You don't need to return anything.

Example Input
5
i 1 23
i 2 24
p
d 1
p

Example Output
23 24
24

Example Explanation
After first two cases linked list contains two elements 23 and 24.
At third case print: 23 24.
At fourth case delete value at first position, only one element left 24.
At fifth case print: 24.
 */

// YOUR CODE GOES HERE
// Please take input and print output to standard input/output (stdin/stdout)
// DO NOT USE ARGUMENTS FOR INPUTS

class LLNode {
    constructor(value) {
        this.data = value;
        this.next = null;
    }
}

class LinkedList {
    constructor() {
        this.head = null;
        this.size = 0;
    }

    insert_node(pos, no) {
        let newNode = new LLNode(no);

        //  when pos is at start
        if (Number(pos) === 1) {
            // when head is null
            if (this.head === null) {
                this.head = newNode;
                this.size++;
            } else {
                newNode.next = this.head;
                this.head = newNode;
                this.size++;
            }
            return;
        }

        //  when pos is in between or last
        if (Number(pos) > 1 && Number(pos) <= (this.size + 1)) {
            let temp = this.head;
            let currentNodePos = 1;
            while ((Number(pos) - 1) > currentNodePos) {
                currentNodePos++;
                temp = temp.next;
            }
            newNode.next = temp.next;
            temp.next = newNode;
            this.size++;
        }
    }

    delete_node(pos) {

        if (Number(pos) >= 1 && Number(pos) <= (this.size)) {

            let temp = this.head;
            // pos = Number(pos);

            // if node to delete is head node
            if (Number(pos) === 1) {
                this.head = temp.next;
                temp.next = null;
                temp = null;
                this.size--;
                return;
            }

            // when node to delete is in between or last
            let currentNodePos = 1;
            while ((Number(pos) - 1) > currentNodePos) {
                currentNodePos++;
                temp = temp.next;
            }

            let nodeToDelete = temp.next;
            temp.next = nodeToDelete.next;
            nodeToDelete.next = null;
            nodeToDelete = null;
            this.size--;
        }

    }

    print_ll() {
        let nodeList = [];
        let temp = this.head;
        while (temp !== null) {
            nodeList.push(temp.data);
            temp = temp.next;
        }
        console.log(nodeList.join(' '));
    }
}