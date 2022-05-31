/*  Add Two Numbers as Lists */

// Definition for singly-linked list.
//    function Node(data){
//      this.data = data
//      this.next = null
//    }

module.exports = {
    //param A : head node of linked list
    //param B : head node of linked list
    //return the head node in the linked list
    addTwoNumbers: function(A, B) {

        let carry = 0;
        let sum = 0;

        let result = new Node('dummy');
        let curr = result;

        while (A != null && B != null) {
            sum = A.data + B.data + carry;
            carry = Math.floor(sum / 10);
            quotient = sum % 10;

            let x = new Node(quotient);
            curr.next = x;
            curr = curr.next;

            A = A.next;
            B = B.next;
        }

        if (carry > 0) {
            while (A != null) {
                sum = A.data + carry;
                carry = Math.floor(sum / 10);
                quotient = sum % 10;
                let x = new Node(quotient);
                curr.next = x;
                curr = curr.next;

                A = A.next;
            }
            while (B != null) {
                sum = B.data + carry;
                carry = Math.floor(sum / 10);
                quotient = sum % 10;
                let x = new Node(quotient);
                curr.next = x;
                curr = curr.next;

                B = B.next;
            }
            if (carry > 0) {
                let x = new Node(carry);
                curr.next = x;
                curr = curr.next;
            }
        } else {
            if (A != null) {
                curr.next = A;
            }
            if (B != null) {
                curr.next = B;
            }
        }
        return result.next;
    }
};