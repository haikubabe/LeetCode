package Easy;

import java.util.Stack;

/**
 * Leetcode - #232
 * Idea - stack1 will contain all the elements and the front of the queue will always be at the top of stack1
 * i.e the recent element will go to the bottom of stack1
 * Push - O(n), Pop - O(1)
 */
public class MyQueue
{
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;
    private int front;

    public MyQueue() {
        this.stack1 = new Stack<>();
        this.stack2 = new Stack<>();
        this.front = -1;
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        if (stack1.isEmpty()) {
            front = x;
        }
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        stack2.push(x);
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        int element = -1;
        if (!stack1.isEmpty()) {
            element = stack1.pop();
            if (!stack1.isEmpty()) {
                front = stack1.peek();
            }
        }
        return element;
    }

    /** Get the front element. */
    public int peek() {
        return front;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack1.isEmpty();
    }

    public static void main(String[] args)
    {
        MyQueue myQueue = new MyQueue();
        myQueue.push(1);
        myQueue.push(2);
        System.out.println(myQueue.peek());
        System.out.println(myQueue.pop());
        System.out.println(myQueue.empty());
    }
}
