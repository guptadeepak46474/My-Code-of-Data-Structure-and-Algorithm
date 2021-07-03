// import java.util.*;

public class StackAsLinkedList1 {
    StackNode root;
    static class StackNode {
        int data;
        StackNode next;
 
        StackNode(int data) { this.data = data; }
    }
    public boolean isEmpty() {
        if(root == null)
            return true;
        else
            return false;
    }
    public void push(int data) {
        StackNode new_node = new StackNode(data);
        if(root == null)
            root = new_node;
        else {
            StackNode temp = root;
            root = new_node;
            new_node.next = temp;
        }
        System.out.println(data + " pushed to stack");
    }
    public int pop() {
        int popped = Integer.MIN_VALUE;
        if(root == null)
            System.out.println("Stack is Empty");
        else {
            popped = root.data;
            root = root.next;
        }
        return popped;
    }
    public int peek() {
        if(root == null) {
            System.out.println("Stack is Empty");
            return Integer.MIN_VALUE;
        }
        else
            return root.data;
    }
    public static void main(String[] args) {
        StackAsLinkedList1 sll = new StackAsLinkedList1();
        sll.push(10);
        sll.push(20);
        sll.push(30);
        System.out.println(sll.pop() + " popped from Stack");
        System.out.println("Top Element is: " + sll.peek());
    }
}

// Output : 
// 10 pushed to stack
// 20 pushed to stack  
// 30 pushed to stack  
// 30 popped from Stack
// Top Element is: 20