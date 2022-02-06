/* Stack implementation using Arrays */

class MyStack {
    int[] stack;
    int top;
    int defaultSize = 10;
    int size;

    public MyStack() {
        this.size = defaultSize;
        this.stack = new int[this.size];
        this.top = -1;
    }

    public MyStack(int size) {
        this.size = size;
        this.stack = new int[this.size];
        this.top = -1;
    }

    public boolean isEmpty() {
        return this.top == -1 ? true : false;
    }

    public boolean isFull() {
        return this.top == (this.size - 1) ? true : false;
    }

    public void push(int x) {
        if (isFull()) {
            System.out.println("stack is full! can not push");
        } else {
            top++;
            stack[top] = x;
        }
    }

    public int top() {
        if (isEmpty()) {
            System.out.println("stack is empty!");
            return -1;
        }
        return stack[top];
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("stack is empty! can not pop");
            return -1;
        } else {
            int x = stack[top];
            top--;
            return x;
        }
    }

    public void print() {
        for (int i = 0; i <= top; i++) {
            System.out.print(stack[i] + " ->");
        }
        System.out.println();
    }
}

public class class_stackImpl_Arrays {

    public static void main(String[] args) {
        MyStack stack = new MyStack(4);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.print();
        System.out.println(stack.isFull());
        System.out.println(stack.top());
        System.out.println(stack.pop());
        System.out.println(stack.top());
        System.out.println(stack.pop());
        stack.push(10);
        stack.print();
        System.out.println(stack.isEmpty());
        System.out.println(stack.isFull());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        stack.pop();

    }
}
