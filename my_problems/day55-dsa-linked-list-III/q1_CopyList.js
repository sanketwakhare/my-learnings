/* Copy List */

// Definition for linked list.
//			function RandomListNode(data){
//				this.data = data
//				this.next = null
//              this.random = null
//			}

module.exports = {
    //param head : head node of linked list
    //return the head node in the linked list
    copyRandomList: function(head) {

        if (head == null) return head;

        // step 1: copy all nodes and connect them to next pointers of original nodes
        let temp = head;
        while (temp != null) {
            let copyNode = new RandomListNode(temp.data);
            copyNode.next = temp.next;
            temp.next = copyNode;

            temp = temp.next.next;
        }

        // step 2: connect random pointers
        temp = head;
        while (temp != null) {
            let copyNode = temp.next;
            if (temp.random !== null) {
                copyNode.random = temp.random.next;
            }

            temp = temp.next.next;
        }

        // step 3: break the list into two seperate list and return cloned list
        temp = head;
        let clonedList = temp.next;
        let copyTemp = clonedList;
        while (temp != null && copyTemp.next != null) {

            temp.next = temp.next.next;
            copyTemp.next = copyTemp.next.next;

            temp = temp.next;
            copyTemp = copyTemp.next;
        }

        return clonedList;
    }
};