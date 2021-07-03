// Check if a linked list is Circular Linked List

public class CircularLinkedList4 {
    static class Node {
        int data;
        Node next;
    }
    static boolean isCircular(Node head) {
        if(head == null)    // An empty linked list is circular
            return true;
        Node node = head.next;  // Next of head
        while(node != null && node != head) // This loop would stop in both cases (1) If Circular (2) Not circular
            node = node.next;
        return (node == head);  // If loop stopped because of circular condition
    }
    static Node newNode(int data) {
        Node temp = new Node();
        temp.data = data;
        temp.next = null;
        return temp;
    }
    public static void main(String[] args) {
        Node head = newNode(1);
        head.next = newNode(2);
        head.next.next = newNode(3);
        head.next.next.next = newNode(4);
        System.out.println((isCircular(head) ? "Yes" : "No"));
        head.next.next.next.next = head;
        System.out.println((isCircular(head) ? "Yes" : "No"));
    }
}