/* Delete middle node of a Linked List */

/***
 * Given a singly linked list, delete middle of the linked list.
 * 
 * For example, if given linked list is 1->2->3->4->5 then linked list should be
 * modified to 1->2->4->5
 * 
 * If there are even nodes, then there would be two middle nodes, we need to
 * delete the second middle element.
 * 
 * For example, if given linked list is 1->2->3->4->5->6 then it should be
 * modified to 1->2->3->5->6.
 * 
 * Return the head of the linked list after removing the middle node.
 * 
 * If the input linked list has 1 node, then this node should be deleted and a
 * null node should be returned.
 * 
 * Input Format
 * 
 * The only argument given is the node pointing to the head node of the linked
 * list
 */

public class q1_DeleteMiddleNodeOfALinkedList {

    // class ListNode {
    // public int val;
    // public ListNode next;

    // ListNode(int x) {
    // val = x;
    // next = null;
    // }
    // }

    public static ListNode deleteMiddleNode(ListNode head) {

        // base condition for head
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            head = head.next;
            return head;
        }

        // first find how many elements are present in ll
        int size = 0;
        ListNode temp = head;
        while (temp != null) {
            temp = temp.next;
            size++;
        }

        // calculate position of node to be deleted
        int deleteNodeAtPos;
        if (size % 2 == 0) {
            // even nodes
            deleteNodeAtPos = (size / 2) + 1;
        } else {
            // odd nodes
            deleteNodeAtPos = (size / 2) + 1;
        }

        // reach till previous position of node to be deleted
        temp = head;
        deleteNodeAtPos--;
        while (deleteNodeAtPos > 1) {
            temp = temp.next;
            deleteNodeAtPos--;
        }

        // delete temp.next as we have to delete next node
        temp.next = temp.next.next;

        // return head
        return head;
    }

    public static void main(String[] args) {

        // odd size
        ListNode head = LinkedListUtils.getTestData();
        LinkedListUtils.printLL(head);
        head = deleteMiddleNode(head);
        LinkedListUtils.printLL(head);

        // even size
        head = LinkedListUtils.getTestData();
        ListNode x = new ListNode(6);
        x.next = head;
        head = x;
        LinkedListUtils.printLL(head);
        head = deleteMiddleNode(head);
        LinkedListUtils.printLL(head);

    }

}
