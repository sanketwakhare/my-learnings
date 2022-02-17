/* Implement Circular Dequeue using Array */

class CustomDeQueue {

    int[] dequeue;
    int size;
    int front;
    int rear;
    int capacity;

    // constructor with initial capacity
    public CustomDeQueue(int capacity) {
        this.capacity = capacity;
        this.front = -1;
        this.rear = -1;
        this.size = 0;
        this.dequeue = new int[this.capacity];
    }

    // check if dequeue is empty
    public boolean isEmpty() {
        if (this.size == 0) {
            return true;
        }
        return false;
    }

    // check if dequeue is full
    public boolean isFull() {
        if (this.size == this.capacity) {
            return true;
        }
        return false;
    }

    // push at rear
    public void enqueue(int value) {
        if (!isFull()) {
            this.rear = (this.rear + 1) % this.capacity;
            this.dequeue[this.rear] = value;
            this.size++;
        }
    }

    // remove from front
    public int dequeue() {
        if (!isEmpty()) {
            this.front = (this.front + 1) % this.capacity;
            int value = this.dequeue[this.front];
            this.dequeue[this.front] = 0;
            this.size--;
            return value;
        }
        return -1;
    }

    // remove from rear
    public int pop() {
        if (!isEmpty()) {
            int value = this.dequeue[this.rear];
            this.dequeue[this.rear] = 0;
            this.rear = (this.rear - 1 + this.capacity) % this.capacity;
            this.size--;
            return value;
        }
        return -1;
    }

    // peek front
    public int front() {
        if (!isEmpty()) {
            int value = this.dequeue[(this.front + 1) % this.capacity];
            return value;
        }
        return -1;
    }

    // peek rear
    public int rear() {
        if (!isEmpty()) {
            int value = this.dequeue[this.rear];
            return value;
        }
        return -1;
    }

    // size of dequeue
    public int size() {
        return this.size;
    }
}

public class class_deque_implement_using_circular_array {

    public static void main(String[] args) {

        CustomDeQueue dq = new CustomDeQueue(5);

        dq.enqueue(11);
        dq.enqueue(12);
        dq.enqueue(13);
        dq.enqueue(14);
        dq.enqueue(15);
        dq.enqueue(16);

        System.out.println(dq.size());

        dq.dequeue();
        dq.dequeue();
        dq.dequeue();

        System.out.println(dq.front());
        System.out.println(dq.rear());

        dq.enqueue(101);
        dq.enqueue(102);
        dq.enqueue(103);

        System.out.println(dq.front());
        System.out.println(dq.rear());

        dq.pop();
        dq.pop();
        dq.pop();
        dq.pop();
        dq.dequeue();
        dq.dequeue();

        System.out.println(dq.front());
        System.out.println(dq.rear());
        System.out.println(dq.size());

    }

}
