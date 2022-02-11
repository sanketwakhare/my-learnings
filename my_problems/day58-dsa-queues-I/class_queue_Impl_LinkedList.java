/**
 * Implement Queue using LinkedList.
 */

/* Definition for singly-linked list. */
/*
 * public class ListNode {
 * public int val;
 * public ListNode next;
 * 
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */

class QueueLL {

    ListNode head;
    ListNode tail;

    QueueLL() {
        head = null;
        tail = null;
    }

    public boolean isEmpty() {
        if (head == null) {
            return true;
        }
        return false;
    }

    public void enqueue(Integer x) {

        ListNode temp = new ListNode(x);
        if (isEmpty()) {
            head = temp;
            tail = temp;
        } else {
            tail.next = temp;
            tail = temp;
        }
        System.out.println("enqueued - " + x);
    }

    public Integer dequeue() {
        if (!isEmpty()) {
            ListNode temp = head;
            head = head.next;
            temp.next = null;
            System.out.println("dequeued - " + temp.val);
            return temp.val;
        }
        return null;
    }

}

public class class_queue_Impl_LinkedList {

    public static void main(String[] args) {

        QueueLL q = new QueueLL();
        q.enqueue(11);
        q.enqueue(12);
        q.enqueue(13);
        q.enqueue(14);
        q.enqueue(15);

        q.dequeue();
        q.dequeue();
        q.dequeue();

        q.enqueue(81);
        q.enqueue(82);

        q.dequeue();
        q.dequeue();

        q.enqueue(101);

        while (!q.isEmpty()) {
            q.dequeue();
        }
    }

}
