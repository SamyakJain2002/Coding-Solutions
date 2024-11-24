class node {
    node prev;
    int val;
    int key;
    node next;

    node(int value, int key) {
        prev = null;
        val = value;
        next = null;
        this.key = key;
    }

    node(node prev, int value, int key, node next) {
        this.prev = prev;
        val = value;
        this.next = next;
        this.key = key;
    }
}

class LRUCache {
    node head;
    node tail;
    int capacity;
    int size;
    HashMap<Integer, node> map;

    public LRUCache(int capacity) {
        head = null;
        tail = null;
        this.capacity = capacity;
        size = 0;
        map = new HashMap<>();
    }

    public int get(int key) {
        if (size == 0 || !map.containsKey(key)) {
            return -1;
        }
        node temp = map.get(key);
        int ans = temp.val;
        appendToEnd(temp);
        return ans;
    }

    public void put(int key, int value) {
        if (size == 0) {
            node temp = new node(value, key);
            head = temp;
            tail = temp;
            size++;
            map.put(key, temp);
        } else if (map.containsKey(key)) {
            node temp1 = map.get(key);
            temp1.val = value;
            appendToEnd(temp1);
        } else if (size < capacity) {
            node temp = new node(value, key);
            tail.next = temp;
            temp.prev = tail;
            tail = temp;
            size++;
            map.put(key, temp);
        } else {
            map.remove(head.key);
            node temp = new node(value, key);
            tail.next = temp;
            temp.prev = tail;
            tail = temp;
            head = head.next;
            head.prev = null;
            map.put(key, temp);
        }
    }

    private void appendToEnd(node temp) {
        if (temp == tail) {
            return;
        } else if (temp == head) {
            head = temp.next;
            head.prev = null;
        } else {
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;
        }
        tail.next = temp;
        temp.prev = tail;
        temp.next = null;
        tail = temp;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */