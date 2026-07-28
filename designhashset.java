import java.util.LinkedList;

class MyHashSet {
    // Use a prime number for capacity to reduce hash collisions
    private static final int CAPACITY = 769;
    private LinkedList<Integer>[] buckets;

    @SuppressWarnings("unchecked")
    public MyHashSet() {
        // Initialize the array of buckets
        buckets = new LinkedList[CAPACITY];
        for (int i = 0; i < CAPACITY; i++) {
            buckets[i] = new LinkedList<>();
        }
    }
    
    // Hash function to map keys to bucket indices
    private int hash(int key) {
        return key % CAPACITY;
    }

    public void add(int key) {
        int index = hash(key);
        // Add only if the key does not already exist
        if (!buckets[index].contains(key)) {
            buckets[index].add(key);
        }
    }

    public void remove(int key) {
        int index = hash(key);
        // LinkedList.remove(Object) removes by value, not index
        buckets[index].remove((Integer) key);
    }

    public boolean contains(int key) {
        int index = hash(key);
        return buckets[index].contains(key);
    }
}
