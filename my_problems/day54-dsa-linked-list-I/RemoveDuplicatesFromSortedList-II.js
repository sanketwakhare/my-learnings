/* Remove Duplicated from Sorted lists - II */
/* LeetCode link: https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/ */
/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} head
 * @return {ListNode}
 */
var deleteDuplicates = function(head) {

    if (head == null || head.next == null) return head;

    // create dummy node at front
    let dummy = new ListNode('dummy');
    dummy.next = head;

    // initialize pointers
    let prev = dummy;
    let first = head;
    let second = head.next;

    // maintain a flag to delete the duplicate node
    let isMatching = false;
    while (second != null) {
        if (first.val == second.val) {
            // id node values are matching, remove second node and increase the second pointer
            first.next = second.next;
            second = second.next;
            // make this flag true to delete the node
            isMatching = true;
        } else {
            if (isMatching) {
                // delete node at first pointer
                first = second;
                second = second.next;
                prev.next = first;
                isMatching = false;
            } else {
                // increase all pointers by 1
                second = second.next;
                first = first.next;
                prev = prev.next;
            }
        }
    }
    // when the duplicate node is present at last
    if (isMatching) {
        prev.next = first.next;
    }
    return dummy.next;
};