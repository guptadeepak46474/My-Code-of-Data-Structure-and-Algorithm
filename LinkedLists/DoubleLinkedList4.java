// import java.util.Stack;

// Reverse a Doubly Linked List

public class DoubleLinkedList4 {
    static Node head;
 
    static class Node {
 
        int data;
        Node next, prev;
 
        Node(int d)
        {
            data = d;
            next = prev = null;
        }
    }
    void reverse() {
        Node temp = null;
        Node current = head;
        while(current != null) {
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;
            current = current.prev;
        }
        if(temp != null)
            head = temp.prev;
        
        //or

        // Stack<Integer> stack = new Stack<>();
        // Node temp = head;
        // while (temp != null) {
        //     stack.push(temp.data);
        //     temp = temp.next;
        // }
        // // added all the elements sequemce wise in the
        // // stack
        // temp = head;
        // while (temp != null) {
        //     temp.data = stack.pop();
        //     temp = temp.next;
        // }
    }
    void push(int new_data)
    {
        /* allocate node */
        Node new_node = new Node(new_data);
 
        /* since we are adding at the beginning,
         prev is always NULL */
        new_node.prev = null;
 
        /* link the old list off the new node */
        new_node.next = head;
 
        /* change prev of head node to new node */
        if (head != null) {
            head.prev = new_node;
        }
 
        /* move the head to point to the new node */
        head = new_node;
    }
    void printList(Node node)
    {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
    public static void main(String[] args)
    {
        DoubleLinkedList4 list = new DoubleLinkedList4();
 
        /* Let us create a sorted linked list to test the
         functions Created linked list will be 10->8->4->2
       */
        list.push(2);
        list.push(4);
        list.push(8);
        list.push(10);
 
        System.out.println("Original linked list ");
        list.printList(head);
 
        list.reverse();
        System.out.println("");
        System.out.println("The reversed Linked List is ");
        list.printList(head);   // The reversed Linked List is 2 4 8 10
    }
}