/* List Cycle */

// Definition for singly-linked list.
//			function Node(data){
//				this.data = data
//				this.next = null
//			}

/*Proof:
M + K = distance covered by slow

2 (M +K ) = distance covered by fast
M + N + K  = distance covered by fast
2 (M +K) = M + N + K
2 M + 2 K = M + K + N
M + K = N
M = N - K
*/

module.exports = {
    //param A : head node of linked list
    //return the head node in the linked list
    detectCycle: function(A) {
        // find the meeting point within circle

        if (A === null) return null;

        let slow = A;
        let fast = A;
        while (fast !== null && fast.next !== null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow === fast) {
                break;
            }
        }

        if (fast === null || fast.next === null) {
            // no cycle
            return null;
        }

        // cycle is present, find start of the loop/cycle
        let temp = A;
        while (temp !== slow) {
            // pointer starting from head node
            temp = temp.next;
            // pointer starting from slow within loop
            slow = slow.next;
        }

        return temp;
    }
};