// Find Length of a Linked List using Recursive

public class LinkedList7 {
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
    public int getCount() {
        return getCountRec(head);
    }
    private int getCountRec(Node node) {
        if(node == null)
            return 0;
        else
            return 1 + getCountRec(node.next);
    }
    public static void main(String[] args) {
        LinkedList7 llist = new LinkedList7();
        llist.push(1);
        llist.push(3);
        llist.push(1);
        llist.push(2);
        System.out.println("Count of nodes in Linked List is: " + llist.getCount());    // Count of nodes in Linked List is: 4
    }
}