package Medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode - #146
 */
public class LRUCache
{
    private Map<Integer, Node> map;
    private Node head;
    private Node tail;
    private int capacity;

    private static class Node {
        private int key;
        private int val;
        private Node prev;
        private Node next;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    public LRUCache(int capacity) {
        this.map = new HashMap<>(capacity);
        this.capacity = capacity;
    }

    public int get(int key) {
        // look the item in the hash map
        // if the item is in the hash map then it is already in our cache's linked list
        // use the hash map to quickly find the node from the linked list
        // else the item is not in our cache then return -1
        if (map.containsKey(key)) {
            Node node = map.get(key);
            removeNode(node);
            addAtHead(node);
            return node.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        // look the item in the hash map
        // if the item is in the hash map then it is already in our cache's linked list
        // use the hash map to quickly find the node from the linked list
        // move the node to the head of the linked list since its now the most recently used item
        // else the item is not in our cache's linked list, we need to put the item into our cache
        // check if our cache is full or not
        // if the cache is full then remove the least recently used item from the cache and also from the hash map
        // if not create a node and insert it into the head of the linked list and also insert it into the hash map
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.val = value;
            removeNode(node);
            addAtHead(node);
        } else {
            if (map.size() == this.capacity) {
                map.remove(tail.key);
                removeNode(tail);
            }
            Node node = new Node(key,value);
            map.put(key, node);
            addAtHead(node);
        }
    }

    private void removeNode(Node node) {
        if (node.prev != null) {
            node.prev.next = node.next;
        } else {
            head = node.next;
        }
        if (node.next != null) {
            node.next.prev = node.prev;
        } else {
            tail = node.prev;
        }
    }

    private void addAtHead(Node node) {
        node.next = head;
        node.prev = null;
        if (head != null) {
            head.prev = node;
        }
        head = node;
        if (tail == null) {
            tail = head;
        }
    }

    public static void main(String[] args)
    {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1,1);
        lruCache.put(2,2);
        System.out.println(lruCache.get(1));
        lruCache.put(3,3);
        System.out.println(lruCache.get(2));
        lruCache.put(4,4);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(3));
        System.out.println(lruCache.get(4));
    }
}
