package Medium;

/**
 * Leetcode - #641
 */
public class MyCircularDeque
{
    private int[] queue;
    private int front;
    private int rear;
    private int MAX_SIZE;

    public MyCircularDeque(int k) {
        this.queue = new int[k];
        this.front = this.rear = -1;
        this.MAX_SIZE = k;
    }

    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }
        if (front == -1) {
            front = 0;
            rear = 0;
        } else {
            front = (front + MAX_SIZE - 1) % MAX_SIZE;
        }
        queue[front] = value;
        return true;
    }

    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }
        if (front == -1) {
            front = 0;
            rear = 0;
        } else {
            rear = (rear + 1) % MAX_SIZE;
        }
        queue[rear] = value;
        return true;
    }

    public boolean deleteFront() {
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

    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }
        if (front == rear) {    // only one element is left
            front = -1;
            rear = -1;
        } else {
            rear = (rear + MAX_SIZE - 1) % MAX_SIZE;
        }
        return true;
    }

    public int getFront() {
        if (front != -1) {
            return queue[front];
        }
        return -1;
    }

    public int getRear() {
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
        MyCircularDeque circularDeque = new MyCircularDeque(3); // set the size to be 3
        System.out.println(circularDeque.insertLast(1));			// return true
        System.out.println(circularDeque.insertLast(2));			// return true
        System.out.println(circularDeque.insertFront(3));			// return true
        System.out.println(circularDeque.insertFront(4));			// return false, the queue is full
        System.out.println(circularDeque.getRear());  			// return 2
        System.out.println(circularDeque.isFull());				// return true
        System.out.println(circularDeque.deleteLast());			// return true
        System.out.println(circularDeque.insertFront(4));			// return true
        System.out.println(circularDeque.getFront());			// return 4
    }
}
