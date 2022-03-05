package MinHeapGenericsImpl;

import java.util.ArrayList;
import java.util.List;

public class MinHeap<T extends Comparable<T>> {
    List<T> heap;

    public MinHeap() {
        heap = new ArrayList<T>();
    }

    public int size() {
        return heap.size();
    }

    public List<T> getHeap() {
        return heap;
    }

    public boolean isEmpty() {
        if (heap.size() == 0) {
            return true;
        }
        return false;
    }

    public void insert(T x) {

        heap.add(x);
        int i = this.heap.size() - 1;
        while (i > 0) {
            int parentIndex = (i - 1) / 2;
            if (heap.get(i).compareTo(heap.get(parentIndex)) < 0) {
                swap(i, parentIndex);
                i = parentIndex;
            } else {
                return;
            }
        }
    }

    public T getMinimum() {
        T x = null;
        if (!isEmpty()) {
            x = heap.get(0);
            // swap last element and x
            swap(0, heap.size() - 1);
            heap.remove(heap.size() - 1);

            int i = 0;
            while ((2 * i) + 1 < heap.size()) {
                int leftChildIndex = (2 * i) + 1;
                int rightChildIndex = (2 * i) + 2;
                T min = null;

                // find minimum out of 3
                min = heap.get(i).compareTo(heap.get(leftChildIndex)) < 0 ? heap.get(i) : heap.get(leftChildIndex);
                if (rightChildIndex < heap.size()) {
                    min = heap.get(rightChildIndex).compareTo(min) < 0 ? heap.get(rightChildIndex) : min;
                }

                if (min == heap.get(i)) {
                    break;
                } else if (min == heap.get(leftChildIndex)) {
                    swap(i, leftChildIndex);
                    i = leftChildIndex;
                } else if (rightChildIndex < heap.size() && min == heap.get(rightChildIndex)) {
                    swap(i, rightChildIndex);
                    i = rightChildIndex;
                }
            }

        }
        return x;
    }

    public T peekMin() {
        return heap.get(0);
    }

    private void swap(int i, int j) {
        T temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

}