// Delete a Doubly Linked List node at a given position

public class DoubleLinkedList3 {
    class Node {
        int data;
        Node next, prev;
        Node(int d) {   // By default next and prev initiised as null
            data = d;
        }
    }
    static Node head = null;
    static Node deleteNode(Node del) {
        if(head == null || del == null)
            return null;
        if(head == del)
            head = del.next;
        if(del.next != null)
            del.next.prev = del.prev;
        if(del.prev != null)
            del.prev.next = del.next;

        del = null;
        
        return head;
    }
    static void deleteNodeAtGivenPos(int n) {
        if(head == null || n < 0)
            return;
        Node current = head;
        int i;
        for(i = 1; current != null && i < n; i++)
            current = current.next;
        if(current == null)
            return;
        deleteNode(current);
    }
    public void push(int new_data) {
        Node new_node = new Node(new_data);
        new_node.next = head;
        new_node.prev = null;
        if(head != null)
            head.prev = new_node;
        head = new_node;
    }
    static void printList()
    {
        Node temp = head;
        if (temp == null)
            System.out.print("Doubly Linked list empty");
 
        while (temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
    public static void main(String[] args)
    {
        // Create the doubly linked list:
        // 10<->8<->4<->2<->5
        DoubleLinkedList3 list = new DoubleLinkedList3();
        list.push(5);
        list.push(2);
        list.push(4);
        list.push(8);
        list.push(10);
 
        System.out.println("Doubly linked list before deletion:");
        printList();
 
        int n = 2;
         
        // delete node at the given position 'n'
        deleteNodeAtGivenPos(n);
        System.out.println("Doubly linked list after deletion:");   // Doubly linked list after deletion 10 4 2 5
        printList();
    }
}