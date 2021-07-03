//Implement Stack using Array

import java.util.*;

public class Stack1 {
    static class Stack {
        static final int max = 1000;
        int top;
        int[] arr = new int[max];
        Stack() {
            top = -1;
        }
        boolean isEmpty() {
            return (top < 0);
        }
        boolean push(int x) {
            if(x >= (max-1)){
                System.out.println("Stack Overflow");
                return false;
            } else {
                arr[++top] = x;
                return true;
            }
        }
        int pop() {
            if(top < 0) {
                System.out.println("Stack Underflow");
                return 0;
            } else {
                int x = arr[top];
                return x;
            }
        }
        int peek() {
            if(top < 0) {
                System.out.println("Stack Underflow");
                return 0;
            } else {
                int x = arr[top];
                return x;
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack s = new Stack();
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            s.push(arr[i] = sc.nextInt());
        }
        sc.close();
        System.out.println(s.pop() + " poped from the stack");
        System.out.println(s.peek() + " peek from the stack");
        // s.push(10);
        // s.push(20);
        // s.push(30);
        // s.push(40);
        // System.out.println(s.pop() + " poped from the stack");  //40
        // System.out.println(s.peek() + " peek from the stack");  //40
    }
    
}