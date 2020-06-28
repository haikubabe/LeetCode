package Medium;

/**
 * Leetcode - #155
 * Idea - using linked list
 */
public class MinStack
{
    private Node head;

    private static class Node {
        private int min;
        private int val;
        private Node next;

        public Node(int val) {
            this.val = val;
            this.min = val;
        }
    }

    public MinStack() {

    }

    public void push(int x) {
        Node node = new Node(x);
        if (head != null) {
            node.next = head;
            if (head.min < node.min) {
                node.min = head.min;
            }
        }
        head = node;
    }

    public void pop() {
        if (head != null) {
            head = head.next;
        }
    }

    public int top() {
        if (head != null) {
            return head.val;
        }
        return -1;
    }

    public int getMin() {
        if (head != null) {
            return head.min;
        }
        return -1;
    }

    public static void main(String[] args)
    {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }
}
