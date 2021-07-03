// QuickSort on Doubly Linked List

public class QuickSortOnDLL {
    Node head;
    static class Node {
        int data;
        Node prev, next;
        Node(int data) {
            this.data = data;
            prev = next = null;
        }
    }
    Node lastNode(Node node) {
        while(node.next != null)
            node = node.next;
        return node;
    }
    Node partition(Node l, Node h) {
        int x = h.data;
        Node i = l.prev;
        for(Node j = l; j != h; j = j.next) {
            if(j.data < x) {
                i = (i==null) ? l : i.next;     // same as i++ in array
                int temp = i.data;
                i.data = j.data;
                j.data = temp;
            }
        }
        i = (i==null) ? l : i.next;     // same as i++ in array
        int temp = i.data;
        i.data = h.data;
        h.data = temp;

        return i;
    }
    public void quickSort(Node node) {
        // Find last Node
        Node head = lastNode(node);
        _quickSort(node, head);
    }
    void _quickSort(Node l, Node h) {
        if(h != null && l != h && l != h.next) {
            Node temp = partition(l, h);
            _quickSort(l, temp.prev);
            _quickSort(temp.next, h);
        }
    }
    public void printList(Node head) {
        while(head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }
    void push(int new_Data) {
        Node new_node = new Node(new_Data);
        if(head == null) {
            head = new_node;
            return;
        }
        new_node.next = head;

        head.prev = new_node;
        new_node.prev = null;

        head = new_node;
    }
    public static void main(String[] args){
        QuickSortOnDLL list = new QuickSortOnDLL();
        list.push(5);
        list.push(20);
        list.push(4);
        list.push(3);
        list.push(30);
        System.out.println("Linked List before sorting ");
        list.printList(list.head);
        System.out.println("\nLinked List after sorting");
        list.quickSort(list.head);
        list.printList(list.head);
    }
}

// Output
// Linked List before sorting 
// 30 3 4 20 5 
// Linked List after sorting
// 3 4 5 20 30