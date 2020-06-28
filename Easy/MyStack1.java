package Easy;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Leetcode - #225
 * Idea - queue1 will contain all the elements and the top is always the front element of queue1
 * Push - O(n), Pop - O(1)
 */
public class MyStack1
{

    private Queue<Integer> queue1;
    private Queue<Integer> queue2;

    public MyStack1() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    public void push(int x) {
        queue2.add(x);
        while (!queue1.isEmpty()) {
            queue2.add(queue1.remove());
        }
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }

    public int pop() {
        return queue1.remove();
    }

    public int top() {
        if (!queue1.isEmpty()) {
            return queue1.peek();
        }
        return -1;
    }

    public boolean empty() {
        return queue1.isEmpty();
    }

    public static void main(String[] args)
    {
        MyStack1 myStack = new MyStack1();
        myStack.push(1);
        myStack.push(2);
        System.out.println(myStack.top());
        System.out.println(myStack.pop());
        System.out.println(myStack.empty());
    }
}
