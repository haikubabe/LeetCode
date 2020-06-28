package Medium;

import java.util.Stack;

/**
 * Leetcode - #155
 * Idea - using one stack
 */
public class MinStackI
{
    private Stack<Integer> stack;
    private int min;

    public MinStackI() {
        stack = new Stack<>();
        min = Integer.MAX_VALUE;
    }

    public void push(int x) {
        if (x <= min) {
            stack.push(min);
            min = x;
        }
        stack.push(x);
    }

    public void pop() {
        if (!stack.isEmpty()) {
            int element = stack.pop();
            if (element == min) {
                min = stack.pop();
            }
        }
    }

    public int top() {
        if (!stack.isEmpty()) {
            return stack.peek();
        }
        return -1;
    }

    public int getMin() {
        return min;
    }

    public static void main(String[] args)
    {
        MinStackI minStack = new MinStackI();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }
}
