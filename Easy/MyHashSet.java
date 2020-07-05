package Easy;

import java.util.Objects;

/**
 * Leetcode - #705
 * @param <K>
 */
public class MyHashSet<K>
{
    private Node<K>[] bucket;
    private int capacity;
    private int size;
    private static final int DEFAULT_INITIAL_CAPACITY = 1 << 4;
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;

    private static class Node<K> {
        private final int hash;
        private final K key;
        private final Object PRESENT;
        private Node<K> next;

        public Node(int hash, K key, Node<K> next) {
            this.hash = hash;
            this.key = key;
            this.PRESENT = new Object();
            this.next = next;
        }
    }
    public MyHashSet() {
        this.bucket = new Node[DEFAULT_INITIAL_CAPACITY];
        this.capacity = DEFAULT_INITIAL_CAPACITY;
        this.size = 0;
    }

    private int getThreshold() {
        return (int)(this.capacity * DEFAULT_LOAD_FACTOR);
    }

    private void resizeHashMap() {
        this.capacity = this.capacity << 1;
        this.size = 0;
        Node<K>[] oldBucket = this.bucket;
        this.bucket = new Node[this.capacity];
        for (Node<K> node : oldBucket) {
            while(node != null) {
                add(node.key);
                node = node.next;
            }
        }
    }

    private int hash(K key) {
        return key == null ? 0 : Math.abs(key.hashCode());
    }

    private int getBucketIndex(K key) {
        return key == null ? 0 : hash(key) % this.capacity;
    }

    public void add(K key) {
        if (this.size == getThreshold()) {
            resizeHashMap();
        }
        int hash = hash(key);
        int index = getBucketIndex(key);
        Node<K> head = bucket[index];
        Node<K> temp = head;
        while (temp != null) {
            // if the key is already present in the hash map, do not need to add it again
            if (temp.hash == hash && Objects.equals(key, temp.key)) {
                return;
            }
            temp = temp.next;
        }
        Node<K> node = new Node<>(hash, key, null);
        node.next = head;
        bucket[index] = node;
        size++;
    }

    public void remove(K key) {
        int hash = hash(key);
        int index = getBucketIndex(key);
        Node<K> head = bucket[index];
        if (head == null) {
            return;
        }
        if (head.hash == hash && Objects.equals(key, head.key)) {
            bucket[index] = head.next;
            size--;
            return;
        }
        Node<K> temp = head.next, prev = head;
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

    public boolean contains(K key) {
        int hash = hash(key);
        int index = getBucketIndex(key);
        Node<K> node = bucket[index];
        while (node !=  null) {
            if (node.hash == hash && Objects.equals(key, node.key)) {
                return true;
            }
            node = node.next;
        }
        return false;
    }

    public static void main(String[] args)
    {
        MyHashSet<Integer> myHashSet = new MyHashSet<>();
        myHashSet.add(1);
        myHashSet.add(2);
        System.out.println(myHashSet.contains(1));    // returns true
        System.out.println(myHashSet.contains(3));    // returns false (not found)
        myHashSet.add(2);
        System.out.println(myHashSet.contains(2));    // returns true
        myHashSet.remove(2);
        System.out.println(myHashSet.contains(2));    // returns false (already removed)
    }
}
