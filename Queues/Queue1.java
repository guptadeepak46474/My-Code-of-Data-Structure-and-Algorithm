// Queue | Set 1 (Introduction and Array Implementation)
public class Queue1 {
    int front, rear, size, capacity, array[];
    public Queue1(int c) {
        capacity = c;
        front = size = 0;
        rear = capacity - 1;
        array = new int[capacity];
    }
    boolean isFull(Queue1 queue) {
        return (queue.size == queue.capacity);
    }
    boolean isEmpty(Queue1 queue) {
        return (queue.size == 0);
    }
    void enqueue(int item) {
        if(isFull(this))
            return;
        rear = (rear + 1) % capacity;
        array[rear] = item;
        size = size + 1;
        System.out.println(item + " enqueued to queue");
    }
    int dequeue() {
        if (isEmpty(this))
            return Integer.MIN_VALUE;
        int item = array[front];
        front = (front + 1) % capacity;
        size = size - 1;
        return item;
    }
    int front() {
        if (isEmpty(this))
            return Integer.MIN_VALUE;
 
        return array[front];
    }
    int rear() {
        if (isEmpty(this))
            return Integer.MIN_VALUE;
 
        return array[rear];
    }
    public static void main(String[] args) {
        Queue1 queue = new Queue1(1000);
 
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
 
        System.out.println(queue.dequeue()+ " dequeued from queue");
        System.out.println("Front item is "+ queue.front());
        System.out.println("Rear item is "+ queue.rear());
    }
}

// Output
// 10 enqueued to queue
// 20 enqueued to queue
// 30 enqueued to queue
// 40 enqueued to queue
// 10 dequeued from queue
// Front item is 20
// Rear item is 40