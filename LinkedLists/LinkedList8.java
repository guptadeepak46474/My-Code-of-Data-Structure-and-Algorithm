// Search an element in a Linked List (Iterative and Recursive)

public class LinkedList8 {
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

    // Iterative Method
    // public boolean search(Node head, int x) {
    //     Node current = head;
    //     while(current != null) {
    //         if(current.data == x)
    //             return true;    // data found
    //         current = current.next;
    //     }
    //     return false;   // if data is not found
    // }

    // Recursive Method
    public boolean search(Node head, int x) {
        if(head == null)
            return false;
        if(head.data == x)
            return true;
        return search(head.next, x);
    }

    public static void main(String[] args) {
        LinkedList8 llist = new LinkedList8();
        llist.push(10);
        llist.push(30);
        llist.push(11);
        llist.push(21);
        llist.push(14);
        System.out.println((llist.search(llist.head, 21)) ? "Yes" : "No");
    }
}