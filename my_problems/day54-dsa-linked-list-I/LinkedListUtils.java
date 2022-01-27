public class LinkedListUtils {

    // 1->2->3->4->5
    public static void printLL(ListNode head) {

        if (head == null)
            return;
        ListNode temp = head;
        while (temp.next != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println(temp.val);

    }

    public static ListNode insertAtEnd(ListNode head, int val) {

        ListNode x = new ListNode(val);

        if (head == null) {
            head = x;
            return head;
        }

        // traverse till end
        ListNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        // temp points to the end of linked list
        temp.next = x;
        return head;

    }

    public static ListNode getTestData() {
        ListNode head = new ListNode(1);
        ListNode t1 = new ListNode(2);
        head.next = t1;
        ListNode t2 = new ListNode(3);
        t1.next = t2;
        ListNode t3 = new ListNode(4);
        t2.next = t3;
        ListNode t4 = new ListNode(5);
        t3.next = t4;
        return head;
    }

    public static ListNode getListWithLoop() {
        ListNode head = null;
        head = insertAtEnd(head, 1);
        head = insertAtEnd(head, 2);
        head = insertAtEnd(head, 3);
        head = insertAtEnd(head, 4);
        head = insertAtEnd(head, 5);
        head = insertAtEnd(head, 6);
        head = insertAtEnd(head, 7);
        head = insertAtEnd(head, 8);
        head = insertAtEnd(head, 9);
        head = insertAtEnd(head, 10);
        head = insertAtEnd(head, 11);

        // find node at position 5 considering 1-based indexing
        ListNode temp = head;
        int position = 8;
        while (position > 1) {
            temp = temp.next;
            position--;
        }

        // find the end node
        ListNode end = temp;
        while (end.next != null) {
            end = end.next;
        }

        // form the loop
        end.next = temp;

        return head;
    }

    public static ListNode getUnsortedList() {
        ListNode head = null;
        head = insertAtEnd(head, 3);
        head = insertAtEnd(head, 4);
        head = insertAtEnd(head, 2);
        head = insertAtEnd(head, 1);
        return head;
    }

    public static ListNode getRandomList(int size) {

        ListNode head = null;
        while (size > 0) {
            int value = (int) Math.floor(Math.random() * 100);
            head = insertAtEnd(head, value);
            size--;
        }
        return head;
    }

    public static ListNode getSortedList(int size) {
        ListNode head = getRandomList(size);
        head = hw_q1_SortList.sortList(head);
        return head;
    }

}
