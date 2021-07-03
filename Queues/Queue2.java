// Queue – Linked List Implementation

public class Queue2 {
    class QNode {
        int key;
        QNode next;
        QNode(int k) {
            key = k;
            next = null;
        }
    }
    QNode front, rear;
    public Queue2() {
        front = rear = null;
    }
    void enqueue(int key) {
        QNode temp = new QNode(key);
        // If queue is empty, then new node is front and rear both
        if(rear == null) {
            front = rear = temp;
            return;
        }
        rear.next = temp;
        rear = temp;
    }
    void dequeue() {
        QNode temp = front;
        front = front.next;
        if(front == null)
            rear = null;
    }
    public static void main(String[] args){
        Queue2 q = new Queue2();
        q.enqueue(10);
        q.enqueue(20);
        q.dequeue();
        q.dequeue();
        q.enqueue(30);
        q.enqueue(40);
        q.enqueue(50);
        q.dequeue();
        System.out.println("Queue Front : " + q.front.key);
        System.out.println("Queue Rear : " + q.rear.key);
    }
}

// Output
// Queue Front : 40
// Queue Rear : 50