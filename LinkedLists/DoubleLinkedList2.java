// Delete a node in a Doubly Linked List

public class DoubleLinkedList2 {
    Node head;
    class Node {
        int data;
        Node next, prev;
        Node(int d) {   // By default next and prev initiised as null
            data = d;
        }
    }
    public void push(int new_data) {
        Node new_node = new Node(new_data);
        new_node.next = head;
        new_node.prev = null;
        if(head != null)
            head.prev = new_node;
        head = new_node;
    }
    public void printList(Node node) {
        Node last = null;
        while(node != null) {
            System.out.print(node.data + " ");
            last = node;
            node = node.next;
        }
        System.out.println();
    }
    void deleteNode(Node del) {
        if(head == null || del == null)
            return;
        if(head == del)
            head = del.next;
        if(del.next != null)    // Change next only if node to be deleted is NOT the last node
            del.next.prev = del.prev;
        if(del.prev != null)
            del.prev.next = del.next;
        return;
    }
    public static void main(String[] args) {
        DoubleLinkedList2 dll = new DoubleLinkedList2();
        dll.push(2);    // Insert 2. So linked list becomes 2->NULL
        dll.push(4);    // Insert 4. So linked list becomes 4->2->NULL
        dll.push(8);    // Insert 8. So linked list becomes 8->4->2->NULL
        dll.push(10);   // Insert 10. So linked list becomes 10->8->4->2->NULL
        System.out.println("Created DLL is: ");
        dll.printList(dll.head);
        dll.deleteNode(dll.head);   // List after deleting first node 8->4->2

        System.out.println("List after deleting first Node is: ");
        dll.printList(dll.head);

        dll.deleteNode(dll.head.next);  // Deleting middle node from 8->4->2
        System.out.println("List after Deleting middle node: ");
        dll.printList(dll.head);    // List after Deleting middle node: 8 2 
    }
    
}