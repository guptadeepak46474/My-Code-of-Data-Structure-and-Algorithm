// Connect nodes at same level

import java.util.*;

public class BinaryTree15 {
    static class Node {
        int data;
        Node left, right, nextRight;
        Node(int d) {
            data = d;
            left = right = nextRight = null;
        }
    }
    Node root;
    void connect(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        Node temp = null;
        while(!q.isEmpty()) {
            int n = q.size();
            for(int i = 0; i < n; i++) {
                Node prev = temp;
                temp = q.poll();

                if(i > 0)
                    prev.nextRight = temp;
                if(temp.left != null)
                    q.add(temp.left);
                if(temp.right != null)
                    q.add(temp.right);
            }
            // pointing last node of the nth level to null
            temp.nextRight = null;
        }
    }
    public static void main(String args[])
    {
        BinaryTree15 tree = new BinaryTree15();
 
        /* Constructed binary tree is
             10
            /  \
          8     2
         /
        3
        */
        tree.root = new Node(10);
        tree.root.left = new Node(8);
        tree.root.right = new Node(2);
        tree.root.left.left = new Node(3);
 
        // Populates nextRight pointer in all nodes
        tree.connect(tree.root);
 
        // Let us check the values of nextRight pointers
        System.out.println("Following are populated nextRight pointers in the tree(-1 is printed if there is no nextRight)");

        int a = tree.root.nextRight != null ? tree.root.nextRight.data : -1;
        System.out.println("nextRight of " + tree.root.data + " is "+ a);

        int b = tree.root.left.nextRight != null ? tree.root.left.nextRight.data : -1;
        System.out.println("nextRight of " + tree.root.left.data + " is "+ b);

        int c = tree.root.right.nextRight != null ? tree.root.right.nextRight.data : -1;
        System.out.println("nextRight of " + tree.root.right.data + " is "+ c);

        int d = tree.root.left.left.nextRight != null ? tree.root.left.left.nextRight.data : -1;
        System.out.println("nextRight of " + tree.root.left.left.data + " is "+ d);
    }
}

// Output
// Following are populated nextRight pointers in the tree(-1 is printed if there is no nextRight)
// nextRight of 10 is -1
// nextRight of 8 is 2
// nextRight of 2 is -1
// nextRight of 3 is -1