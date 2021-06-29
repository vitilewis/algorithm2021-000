class LRUCache {
    LinkedHashMap<Integer, Integer> cache = new LinkedHashMap<>();
    int cap;
    public LRUCache(int capacity) {
        this.cap = capacity;
    }
    
    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }
        moveRecently(key);
        return cache.get(key);
    }
    
    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            cache.put(key, value);
            moveRecently(key);
            return;
        }
        if (cache.size() >= this.cap) {
            int oldKey = cache.keySet().iterator().next();
            cache.remove(oldKey);
        }
        cache.put(key, value);
    }
    public void moveRecently(int key) {
        int val = cache.get(key);
        cache.remove(key);
        cache.put(key, val);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */