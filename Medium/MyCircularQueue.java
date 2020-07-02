package Medium;

/**
 * Leetcode - #622
 */
public class MyCircularQueue
{
    private int[] queue;
    private int front;
    private int rear;
    private int MAX_SIZE;

    public MyCircularQueue(int k) {
        this.queue = new int[k];
        this.front = this.rear = -1;
        this.MAX_SIZE = k;
    }

    public boolean enqueue(int value) {
        if (isFull()) {
            return false;
        }
        if (front == -1) {
            front++;
        }
        rear = (rear + 1) % MAX_SIZE;
        queue[rear] = value;
        return true;
    }

    public boolean dequeue() {
        if (isEmpty()) {
            return false;
        }
        if (front == rear) {    // only one element is left
            front = -1;
            rear = -1;
        } else {
            front = (front + 1) % MAX_SIZE;
        }
        return true;
    }

    public int front() {
        if (front != -1) {
            return queue[front];
        }
        return -1;
    }

    public int rear() {
        if (rear != -1) {
            return queue[rear];
        }
        return -1;
    }

    public boolean isEmpty() {
        return front == -1;
    }

    public boolean isFull() {
        return (front == 0 && rear == MAX_SIZE - 1) || (front == rear + 1);
    }

    public static void main(String[] args)
    {
        MyCircularQueue myCircularQueue = new MyCircularQueue(3);
        System.out.println(myCircularQueue.enqueue(1));  // return true
        System.out.println(myCircularQueue.enqueue(2));  // return true
        System.out.println(myCircularQueue.enqueue(3));  // return true
        System.out.println(myCircularQueue.enqueue(4));  // return false, the queue is full
        System.out.println(myCircularQueue.rear());  // return 3
        System.out.println(myCircularQueue.isFull());  // return true
        System.out.println(myCircularQueue.dequeue());  // return true
        System.out.println(myCircularQueue.enqueue(4));  // return true
        System.out.println(myCircularQueue.rear());  // return 4
    }
}
