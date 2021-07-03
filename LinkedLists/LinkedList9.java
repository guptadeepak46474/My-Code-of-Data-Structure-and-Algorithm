// Write a function to get Nth node in a Linked List

public class LinkedList9 {
    Node head;
    class Node {
        int data;
        Node next;
        Node(int d) {
            data = d;
            next = null;
        }
    }
    public void push(int new_data) {
        Node new_node = new Node(new_data);
        new_node.next = head;
        head = new_node;
    }
    public int GetNth(int index) {
        Node current = head;
        int count = 0;
        while(current != null) {
            if(count == index)
                return current.data;
            count++;
            current = current.next;
        }
        assert(false);
        return 0;
    }

    public static void main(String[] args) {
        LinkedList9 llist = new LinkedList9();
        llist.push(1);
        llist.push(4);
        llist.push(1);
        llist.push(12);
        llist.push(1);
        System.out.println("Element at index 3 is: " + llist.GetNth(3));    // Element at index 3 is: 4
    }
    
}