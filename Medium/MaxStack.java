package Medium;

import java.util.Stack;

/**
 * Leetcode
 * Idea - using one stack
 */
public class MaxStack
{
    private Stack<Integer> stack;
    private int max;

    public MaxStack() {
        stack = new Stack<>();
        max = Integer.MIN_VALUE;
    }

    public void push(int x) {
        if (x >= max) {
            stack.push(max);
            max = x;
        }
        stack.push(x);
    }

    public void pop() {
        if (!stack.isEmpty()) {
            int element = stack.pop();
            if (element == max) {
                max = stack.pop();
            }
        }
    }

    public int top() {
        if (!stack.isEmpty()) {
            return stack.peek();
        }
        return -1;
    }

    public int getMax() {
        return max;
    }

    public static void main(String[] args)
    {
        MaxStack maxStack = new MaxStack();
        maxStack.push(5);
        maxStack.push(0);
        maxStack.push(4);
        System.out.println(maxStack.top());
        System.out.println(maxStack.getMax());
        maxStack.push(6);
        System.out.println(maxStack.top());
        System.out.println(maxStack.getMax());
        maxStack.pop();
        System.out.println(maxStack.top());
        System.out.println(maxStack.getMax());
        maxStack.push(2);
        System.out.println(maxStack.top());
        System.out.println(maxStack.getMax());
        maxStack.pop();
        System.out.println(maxStack.top());
        System.out.println(maxStack.getMax());
        maxStack.push(7);
        System.out.println(maxStack.top());
        System.out.println(maxStack.getMax());
    }
}
