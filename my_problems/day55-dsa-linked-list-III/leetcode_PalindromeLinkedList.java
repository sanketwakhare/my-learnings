public class leetcode_PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {

        // base case
        if (head.next == null) {
            return true;
        }

        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = head;

        ListNode head2 = null;

        while (fast != null) {
            if (fast.next.next == null) {
                // even nodes
                head2 = slow.next;
                slow.next = null;
                break;
            }
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
            if (fast.next == null) {
                // odd nodes
                prev.next = null;
                head2 = slow.next;
                break;
            }
        }

        // reverse head2
        head2 = reverse(head2);

        // compare head and head2
        ListNode temp1 = head;
        ListNode temp2 = head2;
        boolean isPalindrome = true;
        while (temp1.next != null && temp2.next != null) {
            if (temp1.val != temp2.val) {
                isPalindrome = false;
                break;
            }
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        return isPalindrome;
    }

    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static void main(String[] args) {

        leetcode_PalindromeLinkedList t1 = new leetcode_PalindromeLinkedList();
        // test 1
        ListNode list1 = LinkedListUtils.getRandomList(10);
        System.out.println(t1.isPalindrome(list1));

        // test 2
        ListNode list2 = LinkedListUtils.getPalindromeList();
        System.out.println(t1.isPalindrome(list2));
    }
}