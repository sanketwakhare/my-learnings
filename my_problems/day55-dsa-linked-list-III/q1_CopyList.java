public class q1_CopyList {

    // Step 1: create copy nodes and insert in between original nodes by only next
    // pointers
    public static RandomListNode createCloneList(RandomListNode head) {

        // base condition for head
        if (head == null) {
            return null;
        }
        // initialize curr to traverse the list
        RandomListNode curr = head;

        while (curr != null) {
            RandomListNode x = new RandomListNode(curr.label);
            x.next = curr.next;
            curr.next = x;
            curr = curr.next.next;
        }
        // return the newly created list/combined list
        return head;
    }

    // Step 2 - assign random pointers to newly created nodes
    public static RandomListNode assignRandomPointersToCopyNodes(RandomListNode head) {

        RandomListNode curr = head;

        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }
        return head;
    }

    // Step 3 - separate two lists into old and new list and return copy list head
    // pointer
    public static RandomListNode separateTwoLists(RandomListNode head) {

        if (head == null) {
            return null;
        }

        // curr is usd to iterate over old list
        RandomListNode curr = head;
        RandomListNode headCopy = curr.next;

        // temp is used to iterate over copy list
        RandomListNode temp = headCopy;

        while (curr != null) {
            curr.next = curr.next.next;
            curr = curr.next;

            // ignore for last temp node as its next is already pointing to null
            if (curr != null) {
                temp.next = curr.next;
                temp = temp.next;
            }
        }

        // return copy list
        return headCopy;
    }

    public static RandomListNode copyRandomList(RandomListNode head) {

        // Step 1: create copy nodes and insert in between original nodes by only next
        // pointers
        head = createCloneList(head);
        RandomLinkedListUtils.printLL(head);

        // Step 2 - assign random pointers to newly created nodes
        head = assignRandomPointersToCopyNodes(head);
        RandomLinkedListUtils.printLL(head);

        // Step 3 - separate two lists into old and new list and return copy list head
        // pointer
        RandomListNode copyHead = separateTwoLists(head);
        return copyHead;
    }

    public static void main(String[] args) {

        RandomListNode head = RandomLinkedListUtils.getTestData();
        RandomLinkedListUtils.printLL(head);

        RandomListNode copyHead = copyRandomList(head);

        System.out.println("old list->");
        RandomLinkedListUtils.printLL(head);
        System.out.println("new copy list->");
        RandomLinkedListUtils.printLL(copyHead);
        RandomLinkedListUtils.printWithRandomPtrLL(copyHead);

        RandomLinkedListUtils.printWithRandomPtrLL(head);

    }
}
