package Easy;

import java.util.Stack;

/**
 * Leetcode - #232
 * Idea - stack1 and stack2 will contain all the elements and the front of the queue will always be at the top of stack2
 * i.e the recent element will go to the top of stack1
 * Push - O(1), Pop - O(n)
 */
public class MyQueue1
{
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;
    private int front;

    public MyQueue1() {
        this.stack1 = new Stack<>();
        this.stack2 = new Stack<>();
        this.front = -1;
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        if (stack1.isEmpty()) {
            front = x;
        }
        stack1.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        int element = -1;
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
            if (!stack2.isEmpty()) {
                element = stack2.pop();
            }
        } else {
            element = stack2.pop();
        }
        if (!stack2.isEmpty()) {
            front = stack2.peek();
        }
        return element;
    }

    /** Get the front element. */
    public int peek() {
        return front;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    public static void main(String[] args)
    {
        MyQueue1 myQueue = new MyQueue1();
        myQueue.push(1);
        myQueue.push(2);
        System.out.println(myQueue.peek());
        System.out.println(myQueue.pop());
        System.out.println(myQueue.pop());
        System.out.println(myQueue.empty());
    }
}
