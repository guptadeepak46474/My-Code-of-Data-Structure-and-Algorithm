// Queue using Stacks

import java.util.*;

public class Stack3 {
    static class Queue {
        static Stack<Integer> s1 = new Stack<Integer>();
        static Stack<Integer> s2 = new Stack<Integer>();

        static void enQueue(int x) {
            while(!s1.isEmpty()) {  // Move all elements from s1 to s2
                s2.push(s1.pop());
            }
            s1.push(x); // Push item into s1
            while(!s2.isEmpty()) {  // Push everything back to s1
                s1.push(s2.pop());
            }
        }

        static int deQueue() {
            if(s1.isEmpty()) {
                System.out.println("Q is Empty");
                System.exit(0);
            }
            // int x = s1.peek();
            // s1.pop();
            // return x;
            return s1.pop();
        }
    };
    public static void main(String[] args) {
        Queue q = new Queue();
        q.enQueue(1);
        q.enQueue(2);
        q.enQueue(3);
        System.out.println(q.deQueue());
        System.out.println(q.deQueue());
        System.out.println(q.deQueue());
    }
}

// Output
// 1
// 2
// 3