/*  Add Two Numbers as Lists */

/**
 * Problem Description
 * 
 * You are given two linked lists, A and B representing two non-negative
 * numbers.
 * 
 * The digits are stored in reverse order and each of their nodes contain a
 * single digit.
 * 
 * Add the two numbers and return it as a linked list.
 * 
 * Problem Constraints
 * 1 <= |A|, |B| <= 10^5
 * 
 * Input Format
 * The first argument of input contains a pointer to the head of linked list A.
 * The second argument of input contains a pointer to the head of linked list B.
 * 
 * Output Format
 * Return a pointer to the head of the required linked list.
 * 
 * Example Input
 * Input 1:
 * A = [2, 4, 3]
 * B = [5, 6, 4]
 * 
 * Input 2:
 * A = [9, 9]
 * B = [1]
 * 
 * Example Output
 * Output 1:
 * [7, 0, 8]
 * Output 2:
 * [0, 0, 1]
 * 
 * Example Explanation
 * Explanation 1:
 * A = 342 and B = 465. A + B = 807.
 * Explanation 2:
 * A = 99 and B = 1. A + B = 100.
 */

/**
 * TC: O(N)
 * SC: O(1)
 */
public class hw_q2_AddTwoNumbersAsLists {

    public static ListNode addTwoNumbers(ListNode A, ListNode B) {

        // base conditions
        if (A == null) {
            return B;
        }
        if (B == null) {
            return A;
        }

        // create dummy head node to store the output
        ListNode head = new ListNode(-1);

        // initialize pointers
        ListNode ptr1 = A;
        ListNode ptr2 = B;
        ListNode ptr3 = head;
        int sum = 0;
        int carry = 0;

        // while both lists have elements at some position
        while (ptr1 != null && ptr2 != null) {
            sum = ptr1.val + ptr2.val + carry;
            int rem = sum % 10;
            carry = sum / 10;

            ListNode x = new ListNode(rem);
            ptr3.next = x;

            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
            ptr3 = ptr3.next;
        }

        // when list1 has more elements, iterate over remaining elements from list1
        while (ptr1 != null) {
            sum = ptr1.val + carry;
            int rem = sum % 10;
            carry = sum / 10;

            ListNode x = new ListNode(rem);
            ptr3.next = x;

            ptr1 = ptr1.next;
            ptr3 = ptr3.next;
        }

        // when list2 has more elements, iterate over remaining elements from list2
        while (ptr2 != null) {
            sum = ptr2.val + carry;
            int rem = sum % 10;
            carry = sum / 10;

            ListNode x = new ListNode(rem);
            ptr3.next = x;

            ptr2 = ptr2.next;
            ptr3 = ptr3.next;
        }

        // insert remaining carry if it is > 0
        if (carry > 0) {
            ListNode x = new ListNode(carry);
            ptr3.next = x;
        }

        // return head.next as head is dummy node
        return head.next;

    }

    public static void main(String[] args) {

        // test 1
        ListNode a = LinkedListUtils.getRandomLessThan10List(3);
        ListNode b = LinkedListUtils.getRandomLessThan10List(1);
        ListNode c = addTwoNumbers(a, b);
        LinkedListUtils.printLL(a);
        LinkedListUtils.printLL(b);
        LinkedListUtils.printLL(c);

        // test 1
        a = LinkedListUtils.getRandomLessThan10List(3);
        b = LinkedListUtils.getRandomLessThan10List(4);
        c = addTwoNumbers(a, b);
        LinkedListUtils.printLL(a);
        LinkedListUtils.printLL(b);
        LinkedListUtils.printLL(c);
    }
}
