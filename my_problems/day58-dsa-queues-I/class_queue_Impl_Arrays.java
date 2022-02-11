/**
 * Implement queue using array
 * Drawback: Queue can become full once the rear reaches to last element in
 * queue
 * Even though there is space left on left of the front, it is unutilized in
 * this implementation
 */
class MyQueue {

    private int[] queue;
    private int size;
    private int front;
    private int rear;

    public MyQueue(int initialCapacity) {
        this.queue = new int[initialCapacity];
        this.front = -1;
        this.rear = -1;
        this.size = 0;
    }

    public void enqueue(int x) {
        // add element to rear/end
        if (!isFull()) {
            rear = rear + 1;
            queue[rear] = x;
            this.size++;
        }
    }

    public int dequeue() {
        // remove element from front/start
        if (!isEmpty()) {
            front++;
            this.size--;
            return queue[front];
        }
        return -1;
    }

    public boolean isEmpty() {
        if (size == 0) {
            System.out.println("Queue is empty");
            return true;
        }
        return false;
    }

    public boolean isFull() {
        if (this.rear == this.queue.length - 1) {
            System.out.println("Queue is full");
            return true;
        }
        return false;
    }

    public int front() {
        // remove element from front/start
        if (!isEmpty()) {
            return queue[front + 1];
        }
        return -1;
    }

    public void print() {
        for (int i = front + 1; i <= rear; i++) {
            if (i == rear) {
                System.out.println(this.queue[i]);
            } else {
                System.out.print(this.queue[i] + " ");
            }
        }
    }
}

public class class_queue_Impl_Arrays {

    public static void main(String[] args) {
        MyQueue queue = new MyQueue(10);
        queue.enqueue(5);
        queue.enqueue(6);
        queue.enqueue(7);
        queue.enqueue(8);
        queue.enqueue(9);
        queue.print();
        queue.dequeue();
        System.out.println("front is " + queue.front());
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.print();
        queue.dequeue();
        queue.print();
        queue.enqueue(15);
        queue.enqueue(16);
        queue.enqueue(17);
        queue.enqueue(18);
        queue.enqueue(19);
        queue.enqueue(20);
        queue.enqueue(21);
        System.out.println("front is " + queue.front());
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.print();
        queue.enqueue(29);
        queue.enqueue(30);
    }
}
