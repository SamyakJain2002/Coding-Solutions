class LFUCache {

    class CacheNode {
        int key, value, frequency;
        CacheNode prev, next;

        CacheNode(int key, int value) {
            this.key = key;
            this.value = value;
            this.frequency = 1; 
        }
    }

    class FrequencyList {
        CacheNode head, tail; 
        int size; 

        FrequencyList() {
            head = new CacheNode(0, 0); // Dummy head node
            tail = new CacheNode(0, 0); // Dummy tail node
            head.next = tail;
            tail.prev = head;
            size = 0;
        }

        void addNodeToFront(CacheNode node) {
            CacheNode firstNode = head.next;
            head.next = node;
            node.prev = head;
            node.next = firstNode;
            firstNode.prev = node;
            size++;
        }

        void removeNode(CacheNode node) {
            CacheNode prevNode = node.prev;
            CacheNode nextNode = node.next;
            prevNode.next = nextNode;
            nextNode.prev = prevNode;
            size--;
        }

        CacheNode removeLastNode() {
            if (size > 0) {
                CacheNode lastNode = tail.prev;
                removeNode(lastNode);
                return lastNode;
            }
            return null;
        }
    }

    private int cacheCapacity, minFrequency;
    private Map<Integer, CacheNode> keyToCacheNode; 
    private Map<Integer, FrequencyList> frequencyToList; 

    public LFUCache(int capacity) {
        this.cacheCapacity = capacity;
        this.minFrequency = 0; 
        this.keyToCacheNode = new HashMap<>();
        this.frequencyToList = new HashMap<>();
    }

    public int get(int key) {
        if (!keyToCacheNode.containsKey(key)) {
            return -1;         }

        CacheNode node = keyToCacheNode.get(key);
        updateNodeFrequency(node); 
        return node.value;
    }

    public void put(int key, int value) {
        if (cacheCapacity == 0) return; 

        if (keyToCacheNode.containsKey(key)) {
            CacheNode node = keyToCacheNode.get(key);
            node.value = value; 
            updateNodeFrequency(node);
            return;
        }

        if (keyToCacheNode.size() >= cacheCapacity) {
            FrequencyList minFreqList = frequencyToList.get(minFrequency);
            CacheNode nodeToRemove = minFreqList.removeLastNode();
            keyToCacheNode.remove(nodeToRemove.key);
        }

        CacheNode newNode = new CacheNode(key, value);
        keyToCacheNode.put(key, newNode);
        minFrequency = 1;
        frequencyToList.computeIfAbsent(1, k -> new FrequencyList()).addNodeToFront(newNode);
    }

    private void updateNodeFrequency(CacheNode node) {
        int oldFreq = node.frequency;
        FrequencyList oldFreqList = frequencyToList.get(oldFreq);
        oldFreqList.removeNode(node); 

        if (oldFreq == minFrequency && oldFreqList.size == 0) {
            minFrequency++;
        }

        node.frequency++;
        frequencyToList.computeIfAbsent(node.frequency, k -> new FrequencyList()).addNodeToFront(node);
    }
}