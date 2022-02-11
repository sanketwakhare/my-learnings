import java.util.LinkedList;
import java.util.Queue;

/**
 * Implement a Stack using Queue(s)
 * 
 * Idea:
 * 1) push() - always perform push operation on queue1
 * 2) pop() -
 * (a) dequeue all elements from queue1 except last element in queue1
 * into queue2
 * (b) dequeue the last element from queue1
 * (c) swap and rename queue1 and queue2
 */

class CustomStack {

    Queue<Integer> queue1;
    Queue<Integer> queue2;

    CustomStack() {
        queue1 = new LinkedList<Integer>();
        queue2 = new LinkedList<Integer>();
    }

    public boolean isEmpty() {
        if (queue1.isEmpty() && queue2.isEmpty()) {
            return true;
        }
        return false;
    }

    public void push(int x) {
        // enqueue into queue1
        queue1.add(x);
        System.out.println("pushed - " + x);
    }

    public Integer pop() {

        if (isEmpty()) {
            return -1;
        }

        Integer lastElement = null;
        // dequeue all elements from queue1 into queue2 except last element
        while (!queue1.isEmpty()) {
            lastElement = queue1.poll();
            if (!queue1.isEmpty()) {
                queue2.add(lastElement);
            }
        }
        // swap names of queue1 and queue2
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;

        // return last element
        System.out.println("popped - " + lastElement);
        return lastElement;
    }

}

public class class_ImplementStackUsingQueues {

    public static void main(String[] args) {

        CustomStack stack = new CustomStack();

        stack.push(11);
        stack.push(12);
        stack.push(13);
        stack.push(14);

        stack.pop();
        stack.pop();

        stack.push(51);
        stack.push(52);
        stack.push(53);

        stack.pop();
        stack.pop();

        stack.push(101);
        stack.push(102);

        while (!stack.isEmpty()) {
            stack.pop();
        }

    }
}
