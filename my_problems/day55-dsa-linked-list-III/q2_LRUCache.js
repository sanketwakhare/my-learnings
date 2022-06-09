/* LRU Cache */

// Constructor : Initializes the LRUCache with capacity 
class DLLNode {
    constructor(data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}


module.exports = {
    LRUCache: function(capacity) {

        // initialize size and map
        let size = 0;
        let map = new Map();
        // create dummy nodes as head and tail
        let head = new DLLNode('head');
        let tail = new DLLNode('tail');
        head.next = tail;
        tail.prev = head;

        // detach node
        const detachNode = function(temp) {
            let prev = temp.prev;
            let next = temp.next;
            temp.next = null;
            temp.prev = null;
            prev.next = next;
            next.prev = prev;
            return temp;
        }

        // add node next to head
        const addToFront = function(temp) {
            let next = head.next;
            head.next = temp;
            temp.prev = head;
            temp.next = next;
            next.prev = temp;
        }

        return {
            // get function returns an integer
            get: function(key) {
                // check key in hashmap
                if (map.has(key)) {
                    // HIT
                    let node = map.get(key);

                    // update cache
                    let temp = head.next;
                    while (temp.next != null) {
                        if (temp === node) {
                            // node found
                            break;
                        }
                        temp = temp.next;
                    }

                    // remove node from cache 
                    temp = detachNode(temp);
                    // add it to front as it is recently accessed
                    // it can be added to tail as well, but here i am implementing it by adding it to head
                    addToFront(temp);

                    return node.data;
                }
                // MISS
                return -1;
            },
            // set returns nothing
            set: function(key, value) {
                let xNode;
                if (map.has(key)) {
                    // HIT
                    xNode = map.get(key);
                    xNode.data = value;
                    detachNode(xNode);
                } else {
                    // MISS
                    xNode = new DLLNode(value);
                    let keyToRemove = null;
                    if (size === capacity) {
                        // remove least recently used entry from map
                        for (let key of map.keys()) {
                            if (map.get(key) == tail.prev) {
                                keyToRemove = key;
                                break;
                            }
                        }
                        if (keyToRemove) {
                            map.delete(keyToRemove);
                        }
                        // remove least recently used node from tail of the linked list
                        detachNode(tail.prev);
                    } else {
                        // increase size
                        size++;
                    }
                }
                map.set(key, xNode);
                addToFront(xNode);

            }
        }
    }
}