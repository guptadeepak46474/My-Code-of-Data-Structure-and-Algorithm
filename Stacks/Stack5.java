// Queue using Stacks
// Java Program to implement a queue using two stacks

import java.util.*;

public class Stack5 {
    static class Queue {
        Stack<Integer> stack1;
        Stack<Integer> stack2;
    }
    static void push(Stack<Integer> top_ref, int new_data) {
        top_ref.push(new_data);
    }
    static int pop(Stack<Integer> top_ref) {
        if(top_ref.isEmpty()) {
            System.out.println("Stack Underflow");
            System.exit(0);
        }
        return top_ref.pop();
    }
    static void enqueue(Queue q, int x) {
        push(q.stack1, x);
    }
    static int deQueue(Queue q) {
        int x, res = 0;
        if(q.stack1.isEmpty() ) {
            System.out.println("Q is Empty");
            System.exit(0);
        } else if (q.stack1.size() == 1) {
            return pop(q.stack1);
        } else {
            x = pop(q.stack1);
            res = deQueue(q);
            push(q.stack1, x);
            return res;
        }
        return 0;
    }
    public static void main(String[] args) {
        Queue q = new Queue();
        q.stack1 = new Stack<>();
        q.stack2 = new Stack<>();
        enqueue(q, 1);
        enqueue(q, 2);
        enqueue(q, 3);

        System.out.print(deQueue(q) + " ");
        System.out.print(deQueue(q) + " ");
        System.out.print(deQueue(q) + " ");

        // Output: 1 2 3
    }
}