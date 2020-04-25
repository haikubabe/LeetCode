package thirty_day_challenge;

import java.util.HashMap;
import java.util.Map;

public class LRUCache
{
    static class Node {
        int key;
        int val;
        Node left;
        Node right;

        Node (int key, int val) {
            this.key = key;
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    private static Map<Integer, Node> map;
    private static int capacity;
    private static Node start, end;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>(this.capacity);
    }

    public static int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            removeNode(node);
            addAtTop(node);
            return node.val;
        }
        return -1;
    }

    public static void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.val = value;
            removeNode(node);
            addAtTop(node);
        } else {
            Node node = new Node(key,value);
            if (map.size() >= capacity) {
                map.remove(end.key);
                removeNode(end);
            }
            addAtTop(node);
            map.put(key,node);
        }
    }

    private static void removeNode(Node node) {
        if (node.left != null) {
            node.left.right = node.right;
        } else {
            start = node.right;
        }
        if (node.right != null) {
            node.right.left = node.left;
        } else {
            end = node.left;
        }
    }

    private static void addAtTop(Node node) {
        node.right = start;
        node.left = null;
        if (start != null) {
            start.left = node;
        }
        start = node;
        if (end == null) {
            end = start;
        }
    }

    public static void main(String[] args)
    {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));       // returns 1
        cache.put(3, 3);    // evicts key 2
        System.out.println(cache.get((2)));       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        System.out.println(cache.get((1)));       // returns -1 (not found)
        System.out.println(cache.get((3)));       // returns 3
        System.out.println(cache.get((4)));       // returns 4
    }
}
