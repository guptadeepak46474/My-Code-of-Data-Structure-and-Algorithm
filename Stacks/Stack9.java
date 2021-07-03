// Implement Stack using Queues
import java.util.*;

public class Stack9 {
        Queue<Integer> q1 = new LinkedList<Integer>();
        Queue<Integer> q2 = new LinkedList<Integer>();
        int curr_size = 0;
        Stack9() {
            curr_size = 0;
        }
        void push(int x) {
            curr_size++;
            q2.add(x);
            while(!q1.isEmpty()) {
                q2.add(q1.peek());
                q1.remove();
            }
            Queue<Integer> q = q1;
            q1 = q2;
            q2 = q;
        }
        void pop() {
            if(q1.isEmpty())
                return;
            q1.remove();
            curr_size--;
        }
        int top() {
            if(q1.isEmpty())
                return -1;
            return q1.peek();
        }
        int size() {
            return curr_size;
        }
    public static void main(String[] args) {
        Stack9 s = new Stack9();
        s.push(1);
        s.push(2);
        s.push(3);
        
        System.out.println("current size: " + s.size());
        System.out.println(s.top());
        s.pop();
        System.out.println(s.top());
        s.pop();
        System.out.println(s.top());
  
        System.out.println("current size: " + s.size());
    }
}

// Output
// current size: 3
// 3
// 2
// 1
// current size: 1