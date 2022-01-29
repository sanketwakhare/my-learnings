/* Palindrome List */

/****
 * Problem Description
 * 
 * Given a singly linked list A, determine if its a palindrome. Return 1 or 0
 * denoting if its a palindrome or not, respectively.
 * 
 * Problem Constraints
 * 1 <= |A| <= 10^5
 * 
 * Input Format
 * The first and the only argument of input contains a pointer to the head of
 * the given linked list.
 * 
 * Output Format
 * Return 0, if the linked list is not a palindrome.
 * Return 1, if the linked list is a palindrome.
 * 
 * Example Input
 * Input 1:
 * A = [1, 2, 2, 1]
 * Input 2:
 * A = [1, 3, 2]
 * 
 * Example Output
 * Output 1:
 * 1
 * Output 2:
 * 0
 * 
 * Example Explanation
 * Explanation 1:
 * The first linked list is a palindrome as [1, 2, 2, 1] is equal to its
 * reversed form.
 * Explanation 2:
 * The second linked list is not a palindrome as [1, 3, 2] is not equal to [2,
 * 3,
 * 1].
 */

/**
 * TC: O(N)
 * SC: O(N)
 */
public class hw_q1_PalindromeList {

    /* Reverse Palindrome */
    public static ListNode reverse(ListNode head) {

        ListNode prev = null;
        ListNode curr = head;
        ListNode nxt = null;

        while (curr != null) {
            nxt = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nxt;
        }
        return prev;
    }

    /* Copy Linked List */
    public static ListNode copy(ListNode head) {

        if (head == null) {
            return null;
        }

        ListNode newHead = new ListNode(head.val);
        ListNode curr2 = newHead;

        ListNode curr = head.next;

        while (curr != null) {
            ListNode x = new ListNode(curr.val);
            curr2.next = x;

            curr = curr.next;
            curr2 = curr2.next;
        }
        return newHead;

    }

    /* isPalindrome List */
    public static int isPalindromeList(ListNode head) {

        if (head == null || head.next == null) {
            System.out.println("list is not a palindrome list");
            return 0;
        }

        ListNode head2 = copy(head);
        head2 = reverse(head2);

        ListNode curr = head;
        ListNode curr2 = head2;
        while (curr != null && curr2 != null) {

            if (curr.val != curr2.val) {
                System.out.println("list is not a palindrome list");
                return 0;
            }
            curr = curr.next;
            curr2 = curr2.next;
        }

        System.out.println("list is a palindrome list");
        return 1;
    }

    public static void main(String[] args) {

        // test 1
        ListNode list1 = LinkedListUtils.getRandomList(10);
        isPalindromeList(list1);

        // test 2
        ListNode list2 = LinkedListUtils.getPalindromeList();
        isPalindromeList(list2);
    }

}
