package Medium;

/**
 * Queue implementation using array
 */
public class CustomQueue
{
    private int[] queue;
    private int front;
    private int rear;
    private int MAX_SIZE;

    public CustomQueue(int capacity) {
        this.queue = new int[capacity];
        this.front = this.rear = -1;
        this.MAX_SIZE = capacity;
    }

    public void enqueue(int x) {
        if (front == -1) {
            front++;
        }
        if (!isFull()) {
            queue[++rear] = x;
        }
    }

    public int dequeue() {
        if (isEmpty()) {
            return -1;
        }
        int element = queue[front];
        if (front == rear) {    // only one element is left
            front = -1;
            rear = -1;
        } else {
            front++;
        }
        return element;
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
        return rear == MAX_SIZE - 1;
    }

    public static void main(String[] args)
    {
        CustomQueue customQueue = new CustomQueue(6);
        System.out.println(customQueue.isEmpty());
        System.out.println(customQueue.front());
        System.out.println(customQueue.rear());
        customQueue.enqueue(1);
        customQueue.enqueue(2);
        customQueue.enqueue(3);
        customQueue.enqueue(4);
        customQueue.enqueue(5);
        customQueue.enqueue(6);
        System.out.println(customQueue.isFull());
        System.out.println(customQueue.isEmpty());
        System.out.println(customQueue.front());
        System.out.println(customQueue.rear());
        System.out.println(customQueue.dequeue());
        System.out.println(customQueue.dequeue());
        System.out.println(customQueue.dequeue());
        System.out.println(customQueue.dequeue());
        System.out.println(customQueue.isEmpty());
        System.out.println(customQueue.front());
        System.out.println(customQueue.rear());
        customQueue.enqueue(7);
        System.out.println(customQueue.isFull());
        System.out.println(customQueue.isEmpty());
        System.out.println(customQueue.front());
        System.out.println(customQueue.rear());
        System.out.println(customQueue.dequeue());
        System.out.println(customQueue.dequeue());
        System.out.println(customQueue.dequeue());
        System.out.println(customQueue.isEmpty());
        System.out.println(customQueue.front());
        System.out.println(customQueue.rear());
    }
}
