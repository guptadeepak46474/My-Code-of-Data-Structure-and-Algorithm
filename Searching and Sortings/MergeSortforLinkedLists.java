// Merge Sort for Linked Lists

public class MergeSortforLinkedLists {
    Node head = null;
    static class Node{
        int val;
        Node next;
        Node(int val) {
            this.val = val;
            next = null;
        }
    }

    public Node mergeSort(Node head) {
        if(head == null || head.next == null)
            return head;
        Node middle = getMiddle(head);
        Node nextofMiddle = middle.next;
        middle.next = null;

        Node left = mergeSort(head);
        Node right = mergeSort(nextofMiddle);

        Node sortedlist = sortedMerge(left, right);
        return sortedlist;
    }

    public Node sortedMerge(Node a, Node b) {
        Node result = null;
        if(a == null)
            return b;
        if(b == null)
            return a;
        if(a.val <= b.val) {
            result = a;
            result.next = sortedMerge(a.next, b);
        } else {
            result = b;
            result.next = sortedMerge(a, b.next);
        }
        return result;
    }

    public static Node getMiddle(Node head) {
        if(head == null)
            return head;
        Node slow=head, fast=head;
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public void push(int new_data) {
        Node new_node = new Node(new_data);
        new_node.next = head;
        head = new_node;
    }

    public void printList(Node head) {
        while(head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
    public static void main(String[] args)
    {
 
       MergeSortforLinkedLists li = new MergeSortforLinkedLists();
        /*
         * Let us create a unsorted linked list to test the functions
         * created. The list shall be a: 2->3->20->5->10->15
         */
        li.push(15);
        li.push(10);
        li.push(5);
        li.push(20);
        li.push(3);
        li.push(2);
 
        // Apply merge Sort
        li.head = li.mergeSort(li.head);
        System.out.print("Sorted Linked List is: \n");
        li.printList(li.head);
    }
}

// Output
// Sorted Linked List is: 
// 2 3 5 10 15 20