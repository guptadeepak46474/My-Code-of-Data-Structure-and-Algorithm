// Queue using Stacks
// Java Program to implement a queue using two stacks

import java.util.*;

public class Stack4 {
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
        int x;

        /* If both stacks are empty then error */
        if(q.stack1.isEmpty() && q.stack2.isEmpty()) {
            System.out.println("Q is Empty");
            System.exit(0);
        }

        /* Move elements from stack1 to stack 2 only if stack2 is empty */
        while(q.stack2.isEmpty()) {
            while(!q.stack1.isEmpty()) {
                x = pop(q.stack1);
                push(q.stack2, x);
            }
        }
        x = pop(q.stack2);
        return x;
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