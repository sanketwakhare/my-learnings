/* LRU Cache */

/***
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
set(key, value) - Set or insert the value if the key is not already present. When the cache reaches its capacity, it should invalidate the least recently used item before inserting the new item.

The LRUCache will be initialized with an integer corresponding to its capacity. Capacity indicates the maximum number of unique keys it can hold at a time.

Definition of "least recently used" : An access to an item is defined as a get or a set operation of the item. "Least recently used" item is the one with the oldest access time.

NOTE: If you are using any global variables, make sure to clear them in the constructor.

Example :
Input : 
         capacity = 2
         set(1, 10)
         set(5, 12)
         get(5)        returns 12
         get(1)        returns 10
         get(10)       returns -1
         set(6, 14)    this pushes out key = 5 as LRU is full. 
         get(5)        returns -1 
 */

import java.util.HashMap;
import java.util.Map.Entry;

/**
 * TC: O(N)
 * SC: O(N) - hashMap and capacity storage
 */
public class q2_LRUCache {

    /* DLL node structure */
    class DLLNode {
        int data;
        DLLNode prev;
        DLLNode next;

        DLLNode(int data) {
            this.data = data;
        }
    }

    // this is actual capacity of LRU
    private int capacity;
    // current size of the LRU
    private int size = 0;
    // hashMap is maintained to make search operation in O(1)
    private HashMap<Integer, DLLNode> hashMap;

    // head and tail of LRU
    private DLLNode head;
    private DLLNode tail;

    // initialize dummy nodes
    public q2_LRUCache() {
        head = new DLLNode(-1);
        tail = new DLLNode(-1);
    }

    public q2_LRUCache(int capacity) {
        this();
        this.capacity = capacity;
        this.hashMap = new HashMap<Integer, DLLNode>();
        head.next = tail;
        tail.prev = head;
    }

    public DLLNode detachNode(DLLNode temp) {
        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;
        temp.next = null;
        temp.prev = null;
        return temp;
    }

    public void insertAtLast(DLLNode temp) {
        temp.next = tail;
        temp.prev = tail.prev;
        tail.prev.next = temp;
        tail.prev = temp;
    }

    // get data from LRU
    public int get(int key) {

        if (hashMap.containsKey(key)) {
            // HIT scenario
            DLLNode node = hashMap.get(key);
            if (node != null) {
                // update the LRU cache as this is accessed recently
                node = detachNode(node);
                insertAtLast(node);

                return node.data;
            }

        }
        // MISS scenario
        return -1;
    }

    public void set(int key, int value) {

        if (hashMap.containsKey(key)) {
            // HIT
            // get node from hashMap
            DLLNode node = hashMap.get(key);

            // update the same node value
            node.data = value;

            // update the LRU cache as this is accessed recently
            node = detachNode(node);
            insertAtLast(node);

        } else {
            // MISS

            // create new node x and insert into hashMap
            DLLNode x = new DLLNode(value);
            hashMap.put(key, x);

            // check if LRU is full
            if (size == capacity) {
                // LRU is full

                // remove head.next.data from hashMap
                DLLNode temp = head.next;
                int keyToRemove = -1;
                for (Entry<Integer, DLLNode> entry : hashMap.entrySet()) {
                    if (entry.getValue() == temp) {
                        keyToRemove = entry.getKey();
                        break;
                    }
                }
                hashMap.remove(keyToRemove);

                // detach head.next node from LRU cache
                temp = detachNode(temp);

            } else {
                size++;
            }
            // add the new node x at last before tail
            insertAtLast(x);
        }

    }

    public static void main(String[] args) {

        // test case 1
        q2_LRUCache cache = new q2_LRUCache(5);
        cache.set(10, 100);
        cache.set(3, 30);
        cache.set(5, 50);
        System.out.println(cache.get(3));
        System.out.println(cache.get(13));

        cache.set(10, 1000);
        cache.set(4, 40);
        cache.set(9, 90);
        cache.set(4, 400);
        cache.set(1, 10);
        System.out.println(cache.get(4));
        cache.set(15, 150);

        System.out.println(cache.get(3));

        /*
         * capacity = 2
         * set(1, 10)
         * set(5, 12)
         * get(5) returns 12
         * get(1) returns 10
         * get(10) returns -1
         * set(6, 14) this pushes out key = 5 as LRU is full.
         * get(5) returns -1
         */

        // test case 2
        q2_LRUCache cache2 = new q2_LRUCache(2);
        cache2.set(1, 10);
        cache2.set(5, 12);
        System.out.println(cache2.get(5));
        System.out.println(cache2.get(1));
        System.out.println(cache2.get(10));
        cache2.set(6, 14);
        System.out.println(cache2.get(5));

    }
}
