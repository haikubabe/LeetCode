package Medium;

/**
 * Leetcode - #707
 */
public class MyLinkedList
{
    private Node head;
    private int size;

    private static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }

    /** Initialize your data structure here. */
    public MyLinkedList() {

    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if (index >= size) {
            return -1;
        }
        Node temp = head;
        for (int i=0;i<index;i++) {
            temp = temp.next;
        }
        return temp.val;
    }

    /** Add a node of value val before the first element of the linked list.
     * After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        Node node = new Node(val);
        node.next = head;
        head = node;
        size++;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        Node node = new Node(val);
        size++;
        if (head == null) {
            head = node;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = node;
        }
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list,
     * the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if (index > size) {
            return;
        }
        Node node = new Node(val);
        size++;
        if (index == 0) {
            head = node;
            node.next = head;
        } else {
            Node temp = head;
            for (int i=0;i<index-1;i++) {
                temp = temp.next;
            }
            node.next = temp.next;
            temp.next = node;
        }
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (index >= size) {
            return;
        }
        size--;
        if (index == 0) {
            head = head.next;
        } else {
            Node temp = head;
            for (int i=0;i<index-1;i++) {
                temp = temp.next;
            }
            temp.next = temp.next.next;
        }
    }

    public static void main(String[] args)
    {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addAtHead(1);
        linkedList.addAtTail(3);
        linkedList.addAtIndex(1,2);
        System.out.println(linkedList.get(1));
        linkedList.deleteAtIndex(1);
        System.out.println(linkedList.get(1));
    }
}
