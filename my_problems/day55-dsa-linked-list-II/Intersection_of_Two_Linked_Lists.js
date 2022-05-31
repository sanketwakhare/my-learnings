/* Intersection of Two Linked Lists */

/* leetCode link: https://leetcode.com/problems/intersection-of-two-linked-lists/ */


/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */

/**
 * @param {ListNode} headA
 * @param {ListNode} headB
 * @return {ListNode}
 */
var getIntersectionNode = function(headA, headB) {
    if (headA === null || headB === null) return null;

    // append tail1 to head2
    let trav = headA;
    while (trav.next !== null) {
        trav = trav.next;
    }
    trav.next = headB;

    // find cycle in headA and return the intersection point
    let slow = headA;
    let fast = headA;
    while (fast !== null && fast.next !== null) {
        slow = slow.next;
        fast = fast.next.next;
        if (slow === fast) break;
    }

    if (slow != fast) {
        // no cycle, revert to original structure
        trav.next = null;
        return null;
    }

    // find intersection point
    let prev = slow;
    let start = headA;
    while (slow !== start) {
        prev = slow;
        slow = slow.next;
        start = start.next;
    }

    // revert to original structure
    trav.next = null;
    return start;

};