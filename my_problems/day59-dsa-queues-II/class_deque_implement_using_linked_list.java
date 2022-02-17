/* Implement Dequeue using Linked List */

/* Definition for singly-linked list. */
class ListNodeDLL {
    public int val;
    public ListNodeDLL next;
    public ListNodeDLL prev;

    ListNodeDLL(int x) {
        val = x;
        next = null;
        prev = null;
    }
}

class DequeueLL {
    ListNodeDLL head;
    ListNodeDLL tail;

    public DequeueLL() {
        this.head = null;
        this.tail = null;
    }

    public boolean isEmpty() {
        if (this.head == null && this.tail == null) {
            return true;
        }
        return false;
    }

    public void enqueue(int value) {
        ListNodeDLL temp = new ListNodeDLL(value);
        if (isEmpty()) {
            this.head = temp;
            this.tail = temp;
        } else {
            this.tail.next = temp;
            temp.prev = this.tail;
            this.tail = temp;
        }
    }

    // remove from front
    public int dequeue() {
        if (!isEmpty()) {
            ListNodeDLL temp = this.head;
            this.head = this.head.next;
            temp.next = null;
            if (this.head != null) {
                this.head.prev = null;
            } else {
                this.tail = null;
            }
            return temp.val;
        }
        return -1;
    }

    // peek front element
    public int front() {
        if (!isEmpty()) {
            return this.head.val;
        }
        return -1;
    }

    public int rear() {
        if (!isEmpty()) {
            return this.tail.val;
        }
        return -1;
    }

    // remove element from rear
    public int pop() {
        if (!isEmpty()) {
            ListNodeDLL temp = this.tail;
            this.tail = this.tail.prev;
            if (this.tail != null) {
                this.tail.next = null;
            } else {
                this.head = null;
            }
            temp.prev = null;
            return temp.val;
        }
        return -1;
    }

    public int size() {
        if (!isEmpty()) {
            ListNodeDLL temp = this.head;
            int count = 0;
            while (temp != null) {
                count++;
                temp = temp.next;
            }
            return count;
        }
        return 0;
    }

    public void print() {
        System.out.println();
        ListNodeDLL temp = this.head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
    }

}

public class class_deque_implement_using_linked_list {

    public static void main(String[] args) {

        DequeueLL dq = new DequeueLL();

        dq.enqueue(11);
        dq.enqueue(12);
        dq.enqueue(13);
        dq.enqueue(14);
        dq.enqueue(15);
        dq.enqueue(16);

        dq.print();

        System.out.println(dq.dequeue());
        System.out.println(dq.dequeue());
        System.out.println(dq.dequeue());
        System.out.println(dq.dequeue());

        dq.enqueue(101);
        dq.enqueue(102);
        dq.enqueue(103);

        dq.print();
        System.out.println(dq.size());

        System.out.println(dq.pop());
        System.out.println(dq.pop());
        System.out.println(dq.pop());
        System.out.println(dq.pop());
        System.out.println(dq.pop());
        System.out.println(dq.pop());

    }

}
