//Java Program to implement a stack using two queue
import java.util.*;

public class Stack10 {
    Queue<Integer> q1 = new LinkedList<Integer>();
    Queue<Integer> q2 = new LinkedList<Integer>();
    int curr_size;
    public Stack10() {
        curr_size = 0;
    }
    void remove() {
        if(q1.isEmpty())
            return;
        while(q1.size() != 1) {
            q2.add(q1.peek());
            q1.remove();
        }
        q1.remove();
        curr_size--;
        Queue<Integer> q = q1;
        q1 = q2;
        q2 = q;
    }
    void add(int x) {
        q1.add(x);
        curr_size++;
    }
    int top() {
        if(q1.isEmpty())
            return -1;
        while(q1.size() != 1) {
            q2.add(q1.peek());
            q1.remove();
        }
        int temp = q1.peek();
        q1.remove();
        q2.add(temp);
        Queue<Integer> q = q1;
        q1 = q2;
        q2 = q;
        return temp;
    }
    int size() {
        return curr_size;
    }
    public static void main(String[] args)
    {
        Stack10 s = new Stack10();
        s.add(1);
        s.add(2);
        s.add(3);
        s.add(4);
  
        System.out.println("current size: " + s.size());
        System.out.println(s.top());
        s.remove();
        System.out.println(s.top());
        s.remove();
        System.out.println(s.top());
        System.out.println("current size: " + s.size());
    }
}

//Output
// current size: 4
// 4
// 3
// 2
// current size: 2