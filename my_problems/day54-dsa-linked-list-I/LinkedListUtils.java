public class LinkedListUtils {

    // 1->2->3->4->5
    public static void printLL(ListNode head) {

        ListNode temp = head;
        while (temp.next != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println(temp.val);

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

}
