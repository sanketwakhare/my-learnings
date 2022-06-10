// Definition for singly-linked list.
//			function Node(data){
//				this.data = data
//				this.next = null
//			}

class MinHeap {

    constructor() {
        this.heap = [];
    }

    pollMin() {
        // remove first element, insert last element from heap and move it to root of heap and apply top down heapify
        if (this.heap.length > 0) {
            // swap root and last elements from heap
            let temp = this.heap[this.heap.length - 1];
            this.heap[this.heap.length - 1] = this.heap[0];
            this.heap[0] = temp;

            // get min element
            let minEle = this.heap.pop();

            // apply top down heapify on root
            let currIndex = 0;
            let leftChildIndex = Math.floor((currIndex * 2) + 1);
            let rightChildIndex = Math.floor((currIndex * 2) + 2);

            while (leftChildIndex < this.heap.length) {

                // find min out of 3 elements and swap
                let min = Math.min(this.heap[currIndex].data, this.heap[leftChildIndex].data);
                if (rightChildIndex < this.heap.length) {
                    min = Math.min(min, this.heap[rightChildIndex].data);
                }

                if (min !== this.heap[currIndex].data) {
                    // need to swap
                    if (min === this.heap[leftChildIndex].data) {
                        // swap min with left child
                        temp = this.heap[leftChildIndex];
                        this.heap[leftChildIndex] = this.heap[currIndex];
                        this.heap[currIndex] = temp;
                        currIndex = leftChildIndex;
                    } else if (min === this.heap[rightChildIndex].data) {
                        // swap min with right child
                        temp = this.heap[rightChildIndex];
                        this.heap[rightChildIndex] = this.heap[currIndex];
                        this.heap[currIndex] = temp;
                        currIndex = rightChildIndex;
                    }
                    leftChildIndex = Math.floor((currIndex * 2) + 1);
                    rightChildIndex = Math.floor((currIndex * 2) + 2);
                } else {
                    break;
                }
            }
            return minEle;
        }
        return -1;
    }

    peekMin() {
        if (this.heap.length === 0) return -1;
        return this.heap[0];
    }

    addNode(node) {
        if (node != null) {
            // insert element at last and apply heapify
            this.heap.push(node);
            // find index of parent element and current elements and bottom up heapify
            let size = this.heap.length;
            let currIndex = size - 1;
            let parentIndex = Math.floor((currIndex - 1) / 2);
            while (currIndex > 0 && this.heap[parentIndex].data > this.heap[currIndex].data) {
                let temp = this.heap[parentIndex];
                this.heap[parentIndex] = this.heap[currIndex];
                this.heap[currIndex] = temp;
                currIndex = parentIndex;
                parentIndex = Math.floor((currIndex - 1) / 2);
            }
        }
    }

    isEmpty() {
        return this.heap.length === 0;
    }
}

module.exports = {
    //param A : array of integers
    //return the head node in the linked list
    mergeKLists: function (A) {

        // insert head of all lists into min heap
        let minHeap = new MinHeap();
        for (let headNode of A) {
            minHeap.addNode(headNode);
        }

        // not pik min from heap and insert next available element into heap
        let dummyHead = new Node('dummy');
        let result = dummyHead;
        while (!minHeap.isEmpty()) {
            let currMin = minHeap.pollMin();
            if (currMin.next != null) {
                minHeap.addNode(currMin.next);
            }
            result.next = currMin;
            result = result.next;
        }

        return dummyHead.next;

    },
};
