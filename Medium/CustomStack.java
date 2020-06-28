package Medium;

/**
 * Leetcode - #1381
 */
public class CustomStack
{
    private int[] stack;
    private int top;
    private int MAX_SIZE;

    public CustomStack(int maxSize) {
        stack = new int[maxSize];
        top = -1;
        MAX_SIZE = maxSize;
    }

    public void push(int x) {
        if (top < MAX_SIZE-1) {
            stack[++top] = x;
        }
    }

    public int pop() {
        // if stack is not empty
        if (top > -1) {
            return stack[top--];
        }
        return -1;
    }

    public void increment(int k, int val) {
        for (int i=0;i<k && i<MAX_SIZE;i++) {
            stack[i] += val;
        }
    }

    public static void main(String[] args)
    {
        CustomStack customStack = new CustomStack(3);
        customStack.push(1);
        customStack.push(2);
        System.out.println(customStack.pop());
        customStack.push(2);
        customStack.push(3);
        customStack.push(4);
        customStack.increment(5, 100);
        customStack.increment(2, 100);
        System.out.println(customStack.pop());
        System.out.println(customStack.pop());
        System.out.println(customStack.pop());
        System.out.println(customStack.pop());
    }
}
