public class RandomLinkedListUtils {

    // 1->2->3->4->5
    public static void printLL(RandomListNode head) {

        if (head == null)
            return;
        RandomListNode temp = head;
        while (temp.next != null) {
            System.out.print(temp.label + " -> ");
            temp = temp.next;
        }
        System.out.println(temp.label);

    }

    // 1->2->3->4->5
    public static void printWithRandomPtrLL(RandomListNode head) {

        if (head == null)
            return;
        RandomListNode temp = head;
        while (temp != null) {
            RandomListNode random = temp.random;
            System.out.println(temp.label + " -> random -> " + ((random != null) ? random.toString() : "null"));
            temp = temp.next;
        }

    }

    public static RandomListNode getTestData() {
        RandomListNode head = new RandomListNode(1);
        RandomListNode t1 = new RandomListNode(2);
        head.next = t1;
        RandomListNode t2 = new RandomListNode(3);
        t1.next = t2;
        RandomListNode t3 = new RandomListNode(4);
        t2.next = t3;
        RandomListNode t4 = new RandomListNode(5);
        t3.next = t4;
        // assign random pointers
        head.random = t3;
        t1.random = t4;
        t2.random = null;
        t3.random = t3;
        t4.random = t1;
        return head;
    }

}
