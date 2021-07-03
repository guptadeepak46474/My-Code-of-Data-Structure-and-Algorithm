// Delete a Linked List node at a given position

public class LinkedList4 {
    Node head;
    class Node {
        int data;
        Node next;
        Node(int d) {
            data = d;
            next = null;
        }
    }
    void deleteNode(int position) {
        if(head == null)
            return;
        Node temp = head;
        if(position == 0) {
            head = temp.next;
            return;
        }
        for(int i = 0; temp != null && i < position - 1; i++) {
            temp = temp.next;
        }
        if(temp == null || temp.next == null)
            return;
        Node next = temp.next.next;
        temp.next = next;
    }
    public void push(int new_data) {
        Node new_node = new Node(new_data);
        new_node.next = head;
        head = new_node;
    }
    public void printList() {
        Node tnode = head;
        while(tnode != null) {
            System.out.print(tnode.data + " ");
            tnode = tnode.next;
        }
    }
    public static void main(String[] args) {
        LinkedList4 llist = new LinkedList4();
        llist.push(7);
        llist.push(1);
        llist.push(3);
        llist.push(2);
        llist.push(8);
        System.out.println("Created List is: ");    // 8 2 3 1 7
        llist.printList();

        llist.deleteNode(4);    // Delete node at position 4

        System.out.println("\nLinked List after deletion at position 4 is: ");    // 8 2 3 1
        llist.printList();
    }
}