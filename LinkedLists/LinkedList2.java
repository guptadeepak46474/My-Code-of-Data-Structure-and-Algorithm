// Linked List | Set 2 (Inserting a node)

public class LinkedList2 {
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
    public void insertAfter(Node prev_node, int new_data) {
        if(prev_node == null) {
            System.out.println("The given prev node cannot be null");
            return;
        }
        Node new_node = new Node(new_data);
        new_node.next = prev_node.next;
        prev_node.next = new_node;
    }
    public void append(int new_data) {
        Node new_node = new Node(new_data);
        if(head == null) {
            head = new Node(new_data);
            return;
        }
        new_node.next = null;
        Node last = head;
        while(last.next != null) {
            last = last.next;
        }
        last.next = new_node;
        return;
    }
    public void printList() {
        Node tnode = head;
        while(tnode != null) {
            System.out.print(tnode.data + " ");
            tnode = tnode.next;
        }
    }
    public static void main(String[] args) {
        LinkedList2 llist = new LinkedList2();
        llist.append(6);    // Insert 6. So linked list becomes 6->NUllist
        llist.push(7);      // Insert 7 at the beginning. So linked list becomes 7->6->NUllist
        llist.push(1);      // Insert 1 at the beginning. So linked list becomes 1->7->6->NUllist
        llist.append(4);    // Insert 4 at the end. So linked list becomes 1->7->6->4->NUllist
        llist.insertAfter(llist.head.next, 8);  // Insert 8, after 7. So linked list becomes 1->7->8->6->4->NUllist
        System.out.println("Created List is: ");
        llist.printList();
    }
}