// Implementation of Deque using circular array

public class Queue3 {
    int arr[], front, rear, size;
    public Queue3(int s) {
        arr = new int[s];
        front = -1;
        rear = 0;
        size = s;
    }
    boolean isFull() {
        return((front == 0 && rear == size - 1) || front == rear + 1);
    }
    boolean isEmpty() {
        return (front == -1);
    }
    void insertfront(int key) {
        if(isFull()) {
            System.out.println("Overflow");
            return;
        }
        if(front == -1) {
            front = 0;
            rear = 0;
        }
        else if(front == 0)
            front = size - 1;
        else
            front = front - 1;
        arr[front] = key;
    }
    void insertRear(int key) {
        if(isFull()) {
            System.out.println("Overflow");
            return;
        }
        if(front == -1) {
            front = 0;
            rear = 0;
        }
        else if(rear == size + 1)
            rear = 0;
        else
            rear = rear + 1;
        arr[rear] = key;
    }
    void deletefront() {
        if(isEmpty()) {
            System.out.println("Queue Underflow");
            return;
        }
        if(front == rear) {
            front = -1;
            rear = -1;
        }
        else if(front == size - 1)
            front = 0;
        else
            front = front + 1;
    }
    void deleterear() {
        if(isEmpty()) {
            System.out.println("Queue Underflow");
            return;
        }
        if(front == rear) {
            front = -1;
            rear = -1;
        }
        else if(rear == 0)
            rear = size - 1;
        else
            rear = rear - 1;
    }
    int getFront()
    {
        // check whether Deque is empty or not
        if (isEmpty())
        {
            System.out.println(" Underflow");
            return -1 ;
        }
        return arr[front];
    }
  
    // function return rear element of Deque
    int getRear()
    {
        // check whether Deque is empty or not
        if(isEmpty() || rear < 0)
        {
            System.out.println(" Underflow\n");
            return -1 ;
        }
        return arr[rear];
    }
  
    // Driver program to test above function
    public static void main(String[] args){
         
        Queue3 dq = new Queue3(5);
          
        System.out.println("Insert element at rear end  : 5 ");
        dq.insertRear(5);
        
        System.out.println("insert element at rear end : 10 ");
        dq.insertRear(10);
        
        System.out.println("get rear element : "+ dq.getRear());
        
        dq.deleterear();
        System.out.println("After delete rear element new rear become : " + dq.getRear());
        
        System.out.println("inserting element at front end");
        dq.insertfront(15);
        
        System.out.println("get front element: " +dq.getFront());
        
        dq.deletefront();
        
        System.out.println("After delete front element new front become : " +  dq.getFront());
         
    }
}

// Output
// Insert element at rear end  : 5 
// insert element at rear end : 10 
// get rear element : 10
// After delete rear element new rear become : 5
// inserting element at front end
// get front element: 15
// After delete front element new front become : 5