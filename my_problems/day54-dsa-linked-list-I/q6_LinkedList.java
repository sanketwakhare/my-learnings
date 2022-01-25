/*  Linked-List */

/***
 * Problem Description
 * 
 * Design and implement a Linked List data structure. A node in a linked list
 * should have the following attributes - an integer value and a pointer to the
 * next node. It should support the following operations:
 * 
 * insert_node(position, value) - To insert the input value at the given
 * position in the linked list.
 * delete_node(position) - Delete the value at the given position from the
 * linked list.
 * print_ll() - Print the entire linked list, such that each element is followed
 * by a single space.
 * 
 * Note:
 * If an input position does not satisfy the constraint, no action is required.
 * Each print query has to be executed in new line.
 * 
 * Problem Constraints
 * 1 <= position <= n where, n is the size of the linked-list.
 * 
 * Input Format
 * First line contains an integer denoting number of cases, let's say t.
 * Next t line denotes the cases.
 * 
 * Output Format
 * When there is a case of print_ll(), Print the entire linked list, such that
 * each element is followed by a single space.
 * 
 * NOTE: You don't need to return anything.
 * 
 * Example Input
 * 5
 * i 1 23
 * i 2 24
 * p
 * d 1
 * p
 * 
 * Example Output
 * 23 24
 * 24
 * 
 * Example Explanation
 * After first two cases linked list contains two elements 23 and 24.
 * At third case print: 23 24.
 * At fourth case delete value at first position, only one element left 24.
 * At fifth case print: 24.
 */

public class q6_LinkedList {

    static ListNode head = null;
    static int size = 0;

    public static void insert_node(int position, int value) {
        // @params position, integer
        // @params value, integer

        if ((head == null && position > 1) || (position > size + 1) || position <= 0) {
            // can not insert
            return;
        }

        ListNode temp = head;
        if (position == 1) {
            // insert at head
            ListNode x = new ListNode(value);
            x.next = temp;
            head = x;
            size++;
        } else if (position == size + 1) {
            // insert at end
            // System.out.println("at end");
            while (temp.next != null) {
                temp = temp.next;
            }
            // now temp points to last element in LL
            ListNode x = new ListNode(value);
            temp.next = x;
            size++;
        } else if (position <= size) {
            // insert in between
            int tempPos = position - 1;
            while (tempPos > 1) {
                temp = temp.next;
                tempPos--;
            }
            ListNode x = new ListNode(value);
            x.next = temp.next;
            temp.next = x;
            size++;
        }
    }

    public static void delete_node(int position) {
        // @params position, integer
        if (head == null || position < 1 || position > size) {
            // can not delete
            return;
        }
        ListNode temp = head;
        if (position == 1) {
            // delete head
            head = head.next;
            temp.next = null;
            size--;
        } else if (position == size) {
            // delete last
            while (temp.next.next != null) {
                temp = temp.next;
            }
            // delete temp.next
            temp.next = null;
            size--;
        } else {
            // delete element in between
            // System.out.println("inside d "+position);
            int tempPos = position - 1;
            while (temp.next != null && tempPos > 1) {
                temp = temp.next;
                tempPos--;
            }
            // delete temp.next
            temp.next = temp.next.next;
            size--;
        }
    }

    public static void print_ll() {
        // Output each element followed by a space
        ListNode temp = head;

        while (temp.next != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println(temp.val);
    }

    public static void main(String[] args) {
        q6_LinkedList.insert_node(1, 10);
        q6_LinkedList.insert_node(1, 20);
        q6_LinkedList.insert_node(1, 30);
        q6_LinkedList.insert_node(1, 40);
        print_ll();
        q6_LinkedList.delete_node(2);
        print_ll();
    }

}
