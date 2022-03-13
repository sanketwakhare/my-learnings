import java.util.ArrayList;

import MinHeapGenericsImpl.MinHeap;

/* Merge K Sorted Lists */

/* Problem Description

Given a list containing head pointers of N sorted linked lists. Merge these N given sorted linked lists and return it as one sorted list.


Problem Constraints

1 <= total number of elements in given linked lists <= 100000


Input Format

First and only argument is a list containing N head pointers.


Output Format

Return a pointer to the head of the sorted linked list after merging all the given linked lists.


Example Input

Input 1:

 1 -> 10 -> 20
 4 -> 11 -> 13
 3 -> 8 -> 9
Input 2:

 10 -> 12
 13
 5 -> 6


Example Output

Output 1:

 1 -> 3 -> 4 -> 8 -> 9 -> 10 -> 11 -> 13 -> 20
Output 2:

 5 -> 6 -> 10 -> 12 ->13


Example Explanation

Explanation 1:

 The resulting sorted Linked List formed after merging is 1 -> 3 -> 4 -> 8 -> 9 -> 10 -> 11 -> 13 -> 20.
Explanation 2:

 The resulting sorted Linked List formed after merging is 5 -> 6 -> 10 -> 12 ->13. */

/* 
Node structure for this problem
public class ListNode implements Comparable<ListNode> {
    public int val;
    public ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}
 */

/**
 * TC: O(N * logK)
 * SC: O(K)
 */
class NodeItem implements Comparable<NodeItem> {
    int value;
    ListNode node;

    public NodeItem(int value, ListNode node) {
        this.value = value;
        this.node = node;
    }

    @Override
    public int compareTo(NodeItem o) {
        return this.value - o.value;
    }
}

public class hw_q4_merge_k_sorted_list {

    private static void mergeKLists(ArrayList<ListNode> list) {
        // Min Heap of size K where (K = size of list)
        MinHeap<NodeItem> minHeap = new MinHeap<NodeItem>();

        // store heads of all lists into heap
        for (ListNode node : list) {
            minHeap.insert(new NodeItem(node.val, node));
        }

        // initialize head and temp pointers
        ListNode head = null;
        ListNode temp = head;

        // get min element from heap and append to next of result linked list
        while (!minHeap.isEmpty()) {
            // get minimum node from heap
            ListNode x = minHeap.getMinimum().node;

            // add next available node of the current minimum node into the heap
            ListNode nextNode = x.next;
            if (nextNode != null) {
                minHeap.insert(new NodeItem(nextNode.val, nextNode));
            }

            // attach the node x at end to the result list
            if (head == null) {
                head = x;
                temp = head;
            } else {
                temp.next = x;
                temp = temp.next;
            }
        }

        LinkedListUtils.printLL(head);

    }

    public static void main(String[] args) {

        ListNode l1 = LinkedListUtils.getSortedList(5);
        ListNode l2 = LinkedListUtils.getSortedList(4);
        ListNode l3 = LinkedListUtils.getSortedList(5);

        LinkedListUtils.printLL(l1);
        LinkedListUtils.printLL(l2);
        LinkedListUtils.printLL(l3);

        ArrayList<ListNode> list = new ArrayList<ListNode>();
        list.add(l1);
        list.add(l2);
        list.add(l3);

        mergeKLists(list);

        /*
         * e.g.
         * 
         * Input:
         * 24 -> 29 -> 68 -> 69 -> 78
         * 27 -> 38 -> 63 -> 90
         * 6 -> 44 -> 50 -> 53 -> 79
         * 
         * Output-
         * 6 -> 24 -> 27 -> 29 -> 38 -> 44 -> 50 -> 53 -> 63 -> 68 -> 69 -> 78 -> 79 ->
         * 90
         */
    }

}
