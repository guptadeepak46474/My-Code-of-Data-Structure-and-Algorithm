// Find the middle of a given linked list

public class LinkedList11 {
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
    public void printMiddle() {
        Node slow_ptr = head;
        Node fast_ptr = head;
        if(head != null) {
            while(fast_ptr != null && fast_ptr.next != null) {
                slow_ptr = slow_ptr.next;
                fast_ptr = fast_ptr.next.next;
            }
            System.out.println("The middle element is [" + slow_ptr.data + "]");
        }
    }
    public void printList() {
        Node temp = head;
        while(temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("NULL");
    }
    public static void main(String[] args) {
        LinkedList11 llist = new LinkedList11();
        for(int i = 5; i > 0; --i) {
            llist.push(i);
            llist.printList();
            llist.printMiddle();
        }
    }
}

// Output
// 5->NULL
// The middle element is [5]
// 4->5->NULL
// The middle element is [5]
// 3->4->5->NULL
// The middle element is [4]
// 2->3->4->5->NULL
// The middle element is [4]
// 1->2->3->4->5->NULL
// The middle element is [3]