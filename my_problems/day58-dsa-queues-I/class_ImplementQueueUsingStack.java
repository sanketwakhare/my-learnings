import java.util.Stack;

/**
 * Implement a Queue using 2 stacks
 * 
 * Idea:
 * 1) enqueue operation will always be done into stack1
 * 2) dequeue operation will always be done from stack2
 * if stack2 is empty, fetch all elements from stack1 and flush into stack2
 * is stack2 is not empty, directly fetch the top of stack2
 */

class CustomQueue {
    Stack<Integer> stack1;
    Stack<Integer> stack2;

    CustomQueue() {
        stack1 = new Stack<Integer>();
        stack2 = new Stack<Integer>();
    }

    // insert the element into stack1 always
    public void enqueue(int x) {
        System.out.println("enqueued - " + x);
        stack1.push(x);
    }

    // fetch the element form stack2 always
    // is stack2 eis empty, flush all the elements from stack1 to stack2 and then
    // fetch
    public int dequeue() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        if (!stack2.isEmpty()) {
            System.out.println("dequeued - " + stack2.peek());
            return stack2.pop();
        }
        return -1;
    }

    public boolean isEmpty() {
        if (stack1.isEmpty() && stack2.isEmpty()) {
            return true;
        }
        return false;
    }

}

public class class_ImplementQueueUsingStack {

    public static void main(String[] args) {

        CustomQueue myQueue = new CustomQueue();
        myQueue.enqueue(11);
        myQueue.enqueue(12);
        myQueue.enqueue(13);
        myQueue.enqueue(14);
        myQueue.enqueue(15);

        myQueue.dequeue();
        myQueue.dequeue();

        myQueue.enqueue(51);
        myQueue.enqueue(52);
        myQueue.enqueue(53);

        myQueue.dequeue();
        myQueue.dequeue();

        myQueue.enqueue(101);
        myQueue.enqueue(102);

        while (!myQueue.isEmpty()) {
            myQueue.dequeue();
        }

    }

}
