/* Stack implementation using Linked List */

/**
 * ListNode class for Linked List node
 */
class SLLNode {
    int data;
    SLLNode next;

    SLLNode(int data) {
        this.data = data;
    }
}

class MyStackLL {

    int size;
    SLLNode head;

    MyStackLL() {
        this.size = 0;
        this.head = null;
    }

    public boolean isEmpty() {
        if (this.head == null) {
            return true;
        }
        return false;
    }

    public void push(int x) {
        // create node
        SLLNode temp = new SLLNode(x);
        if (this.head == null) {
            this.head = temp;
        } else {
            // insert at head
            temp.next = head;
            this.head = temp;
        }
        size++;
    }

    public int pop() {
        if (!isEmpty()) {
            // delete element at head and move head

            SLLNode temp = head;
            // update head
            this.head = this.head.next;

            // delete top node and return data
            this.size--;
            temp.next = null;
            return temp.data;

        }
        return -1;
    }

    public int top() {
        if (!isEmpty()) {
            return this.head.data;
        }
        return -1;
    }

    public void print() {
        SLLNode temp = head;
        while (temp != null) {
            if (temp.next != null) {
                System.out.print(temp.data + " -> ");
            } else {
                System.out.print(temp.data);
            }
            temp = temp.next;
        }
        System.out.println();
    }

    public int size() {
        return this.size;
    }

}

public class class_StackImpl_LinkedList {
    public static void main(String[] args) {

        MyStackLL stack = new MyStackLL();

        System.out.println("isEmpty() = " + stack.isEmpty());
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.print();

        System.out.println("popped element = " + stack.pop());
        System.out.println("top = " + stack.top());

        stack.push(2);
        System.out.println("top = " + stack.top());

        System.out.println("size = " + stack.size());
        stack.print();

        System.out.println("popped element = " + stack.pop());
        System.out.println("popped element = " + stack.pop());
        System.out.println("popped element = " + stack.pop());
        stack.print();

        stack.pop();
        System.out.println(stack.isEmpty());
        System.out.println("size = " + stack.size());
        stack.print();
    }
}
