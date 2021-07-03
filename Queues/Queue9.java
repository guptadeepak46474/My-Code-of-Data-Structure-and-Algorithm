public class Queue9 {
    int k, n, free;
    int arr[], front[], rear[], next[];
    Queue9(int k, int n) {
        this.k = k;
        this.n = n;
        arr = new int[n];
        front = new int[k];
        rear = new int[k];
        next = new int[n];
        for(int i = 0; i < k; i++)
            front[i] = rear[i] = -1;
        free = 0;
        for(int i = 0; i < n - 1; i++)
            next[i] = i+1;
        next[n-1] = -1;
    }
    private boolean isEmpty(int i) {
        return front[i] == -1;
    }
     
    // To dequeue an from queue number 'i' where i is from 0 to k-1
    private boolean isFull(int i) {
        return free == -1;
    }
 
    private void enqueue(int item, int j) {
        if(isFull(j)) {
            System.out.println("queue overflow");
            return;
        }
        int nextfree = next[free];
        if(isEmpty(j))
            rear[j] = front[j] = free;
        else {
            next[rear[j]] = free;
            rear[j] = free;
        }
        next[free] = -1;
        arr[free] = item;
        free = nextfree;
    }
    private int dequeue(int i) {
        if(isEmpty(i)) {
            System.out.println("Stack underflow");
            return Integer.MIN_VALUE;
        }
        int frontIndex = front[i];
        front[i] = next[frontIndex];

        next[frontIndex] = free;
        free = frontIndex;

        return arr[frontIndex];
    }
    public static void main(String[] args)
    {
        // Let us create 3 queue in an array of size 10
        int k = 3, n = 10;
        Queue9 ks=  new Queue9(k, n);
        
         
        // Let us put some items in queue number 2
        ks.enqueue(15, 2);
        ks.enqueue(45, 2);
       
        // Let us put some items in queue number 1
        ks.enqueue(17, 1);
        ks.enqueue(49, 1);
        ks.enqueue(39, 1);
       
        // Let us put some items in queue number 0
        ks.enqueue(11, 0);
        ks.enqueue(9, 0);
        ks.enqueue(7, 0);
         
        System.out.println("Dequeued element from queue 2 is " + ks.dequeue(2));
        System.out.println("Dequeued element from queue 1 is " + ks.dequeue(1));
        System.out.println("Dequeued element from queue 0 is " + ks.dequeue(0) );
    }
}

// Output
// Dequeued element from queue 2 is 15
// Dequeued element from queue 1 is 17
// Dequeued element from queue 0 is 11