/**
 * Implement circular Queue using array
 */

class CircularQueue {

    int[] queue;
    int front;
    int rear;
    int size;

    public CircularQueue(int capacity) {
        this.queue = new int[capacity];
        this.front = -1;
        this.rear = -1;
        this.size = 0;
    }

    public boolean isEmpty() {
        if (this.size == 0) {
            return true;
        }
        return false;
    }

    public boolean isFull() {
        if (this.size == queue.length) {
            return true;
        }
        return false;
    }

    public void enqueue(int x) {
        if (!isFull()) {
            rear = (rear + 1) % queue.length;
            queue[rear] = x;
            System.out.println("enqueued - " + queue[rear]);
            this.size++;
        }
    }

    public int dequeue() {
        if (!isEmpty()) {
            front = (front + 1) % queue.length;
            int dequeued = queue[front];
            System.out.println("dequeued - " + dequeued);
            this.size--;
            queue[front] = 0;
            return dequeued;
        }
        return -1;
    }

    public int front() {
        if (!isEmpty()) {
            int firstPos = (front + 1) % queue.length;
            System.out.println("front - " + queue[firstPos]);
            return queue[firstPos];
        }
        return -1;
    }
}

public class class_queue_Impl_circularQueue_Arrays {

    public static void main(String[] args) {

        CircularQueue cq = new CircularQueue(5);

        cq.enqueue(11);
        cq.enqueue(12);
        cq.enqueue(13);

        cq.dequeue();
        cq.dequeue();

        cq.front();

        cq.enqueue(51);
        cq.enqueue(52);
        cq.enqueue(53);

        cq.dequeue();
        cq.dequeue();
        cq.dequeue();

        cq.enqueue(101);
        cq.enqueue(102);
        cq.enqueue(103);
        cq.enqueue(104);
        cq.enqueue(105);

        cq.enqueue(201);
        cq.enqueue(202);

        while (!cq.isEmpty()) {
            cq.dequeue();
        }
    }

}
