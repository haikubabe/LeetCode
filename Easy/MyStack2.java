package Easy;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Leetcode - #225
 * Idea - only one queue is used
 * Push - O(n), Pop - O(1)
 */
public class MyStack2
{

    private Queue<Integer> queue;

    public MyStack2() {
        queue = new LinkedList<>();
    }

    public void push(int x) {
        queue.add(x);
        int size = queue.size();
        while (size > 1) {
            queue.add(queue.remove());
            size--;
        }
    }

    public int pop() {
        return queue.remove();
    }

    public int top() {
        if (!queue.isEmpty()) {
            return queue.peek();
        }
        return -1;
    }

    public boolean empty() {
        return queue.isEmpty();
    }

    public static void main(String[] args)
    {
        MyStack2 myStack = new MyStack2();
        myStack.push(1);
        myStack.push(2);
        System.out.println(myStack.top());
        System.out.println(myStack.pop());
        System.out.println(myStack.empty());
    }
}
