package Easy;

import java.util.Objects;

/**
 * Leetcode - #706
 * @param <K>
 * @param <V>
 */
public class MyHashMap<K,V>
{
    private Node<K,V>[] bucket;
    /**
     * Number of key value mappings
     */
    private int size;
    /**
     * Number of buckets in a hash map
     */
    private int capacity;
    /**
     * Number of buckets in a hash map at the time of creation
     */
    private static final int DEFAULT_INITIAL_CAPACITY = 1 << 4;
    /**
     * It's a measure of how full the hash map is allowed to get before its capacity is resized automatically
     */
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;

    private static class Node<K,V> {
        private final int hash;
        private final K key;
        private V value;
        private Node<K,V> next;

        public Node(int hash, K key, V value, Node<K,V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    public MyHashMap() {
        this.bucket = new Node[DEFAULT_INITIAL_CAPACITY];
        this.size = 0;
        this.capacity = DEFAULT_INITIAL_CAPACITY;
    }

    /**
     * The next size value at which to resize the hash map (capacity * load factor)
     */
    private int getThreshold() {
        return (int)(this.capacity * DEFAULT_LOAD_FACTOR);
    }

    /**
     * Calculate the hashcode of key
     * @param key
     * @return
     */
    private int hash(K key) {
        return key == null ? 0 : Math.abs(key.hashCode());
    }

    /**
     * Calculate the bucket's index
     * @param key
     * @return
     */
    private int getBucketIndex(K key) {
        return (key == null) ? 0 : hash(key) % this.capacity;
    }

    private void resizeHashMap() {
        this.capacity = this.capacity << 1; // double the size of hash map
        this.size = 0;
        Node<K,V>[] oldBucket = bucket;
        this.bucket = new Node[this.capacity];
        for (Node<K,V> node : oldBucket) {
            while (node != null) {
                put(node.key, node.value);
                node = node.next;
            }
        }
    }

    public void put(K key, V value) {
        if (size > getThreshold()) {
            resizeHashMap();
        }
        int hash = hash(key);
        int index = getBucketIndex(key);
        Node<K,V> node = new Node<>(hash, key, value, null);
        Node<K,V> head = bucket[index];
        Node<K,V> temp = head;
        while (temp != null) {
            if (temp.hash == hash && (Objects.equals(key, temp.key))) {
                temp.value = value;
                return;
            }
            temp = temp.next;
        }
        node.next = head;
        bucket[index] = node;
        size++;
    }

    public V get(K key) {
        int hash = hash(key);
        int index = getBucketIndex(key);
        Node<K,V> node = bucket[index];
        while (node != null) {
            if (node.hash == hash && Objects.equals(key, node.key)) {
                return node.value;
            }
            node = node.next;
        }
        return null;
    }

    public void remove(K key) {
        int hash = hash(key);
        int index = getBucketIndex(key);
        Node<K,V> head = bucket[index];
        if (head == null) {
            return;
        }
        // if the node to be deleted is the head of the linked list
        if (head.hash == hash && Objects.equals(key, head.key)) {
            bucket[index] = head.next;
            size--;
            return;
        }
        Node<K,V> temp = head.next, prev = head;
        while (temp != null) {
            if (temp.hash == hash && Objects.equals(key, temp.key)) {
                prev.next = temp.next;
                size--;
                return;
            }
            prev = temp;
            temp = temp.next;
        }
    }

    public boolean containsKey(K key) {
        int hash = hash(key);
        int index = getBucketIndex(key);
        Node<K,V> node = bucket[index];
        while (node != null) {
            if (node.hash == hash && Objects.equals(key, node.key)) {
                return true;
            }
            node = node.next;
        }
        return false;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public static void main(String[] args)
    {
        MyHashMap<Employee, String> myHashMap = new MyHashMap<>();
        /*System.out.println(myHashMap.isEmpty());
        myHashMap.put("Sreemoyee", "Chowdhury");
        myHashMap.put("Sourav", "Goswami");
        myHashMap.put("Sumedha", "Chowdhury");
        myHashMap.put("Pallavi", "Chatterjee");
        myHashMap.put("Sudip", "Ghosh");
        System.out.println(myHashMap.get("Sumedha"));
        System.out.println(myHashMap.get("Sudip"));
        System.out.println(myHashMap.get("Sreemoyee"));
        myHashMap.put("Sreemoyee", "Goswami");
        System.out.println(myHashMap.get("Sreemoyee"));
        System.out.println(myHashMap.get("Pallavi"));
        myHashMap.remove("Pallavi");
        System.out.println(myHashMap.get("Pallavi"));
        System.out.println(myHashMap.size());
        System.out.println(myHashMap.isEmpty());
        System.out.println(myHashMap);*/

        Employee emp1 = new Employee(123456, "Sreemoyee Chowdhury");
        Employee emp2 = new Employee(87907, "Sourav Goswami");
        myHashMap.put(emp1, "Hyland");
        myHashMap.put(emp2, "Mentor");
        System.out.println(myHashMap.get(emp1));
        System.out.println(myHashMap.get(emp2));
        myHashMap.put(emp1, "Hyland Software");
        System.out.println(myHashMap.get(emp1));
        myHashMap.remove(emp1);
        System.out.println(myHashMap.get(emp1));
        System.out.println(myHashMap.containsKey(emp2));
        System.out.println(myHashMap.containsKey(new Employee(8786, "John")));
        System.out.println(myHashMap.toString());
    }
}
