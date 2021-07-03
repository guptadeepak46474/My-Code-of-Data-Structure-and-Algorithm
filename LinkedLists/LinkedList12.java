// Write a function that counts the number of times a given int occurs in a Linked List

public class LinkedList12 {
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
    public int count(int n) {
        int count = 0;
        Node temp = head;
        while(temp != null) {
            if(temp.data == n)
                count++;
            temp = temp.next;
        }
        return count;
    }
    public static void main(String[] args) {
        LinkedList12 llist = new LinkedList12();
 
        /* Use push() to construct below list
          1->2->1->3->1  */
        llist.push(1);
        llist.push(2);
        llist.push(1);
        llist.push(3);
        llist.push(1);
 
        /*Checking count function*/
        System.out.println("Count of 1 is " + llist.count(1));
    }
    
}